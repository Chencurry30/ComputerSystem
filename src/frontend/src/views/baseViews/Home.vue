<template>
    <div class="HomeBox">
      <bannerFigure></bannerFigure>
      <selectModule></selectModule>
      <VideoModule></VideoModule>
      <teacherModuleVue></teacherModuleVue>
      <appendixModule></appendixModule>
    </div>
</template>



<script>
  import bannerFigure from '../../components/mainHome/bannerFigure.vue'
  import selectModule from '../../components/mainHome/selectModule.vue'
  import teacherModuleVue from '../../components/mainHome/teacherModule.vue';
  import VideoModule from '../../components/mainHome/videoModule.vue';
  import appendixModule from '../../components/mainHome/appendixModule.vue';
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
.HomeBox{
  padding-top: 15px;
}
  </style>
