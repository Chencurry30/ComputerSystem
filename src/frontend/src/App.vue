<template>
  <div id="app">

    <webHeader></webHeader>
    <router-view></router-view>
    <webFotter></webFotter>

  </div>
</template>

<script>

import webHeader from './components/headerFooer/webHeader.vue';
import webFotter from './components/headerFooer/webFotter.vue';


export default {
  name: 'App',
  components: {
    webHeader,
    webFotter,
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
