<!--题库选择页面-->
<template>
  <div class="MainBox MainPageHeader">
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
    <div class="questionPopup w" v-if="judgeDataList">
      <div @click="checkQuestion()" class="checkBtn">点击组卷</div>
      <questionPopup ref="questionPopup"></questionPopup>
    </div>
    <div class="MainConnect w">
      <div class="Mainleft" v-if="judgeDataList">
        <div class="questionList">
          <ul>
            <!--利用questionInfo向子组件中传递返回列表中的题目信息-->
            <questionItem v-for="(Item) in getQuestionList" :key="Item.questionId" :questionData="Item">
            </questionItem>
          </ul>
        </div>
        <!--其中的第一组为父组件向子组件传递的参数  第二组是子组件向父组件传递的选择的页码-->
        <PagerView :pageInfo="getQuestionPage" @giveFatherPageNo="getSonPageNo"></PagerView>
      </div>
      <div v-else class="noDataImg">
        <img src="../../assets/Img/defaultListImg.png" alt="">
        <span>未找到相关数据</span>
      </div>
    </div>
  </div>
</template>
<script>
import _ from 'lodash'
import { mapGetters } from 'vuex'
import PagerView from '../../components/remark/PagerView'
import QuestionItem from '../../components/questionItem/questionItem'
import questionPopup from '../../components/popUp/questionPopup'

export default {
  name: 'questionSelect',
  data() {
    return {
      selectItem: {
        typeId: 0,
        difficultId: 0,
        classifyId: 0,
        sourceId: 0,
        yearId: 0,
        pageNum: 1
      },
    }
  },
  components: {
    PagerView,
    QuestionItem,
    questionPopup
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
    getSonPageNo(pageNum) {
      let { typeId, difficultId, classifyId, sourceId, yearId } = this.selectItem
      console.log();
      this.$store.dispatch('questionData/getQuestionData', { typeId, difficultId, classifyId, sourceId, yearId, pageNum })
    },

    //根据选择的题库获取对应的题库信息
    selectQuestion: _.throttle(function (event) {
      let element = event.target
      let { typeid, difficultid, classifyid, sourceid, yearid } = element.dataset
      //利用v-bind绑定对应的属性
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





    gotoPage() {
      let location = {
        name: 'questionPage'
      }
      this.$router.push(location)
    },

    //组卷按钮（展示随机组卷的弹窗）
    checkQuestion() {
      this.$refs.questionPopup.showPopup()

    }

  },
  computed: {
    ...mapGetters('questionData', {
      questionNavSelect: 'getQuestionNav',
      getQuestionList: 'getQuestionList',
      getQuestionPage: 'getQuestionPage' //获取对应的分页数据传给分页组件
    }),
    judgeDataList() {
      return this.getQuestionList.length !== 0
    },
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
  .noDataImg {
    text-align: center;
    margin: 0 auto;
    width: 320px;

    img {
      width: 100%;
      height: 100%;
    }
  }
}


.questionPopup {
  display: flex;
}

.checkBtn {
  margin: 5px 15px;
  width: 100px;
  height: 40px;
  line-height: 40px;
  border-radius: 8px;
  text-align: center;
  cursor: pointer;
  color: #ffffff;
  background-color: #4a9efa;
}
</style>
