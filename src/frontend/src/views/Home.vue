<template>
  <div>
    <bannerFigure></bannerFigure>
    <selectModule></selectModule>
    <VideoModule></VideoModule>
    <teacherModuleVue></teacherModuleVue>
    <appendixModule></appendixModule>
  </div>
</template>



<script>
  import bannerFigure from '../components/Home/bannerFigure.vue'
  import selectModule from '../components/Home/selectModule.vue'
  import teacherModuleVue from '../components/Home/teacherModule.vue';
  import VideoModule from '../components/Home/videoModule.vue';
  import appendixModule from '../components/Home/appendixModule.vue';
  export default {
    name: "Home",
    components:{
      bannerFigure,
      teacherModuleVue,
      VideoModule,
      selectModule,
      appendixModule
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