<!--修改用户的相关信息-->
<template>
  <div class="tab-content" v-show="showDialog">
    <div class="contentBox">
      <div class="header">
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
        <div class="title centerLocation">个人信息</div>
      </div>
      <div class="content-body">
        <div class="content-main">
          <el-form label-width="80px" class="login_in" ref="showPopupInfo" :model="showPopupInfo"
            :rules="showPopupInfo">

            <div class="form-info">
              <el-form-item label="用户名">
                <span class="notallowed">{{ showPopupInfo.username }}</span>
              </el-form-item>
              <el-form-item label="昵称">
                <el-input type="text" placeholder="请输入账号" v-model.trim="showPopupInfo.nickname" class="nick-info">
                </el-input>
              </el-form-item>
              <el-form-item label="手机号">
                <span class="notallowed">{{ showPopupInfo.phone }}</span>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input type="text" placeholder="请输入邮箱号码" v-model.trim="showPopupInfo.email">
                </el-input>
              </el-form-item>
              <el-form-item label="年龄">
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
              <el-form-item label="隐私设置">
                <el-select type="text" placeholder="请选择性别" v-model.trim="showPopupInfo.isHide">
                  <el-option label="用户均可见" value="0"></el-option>
                  <el-option label="用户均不可见" value="1"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="个人留言">
                <el-input type="text" placeholder="请输入留言" v-model.trim="showPopupInfo.message">
                </el-input>
              </el-form-item>
              </div>
          </el-form>

          <div class="sendInfo" @click="sendInfo">提交</div>
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
  data() {
    return {
      showDialog: false,
      showPopupInfo: {},
      checkForm: {
        //用户名校验
        username: [
          { validator: rules.FormValidate.Form().validateUserName, trigger: 'blur' },
        ],
        //密码校验
        password: [
          { validator: rules.FormValidate.Form().validatePassWord, trigger: 'blur' }
        ],
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
      this.$store.dispatch('userInfo/changeUserInfo', this.showPopupInfo)
      this.closePopup()
    }
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
.tab-content {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  overflow: auto;
  margin: 0;
  background: rgba(0, 0, 0, 0.5);

  .contentBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 400px;
    height: 540px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;

    .header {
      border-top-left-radius: 16px;
      border-top-right-radius: 16px;
      display: flex;
      justify-content: center;
      height: 80px;
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

      .title {
        font-size: 18px;
        font-weight: 700;
        line-height: 80px;
      }
    }

    .content-body {
      width: 100%;

      .content-main {
        padding: 10px 20px;

        .notallowed {
          padding: 0 15px;
        }


        .body-item {
          margin: 10px 0px;
          display: flex;

          .laber {
            margin-right: 10px;
            width: 70px;
            font-size: 14px;
          }

          .nick-info {
            padding: 0px 15px;
            width: 90%;
            height: 22px;
            border: 0;
            outline: none
          }

          .nick-info:focus {
            border-bottom: 1px solid #666;
          }
        }

        .sendInfo {
          padding: 10px 5px;
          text-align: center;
          border-radius: 8px;
          background: #59c3fb;
          color: #fff;
        }
      }
    }
  }
}


/deep/.el-input__inner {
  border: 0;
  outline: 0;
}

.el-form-item {
  margin-bottom: 0px;
}
</style>
  