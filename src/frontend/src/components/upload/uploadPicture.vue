<template>
  <div id="upload" class="uploadBox">
    <el-upload class="upload-demo" :action="objectData.host" :before-upload="getPolicy" :data="objectData"
      :on-preview="handlePreview" :on-remove="handleRemove"  list-type="picture">
      <img :src='[publicUrl+imageUrl]' class="avatar">
      <i  class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>

</template>

<script>
import { uploadUserPicture} from '../../service/userServers'
import {mapState} from 'vuex'
import {createPublicUrl} from '../../utils/index'
export default {
  props:['userImage'],
  name: "uploadPicture",
  data() {
    return {
      fileList: {},
      objectData: {
        OSSAccessKeyId: "",
        policy: "",
        Signature: "",
        key: "",
        host: '',
        dir: ''
      },
      imageUrl: this.userImage,
    };
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    getPolicy(file) {
      let picture = file.name
      console.log(picture);
      uploadUserPicture(picture).then((res) => {

        this.objectData.OSSAccessKeyId = res.data.data.accessid; // Bucket拥有者的AccessKey ID。
        this.objectData.policy = res.data.data.policy; //Policy规定了请求表单域的合法性。
        this.objectData.Signature = res.data.data.signature;//根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
        this.objectData.dir = res.data.data.dir;//前缀
        this.objectData.host = res.data.data.host;// "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
        // this.objectData.key = res.data.dir + "${filename}";
        this.objectData.key = res.data.data.key;//dir + fileName (上传Object的名称。)
        // this.fileList = { name: res.data.data.key, url: res.data.data.host + "/" + res.data.data.key }
        console.log(res);
        console.log(this.objectData);
        this.userInfo.image = res.data.data.key
        this.$store.dispatch('userInfo/changeUserInfo',this.userInfo)
        
      })
     

    }
  },
  computed:{
    ...mapState('userInfo',{
    userInfo:'userInfo'
  }),
  //获取公共的URL函数 
  publicUrl(){
    return createPublicUrl();
  }
  },
  watch:{
    userImage(newData) {
      console.log(this.userImage);
      console.log(newData);
      this.imageUrl = newData
    }
  }
}

</script>

<style scoped lang="less">
.uploadBox {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 36px;
  color: #8c939d;
  text-align: center;
}
</style>
