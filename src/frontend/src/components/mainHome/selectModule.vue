<template>
  <div class="select-item">
    <div class="item-list w">
      <div class="item-box">
        <div class="banner-nav">
            <div class="nav-titleImg centerLocation">
              <img src="../../assets/Img/Icon/video-2.png" alt="">
            </div>
            <div class="title1">热搜课程</div>
        </div>
        <div class="banner-connect">
          <ul class="banner-box">
            <li>英语</li>
            <li>数学</li>
            <li>政治</li>
            <li>计组</li>
            <li>计网</li>
          </ul>
        </div>
      </div>
      <div class="item-box">
        <div class="banner-nav">
            <div class="nav-titleImg centerLocation">
              <img src="../../assets/Img/Icon/teacher.png" alt="">
            </div>
            <div class="title1">答疑老师</div>
        </div>
        <div class="banner-connect">
          <ul class="banner-box">
            <li>英语</li>
            <li>数学</li>
            <li>政治</li>
            <li>计组</li>
            <li>计网</li>
          </ul>
        </div>
      </div>
      <div class="item-box">
        <div class="banner-nav">
            <div class="nav-titleImg centerLocation">
              <img src="../../assets/Img/Icon/poliy.png" alt="">
            </div>
            <div class="title1">专业院校</div>
        </div>
        <div class="banner-connect">
          <ul class="banner-box">
            <li>自主出题</li>
            <li>985</li>
            <li>211</li>
            <li>双一流</li>
            <li>普通本科</li>
          </ul>
        </div>
      </div>
      <div class="item-box">
        <div class="banner-nav">
            <div class="nav-titleImg centerLocation">
              <img src="../../assets/Img/Icon/course.png" alt="">
            </div>
            <div class="title1">资源下载</div>
        </div>
        <div class="banner-connect">
          <ul class="banner-box">
            <li>英语试题</li>
            <li>数学试题</li>
            <li>政治考题</li>
            <li>专业课考题</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name:'teacherModule',
  data() {
    return {};
  },
};
</script>
<style lang="less" scoped>
.select-item {
    background: #f7f7f7;
    padding: 22px 0;
  .item-list {
    display: flex;
    .item-box{
      width: 286px;
      height: 130px;
      margin-right: 18px;
      border-radius: 6px;
      background: #fff;
      overflow: hidden;
      padding: 9px 16px 16px 16px;
      .banner-nav{
            border-bottom: 1px solid #0000001a;
            display: flex;
            align-content: center;
            padding-bottom: 6px;
              .nav-titleImg{
                width: 24px;
                height: 24px;
                img{
                  width: 100%;
                }
              
            }
                          .title1{
                margin-left: 8px;
                            font-size: 15px;
              font-family: Microsoft YaHei;
              font-weight: bold;
              color: rgba(51,51,51,1);
              margin-right: 5px;
              line-height: 24px;

            } 
      }
      .banner-connect{
        .banner-box{
          width: 258px;
          height: 60px;
          display: flex;
          margin-top: 10px;
          flex-wrap: wrap;
          overflow: hidden;
          li{
                margin-right: 10px;
    margin-bottom: 10px;
            width: 66px;
    height: 25px;
    background: rgba(249,249,249,1);
    border-radius: 4px;
    font-size: 12px;
    font-family: Microsoft YaHei;
    font-weight: 400;
    color: rgba(102,102,102,1);
    line-height: 25px;
    text-align: center;
          }
        }
      }
    }
  }
}
</style>