<!--网站头部-->
<template>
  <div class="indexNav">
    <div class="headbox w">
      <div class="head-title">
        <div class="loge">
          <img src="@/assets/Img/webloge.png" alt="" />
        </div>
        <div class="webtitle">旭升考研完</div>
      </div>
      <div class="head-select">
        <div class="select-item">首页</div>
        <div class="select-item">资源</div>
        <div class="select-item">院校</div>
        <div class="select-item">备考</div>
        <div class="select-item">答疑</div>
        <div class="select-item">政策</div>
        <div class="select-item">帮助</div>
        <div class="select-item">更多</div>
      </div>
      <div class="head-btn">
        <div class="goto-login-btn" @click="gotologin">登录注册</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "webHeader",

  methods: {
    gotologin() {
      console.log(1);
      let location = { name: "Login" };
      this.$router.push(location);
    },
  },
};
</script>

<style lang="less" scoped>
.indexNav {
  width: 100%;
  height: 60px;
  line-height: 60px;
  background-color: #ffffff;
  .headbox {
    display: flex;
    margin-top: 10px;
    height: 60px;
    line-height: 60px;
    .head-title {
      display: flex;
      flex: 20%;
      .loge {
        margin-left: 60px;
        width: 60px;
        img {
          margin-top: 6px;
          width: 100%;
        }
      }
    }
    .head-select {
      display: flex;
      flex: 60%;
      .select-item {
        padding: 0 20px;
        height: 100%;
      }
    }
    .head-btn {
      margin-top: 17px;
      flex: 20%;
      .goto-login-btn {
        width: 92px;
        height: 26px;
        line-height: 26px;
        text-align: center;
        border-radius:13px;
        border: 1px solid #00965e;
        background: #00965e;
      }
    }
  }
}
</style>