<template>
  <div class="breadMain w">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }" replace>首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/schoolSelect' }" replace>院校选择</el-breadcrumb-item>
      <el-breadcrumb-item>院校详情</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

</template>

<script>
export default {
  name: 'breadCrumb',
}
</script>

<style scoped lang="less">
.breadMain{
  margin-top: 25px;
}

.el-breadcrumb {
  font-size: 16px;
}
el-breadcrumb {
  font-size: large;
  margin: 35px 150px;
}
</style>
