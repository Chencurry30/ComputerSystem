<!--添加好友的弹窗-->
<template>
  <div class="tab-content" v-show="showDialog">
    <div class="contentBox">
      <div class="header">
        <div class="headerPopup">添加好友</div>
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>
      <div class="content-body">
        <div class="content-main">
          <div class="body-item">
            <div class="laber">验证消息</div>
            <input type="text" class="laber-info" v-model="validationData" />
            <i class="laber-line"></i>
          </div>
          <div class="sendInfo btn" @click="sendAddUserFriendData">发送验证</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { addUserFriendAction } from '../../service/userServers'
export default {
  name: "addUserFriend",
  data() {
    return {
      showDialog: false,
      validationData: '',
      friendId: 0,
    };
  },
  methods: {
    showPopup(friendId) {
      this.friendId = friendId
      this.showDialog = true;
    },
    closePopup() {
      this.showDialog = false;
    },
    //发送相关的好友请求 
    sendAddUserFriendData() {
      if (this.validationData === '') {
        this.$message.error('请输入相关的验证信息,更方便的通过对方添加')
      } else {
        let sendData = {}
        sendData.friendId = this.friendId
        sendData.reason = this.validationData
        addUserFriendAction(sendData).then((res) => {
          console.log(res);
          if(res.data.code === 200){
            this.showDialog = false;
          }else if(res.data.code === 400){
            this.$message.error(res.data.message)
          }
        })
      }

    }
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
  z-index: 999;

  .contentBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 400px;
    height: 380px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;

    .header {
      border-top-left-radius: 16px;
      border-top-right-radius: 16px;
      height: 70px;
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
    }

    .content-body {
      width: 100%;

      .content-main {
        padding: 10px 20px;

        .body-item {
          margin: 10px 0;
          display: flex;
          position: relative;

          .laber {
            position: absolute;
            top: 2px;
            left: 0;
            width: 60px;
            font-size: 14px;
            transition: 0.8s;
          }

          .laber-info {
            outline: 0;
            border: none;
            display: block;
            width: 100%;
            padding: 2em 2em 0.4em 0.3em;
            opacity: 0.8;
            transition: 0.3s;
            background: 0 0;
          }

          .laber-line {
            position: absolute;
            bottom: 0;
            left: 0;
            height: 1px;
            width: 100%;
            transition: 0.8s;
            background: rgba(50, 50, 50, 0.06);
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
