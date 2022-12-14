//回复相关信息是的组件
<template>
  <div class="replyItem">
    <div class="replyItem-Box">
      <div class="replyItem-Img" @click="gotoUserView">
        <img v-if="judgeUserImg" src="../../assets/Img/defaultUserImg.png" alt="">
        <img v-else :src="[publicUrl + replyInfo.image]" alt="">
      </div>
    </div>
    <div class="replyItem-other">
      <div class="replyItemHeader">
        <div class="title1"><em> 用户名:</em>&nbsp;&nbsp;{{replyInfo.nickName }}
        </div>
      </div>
      <div class="replyItemMain">
        <div class="title2">{{ replyInfo.content }}</div>
        <div class="ItemData">{{ replyInfo.messageTime.substring(0, 10) }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import { createPublicUrl } from '../../utils/index'
export default {
  name: "teacherReply",
  props: ['replyInfo'],
  methods: {
    //我跳转的到对应选择的用户介绍页面了，注意用户的ID与后端返回的ID
    gotoUserView() {
      let location = { name: 'otherPerson' }
      location.query = { userId: this.replyInfo.userId }
      this.$router.push(location);
    },
  },
  computed: {
    //判断用户是否有头像(有则展示用户头像,无则不展示)     
    judgeUserImg() {
      return this.replyInfo.image === "无"
    },
    publicUrl() {
      return createPublicUrl()
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

      img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }
    }
  }

  .replyItem-other {
    flex: 10;

    .replyItemHeader {
      display: flex;
      justify-content: space-between;
      em{
        font-weight: 700;
      }
    }

    .replyItemMain {
      display: flex;
      justify-content: space-between;

      .title2 {
        margin-left: 10px;
      }

      .ItemData {
        margin-right: 45px;
        font-size: 12px;
      }
    }

  }
}
</style>
