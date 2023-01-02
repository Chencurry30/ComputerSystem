<!--系统首页-->
<template>
  <div class="homeView">
    <div class="viewTitle">
      系统简介:
    </div>
    <p class="font">
      随着现代互联网技术的飞速发展，国家 4G 网,5G 网的普及,现如今我国已经成为了
      一个信息大国，我国各行各业的信息化建设也越来越快，似乎每一个行业都不由自主的和互联网挂上钩。
      在此背景下，当代大学生中有一部分特殊群体也应该享受到互联网所带来的便利，那就是各大学校各个专业的考研子弟。
      本网站就致力于为考研的学生提供便捷，提高他们的效率
    </p>
    <div class="viewTitle">系统相关的数据</div>
    <div class="viewData">
      <div class="viewItem">
        <questionCard></questionCard>
      </div>
      <div class="viewItem">
        <videoCard></videoCard>
      </div>
    </div>
  </div>
</template>
<script>
import questionCard from '../../components/HomeCard/questionCard.vue'
import videoCard from '../../components/HomeCard/videoCard.vue'
export default {
  name: 'homeView',
  data() {
    return {
      loading: false,
      currentDate: '2022-06-23',
      questionTypeCount: []
    }
  },
  components: {
    questionCard,
    videoCard
  },
}
</script>

<style lang="less" scoped>

.el-main {
  padding-top: 0;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;

}

.medium img {
  width: 130%;
  height: 100%;
}

.viewTitle {
  margin: 10px 0 10px 20px;
  font-size: 18px;
  height: 32px;
  line-height: 32px;
  font-weight: 700;
}

.viewData {
  margin-top: 10px;
  display: flex;
  flex-wrap: wrap;

  .viewItem {
    width: 50%;
    justify-content: space-between;
  }
}

.font {
  font-size: 17px;
  text-indent: 2em;
  line-height: 25px;
  margin-left: 10px;
  margin-right: 8px;
  text-align: justify;
}
</style>




