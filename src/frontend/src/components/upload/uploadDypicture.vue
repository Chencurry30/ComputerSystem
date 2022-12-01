<template>
  <div>
    <el-upload
        class="upload-demo"
        :action="objectData.host"
        :before-upload="getPolicy"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-success="handleAvatarSuccess"
        :file-list="fileList"
        :data="objectData"
        :show-file-list="true">
      <el-button size="small" type="primary">上传照片</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      <img :src='imageUrl' v-if="objectData.key">
    </el-upload>
  </div>
</template>

<script>
import {uploaddynamicPicture} from "@/service/userServers";
import {createPublicUrl} from "@/utils";

export default {
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
      fileList: [],
      imageUrl: ''
    };
  },
  methods: {
    getPolicy(file) {
      console.log(file)
      return new Promise(((resolve, reject) => {
        uploaddynamicPicture(file.name)
            .then(res => {
              console.log(res)
              this.objectData.OSSAccessKeyId = res.data.data.accessid; // Bucket拥有者的AccessKey ID。
              this.objectData.policy = res.data.data.policy; //Policy规定了请求表单域的合法性。
              this.objectData.Signature = res.data.data.signature;//根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
              this.objectData.dir = res.data.data.dir;//前缀
              this.objectData.host = res.data.data.host;// "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
              this.objectData.key = res.data.data.key;//dir + fileName (上传Object的名称。)
              this.$parent.contents.picture = res.data.data.key
              console.log(this.$parent.contents.picture)
              resolve(true);
            })
            .catch(err => {
              console.log(err);
              reject(false);
            })

      }))
    },
    handleRemove(file, fileList) {
      // console.log(file, fileList);
    },
    handlePreview(file) {
      // console.log(file);
    },
    handleAvatarSuccess(response, file, fileList){
      this.imageUrl = URL.createObjectURL(file.raw);
    }
  }
}
</script>

<style scoped lang='less'>
.upload-demo{
  img{
    width: 200px;
    height: 200px;
  }
}
.upload-demo{
  margin: 10px 0 0 10px;
}
</style>
