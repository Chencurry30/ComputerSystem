<template>
  <div class="uploadBox">
    <div class="upload">
      <el-upload
          class="upload-video"
          drag
          :auto-upload="false"
          :limit="1"
          action=""
          :file-list="fileList"
          :on-change="ChangeFile"
          :on-exceed="beyondFileNumber"
          multiple>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将视屏或视屏图片拖到此处，或<em>点击上传</em></div>
      </el-upload>
      <el-button @click="doUpload">上传视屏</el-button>
    </div>
    <div class="uploadProcess"></div>
    <el-progress :text-inside="true" :stroke-width="18"

                 :percentage="progress" v-if="progress !== 0" >
    </el-progress>

  </div>
</template>

<script>
import axios from 'axios'
const OSS = require('ali-oss')
let  ossClient

export default {
  name: "uploadVideo",
  data() {
    return {
      //当videoType为0表示上传的视屏,为1表示上传的是视屏图片
      videoType:-1,
      fileList:[],
      ossConfig: {},
      urlLink:'',
      progress:0
    }
  },
  methods: {
    async doUpload() {
      console.log(this.fileList);
      //判断当前上传的文件里面是否有文件存在
      if (this.fileList.length === 0) {
        this.$message.error('请选择上传的文件')
        return
      }

      if (ossClient === undefined){
        let ossConfig
        await this.getStsToken().then(res => {
          console.log(res);
          if (res.status === 200) {
            let data = res.data.data
            ossConfig = {
              region: data.region,
              accessKeyId: data.accessKeyId,
              accessKeySecret: data.accessKeySecret,
              stsToken: data.stsToken,
              bucket: data.bucket
            }
            console.log(ossConfig);
          } else {
            alert('sts token get failed')
          }
        })
        ossClient = new OSS(ossConfig)
      }

      await this.doMultipartUpload()
    },
    //上传文件时,将文件放入列表的第一个元素
    ChangeFile(file) {
      this.fileList[0] = file
    },
    //限制文件上传时的个数(只能为1个)
    beyondFileNumber(){
      this.$message.error('一次只能上传一个文件,请先把文件上传或者在文件列表中删除后再添加')
    },
    getStsToken() {
      return axios({
        method: 'get',
        url: 'http://localhost:8989/api/oss/sts'
      })
    },
    //这个是分片上传的数据
    async doMultipartUpload() {
      let that = this
      let key
      try{
        let file = this.fileList[0].raw
        console.log(123,file)
        if(file.type === 'image/png' || file.type === 'image/jpg'){
          this.videoType = 0
          key = '/test/userUploadVideoImg/' + file.name
        }
          key = '/test/userUploadVideoData/' + file.name


        let result = await ossClient.multipartUpload(key, file, {
          progress: function (p) {

           //打印上传百分比(其中的p表示分片上传的百分比)
            that.progress = p*100
          },
          partsSize: 1000 * 1024 * 1024
        })

        console.log(result)
        //清空文件列表
        this.$message.error('上传成功')
        this.fileList = []
        this.progress = 0
        console.log(this.$parent)
      } catch (e) {
        console.log(e)
      }
    },
  },
}
</script>

<style scoped lang="less">
.upload{
  margin: 5px auto;
  //display: flex;
  //width: 400px;
  // height: 300px;
  .upload-video{
    display: flex;
    flex-direction: column;
  }
}
</style>

