<template>
  <div>
    <vue-particles
      color="#e8f659"
      :particleOpacity="0.7"
      :particlesNumber="60"
      shapeType="circle"
      :particleSize="6"
      linesColor="#e8f659"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="3"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    >
    </vue-particles>
    <div class="register_container">
      <div class="register_box">

        <div class="avatar_box">
          <img src="../assets/Img/LoginImg/tx.jpg" alt="" />
        </div>

        <el-form label-width="0px" class="register_in" ref="dataForm" :model="dataForm" :rules="checkForm">

          <div class="form-info">
            <el-form-item prop="username">
              <el-input
                type="text"
                prefix-icon="el-icon-user"
                placeholder="请输入账号"
                v-model="dataForm.username"
              ></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                :type="changeHiddenImg === true ? 'text':'password'"
                prefix-icon="el-icon-thumb"
                placeholder="请输入密码"
                v-model="dataForm.password"
                @focus="showImg"
              ></el-input>
              <div class="clickImg" v-show="showHiddenImg" @click="changeImg">
                <div :class="changeHiddenImg === true ? 'showImg':'hiddenImg'"></div>
              </div>
            </el-form-item> 




            <el-form-item prop="phone">
              <el-input
                label-width="100px"
                type="text"
                prefix-icon="el-icon-user"
                placeholder="请输入手机号"
                v-model="dataForm.phone"
              ></el-input>
            </el-form-item>
            <el-form-item prop="smsCode" class="verification">
              <el-input
                type="password"
                prefix-icon="el-icon-thumb"
                placeholder="请输入验证码"
                v-model="dataForm.smsCode"
              ></el-input>
              <SendCodeBtn :phone="this.dataForm.phone"></SendCodeBtn>

            </el-form-item>
          </div>
          <el-form-item class="btns">
            <el-button type="primary" @click="goToRegister" :disabled="!canRegister">注&nbsp;&nbsp;&nbsp;&nbsp;册</el-button>
          </el-form-item>

          <div class="stytem">
            <div class="stytem-left font-text">
              <div class="lefttitle" @click="backHome()">返回首页</div>
            </div>
            <div class="stytem-right font-text">
              <div class="righttitle">
                <router-link :to="{ name: 'loginView' }">用户登录</router-link>
              </div>
            </div>
          </div>

        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
import { userRegister } from "@/Servers/ServersApi"
import SendCodeBtn from '../components/sendCodeBtn'
import {CryAlgorithm} from '../encryption/index'  //公钥加密函数
import {mapGetters} from 'vuex'  //获取公钥的相关配置
import rules from '../encryption/rules'
export default {
  name: "registerView",
  data() {
    return {
      showHiddenImg:false,
      changeHiddenImg:false,
      dataForm:{  
        username: '', //账号
        password: '', //密码
        phone:'',         //手机号
        smsCode:'',  //验证码  
      },
      checkForm:{
        username:[
          {validator: rules.FormValidate.Form().validateUserName,trigger:'blur'}
        ],
        password:[
          {validator: rules.FormValidate.Form().validatePassWord,trigger:'blur'}
        ],
        phone:[
          {validator: rules.FormValidate.Form().validatePhone,trigger:'blur'}
        ],
        smsCode:[
          {validator: rules.FormValidate.Form().validateCode,trigger:'blur'}
        ]
      },
    };
  },
  components:{
    SendCodeBtn
  },
  computed:{
    //判断登录条件
    canRegister(){
      const { username,password } = this.dataForm
      return Boolean(username&&password)
    },
    ...mapGetters('encryption',{
      getkeyInfo:'getkeyInfo'
    })
  },
  methods: {
    //是否自动登录
    submitLogin() {
      this.automaticLogin = !this.automaticLogin;
    },
    //返回首页
    backHome() {
      let location = { name: "Home" };
      this.$router.push(location);
    },
    //注册
    goToRegister() {
      let data = {}
      data.username = this.dataForm.username
      data.password = CryAlgorithm(this.getkeyInfo.encryPtion,this.dataForm.password)
      data.phone = this.dataForm.phone     
      data.smsCode = this.dataForm.smsCode
      data.uuId = this.getkeyInfo.uuId
      userRegister(data).then( res => {
          if(res.data.code===200){
            this.$message({
              message: "恭喜你，注册成功！请登录",
              type: "success",
            })
            this.$router.push({name:'loginView'})
          }
          else if (res.data.code === 201) {
            this.$message.error("用户名重复，请重新输入！");
            this.dataForm = {
              username: "",
              password: "",
              phone:"",
              smsCode:"",
            };
          }
        }
      )
    },
    showImg(){
      this.showHiddenImg = true
    },
    changeImg(){
      console.log(this.changeHiddenImg);
      this.changeHiddenImg = !this.changeHiddenImg
    }
  },
  mounted(){
    this.$store.dispatch('encryption/getPubKey');
  }
}
</script>


<style scoped lang="less">
  #particles-js {
    width: 100%;
    height: calc(100%);
    position: absolute;
    background-image: url("../assets/Img/LoginImg/background.png");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .register_container {
    height: 100%;
  }
  .el-form-item {
    margin-bottom: 20px;
  }
  .register_box {
    width: 450px;
    height: 300px;
    position: absolute;
    left: 50%;
    top: 45%;
    transform: translate(-50%, -50%);
    .avatar_box {
      height: 130px;
      width: 130px;
      border: 1px solid #eee;
      border-radius: 50%;
      box-shadow: 0 0 10px #ddd;
      position: absolute;
      left: 50%;
      transform: translate(-50%, -50%);
      background-color: #fff;
      padding: 10px;
      img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eee;
      }
    }
  }
  .btns {
    display: flex;
    justify-content: space-between;
  }
  .register_in{
    z-index: 999;
    position: absolute;
    bottom: -100px;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
    .verification {
      //验证码登录的输入框
      .el-input {
        width: 240px;
      }

    }
    //选择链接 
    .stytem {
      display: flex;
      justify-content: space-between;
      align-content: center;
      .stytem-left {
        .lefttitle {
          margin-left: 35px;
        }
      }
      .stytem-right {
        .righttitle {
          margin-right: 35px;
        }
      }
      .righttitle:hover {
        color: rgb(236, 60, 11);
        cursor: pointer;
      }
      .lefttitle:hover {
        color: rgb(236, 60, 11);
        cursor: pointer;
      }
    }
    //修改了button的形式 
    .el-button{
      padding: 12px 110px;
    }
    //修改输入框大小 
    .el-input {
      left: 7%;
      width: 360px;
    }
  }
  /deep/.el-form-item__error{
      color: #F56C6C;
      font-size: 14px;
      padding: 3px 0px;
      position: absolute;
      top: 100%;
      left: 35px;
  }
  .clickImg{
    display: flex;
    position: absolute;
    right: 60px;
    top: 50%;
    transform: translate(-50%, -50%);
    .hiddenImg{
      width: 24px;
      height: 24px;
      background: url(../assets/Img/Icon/hidden1.png) no-repeat center center;
    }
    .showImg{
      width: 24px;
      height: 24px;
      background: url(../assets/Img/Icon/show1.png) no-repeat center center;
    }
  }
</style>