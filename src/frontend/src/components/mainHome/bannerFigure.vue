<template>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="(item,value) in imglist" :key="value">
            <h3 class="medium">
                <img :src="item.imgurl" alt="">
            </h3>
      </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
    name:'Lb',
    data(){
        return{
            imglist:[
                {imgurl:require('../../assets/Img/lunbo/lb1.jpg')},
                {imgurl:require('../../assets/Img/lunbo/lb2.jpg')},
                {imgurl:require('../../assets/Img/lunbo/lb3.jpg')},
                {imgurl:require('../../assets/Img/lunbo/lb4.jpg')},
                {imgurl:require('../../assets/Img/lunbo/lb5.jpg')},
                {imgurl:require('../../assets/Img/lunbo/lb3.jpg')}
            ],
        }
    }
}
</script>

<style lang="less" scoped>

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .medium img{
    height: 300px;
    width: 100%;
}
</style>