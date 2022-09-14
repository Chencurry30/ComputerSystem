<template>
  <div id="app">
<<<<<<< HEAD
    <Header v-if="showHeader"></Header>
=======
    
    <Login></Login>

>>>>>>> 9653537358bac4cf83bb9dae6f4926530fe41234
    <router-view></router-view>
    <Fotter v-if="showFotter"></Fotter>

  </div>
</template>

<script>

import Header from './components/webHeader.vue';
import Fotter from './components/webFotter.vue';
<<<<<<< HEAD

=======
import Login from './views/Login.vue'
>>>>>>> 9653537358bac4cf83bb9dae6f4926530fe41234

export default {
  name: 'App',
  components: {
    Header,
    Fotter,
<<<<<<< HEAD
  },
  computed:{
    showHeader(){
      return this.$route.name !== 'loginView'
    },
    showFotter(){
      return this.$route.name !== 'loginView'
    }

  },
=======
    Login
},

>>>>>>> 9653537358bac4cf83bb9dae6f4926530fe41234
}
</script>

<style lang="less">
#app{
  height: 100%;
  margin: 0;
  padding: 0;
}
</style>
