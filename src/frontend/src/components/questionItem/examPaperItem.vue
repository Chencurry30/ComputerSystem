<!--点击组卷时对应的试题的每一项-->
<template>

    <li class="questionBox" @click="gotoPage">
      <div class="questionTitle">
        <span>({{ questioHead }})</span>
        有理数a,b在数轴上表示如下，下列判断错误的是()
      </div>
      <div class="questionBottom" v-if="questionItem.questionType === 1 || questionItem.questionType === 2">
        <div class="item" v-for="(questionChildItem) in questionItem.questionChoiceList"
          :key="questionChildItem.choiceId">
          <span @click="select(questionChildItem)">{{ questionChildItem.choiceName }}. {{ questionChildItem.choiceTitle
          }}</span>
        </div>
      </div>
      <div class="questionBottom" v-else-if="questionItem.questionType === 3">
        <div class="item">
          <div class="selectOption" v-for="(item) in judgeList" :key="item.id">
            <span class="span1">{{ item.option }}&nbsp;:&nbsp;</span>
            <span class="span2">{{ item.name }}</span>
          </div>
        </div>

      </div>
      <div class="questionBottom" v-else>
        <div class="item">
          <span>答：</span>
          <input type="text" class="line">
          <button>提交</button>
        </div>
      </div>
    </li>

</template>

<script>
export default {
  props: ['questionItem'],
  name: 'questionItem',
  data() {
    return {
      judgeList: [
        {
          id: 65656,
          name: '对',
          option: 'A'
        },
        {
          id: 65658,
          name: '错',
          option: 'B'
        }
      ]
    }
  },
  methods: {
    select(questionChildItem) {
      console.log(questionChildItem);
    },
    gotoPage() {
      console.log(this.questionItem);
    }
  },
  computed: {
    questioHead() {
      if (this.questionItem.questionType === 1) {
        return '单选题'
      } else if (this.questionItem.questionType === 2) {
        return '多选题'
      } else if (this.questionItem.questionType === 3) {
        return '判断题'
      } else {
        return '简答题'
      }
    }
  }
}
</script>

<style lang="less" scoped>

  .questionBox {

    margin-bottom: 15px;
    // border: 1px solid #dadada;
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

    .questionBottom {
      padding: 0px 20px 20px 20px;
      display: flex;

      .item {
        flex: 10%;

        .selectOption {
          height: 24px;
          line-height: 24px;
        }

        .span1 {
          margin-left: 6px;
        }

        .span2 {
          margin-left: 10px;
        }

        .line {
          width: 200px;
          height: 20px;
          border-bottom: 1px solid #666666;
        }
      }
    }
  }

</style>