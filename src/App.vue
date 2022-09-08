<template>
  <div id="app">
    <Header></Header>

    <router-view></router-view>
    

    <Fotter></Fotter>
  </div>
</template>

<script>

import Header from './components/webHeader.vue';
import Fotter from './components/webFotter.vue';

export default {
  name: 'App',
  components: {
    Header,
    Fotter
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
