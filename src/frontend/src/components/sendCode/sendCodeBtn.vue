<template>
  <div class="getVerificationCode" @click="getVerCode">
    {{ verificationCodeInfo }}
  </div>
</template>

<script>
import { retrievePassword } from "../../service/systemService"
export default {
  props: ['phone'],
  name: 'sendCodeBtn',
  data() {
    return {
      sendTimeCode: 30,      //再次发送的时间
      bVerification: false,   //节流阀，控制点击获取验证码
      verificationCodeInfo: "发送验证码",
    }
  },
  methods: {
    //发送验证码的按钮
    getVerCode() {
      if (this.phone === '') {
        return;
      }
      if (this.bVerification === true) {
        return;
      }
      this.bVerification = true;       //关闭节流阀
      let time = setInterval(() => {
        this.sendTimeCode -= 1
        this.verificationCodeInfo = `${this.sendTimeCode}秒后发送`
        if (this.sendTimeCode <= 0) {
          this.verificationCodeInfo = '发送验证码'
          this.sendTimeCode = 30   //对应的间隔时间
          clearInterval(time)
          this.bVerification = false  //打开节流阀
        }
      }, 1000)
      let phone = {
        phone: this.phone
      }
      retrievePassword(phone).then(res => {
        console.log(res.data.code);
        if (res.data.code === 414) {
          this.$message.error("手机号为空，请输入手机号")
        } else if (res.data.code === 413) {
          this.$message.error("手机号已注册，请输入新的手机号")
        } else if (res.data.code === 200) {
          this.$message({
            message: "验证码已发送，请注意查收",
            type: "success",
          })
        }
      })
    },
  }
}
</script>

<style lang="less" scoped>
.getVerificationCode {
  position: absolute;
  width: 100px;
  height: 40px;
  top: 0;
  right: 20px;
  border-radius: 4px;
  text-align: center;
  cursor: pointer;
  color: #ffffff;
  background-color: #409eff;
  z-index: 99999;
}
</style>
