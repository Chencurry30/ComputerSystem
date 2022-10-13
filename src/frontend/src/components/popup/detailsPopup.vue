<!--用户回复的相关信息-->
<template>
  <div class="tab-content" v-show="showDialog">
    <div class="contentBox">
      <div class="header">
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
        <div class="header-left">用户名</div>
        <div class="header-right">评论时间</div>
      </div>
      <div class="content-body">
        <div class="content-main">
          <div class="body-item">
            <div class="laber">回复内容</div>
            <div class="body-item-info">{{ replyshow.content }}</div>
          </div>

          <div class="sendInfo btn" @click="closePopup">关闭</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "detailsPopup",
  data() {
    return {
      showDialog: false,
      replyshow: {},
    };
  },
  methods: {
    showPopup(replyInfo) {
      this.replyshow = replyInfo;
      this.showDialog = true;
    },
    closePopup() {
      this.showDialog = false;
    },
  },
};
</script>

<style lang="less" scoped>
.tab-content {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  overflow: auto;
  margin: 0;
  background: rgba(0, 0, 0, 0.5);
  .contentBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 400px;
    height: 310px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;
    .header {
      border-top-left-radius: 16px;
      border-top-right-radius: 16px;
      display: flex;
      justify-content: center;
      height: 80px;
      background: #59c3fb;
      .closeImg {
        position: absolute;
        top: 16px;
        right: 14px;
        width: 24px;
        height: 24px;
        cursor: pointer;
        img {
          width: 100%;
        }
      }
      .header-left {
        font-size: 18px;
        font-weight: 700;
        margin-right: 40px;
        line-height: 80px;
      }
      .header-right {
        font-size: 14px;
        margin-left: 40px;
        line-height: 80px;
      }
    }
    .content-body {
      width: 100%;
      .content-main {
        padding: 10px 20px;
        .body-item {
          margin: 10px 0px;
          display: flex;
          position: relative;
          .laber {
            position: absolute;
            top: 2px;
            left: 0px;
            width: 70px;
            font-size: 14px;
            transition: 0.8s;
          }
          .body-item-info {
            margin-top: 25px;
            width: 100%;
            height: 100px;
            font-size: 14px;
            color: #666;
          }
        }
        .sendInfo {
          display: flex;
          justify-content: center;
          margin-top: 20px;
          padding: 0.4em 5em;
          background: #59c3fb;
          color: #fff;
        }
      }
    }
  }
}
</style>
