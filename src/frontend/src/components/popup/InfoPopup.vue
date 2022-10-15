<!--修改用户的相关信息-->
<template>
    <div class="tab-content" v-show="showDialog">
      <div class="contentBox">
        <div class="header">
          <div class="closeImg" @click="closePopup">
            <img src="../../assets/Img/Icon/close.png" alt="" />
          </div>
          <div class="title centerLocation">个人信息</div>
        </div>
        <div class="content-body">
          <div class="content-main">
            <div class="body-item">
              <div class="laber">昵称:</div>
              <input class="nick-info"/>
            </div>
            <div class="body-item">
              <div class="laber">邮箱:</div>
              <input class="nick-info"/>
            </div>
            <div class="body-item">
              <div class="laber">年龄:</div>
              <input class="nick-info"/>
            </div>
            <div class="body-item">
              <div class="laber">性别:</div>
              <input class="nick-info"/>
            </div>
            <div class="body-item">
              <div class="laber">隐私设置:</div>
              <input class="nick-info"/>
            </div>
            <div class="body-item">
              <div class="laber">个人留言:</div>
              <input class="nick-info"/>
            </div>
            <div class="sendInfo btn" @click="closePopup">关闭</div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "InfoPopup",
    data() {
      return {
        showDialog: false,
        replyshow: {},
      };
    },
    methods: {
      showPopup(replyInfo) {
        this.replyshow = replyInfo;
        this.showDialog = true;
      },
      closePopup() {
        this.showDialog = false;
      },
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
    .contentBox {
      position: relative;
      top: 50%;
      left: 50%;
      width: 400px;
      height: 390px;
      border-radius: 16px;
      transform: translateX(-50%) translateY(-50%);
      background: #ffffff;
      .header {
        border-top-left-radius: 16px;
        border-top-right-radius: 16px;
        display: flex;
        justify-content: center;
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
        .title{
          font-size: 18px;
          font-weight: 700;
          line-height: 80px;
        }
      }
      .content-body {
        width: 100%;
        .content-main {
          padding: 10px 20px;
          .body-item {
            margin: 10px 0px;
            display: flex;
            .laber {
              margin-right: 10px;
              width: 70px;
              font-size: 14px;
            }
            .nick-info {
              padding: 0px 15px;
              width: 90%;
              height: 22px;
              border: 0;
              outline: none 
            }
            .nick-info:focus{
              border-bottom: 1px solid #666;
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
  