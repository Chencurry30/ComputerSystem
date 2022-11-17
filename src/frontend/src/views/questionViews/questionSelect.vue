<!--题库选择页面-->
<template>
  <div class="questionConnect">

    <div class="headerConnect">
      <div class="wrapper">
        <div class="selectItem" v-for="(fatherItem) in questionNavSelect" :key="fatherItem.id">
          <span class="selectTitle">{{ fatherItem.name }}</span>
          <ul class="clearfix selectList">
            <li v-for="(childItem) in fatherItem.list" :key="childItem.id" :data-typeId="childItem.typeId"
              :data-difficultId="childItem.difficultId" :data-classifyId="childItem.classifyId"
              :data-sourceId="childItem.sourceId" :data-yearId="childItem.yearId" :class="{
                activeOn1: selectItem.typeId === childItem.typeId,
                activeOn2: selectItem.difficultId === childItem.difficultId,
                activeOn3: selectItem.classifyId === childItem.classifyId,
                activeOn4: selectItem.sourceId === childItem.sourceId,
                activeOn5: selectItem.yearId === childItem.yearId
              }" @click="selectQuestion">{{ childItem.name }}</li>







          </ul>
        </div>
      </div>
    </div>
    <div class="MainConnect w">
      <div class="Mainleft">
        <div class="questionList">
          <ul>
            <li class="questionItem" v-for="(questionItem) in getQuestionList.list" :key="questionItem.questionId">
              <div class="questionTitle">
                有理数a,b在数轴上表示如下，下列判断错误的是()
              </div>
              <div class="questionSelect">
                <div class="item" v-for="(questionChildItem) in questionItem.questionChoiceList" :key="questionChildItem.choiceId">
                  <span>{{questionChildItem.choiceName}}. {{questionChildItem.choiceTitle}}</span>
                </div>

              </div>
              <div class="questionBottom">
                <div class="BottomLeft">
                  <span class="time">上传时间:{{(questionItem.year).substring(0,10)}}</span>
                  <span class="difficulty">难度:{{questionItem.difficult}}</span>
                  <span class="icon-analyze">
                    <img src="../../assets/Img/Icon/fuwu-1.png" alt="">
                    解析
                  </span>
                  <span class="icon-college">
                    <img src="../../assets/Img/Icon/fuwu-2.png" alt="">
                    收藏
                  </span>
                </div>
              </div>









            </li>

          </ul>
        </div>
        <!--其中的第一组为父组件向子组件传递的参数  第二组是子组件向父组件传递的选择的页码-->
        <PagerView :pageInfo="getQuestionPage"  @giveFatherPageNo="getSonPageNo"></PagerView>
      </div>
      <div class="Mainright">
        <div class="mid-content">
          <div class="mid-title">题目设置</div>
          <p>请选择题型</p>
          <div class="titlePt1">
            <div class="PtItem" :data-typeId="1" @click="selectNumber" :class="{ activeOn: !showId1 }">选择题</div>
            <div class="PtItem" :data-typeId="2" @click="selectNumber" :class="{ activeOn: !showId2 }">多选题</div>
            <div class="PtItem" :data-typeId="3" @click="selectNumber" :class="{ activeOn: !showId3 }">填空题</div>
            <div class="PtItem" :data-typeId="4" @click="selectNumber" :class="{ activeOn: !showId4 }">解答题</div>
          </div>
          <p>题量设置</p>
          <div class="titilePt2">
            <div class="pt2Item" :class="{ hiddenBox: showId1 }">
              <em>选择题</em>
              <input type="text" placeholder="输入题量" maxlength="2">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId2 }">
              <em>多选题</em>
              <input type="text" placeholder="输入题量" maxlength="2">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId3 }">
              <em>填空题</em>
              <input type="text" placeholder="输入题量" maxlength="2">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId4 }">
              <em>解答题</em>
              <input type="text" placeholder="输入题量" maxlength="2">
            </div>

          </div>
          <p>难度设置</p>
          <div class="titilePt3">
            <div class="PtItem" v-for="(difficultyItem) in difficultyList" :key="difficultyItem.id"
              @click="selectDifficulty(difficultyItem)" :class="{ activeOn: difficultyId === difficultyItem.id }">
              {{ difficultyItem.name }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



</template>

<script>
import _ from 'lodash'
import { mapGetters } from 'vuex'
import PagerView from '../../components/remark/PagerView'
export default {
  name: 'questionSelect',
 
  data() {
    return {
      showId1: true,
      showId2: true,
      showId3: true,
      showId4: true,
      difficultyId: 0,
      //用来记录选择框的属性
      selectItem: {
        typeId: 0,
        difficultId: 0,
        classifyId: 0,
        sourceId: 0,
        yearId: 0,
        pageNum: 1
      },
      //用来记录遍历的题目难度 
      difficultyList: [
        {
          id: 10000,
          name: '易'
        },
        {
          id: 10001,
          name: '较易'
        },
        {
          id: 10002,
          name: '中等'
        }, {
          id: 10003,
          name: '难'
        }



      ]
    }
  },
  components:{
    PagerView 
  },
  mounted() {
    //获取题目的选择列表 
    this.getQuestionNav()
    //获取题库的数据列表
    this.getQuestionData()
  },
  methods: {
    //获取题库的选择列表 
    getQuestionNav() {
      this.$store.dispatch('questionData/getQuestionNavSelect')
    },
    //获取题库的数据列表
    getQuestionData() {
      let { typeId, difficultId, classifyId, sourceId, yearId, pageNum } = this.selectItem
      this.$store.dispatch('questionData/getQuestionData', { typeId, difficultId, classifyId, sourceId, yearId, pageNum })
    },
    //根据分页器选择的页面数返回对应选择的几页
    getSonPageNo(pageNum){
        let { typeId, difficultId, classifyId, sourceId, yearId } = this.selectItem
        console.log();
        this.$store.dispatch('questionData/getQuestionData',{typeId,difficultId,classifyId,sourceId,yearId,pageNum})
    }, 

    //根据选择的题库获取对应的题库信息
    selectQuestion: _.throttle(function (event) {
      let element = event.target
      let { typeid, difficultid, classifyid, sourceid, yearid } = element.dataset
      //利用v-bind 
      if (typeid !== undefined) {
        this.selectItem.typeId = parseInt(typeid)
      } else if (difficultid !== undefined) {
        this.selectItem.difficultId = parseInt(difficultid)
      } else if (classifyid !== undefined) {
        this.selectItem.classifyId = parseInt(classifyid)
      } else if (sourceid !== undefined) {
        this.selectItem.sourceId = parseInt(sourceid)
      } else {
        this.selectItem.yearId = parseInt(yearid)
      }
      let { typeId, difficultId, classifyId, sourceId, yearId, pageNum } = this.selectItem
      console.log(typeId, difficultId, classifyId, sourceId, yearId, pageNum);
      this.$store.dispatch('questionData/getQuestionData', { typeId, difficultId, classifyId, sourceId, yearId, pageNum })
    }, 1500),

    selectNumber(e) {
      let element = e.target
      let { typeid } = element.dataset
      if (typeid === '1') {
        this.showId1 = !this.showId1
      } else if (typeid === '2') {
        this.showId2 = !this.showId2
      } else if (typeid === '3') {
        this.showId3 = !this.showId3
      } else {
        this.showId4 = !this.showId4
      }
    },
    selectDifficulty(difficultyItem) {
      this.difficultyId = difficultyItem.id
    },


    gotoPage() {
      let location = {
        name: 'questionPage'
      }
      this.$router.push(location)
    }
  },
  computed: {
    ...mapGetters('questionData', {
      questionNavSelect: 'getQuestionNav',
      getQuestionList: 'getQuestionList',
      getQuestionPage:'getQuestionPage' //获取对应的分页数据传给分页组件
    })
  }
}
</script>

<style lang="less" scoped>
.headerConnect {
  background: #f2f4f6;

  .wrapper {
    margin: 5px auto;
    width: 1100px;
    color: #5f5d5d;
    padding: 5px 0px;
    font-size: 14px;

    // background: #f2f4f6;
    .selectItem {
      margin: 5px 0;
      display: flex;
      line-height: 30px;
      align-items: center;

      .selectTitle {
        padding: 0 10px;
      }

      .selectList {
        margin-left: 15px;

        li {
          float: left;
          text-align: center;
          padding: 0 8px;
          cursor: pointer;
        }

        .activeOn1,
        .activeOn2,
        .activeOn3,
        .activeOn4,
        .activeOn5 {
          background-color: #eaf4fd;
          color: #008afb;
          border-radius: 8px;
          padding: 0 8px;
        }
      }
    }
  }

}

.MainConnect {
  display: flex;

  .Mainleft {
    width: 840px;

    .questionList {
      .questionItem {

        margin-bottom: 15px;
        border: 1px solid #dadada;
        border-radius: 10px;
        position: relative;

        .questionTitle {
          overflow: hidden;
          zoom: 1;
          clear: both;
          line-height: 25px;
          font-size: 14px;
          padding: 20px 20px 20px 20px;
          position: relative;
          cursor: pointer;

        }

        .questionSelect {
          padding: 0px 20px 20px 20px;
          display: flex;

          .item {
            flex: 10%;

            span {
              margin-left: 20px;
            }
          }
        }

        .questionBottom {
          display: flex;
          align-items: center;
          height: 32px;
          line-height: 16px;
          background-color: #f4f4f4;
          border-top: 1px solid #dadada;
          padding: 0 20px;
          color: #666666;
          border-radius: 0 0 10px 10px;
          position: relative;
          font-size: 12px;

          .time,
          .difficulty,
          .icon-analyze,
          .icon-college {
            margin-left: 10px;
          }

          .icon-analyze,
          .icon-college {
            img {
              width: 16px;
              height: 16px;
            }
          }

        }
      }
    }
  }

  .Mainright {
    margin-left: 10px;
    width: 350px;
    border-radius: 10px;
    border: 1px solid #dadada;

    .mid-content {
      .mid-title {
        padding: 15px;
        text-align: left;
      }

      .titlePt1,
      .titilePt3 {
        margin: 5px 10px;
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;

        .PtItem {
          margin-bottom: 10px;
          height: 34px;
          line-height: 34px;
          min-width: 64px;
          padding: 0 8px;
          color: #666666;
          background-color: #e8e8e8;
          cursor: pointer;
          text-align: center;
          border-radius: 4px;
        }

        .activeOn {
          color: #ffffff;
          background-color: #4a9efa;
        }
      }

      .titilePt2 {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        line-height: 30px;
        margin-bottom: 10px;

        .pt2Item {
          margin: 5px 0px;

          em {
            color: #fff;
            background-color: #2489f6;
            text-align: center;
            float: left;
            min-width: 60px;
            padding: 0 5px;
          }

          input {
            width: 96px;
            height: 30px;
            line-height: 30px;
            border: 1px solid #e8e8e8;
            border-radius: 6px;
            padding: 0 15px;
          }
        }

      }























      p {
        text-align: left;
        color: #666666;
        margin: 10px auto;
      }

    }






  }
}
</style>