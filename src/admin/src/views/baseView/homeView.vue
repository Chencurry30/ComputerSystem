<!--系统首页-->
<template>
  <div class="homeView">
    <HomeData></HomeData>
    <HomeDiscount></HomeDiscount>
    <div class="homeCardData">
      <div class="cardItem">
        <questionCard></questionCard>
      </div>
      <div class="cardItem">
        <videoCard></videoCard>
      </div>
      <div class="cardItem">
        <userCard></userCard>
      </div>
    </div>
  </div>
</template>
<script>
//第一部分引入 
import HomeData from '@/components/DataEchar/HomeData.vue'
import HomeDiscount from '@/components/DataEchar/HomeDiscount.vue'
//第二部分引入 
import questionCard from '../../components/HomeCard/questionCard.vue'
import videoCard from '../../components/HomeCard/videoCard.vue'
import userCard from '../../components/HomeCard/userCard.vue'
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
    HomeData,
    HomeDiscount,
    questionCard,
    videoCard,
    userCard
  },
}
</script>

<style lang="less" scoped>
.homeCardData {
  display: flex;
  margin-top: 20px;
  margin-left: -10px;
  height: 320px;

  .cardItem {
    margin: 0 10px;
    flex: 30%;
    height: 100%;
  }
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
</style>




