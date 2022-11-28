<template>
  <div id="upload">
    <el-upload class="upload-demo" :action="objectData.host" :before-upload="getPolicy" :data="objectData"
      :on-preview="handlePreview"  :on-success="handleAvatarSuccess" :show-file-list="false"
      list-type="picture">
      <img v-if="hiddemDeafult" :src='imageUrl' class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>

</template>

<script>
import { uploadUserPicture } from '../../service/userServers';
import { mapGetters } from 'vuex'
import {createPublicUrl} from '../../utils/index'
export default {
  name: "upfile",
  props: ['userImage'],
  inject: ['reload'],
  //从App中传递的一个方法用来刷新页面
  data() {
    return {
      objectData: {
        OSSAccessKeyId: "",
        policy: "",
        Signature: "",
        key: "",
        host: '',
        dir: ''
      },
      imageUrl: `${createPublicUrl()}${this.userImage}`

    };
  },
  created() {

  },
  methods: {
    handlePreview(file) {
      console.log(file);
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    getPolicy(file) {
      return new Promise(((resolve, reject) => {
        uploadUserPicture(file.name)
          .then(res => {
            this.objectData.OSSAccessKeyId = res.data.data.accessid; // Bucket拥有者的AccessKey ID。
            this.objectData.policy = res.data.data.policy; //Policy规定了请求表单域的合法性。
            this.objectData.Signature = res.data.data.signature;//根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
            this.objectData.dir = res.data.data.dir;//前缀
            this.objectData.host = res.data.data.host;// "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
            this.objectData.key = res.data.data.key;//dir + fileName (上传Object的名称。)
            //将获取的oss的存储路径存放到个人信息中，准备提交到数据库
            this.getUserInfo.image = this.objectData.key
            //将修改后的图片路径放入session,实现数据的持久化
            sessionStorage.setItem('userImg',this.getUserInfo.image)
            this.$store.dispatch('userInfo/changeUserInfo', this.getUserInfo)
            this.reload()
            resolve(true);
          })
          .catch(err => {
            console.log(err);
            reject(false);
          })

      }))
    }
  },
  computed: {
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
    hiddemDeafult(){
      return this.getUserInfo.image !== ""
    }
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


