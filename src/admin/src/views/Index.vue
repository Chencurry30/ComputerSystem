<template>
  <el-container style="height:100%">
    <!--侧边栏-->
    <el-aside width=auto>
      <Common-aside></Common-aside>
    </el-aside>
    <!--右边核心区域-->
    <el-container>
      <!--头部的相关高度-->
      <el-header>
        <!--首部组件-->
        <CommonHeader></CommonHeader>
        <!--面包屑组件-->
        <div class="HeaderBread">
          <BreadCrumb></BreadCrumb>
        </div>
      </el-header>

      <el-main>
        <!--路由出口,展示路由组件-->
        <router-view></router-view>
      </el-main>


    </el-container>
  </el-container>
</template>

<script>
import CommonAside from '../components/CommonAside';
import CommonHeader from '../components/CommonHeader';
import BreadCrumb from '../components/Breadcrumb/BreadCrumb'      //面包屑
export default {
  name: 'index',
  components: {
    CommonAside,
    CommonHeader,
    BreadCrumb,
  },
}
</script>

<style lang="less" scoped>
.HeaderBread {
  width: 100%;
  height: 38px;
  background: #fff;
  border-bottom: 1px solid #d8dce5;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 0 3px 0 rgba(0, 0, 0, 0.04);
}








.el-aside {
  background-color: #304156;
}

.el-header {
  margin-top: 0;
  padding: 0;
  height:auto !important;  //让高度靠自己填充
  border: none;
  background-color: #fff;;
}

.el-main {
  padding-top: 0;
}

.el-card__body,
.el-main {
  padding: 0;
}
</style>