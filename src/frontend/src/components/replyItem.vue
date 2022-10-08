//回复相关信息是的组件 
<template>
  <div class="replyItem">
    <div class="replyItem-Box">
      <div class="replyItem-Img"></div>
      <div class="replyItem-info">
        <div class="title1">{{replyInfo.nickname}}</div>
        <div class="title2">{{replyInfo.content}}</div>
        <div class="title3">{{replyInfo.resourcename}}</div>
      </div>
    </div>
    <div class="replyItem-other">
      <div class="ItemData">{{replyInfo.time}}</div>
      <div class="ItemMore" @click="lockMore">点击详情</div>
      <detailsPopup ref="detailsPopup"></detailsPopup>
    </div>
  </div>
</template>

<script>
import detailsPopup from './popup/detailsPopup.vue';
export default {
  components: { detailsPopup },
  name: "replyItem",
  props:['replyInfo'],
  methods:{
    lockMore(){
      this.$refs.detailsPopup.showPopup(this.replyInfo);
    }
  }
};
</script>

<style lang='less' scoped>
.replyItem {
  display: flex;
  justify-content: space-between;
  margin: 15px 10px;
  padding: 10px 5px;
  border-radius: 6px;
  color: #666;
  border: 2px solid #eee;
  .replyItem-Box {
    display: flex;
    .replyItem-Img {
      margin-left: 15px;
      width: 64px;
      height: 64px;
      border-radius: 50%;
      background: red;
    }
    .replyItem-info {
      margin-left: 15px;
      font-size: 14px;
      .title1 {
        font-size: 16px;
        font-weight: 700;
      }
      .title2 {
        color: #666;
      }
    }
  }
  .replyItem-other {
    margin-top: 45px;
    display: flex;
    justify-content: space-between;
    align-content: flex-end;
    height: 20px;
    line-height: 20px;
    .ItemData {
      margin-right: 15px;
      font-size: 14px;
    }
    .ItemMore {
      margin-left: 8px;
      margin-right: 10px;
      font-size: 14px;
      cursor: pointer;
    }
  }
}
</style>