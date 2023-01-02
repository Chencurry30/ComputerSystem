<!--组卷的弹窗-->
  
<template>
  <div class="questionDialog">
    <el-dialog title="题目详情" :visible.sync="dialogVisible" width="60%" center>
      <!--题目的详情页面-->
      <div class="titleConnect">
        <!--问题的题目-->
        <div class="questionTitle">
          <div class="titleHeader">
            <span>({{ questioHead }})&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span v-if="QuestionData.questionTitle === '无'">题目如下图所示</span>
            <span v-else>{{ QuestionData.questionTitle }}</span>
          </div>
          <div v-if="QuestionData.titleImage !== ''" class="titleImg">
            <img :src="[publicUrl + QuestionData.titleImage]" alt="">
          </div>
        </div>
        <!--问题的选项-->
        <div class="questionSelect">
          <div class="selectItem" v-for="(questionChildItem) in QuestionData.questionChoiceList"
            :key="questionChildItem.choiceId">
            <span v-if="questionChildItem.choiceTitle !== '无'">
              {{ questionChildItem.choiceName }}. {{ questionChildItem.choiceTitle }}
            </span>
            <span v-else class="selectOption">
              {{ questionChildItem.choiceName }}.&nbsp;&nbsp;&nbsp;
              <div class="titleImg" v-if="questionChildItem !== ''">
                <img :src="[publicUrl + questionChildItem.titleImage]" alt="">
              </div>
            </span>

          </div>
        </div>
        <!--问题考点-->
        <div class="questionSites">
          <em>[ 考点 ]</em>
          <div>{{ QuestionData.sites }}</div>
        </div>
        <!--问题的答案-->
        <div class="questionAnswer">
          <em>[ 答案 ]</em>
          <span v-if="QuestionData.answer === '无'"></span>
          <span v-else>{{ QuestionData.answer }}</span>

          <div v-if="QuestionData.answerImage !== ''" class="titleImg">
            <img :src="[publicUrl + QuestionData.answerImage]" alt="">
          </div>
        </div>
        <!--题目的解析-->
        <div class="questionSolution">
          <div class="solutionHeader">
            <em>[ 解答 ]</em>
            <span v-if="QuestionData.solution === '无'">解析如下图所示</span>
            <span v-else>{{ QuestionData.solution }}</span>
          </div>
          <div v-if="QuestionData.solutionImage !== ''" class="solutionImg">
            <img :src="[publicUrl + QuestionData.solutionImage]" alt="该题目解析的图片">
          </div>
        </div>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>



<script>
import { createPublicUrl } from '../../../utils/getPublicUrl'
//引入导入题目的upload 
export default {
  name: 'showQuestionMorePopup',
  data() {
    return {
      QuestionData: {},
      dialogVisible: false
    };
  },
  methods: {
    showQuestionMore(row) {
      console.log();
      this.QuestionData = row
      this.dialogVisible = true
    }
  },
  computed: {
    questioHead() {
      if (this.QuestionData.questionType === 1) {
        return '单选题'
      } else if (this.QuestionData.questionType === 2) {
        return '多选题'
      } else if (this.QuestionData.questionType === 3) {
        return '填空题'
      } else {
        return '解答题'
      }
    },
    //提供公共的URL 
    publicUrl() {
      return createPublicUrl();
    }
  }
}
</script>


<style lang="less" scoped>
.titleConnect {
  display: block;
  padding: 0;
  line-height: 25px;
  letter-spacing: 1px;
  word-break: break-all;
  border-radius: 10px 10px 0 0;
  border: 1px solid #dadada;
  border-radius: 10px;


  .questionTitle {
    overflow: hidden;
    zoom: 1;
    clear: both;
    line-height: 24px;
    font-size: 16px;
    padding: 10px 20px;
    cursor: pointer;

    .titleImg {
      width: 100%;

      img {
        width: 80%;
      }
    }

  }

  .questionSelect {
    padding: 0px 20px 20px 20px;

    .selectItem {
      padding: 10px 0px;
    }

    .selectOption {
      padding: 10px 0px;
      display: flex;
      align-items: center;
    }
  }


  .questionSites,
  .questionAnswer,
  .questionSolution {
    display: flex;
    align-items: center;
    padding: 0px 20px 20px 20px;

    em {
      margin-right: 10px;
      font-style: normal;
      font-weight: 700;
    }
  }

  //由于有图片，就只能使其不为flex布局 
  .questionSolution {
    display: block;

    .solutionImg {
      margin-top: 14px;
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

    .source,
    .time,
    .difficulty,
    .icon-analyze,
    .icon-college {
      margin-left: 16px;
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
</style>