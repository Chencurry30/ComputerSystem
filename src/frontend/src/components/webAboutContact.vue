<!--关于联系我们的-->
<template>
  <div class="ContainBox" v-show="showDialog">
    <div class="FormBox">
      <div class="FormTitle">SEND US A MESSAGE</div>
      <div class="RtBack" @click="shutDownDialog">
        <img src="../assets/Img/Icon/delete.png" alt="" />
      </div>
      <div class="Form">
        <div class="Form-item">
          <input type="text" placeholder="Fill Your Name" />
        </div>
        <div class="Form-item">
          <input type="text" placeholder="Fill Your Email" />
        </div>
        <div class="Form-item">
          <input type="text" placeholder="Fill Your Advice" />
        </div>
        <div class="Form-item">
          <div class="Btn">Send To Advice</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "webAboutContact",
  data() {
    return {
      showDialog: false,
    };
  },
  methods: {
    Dialog(flag) {
      this.showDialog = !flag;
    },
    shutDownDialog() {
      this.$parent.ShowDialog();
    },
  },
};
</script>

<style lang="less" scoped>
.ContainBox {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #eaeaea;
  z-index: 444;
  // opacity: .5;
  .FormBox {
    position: relative;
    width: 400px;
    margin: 0 auto;
    margin-top: 100px;
    .FormTitle {
      padding: 10px 2px;
      text-align: center;
      font-weight: 700;
      font-size: 24px;
      opacity: 1;
      border-radius: 12px;
    }
    .Form-item {
      margin: 15px 0px;
      input {
        padding: 5px 25px;
        width: 100%;
        height: 40px;
        line-height: 40px;
        border-radius: 15px;
        background-color: #ffffff;
      }
      .Btn{
        margin: 5px auto;
        width: 200px;
        text-align: center;
        height: 40px;
        line-height: 40px;
        border-radius: 15px;
        background-color: #4e71f2;
      }
    }
    .RtBack {
      position: absolute;
      top: 15px;
      right: 12px;
      width: 20px;
      height: 20px;
      cursor: pointer;

      img {
        width: 100%;
      }
    }
  }
}
</style>