<template>
  <header>
    <div class="l-content">
      <el-button plain icon="el-icon-menu" size="mini" @click="handleMenu"></el-button>
    </div>
    <h2 style="color: #fff">考研后台系统</h2>
    <div class="r-content">
      <el-dropdown trigger="click" size="mini">
        <span>
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
  </header>
</template>
<script>
import { logoutAdmin } from '../services/systemService'
export default {
  name: "CommonHeader",
  data() {
    return {
      userImg: require("../assets/header.png"),
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
          this.$router.push("/loginView");
        }
      })
    },
  },
};
</script>

<style lang="less" scoped>
header {
  display: flex;
  height: 70%;
  justify-content: space-between;
  align-content: center;
  width: 100%;
  margin-top: 10px;
  border: none;

  h2 {
    letter-spacing: 10px;
    font-size: 27px;
    margin-top: 5px;
  }
}

.l-content {
  display: flex;
  align-content: center;

  .el-button {
    margin-right: 20px;
    margin-top: 0;
  }

  h3 {
    margin-top: 10px;
  }
}

.r-content {
  .user {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    margin-top: -6px;
  }
}
</style>