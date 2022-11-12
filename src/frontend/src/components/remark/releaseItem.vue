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
        <textarea class="InputBox" :placeholder="showplacehodler" v-model="content"></textarea>
      </div>
      <div class="userBtn">
        <div class="Btn-text" @click="sendIndo">发送</div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import { sendVideoRemark } from '../../service/videoService'
export default {
  name: "releaseItem",
  props: ['typeSelect', 'fatherInfo'],
  data() {
    return {
      content: ''
    }
  },
  // 该视频对我的相关学习起到了很好的作用
  methods: {
    sendIndo() {
      let data = {}
      data.content = this.content
      data.resourceId = parseInt(this.$route.query.videoId)
      console.log(data);
      if (this.fatherInfo === undefined) {
        data.level = 1    //表示的是用户发表的评论
        data.parentId = 0
        data.toUid = 0
      } else {
        //表示的是用户回复其他人的评论
        data.toUid = this.backOtherInfo.toUser 
        data.parentId = this.fatherInfo.commentId
        data.level = 2
      }
      sendVideoRemark(data).then((res)=>{
        console.log(res);
      })
    }
  },
  computed: {
    ...mapState('remark', {
      backOtherInfo: 'backOtherInfo',
    }),
    showplacehodler() {
      if (this.typeSelect === '回复') {
        return '@' + this.backOtherInfo.nickname
      } else {
        return '发送一条相关的评论'
      }
    }
  },

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
      justify-content: center;
      align-content: center;
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
