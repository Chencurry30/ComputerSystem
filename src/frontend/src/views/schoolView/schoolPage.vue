<template>
  <div class="allBox">
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
    <div class="connectBox"></div>
  </div>
</template>

<script>
export default {
    name:'schoolPage'
}
</script>


<style lang="less" scoped>
  .allBox{
    background: rgba(0, 0, 0, .2);
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
      width: 880px;
    background: #fff;
    padding: 1px 32px 40px;
    box-sizing: border-box;
    margin-top: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0,.03);
    }
  }
</style>