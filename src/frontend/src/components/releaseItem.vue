//提出评论时的组件 
<template>
  <div class="releaseItem">
    <div class="ItemInfo">
      <div class="userImg">
        <div class="active-img">
          <img src="" alt="" />
        </div>
      </div>
      <div class="userInput">
        <textarea class="InputBox" placeholder="发一条友善的评论"></textarea>
      </div>
      <div class="userBtn">
        <div class="Btn-text">发送</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "releaseItem",

};
</script>
<style lang='less' scoped>
.releaseItem {
  width: 100%;
  .ItemInfo {
    display: flex;
    height: 50px;
    .userImg {
      display: flex;
      width: 80px;
      height: 50px;
      .active-img {
        width: 48px;
        height: 48px;
        border-radius: 50%;
        background: red;
      }
    }
    .userInput {
      flex: 7;
      .InputBox {
        width: 100%;
        height: 100%;
        padding: 5px 10px;
        border-radius: 6px;
        resize: none;
        outline: none;
        color: #18191c;
        border: 1px solid #f1f2f3;
        background-color: #f1f2f3;
      }
    }
    .userBtn {
      display: flex;
      flex: 1;
      justify-content: center;
      align-items: center;
      position: relative;
      margin-left: 10px;
      border-radius: 4px;
      background: #00aeec;
      cursor: pointer;
      .Btn-text {
        position: absolute;
        z-index: 1;
        font-size: 16px;
        color: #ffffff;
      }
    }
  }
}
</style>