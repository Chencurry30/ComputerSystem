<template>
  <div class="allBox">
    <div class="header">
      <div class="headerBox clearfix w">
        <div class="school-type">
          <div class="school-type-header">
            <div class="title">{{ schoolInfo.name }}</div>
            <div class="ranking">{{ schoolInfo.attribute }}</div>
            <div class="link">高校的官网地址</div>
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
          <div class="school-item2 bg fourth">学科建设：{{ schoolInfo.disDevelop }}</div>
          <div class="school-item3 bg fifth">院校排名：{{ schoolInfo.rank }}</div>
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
          北京大学创办于1898年，初名京师大学堂，是中国第一所国立综合性大学，也是当时中国最高教育行政机关。辛亥革命后，于1912年改为现名。

          作为新文化运动的中心和“五四”运动的策源地，作为中国最早传播马克思主义和民主科学思想的发祥地，作为中国共产党最早的活动基地，北京大学为民族的振兴和解放、国家的建设和发展、社会的文明和进步做出了不可替代的贡献，在中国走向现代化的进程中起到了重要的先锋作用。爱国、进步、民主、科学的传统精神和勤奋、严谨、求实、创新的学风在这里生生不息、代代相传。

          1917年，著名教育家蔡元培出任北京大学校长，他“循思想自由原则，取兼容并包主义”，对北京大学进行了卓有成效的改革，促进了思想解放和学术繁荣。陈独秀、李大钊、毛泽东以及鲁迅、胡适等一批杰出人才都曾在北京大学任职或任教。

          1937年卢沟桥事变后，北京大学与清华大学、南开大学南迁长沙，共同组成长沙临时大学。不久，临时大学又迁到昆明，改称国立西南联合大学。抗日战争胜利后，北京大学于1946年10月在北平复学。
        </div>
      </div>
      <div class="column-title-left">
        <div class="column-title-left-header">
          <h3>学科建设</h3>
          <div>
            <a href="javascript:;" class="rightLink">展开全部</a>
          </div>
        </div>
        <div class="schoolIntroduce">
          目前，北京大学共有53个一级学科博士学位授权点，50个一级学科硕士学位授权点，7个专业学位博士授权店，29个专业学位硕士授权点。

          北京大学现有博士生导师2800余人，是一个老中青相结合的高水平导师群体。

          截至2022年3月，北京大学有在校研究生30000余人，其中，博士研究生12000余人，硕士研究生17000余人。

          截至2022年3月，北京大学共授予35467人博士学位，128656人硕士学位。
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
        height: 75px;
        overflow: hidden;
        transition: all 1s;
      }

      .showHeight {
        height: 145px;
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