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
    <div class="login_container">
      <div class="login_box">
        <div class="avatar_box">
          <img src="../assets/Img/LoginImg/tx.jpg" alt="" />
        </div>
        <el-form label-width="0px" class="login_in" :model="userInfo">
          <el-form-item prop="account">
            <el-input
              type="text"
              prefix-icon="el-icon-user"
              placeholder="请输入账号"
              v-model="userInfo.account"
            ></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              type="password"
              prefix-icon="el-icon-thumb"
              placeholder="请输入密码"
              v-model="userInfo.password"
            ></el-input>
          </el-form-item>

          <div class="tablenav">
            <div class="navleft">
              <div class="leftbtn">
                <div
                  :class="
                    automaticLogin === false ? 'dashDiv' : 'dashDivSelectd'
                  "
                >
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
            <el-button type="primary">登录</el-button>
            <el-button>注册</el-button>
          </el-form-item>
          <div class="stytem">
            <div class="stytem-left">
              <div class="lefttitle" @click="backHome()">返回首页</div>
            </div>
            <div class="stytem-right">
              <div class="righttitle">关于我们</div>
            </div>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "loginView",
  data() {
    return {
      automaticLogin: false, //自动登录
      userInfo:{
        account:'',
        password:''
      }
    };
  },
  methods: {
    submitLogin() {
      this.automaticLogin = !this.automaticLogin;
    },
    backHome() {
      let location = { name: "Home" };
      this.$router.push(location);
    },
  },
  computed: {},
};
</script>

<style scoped lang="less">
#particles-js {
  width: 100%;
  height: calc(100%);
  position: absolute;
  background-image: url("../assets/Img/LoginImg/background.png");
}
.login_container {
  z-index: 55;
  background-color: #42b983;
  height: 100%;
}

.el-form-item {
  margin-bottom: 14px;
  margin-top: 10px;
}
.login_box {
  width: 450px;
  height: 300px;
  // background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  // opacity: .7;
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
  .el-input {
    left: 7%;
    width: 360px;
  }
  .el-button{
    padding: 12px 50px;
  }
  .tablenav {
    display: flex;
    justify-content: space-between;
    align-content: center;

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
      font-size: 14px;
      font-family: 楷体;
    }
  }
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
      color: blue;
      cursor: pointer;
    }
    .lefttitle:hover {
      color: blue;
      cursor: pointer;
    }
  }
  .prompt:hover {
    color: blue;
    cursor: pointer;
  }
}
</style>