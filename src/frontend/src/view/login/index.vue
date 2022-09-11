<template>
    <div class="login-container">
      <LoginForm :model.sync="loginForm" :rules="loginRules" @submitBtnClick="handleLogin()" class="loginForm"></LoginForm>
    </div>
  </template>
  
  <script>
    import  LoginForm from '@/components/loginForm'
  
    export default {
      name:'login',  
      data() {
        /*密码校验规则*/
        const validatePassword = (rule, value, callback) => {
          if (value.length < 6) {
            callback(new Error('The password can not be less than 6 digits'))
          } else {
            callback()
          }
        }
        return {
          loginForm: {
            username: 'admin',
            password: ''
          },
          loginRules: {
            password: [{ required: true, trigger: 'blur', validator: validatePassword }]
          },
        }
      },
  
      methods: {
        handleLogin() {
  
        }
  
  
      },
      components:{
        LoginForm
      }
    }
  </script>
  
  
  
  <style lang="scss" scoped>

    .title {
      margin-top: 70px;
    }
    .login-container {
      height: 100%;
      width: 100%;
      overflow: hidden;
      background: url('../../img/login/test5.png') no-repeat;
      background-size:100% 100%;
    }
  
    .loginForm {
  
      float: right;
      margin: 240px 300px 0 0;
    }
  </style>
  
  
  
  