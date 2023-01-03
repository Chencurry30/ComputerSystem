<!-- eslint-disable vue/no-duplicate-attributes -->
<template>
  <el-menu
    default-active="1-4-1"
    class="el-menu-vertical-demo"
    unique-opened
    background-color="#304156"
    text-color="#fff"
    router
    :default-active="this.$router.path"
    @select="handleSelect"
    active-text-color="#ffd04b"
    @open="handleOpen"
    @close="handleClose"
    :collapse="isCollapse"
  >

  
    <h3>{{ isCollapse ? "系统" : "考研后台系统" }}</h3>
    <!--点击首页不展示或者后期自己加一个首页页面-->
    <el-menu-item index="/homeView">
      <i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <!-- 数组index加1为组件服务，并且将num转化为string -->
    <el-submenu
      :index="(index + 1).toString()"
      v-for="(item, index) in menuList"
      :key="index"
    >
      <template slot="title">
        <span slot="title">
          <i class="el-icon-notebook-2"></i>
          {{ item.name }}
        </span>
      </template>
      <el-menu-item-group>
        <el-menu-item
          v-for="(childitem, menuaId) in item.children"
          :key="menuaId"
          :index="childitem.path"
        >
          {{ childitem.name }}
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>


<script>
export default {
  data() {
    return {
      menuList: JSON.parse(sessionStorage.getItem("menulist")),
    };
  },
  methods: {
    handleOpen() {},
    handleClose() {},
    handleSelect() {},
  },
  computed: {
    isCollapse() {
      return this.$store.state.tab.isCollapse;
    },
  },
};
</script>

<style lang="less" scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  overflow: hidden;
  width: 170px;
}
.el-menu {
  min-height: 810px;
  border: none;
  h3 {
    color: #fff;
    text-align: center;
    font-size: large;
    height: 60px;
    line-height: 60px;
  }
}
*{
  overflow: hidden;
}
</style>
