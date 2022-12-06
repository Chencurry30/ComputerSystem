<!--修改用户的相关信息-->
<template>
  <div class="userDialog" v-show="showDialog">
    <div class="DialogBox">
      <div class="DialogHeader">
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
        <div class="Dialogtitle centerLocation">个人信息</div>
      </div>
      <div class="DialogBody">
        <div class="content-main">
          <el-form label-width="80px" class="userInfoBox" ref="showPopupInfo" :model="showPopupInfo" :rules="checkForm">
            <div class="formBox">
              <div class="formLeft">
                <el-form-item label="用户名">
                  <span class="notAllowed">{{ showPopupInfo.username }}</span>
                </el-form-item>
                <el-form-item label="昵称" prop="nickname">
                  <el-input type="text" placeholder="请输入账号" v-model.trim="showPopupInfo.nickname" class="nick-info">
                  </el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                  <el-input type="text" placeholder="请输入邮箱号码" v-model.trim="showPopupInfo.email">
                  </el-input>
                </el-form-item>
              </div>
              <div class="formRight">
                <el-form-item label="手机号">
                  <span class="notAllowed">{{ showPopupInfo.phone }}</span>
                </el-form-item>
                <el-form-item label="年龄" prop="age">
                  <el-input type="text" placeholder="请输入账号" v-model.trim="showPopupInfo.age">
                  </el-input>
                </el-form-item>
                <el-form-item label="性别">
                  <el-select type="text" placeholder="请选择性别" v-model.trim="showPopupInfo.sex">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                    <el-option label="保密" value="保密"></el-option>
                  </el-select>
                </el-form-item>

              </div>
            </div>

            <el-form-item label="个人留言" prop="message" class="personMessage">
              <el-input type="text" placeholder="请输入留言" v-model.trim="showPopupInfo.message">
              </el-input>
            </el-form-item>


          </el-form>
          <div class="saveBtn" @click="sendInfo(showPopupInfo)">提交</div>
        </div>
      </div>
    </div>
  </div>
</template>
  
<script>
import { mapGetters } from 'vuex'
import rules from '../../utils/rules'
export default {
  name: "InfoPopup",
  //App中传入的一个相关的方法,用于帮助进行页面刷新 
  inject: ['reload'],
  data() {
    return {
      showDialog: false,
      showPopupInfo: {},

      checkForm: {
        //邮箱验证
        email: [
          { validator: rules.FormValidate.Form().validateEmail, trigger: 'blur' }
        ],
        //年龄验证
        age: [
          { validator: rules.FormValidate.Form().validataAge, trigger: 'blur' }
        ],
        //昵称验证 
        nickname: [
          { validator: rules.FormValidate.Form().validateNickName, trigger: 'blur' }
        ],
        //留言验证 
        message: [
          { validator: rules.FormValidate.Form().validatePersonalMessage, trigger: 'blur' }
        ]

      },
    };
  },
  methods: {
    showPopup(value) {
      this.showPopupInfo = JSON.parse(JSON.stringify(value));
      this.showDialog = true;
    },
    closePopup() {
      this.showDialog = false;
    },
    sendInfo() {

      this.$refs.showPopupInfo.validate((valid) => {

        // 验证通过提交信息
        if (valid) {
          console.log('数据符合要求');
          this.$store.dispatch('userInfo/changeUserInfo', this.showPopupInfo)
          this.$message({
            message: "修改个人信息成功",
            type: "success",
          })
          sessionStorage.setItem('nickname',this.showPopupInfo.nickname)
          this.reload()
          this.closePopup()

        } else {
          this.$message({
            message: "请按照相关提示修改后再提交",
            type: "error",
          })
        }
      })

    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  computed: {
    ...mapGetters('userInfo',
      {
        getUserInfo: 'getUserInfo',
      }),
  }
};
</script>
  
<style lang="less" scoped>
.userDialog {
  .DialogBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 600px;
    height: 440px;
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

        .userInfoBox {
          .formBox {
            display: flex;
            justify-content: center;
          }
        }

        .notAllowed {
          padding: 0 15px;
        }

        .personMessage {
          display: block;
          width: 100%;
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
  