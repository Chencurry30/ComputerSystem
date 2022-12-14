<!--轮播图的相关组件-->
<template>
  <div class="swiper">
    <div class="swiper-wrapper">
      <div class="swiper-slide" v-for="(fatherItem) in schoolList" :key="fatherItem.id">
        <div class="schoolItem" v-for="childItem in fatherItem.children" :key="childItem.collegeId" @click="gotoPage(childItem.collegeId)">
          <img :src="childItem.image" alt="四川大学" class="schoolImg centerLocation">
          <div class="schoolInfo">{{childItem.name}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper'
export default {
  name: 'swiper',
  data() {
    return {
      schoolList: [
        {
          id: 0,
          name: '第一组',
          children: [
            {
              collegeId: 90,
              name: '北京邮电',
              image: require('../../assets/Img/schoolImg/collegeIcon/202001.jpg')
            },
            {
              collegeId: 3,
              name: '清华大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202002.jpg')
            }, {
              collegeId: 129,
              name: '北京航空',
              image: require('../../assets/Img/schoolImg/collegeIcon/202003.jpg')
            }, {
              collegeId:130,
              name: '北京理工',
              image: require('../../assets/Img/schoolImg/collegeIcon/202004.jpg')
            }, {
              collegeId: 173,
              name: '南开大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202005.jpg')
            }, {
              collegeId: 182,
              name: '复旦大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202006.jpg')
            }
          ]
        },
        {
          id: 1,
          name: '第二组',
          children: [
            {
              collegeId: 191,
              name: '上海交大',
              image: require('../../assets/Img/schoolImg/collegeIcon/202007.jpg')
            }, {
              collegeId: 42,
              name: '北京工业',
              image: require('../../assets/Img/schoolImg/collegeIcon/202008.jpg')
            }, {
              collegeId: 124,
              name: '浙江大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202009.jpg')
            }, {
              collegeId: 206,
              name: '山东大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202010.jpg')
            }, {
              collegeId: 140,
              name: '贵州大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202011.jpg')
            }, {
              collegeId: 143,
              name: '云南大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202012.jpg')
            },
          ]
        },
        {
          id: 2,
          name: '第三组',
          children: [
            {
              collegeId: 141,
              name: '华北电力',
              image: require('../../assets/Img/schoolImg/collegeIcon/202013.jpg')
            }, {
              collegeId: 172,
              name: '天津大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202014.jpg')
            }, {
              collegeId: 228,
              name: '大连理工',
              image: require('../../assets/Img/schoolImg/collegeIcon/202015.jpg')
            }, {
              collegeId: 229,
              name: '东北大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202016.jpg')
            }, {
              collegeId: 252,
              name: '吉林大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202017.jpg')
            }, {
              collegeId: 264,
              name: '哈工大',
              image: require('../../assets/Img/schoolImg/collegeIcon/202018.jpg')
            }
          ]
        },
        {
          id: 3,
          name: '第四组',
          children: [
            {
              collegeId: 30,
              name: '南京大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202019.jpg')
            }, {
              collegeId: 204,
              name: '东南大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202020.jpg')
            },
            {
              collegeId: 117,
              name: '中科大',
              image: require('../../assets/Img/schoolImg/collegeIcon/202021.jpg')
            }, {
              collegeId: 105,
              name: '厦门大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202022.jpg')
            }, {
              collegeId: 2,
              name: '武汉大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202023.jpg')
            }, {
              collegeId: 29,
              name: '华科大',
              image: require('../../assets/Img/schoolImg/collegeIcon/202024.jpg')
            }
          ]
        },
        {
          id: 4,
          name: '第五组',
          children: [
            {
              collegeId: 281,
              name: '中央财经',
              image: require('../../assets/Img/schoolImg/collegeIcon/202025.jpg')
            }, {
              collegeId: 39,
              name: '中南大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202026.jpg')
            }, {
              collegeId: 166,
              name: '中山大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202027.jpg')
            }, {
              collegeId: 43,
              name: '华南理工',
              image: require('../../assets/Img/schoolImg/collegeIcon/202028.jpg')
            }, {
              collegeId: 180,
              name: '重庆大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202029.jpg')
            }, {
              collegeId: 148,
              name: '四川大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202030.jpg')
            }
          ]
        },
        {
          id: 5,
          name: '第六组',
          children: [
            {
              collegeId: 158,
              name: '电科大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202031.jpg')
            }, {
              collegeId: 160,
              name: '西安交大',
              image: require('../../assets/Img/schoolImg/collegeIcon/202032.jpg')
            }, {
              collegeId: 108,
              name: '西北工业',
              image: require('../../assets/Img/schoolImg/collegeIcon/202033.jpg')
            }, {
              collegeId: 187,
              name: '兰州大学',
              image: require('../../assets/Img/schoolImg/collegeIcon/202034.jpg')
            }
          ]
        }







      ]
    }
  },
  mounted() {
    new Swiper('.swiper', {
      // direction: 'vertical', // 垂直切换选项
      loop: true, // 循环模式选项
      autoplay: true,
      // 如果需要分页器
    })
  },
  methods:{
    gotoPage(collegeId){
      let location = {}
      location.name = 'schoolPage'
      location.query = {collegeId:collegeId}
      console.log(location);
      this.$router.push(location)
    }
  }
}
</script>

<style scoped lang="less">
.swiper {
  position: relative;
  overflow: hidden; 
  text-align:center;
  .swiper-slide {
    margin: 10px 0;

    .schoolItem {
      margin: 0 11px;
      float: left;
      display: flex;
      flex-direction: column;
      cursor: pointer;
      .schoolImg {
        width: 44px;
        height: 44px;
      }

      .schoolInfo {
        height: 20px;
        line-height: 20px;
        font-size: 12px;
        color: #333;
        text-align: center;
      }
    }
  }
}
</style>
