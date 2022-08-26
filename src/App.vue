<template>
  <div id="app">
    <Header></Header>



    <Login></Login>
  </div>
</template>

<script>
import Login from './view/Login.vue';
import Header from './components/Header.vue';

export default {
  name: 'App',
  components: {
    Login,
    Header
},
  mounted(){
    console.log(this.$store);
    console.log(this.$router);
  }
}
</script>

<style>

</style>
