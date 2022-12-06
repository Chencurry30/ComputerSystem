<template>
  <div id="upload">
    <el-upload
        class="upload-demo"
        action="https://system-1234.oss-cn-chengdu.aliyuncs.com"
        :before-upload="getPolicy"
        :data="objectData"
        :on-success="handleAvatarSuccess"
        :show-file-list="false"
        list-type="picture">
      <img v-if="getUserInfo.image !== '无'" :src='imageUrl' class="avatar" alt="">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>

</template>

<script>
import { uploadUserPicture } from '../../service/userServers';
import { mapGetters } from 'vuex'
import {createPublicUrl} from '../../utils/index'
export default {
  name: "uploadPicture",
  props: ['userImage'],
  data() {
    return {
      //上传到OSS的相关签名 
      objectData: {
        OSSAccessKeyId: "",
        policy: "",
        Signature: "",
        key: "",
        host: '',
        dir: '',
      },
      //头像的图片路径 
      imageUrl: `${createPublicUrl()}${this.userImage}`
    };
  },
  methods: {
    //上传成功后修改临时的URL,避免需要刷新 
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    //图片上传前获取后端签名上传 
    getPolicy(file) {
      //验证数字和字母
      let urlNumber = /^[a-zA-Z0-9]+$/
      let fileLength = file.name.length
      if(urlNumber.test(`${file.name.substring(0,fileLength-4)}`) === false){
        this.$message.error('上传资源的命名非法,请修改为数字或字母')
      }else{
        return new Promise(((resolve, reject) => {
          uploadUserPicture(file.name).then(res => {
              console.log(res)
              this.objectData.OSSAccessKeyId = res.data.data.accessid; // Bucket拥有者的AccessKey ID。
              this.objectData.policy = res.data.data.policy; //Policy规定了请求表单域的合法性。
              this.objectData.Signature = res.data.data.signature;//根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
              this.objectData.dir = res.data.data.dir;//前缀
              this.objectData.host = res.data.data.host;// "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
              this.objectData.key = res.data.data.key;//dir + fileName (上传Object的名称。)
              //将获取的oss的存储路径存放到个人信息中，准备提交到数据库
              this.getUserInfo.image = this.objectData.key
              //将修改后的图片路径放入session,实现数据的持久化
              // sessionStorage.setItem('userImg',this.objectData.key)
              this.$store.dispatch('userInfo/changeUserInfo', this.getUserInfo)
              resolve(true);
            })
            .catch(err => {
              console.log(err)
              reject(false)
            })

        }))
      }


    }
  },
  computed:{
    //从Vuex中获取用户的相关信息 
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
  },

  watch:{
    userImage(newvalue){
      this.imageUrl = `${createPublicUrl()}${newvalue}`
    }
  }
}

</script>


<style scoped lang="less">
#upload {
  position: relative;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  overflow: hidden;
  cursor: pointer;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  position: absolute;
  top: 32px;
  left: 32px;
  font-size: 36px;
  color: #8c939d;
  text-align: center;
}

.avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  display: block;
}
</style>



