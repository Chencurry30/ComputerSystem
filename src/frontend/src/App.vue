<template>
  <div id="app">
    <div v-if="showHeader" class="minHeader">
      <webHeader v-if="isRouterAlive"></webHeader>
    </div>
    <router-view></router-view>
    <webFotter v-if="showFotter"></webFotter>

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
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  },
  computed: {
    showHeader() {
      return this.$route.meta.showNotFound
    },
    showFotter() {
      return this.$route.meta.showNotFound
    }
  }
}
</script>

<style lang="less">
#app {
  height: 100%;
  margin: 0;
  padding: 0;
}
// .minHeader{
//   min-width: 1080px;
// }
</style>
