<!--修改密码的弹窗-->
<template>
  <div class="userDialog" v-show="showDialog">
    <div class="DialogBox">
      <div class="DialogHeader">

        <div class="Dialogtitle">修改密码</div>

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
                <el-form-item label="旧密码" prop="oldPassword">
                  <el-input type="text" placeholder="请输入旧密码" v-model.trim="showPopupInfo.oldPassword" class="nick-info">
                  </el-input>
                </el-form-item>
                <el-form-item label="新密码" prop="password">
                  <el-input type="text" placeholder="请输入新密码" v-model.trim="showPopupInfo.password" class="nick-info">
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
          <div class="saveBtn" @click="modifyPassWordAction()">提交</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import rules from '../../utils/rules'
import sendCodeBtn from '../sendCode/sendCodeBtn';
import { CryAlgorithm } from '../../utils/index'
import { modifyPassword } from '../../service/ServersApi'
export default {
  name: "passwordPopup",
  components: { sendCodeBtn },
  data() {
    return {
      showDialog: false,
      showPopupInfo: {
        oldPassword: '',
        password: '',
        phone: '',
        smsCode: '',
      },
      checkForm: {
        //密码验证
        password: [
          { validator: rules.FormValidate.Form().validatePassWord, trigger: 'blur' }
        ],
        oldPassword: [
          { validator: rules.FormValidate.Form().validatePassWord, trigger: 'blur' }
        ],
        phone: [
          { validator: rules.FormValidate.Form().validatePhone, trigger: 'blur' }
        ],
      },

    };
  },

  methods: {
    showPopup() {
      this.showDialog = true;
    },
    closePopup() {
      this.showDialog = false;
    },
    getPublicKey() {
      this.$store.dispatch('encryption/getPubKey');
    },
    //修改密码
    modifyPassWordAction() {
      this.getPublicKey()
      setTimeout(() => {
        let data = {}
        data.oldPassword = CryAlgorithm(this.getkeyInfo.encryPtion, this.showPopupInfo.oldPassword)
        data.password = CryAlgorithm(this.getkeyInfo.encryPtion, this.showPopupInfo.password)
        data.phone = this.showPopupInfo.phone
        data.smsCode = this.showPopupInfo.smsCode
        data.uuId = this.getkeyInfo.uuId
        modifyPassword(data).then((res) => {
          if(res.data.code === 200){
            this.$message.success('修改密码成功')
            this.showDialog = true;
          }else if(res.data.code === 406){
            this.$message.error('原密码错误')
          }else if(res.data.code === 407){
            this.$message.error('手机验证码错误')
          }
          console.log(res);
        })
      }, 1500)
    }
  },
  computed: {
    ...mapGetters('encryption', {
      getkeyInfo: 'getkeyInfo'
    })
  }
};
</script>

<style lang="less" scoped>
.userDialog {
  .DialogBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 420px;
    height: 380px;
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
  
