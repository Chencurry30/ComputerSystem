<!--热门视屏-->
<template>
  <div class="video-item w">
    <div class="title">
      <div class="title-left">
        <div class="titleInfo">热门视屏</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li v-for="(item) in liList" :key="item.id" v-on:click="addClass(item.id)"
            v-bind:class="{ On: item.id === current }" class="BoxItem">
            {{ item.name }}
          </li>
        </ul>
      </div>
      <div class="title-right">
        <div class="more">
          <router-link :to="{ name: 'videoSelect' }">点击更多</router-link>
        </div>
      </div>
    </div>
    <div class="item-list">
      <ul class="listBox clearfix" v-if="judgeNotFound">
        <li class="course-item" v-for="(childItem, index) in videoHotList" :key="index"
          @click="gotoVideoPage(childItem.videoId)" v-show="(index < 4)">
          <div class="course-img">
            <img :src="[publicUrl + childItem.image]" alt="视屏图片">
          </div>
          <div class="course-connect">
            <div class="connect-info">{{ childItem.name }}</div>
            <div class="course-bottom">
              <span>{{ childItem.nickname }}</span>
              <span>{{ childItem.time }}</span>
            </div>
          </div>
        </li>
      </ul>
      <div v-else class="notFound">
        <img src="../../assets/Img/defaultListImg.png" alt="">
        <span>没有相关数据</span>
      </div>
    </div>
  </div>
</template>
<script>
import { createPublicUrl } from '../../utils/index'
import { getHotVideo } from '../../service/systemService'
export default {
  name: 'videoModule',
  data() {
    return {
      liList: [
        {
          id: 1,
          name: '英语'
        },
        {
          id: 2,
          name: '数学'
        },
        {
          id: 3,
          name: '政治'
        },
        {
          id: 4,
          name: '计算机网络'
        },
        {
          id: 5,
          name: '数据结构'
        },
        {
          id: 6,
          name: '计算机组成原理'
        },
      ],
      videoHotList: [],
      current: 1,
      showflag: true
    };
  },
  mounted() {
    //默认加载页面时发送请求1
    this.getHotList(1)
  },
  methods: {
    getHotList(videoSpeciesId) {
      getHotVideo(videoSpeciesId).then((res) => {
        if (res.data.code === 200) {
          this.videoHotList = res.data.data
        } else if (res.data.code === 417) {
          this.showflag = false
        }
      })
    },
    addClass(videoSpeciesId) {
      this.current = videoSpeciesId
      //根据选择的种类来进行对应的请求
      this.getHotList(videoSpeciesId)
    },
    gotoVideoPage(videoId) {
      let location = {
        name: 'videoPage'
      }
      location.query = { videoId: videoId }
      this.$router.push(location)
    }
  },
  computed: {
    //计算出公共的路径
    publicUrl() {
      return createPublicUrl()
    },
    judgeNotFound() {
      return this.showflag
    }
  }
};
</script>
<style lang='less' scoped>
.video-item {
  .title {
    display: flex;
    height: 30px;
    line-height: 30px;

    .title-left {
      flex: 1;

      .titleInfo {
        margin-left: 3px;
        padding-left: 8px;
        border-left: 4px solid #4e71f2;
        font-size: 24px;
        font-weight: 700;
        color: #333;
      }
    }

    .title-middle {
      flex: 8;

      .middleBox {
        margin-left: 30px;

        .BoxItem {
          float: left;
          display: block;
          padding: 0 15px;
          border-bottom: 4px solid #ffffff;
          line-height: 27px;
          font-size: 16px;
          cursor: pointer;
          color: #333;
        }

        .On {
          color: #4e71f2;
          border-color: #4e71f2;
        }
      }
    }

    .title-right {
      flex: 1;

      .more {
        float: right;
        font-size: 14px;
        cursor: pointer;
        color: #333;
      }
    }
  }

  .item-list {
    margin-top: 20px;

    .listBox {
      // display: none;
      width: 100%;

      .course-item {
        float: left;
        margin: 0 9px;
        width: 280px;
        height: 240px;
        border-radius: 8px;
        overflow: hidden;
        cursor: pointer;
        transition: all 1s;

        .course-img {
          width: 100%;
          height: 170px;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .course-connect {
          padding: 10px;
          width: 100%;
          border-radius: 0 0 6px 6px;

          .connect-info {
            width: 100%;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
          }

          .course-bottom {
            display: flex;
            justify-content: space-between;
            padding-top: 9px;

            span {
              font-size: 12px;
              font-family: Microsoft YaHei;
              font-weight: 400;
              color: rgba(128, 128, 128, 1);
              margin-top: 2px;
            }
          }
        }

      }

      .course-item:hover {
        margin-top: 0;
        box-shadow: 0 0 10px 2px #918f8f;
        transition: all 0.8s;
      }
    }

    .notFound {
      margin: 0 auto;
      width: 320px;
      display: flex;
      flex-direction: column;
      text-align: center;
    }

    .hiddenListBox {
      display: block;
    }
  }
}
</style>
