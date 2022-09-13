<template>
  <div id="app">
    
    <Login></Login>

    <router-view></router-view>
    


  </div>
</template>

<script>

import Header from './components/webHeader.vue';
import Fotter from './components/webFotter.vue';
import Login from './views/Login.vue'

export default {
  name: 'App',
  components: {
    Header,
    Fotter,
    Login
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
