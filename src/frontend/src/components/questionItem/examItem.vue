<!--题目列表对应的组件-->
<template>
  <div>
    <li class="questionItem">
      <div class="questionTitle">
        <span>({{questioHead}})</span>
        有理数a,b在数轴上表示如下，下列判断错误的是()
      </div>
      <div class="questionSelect" v-if="questionItem.questionType === 1 || questionItem.questionType === 2">
        <div class="item" v-for="(questionChildItem) in questionItem.questionChoiceList"
          :key="questionChildItem.choiceId">
          <span @click="givefather(questionChildItem)" class="answerBtn">{{ questionChildItem.choiceName }}. {{ questionChildItem.choiceTitle }}</span>
        </div>
      </div>
      <div class="questionSelect" v-else-if="questionItem.questionType === 3">
        <div class="item">
          <div class="selectOption" v-for="(item) in judgeList" :key="item.id">
            <input type="radio">
            <span class="span1 answerBtn" >{{item.option}}&nbsp;:&nbsp;</span>
            <span class="span2 answerBtn">{{item.name}}</span>
          </div>
        </div>

      </div>
      <div class="questionSelect" v-else>
        <div class="item">
          <span>答：</span>
          <input type="text" class="line">
          <button class="answerBtn">提交</button>
        </div>

      </div>
      <div class="questionBottom">
        <div class="BottomLeft">
          <span class="time">上传时间:{{ (questionItem.year).substring(0, 10) }}</span>
          <span class="difficulty">难度:{{ questionItem.difficult }}</span>
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
  </div>
</template>

<script>
export default {
  props: ['questionItem'],
  name: 'examItem',
  data() {
    return {
      judgeList: [
        {
          id: 65656,
          name: '对',
          option:'A'
        },
        {
          id: 65658,
          name: '错',
          option:'B'
        }
      ]
    }
  },
  methods: {


  },
  computed:{
    questioHead(){
      if(this.questionItem.questionType === 1){
        return '单选题'
      }else if(this.questionItem.questionType === 2){
        return '多选题'
      }else if(this.questionItem.questionType === 3){
        return '判断题'
      }else{
        return '简答题'
      }
    }
  }
}
</script>

<style lang="less" scoped>
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
      .selectOption{
        height: 24px;
        line-height: 24px;
      }
      .span1 {
        margin-left: 6px;
      }
      .span2{
        margin-left: 10px;
      }
      .line{
        width: 200px;
        height: 20px;
        border-bottom: 1px solid #666666;
      }
      .answerBtn{
        cursor: pointer;
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
</style>