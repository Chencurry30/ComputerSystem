<template>
  <div class="commonHeader">
    <div class="HeaderMain">
      <div class="Header-Main-leftBtn">
        <el-button plain icon="el-icon-menu" size="mini" @click="handleMenu"></el-button>
      </div>
      <div class="header-Title">考研后台系统</div>
      <div class="Header-Main-right">
        <el-dropdown trigger="click" size="mini">
          <span class="userImg">
            <img class="user" :src="userImg" />
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <router-link to="/person">基本信息</router-link>
            </el-dropdown-item>
            <el-dropdown-item>
              <span @click="loginout">退出</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>
<script>
import SessionStorageAction from '@/utils/SessionStorageAction';
import { logoutAdmin } from '../services/systemService'
export default {
  name: "CommonHeader",
  data() {
    return {
      userImg: require("../assets/userImg.gif"),
    };
  },

  methods: {
    handleMenu() {
      this.$store.commit("collapseMenu");
    },
    //退出登录
    loginout() {
      logoutAdmin().then((res) => {
        if (res.data.code === 200) {
          //清空本地存储,回到登录页面
          this.$message.success('退出登录成功')
          sessionStorage.removeItem("token");
          sessionStorage.removeItem("menulist");
          sessionStorage.removeItem("menuRight");
          SessionStorageAction.clearSessionStorage('bread')
          this.$router.push("/loginView");
        }
      })
    },
  },
};
</script>

<style lang="less" scoped>
.commonHeader {
  .HeaderMain {
    display: flex;
    justify-content: space-between;
    align-content: center;
    width: 100%;
    margin: 5px 0;
    .Header-Main-leftBtn {
      display: flex;
      align-items: center;
      .el-button {
        height: 36px;
        margin-left: 20px;
        margin-top: 0;
      }
    }
    .header-Title {
      letter-spacing: 10px;
      font-size: 27px;
      margin-top: 5px;
      color: #97a8be;
    }
    .Header-Main-right {
      display: flex;
      align-items: center;
      .userImg{
        margin-right: 30px;
        display: inline-block;
        width: 40px;
        height: 40px;
      }
      .user {
        width: 100%;
        height: 100%;
        border-radius: 8px;
      }
    }
  }
}
</style>