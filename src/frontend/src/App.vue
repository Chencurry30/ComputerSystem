<template>
  <div id="app">

    <webHeader v-if="hiddenComponent"></webHeader>
    <router-view></router-view>
    <webFotter v-if="hiddenComponent"></webFotter>

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
    hiddenComponent() {
      return this.$route.meta.showTopFotter;
    },
  },
}

</script>

<style lang="less">
#app{
  height: 100%;
  margin: 0;
  padding: 0;
}
</style>
