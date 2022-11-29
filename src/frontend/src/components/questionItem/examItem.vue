<!--组卷时题目对应的组件-->
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

  border-radius: 10px;
  // border: 1px solid red;
  position: relative;

  .questionTitle {
    overflow: hidden;
    zoom: 1;
    clear: both;
    line-height: 25px;
    font-size: 16px;
    padding: 10px;
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
    padding: 10px 20px;

    .item {
      padding: 10px 0px;

      .selectOption {
        display: flex;
        align-items: center;
      }
    }
  }


}
</style>