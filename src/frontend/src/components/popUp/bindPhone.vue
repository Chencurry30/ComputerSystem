<!--修改密码的弹窗-->
<template>
  <div class="userDialog" v-show="showDialog">
    <div class="DialogBox">
      <div class="DialogHeader">
        <div class="Dialogtitle">绑定手机号</div>
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>
      <div class="DialogBody">
        <div class="content-main">
          <el-form label-width="80px" class="userInfoBox" ref="showPopupInfo" :model="showPopupInfo" :rules="checkForm">
            <div class="formBox">
              <div class="formLeft">
                <el-form-item label="手机号" prop="phone">
                  <el-input type="text" placeholder="请输入手机号" v-model.trim="showPopupInfo.phone" class="nick-info">
                  </el-input>
                </el-form-item>
                <el-form-item label="验证码" prop="smsCode" class="smsCode">
                  <el-input type="text" placeholder="验证码" v-model.trim="showPopupInfo.smsCode">
                  </el-input>
                  <sendCodeBtn :phone="showPopupInfo.phone"></sendCodeBtn>
                </el-form-item>
              </div>
            </div>
          </el-form>
          <div class="saveBtn" @click="modifyPhoneAction()">绑定手机号</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import rules from '../../utils/rules'
import sendCodeBtn from '../sendCode/sendCodeBtn';
import { bindUserPhone } from '../../service/ServersApi'
export default {
  name: "bindPhone",
  components: { sendCodeBtn },
  data() {
    return {
      showDialog: false,
      showPopupInfo: {
        phone: '',
        smsCode: '',
      },
      checkForm: {
        phone: [
          { validator: rules.FormValidate.Form().validatePhone, trigger: 'blur' }
        ],
      },

    };
  },

  methods: {
    showPopup() {
      this.showDialog = true;
      console.log('我是绑定手机号的弹窗');
    },
    closePopup() {
      this.showDialog = false;
    },
    getPublicKey() {
      this.$store.dispatch('encryption/getPubKey');
    },
    //修改密码
    modifyPhoneAction() {
      if (this.showPopupInfo.phone === '') {
        this.$message.error('请输入绑定的手机号')
      } else {
        bindUserPhone(this.showPopupInfo).then((res) => {
          if(res.data.code === 200){
            this.$message.success('绑定成功')
            this.showDialog = false;
          }else if(res.data.code === 407){
            this.$message.error('手机验证码错误')
          }
        })
      }
    }
  },
};
</script>

<style lang="less" scoped>
.userDialog {
  .DialogBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 420px;
    height: 280px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;

    .DialogHeader {
      .closeImg {
        img {
          width: 100%;
        }
      }
    }

    .DialogBody {
      width: 100%;

      .content-main {
        padding: 10px 20px;

        .smsCode {
          .el-input {
            width: 60%;
          }
        }

      }
    }
  }
}

:deep .el-input__inner {
  border: 0;
  outline: 0;
}

.el-form-item {
  margin-bottom: 10px;
}

.el-select {
  width: 100%;
  display: inline-block;
  position: relative;
}

:deep .el-form-item__error {
  position: absolute;
  padding: 3px 0;
  top: 75%;
  left: 0;
  color: #F56C6C;
  font-size: 12px;
}

:deep .el-form-item__label {
  padding: 0;
}
</style>
  
