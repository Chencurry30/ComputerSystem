<!-- 修改手机号的相关弹窗-->
<template>
  <div class="tab-content" v-show="dialogVisible">
    <div class="contentBox">
      <div class="header">
        <div class="tst-center">
          <div class="phoneImg">
            <img src="../../assets/Img/Icon/phone.png" alt="" />
          </div>
          <div class="p4">更改手机号</div>
        </div>
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>
      <div class="content-body">
        <div class="content-main">
          <div class="body-item">
            <div class="laber">手机号</div>
            <input type="text" class="laber-info" />
            <i class="laber-line"></i>
          </div>
          <div class="body-item">
            <div class="laber">验证码</div>
            <input type="text" class="laber-info" />
            <i class="laber-line"></i>
            <div class="getVode btn">获取验证码</div>
          </div>
          <div class="sendInfo btn" @click="closePopup">解绑手机号</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PopupWindow",
  data() {
    return {
      dialogVisible: false,
    };
  },
  methods: {
    showPopup() {
      console.log('123密码');
      this.dialogVisible = true;
    },
    closePopup(){
      this.dialogVisible = false
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
      height: 310px;
      border-radius: 16px;
      transform: translateX(-50%) translateY(-50%);
      background: #ffffff;
      .header {
        border-top-left-radius: 16px;
        border-top-right-radius: 16px;
        height: 100px;
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
        .tst-center {
          margin: 0 auto;
          padding-top: 25px;
          width: 76px;
          .phoneImg {
            margin: 0 auto;
            width: 48px;
            height: 48px;
            img {
              width: 100%;
            }
          }
        }
      }
      .content-body {
        width: 100%;
        .content-main {
          padding: 10px 20px;
          .body-item {
            margin: 10px 0px;
            display: flex;
            position: relative;
            .laber {
              position: absolute;
              top: 2px;
              left: 0px;
              width: 50px;
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
            .getVode {
              position: absolute;
              padding: 2px 5px;
              top: 20px;
              right: 0;
              color: #2997f7;
              opacity: 0.8;
              background: rgba(41, 151, 247, 0.1);
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
