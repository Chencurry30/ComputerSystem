<!--题目的具体详情页面-->
<template>
  <div class="wrapper">
    <div class="titleBanner">
      <span class="questionMore">试题详情</span>
      <span class="sky">/</span>
      <span class="backSelect" @click="backSelectPage()">返回选择页</span>

    </div>
    <div class="titleConnect">
      <div class="pttitle">
        下面说法正确的是( )
      </div>
      <div class="ptSelect">
        <div class="selectOption">
          <input type="radio">
          <span>A．只有符号不同的两个数是互为相反数</span>
        </div>
        <div class="selectOption">
          <input type="radio" checked="checked">
          <span>B．只有符号不同的两个数是互为相反数</span>
        </div>
        <div class="selectOption">
          <input type="radio">
          <span>C．只有符号不同的两个数是互为相反数</span>
        </div>
        <div class="selectOption">
          <input type="radio">
          <span>D．只有符号不同的两个数是互为相反数</span>
        </div>
      </div>
      <div class="pt2">
        <em>[ 考点 ]</em>
        <span>考察的相关数学知识</span>
      </div>
      <div class="pt3">
        <em>[ 答案 ]</em>
        <span>考察的相关数学知识</span>
      </div>
      <div class="pt4">
        <em>[ 解答 ]</em>
        <span>考察的相关数学知识</span>
      </div>
      <div class="ptBottom">
        <span class="time">上传时间:2022-9-11</span>
        <span class="difficulty">难度:0.9</span>
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

    <QuestionItem></QuestionItem>
  </div>
</template>

<script>
import QuestionItem from '../../components/question/questionItem.vue'
export default {
  name: 'questionPage',
  components:{
    QuestionItem
  },
  
  methods:{
    backSelectPage(){
      let location = {
        name:'questionSelect'
      }
      this.$router.push(location)
    }
  }
}
</script>

<style lang="less" scoped>
.wrapper {
  width: 1200px;
  margin: 0 auto;

  .titleBanner {
    text-align: left;
    margin: 10px 5px;
    font-size: 14px;

    .questionMore {
      color: #008afb;
    }

    .sky {
      padding: 0 5px;
    }
    .backSelect{
      cursor: pointer;
    }
  }

  .titleConnect {
    display: block;
    padding: 0;
    line-height: 25px;
    letter-spacing: 1px;
    word-break: break-all;
    border-radius: 10px 10px 0 0;
    border: 1px solid #dadada;
    border-radius: 10px;

    .pttitle {
      overflow: hidden;
      zoom: 1;
      clear: both;
      line-height: 25px;
      padding: 20px 20px 20px 20px;
      cursor: pointer;

    }

    .ptSelect {
      padding: 0px 20px 20px 20px;

      .selectOption {
        display: flex;
        align-items: center;
        line-height: 26px;

        input {
          vertical-align: middle;
          margin: 0 5px;
          width: 20px;
          height: 16px;
        }
      }
    }

    .pt2,
    .pt3,
    .pt4 {
      zoom: 1;
      position: relative;
      padding: 0px 20px 20px 80px;

      em {
        font-style: normal;
        font-weight: 700;
        position: absolute;
        left: 20px;
      }
    }

    .ptBottom {
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

}
</style>