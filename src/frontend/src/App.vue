<template>
  <div id="app">
    <Header v-if="showHeader"></Header>
    <router-view></router-view>
    <Fotter v-if="showFotter"></Fotter>

  </div>
</template>

<script>

import Header from './components/webHeader.vue';
import Fotter from './components/webFotter.vue';


export default {
  name: 'App',
  components: {
    Header,
    Fotter,
  },
  computed:{
    showHeader(){
      return this.$route.name !== 'loginView'
    },
    showFotter(){
      return this.$route.name !== 'loginView'
    }

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
