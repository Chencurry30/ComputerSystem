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

        <!-- <el-form label-width="0px" class="login_in" @keyup.enter.native="goToLogin"> -->
        <el-form label-width="0px" class="login_in" @keyup.enter="goToLogin">
          <div class="navSelect">
            <div class="select-left">
              <div class="left-btn" @click="selectRegisterWay">账号登录</div>
              <div class="btn-selected" v-show="!selectWay"></div>
            </div>
            <div class="select-right">
              <div class="right-btn" @click="selectRegisterWay">手机登录</div>
              <div class="btn-selected" v-show="selectWay"></div>
            </div>
          </div>

          <div class="form-info" v-show="!selectWay" ref="dataForm">
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
                type="password"
                prefix-icon="el-icon-thumb"
                placeholder="请输入密码"
                v-model="dataForm.password"
              ></el-input>
            </el-form-item>
          </div>
          <div class="form-info" v-show="selectWay" ref="dataForm">
            <el-form-item prop="account">
              <el-input
                type="text"
                prefix-icon="el-icon-user"
                placeholder="请输入手机号"
                v-model="dataForm.phone"
              ></el-input>
            </el-form-item>
            <el-form-item prop="verificationCode" class="verification">
              <el-input
                type="password"
                prefix-icon="el-icon-thumb"
                placeholder="请输入验证码"
                v-model="dataForm.verificateCode"
              ></el-input>
              <div class="getVerificationCode" @click="getVerCode">
                {{ verificationCodeInfo }}
              </div>
            </el-form-item>
          </div>

          <div class="tablenav">
            <div class="navleft">
              <div class="leftbtn">
                <div :class="automaticLogin === false ? 'dashDiv' : 'dashDivSelectd'">
                  <span class="dashSpan" @click="submitLogin"></span>
                </div>
                <div class="prompt">自动登录</div>
              </div>
            </div>
            <div class="navright">
              <div class="prompt">忘记密码</div>
            </div>
          </div>

          <el-form-item class="btns">
            <el-button type="primary" @click="goToLogin" :disabled="!canSubmit">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
            <!-- <el-button type="primary">注册</el-button> -->
          </el-form-item>

          <div class="stytem">
            <div class="stytem-left">
              <div class="lefttitle" @click="backHome()">返回首页</div>
            </div>
            <div class="stytem-right">
              <div class="righttitle">
                <router-link :to="{ name: 'registerView' }">用户注册</router-link>
              </div>
            </div>
          </div>

        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { userLogin } from "@/Servers/ServersApi";
export default {
  name: "loginView",
  data() {
    return {
      automaticLogin: false, //自动登录
      sendTimeCode:5,      //再次发送的时间
      bVerification:false,   //节流阀，控制点击获取验证码
      verificationCodeInfo:"发送验证码",
      selectWay: false, //注册的方式  false 表示账号密码注册  TRUE 表示手机注册
      dataForm:{  
        username: '', //账号
        password: '', //密码
        phone:'',         //手机号
        verificateCode:'',  //验证码  
      },
    };
  },
  computed:{
    //判断提交
    canSubmit(){
      const { username,password } = this.dataForm
      return Boolean(username&&password)
    }
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
    //选择登录的方式
    selectRegisterWay() {
      this.selectWay = !this.selectWay;
    },
    //发送验证码的按钮
    getVerCode(){
      if(this.bVerification === true){
        return;
      }
      this.bVerification = true;       //关闭节流阀
      let time = setInterval(()=>{
        this.sendTimeCode -= 1
        this.verificationCodeInfo = `剩余${this.sendTimeCode}秒后发送`
        if(this.sendTimeCode <=0){
          this.verificationCodeInfo = '发送验证码'
          this.sendTimeCode = 5   //对应的间隔时间
          clearInterval(time)
           this.bVerification = false  //打开节流阀
        }
      },1000)
    },
    //登录 
    goToLogin() {
      let data = this.dataForm
      // console.log(data);
      userLogin(data).then( res => {
          console.log(res.data);
          const name = data.username
          const token = res.data.data.token
          localStorage.setItem('token',token)  //保存token到本地浏览器
          if(res.data.code===200){
            this.$message({
              message: "恭喜你，登录成功！欢迎用户: " + name,
              type: "success",
            })
            this.$router.push({name:'Home'})
          }
          if(res.data.message==='用户名不存在'){
            this.$message({
              message: "该用户名不存在，请注册你的账号！",
              type: "warning",
            })
          }
          if(res.data.message==='密码错误'){
            this.$message({
              message: "密码错误，请重新输入密码",
              type: "error",
            })
          }
        })
          

    },
  },
};
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
    z-index: 55;
    background-color: #42b983;
    height: 100%;
  }
  .el-form-item {
    margin-bottom: 14px;
    margin-top: 10px;
  }
  .register_box {
    width: 450px;
    height: 300px;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
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
  .login_in {
    z-index: 999;
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
    //选择方式
    .navSelect {    
      display: flex;
      justify-content: space-between;
      color: #ffffff;
      font-size: 18px;
      font-family: "楷体";
      .select-left {
        position: relative;
        margin-left: 50px;
        cursor: pointer;
        .btn-selected {
          position: absolute;
          width: 60px;
          height: 2px;
          bottom: -1px;
          left: 9px;
          background-color: #ffffff;
        }
      }
      .select-right {
        position: relative;
        margin-right: 50px;
        cursor: pointer;
        .btn-selected {
          position: absolute;
          width: 60px;
          height: 2px;
          bottom: -1px;
          right: 9px;
          background-color: #ffffff;
        }
      }
    }
    .verification {
      //验证码登录的输入框
      .el-input {
        width: 240px;
      }
      .getVerificationCode {
        position: absolute;
        width: 100px;
        height: 40px;
        top: 0px;
        right: 20px;
        border-radius: 4px;
        text-align: center;
        cursor: pointer;
        color: #ffffff;
        background-color: #409eff;
      }
    }
    .tablenav {
      display: flex;
      justify-content: space-between;
      font-family: "楷体";
      .navleft {
        margin-left: 30px;
        .leftbtn {
          display: flex;
          //未选中状态
          .dashDiv {
            border-radius: 1.8667rem;
            border: 0.03rem solid #cbcbcb;
            background-color: #dad6d6;
            width: 42px;
            height: 16px;
            margin-top: 0.26rem;
            margin-right: 0.4rem;
            box-sizing: border-box;
          }
          .dashDiv .dashSpan {
            border-radius: 7px;
            border: 0.03rem solid #cbcbcb;
            background-color: #ffffff;
            float: left;
            margin-left: 0.04rem;
            margin-top: 0.019rem;
            width: 24px;
            height: 14px;
            box-sizing: border-box;
          }
          /*选中状态*/
          .dashDivSelectd {
            background-color: #4cd964;
            transition: 0.5s;
            border-radius: 1.8667rem;
            border: 0.03rem solid #ffffff;
            width: 42px;
            height: 16px;
            margin-top: 0.26rem;
            margin-right: 0.4rem;
            box-sizing: border-box;
          }
          .dashDivSelectd .dashSpan {
            border-radius: 7px;
            border: 0.03rem solid #ffffff;
            background-color: #ffffff;
            float: right;
            margin-right: 0.04rem;
            margin-top: 0.019rem;
            width: 24px;
            height: 14px;
            box-sizing: border-box;
          }
        }
      }
      .navright {
        margin-right: 30px;
      }
      .prompt {
        margin-top: 1px;
        color: #ffffff;
        font-size: 18px;
        font-family: 楷体;
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
          font-size: 14px;
          color: #ffffff;
        }
      }
      .stytem-right {
        .righttitle {
          margin-right: 35px;
          font-size: 14px;
          color: #ffffff;
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
    .prompt:hover {
      color: rgb(236, 60, 11);
      cursor: pointer;
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
</style>