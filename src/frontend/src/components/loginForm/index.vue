<template>
    <el-form ref="loginForm" :model="model" :rules="rules" class="login-form">
      <!--登陆标题-->
      <div class="title-container">
        <h3 class="title">平 台 登 录</h3>
      </div>
      <!--用户名输入框-->
      <el-form-item>
          <span class="svg-container">
            <svg-icon icon-class="user" />
          </span>
        <el-input
          ref="username"
          v-model="model.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>
      <!--密码输入框-->
      <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="model.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
            <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>
      <!--登录按钮-->
      <el-button :loading="loading" type="primary" @click.native.prevent="subBtn()"  plain  round>登录</el-button><!---->
  
      <el-link type="info">忘记密码</el-link>
  
    </el-form>
  </template>
  
  <script>
      export default {
        name: "LoginForm",
        props:{
          "rules": {
            type: Object,
            default: ()=>{return {}}
          },
          "model": {
            type: Object,
            required: true,
          }
        },
        data() {
  
          return {
            loading: false,
            passwordType: 'password',
            redirect: undefined
          }
        },
        methods:{
          showPwd() {
            if (this.passwordType === 'password') {
              this.passwordType = ''
            } else {
              this.passwordType = 'password'
            }
            this.$nextTick(() => {
              this.$refs.password.focus()
            })
          },
          subBtn(){
            /*如果密码格式正确，则进行登录*/
            this.$refs.loginForm.validate(valid => {
              if (valid){
                this.$emit('submitBtnClick')
              }  else {
                console.log('error submit!!')
                return false
              }
            })
          },
          handleLogin(){
            this.$emit('submitBtnClick')
          }
        }
      }
  
  </script>
  
  <style lang="scss">
  
    /* 修复input 背景不协调 和光标变色 */
    /* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */
  
  
  
    $cursor: #fff;
  
    @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
      .login-container .el-input input {
        color: $cursor;
      }
    }
  
    /* reset element-ui css */
    .login-container {
      .el-input {
        display: inline-block;
        height: 47px;
        width: 85%;
  
        input {
          background: transparent;
          border: 0px;
          -webkit-appearance: none;
          -webkit-transition: background-color 43200s ease-in-out 0s;
          border-radius: 0px;
          padding: 12px 5px 12px 15px;
          color: white;
          height: 35px;
          caret-color: $cursor;
  
          &:-webkit-autofill {
            color: #FFF !important;
            -webkit-text-fill-color: #FFF;
            -webkit-transition: background-color 43200s ease-in-out 0s;
            transition: background-color 43200s ease-in-out 0s;
            &:hover,&:focus {
              color: #FFF !important;
              -webkit-text-fill-color: #FFF;
              -webkit-transition: background-color 43200s ease-in-out 0s;
              transition: background-color 43200s ease-in-out 0s;
            }
          }
  
  
        }
      }
  
  
    }
  </style>
  <style lang="scss" scoped>
    .login-form {
      position: relative;
      width: 350px;
      max-width: 100%;
      padding: 140px 0px 80px;
      overflow: hidden;
      border: 2px solid #06c;
      /*登录框透明背景颜色*/
      background-color: rgba(130,187,232,0.1);
  
      /*边框荧光*/
      -moz-box-shadow:4px -4px 50px #57E7F4;
      -webkit-box-shadow:4px -2px 50px #57E7F4;
      box-shadow:4px -4px 50px #57E7F4;
  
      .el-form-item{
        border-top: 1px solid #57E7F4;
        height: 45px;
        margin:0;
        /*登录密码框前面的图标背景*/
        .svg-container {
          padding: 6px 5px 6px 15px;
          color: white;
          vertical-align: middle;
          width: 30px;
          display: inline-block;
        }
        /*显示密码背景颜色*/
        .show-pwd {
          position: absolute;
          right: 10px;
          top: 7px;
          font-size: 16px;
          color: white;
          cursor: pointer;
          user-select: none;
        }
  
      }
      .el-form-item:nth-child(3){
        border-bottom: 1px solid #57E7F4;
      }
      .title-container {
        position: relative;
        margin-bottom:20px;
  
        /*标题颜色*/
        .title {
          font-size: 26px;
          color: white;
          margin: 0px 30px 40px 30px;
          text-align: center;
          font-weight: bold;
          display: inline-block;
        }
      }
      .el-button{
        width: 130px;
        height: 40px;
        font-size:1em;
        font-weight: bold;
        background-color: #293140;
        border: 3px #3bb6f4 solid;
        margin-left: 35px;
        margin-top: 50px;
        color: #3bb6f4;
      }
      .el-button:hover{
        background-color: #156cd2;
        color: #fff;
      }
      .el-link{
        float:right;
        margin-top:70px ;
        margin-right: 40px;
      }
    }
  </style>
  
  