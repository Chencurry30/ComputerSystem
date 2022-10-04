<template>
  <div class="allBox">
    <div class="UserBox">
      <div class="containHeader">
        <span class="headerP1">我的资料</span>
        <span class="headerP2">MY PROFILE</span>
        <span class="headerP3">SETTINGS</span>
      </div>
      <div class="containMain">
        <div class="userImg"></div>
        <div class="userInfo">
          <div class="infoTop">
            <div class="left">高山流水</div>
          </div>
          <div class="infoMiddle">
            <span>四川</span>
            <span>/</span>
            <span>达州市</span>
            <span>/</span>
            <span>曲线</span>
          </div>
          <div class="infoBottom">
            <span>数学</span>
            <span>英语</span>
            <span>手绘</span>
          </div>
        </div>
      </div>
    </div>
    <div class="UserBox second">
      <div class="messageHeraer">
        .
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "messageReply",
};
</script>

<style lang='less' scoped>
.allBox {
  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;
    .containHeader {
      padding: 15px 0;
      border-bottom: 2px solid #eee;
      .headerP1 {
        margin-left: 40px;
        font-weight: 700;
      }
      .headerP2 {
        margin-left: 20px;
        font-weight: 700;
        color: #ff8c00;
      }
      .headerP3 {
        margin-left: 10px;
      }
    }
    .containMain {
      margin: 10px 0px;
      padding: 0px 20px;
      display: flex;
      .userImg {
        margin-left: 40px;
        width: 100px;
        height: 100px;
        border-radius: 50px;
        border: 1px solid #eee;
      }
      .userInfo {
        margin-left: 40px;
        width: 200px;
        .infoTop {
          margin: 5px 0px;
          display: flex;
          justify-content: space-between;
          .left {
            font-weight: 700;
          }
          .right {
            font-weight: 700;
          }
        }
        .infoMiddle {
          margin-left: 5px;
          margin-bottom: 5px;
          span {
            padding: 0px 5px;
          }
        }
        .infoBottom {
          margin-left: -3px;
          margin-top: 10px;
          span {
            margin: 0 3px;
            padding: 0px 8px;
            border: 2px solid #eee;
            border-radius: 10px;
          }
        }
      }
    }
    .messageMain {
    }
  }
  .second {
    margin-top: 15px;
  }
}
</style>