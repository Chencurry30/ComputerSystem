//提出评论时的组件
<template>
  <div class="releaseItem">
    <div class="ItemInfo">
      <div class="userImg">
        <div class="active-img">
          <img v-if="judgeUserImg" src="../../assets/Img/defaultUserImg.png" alt="" />
          <img v-else :src="[publicUrl + userImg]" alt="" />
        </div>
      </div>
      <div class="userInput">
        <textarea class="InputBox" :placeholder="showplacehodler" v-model="content"></textarea>
      </div>
      <div class="userBtn">
        <div class="Btn-text" @click="sendComments">发送</div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import { sendVideoRemark } from '../../service/videoService'
import { createPublicUrl } from '../../utils/index'
import _ from 'lodash'
export default {
  name: "releaseItem",
  //父组件传入的参数(1.回复或者是评论 2.父组件的信息) 
  props: ['typeSelect', 'fatherInfo'],
  data() {
    return {
      content: '',
      userImg: sessionStorage.getItem('userImg')
    }
  },
  methods: {
    //发送相关评论(60秒发送一次) 
    sendComments: _.throttle(function () {
      let data = {}
      data.content = this.content
      data.resourceId = parseInt(this.$route.query.videoId)
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
      //发送评论(得在父组件内在请求获取一次所有评论的接口,顺便评论刷新) 
      sendVideoRemark(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success('评论成功')
          this.$parent.getPageRemark()
          this.content = ''
        }
      })

    }, 60000)




  },
  // user/userImage/32757fc1-9511-4cde-85bf-7ba8cb6ad916.jpg
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
    },
    //判断用户是否有头像(有则展示用户头像,无则不展示)     
    judgeUserImg() {
      return sessionStorage.getItem('userImg') === "无"
    },
    //获取公共的url 
    publicUrl() {
      return createPublicUrl()
    }

  },

};
</script>
<style lang='less' scoped>
.releaseItem {
  width: 100%;

  .ItemInfo {
    display: flex;
    height: 48px;

    .userImg {
      display: flex;
      justify-content: center;
      align-content: center;
      width: 80px;

      .active-img {
        width: 50px;
        height: 50px;

        img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
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
