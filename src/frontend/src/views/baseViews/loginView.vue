<template>
  <div class="SystemBgBox">
    <div class="SystemMain">
      <div class="SystemFormTitle">用户登录</div>
      <el-form class="SystemForm" label-width="0px" ref="dataForm" :model="dataForm" :rules="checkForm">

        <div class="SystemFormData">
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


        </div>

        <div class="SystemFormTop">
          <div class="SystemFormTop-left">
            <div class="SystemFormTop-leftbtn">
              <div :class="automaticLogin === false ? 'dashDiv' : 'dashDivSelectd'">
                <span class="dashSpan" @click="submitLogin"></span>
              </div>
              <div class="promptTitle">自动登录</div>
            </div>
          </div>
          <div class="SystemFormTop-right">
            <div class="promptTitle" @click="gotoretrieve">忘记密码</div>
          </div>
        </div>

        <div class="SystemFormMiddle">
          <el-button class="loginBtn" type="primary" @click="goToLogin('dataForm')"
            :disabled="!canSubmit">登&nbsp;&nbsp;&nbsp;&nbsp;录
          </el-button>
        </div>

        <div class="SystemFormBottom">
          <div class="SystemFormBottom-left">
            <router-link :to="{ name: 'Home' }">返回首页</router-link>
          </div>
          <div class="SystemFormBottom-right">
            <router-link :to="{ name: 'registerView' }">用户注册</router-link>
          </div>
        </div>


      </el-form>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie';
import { userLogin } from '../../service/systemService';
import { CryAlgorithm } from '../../utils'  //公钥加密函数
import { mapGetters } from 'vuex'  //获取公钥的相关配置
import rules from '../../utils/rules'

export default {
  name: "loginView",
  //App中传入的一个相关的方法,用于帮助进行页面刷新
  inject: ['reload'],
  data() {
    return {
      automaticLogin: false, //自动登录
      showHiddenImg: false,
      changeHiddenImg: false,
      dataForm: {
        username: '', //账号
        password: '', //密码
      },
      checkForm: {
        //用户名校验
        username: [
          { validator: rules.FormValidate.Form().validateUserName, trigger: 'blur' },
        ],
        //密码校验
        password: [
          { validator: rules.FormValidate.Form().validatePassWord, trigger: 'blur' }
        ],
      },
    };
  },
  mounted() {
    this.reload()
  },
  methods: {
    //获取公钥逻辑
    getPublicKey() {
      this.$store.dispatch('encryption/getPubKey');
    },
    //是否自动登录
    submitLogin() {
      this.automaticLogin = !this.automaticLogin;
    },
    //返回首页
    backHome() {
      let location = { name: "mainHome" };
      this.$router.push(location);
    },
    //忘记密码
    gotoretrieve() {
      let location = { name: "retrievePassword" };
      this.$router.push(location);
    },
    //获取焦点时显示图片
    showImg() {
      this.showHiddenImg = true
    },
    //修改可以查看密码的图片样式
    changeImg() {
      this.changeHiddenImg = !this.changeHiddenImg
    },
    //登录逻辑
    goToLogin(dataForm) {
      this.getPublicKey();
      setTimeout(() => {
        this.$refs[dataForm].validate(valid => {
          //验证通过
          if (valid) {
            if (this.getkeyInfo.encryPtion === '') {
              this.$message.error("密码加密失败，请重新点击登录按钮")
            } else {
              let data = {}
              data.uuId = this.getkeyInfo.uuId
              data.username = this.dataForm.username
              data.password = CryAlgorithm(this.getkeyInfo.encryPtion, this.dataForm.password)
              userLogin(data).then(res => {
                console.log(res);
                if (res.data.code === 200) {
                  Cookies.set('name', res.data.data.user.nickname)
                  const token = res.data.data.token
                  const userImg = res.data.data.user.image
                  const userId = res.data.data.user.userId
                  const nickname = res.data.data.user.nickname || '无'
                  const userPhone = res.data.data.user.phone || '无'
                  const teacherId = res.data.data.teacherId || 0
                  sessionStorage.setItem('userImg', userImg)
                  sessionStorage.setItem('userId', userId)   //保存正在登录用户的userId
                  sessionStorage.setItem('token', token)    //保存token到本地浏览器
                  sessionStorage.setItem('nickname', nickname)
                  sessionStorage.setItem('userPhone', userPhone)
                  sessionStorage.setItem('teacherId', teacherId)
                  this.$message({
                    message: "恭喜你，登录成功！欢迎用户: " + nickname,
                    type: "success",
                  })
                  this.$router.push({ name: 'Home' })
                  //刷新页面
                  this.reload()
                } else if (res.data.code === 409) {
                  this.$message.error(res.data.message)
                } else if (res.data.code === 500) {
                  this.$message.error(res.data.message)
                }
              })
            }
          }
          // 验证未通过
          else {
            this.$message.error("请按照提示要求修改后再进行登录")
          }
        })
      }, 1000);
    }

  },
  computed: {
    //判断提交
    canSubmit() {
      const { username, password } = this.dataForm
      return Boolean(username && password)
    },
    //获取公钥的ID以及公钥的内容
    ...mapGetters('encryption', {
      getkeyInfo: 'getkeyInfo'
    })
  },
};
</script>

<style scoped lang="less">
.SystemBgBox {
  background: url(../../assets/Img/LoginImg/login_img.png) no-repeat 20% 50px #ddd;

  .SystemForm {
    .SystemFormData {
      .clickImg {
        display: flex;
        position: absolute;
        right: 60px;
        top: 56%;
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

    .SystemFormMiddle {
      .loginBtn {
        width: 80% !important;
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


    .el-form-item {
      margin-bottom: 20px;
    }
    .el-button {
      padding: 12px 110px;
    }
    .el-input {
      left: 5%;
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
</style>
