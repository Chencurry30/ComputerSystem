<template>
  <div id="app">
    
    <login></login>

    <router-view></router-view>
    


  </div>
</template>

<script>

import Header from './components/webHeader.vue';
import Fotter from './components/webFotter.vue';
import login from './views/login/index.vue'

export default {
  name: 'App',
  components: {
    Header,
    Fotter,
    login
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
