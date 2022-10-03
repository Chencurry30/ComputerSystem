<template>
  <div class="allBox">
    <div class="UserBox">
      <div class="boxbody">
        <div class="title-h">
          <span>修改绑定手机号</span>
        </div>
        <div class="muted-color">修改绑定的手机号，避免手机号不能使用</div>
        <div class="btn" @click="changePhone">修改手机号</div>
        <phonePopup ref="phonePopup"></phonePopup>
      </div>
    </div>
    <div class="UserBox">
      <div class="boxbody">
        <div class="title-h">
          <span>修改密码</span>
        </div>
        <div class="muted-color">定期修改账号密码，提高账号的安全性</div>
        <div class="btn" @click="changePassword">修改密码</div>
        <passwordPopup ref="passwordPopup"></passwordPopup>
      </div>
    </div>
  </div>
</template>

<script>
import phonePopup from "../../../components/popup/phonePopup.vue";
import passwordPopup from "../../../components/popup/passwordPopup.vue";
export default {
  components: { phonePopup, passwordPopup },
  name: "personSecurity",
  methods: {
    changePhone() {
      this.$refs.phonePopup.showPopup();
    },
    changePassword() {
      this.$refs.passwordPopup.showPopup();
    },
  },
};
</script>

<style lang='less' scoped>
.UserBox {
  margin: 18px 0;
  border-radius: 10px;
  font-size: 14px;
  color: #666;
  border: 2px solid #eee;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  .boxbody {
    padding: 15px;
    .title-h {
      padding-bottom: 8px;
      position: relative;
      span {
        font-weight: 700;
      }
      ::after {
        position: absolute;
        content: "";
        display: block;
        width: 80px;
        height: 4px;
        top: 20px;
        left: 0px;
        bottom: 3px;
        transition: 0.4s;
        background: black;
      }
    }
    .muted-color {
      margin-bottom: 20px;
      color: #999;
    }
    .btn {
      text-align: center;
      padding: 10px 15px;
      width: 300px;
      margin-right: 15px;
      margin-bottom: 10px;
      color: #5c7cff;
      background: rgba(77, 130, 249, 0.1);
      border-radius: 6px;
    }
  }
}
</style>