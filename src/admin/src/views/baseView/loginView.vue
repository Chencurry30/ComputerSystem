<template>
  <div class="login_container">
    <div class="login_box">
      <div class="loge">
        <img src="../../assets/logo_pic.png" alt="" />
        <p>计算机考验辅助系统</p>
      </div>
      <el-form label-width="0px" class="login_in" ref="dataForm" :model="dataForm" :rules="checkForm">
        <div class="form-info">
          <el-form-item prop="username">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入账号" v-model.trim="dataForm.username">
            </el-input>
          </el-form-item>

          <el-form-item prop="password">
            <el-input type="password" prefix-icon="el-icon-thumb" placeholder="请输入密码"
              v-model.trim="dataForm.password"></el-input>
          </el-form-item>
        </div>

        <el-form-item class="btns">
          <el-button type="primary" @click="goToLogin" :disabled="!canSubmit">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import rules from "../../utils/rules";
import Cookies from "js-cookie";
import { CryAlgorithm } from "../../utils/uuid";
import { userLogin } from "../../services/systemService";
import { mapGetters } from "vuex"; //获取公钥的相关配置
export default {
  name: "loginView",
  data() {
    return {
      dataForm: {
        username: "", //账号
        password: "", //密码
      },
      checkForm: {
        //用户名校验
        username: [
          {
            validator: rules.FormValidate.Form().validateUserName,
            trigger: "blur",
          },
        ],
        //密码校验
        password: [
          {
            validator: rules.FormValidate.Form().validatePassWord,
            trigger: "blur",
          },
        ],
      },
    };
  },
  computed: {
    //判断提交
    canSubmit() {
      const { username, password } = this.dataForm;
      return Boolean(username && password);
    },
    //获取公钥的ID以及公钥的内容
    ...mapGetters("encryption", {
      getkeyInfo: "getkeyInfo",
    }),
  },
  methods: {
    goToLogin() {
      this.getPublicKey()
      setTimeout(() => {
        let data = {};
        data.uuId = this.getkeyInfo.uuId;
        data.username = this.dataForm.username;
        data.password = CryAlgorithm(this.getkeyInfo.encryPtion, this.dataForm.password) //密码加密
        userLogin(data).then((res) => {
          console.log(res);
          if (res.data.code === 400) {
            this.$message.error("用户名或密码错误，请重新输入！");
          } else if (res.data.code === 403) {
            this.$message.error("该用户无权限访问！");
          } else {
            let menulist = JSON.stringify(res.data.data.menuList[0].children);
            let menuRight = JSON.stringify(res.data.data.rights);
            sessionStorage.setItem("menulist", menulist);
            sessionStorage.setItem("menuRight", menuRight);
            Cookies.set("name", this.dataForm.username); //保存用户名
            const name = data.username;
            if (res.data.code === 200) {
              const token = res.data.data.token;
              sessionStorage.setItem("token", token); //保存token到本地浏览器
              this.$message({
                message: "恭喜你，登录成功！欢迎用户: " + name,
                type: "success",
              });
              this.$router.push({ name: "indexBox" });
            } else if (res.data.data.menuList === null) {
              this.$message({
                message: "无权限登录",
                type: "success",
              });
            }
          }
        });
      }, 1500)


    },
    getPublicKey() {
      this.$store.dispatch("encryption/getPubKey");
    }
  },
};
</script>

<style scoped lang="less">
.login_container {
  z-index: 55;
  height: 100%;

  .login_box {
    width: 460px;
    height: 420px;
    background: #fff;
    box-shadow: 0 0 10px 0 rgba(87, 190, 255, 0.2);
    border-radius: 10px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    .loge {
      text-align: center;
      font-family: "微软雅黑";
      font-size: 24px;
      color: #2f323e;
      margin-top: 26px;
    }

    .login_in {
      z-index: 999;
      position: absolute;
      top: 200px;
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
  }

  .btns {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
  }
}

/deep/.el-form-item__error {
  color: #f56c6c;
  font-size: 14px;
  padding: 3px 0px;
  position: absolute;
  top: 100%;
  left: 35px;
}
</style>
