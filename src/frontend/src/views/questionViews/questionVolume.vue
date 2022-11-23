


















































 <template>
  <div class="questionView w">
    <div class="questionConnect">
      <div v-for="(questionItem) in dataList" :key="questionItem.questionId" class="questionItem"
      @click="judgeQuestion(questionItem)">
        <examItem :questionItem="questionItem" @giveFather="getSno"></examItem>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import examItem from '../../components/questionItem/examItem'
export default {
  components: { examItem },
  name: 'questionVolume',
  data() {
    return {
      swiper: {},
      isShowAnswer: -1,// 控制是否显示解析
      isActive: -1,
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
    }
  },
  methods: {
    chechan(v1, v2, index, index1) {

      if (v1.userAnswer !== -1) return // 代表已经答过了
      this.isActive = index1//选中当前选项
      this.isShowAnswer = index //选完显示答案和解析
      v1.userAnswer = index1;   //此处非常关键，已经改变了 tmList数组
      if (index1 === v1.correct) {
        this.nextto();
      }
      console.log("点击的答案" + v1, "正确答案" + `${v2}`, "第" + `${index + 1}` + "题", `点击了第${index + 1}题的第${index1 + 1}答案`);

      //判断最后一个  此判断只适用于最后一个题目的答案 和没一道题的 选项唯一   根据自己的业务判断最后一个题
      let clicklast = v1.content;
      let arrlast = this.tmList[this.tmList.length - 1].content;
      if (clicklast === arrlast) {
        alert("恭喜你完成答题")
      }
    },
    getSno(data){
      console.log(data);
    },
    judgeQuestion(questionItem){
      console.log(questionItem);
    } 






  },
  computed: {
    ...mapGetters('questionData', {
      getSetvolumeData: 'getSetvolumeData'
    })
  }
}
</script>

<style scoped lang="less">
.questionView {}
</style> 







<!-- 
<style lang="less" scoped>
[v-cloak] {
  display: none
}


/* swiper */
.box {
  width: 94%;
  margin: 0 auto;
}

.qes-num {
  margin-left: 8px;
}

.anlist {
  margin-top: 15px;
}

.anlist ul li {
  padding: 10px 0px;
  background: #f6f6f6;
  margin: 5px;
  border-radius: 7px;
  text-indent: 12px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.anlist .success-active {
  background: #021a02ad;
  color: #fff;
  position: relative;
}

.anlist .success-active::before {
  position: absolute;
  content: "✔";
  top: 8px;
  left: 2px;
  font-size: 25px;
  color: #80e4ba;
}

.anlist .error-active {
  background: #c15a5a;
  color: #fff;
  position: relative;
}

.anlist .error-active::before {
  position: absolute;
  content: "×";
  top: 8px;
  left: 2px;
  font-size: 35px;
  color: #80e4ba;
}

.van-radio {
  margin: 10px 0px;
}

.redcol {
  color: red;
}

.mar20 {
  margin: 20px auto;
}

.pa20 {
  background: #7c937014;
  padding: 10px;
  border-radius: 10px;
  font-size: 14px;
  color: #999;
  line-height: 28px;
}
</style> -->