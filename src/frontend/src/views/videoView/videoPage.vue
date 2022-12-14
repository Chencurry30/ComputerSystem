//视屏资源的首页
<template>
  <div class="MainBox w MainPageHeader">
    <div class="MainBox-left">
      <div class="videotitle">
        <h1 class="title">{{ videoInfo.name }}</h1>
        <div class="video-data">
          <div class="video-data-list">
            <span class="videoItem">
              <img src="../../assets/Img/Icon/video.png" alt="" />
              {{ videoInfo.viewNum }}
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/videomessage.png" alt="" />
              {{ videoInfo.commentNum }}
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/time.png" alt="" />
              {{ videoInfo.time }}
            </span>
          </div>
        </div>
      </div>
      <!--视屏的主题-->
      <div class="videomain">
        <videoPlay :videoLink="videoInfo.link" :videoImg:="videoInfo.image"></videoPlay>
      </div>

      <!--视屏的相关操作(如收藏，点赞等)-->
      <div class="video-toolbar">
        <div class="like">
          <img src="../../assets/Img/Icon/dianzan.png" title="点赞" alt="" class="icon" />
          <span class="test-info">{{ videoInfo.likeNumber }}</span>
        </div>
        <div class="collection">
          <img src="../../assets/Img/Icon/shoucang.png" alt="收藏" title="收藏" class="icon" @click="collectVideo" />
        </div>

      </div>


      <!--视屏的介绍-->
      <div class="videoinfo">
        <span class="infoconnect">
          {{ videoInfo.introduction }}
        </span>
      </div>
      <!--视屏的忠烈-->
      <div class="videotype">
        <div class="typewarp">
          <ul class="warpBox">
            <li class="tag">
              <div class="taginfo">视屏分类</div>
            </li>
            <li class="tag">
              <div class="taginfo">视屏分类</div>
            </li>
            <li class="tag">
              <div class="taginfo">视屏分类</div>
            </li>
            <li class="tag">
              <div class="taginfo">视屏分类</div>
            </li>
          </ul>
        </div>
      </div>

      <!--评论阶段-->
      <div class="videocommit">

        <div class="reply-header">
          <div class="reply-notecion">
            <ul class="reply-bar">
              <li class="nav-item">
                <span class="reply-title">评论</span>
                <span class="total-reply">216</span>
              </li>
            </ul>
          </div>
        </div>

        <!--评论组件-->
        <div class="reply-content">
          <ReleaseItem :typeSelect="Type.second"></ReleaseItem>
        </div>
        <!--消息回复的组件-->
        <div class="reply-List" v-for="(fatherItem) in getRemarkList" :key="fatherItem.id">
          <replyItem :replyInfo="fatherItem.comment" :showId="fatherItem.id"></replyItem>
          <div class="children-List hidden" :class="{
            hiddenBox: fatherItem.children === null, showBox: showMoreID === fatherItem.id
          }">
            <replyItem v-for="(child) in fatherItem.children" :replyInfo="child" :showId="fatherItem.id"
              :key="child.commentId"></replyItem>
          </div>
          <div class="totalNumber">
            <div class="getMore" @click="showMoreInfo(fatherItem.id)">查看全部</div>
          </div>
          <div class="children-Commit hiddenBox" :class="{ showBox: fatherItem.id === getOtherInfo.showId }">
            <!--将每个评论的父亲传入，是每次回复的时候都是回复到父亲管理-->
            <ReleaseItem :typeSelect="Type.first" :fatherInfo="fatherItem.comment"></ReleaseItem>
          </div>
        </div>
      </div>
    </div>

    <!--这里就是利用父组件循环的ID来控制展示的相关回复的信息-->
    <div class="MainBox-right">
      <div class="videoList">
        <div class="listItem-Box" v-for="(videoItem) in videoList" :key="videoItem.videoId">
          <div class="listItem" @click="gotoPage(videoItem.videoId)">
            <div class="listItemImg">
              <img :src="[publicUrl + videoItem.videoImage]" alt="">
            </div>
            <div class="listItemData">
              <div class="item-info-title hiddenText">{{ videoItem.videoName }}</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>

              <div class="listItemBottom">
                <div class="BottomImg">
                  <img src="../../assets/Img/Icon/time.png" alt="">
                </div>
                <div class="BottomInfo">{{ videoItem.videoTime.substring(0, 10) }}</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { collectVideo } from '../../service/videoService'
import ReleaseItem from "../../components/remark/releaseItem.vue";
import ReplyItem from "../../components/remark/replyItem.vue";
import videoPlay from "../../components/videoPlay/videoPlay"
import { mapGetters } from 'vuex'
import _ from 'lodash'
import { createPublicUrl } from '../../utils/index'
export default {
  name: "videoPage",
  data() {
    return {
      showMoreID: 0,
      Type: {
        first: '回复',
        second: '提问',
      },
      videoList: [
        {
          videoId: 14,
          videoImage: 'video/videoImg/8794027591208.jpg',
          videoName: '考研数学历年真题全解析 2021年 数学二',
          videoTime: '2022-10-15 16:12:31'
        },
        {
          videoId: 2,
          videoImage: 'video/videoImg/8794737791208.jpg',
          videoName: '考研数学历年真题全解析 2022年 数学三',
          videoTime: '2022-10-15 16:12:31'
        },
        {

          videoId: 8,
          videoImage: 'video/videoImg/8794027591208.jpg',
          videoName: '考研数学历年真题全解析 2022年 数学二',
          videoTime: '2022-10-15 16:12:31'
        },
        {

          videoId: 20,
          videoImage: 'video/videoImg/4389035031208.jpg',
          videoName: '考研数学历年真题全解析 2021年 数学三',
          videoTime: '2022-10-15 16:12:31'
        }
      ]
    };
  },
  components: {
    ReleaseItem,
    ReplyItem,
    videoPlay,
  },
  mounted() {
    //获取对应视屏的相关信息
    this.getPageData()
    //获取相应资源的评论信息
    this.getPageRemark()
  },
  methods: {

    //获取视屏页面的具体信息
    getPageData() {
      let videoId = this.$route.query.videoId
      this.$store.dispatch('videoData/getInfo', videoId)
    },
    //获取对应的评论信息
    getPageRemark() {
      let videoId = this.$route.query.videoId
      this.$store.dispatch('remark/getVideoRemark', videoId)
    },
    //将隐藏的评论全部展示
    showMoreInfo(fatherId) {
      if (this.showMoreID === fatherId) {
        this.showMoreID = 0
      } else {
        this.showMoreID = fatherId
      }

    },
    //判断用户是否收藏了这视频(10秒钟执行一次)
    collectVideo: _.throttle(function () {
      let videoId = this.$route.query.videoId
      collectVideo(videoId).then((res) => {
        if (res.data.code === 200) {
          this.$message.success(res.data.message)
        }
      })
    }, 10000),

    //点击视屏前往视屏页面
    gotoPage(videoId){
      let location = {name :'videoPage'}
      location.query = {videoId:videoId}
      this.$router.push(location)   //由于是本页面的跳转,因此还需要重新执行一次获取数据的函数
      this.getPageData()
    } 


  },
  computed: {


    //从vuex中获取视屏的基本信息
    ...mapGetters('videoData', {
      videoInfo: 'getVideoInfo'
    }),


    //从vuex中获取基本的评论列表
    ...mapGetters('remark', {
      getRemarkList: 'getRemarkList',
      //获取的是点击回复评论时被回复人的相关信息
      getOtherInfo: 'getOtherInfo'
    }),


    publicUrl() {
      return createPublicUrl()
    }
  },
};
</script>

<style lang='less' scoped>
.MainBox {
  display: flex;

  .MainBox-left {
    width: 800px;
    padding: 10px 20px 10px 70px;

    .videotitle {
      padding-top: 12px;
      height: 85px;

      .title {
        margin-bottom: 12px;
        overflow: hidden;
        line-height: 24px;
        font-size: 20px;
        font-weight: 500;
        color: #18191c;
      }

      .video-data {
        display: flex;
        position: relative;
        overflow: hidden;
        height: 24px;
        line-height: 20px;
        align-items: center;
        font-size: 12px;
        color: #9499a0;

        .video-data-list {
          display: flex;
          align-items: center;
          overflow: hidden;
          box-sizing: border-box;

          .videoItem {
            margin-right: 12px;
            display: inline-flex;
            text-align: center;
            overflow: hidden;
          }

          img {
            margin-right: 4px;
            width: 20px;
            height: 20px;
          }
        }
      }
    }

    .videomain {
      width: 100%;
    }

    .video-toolbar {
      display: flex;
      align-items: center;
      padding: 10px 0 10px 5px;
      border-bottom: 1px solid #e3e5e7;
      color: #61666d;

      .like,
      .collection {
        display: flex;
        align-items: center;
        margin-right: 45px;
      }

      .icon {
        margin-right: 8px;
        width: 20px;
        height: 20px;
        cursor: pointer;
      }

      .test-info {
        overflow: hidden;
        text-overflow: ellipsis;
        word-break: break-word;
        white-space: nowrap;
      }
    }






    .videoinfo {
      margin: 16px 0;
      min-height: 30px;

      .infoconnect {
        white-space: pre-line;
        font-size: 15px;
        color: #18191c;
        letter-spacing: 0;
        line-height: 24px;
        overflow: hidden;
      }
    }

    .videotype {
      margin: 16px 0 10px 0;
      padding-bottom: 12px;
      height: 46px;
      border-bottom: 1px solid #e3e5e7;

      .tag {
        float: left;
        margin: 0 12px 8px 0;

        .taginfo {
          padding: 0 12px;
          height: 28px;
          line-height: 28px;
          font-size: 14px;
          border-radius: 100px;
          color: #61666d;
          background: #f1f2f3;
        }
      }
    }

    .videocommit {
      margin-top: 24px;

      .reply-notecion {
        margin-bottom: 22px;

        .reply-bar {
          display: flex;
          align-items: center;

          .nav-item {
            font-size: 20px;

            .total-reply {
              margin: 0 36px 0 6px;
              color: #9499a0;
              font-size: 14px;
            }
          }
        }
      }

      .reply-List {
        .children-List {
          margin-left: 6%;
          width: 100%;
        }

        .children-Commit {
          margin: 10px 0;
          margin-left: 5%;
          width: 95%;
        }

        .totalNumber {
          display: flex;
          margin-left: 10%;
          color: #9499a0;
          font-size: 12px;

          .total {
            margin-right: 10px;
          }

          .getMore:hover {
            color: #00aeec;
          }
        }

        //显示子评论的宽度
        .hidden {
          height: 90px;
          overflow: hidden;
        }

        //将没有子评论的相关信息隐藏
        .hiddenBox {
          height: 0;
          overflow: hidden;
        }

        //显示相关信息
        .showBox {
          height: 100%;
          // overflow: auto;
        }
      }
    }
  }

  .MainBox-right {
    margin-top: 40px;
    padding: 0 15px;
    width: 400px;

    .videoList {
      .listItem {
        display: flex;
        margin-bottom: 10px;
        cursor: pointer;
        .listItemImg {
          width: 200px;
          height: 100px;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .listItemData {
          margin-top: 10px;
          margin-left: 10px;
          max-width: 180px;
          font-size: 14px;
          .item-info-title {
            height: 26px;
            line-height: 26px;
            font-weight: 700;
          }

          .item-info-contest {
            height: 24px;
            line-height: 24px;

          }

          .listItemBottom {
            margin-top: 5px;
            display: flex;
            align-content: center;


            .BottomImg {
              margin-right: 8px;
              width: 18px;
              height: 18px;

              img {
                width: 100%;
              }
            }


            .BottomInfo {
              font-size: 12px;
            }

          }
        }
      }
    }
  }
}
</style>
