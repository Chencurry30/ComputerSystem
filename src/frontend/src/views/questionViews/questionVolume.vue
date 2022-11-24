<template>
  <div class="questionView">
    <div class="questionBread w">

      <span>当前位置：</span>
      <a href="javascript:;">试卷选择</a>
      <span></span>
      <a href="javascript:;">组卷详情</a>

    </div>
    <div class="questionConnect w" id="main-content">
      <div class="questionHeader">随机组成试卷一</div>
      <div class="questionConnect">
        <div v-for="(questionItem) in dataList" :key="questionItem.questionId" class="questionItem">
          <examPageItem :questionItem="questionItem" @giveFather="getSno"></examPageItem>
        </div>
      </div>
      <button type="primary" size="small" @click="printOutDPF('#main-content')">点击下载</button>
    </div>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import examPageItem from '../../components/questionItem/examPaperItem'
export default {
  components: { examPageItem },
  name: 'questionVolume',
  data() {
    return {
      dataList: [
        {
          "questionId": 17,
          "questionType": 1,
          "questionTitle": "数学题17",
          "answer": "A",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.5,
          "source": "自主招生",
          "year": "2022-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 65,
              "choiceName": "A",
              "choiceTitle": "这是数学题17的选项A"
            },
            {
              "choiceId": 66,
              "choiceName": "B",
              "choiceTitle": "这是数学题17的选项B"
            },
            {
              "choiceId": 67,
              "choiceName": "C",
              "choiceTitle": "这是数学题17的选项C"
            },
            {
              "choiceId": 68,
              "choiceName": "D",
              "choiceTitle": "这是数学题17的选项D"
            }
          ]
        },
        {
          "questionId": 13,
          "questionType": 1,
          "questionTitle": "数学题13",
          "answer": "D",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.4,
          "source": "自主招生",
          "year": "2022-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 49,
              "choiceName": "A",
              "choiceTitle": "这是数学题13的选项A"
            },
            {
              "choiceId": 50,
              "choiceName": "B",
              "choiceTitle": "这是数学题13的选项B"
            },
            {
              "choiceId": 51,
              "choiceName": "C",
              "choiceTitle": "这是数学题13的选项C"
            },
            {
              "choiceId": 52,
              "choiceName": "D",
              "choiceTitle": "这是数学题13的选项D"
            }
          ]
        },
        {
          "questionId": 11,
          "questionType": 1,
          "questionTitle": "数学题11",
          "answer": "C",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.8,
          "source": "自主招生",
          "year": "2017-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 41,
              "choiceName": "A",
              "choiceTitle": "这是数学题11的选项A"
            },
            {
              "choiceId": 42,
              "choiceName": "B",
              "choiceTitle": "这是数学题11的选项B"
            },
            {
              "choiceId": 43,
              "choiceName": "C",
              "choiceTitle": "这是数学题11的选项C"
            },
            {
              "choiceId": 44,
              "choiceName": "D",
              "choiceTitle": "这是数学题11的选项D"
            }
          ]
        },
        {
          "questionId": 15,
          "questionType": 1,
          "questionTitle": "数学题15",
          "answer": "B",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.8,
          "source": "408",
          "year": "2017-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 57,
              "choiceName": "A",
              "choiceTitle": "这是数学题15的选项A"
            },
            {
              "choiceId": 58,
              "choiceName": "B",
              "choiceTitle": "这是数学题15的选项B"
            },
            {
              "choiceId": 59,
              "choiceName": "C",
              "choiceTitle": "这是数学题15的选项C"
            },
            {
              "choiceId": 60,
              "choiceName": "D",
              "choiceTitle": "这是数学题15的选项D"
            }
          ]
        },
        {
          "questionId": 32,
          "questionType": 2,
          "questionTitle": "数学题32",
          "answer": "A",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.5,
          "source": "考研真题",
          "year": "2017-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 125,
              "choiceName": "A",
              "choiceTitle": "这是数学题32的选项A"
            },
            {
              "choiceId": 126,
              "choiceName": "B",
              "choiceTitle": "这是数学题32的选项B"
            },
            {
              "choiceId": 127,
              "choiceName": "C",
              "choiceTitle": "这是数学题32的选项C"
            },
            {
              "choiceId": 128,
              "choiceName": "D",
              "choiceTitle": "这是数学题32的选项D"
            }
          ]
        },
        {
          "questionId": 27,
          "questionType": 2,
          "questionTitle": "数学题27",
          "answer": "B",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.1,
          "source": "408",
          "year": "2022-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 105,
              "choiceName": "A",
              "choiceTitle": "这是数学题27的选项A"
            },
            {
              "choiceId": 106,
              "choiceName": "B",
              "choiceTitle": "这是数学题27的选项B"
            },
            {
              "choiceId": 107,
              "choiceName": "C",
              "choiceTitle": "这是数学题27的选项C"
            },
            {
              "choiceId": 108,
              "choiceName": "D",
              "choiceTitle": "这是数学题27的选项D"
            }
          ]
        },
        {
          "questionId": 34,
          "questionType": 2,
          "questionTitle": "数学题34",
          "answer": "B",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.3,
          "source": "自主招生",
          "year": "2022-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 133,
              "choiceName": "A",
              "choiceTitle": "这是数学题34的选项A"
            },
            {
              "choiceId": 134,
              "choiceName": "B",
              "choiceTitle": "这是数学题34的选项B"
            },
            {
              "choiceId": 135,
              "choiceName": "C",
              "choiceTitle": "这是数学题34的选项C"
            },
            {
              "choiceId": 136,
              "choiceName": "D",
              "choiceTitle": "这是数学题34的选项D"
            }
          ]
        },
        {
          "questionId": 28,
          "questionType": 2,
          "questionTitle": "数学题28",
          "answer": "D",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.6,
          "source": "自主招生",
          "year": "2012-01-01 00:00:00",
          "questionChoiceList": [
            {
              "choiceId": 109,
              "choiceName": "A",
              "choiceTitle": "这是数学题28的选项A"
            },
            {
              "choiceId": 110,
              "choiceName": "B",
              "choiceTitle": "这是数学题28的选项B"
            },
            {
              "choiceId": 111,
              "choiceName": "C",
              "choiceTitle": "这是数学题28的选项C"
            },
            {
              "choiceId": 112,
              "choiceName": "D",
              "choiceTitle": "这是数学题28的选项D"
            }
          ]
        },
        {
          "questionId": 214,
          "questionType": 3,
          "questionTitle": "数学题54",
          "answer": "√",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.8,
          "source": "自主招生",
          "year": "2019-01-01 00:00:00"
        },
        {
          "questionId": 239,
          "questionType": 3,
          "questionTitle": "数学题79",
          "answer": "×",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.7,
          "source": "考研真题",
          "year": "2022-01-01 00:00:00"
        },
        {
          "questionId": 207,
          "questionType": 3,
          "questionTitle": "数学题47",
          "answer": "暂无答案",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.8,
          "source": "考研真题",
          "year": "2017-01-01 00:00:00"
        },
        {
          "questionId": 230,
          "questionType": 3,
          "questionTitle": "数学题70",
          "answer": "×",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.1,
          "source": "自主招生",
          "year": "2018-01-01 00:00:00"
        },
        {
          "questionId": 418,
          "questionType": 4,
          "questionTitle": "数学题98",
          "answer": "暂无答案",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.7,
          "source": "自主招生",
          "year": "2017-01-01 00:00:00"
        },
        {
          "questionId": 439,
          "questionType": 4,
          "questionTitle": "数学题119",
          "answer": "暂无答案",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.7,
          "source": "考研真题",
          "year": "2022-01-01 00:00:00"
        },
        {
          "questionId": 438,
          "questionType": 4,
          "questionTitle": "数学题118",
          "answer": "暂无答案",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.4,
          "source": "考研真题",
          "year": "2017-01-01 00:00:00"
        },
        {
          "questionId": 440,
          "questionType": 4,
          "questionTitle": "数学题120",
          "answer": "暂无答案",
          "analysis": "暂无题目分析",
          "solution": "暂无题目解答",
          "sites": "暂无题目考点",
          "classifyId": 2,
          "classifyName": "数学",
          "difficult": 0.8,
          "source": "考研真题",
          "year": "2019-01-01 00:00:00"
        }
      ],
      htmlTitle: '页面导出PDF文件名'
    }
  },
  methods: {


  },
  computed: {
    ...mapGetters('questionData', {
      getSetvolumeData: 'getSetvolumeData'
    })
  }
}
</script>

<style lang="less" scoped>
.questionView {
  background-color: #f5f5f5;

  .questionBread {
    padding-top: 15px;
    margin-bottom: 15px;
    text-align: left;
    font-size: 14px
  }

  .questionConnect {
    background-color: #fff;

    .questionHeader {
      font-size: 24px;
      text-align: center;
      line-height: 50px;
      padding-top: 10px;
    }

    .questionItem {
      margin: 0px 15px;
    }
  }
}
</style> 
