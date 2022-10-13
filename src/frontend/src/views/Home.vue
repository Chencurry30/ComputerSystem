<template>
  <div>
    <div>
    <router-link :to="{name:'videoPage'}">点击跳转到视屏首页</router-link>
  </div>
    <bannerFigure></bannerFigure>
    <VideoModule></VideoModule>
    <teacherModuleVue></teacherModuleVue>
  </div>
</template>



<script>
  import bannerFigure from '../components/Home/bannerFigure.vue'
  import teacherModuleVue from '../components/Home/teacherModule.vue';
  import VideoModule from '../components/Home/videoModule.vue';
  export default {
    name: "Home",
    components:{
      bannerFigure,
      teacherModuleVue,
      VideoModule
},
  data() {
    return{
      
    }
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