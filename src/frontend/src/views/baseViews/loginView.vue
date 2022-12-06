<template>
  <div class="login-wrap-bg">
    <div class="login_box">
      <el-form label-width="0px" class="login_in" ref="dataForm" :model="dataForm" :rules="checkForm">

        <div class="form-info">
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
          <el-button type="primary" @click="goToLogin('dataForm')" :disabled="!canSubmit">登&nbsp;&nbsp;&nbsp;&nbsp;录
          </el-button>
        </el-form-item>

        <div class="stytem">
          <div class="stytem-left font-text">
            <router-link :to="{ name: 'Home' }">返回首页</router-link>
          </div>
          <div class="stytem-right font-text">
            <router-link :to="{ name: 'registerView' }">用户注册</router-link>
          </div>
        </div>

      </el-form>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie';
import { userLogin } from '../../service/ServersApi';
import { CryAlgorithm } from '../../utils'  //公钥加密函数
import { mapGetters } from 'vuex'  //获取公钥的相关配置
import rules from '../../utils/rules'

export default {
  name: "loginView",
  //App中传入的一个相关的方法,用于帮助进行页面刷新
  inject:['reload'],
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
  mounted(){
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
      let location = { name: "mainHome" };
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
          // if (valid){
          //   if(this.getkeyInfo.encryPtion === ''){
          //      this.$message.error("密码加密失败，请重新点击登录按钮")
          //   }else{
          let data = {}
          data.uuId = this.getkeyInfo.uuId
          data.username = this.dataForm.username
          data.password = this.dataForm.password
          // data.password = CryAlgorithm(this.getkeyInfo.encryPtion,this.dataForm.password)
          userLogin(data).then(res => {
            console.log(res);
            if (res.data.code === 200) {
              Cookies.set('name',res.data.data.user.nickname)
              const token = res.data.data.token
              const userImg = res.data.data.user.image
              const userId = res.data.data.user.userId
              const nickname = res.data.data.user.nickname
              sessionStorage.setItem('userImg',userImg)
              sessionStorage.setItem('userId',userId)   //保存正在登录用户的userId
              sessionStorage.setItem('token', token)    //保存token到本地浏览器
              sessionStorage.setItem('nickname',nickname)
              const name = Cookies.get('nickname')
              this.$message({
                message: "恭喜你，登录成功！欢迎用户: " + name,
                type: "success",
              })
              this.$router.push({ name: 'Home' })
              //刷新页面
              this.reload()
            } else if (res.data.code === 400) {
              this.$message.error("用户名或密码错误，请重新输入！")
            }
          })
          //   }
          // }
          // 验证未通过
          // else {
          //   this.$message.error("请按照提示要求修改后再进行登录")
          //   this.dataForm = {}
          // }
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
.login-wrap-bg {
  margin-top: 60px;
  position: relative;
  height: 440px;
  width: 100%;
  background: url(../../assets/Img/LoginImg/login_img.png) no-repeat 20% 50px #ddd;
}
.login_box {
  width: 450px;
  height: 350px;
  border-radius: 3px;
  position: absolute;
  right: 14%;
  top: 10%;
  background: #fff;

  .login_in {
    z-index: 999;
    position: absolute;
    top: 18%;
    width: 100%;
    padding: 0 20px;

    .el-form-item {
      margin-bottom: 20px;
    }

    //选择方式
    .tablenav {
      margin: 10px 0px;
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
        font-size: 18px;
        font-family: 楷体;
      }
    }
    //选择链接
    .stytem {
      display: flex;
      justify-content: space-between;
      align-content: center;
      font-size: 14px;
      line-height: 22px;

      .stytem-left {
        margin-left: 35px;
        a {
          color: #666;
        }
      }

      .stytem-right {
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
      left: 5%;
      width: 360px;
    }
  }
}
.btns {
  display: flex;
  justify-content: space-between;
}
:deep .el-form-item__error {
  color: #F56C6C;
  font-size: 14px;
  padding: 3px 0px;
  position: absolute;
  top: 100%;
  left: 35px;
}
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
</style>
