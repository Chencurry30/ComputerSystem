<template>
  <div class="mainBox">
    <div class="main">
      <div class="mainHeader">
        <div class="HeaderLeft">
          <img src="../../assets/Img/webAbout/service.png.png" alt="" />
        </div>
        <div class="HeaderRight">
          <div class="AskBtn">点击咨询</div>
        </div>
      </div>
      <div class="mainSelect">
        <div class="SelectLeft">
          <div class="title">在线客服</div>
          <div class="showinfo">在线解答相关咨询，高校，简介</div>
          <div class="gotoBtn">点击咨询</div>
        </div>
        <div class="SelectRight">
          <div class="title">提供反馈</div>
          <div class="showinfo">提供相关反馈，提高用户体验</div>
          <div class="gotoBtn">
            <router-link :to="{}"></router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "webAboutService",
};
</script>
<style lang="less" scoped>
.mainBox {
  width: 100%;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f1f1f1;
  .main {
    margin: 0 auto;
    padding-bottom: 30px;
    width: 990px;
    background-color: #f9f9f9;
    .mainHeader {
      display: flex;

      .HeaderRight {
        .AskBtn {
          margin-top: 45px;
          margin-left: 30px;
          padding: 5px 20px;
          width: 140px;
          text-align: center;
          line-height: 30px;
          font-size: 16px;
          color: #ffffff;
          background-color: #f3b701;
          cursor: pointer;
        }
      }
    }
    .mainSelect {
      margin-top: 8px;
      display: flex;
      justify-content: space-between;

      .SelectLeft {
        cursor: pointer;
        margin-left: 60px;
      }
      .SelectRight {
        cursor: pointer;
        margin-right: 60px;
      }
      .title {
        margin-bottom: 10px;
        font-size: 16px;
        font-weight: 700;
      }
      .showinfo {
        color: #999;
        margin-bottom: 10px;
      }
      .gotoBtn {
        padding: 5px 15px;
        color: #fff;
        text-align: center;
        background-color: #6abb77;
      }
    }
  }
}
</style>