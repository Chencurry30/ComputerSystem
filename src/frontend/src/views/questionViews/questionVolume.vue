<template>
  <div class="questionView">
    <div class="questionConnect">
      <div v-for="(item, index) in tmList" :key="index" class="questionItem">
        <div class="box">
          <!-- <van-divider class="qes-num"> {{ index + 1 }}/{{ tmList.length }}</van-divider> -->
          <p class="title">{{ item.title }}</p>
          <div class="anlist">
            <ul>
              <li :class="{
                'success-active': item.userAnswer === subIndex,
                'error-active': item.userAnswer !== item.correct && item.userAnswer === subIndex
              }" v-for="(sub, subIndex) in item.answer" :key="sub.id" class="lis"
                @click="chechan(item, sub, index, subIndex)">
                {{ sub }}
              </li>
            </ul>
          </div>
          <div v-if="isShowAnswer === index || item.userAnswer !== -1">
            <div class="mar20">
              正确答案: <span class="redcol"> {{ item.answer[item.correct] }}</span>
            </div>
            <div class="mar20 pa20">解析: {{ item.content }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'questionVolume',
  data() {
    return {
      swiper: {},
      isShowAnswer: -1,// 控制是否显示解析
      isActive: -1,
      tmList: [
        {
          id: 1,
          title: '1、1947年12月，毛泽东在《目前形势和我们的任务》中总结出十大军事原则，其核心是( )',
          correct: 0,
          answer: [
            'A.集中优势兵力，各个歼灭敌人',
            'B.诱敌深入，积极防御',
            'C.多种作战形式，适时转变',
            'D.避其主力，打其虚弱'
          ],
          userAnswer: -1,
          content: "毛泽东于1947年12月25日在中共中央召开的会议上所做《目前形势和我们的任务》的报告中正式提出十大军事原则。十大军事原则是一个有机的整体，其核心是强调集中优势兵力打歼灭战",
        },
        {
          id: 2,
          title: '2、中国宋代哲学家朱熹提出“理在事先”，把“天理”说成是世界万物的本原。这是一种( )',
          correct: 1,
          answer: ['A.主观唯心主义观点', 'B.客观唯心主义观点', 'C.朴素唯物主义观点', 'D.形而上学唯物主义观点'],
          userAnswer: -1,
          content: "主观唯心主义认为物质是某种主观精神的产物，客观唯心主义将物质归结为某种客观精神的产物。结合题干可得，“理在事先”这种“天理”观属于客观唯心主义。",
        },
        {
          id: 3,
          title: '3、毛泽东在《新民主主义论》中提出的新民主主义文化纲领是( )',
          correct: 2,
          answer: [
            'A.为抗战服务',
            'B.为工农兵服务',
            'C.民族的、科学的、大众的文化',
            'D.古为今用，洋为中用'
          ],
          userAnswer: -1,
          content: "新民主主义的文化就是“无产阶级领导的，人民大众的，反帝反封建的文化”。这种文化是无产阶级领导的民族的、科学的、大众的文化。",
        },
        {
          id: 4,
          title: '4、下列选项中，强调外因在事物发展中起着重要作用的是( )',
          correct: 2,
          answer: [
            'A.出淤泥而不染',
            'B.威武不能屈，贫贱不能移',
            'C.近朱者赤，近墨者黑',
            'D.常在河边走，就是不湿鞋'
          ],
          userAnswer: -1,
          content: "在因果联系中，内因是事物变化的根据，外因是事物变化的条件。“近朱者赤，近墨者黑”强调的是外因在事物变化发展中的重要作用。",
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
  },
}
</script>

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
</style>