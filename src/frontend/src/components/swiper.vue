<!--轮播图的相关组件-->
<template>
  <div class="swiper" style='overflow: hidden;text-align:center'>
    <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
          <div class="schoolItem">
              <img src="../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
          </div>
        </div>
    </div>
    <!-- 如果需要分页器 -->
    <div class="swiper-pagination"></div>
    <!-- 如果需要导航按钮 -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>
</template>

<script>
import Swiper from 'swiper'
export default {
    name:'swiper',
    mounted(){
  //    new Swiper('.swiper', {
  //   // direction: 'vertical', // 垂直切换选项
  //   loop: false, // 循环模式选项
  //   autoplay:true,
  //   // 如果需要分页器
  //   pagination: {
  //     el: '.swiper-pagination',
  //     clickable :true,
  //   },
  //   // 如果需要前进后退按钮
  //   navigation: {
  //     nextEl: '.swiper-button-next',
  //     prevEl: '.swiper-button-prev',
  //   },
  // }) 
  }
}
</script>

<style scoped lang="less">
  .swiper{
    .swiper-slide{
      margin: 10px 0;
          .schoolItem{
            margin: 0 12px;
            float: left;
            display: flex;
            flex-direction: column;
            .schoolImg{
              width: 44px;
              height: 44px;
            }
            .schoolInfo{
              height: 20px;
              line-height: 20px;
              font-size: 12px;
              color: #333;
              text-align: center;
            }
          }
        }
  }
</style>