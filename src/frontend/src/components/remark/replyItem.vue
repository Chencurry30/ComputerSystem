//回复相关信息是的组件
<template>
  <div class="replyItem">
    <div class="replyItem-Box">
      <div class="replyItem-Img" @click="gotoUserView"></div>
    </div>
    <div class="replyItem-other">
      <div class="replyItem-info">
        <div class="title1">{{replyInfo.author.nickname}}
        <span class="backTitle" v-if="replyInfo.toUser">回复的是{{replyInfo.toUser.nickname}}</span>
        </div>
        <div class="title2">{{replyInfo.content}}</div>
      </div>
      <div class="replyItem-select">
        <div class="ItemData">{{replyInfo.createDate}}</div>
        <div class="like">
          <img src="../../assets/Img/Icon/like.png" alt="">
          <div class="likeNumber">1232</div>
        </div>
        <div class="unlike">
          <img src="../../assets/Img/Icon/unlike.png" alt="">
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
import detailsPopup from '../popUp/detailsPopup';
export default {
  components: { detailsPopup },
  name: "replyItem",
  props:['replyInfo','showId'],
  methods:{
    lockMore(){
      this.$refs.detailsPopup.showPopup(this.replyInfo);
    },
    clickBackothersInfo(){
      let otherInfo = {}
      otherInfo.toUser = this.replyInfo.author.userId || null
      otherInfo.nickname = this.replyInfo.author.nickname;
      //这里面的showId是用来控制着回复的弹出框展示的是哪一个的弹出框
      otherInfo.showId = this.showId;
      this.$store.dispatch('remark/getotherinfo',otherInfo)
    },





    //我跳转的到对应选择的用户介绍页面了，注意用户的ID与后端返回的ID
    gotoUserView(){
      let location ={name:'otherPerson'}
      location.query = {userId:this.replyInfo.author.userId}
      this.$router.push(location);
    }
  }
};
</script>

<style lang='less' scoped>
.replyItem {
  display: flex;
    justify-content: space-between;
    margin: 8px 10px;
    padding: 5px 5px;
    height: 75px;
    color: #666;
  // border: 2px solid #eee;
  .replyItem-Box {
    display: flex;
    justify-content: center;
    flex: 1.1;
    .replyItem-Img {
      width: 48px;
      height: 48px;
      cursor: pointer;
      border-radius: 50%;
      background: red;
}
  }
  .replyItem-other {
    flex: 10;
    .replyItem-info{
      .title1,.title2{
        font-size: 16px;
      }
      .backTitle{
        font-size: 12px;
        color: #00aeec;
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
