<template>
  <div id="app">

    <webHeader v-if="isRouterAlive"></webHeader>
    <router-view></router-view>
    <webFotter></webFotter>

  </div>
</template>

<script>

import webHeader from './components/headerFooer/webHeader.vue';
import webFotter from './components/headerFooer/webFotter.vue';


export default {
  name: 'App',
  provide() { // 父组件中返回要传给下级的数据
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  components: {
    webHeader,
    webFotter,
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
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
