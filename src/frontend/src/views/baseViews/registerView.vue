<!--注册页面-->
<template>
  <div class="SystemUserBox">
    <div class="registerBox">
      <div class="registerFormTitle">用户注册</div>
      <el-form class="registerForm" label-width="0px" ref="dataForm" :model="dataForm" :rules="checkForm">
        <div class="formData">
          <el-form-item prop="username">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入账号" v-model.trim="dataForm.username">
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input :type="changeHiddenImg === true ? 'text' : 'password'" prefix-icon="el-icon-thumb"
              placeholder="请输入密码" v-model.trim="dataForm.password" @focus="showImg"></el-input>
            <div class="clickImg" v-show="showHiddenImg" @click="changeImg">
              <div :class="changeHiddenImg === true ? 'showImg' : 'hiddenImg'"></div>
            </div>
          </el-form-item>
          <el-form-item prop="phone">
            <el-input label-width="100px" type="text" prefix-icon="el-icon-user" placeholder="请输入手机号"
              v-model.trim="dataForm.phone"></el-input>
          </el-form-item>
          <el-form-item prop="smsCode" class="verification">
            <el-input type="text" prefix-icon="el-icon-thumb" placeholder="请输入验证码" v-model.trim="dataForm.smsCode">
            </el-input>
            <SendCodeBtn :phone="this.dataForm.phone"></SendCodeBtn>

          </el-form-item>
        </div>
        <el-form-item class="reterieveBtn">
          <el-button type="primary" @click="goToRegister" :disabled="!canRegister">注&nbsp;&nbsp;&nbsp;&nbsp;册
          </el-button>
        </el-form-item>

        <div class="userBack">
          <div class="userBack-left font-text">
            <router-link :to="{ name: 'Home' }">返回首页</router-link>
          </div>
          <div class="userBack-right font-text">
            <router-link :to="{ name: 'loginView' }">用户登录</router-link>
          </div>
        </div>

      </el-form>
    </div>
  </div>
</template>
<script>
import { userRegister } from "../../service/systemService"
import SendCodeBtn from '../../components/sendCode/sendCodeBtn'
import { CryAlgorithm } from '../../utils'  //公钥加密函数
import { mapGetters } from 'vuex'  //获取公钥的相关配置
import rules from '../../utils/rules'
export default {
  name: "registerView",
  data() {
    return {
      showHiddenImg: false,
      changeHiddenImg: false,
      dataForm: {
        username: '', //账号
        password: '', //密码
        phone: '',         //手机号
        smsCode: '',  //验证码
      },
      checkForm: {
        username: [
          { validator: rules.FormValidate.Form().validateUserName, trigger: 'blur' }
        ],
        password: [
          { validator: rules.FormValidate.Form().validatePassWord, trigger: 'blur' }
        ],
        phone: [
          { validator: rules.FormValidate.Form().validatePhone, trigger: 'blur' }
        ],
      },
    };
  },
  components: {
    SendCodeBtn
  },
  computed: {
    //判断登录条件
    canRegister() {
      const { username, password } = this.dataForm
      return Boolean(username && password)
    },
    ...mapGetters('encryption', {
      getkeyInfo: 'getkeyInfo'
    })
  },
  methods: {
    //是否自动登录
    submitLogin() {
      this.automaticLogin = !this.automaticLogin;
    },
    //注册
    goToRegister() {
      let data = {}
      data.username = this.dataForm.username
      data.password = CryAlgorithm(this.getkeyInfo.encryPtion, this.dataForm.password)
      data.phone = this.dataForm.phone
      data.smsCode = this.dataForm.smsCode
      data.uuId = this.getkeyInfo.uuId
      userRegister(data).then(res => {
        if (res.data.code === 200) {
          this.$message({
            message: "恭喜你，注册成功！请登录",
            type: "success",
          })
          this.$router.push({ name: 'loginView' })
        }
        else if (res.data.code === 201) {
          this.$message.error("用户名重复，请重新输入！");
          this.dataForm = {
            username: "",
            password: "",
            phone: "",
            smsCode: "",
          };
        }
      }
      )
    },
    showImg() {
      this.showHiddenImg = true
    },
    changeImg() {
      console.log(this.changeHiddenImg);
      this.changeHiddenImg = !this.changeHiddenImg
    }
  },
  mounted() {
    this.$store.dispatch('encryption/getPubKey');
  }
}
</script>


<style scoped lang="less">
.SystemUserBox {
  margin-top: 60px;
  position: relative;
  height: 500px;
  width: 100%;
  background: url(../../assets/Img/LoginImg/login_img.png) no-repeat 20% 50px #ddd;

  .registerBox {
    width: 450px;
    height: 400px;
    border-radius: 3px;
    position: absolute;
    right: 14%;
    top: 10%;
    background: #fff;

    .registerFormTitle {
      margin-top: 10px;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 22px;
    }

    .registerForm {
      z-index: 999;
      position: absolute;
      top: 15%;
      width: 100%;
      padding: 0 20px;

      .clickImg {
        display: flex;
        position: absolute;
        right: 60px;
        top: 50%;
        transform: translate(-50%, -50%);

        .hiddenImg {
          width: 24px;
          height: 24px;
          background: url(../../assets/Img/Icon/hidden1.png) no-repeat center center;
        }

        .showImg {
          width: 24px;
          height: 24px;
          background: url(../../assets/Img/Icon/show1.png) no-repeat center center;
        }
      }


      .verification {

        //验证码登录的输入框
        .el-input {
          width: 240px;
        }
      }

      //选择链接
      .userBack {
        display: flex;
        justify-content: space-between;
        align-content: center;

        .userBack-left {

          margin-left: 35px;

          a {
            color: #666;
          }
        }

        .userBack-right {

          margin-right: 35px;

          a {
            color: #666;
          }
        }
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

      .reterieveBtn {
        margin-bottom: 10px;
        display: flex;
        justify-content: space-between;
      }

    }
  }

  :deep .el-form-item__error {
    color: #F56C6C;
    font-size: 14px;
    padding: 3px 0;
    position: absolute;
    top: 100%;
    left: 35px;
  }
}
</style>
