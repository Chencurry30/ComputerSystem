//找回密码的页面 
<template>
  <div class="SystemBgBox">
    <div class="SystemMain">
      <div class="SystemFormTitle">找回密码</div>
      <el-form class="SystemForm" label-width="0px" ref="dataForm" :model="dataForm" :rules="checkForm">


        <div class="SystemFormData">
          <el-form-item prop="username">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入账号" v-model.trim="dataForm.username">
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input :type="changeHiddenImg === true ? 'text' : 'password'" prefix-icon="el-icon-thumb"
              placeholder="请输入新密码" v-model.trim="dataForm.password" @focus="showImg"></el-input>
            <div class="clickImg" v-show="showHiddenImg" @click="changeImg">
              <div :class="changeHiddenImg === true ? 'showImg' : 'hiddenImg'"></div>
            </div>
          </el-form-item>
          <el-form-item prop="phone">
            <el-input label-width="100px" type="text" prefix-icon="el-icon-user" placeholder="请输入账号绑定的手机号"
              v-model.trim="dataForm.phone"></el-input>
          </el-form-item>
          <el-form-item prop="smsCode" class="verification">
            <el-input type="text" prefix-icon="el-icon-thumb" placeholder="请输入验证码" v-model.trim="dataForm.smsCode">
            </el-input>
            <SendCodeBtn :phone="this.dataForm.phone"></SendCodeBtn>

          </el-form-item>
        </div>

        <div class="SystemFormMiddle">
          <el-button type="primary" @click="goToRegister" :disabled="!canRegister">修改密码
          </el-button>
        </div>

        <div class="SystemFormBottom">
          <div class="SystemFormBottom-left">
            <router-link :to="{ name: 'Home' }">返回首页</router-link>
          </div>
          <div class="ystemFormBottom-right">
            <router-link :to="{ name: 'loginView' }">用户登录</router-link>
          </div>
        </div>

      </el-form>
    </div>
  </div>
</template>
<script>
import { forgetPassword } from "../../service/systemService"
import SendCodeBtn from '../../components/sendCode/sendCodeBtn'
import { CryAlgorithm } from '../../utils'  //公钥加密函数
import { mapGetters } from 'vuex'  //获取公钥的相关配置
import rules from '../../utils/rules'
export default {
  name: "retrievePassword",
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
    //获取公钥逻辑
    getPublicKey() {
      this.$store.dispatch('encryption/getPubKey');
    },

    //修改密码
    goToRegister() {
      this.getPublicKey();
      setTimeout(() => {
        let data = {}
        data.username = this.dataForm.username
        data.password = CryAlgorithm(this.getkeyInfo.encryPtion, this.dataForm.password)
        data.phone = this.dataForm.phone
        data.smsCode = this.dataForm.smsCode
        data.uuId = this.getkeyInfo.uuId
        forgetPassword(data).then(res => {
          console.log(res);
          if (res.data.code === 200) {
            this.$message.success('修改密码成功！！！')
            this.$router.push({ name: 'loginView' })
          }
          else if (res.data.code === 406) {
            this.$message.error(res.data.message);
          } else if (res.data.code === 415) {
            this.$message.error(res.data.message);
          }
        }
        )
      }, 1500)
    },
    //显示密码 
    showImg() {
      this.showHiddenImg = true
    },
    //隐藏密码 
    changeImg() {
      console.log(this.changeHiddenImg);
      this.changeHiddenImg = !this.changeHiddenImg
    }
  },
}
</script>


<style scoped lang="less">
.SystemBgBox {
  height: 500px;
  background: url(../../assets/Img/LoginImg/login_img.png) no-repeat 20% 50px #ddd;

  .SystemMain {
    height: 420px;


    .SystemForm {


      .SystemFormData {

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

      }

      .SystemFormBottom {
        .SystemFormBottom-left {


          a {
            color: #666;
          }
        }

        .SystemFormBottom-right {

          a {
            color: #666;
          }
        }
      }



      .verification {

        //验证码登录的输入框
        .el-input {
          width: 240px;
        }

      }



      .el-button {
        padding: 12px 110px;
      }

      .el-input {
        left: 7%;
        width: 360px;
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
