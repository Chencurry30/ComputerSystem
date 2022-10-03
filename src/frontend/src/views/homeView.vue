<template>
  <div>
    <!-- <Lb></Lb> -->
    <div>
      <router-link :to="{name:'personPage'}">点击跳转个人首页</router-link></div>
    <teacher-module></teacher-module>
  </div>
</template>



<script>
  // import Lb from '../components/Home/Lb.vue'
import TeacherModule from '../components/teacherModule.vue';
export default {
  name: "homeView",
  components:{
    // Lb,
    TeacherModule
  },
  data() {
    return{}
  },
};
</script>

<style scoped lang="less">
  .contain {
    position: relative;
    .mainbox {
      display: flex;

    }
  }
  </style>