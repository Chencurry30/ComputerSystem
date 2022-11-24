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
            <!--利用questionInfo向子组件中传递返回列表中的题目信息-->
            <questionItem v-for="(Item) in getQuestionList.list" :key="Item.questionId" :questionItem="Item">
            </questionItem>
          </ul>
        </div>
        <!--其中的第一组为父组件向子组件传递的参数  第二组是子组件向父组件传递的选择的页码-->
        <PagerView :pageInfo="getQuestionPage" @giveFatherPageNo="getSonPageNo"></PagerView>
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
              <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.singleChoiceNum">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId2 }">
              <em>多选题</em>
              <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.multipleChoiceNum">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId3 }">
              <em>填空题</em>
              <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.judgeNum">
            </div>
            <div class="pt2Item" :class="{ hiddenBox: showId4 }">
              <em>解答题</em>
              <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.answerNum">
            </div>

          </div>
          <p>科目设置</p>
          <div class="titlePt4">
            <div class="PtItem" v-for="(subjectItem) in subjectList" :key="subjectItem.classifyId"
              @click="selectSubject(subjectItem)" :class="{ activeOn: subjectId === subjectItem.classifyId }">
              {{ subjectItem.name }}
            </div>
          </div>
          <div class="mid-bottom" @click="submitSelect">点击组卷</div>
        </div>
      </div>
    </div>
  </div>



</template>

<script>
import _ from 'lodash'
import { mapGetters } from 'vuex'
import PagerView from '../../components/remark/PagerView'
import QuestionItem from '../../components/questionItem/questionItem'
import {setVolume} from '../../service/questionService'
export default {
  name: 'questionSelect',
  data() {
    return {
      showId1: true,
      showId2: true,
      showId3: true,
      showId4: true,
      difficultyId: 0,

      //选择科目的组卷ID 
      subjectId: 0,
      //用来记录选择框的属性
      selectItem: {
        typeId: 0,
        difficultId: 0,
        classifyId: 0,
        sourceId: 0,
        yearId: 0,
        pageNum: 1
      },
      //用来记录遍历的科目
      subjectList: [
        {
          classifyId: 2,
          name: '数学'
        },
        {
          classifyId: 3,
          name: '政治'
        },
        {
          classifyId: 4,
          name: '数据结构'
        },
        {
          classifyId: 5,
          name: '计网'
        },
        {
          classifyId: 6,
          name: "计组"
        }
      ],
      //组卷方面的相关数据 
      selectInput: {
        singleChoiceNum:0,
        multipleChoiceNum: 0,
        judgeNum:0,
        answerNum:0,
      }
    }
  },
  components: {
    PagerView,
    QuestionItem
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
    selectSubject(subjuctItem) {
      this.subjectId = subjuctItem.classifyId
    },


    gotoPage() {
      let location = {
        name: 'questionPage'
      }
      this.$router.push(location)
    },

    //组卷按钮 
    submitSelect(){
      if(this.subjectId === 0){
        this.$message({
                message: "请选择要组卷的题目",
                type: "error",
              })
      }else if(this.selectInput.singleChoiceNum === 0 &&
      this.selectInput.multipleChoiceNum===0&&
      this.selectInput.judgeNum===0&&
      this.selectInput.answerNum === 0){
        this.$message({
                message: "请至少选择一项组卷题目的类型",
                type: "error",
              }) 
      }else{
        let data = {}
        data.classifyId = this.subjectId
        data.singleChoiceNum = parseInt(this.selectInput.singleChoiceNum),
        data.multipleChoiceNum = parseInt(this.selectInput.multipleChoiceNum),
        data.judgeNum = parseInt(this.selectInput.judgeNum),
        data.answerNum = parseInt(this.selectInput.answerNum)
        setVolume(data).then((res)=>{
          console.log(res);
        })
      }
    }
  },
  computed: {
    ...mapGetters('questionData', {
      questionNavSelect: 'getQuestionNav',
      getQuestionList: 'getQuestionList',
      getQuestionPage: 'getQuestionPage' //获取对应的分页数据传给分页组件
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
      .titilePt3,
      .titlePt4 {
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
    .mid-bottom{
      margin: 10px auto;
      display: flex;
      justify-content: center;
      width: 80%;
      height: 40px;
      line-height: 40px;
      border-radius: 8px;
      text-align: cente;
      cursor: pointer;
      color: #ffffff;
      background-color: #4a9efa;
    }
  }
}
</style>