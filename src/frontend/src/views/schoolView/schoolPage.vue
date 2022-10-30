<template>
  <div class="allBox">
    <div class="header">
      <div class="headerBox clearfix w">
        <div class="school-type">
            <div class="title">学校名字</div>
            <div class="ranking">958</div>
            <div class="phone">
                <span>联系电话</span>
                <span>电话</span>
            </div>
        </div>
        <div class="school-introduce">
           <ul class="school-item1">
            <li class="first bg">学校地区</li>
            <li class="second bg">院校类别</li>
            <li class="third bg">院校的隶属</li>
           </ul>
           <div class="school-item2 bg fourth">学科建设</div>
           <div class="school-item3 bg fifth">院校排名</div>
           <div class="school-item4 bg sixth">院校地址</div>
        </div>
    </div>
    
    </div>
    <div class="connect">
      <div class="connectBox w">
      <div class="typeItem">
        <div class="ItemHeader">计算机科学与技术</div>
        <div class="ItemChild">
          <div class="childInfo">计算机系统结构</div>
          <div class="childMore">了解详情</div>
        </div>
        <div class="ItemChild">
          <div class="childInfo">计算机系统结构</div>
          <div class="childMore">了解详情</div>
        </div>
        <div class="ItemChild">
          <div class="childInfo">计算机系统结构</div>
          <div class="childMore">了解详情</div>
        </div>
      </div>
      <div class="typeItem">
        <div class="ItemHeader">计算机科学与技术</div>
        <div class="ItemChild">计算机系统结构</div>
        <div class="ItemChild">计算机软件与理论 </div>
        <div class="ItemChild">计算机应用技术</div>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
    name:'schoolPage'
}
</script>


<style lang="less" scoped>
  .allBox{

    .headerBox{
      padding: 15px 0;
      display: flex;
      align-items: center;
      justify-content: center;
        .school-type{
            float: left;
            width: 300px;
            .title{
                font-size: 26px;
                // color: #fff;
            }
            .ranking{
              display: inline-block;
              margin-top: 5px;
              padding: 0 8px;
              min-width: 49px;
              height: 21px;
              line-height: 21px;
              border-radius: 10px;
              background: #f5a500;
              font-size: 16px;
              text-align: center;
            }
            .phone{
                font-size: 16px;
                line-height: 24px;
                margin-top: 22px;
            }
        }
        .school-introduce{
            width: 620px;
            margin-right: 20px;
            float: right;
            font-size: 16px;
            .school-item1{
              height: 24px;
              line-height: 24px;
              li{
                margin-right: 15px;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
                float: left;
                padding-left: 24px;
                box-sizing: border-box;
              }
            }
            .school-item2,.school-item3,.school-item4{
              margin-top: 20px;
              padding-left: 24px;
              box-sizing: border-box;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;

            }
            .bg{
              background: url(../../assets/Img/schoolImg/iconAll.png) no-repeat;
            }
            .first{
              width: 186px;
              background-position: -5px -106px;
            }
            .second{
              width: 186px;
              background-position: -6px -4px;
            }
            .third{
              width: 186px;
              background-position: -4px -70px;
            }
            .fourth{
              width: 186px;
              background-position: -8px -38px;
            }
            .fifth{
              width: 186px;
              background-position: -6px -176px;
            }
            .sixth{
              width: 186px;
              background-position: -5px -71px;
            }
        }
    }
    .connectBox{
      margin: 10px auto;
      width: 1280px;
      background: #fff;
      padding: 1px 60px 40px;
      box-sizing: border-box;
      margin-top: 20px;
      box-shadow: 0 0 10px rgb(0 0 0 / 3%);
      .ItemHeader{
        height: 46px;
        border: 1px solid #eeeeee;
        font-size: 18px;
        color: #333;
        font-weight: 700;
        line-height: 46px;
        position: relative;
        padding-left: 19px;
        box-sizing: border-box;
        margin-top: 32px;
      }
      .ItemChild{
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-size: 16px;
    color: #999;
    margin-top: 24px;
    line-height: 18px;
        .childInfo{
          margin-left: 20px;
        }
        .childMore{
          margin-right: 20px;
          font-size: 12px;
        }
        }
    .ItemHeader::before{
        display: inline-block;
        content: "";
        width: 5px;
        height: 100%;
        background: #ff9d00;
        position: absolute;
        left: 0;
        top: 0;
    }
    }
  }
</style>