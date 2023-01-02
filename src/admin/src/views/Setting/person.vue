<template>
  <div>
    <el-descriptions class="top" title="管理员基本信息" direction="vertical" :column="6" border>
      <el-descriptions-item label="用户名">web前端第二小组</el-descriptions-item>
      <el-descriptions-item label="小组成员">陈忠颖、胡建华、李国强、蔡名展、汪洋
      </el-descriptions-item>
      <el-descriptions-item label="学校" :span="1">四川师范大学</el-descriptions-item>
      <el-descriptions-item label="学院">计算机科学学院</el-descriptions-item>
      <el-descriptions-item label="评价">
        <el-rate v-model="value1" :colors="colors">
        </el-rate>
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions class="top" title="健康系统基本信息" direction="vertical" :column="6" border>
      <el-descriptions-item label="开发时间">2022/6/28</el-descriptions-item>
      <el-descriptions-item label="基本功能">注册、登录</el-descriptions-item>
      <el-descriptions-item label="系统功能">管理考研辅助系统后台数据</el-descriptions-item>
      <el-descriptions-item label="开发思路">前后端分离</el-descriptions-item>
      <el-descriptions-item label="开发周期">1学期</el-descriptions-item>
      <el-descriptions-item label="评价">
        <el-rate v-model="value2" :colors="colors">
        </el-rate>
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions class="top" title="用户角色描述" direction="vertical" :column="3" border>
      <el-descriptions-item label="管理员">可对平台所有信息进行管理，有增删改查的功能</el-descriptions-item>
    </el-descriptions>

    <el-descriptions class="top" title="产品信息" direction="vertical" :column="2" border>
      <el-descriptions-item
        label="产品介绍">计算机考研辅助系统是一款专门为考研学子服务的相关软件</el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value1: null,
      value2: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900']
    }
  }
} 
</script>

<style lang="less" scoped>
.top {
  margin-top: 20px;
  margin-left: 50px;
  margin-right: 50px;
}
</style>