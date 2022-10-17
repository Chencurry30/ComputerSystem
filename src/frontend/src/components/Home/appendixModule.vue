<template>
  <div class="appendix-item w">
    <div class="title">
      <div class="titleInfo">备考资源</div>
    </div>
    <div class="item-list">
      <div class="list-connect">


        <div class="list-left">
          <div class="title1">院校推荐</div>
          <div class="title2">推荐相关热门院校</div>
          <div class="itemBox clearfix">
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
            <div class="schoolItem">
              <img src="../../assets/Img/schoolImg/2020100.jpg" alt="四川大学" class="schoolImg centerLocation">
              <div class="schoolInfo">四川大学</div>
            </div>
          </div>
          <div class="title3">服务专区</div>
          <div class="itemBox clearfix">
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
            <div class="serviceItem">
              <img src="../../assets/Img/Icon/fuwu-1.png" alt="" class="serviceImg">
              <span class="serviceInfo">师资库</span>
            </div>
          
          
          </div>
          <div class="title4">相关指南</div>

        </div>

        <div class="list-middle">2</div>

        <div class="list-right">
          <div class="title1">34所自主划线</div>
          <div class="itemBox clearfix">
              <Swiper></Swiper>
          </div>
          <div class="title2">院校地区</div>
          <div class="itemBox">
            <dl>
              <dt>一区</dt>
              <dd>北京</dd>
              <dd>天津</dd>
              <dd class="first">上海</dd>
              <dd>江苏</dd>
              <dd>更多</dd>
              <dt>二区</dt>
              <dd>广西</dd>
              <dd>海南</dd>
              <dd class="first">贵州</dd>
              <dd>云南</dd>
              <dd>更多</dd>
              <dt>三区</dt>
              <dd>新疆</dd>
              <dd>西藏</dd>
              <dd class="first">甘肃</dd>
              <dd>青海</dd>
              <dd>更多</dd>
            </dl>
          </div>




        </div>

      </div>
    </div>
  </div>
</template>

<script>
import Swiper from '../swiper.vue';
export default {
    name: "appendixModule",
    components: { Swiper }
}
</script>

<style lang="less" scoped>
.appendix-item{
  background: #fff;
  .title {
    display: flex;
    height: 30px;
    line-height: 30px;
      .titleInfo {
        margin-left: 3px;
        padding-left: 8px;
        border-left: 4px solid #4e71f2;
        font-size: 24px;
        font-weight: 700;
        color: #333;
      }
    
  }
  .item-list{
    padding: 25px 15px;
    .list-connect{
      display: flex;
      .list-left{
        padding: 0 11px;
        width: 285px;
        .title1,.title3,.title4{
          height: 18px;
          line-height: 18px;
          padding-left: 9px;
          border-left: solid 4px #4e71f2;
          font-size: 16px;
          color: #333333;
          font-weight: 700;
        }
        .title2{
          font-size: 12px;
          color: #666;
          margin-top: 7px;
        }
        .title3,.title4{
          margin-top: 26px;
        }
        .itemBox{
          margin: 5px auto;
          .schoolItem{
            margin: 0 9px;
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
          .serviceItem{
            height: 20px;
    line-height: 20px;
    padding-left: 0px;
    font-size: 14px;
    color: #333333;
    float: left;
    margin-left: 10px;
    margin-top: 10px;
            .serviceImg{
              width: 20px;
              height: 20px;
            }
            .serviceInfo{
              margin-left: 5px;
            }
          }
          .tl-title{
            margin-left: 5px;
            height: 20px;
            line-height: 20px;
            font-size: 14px;
            color: #FF9D00;
          }
          .tl-info{
            margin: 4px 0px 4px 10px;
            font-size: 14px;
            color: #333333;
          }
        }
      }

      .list-middle{
        flex: 1;
      }
      .list-right{
        width: 214px;
        height: 496px;

        .title1,.title2{
          height: 18px;
          line-height: 18px;
          padding-left: 9px;
          border-left: solid 4px #4e71f2;
          font-size: 16px;
          color: #333333;
          font-weight: 700;
        }
        .itemBox{
          margin: 5px auto;
          dt,dd{
            margin-top: 10px;
            float: left;
            width: 64px;
            text-align: center;
            height: 26px;
            line-height: 26px;
            font-size: 14px;
            border-radius: 45px;
          }
          dt{
            color: #fff;
            background-color: #FF9D00;
          }
          dd{
            margin-left: 10px;
            color: #333;
            border: solid 1px #EDEDED;
          }
        }
      }
    }
  }
}
</style>