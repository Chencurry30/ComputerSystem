//回复相关信息是的组件 
<template>
  <div class="replyItem">
    <div class="replyItem-Box">
      <div class="replyItem-Img"></div>
    </div>
    <div class="replyItem-other">
      <div class="replyItem-info">
        <div class="title1">{{replyInfo.nickname}}</div>
        <div class="title2">{{replyInfo.content}}</div>
      </div>
      <div class="replyItem-select">
        <div class="ItemData">{{replyInfo.time}}</div>
        <div class="like">
          <img src="../assets/Img/Icon/like.png" alt="">
          <div class="likeNumber">1232</div>
        </div>
        <div class="unlike">
          <img src="../assets/Img/Icon/unlike.png" alt="">
          <div class="unlikeNumber">0</div>
        </div>
        <div class="ItemMore" @click="lockMore">点击详情</div>
        <div class="title3" @click="clickBackothersInfo">回复</div>
        <detailsPopup ref="detailsPopup"></detailsPopup>
      </div>

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
    },
    clickBackothersInfo(){
      let otherInfo = {}
      otherInfo.userId = this.replyInfo.userId;
      otherInfo.nickname = this.replyInfo.nickname;
      console.log("这里将需要回复的相关信息的回复的ID放入了vuex供其他组件访问");
      this.$store.dispatch('remark/getotherinfo',otherInfo)
    }
  }
};
</script>

<style lang='less' scoped>
.replyItem {
  display: flex;
    justify-content: space-between;
    margin: 5px 10px;
    padding: 5px 5px;
    height: 75px;
    color: #666;
  // border: 2px solid #eee;
  .replyItem-Box {
    display: flex;
    justify-content: center;
    flex: 1;
    .replyItem-Img {
      width: 65%;
      height: 63%;
      border-radius: 50%;
      background: red;
}
  }
  .replyItem-other {
    flex: 10;
    .replyItem-info{
      .title1,.title2{
        font-size: 12px;
      }
    }
    .replyItem-select{
      display: flex;
      font-size: 12px;
      .title3{
        color: #00aeec;
        cursor: pointer;
      }
      .ItemData {
        margin-right: 15px;
      }
      .ItemMore {
        margin-right: 15px;
        cursor: pointer;
      }
      .like,.unlike{
        margin-right: 10px;
        display: flex;
        align-content: center;
        justify-content: center;
        img{
          margin-right: 5px;
          width: 18px;
          height: 18px;
        }
        .likeNumber,.unlikeNumber{
          margin-right: 10px;
          font-size: 12px;
          color: #666;
        }
      }
    }

  }
}
</style>