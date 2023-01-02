<!--上传题目图片的相关弹窗-->
<template>
  <el-upload
    class="upload-demo"
    :action="objectData.host" 
    :before-upload="getPolicy" 
    :data="objectData"
    :show-file-list="false"
    list-type="picture"
    >
    <el-button size="small" type="primary">点击上传</el-button>
  </el-upload>
  </template>
  
  <script>
  import {uploadQuestionPicture} from '../../services/questionManage'
  export default {
    data() {
      return {
        // totleUrl: '',
        objectData: {
          OSSAccessKeyId: "",
          policy: "",
          Signature: "",
          key: "",
          host: '',
          dir: ''
        },
      };
    },
    methods: {
      //上传图片的功能(file,location)分别为文件名和传入的存储路径
      getPolicy(file){
        let location = this.returnImgLocation
        let fileName = file.name;
        console.log(location);
        console.log(this.$parent.prop);
        console.log(this.$parent.$parent.$parent.$parent.ruleForm);
        return new Promise(((resolve, reject) => {
          uploadQuestionPicture({fileName,location})
            .then(res => {
              console.log(res);
              this.objectData.OSSAccessKeyId = res.data.data.accessid; // Bucket拥有者的AccessKey ID。
              this.objectData.policy = res.data.data.policy; //Policy规定了请求表单域的合法性。
              this.objectData.Signature = res.data.data.signature;//根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
              this.objectData.dir = res.data.data.dir;//前缀
              this.objectData.host = res.data.data.host;// "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
              this.objectData.key = res.data.data.key;//dir + fileName (上传Object的名称。)
              console.log(this.$parent.$parent.$parent);
              if(this.$parent.prop === 'answerImage'){
                console.log(this.$parent.$parent.$parent);
                this.$parent.$parent.$parent.$parent.ruleForm.answerImage = res.data.data.key
              }else if(this.$parent.prop === 'enclosureImage'){
                this.$parent.$parent.$parent.$parent.ruleForm.enclosureImage = res.data.data.key
              }else if(this.$parent.prop === 'solutionImage'){
                this.$parent.$parent.$parent.$parent.ruleForm.solutionImage = res.data.data.key
              }else if(this.$parent.prop === 'titleImage'){
                this.$parent.$parent.$parent.$parent.ruleForm.titleImage = res.data.data.key
              }else{
                let count = this.$parent.label.substring(0,1);
                console.log(this.$parent.$parent.$parent.ruleForm.questionChoiceList[count-1]);
                this.$parent.$parent.$parent.ruleForm.questionChoiceList[count-1].titleImage = res.data.data.key
              }
              console.log(this.objectData);
              resolve(true);
            })
            .catch(err => {
              console.log(err);
              reject(false);
            })
  
        }))
      },
  
  
    },
    computed:{
      //判断图片在OSS上的存储路径 
      returnImgLocation(){
        //答案的图片 
        if (this.$parent.prop === 'answerImage') {
          //将获取到的文件上传到OSS，且传入相应的路径 
          return 'answer'
        //题目中出现的图片(如右侧的图片) 
        }else if(this.$parent.prop === 'enclosureImage'){
          return  'enclosure'
        //解答的图片 
        }else if(this.$parent.prop === 'solutionImage'){
          return 'solution'
        //题目的图片(如题目有特殊符号) 
        }else if(this.$parent.prop === 'titleImage'){
          return 'title'
        }else{
          return 'options'
        }
      }
    }
  }
  </script>
  
  <style scoped lang="less">
  .upload-demo{
    margin-left: 10px;
  }
  .el-button--small {
      padding: 12px 15px;
      font-size: 12px;
      border-radius: 3px;
  }
  </style>