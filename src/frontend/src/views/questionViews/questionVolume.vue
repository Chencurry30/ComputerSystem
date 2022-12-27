<template>
  <div class="questionView w MainPageHeader">
    <div class="questionBread">
      <div class="questionBreadLeft">
        <span class="routerCurrent">试题详情</span>
        <span class="sky">/</span>
        <span class="routerBack" @click="backSelectPage()">返回选择页</span>
      </div>
      <div class="questionBreadRight">
        <span class="downloadQuestion" @click="printOutPDF('#main-content')">下载试卷</span>
      </div>

    </div>
    <div id="main-content">
      <div class="questionConnect">
        <div class="questionHeader w">随机组成试卷一</div>
        <div v-for="(questionItem) in questionDataList" :key="questionItem.questionId" class="questionItem">
          <examItem :questionData="questionItem"></examItem>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import { getVolume } from '../../service/questionService'

import examItem from '../../components/questionItem/examItem'
export default {
  components: { examItem },
  name: 'questionVolume',
  data() {
    return {
      //获取的题目列表 
      questionDataList: []
    }
  },
  mounted() {
    //根据组卷的相关数据，随机组卷 
    this.getVolumeQuestionData()
  },
  methods: {
    getVolumeQuestionData() {
      let selectData = this.$route.query
      selectData.classifyId = parseInt(selectData.classifyId)
      selectData.singleChoiceNum = parseInt(selectData.singleChoiceNum)
      selectData.multipleChoiceNum = parseInt(selectData.multipleChoiceNum)
      selectData.completionNum = parseInt(selectData.completionNum)
      selectData.answerNum = parseInt(selectData.answerNum)
      getVolume(selectData).then((res) => {
        this.questionDataList = res.data.data
        console.log(res);
      })

    },
    backSelectPage() {
      let location = {
        name: 'questionSelect'
      }
      this.$router.push(location)
    }








  },
}

</script>

<style scoped lang="less">
.downloadQuestion {
  color: #008afb;
  cursor: pointer;
}
</style> 



