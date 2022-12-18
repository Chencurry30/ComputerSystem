<template>
  <div class="MainBox MainPageHeader">
    <div class="MainHeader">
      <div class="fittle">
        <div class="fittle-box">
          <div class="fittle-itme" v-for="(fatherItem) in getNavType" :key="fatherItem.id">
            <span class="typename centerLocation">{{ fatherItem.name }}</span>
            <ul class="itemList">
              <li class="item centerLocation" v-for="(childItem) in fatherItem.list" :key="childItem.id" :class="{
                activeOn1: selectId.first === childItem.typeId, activeOn2:
                  selectId.second === childItem.durationId, activeOn3: selectId.thild === childItem.sortId
              }" :data-typeId="childItem.typeId" :data-durationId="childItem.durationId"
                :data-sortId="childItem.sortId" @click="selectVideo">{{ childItem.name }}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="MainContent" >
      <div class="video-list" v-if="judgeDataList">
        <div class="list-item" v-for="(videoItem) in getDataList" :key="videoItem.videoId"
          @click="getoVideoPage(videoItem.videoId)" @mouseenter="moveVideo(videoItem.videoId)">
          <div class="video-card">
            <div class="cardImg">
              <img :src='[publicUrl + videoItem.image]' alt="">
              <div class="cardMask" :class="{ showBox: countIndex === videoItem.videoId }">
                <div class="MaskInfo">
                  <div class="Mask-left">
                    <svg t="1667739121708" class="icon" viewBox="0 0 1024 1024" version="1.1"
                      xmlns="http://www.w3.org/2000/svg" p-id="13109" width="16" height="16">
                      <path fill="#ffffff"
                        d="M512 0C230.4 0 0 230.4 0 512s230.4 512 512 512 512-230.4 512-512S793.6 0 512 0z m0 981.333333C253.866667 981.333333 42.666667 770.133333 42.666667 512S253.866667 42.666667 512 42.666667s469.333333 211.2 469.333333 469.333333-211.2 469.333333-469.333333 469.333333z"
                        p-id="13110"></path>
                      <path fill="#ffffff"
                        d="M672 441.6l-170.666667-113.066667c-57.6-38.4-106.666667-12.8-106.666666 57.6v256c0 70.4 46.933333 96 106.666666 57.6l170.666667-113.066666c57.6-42.666667 57.6-106.666667 0-145.066667z"
                        p-id="13111"></path>
                    </svg>
                    <span class="number1">{{ videoItem.viewNum }}</span>
                    <svg t="1667740421302" class="icon" viewBox="0 0 1024 1024" version="1.1"
                      xmlns="http://www.w3.org/2000/svg" p-id="15241" width="16" height="16">
                      <path fill="#ffffff"
                        d="M511.402 962.766c-29.68 0-57.568-11.561-78.549-32.543L327.52 824.889H142.769C98.238 824.889 62 788.65 62 744.119V144.12c0-44.531 36.238-80.769 80.769-80.769H881.23c44.531 0 80.77 36.238 80.77 80.769v599.999c0 44.531-36.238 80.77-80.77 80.77H695.285L589.952 930.223c-20.981 20.982-48.869 32.543-78.55 32.543zM142.769 132.582c-6.366 0-11.538 5.172-11.538 11.538v599.999c0 6.367 5.172 11.539 11.538 11.539h217.304l13.736 17.623 107.993 107.994c15.82 15.797 43.382 15.797 59.202 0l111.34-112.32 10.389-13.297H881.23c6.367 0 11.539-5.172 11.539-11.539V144.12c0-6.366-5.172-11.538-11.539-11.538H142.769z"
                        p-id="15242"></path>
                      <path fill="#ffffff"
                        d="M696.615 378.45H304.308c-19.122 0-34.615-15.494-34.615-34.615 0-19.122 15.494-34.616 34.615-34.616h392.308c19.122 0 34.615 15.494 34.615 34.616-0.001 19.122-15.494 34.615-34.616 34.615zM558.154 571.043H304.308c-19.122 0-34.615-15.494-34.615-34.615s15.494-34.615 34.615-34.615h253.847c19.121 0 34.615 15.494 34.615 34.615s-15.495 34.615-34.616 34.615z"
                        p-id="15243"></path>
                    </svg>
                    <span class="number2">{{ videoItem.commentNum }}</span>
                  </div>
                </div>
              </div>

            </div>
            <div class="cardInfo">{{ videoItem.name }}</div>
            <div class="cardBottom">
              <svg t="1667737808683" class="icon" viewBox="0 0 1024 1024" version="1.1"
                xmlns="http://www.w3.org/2000/svg" p-id="6836" width="12" height="12">
                <path fill="#9499a0"
                  d="M764.096 685.888c4.736 3.2 10.432 5.056 16.576 5.056 16.32 0 29.568-13.248 29.568-29.632 0-7.04-2.56-13.504-6.72-18.56l0.256-0.256c-0.448-0.448-1.024-0.832-1.472-1.216-1.728-1.856-3.712-3.52-5.888-4.928-42.944-37.568-92.48-65.664-145.728-83.264 89.536-47.872 150.656-142.208 150.656-250.624 0-156.608-127.424-284.096-284.096-284.096-156.608 0-284.096 127.424-284.096 284.096 0 108.416 61.12 202.752 150.592 250.624-168.704 56.128-290.816 215.168-290.816 402.56 0 16.32 13.248 29.632 29.632 29.632s29.632-13.248 29.632-29.632c0-201.344 163.776-365.12 365.12-365.12 91.52 0 179.072 33.984 246.528 95.744L764.096 685.888zM517.312 531.264c-1.088 0-2.048 0.128-3.136 0.128-124.864-1.664-225.92-103.68-225.92-228.928 0-126.336 102.784-229.056 229.12-229.056s229.056 102.784 229.056 229.056c0 125.184-100.992 227.136-225.792 228.928C519.488 531.392 518.464 531.264 517.312 531.264z"
                  p-id="6837"></path>
                <path
                  d="M916.352 955.072l-69.76-69.76 69.76-69.76c11.52-11.584 11.52-30.336 0-41.856-11.584-11.584-30.336-11.584-41.856 0l-69.76 69.76-69.76-69.76c-11.52-11.584-30.336-11.584-41.92 0-11.52 11.52-11.52 30.272 0 41.856l69.76 69.76-69.76 69.76c-11.584 11.584-11.584 30.336 0 41.856 11.52 11.584 30.336 11.584 41.856 0l69.76-69.76 69.76 69.76c11.52 11.584 30.272 11.584 41.856 0C927.872 985.408 927.872 966.656 916.352 955.072z"
                  p-id="6838"></path>
              </svg>
              <span class="cardAuthor">{{ videoItem.nickname }}</span>
              <span class="cardDate">{{ videoItem.time }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="MainFooter" v-if="judgeDataList">
      <!--其中的第一组为父组件向子组件传递的参数  第二组是子组件向父组件传递的选择的页码-->
      <PagerView :pageInfo="getVideoPage" @giveFatherPageNo="getSonPageNo"></PagerView>
    </div>
    <div v-else class="noDataImg">
      <img src="../../assets/Img/defaultListImg.png" alt="">
      <span>未找到相关数据</span>
    </div>
  </div>
</template>

<script>
import _ from 'lodash'
import { mapGetters } from 'vuex'
import { createPublicUrl } from '../../utils/index'
import PagerView from '../../components/remark/PagerView'
export default {
  name: "videoSelect",
  data() {
    return {
      selectId: {
        first: 0,
        second: 0,
        thild: 0,
        pageNum: 1
      },
      //用来判断鼠标移入的时候显示的是哪一个遮罩层
      countIndex: 0,
    }
  },
  components: {
    PagerView
  },
  mounted() {
    //获取最初始化的相关数据
    this.getvideos()
    //获取视屏的选择列表
    this.getVideoNavType()

  },
  methods: {
    //获取视屏的选择列表
    getVideoNavType() {
      this.$store.dispatch('videoData/getNavType')
    },
    //获取初始化的相关数据
    getvideos() {
      let first = 0
      let second = 0
      let thild = 0
      let pageNum = 1
      this.$store.dispatch('videoData/getVideoData', { first, second, thild, pageNum })
    },
    //获取子组件返回的pageNo
    getSonPageNo(pageNum) {
      let { first, second, thild } = this.selectId
      this.$store.dispatch('videoData/getVideoData', { first, second, thild, pageNum })
    },

    //根据列表中的选项，返回相关的数据
    selectVideo: _.throttle(function (event) {
      let element = event.target
      let { typeid, durationid, sortid } = element.dataset
      if (typeid !== undefined) {
        this.selectId.first = parseInt(typeid)
      } else if (durationid !== undefined) {
        this.selectId.second = parseInt(durationid)
      } else if (sortid !== undefined) {
        this.selectId.thild = parseInt(sortid)
      }
      let { first, second, thild, pageNum } = this.selectId
      this.$store.dispatch('videoData/getVideoData', { first, second, thild, pageNum })
    }, 1500)
    ,
    //去往具体的视屏页面
    getoVideoPage(videoId) {
      let location = {}
      location.name = 'videoPage'
      location.query = { videoId: videoId }
      this.$router.push(location)
    },
    //鼠标移入时修改下标切换遮罩层
    moveVideo(videoId) {
      this.countIndex = videoId
    }
  },
  computed: {
    ...mapGetters('videoData', {
      getNavType: 'getVideoNavType',
      getDataList: 'getVideoDataList',
      getVideoPage: 'getVideoPage',
    }),
    judgeDataList(){
      console.log(this.getDataList.length === 0);
      return this.getDataList.length !== 0
    },
    publicUrl() {
      return createPublicUrl()
    }

  }
}
</script>

<style lang="less" scoped>
.MainHeader {
  background: #f2f4f6;

  .fittle {
    margin: 0 auto;
    padding-top: 20px;
    width: 1280px;

    .fittle-box {
      padding-bottom: 10px;
      font-size: 14px;
      color: #545c63;
      border-bottom: 1px solid #545c6333;

      .fittle-itme {
        display: flex;
        align-content: center;
        margin-bottom: 15px;

        .typename {
          margin-left: 20px;
          width: 3em;
          margin-right: 6px;
          font-weight: 700;
        }

        .itemList {
          display: flex;
          flex: 1;
          margin-bottom: 0px;

          .item {
            padding: 3px 10px;
            border-radius: 10px;
            cursor: pointer;
          }

          .activeOn1,
          .activeOn2,
          .activeOn3 {
            color: #f20d0d;
            font-weight: 700;
            background: #f20d0d0f;
          }
        }
      }
    }
  }
}

.MainContent {
  margin: 0 auto;
  padding-top: 20px;
  width: 1280px;

  .video-list {
    display: flex;
    flex-wrap: wrap;

    .list-item {
      margin: 0 10px;
      width: 300px;
      cursor: pointer;
      .cardImg {
        position: relative;
        width: 100%;
        height: 180px;

        img {
          width: 100%;
          height: 100%;
          border-radius: 10px;
        }

        .cardMask {
          display: none;
          position: absolute;
          width: 100%;
          height: 100%;
          top: 0px;
          left: 0px;
          border-radius: 10px;

          .MaskInfo {
            color: #ffffff;

            .Mask-left {
              position: absolute;
              left: 10px;
              bottom: 6px;

              .number1 {
                margin-left: 8px;
                margin-right: 15px;
              }

              .number2 {
                margin-left: 8px;
                margin-right: 10px;
              }

            }

            .Mask-right {
              position: absolute;
              right: 20px;
              bottom: 6px;
              font-size: 14px;
            }
          }
        }

        .showBox {
          display: block;
        }
      }

      .cardInfo {
        margin-top: 10px;
      }

      .cardBottom {
        display: flex;
        align-items: center;
        font-size: 12px;
        color: #9499a0;
      }

      .cardAuthor {
        margin-left: 5px;
      }

      .cardDate {
        margin-left: 10px;
      }
    }
  }
}

.noDataImg{
  text-align: center;
  margin: 0 auto;
  width: 320px;
  img{
    width: 100%;
    height: 100%;
  }
}
</style>
