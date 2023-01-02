<template>
        <el-container style="height:100%">
        <el-aside width=auto>
            <Common-aside></Common-aside>
        </el-aside>
        <el-container>
        <el-header style="width:100%">
            <!--首部组件-->
            <CommonHeader></CommonHeader>
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
export default {
    name:'index',
    components:{
      CommonAside,
      CommonHeader,
    },
}
</script>

<style lang="less" scoped>
.el-header{
    background-color: #545364;
    margin-top:0;
    border: none;
}
.el-main{
   padding-top: 0; 
}
.el-card__body, .el-main{
    padding: 0;
}
</style>