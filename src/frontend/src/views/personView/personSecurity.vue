//用户安全
<template>
  <div class="MainBox w MainPageHeader">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <personHeader></personHeader>
        <div class="UserBox">
          <div class="boxbody">
            <div class="title-h">
              <span>修改绑定手机号</span>
            </div>
            <div class="muted-color">修改绑定的手机号，避免手机号不能使用</div>
            <div class="btn" @click="changePhone(1)">修改手机号</div>
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
    </div>
  </div>

</template>

<script>
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import phonePopup from "../../components/popUp/phonePopup.vue";
import passwordPopup from "../../components/popUp/passwordPopup.vue";
export default {
  components: { phonePopup, passwordPopup, personAside, personHeader },
  name: "personSecurity",
  //避免页面刷新导致vuex中的数据丢失
  mounted() {
    this.$store.dispatch('userInfo/getUserInfo')
  },
  methods: {
    changePhone(activeId) {
      this.$refs.phonePopup.showPopup(activeId);
    },
    changePassword() {
      this.$refs.passwordPopup.showPopup();
    },
  },
};
</script>

<style lang='less' scoped>
.MainBox {

  .containBox {

    display: flex;


    .contain-right {
      flex: 3;
    }
  }
}

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
        left: 0;
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
