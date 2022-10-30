<template>
  <div>
    <vue-particles color="#e8f659" :particleOpacity="0.7" :particlesNumber="60" shapeType="circle" :particleSize="6"
      linesColor="#e8f659" :linesWidth="1" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="3"
      :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push">
    </vue-particles>
    <div class="login_container">
      <div class="login_box">

        <div class="avatar_box">
          <img src="../../assets/Img/LoginImg/tx.jpg" alt="" />
        </div>

        <el-form label-width="0px" class="login_in"  ref="dataForm" :model="dataForm" :rules="checkForm">

          <div class="form-info">
            <el-form-item prop="username">
              <el-input
                type="text"
                prefix-icon="el-icon-user"
                placeholder="请输入账号"
                v-model.trim="dataForm.username">
              </el-input>
            </el-form-item>


            <el-form-item prop="password">
              <el-input
                :type="changeHiddenImg === true ? 'text':'password'"
                prefix-icon="el-icon-thumb"
                placeholder="请输入密码"
                v-model.trim="dataForm.password"
                @focus="showImg"
              ></el-input>
              <div class="clickImg" v-show="showHiddenImg" @click="changeImg">
                <div :class="changeHiddenImg === true ? 'showImg':'hiddenImg'"></div>
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
              <div class="prompt" @click="gotoretrieve">忘记密码</div>
            </div>
          </div>

          <el-form-item class="btns">
            <el-button type="primary" @click="goToLogin" :disabled="!canSubmit">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
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
import Cookies from 'js-cookie';
import { userLogin } from '../../Servers/ServersApi';
import {CryAlgorithm} from '../../utils'  //公钥加密函数
import {mapGetters} from 'vuex'  //获取公钥的相关配置
import rules from '../../utils/rules'

export default {
  name: "loginView",
  data() {
    return {
      automaticLogin: false, //自动登录
      showHiddenImg:false,
      changeHiddenImg:false,
      dataForm: {
        username: '', //账号
        password: '', //密码
      },
      checkForm:{
        //用户名校验
        username:[
          {validator: rules.FormValidate.Form().validateUserName,trigger:'blur'}
        ],
        //密码校验
        password:[
          {validator: rules.FormValidate.Form().validatePassWord,trigger:'blur'}
        ],
      },
    };
  },
  mounted(){
    this.$store.dispatch('encryption/getPubKey');
  },
  computed: {
    //判断提交
    canSubmit() {
      const { username, password } = this.dataForm
      return Boolean(username && password)
    },
    //获取公钥的ID以及公钥的内容
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
      let location = { name: "mainHome" };
      this.$router.push(location);
    },
    //登录
    goToLogin() {
      let data = {}
      data.uuId = this.getkeyInfo.uuId
      data.username = this.dataForm.username
      data.password = this.dataForm.password
      // data.password = CryAlgorithm(this.getkeyInfo.encryPtion,this.dataForm.password)
      userLogin(data).then(res => {
        console.log(res);
        Cookies.set('name', this.dataForm.username)
        const name = data.username
        if (res.data.code === 200) {
        const token = res.data.data.token
        // localStorage.setItem('username',res.data.data.user.nickname)
        localStorage.setItem('token', token)  //保存token到本地浏览器
          this.$message({
            message: "恭喜你，登录成功！欢迎用户: " + name,
            type: "success",
          })
          this.$router.push({ name: 'Home' })
        }else if (res.data.code === 400) {
          this.$message.error("用户名或密码错误，请重新输入！")
        }
      })

    },
    //忘记密码
    gotoretrieve(){
      let location = { name: "mainHome" };
      this.$router.push(location);
    },
    //获取焦点时显示图片
    showImg(){
      this.showHiddenImg = true
    },
    //修改可以查看密码的图片样式
    changeImg(){
      this.changeHiddenImg = !this.changeHiddenImg
    }
  },
};
</script>

<style scoped lang="less">
#particles-js {
  width: 100%;
  height: calc(100%);
  position: absolute;
  background-image: url("../../assets/Img/LoginImg/background.png");
  background-repeat: no-repeat;
  background-size: cover;
}
.login_container {
  z-index: 55;
  background-color: #42b983;
  height: 100%;
}
.el-form-item {
  margin-bottom: 20px;
}
.login_box {
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
    bottom: -15px;
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
  .el-button {
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
      background: url(../../assets/Img/Icon/hidden1.png) no-repeat center center;
    }
    .showImg{
      width: 24px;
      height: 24px;
      background: url(../../assets/Img/Icon/show1.png) no-repeat center center;
    }
}
</style>
