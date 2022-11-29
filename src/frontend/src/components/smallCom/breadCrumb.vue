<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }" replace>首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/schoolSelect' }" replace>院校选择</el-breadcrumb-item>
      <el-breadcrumb-item>院校详情</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

</template>

<script>
export default {
    name:'breadCrumb',
}
</script>

<style scoped>
.el-breadcrumb{
  font-size: large;
  margin: 30px 20px;
}
</style>
