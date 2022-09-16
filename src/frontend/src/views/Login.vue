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
          clickMode="push">
</vue-particles>
<div class="login_container">
    <div class="login_box">
      <div class="avatar_box">
        <img src="../assets/Img/LoginImg/tx.jpg" alt="">
      </div>
      <el-form label-width="0px" class="login_in">
        <el-form-item prop="username">
          <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" prefix-icon="el-icon-thumb" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button type="primary">登录</el-button>
          <el-button>重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
    </div>


</template>

<script>
export default {
    name:'Login',
    data(){
        
    }
}
</script>

<style scoped lang="less">
#particles-js {
  width: 100%;
  height: calc(100%);
  position: absolute;
  background-image: url('../assets/Img/LoginImg/background.png');
}
.login_container {
    background-color: #42b983;
    height: 100%;
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
    justify-content: flex-end;

  }

  .login_in {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
</style>