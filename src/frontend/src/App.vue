<template>
  <div id="app">

    <webHeader v-if="hiddenTopComponent"></webHeader>
    <router-view></router-view>
    <webFotter v-if="hiddenFotterComponent"></webFotter>

  </div>
</template>

<script>

import webHeader from './components/webHeader.vue';
import webFotter from './components/webFotter.vue';


export default {
  name: 'App',
  components: {
    webHeader,
    webFotter,
  },
  computed: {
    hiddenTopComponent() {
      return this.$route.meta.showTop;
    },
    hiddenFotterComponent() {
      return this.$route.meta.showFotter;
    },
  },
}

</script>

<style lang="less">
#app{
  height: 100%;
  margin: 0;
  padding: 0;
  // background: #f7f7f7;
}
</style>
