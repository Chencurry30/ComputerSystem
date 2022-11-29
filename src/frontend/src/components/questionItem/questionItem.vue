<!--题目列表对应的组件-->
<template>
  <li class="questionItem" @click="gotoPage">
    <div class="questionTitle">
      <div class="titleHeader">
        <span>({{ questioHead }})&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span v-if="questionData.questionTitle === '无'">题目如下图所示</span>
        <span v-else>{{ questionData.questionTitle }}</span>
      </div>
      <div v-if="questionData.titleImage !== ''" class="titleImg">
        <img :src="[publicUrl + questionData.titleImage]" alt="">
      </div>
    </div>


    <!-- choiceTitle -->
    <div class="questionSelect" v-if="questionData.questionType === 1 || questionData.questionType === 2">
      <div class="item" v-for="(questionChildItem) in questionData.questionChoiceList"
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

    <div class="questionBottom">
      <div class="BottomLeft">
        <span class="time">上传时间:{{ (questionData.year).substring(0, 10) }}</span>
        <span class="difficulty">难度:{{ questionData.difficult }}</span>
        <span class="icon-analyze">
          <img src="../../assets/Img/Icon/fuwu-1.png" alt="">
          解析
        </span>
        <span class="icon-college">
          <img src="../../assets/Img/Icon/fuwu-2.png" alt="">
          收藏
        </span>
        <span class="addQuestion">收藏</span>
      </div>
    </div>
  </li>
</template>
<script>
import { createPublicUrl } from '../../utils/index'
export default {
  props: ['questionData'],
  name: 'questionItem',
  data() {
    return {

    }
  },
  methods: {
    select(questionChildItem) {
      console.log(questionChildItem);
    },
    gotoPage() {
      console.log(this.questionData);
      let location = { name: 'questionPage' }
      location.query = { questionId: this.questionData.questionId }
      this.$router.push(location)
    }
  },
  computed: {
    questioHead() {
      if (this.questionData.questionType === 1) {
        return '单选题'
      } else if (this.questionData.questionType === 2) {
        return '多选题'
      } else if (this.questionData.questionType === 3) {
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
    font-size: 16px;
    padding: 20px 20px 20px 20px;
    position: relative;
    cursor: pointer;

    //用来限制题目照片过大 
    .titleImg {
      width: 100%;

      img {
        width: 70%;
      }
    }

  }

  .questionSelect {
    padding: 0px 20px 20px 20px;

    .item {
      padding: 10px 0px;

      .selectOption {
        display: flex;
        align-items: center;
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

    .addQuestion {
      margin-left: 8px;
      height: 18px;
      line-height: 18px;
      min-width: 28px;
      border-radius: 8px;
      background-color: #ff8a00;
      padding: 4px 8px;
      color: #666666;
    }
  }
}
</style>