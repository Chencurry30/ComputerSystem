<!--好友聊天弹窗-->
<template>
  <div class="tab-content" v-show="showDialog">
    <div class="contentBox">
      <div class="chatHeader">
        <div class="chatToUserTitle">{{ friendNickName }}</div>
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>
      <div class="chatMain" ref="chatRoom">
        <div ref="content">
          <div v-for="(item, index) in msgList" :key="index" class="chatItem"
          :class="{ reverseChatItem: item.from === userId }">
          <div class="userImg">
            <!--通过两个计算属性来合并显示的url参数-->
            <img :src="[publicUrl + titleImg(item.from)]" alt="">
          </div>
          <div class="usercommunication" :class="{ reverseCommunication: item.from === userId }">
            {{ item.message }}
          </div>
        </div>
        </div>
      </div>
      <div class="chatBottom">
        <el-input type="textarea" class="chatInformationBox" v-model="chatUserCommunication"
          :autosize="{ minRows: 2, maxRows: 3 }" :autofocus="true">
        </el-input>
      </div>
      <div class="chatSendBtn">
        <el-button type="success" @click="sendInfo()">发送</el-button>
        <el-button type="primary" @click="giveFatherAction()">关闭</el-button>
      </div>
    </div>
  </div>
</template>
  
<script>
import { getmessage } from '../../service/userServers'
import { createPublicUrl } from '../../utils/index'
export default {
  name: "passwordPopup",
  data() {
    return {
      rowsData: {
        minRows: 2, maxRows: 6
      },

      showDialog: false,
      chatUserCommunication: '',
      msgList: [],
      //用户自己的相关信息 
      userId: 0,
      userImg: sessionStorage.getItem('userImg'),
      //好友的相关信息 
      friendId: 0,
      friendImage: '',
      friendNickName: ''
    };
  },
  mounted(){
    this.scrollToBottom() 
  },
  methods: {
    showPopup(friendUserId, friendImg, friendNickName) {
      let userId = sessionStorage.getItem("userId");
      this.socket = new WebSocket(`ws://localhost:8989/api/websocket/${userId}-${friendUserId}`)
      this.socket.onmessage = event => {
        this.msgList.push(JSON.parse(event.data))
      }
      //保存数据(注意要转化对应的形式，避免字符串和整数比较，因为用的===)   
      this.userId = parseInt(userId)
      this.friendId = parseInt(friendUserId)
      this.friendImage = friendImg
      this.friendNickName = friendNickName
      //建立练习 
      this.userFriendContact(userId, friendUserId);

      this.showDialog = true;

      //设置滑轮滚动 
      this.scrollToBottom()
    },
    //关闭弹窗 
    closePopup() {
      //关闭弹窗的时候手动关闭链接 
      this.socket.close();
      this.socket = null
      this.showDialog = false;
    },
    //向父组件中发出关闭弹窗的相关请求
    giveFatherAction() {
      this.$parent.closePopupBox()
    },
    //建立联系
    userFriendContact(userId, friendId) {
      getmessage(userId, friendId).then((res) => {
        this.msgList = res.data
      })
    },

    //发送信息 
    sendInfo() {
      if (this.chatUserCommunication === '') {
        this.$message.error('发送的内容不能为空')
      } else {
        let entity = {
          from: this.userId,
          to: this.friendId,
          message: this.chatUserCommunication,
          time: new Date()
        }
        this.chatUserCommunication = ''
        this.socket.send(JSON.stringify(entity))
        this.msgList.push(entity)
        //发送完相关信息后就自动获取底部 
        this.scrollToBottom()
      }
    },
    //监听滚动到底部
    scrollToBottom() {
      console.log(123123);
      setTimeout(() => {
        let el = this.$refs["chatRoom"];
        el.scrollTop = el.scrollHeight;
      }, 30);

    }
  },
  computed: {
    //获取公共的url头 
    publicUrl() {
      return createPublicUrl()
    },
    //判断是哪一个图片
    titleImg() {
      return function (id) {
        //即使用户本人发表的交流 
        if (id === this.userId) {
          return this.userImg
        } else {
          return this.friendImage
        }
      }
    }
  }
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
    width: 640px;
    height: 560px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;

    .chatHeader {
      border-top-left-radius: 16px;
      border-top-right-radius: 16px;
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

      .chatToUserTitle {
        // margin: 0 auto
        padding-top: 25px;
        text-align: center;
        color: #ffffff;
        font-weight: 700;
        font-size: 24px;
      }
    }

    .chatMain {
      padding: 0 10px;
      height: 340px;
      overflow-y: scroll;

      .chatItem {
        margin-top: 8px;
        display: flex;
        align-items: center;
      }

      .usercommunication {
        margin-left: 10px;
        padding: 12px 0;

      }

      .reverseChatItem {
        flex-direction: row-reverse;
      }

      .reverseCommunication {
        margin-left: 0;
        margin-right: 10px;
      }



      .userImg {
        width: 48px;
        height: 48px;

        img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }

    }

    .chatBottom {
      margin-top: 10px;
      height: 80px;
      border-top: 1px solid #d1d5db;

      .chatInformationBox ::v-deep {
        .el-textarea__inner {
          border: 0;
          border-radius: 0;
          resize: none;
        }
      }

    }

    .chatSendBtn {
      display: flex;
      flex-direction: row-reverse;
      padding: 5px 0;
      height: 50px;

      button {
        margin: 0 10px;
      }
    }
  }
}
</style>
  