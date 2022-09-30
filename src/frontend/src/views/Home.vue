<template>
  <div>
    <bannerFigure></bannerFigure>
    <teacherModuleVue></teacherModuleVue>
  </div>
</template>



<script>
  import bannerFigure from '../components/Home/bannerFigure.vue'
  import teacherModuleVue from '../components/teacherModule.vue';
export default {
  name: "Home",
  components:{
    bannerFigure,
    teacherModuleVue
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