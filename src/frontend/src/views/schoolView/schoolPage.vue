<template>
  <div class="allBox">
    <div class="header">
      <div class="headerBox clearfix w">
        <div class="school-type">
          <div class="school-type-header">
            <div class="title">{{ schoolInfo.name }}</div>
            <div class="ranking">{{ schoolInfo.attribute }}</div>
          </div>
          <div class="phone">
            <span>联系电话</span>
            <span>{{ schoolInfo.phone }}</span>
          </div>
        </div>
        <div class="school-introduce">
          <ul class="school-item1">
            <li class="first bg">地区：{{ schoolInfo.region }}</li>
            <li class="second bg">类别：{{ schoolInfo.type }}</li>
            <li class="third bg">隶属：{{ schoolInfo.subjection }}</li>
          </ul>
          <div class="school-item4 bg fourth">院校邮箱：{{ schoolInfo.mail }}</div>
          <div class="school-item4 bg fifth">院校官网：{{ schoolInfo.web }}</div>
          <div class="school-item4 bg sixth">院校地址：{{ schoolInfo.address }}</div>
        </div>
      </div>

    </div>
    <div class="connect w">
      <div class="column-title">
        <h3>院校概况</h3>
        <div class="title-border"></div>
      </div>
      <h2 class="big-title">院校简介</h2>
      <div class="column-title-left">
        <div class="column-title-left-header">
          <h3>院校历史</h3>
          <div @click="hex">
            <a href="javascript:;" class="rightLink">展开全部</a>
          </div>
        </div>
        <div class="schoolIntroduce" :class="{ showHeight: first }">
          {{schoolInfo.introduction}}
        </div>
      </div>


      <h2 class="big-title">专业简介</h2>
      <div class="column-title-left">
        <div class="column-title-left-header">
          <h3>硕士专业</h3>
        </div>
        <div class="tab-header clearfix">
          <div class="tab-item" :class="{ selected: countIndex === item.id }" v-for="(item) in collegeList" :key="item.id
          " @click="selectItem(item.id)">
            <a href="javascript:;">{{ item.name }}</a>
          </div>
        </div>
        <div class="tab-connect">
          <div class="item-connect">
            <ul class="clearfix">
              <li>高等教育学[专业的编号]</li>
              <li>教育技术学[专业的编号]</li>
            </ul>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import { getschoolInfo } from '../../service/schoolService'
export default {
  name: 'schoolPage',
  data() {
    return {
      schoolInfo: {},
      first: false,
      collegeList: [
        {
          id: 0,
          name: '教育学'
        },
        {
          id: 12350,
          name: '工学'
        },
        {
          id: 1235089,
          name: '理学'
        }
      ],
      countIndex: 0,
    }
  },
  mounted() {

    //获取具体院校相关的信息
    this.getSchool()
  },
  methods: {
    //获取具体院校相关的信息
    getSchool(){
      let collegeId = this.$route.query.collegeId
      getschoolInfo(collegeId).then((res) => {
      this.schoolInfo = res.data.data
      console.log(res);
      })
    },







    hex() {
      this.first = !this.first
    },
    selectItem(id) {
      this.countIndex = id
    }
  }
}
</script>
<style lang="less" scoped>
.allBox {
  .header {
    width: 100%;
    background: #add9fc url(../../assets/Img/schoolImg/zx-bg.jpg) 50% 0 no-repeat;
    .headerBox {
      padding: 15px 0;
      display: flex;
      align-items: center;
      justify-content: center;

      .school-type {
        float: left;
        width: 300px;

        .school-type-header {
          display: flex;
          align-items: center;
          margin: 15px 0px 15px 0;
          .title {
            font-size: 26px;
          }
          .ranking {
            display: inline-block;
            margin: 5px 10px;
            padding: 0 8px;
            min-width: 49px;
            height: 21px;
            line-height: 21px;
            border-radius: 10px;
            background: #f5a500;
            font-size: 16px;
            text-align: center;
          }
        }
        .phone {
          font-size: 16px;
          line-height: 24px;
          margin-top: 5px;
        }
      }
      .school-introduce {
        width: 620px;
        margin-right: 20px;
        float: right;
        font-size: 16px;

        .school-item1 {
          height: 24px;
          line-height: 24px;

          li {
            margin-right: 15px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            float: left;
            padding-left: 24px;
            box-sizing: border-box;
          }
        }

        .school-item2,
        .school-item3,
        .school-item4 {
          margin-top: 20px;
          padding-left: 24px;
          box-sizing: border-box;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;

        }

        .bg {
          background: url(../../assets/Img/schoolImg/iconAll.png) no-repeat;
        }

        .first {
          width: 186px;
          background-position: -5px -106px;
        }

        .second {
          width: 186px;
          background-position: -6px -4px;
        }

        .third {
          width: 186px;
          background-position: -4px -70px;
        }

        .fourth {
          width: 380px;
          background-position: -8px -38px;
        }

        .fifth {
          background-position: -6px -176px;
        }

        .sixth {
          width: 370px;
          background-position: -5px -71px;
        }
      }
    }
  }
  .connect {
    margin-top: 20px;

    .column-title {
      position: relative;
      height: 60px;
      border-bottom: 1px solid #e5e5e5;

      h3 {
        margin-bottom: 0px;
        line-height: 58px;
        font-size: 22px;
        font-weight: 400;
        text-align: center;
      }

      .title-border {
        width: 90px;
        height: 0;
        margin: 0 auto;
        border-bottom: 3px solid #1787e0;
      }
    }

    .big-title {
      margin: 20px 0;
      font-size: 26px;
      font-weight: 700;
      word-break: break-all;
      word-wrap: break-word;
    }

    .column-title-left {
      padding: 10px 0;

      // border-bottom: 1px solid #e5e5e5;
      .column-title-left-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }

      h3 {
        line-height: 24px;
        border-left: 3px solid #1787e0;
        padding-left: 12px;
        font-size: 22px;
        font-weight: 400;
      }

      .schoolIntroduce {
        padding: 2px 20px;
        height: 50px;
        overflow: hidden;
        transition: all 1s;
        overflow : hidden;
        display: -webkit-box; 
        -webkit-box-orient: vertical;
         -webkit-line-clamp: 5; 
      }

      .showHeight {
        height: 120px;
      }

      .rightLink {
        font-size: 12px;
      }

      .tab-header{
        position: relative;
        height: auto;
        margin-bottom: 20px;

        .tab-item {
          float: left;
          border-bottom: 2px solid transparent;
          margin-right: 10px;

          a {
            padding: 2px 10px;
            margin-top: 5px;
            display: block;
            color: #666;
            font-size: 16px;
            padding: 4px 10px 5px;
          }

          a:hover {
            text-decoration: none;
          }
        }

        .selected {
          border-color: #1787e0;
        }
      }

      .tab-connect{
        .item-connect{
          padding: 10px 0;
          min-height: 60px;
          ul{
            margin-bottom: 0;
            padding: 10px 0;
            background: #f7f9fa;
          }
          li{
            float: left;
            width: 255px;
            padding: 0 20px;
            height: 35px;
            line-height: 35px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }

        }
      }

    }
  }

}
</style>