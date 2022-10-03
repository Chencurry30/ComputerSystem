<template>
  <div class="tab-content" v-show="showDialog">
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
            <div class="laber">新密码</div>
            <input type="text" class="laber-info" />
            <i class="laber-line"></i>
          </div>
          <div class="body-item">
            <div class="laber">验证码</div>
            <input type="text" class="laber-info" />
            <i class="laber-line"></i>
            <div class="getVode btn">获取验证码</div>
          </div>
          <div class="sendInfo btn" @click="closePopup">修改密码</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "passwordPopup",
  data() {
    return {
      showDialog: false,
    };
  },
  methods: {
    showPopup() {
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
  .header {
    border-top-left-radius: 16px;
    border-top-right-radius: 16px;
    height: 100px;
    background: #f59f54;
  }
  .contentBox {
    height: 380px;
  }
}
</style>
