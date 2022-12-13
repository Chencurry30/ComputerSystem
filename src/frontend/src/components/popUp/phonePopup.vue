<!-- 修改手机号的相关弹窗-->
<template>
  <div class="userDialog" v-show="dialogVisible" ref="phonePopup">
    <div class="DialogBox">
      <div class="DialogHeader">
        <div class="Dialogtitle">修改手机号</div>

        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>
      <div class="DialogBody">
        <div class="contentHeader">
          <el-steps :active="active" finish-status="success" :align-center="true">
            <el-step title="步骤 1"></el-step>
            <el-step title="步骤 2"></el-step>
            <el-step title="步骤 3"></el-step>
          </el-steps>
        </div>
        <div class="contentMain">
          <el-form label-width="80px" class="userInfoBox" ref="showPopupInfo" :model="showPopupInfo" :rules="checkForm">
            <div class="formBox" v-if="active === 1">
              <el-form-item label="手机号" prop="oldPhone">
                <el-input type="text" placeholder="请输入绑定的手机号" v-model.trim="showPopupInfo.oldPhone" class="nick-info">
                </el-input>
              </el-form-item>
              <el-form-item label="验证码" prop="oldSmsCode" class="smsCode">
                <el-input type="text" placeholder="验证码" v-model.trim="showPopupInfo.oldSmsCode">
                </el-input>
                <sendCodeBtn :phone="showPopupInfo.oldPhone"></sendCodeBtn>
              </el-form-item>
            </div>
            <div class="formBox" v-else-if="active === 2">
              <el-form-item label="手机号" prop="phone">
                <el-input type="text" placeholder="请输入新的手机号" v-model.trim="showPopupInfo.phone" class="nick-info">
                </el-input>
              </el-form-item>
              <el-form-item label="验证码" prop="smsCode" class="smsCode">
                <el-input type="text" placeholder="验证码" v-model.trim="showPopupInfo.smsCode">
                </el-input>
                <sendCodeBtn :phone="showPopupInfo.phone"></sendCodeBtn>
              </el-form-item>
            </div>
            <div class="formBox" v-else>
              <div class="formBoxItem">
                <div class="BoxItemTitle">解绑的手机号:</div>
                <div class="BoxItemData">{{showPopupInfo.oldPhone}}</div>
              </div>
              <div class="formBoxItem">
                <div class="BoxItemTitle">绑定的手机号:</div>
                <div class="BoxItemData">{{showPopupInfo.phone}}</div>
              </div>
              <div class="formBoxItem">
                <div class="BoxItemTitle">解绑的手机号的验证码:</div>
                <div class="BoxItemData">{{showPopupInfo.oldSmsCode}}</div>
              </div>
              <div class="formBoxItem">
                <div class="BoxItemTitle">绑定的手机号的验证码:</div>
                <div class="BoxItemData">{{showPopupInfo.smsCode}}</div>
              </div>
            </div>
          </el-form>
        </div>
        <div class="contentBottom" v-if="active === 1 || active === 2">
          <el-button style="margin: 6px 10px;" @click="preActionBtn()">上一步</el-button>
          <el-button style="margin: 6px 10px;" @click="nextActionBtn()">下一步</el-button>
        </div>
        <div class="contentBottom" v-else>
          <el-button style="margin: 6px 10px;" @click="preActionBtn()">上一步</el-button>
          <el-button style="margin: 6px 10px;" @click="sendActionData()">提交</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import sendCodeBtn from '../sendCode/sendCodeBtn.vue'
import rules from '../../utils/rules'
import {modifyPhone} from '../../service/ServersApi'
export default {
  name: "PopupWindow",
  data() {
    return {
      dialogVisible: false,
      active: 1,
      showPopupInfo: {
        oldPhone: '',
        oldSmsCode: '',
        phone: '',
        smsCode: '',
      },

      checkForm: {
        oldPhone: [
          { validator: rules.FormValidate.Form().validatePhone, trigger: 'blur' }
        ],
        phone: [
          { validator: rules.FormValidate.Form().validatePhone, trigger: 'blur' }
        ],
      },

    };
  },
  components: {
    sendCodeBtn
  },
  methods: {
    showPopup(activeId) {
      this.active = activeId
      this.dialogVisible = true;
    },
    closePopup() {
      this.dialogVisible = false
    },
    //上一步的操作 
    preActionBtn() {
      if (this.active < 2) {
        this.active = 1;
      } else {
        this.closePopup()
        this.$parent.changePhone(this.active - 1)
      }
    },
    //下一步的操作 
    nextActionBtn() {
      if (this.active > 2) {
        this.active = 3;
      } else {
        this.closePopup()
        this.$parent.changePhone(this.active + 1)
      }
    },
    //提交修改后的相关信息 
    sendActionData(){
      if(this.showPopupInfo.oldPhone === '' || this.showPopupInfo.oldSmsCode === '' || this.showPopupInfo.phone === '' || this.showPopupInfo.smsCode === ''){
        this.$message.error('请填写完完整数据后再提交')
      }else{
        modifyPhone(this.showPopupInfo).then((res)=>{
          if(res.data.code === 407){
            this.$message.error('解绑的手机号验证码错误')
          }else if(res.data.code === 200){
            this.$message.success(res.data.message)
          }
          console.log(res);
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
    width: 480px;
    height: 420px;
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
      padding: 10px 20px;
      .contentMain {
        .smsCode {
          .el-input {
            width: 60%;
          }
        }

        .formBoxItem {
          padding: 5px 50px;
          display: flex;
          align-items: center;

          .BoxItemTitle,.BoxItemData {
            text-align: right;
            vertical-align: middle;
            font-size: 16px;
            color: #606266;
            line-height: 40px;
          }
          .BoxItemData{
            margin-left: 10px;
          }
        }
      }

      .contentBottom {
        display: flex;
        justify-content: center;
        align-items: center;
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
