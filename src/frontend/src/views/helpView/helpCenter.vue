<!--帮助中心-->
<template>
  <div class="MainPageHeader w">
    <div class="helpList">
      <div class="helpCard" :class="{ selectCurrentBg: currentIndex === item.id }" v-for="(item) in helpSelect"
        :key="item.id" @mouseenter="mouseMoveSelect(item.id)" @mouseleave="mouseLevelSelect()"
        @click="gotoPageView(item.routerLink)">
        <img :src="item.image" alt="">
        <div class="helpCardTitle">{{ item.name }}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'helpCenter',
  data() {
    return {
      currentIndex: 0,
      helpSelect: [
        {
          id: 1,
          name: '安全帮助',
          image: require('../../assets/Img/helpCenterImg/security.png'),
          routerLink:'securityView'
        },
        {
          id: 2,
          name: '上传帮助',
          image: require('../../assets/Img/helpCenterImg/upload.png'),
          routerLink:'uploadView'
        },
        {
          id: 3,
          name: '用户帮助',
          image: require('../../assets/Img/helpCenterImg/user.png'),
          routerLink:'userhelpView'
        }
      ]
    }
  },
  methods: {
    //移入产生的相关背景修改 
    mouseMoveSelect(itemId) {
      this.currentIndex = itemId

    },
    //移除产生的相关背景修改 
    mouseLevelSelect(){
      this.currentIndex = 0;
    },
    //点击跳转到对应的用户页面
    gotoPageView(itemRouterLink){
      this.$router.push(itemRouterLink)
    }, 
  }
}
</script>

<style lang="less" scoped>
.helpList {
  margin-top: 90px;
  display: flex;
  flex-flow: wrap;
}
.helpCard {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  margin: 5px 10px;
  width: 380px;
  height: 200px;
  border-radius: 40px;
  border: 4px solid #E4E7ED;
  cursor: pointer;

  img {
    margin-bottom: 10px;
    width: 72px;
    height: 72px;
  }

  .helpCardTitle {
    margin-top: 5px;
    font-size: 24px;
    color: #409EFF;
  }
}
.selectCurrentBg {
  background-color: #F2F6FC;
}
</style>