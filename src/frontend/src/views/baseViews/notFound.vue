<!--404页面-->
<template>
<div class="notFoundMain">
  <div class="notFoundHeader">
    <img src="../../assets/Img/notfound/notFound.png" alt="">
  </div>
  <div class="notFoundBox">
    <div class="notFoundTitle">抱歉,页面无法访问</div>
    <div class="notFoundInfo">可能原因：网址有错误 > 请检查地址是否完整或存在多余字符；
      网址已失效 > 可能页面已删除 或者 活动已下线等  数据丢失 > 页面数据可能丢失，请稍后再试</div>
    <div class="backHomeBtn" @click="backHome">返回首页</div>
  </div>
</div>
</template>

<script>
export default {
  name: "notFound",
  methods:{
    backHome(){
      let location = {
        name:'Home'
      }
      this.$router.push(location)

    }
  }
}
</script>

<style scoped lang="less">
.notFoundMain{
  margin: 10px auto;
  width: 800px;
}
.notFoundHeader{
  margin: 50px auto 10px;
  width: 400px;
  img{
    width: 100%;
  }
}
.notFoundBox{
  .notFoundTitle{
    margin: 15px auto 5px;
    height: 48px;
    text-align: center;
    font-size: 36px;
    color: #181818;
    line-height: 48px;
  }
  .notFoundInfo{
    margin-top: 10px;
    height: 48px;
    text-align: center;
    font-size: 14px;
    color: #3d3d3d;
    line-height: 24px;
  }
  .backHomeBtn{
    margin: 10px auto;
    width: 140px;
    background-color: #ff6a00;
    padding: 0 24px;
    height: 32px;
    line-height: 32px;
    font-size: 14px;
    text-align: center;
    color: #ffffff;
    cursor: pointer;
  }
}

</style>