<template>
  <div id="App">
    <router-view></router-view>
  </div>
</template>

<script>
import {fnAddDynamicMenuRoutes,Routes,loadView} from './router/permission'
  export default {
    data() {
      return {
        isCollapse: true
      };
    },
    created(){
      fnAddDynamicMenuRoutes(),
      Routes(),
      loadView()
    }
  }
</script>

<style>
 #app{
  height: 100%;
 }
 *{
  margin: 0;
  padding: 0;
 }

</style>
