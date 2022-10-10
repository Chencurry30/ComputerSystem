<template>
  <div class="MainBox">
    <div class="MainHeader">
        <SelectHeader></SelectHeader>
    </div>
    <div class="MainConnect">
        <SelectMain></SelectMain>
    </div>
  </div>
</template>

<script>
import SelectHeader from '../../components/selectBox/selectHeader.vue';
import SelectMain from '../../components/selectBox/selectMain.vue';
export default {
    name: "videoSelect",
    components: { 
        SelectHeader, 
        SelectMain 
    }
}
</script>

<style lang="less" scoped>
  .MainHeader{
    background: #f2f4f6;
  }
</style>