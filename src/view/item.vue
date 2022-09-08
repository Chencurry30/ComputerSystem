<template>
  <!--登录和注册公用的组件-->
  <div class="contain w">
    <div class="mainbox" :class="{ SortingStyle: changestyle }">
      <div class="mianleft">
        <div class="form login" :class="{ showblock: changestyle }">
          <div class="title">欢迎回来</div>
          <div class="item">
            <div class="labletitle">手机号</div>
            <input type="text" />
          </div>
          <div class="item">
            <div class="labletitle">密码</div>
            <input type="text" />
          </div>
          <div class="agreement">
            <input type="checkbox" />
            <span
              >平台
              <a href="###" class="first">注册协议</a>
              和
              <a href="" class="second">隐私政策</a>
            </span>
          </div>
          <div class="Payattention items-center">
            <div class="lf">
              <input type="checkbox" />
              <span>自动登录</span>
            </div>
            <div class="lr">
              <a href="">忘记密码</a>
            </div>
          </div>
          <div class="Loginbtn">
            <a href="javascript:;">登录</a>
          </div>
        </div>
        <div class="form register" :class="{ showblock: !changestyle }">
          <div class="title">立即注册</div>
          <div class="item">
            <div class="labletitle">手机号</div>
            <input type="text" />
          </div>
          <div class="item">
            <div class="labletitle">密码</div>
            <input type="password" />
          </div>
          <div class="item">
            <div class="labletitle">确认密码密码</div>
            <input type="password" />
          </div>
          <div class="item Vcode">
            <div class="labletitle">验证码</div>
            <input type="text" />
            <button class="Vbtn">获取验证码</button>
          </div>
          <div class="Loginbtn">
            <a href="javascript:;" @click="SendInfo">注册</a>
          </div>
        </div>
      </div>
      <div class="mainright" :class="{ mainrightbg: !changebg, mainleftbg: changebg }">
        <div class="EncourageInfo">
          <div class="EncoInfo-l">愿君扶摇直上五千里</div>
          <div class="EncoInfo-r">易云直挂无九州</div>
        </div>
        <div class="registerbtn" @click="GotoBtn"
          :class="{
            'registerbtn-l-Location': changebg,
            'registerbtn-r-Location': !changebg,
          }"
        >
          <a href="javascript:;">{{
            changestyle === true ? "登录" : "注册"
          }}</a>
        </div>
      </div>
    </div>
    <PopupWindow ref="PopupWindow"></PopupWindow>
  </div>
</template>



<script>
import PopupWindow from "@/components/PopupWindow.vue";
export default {
  name: "item",
  data() {
    return {
      UserInfoLogin: {
        phone: "",
        password: "",
        CommitPassword: "",
        Vcode: "",
      },
    };
  },
  methods: {
    GotoBtn() {
      let routes = this.$route.name;
      if (routes === "Register") {
        let location = { name: "Login" };
        this.$router.push(location);
      } else {
        let location = { name: "Register" };
        this.$router.push(location);
      }
    },
    SendInfo() {
      console.log(123);
      this.$refs.PopupWindow.show(); //用于提醒用户输入的条件
    },
  },
  computed: {
    changestyle() {
      return this.$route.name !== "Login";
    },
    changebg() {
      return this.$route.name !== "Login";
    },
  },
  components: { PopupWindow },
};
</script>

<style scoped lang="less">
.contain {
  position: relative;
  height: 500px;
  background-color: #ededed;
  .mainbox {
    display: flex;
    position: absolute;
    top: 14px;
    left: 17%;
    width: 760px;
    height: 472px;
    .mianleft {
      flex: 65%;
      height: 100%;
      background-color: #fff;
      .form {
        margin: 10px auto;
        width: 50%;
        .title {
          text-align: center;
          font-weight: 700;
          font-size: 18px;
        }
        .item {
          height: 80px;
          .labletitle {
            margin: 5px 0 5px 0;
            font-size: 12px;
            text-align: center;
            color: #909399;
          }
          .Vbtn {
            position: absolute;
            top: 10px;
            right: -22px;
            font-size: 12px;
            width: 80px;
            height: 30px;
            line-height: 30px;
            border: 1px solid #999;
            border-radius: 20px;
            background-color: #fff;
          }
          input {
            width: 80%;
            padding: 0 20px;
            font-size: 16px;
            border-bottom: 1px solid rgba(0, 0, 0, 0.4);
            text-align: center;
          }
        }
        .Vcode {
          position: relative;
        }
        .Payattention {
          display: flex;
          justify-content: space-between;
          .lf {
            position: relative;
            align-self: center;
            font-size: 12px;
            span {
              padding: 1px 2px;
            }
          }
          .lr {
            a {
              font-size: 12px;
              color: #cfcfcf;
              text-decoration: underline;
            }
          }
        }
        .agreement {
          span {
            font-size: 12px;
            padding: 1px 2px;
            a {
              color: blue;
            }
            .first:hover {
              text-decoration: underline;
            }
            .second:hover {
              text-decoration: underline;
            }
          }
        }
        .Loginbtn {
          margin-top: 20px;
          height: 40px;
          line-height: 40px;
          text-align: center;
          background-color: wheat;
          color: #fff;
          border-radius: 20px;
        }
      }

      .login {
        .item {
          margin-top: 30px;
        }
      }
      .register {
        .item {
          margin-top: 5px;
        }
      }
    }
    .mainright {
      position: relative;
      flex: 35%;
      height: 100%;

      .EncourageInfo{
        position: absolute;
        left: 27px;
        top: 50px;
        width: 20px;
        display: flex;
        font: italic 1.3em Georgia, serif;
      }


      .registerbtn {
        position: absolute;
        opacity: 0.7;
        bottom: 50px;
        height: 40px;
        line-height: 40px;
        background-color: wheat;
        width: 100px;
        margin: 0 auto;
        text-align: center;
        border-radius: 20px;
        color: white;
      }
      .registerbtn-l-Location {
        left: 85px;
      }
      .registerbtn-r-Location {
        right: 85px;
      }
    }

    .mainrightbg {
      background: url(../assets/Img/LoginImg/form-rg.png);
      opacity: 0.8;
    }
    .mainleftbg {
      background: url(../assets/Img/LoginImg/form-lg.png);
      opacity: 0.8;
    }
  }
  .SortingStyle {
    flex-direction: row-reverse;
  }
  .showblock {
    display: none;
  }
}
</style>