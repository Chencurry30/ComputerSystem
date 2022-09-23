<template>
  <div>
    <Lb></Lb>
  </div>
</template>



<script>
  import Lb from '../components/Home/Lb.vue'
export default {
  name: "Home",
  components:{
    Lb
  },
  data() {
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