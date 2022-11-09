//视屏资源的首页
<template>
  <div class="MainBox w">
    <div class="MainBox-left">
      <div class="videotitle">
        <h1 class="title">{{videoInfo.name}}</h1>
        <div class="video-data">
          <div class="video-data-list">
            <span class="videoItem">
              <img src="../../assets/Img/Icon/video.png" alt="" />
              {{videoInfo.viewNum}}
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/videomessage.png" alt="" />
              {{videoInfo.commentNum}}
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/time.png" alt="" />
              {{videoInfo.time}}
            </span>
          </div>
        </div>
      </div>
      <!--视屏的主题-->
      <div class="videomain"></div>

      <div class="video-toolbar">
        <span class="like">
          <img
            src="../../assets/Img/Icon/dianzan.png"
            title="点赞"
            alt=""
            class="icon"
          />
          <span class="test-info">{{videoInfo.likeNumber}}</span>
        </span>
        <!-- <span class="collection">
          <img
            src="../../assets/Img/Icon/shoucang.png"
            alt=""
            title="收藏"
            class="icon"
          />
          <span class="test-info">131</span>
        </span>
        <span class="share">
          <img
            src="../../assets/Img/Icon/fenxiang.png"
            alt=""
            title="转发"
            class="icon"
          />
          <span class="test-info">31</span>
        </span> -->
      </div>
      <div class="videoinfo">
        <span class="infoconnect">
          asdjawjdka jdkasjdlkawjdlka jsdlkjawlkdj
        </span>
      </div>
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
        <div class="reply-List" v-for="(item) in getRemarkList" :key="item.id">
          <replyItem :replyInfo="item.father" :showId="item.id"></replyItem>
          <div class="children-List hidden " :class="{unhidden:item.id === showMoreID}" >
            <replyItem  v-for="(child) in item.children" :key="child.id" :replyInfo="child" :showId="item.id"></replyItem>
          </div>
          <div class="totalNumber">
            <div class="total" >共1223条回复</div>
            <div class="getMore" @click="showMoreInfo(item)">点击查看</div>
          </div>
          <!--这里就是利用父组件循环的ID来控制展示的相关回复的信息-->
          <div class="children-Commit hiddenBox" :class="{showBox:item.id === backOtherInfo.showId}">
            <ReleaseItem :typeSelect="Type.first"></ReleaseItem>
          </div>
        </div>
      </div>
    </div>
    <div class="MainBox-right">
      <div class="videoList">
        <div class="video-list-item">
          <div class="item-box">
            <div class="item-img-box"></div>
            <div class="item-info">
              <div class="item-info-title hiddenText">视屏的标题今天你学习了吗呵呵呵呵呵</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>
              <div class="item-info-total">
                <div class="total-left">
                  <div class="left-img">
                    <img src="../../assets/Img/Icon/video.png" alt="">
                  </div>
                  <div class="left-info">213213</div>
                </div>
                <div class="total-right">
                  <div class="right-img">
                    <img src="../../assets/Img/Icon/time.png" alt="">
                  </div>
                  <div class="right-info">2022-9-10</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="video-list-item">
          <div class="item-box">
            <div class="item-img-box"></div>
            <div class="item-info">
              <div class="item-info-title hiddenText">视屏的标题今天你学习了吗呵呵呵呵呵</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>
              <div class="item-info-total">
                <div class="total-left">
                  <div class="left-img">
                    <img src="../../assets/Img/Icon/video.png" alt="">
                  </div>
                  <div class="left-info">213213</div>
                </div>
                <div class="total-right">
                  <div class="right-img">
                    <img src="../../assets/Img/Icon/time.png" alt="">
                  </div>
                  <div class="right-info">2022-9-10</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="video-list-item">
          <div class="item-box">
            <div class="item-img-box"></div>
            <div class="item-info">
              <div class="item-info-title hiddenText">视屏的标题今天你学习了吗呵呵呵呵呵</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>
              <div class="item-info-total">
                <div class="total-left">
                  <div class="left-img">
                    <img src="../../assets/Img/Icon/video.png" alt="">
                  </div>
                  <div class="left-info">213213</div>
                </div>
                <div class="total-right">
                  <div class="right-img">
                    <img src="../../assets/Img/Icon/time.png" alt="">
                  </div>
                  <div class="right-info">2022-9-10</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="video-list-item">
          <div class="item-box">
            <div class="item-img-box"></div>
            <div class="item-info">
              <div class="item-info-title hiddenText">视屏的标题今天你学习了吗呵呵呵呵呵</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>
              <div class="item-info-total">
                <div class="total-left">
                  <div class="left-img">
                    <img src="../../assets/Img/Icon/video.png" alt="">
                  </div>
                  <div class="left-info">213213</div>
                </div>
                <div class="total-right">
                  <div class="right-img">
                    <img src="../../assets/Img/Icon/time.png" alt="">
                  </div>
                  <div class="right-info">2022-9-10</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="video-list-item">
          <div class="item-box">
            <div class="item-img-box"></div>
            <div class="item-info">
              <div class="item-info-title hiddenText">视屏的标题今天你学习了吗呵呵呵呵呵</div>
              <div class="item-info-contest hiddenText">坚持这样练3个月,你也能听懂百分之九十的英语对话</div>
              <div class="item-info-total">
                <div class="total-left">
                  <div class="left-img">
                    <img src="../../assets/Img/Icon/video.png" alt="">
                  </div>
                  <div class="left-info">213213</div>
                </div>
                <div class="total-right">
                  <div class="right-img">
                    <img src="../../assets/Img/Icon/time.png" alt="">
                  </div>
                  <div class="right-info">2022-9-10</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ReleaseItem from "../../components/remark/releaseItem.vue";
import ReplyItem from "../../components/remark/replyItem.vue";
import {mapState,mapGetters} from 'vuex'
import {getVideoInfo} from '../../service/videoService.js'
export default {
  name: "videoPage",
  data() {
    return {
      showMoreID:0,
      showRemarkID:0,
      Type:{
        first:'回复',
        second:'提问',
      },
      videoInfo:{}
    };
  },
  components: {
    ReleaseItem,
    ReplyItem,
  },
  mounted(){
    this.getPageData()
  },
  methods:{
    showMoreInfo(item){
      this.showMoreID = item.id;
    },

    //获取视屏页面的具体信息 
    getPageData(){
      let videoId = this.$route.query.videoId
      getVideoInfo(videoId).then((res)=>{
        console.log(res);
        this.videoInfo = res.data.data
      })
    }







  },
  computed:{
    ...mapState('remark',{
      backOtherInfo:"backOtherInfo",   //点击回复时候所回复人的相关储存信息
    }),
    ...mapGetters('remark',{
      getRemarkList:'getRemarkList',
    }),


  },
};
</script>

<style lang='less' scoped>
.MainBox {
  display: flex;
  margin-top: 15px;
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
      height: 480px;
      background: red;
    }
    .video-toolbar {
      box-sizing: content-box;
      padding-top: 16px;
      padding-bottom: 12px;
      height: 28px;
      line-height: 28px;
      border-bottom: 1px solid #e3e5e7;
      color: #61666d;
      .like,
      .share,
      .collection {
        margin-right: 45px;
      }
      .icon {
        margin-top: -6px;
        margin-right: 8px;
        width: 24px;
        height: 24px;
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
      .reply-List{
        .children-List{
          margin-left: 6%;
          width: 100%;
        }
        .children-Commit{
          margin: 10px 0;
          margin-left: 5%;
          width: 95%;
          }
        .totalNumber{
          display: flex;
          margin-left: 10%;
          color: #9499a0;
          font-size: 12px;
          .total{
            margin-right: 10px;
          }
          .getMore:hover{
            color: #00aeec;
          }
        }
        .hidden{
          height: 160px;
          overflow: hidden;
        }
        .unhidden{
          height: 100%;
        }
      }
    }
  }
  .MainBox-right {
    padding: 0 25px;
    width: 400px;
    .videoList{
      .item-box{
        display: flex;
        margin-bottom: 10px;
        .item-img-box{
          display: flex;
          flex: 1;
          justify-content: center;
          align-content: center;
          width: 160px;
          height: 80px;
          background: red;
        }
        .item-info{
          flex: 1;
          max-width: 180px;
          margin-left: 10px;
          .item-info-title{
            font-size: 14px;
            height: 26px;
            line-height: 26px;
            font-weight: 700;
          }
          .item-info-contest{
            height: 24px;
            line-height: 24px;
            font-weight: 400;
            font-size: 12px;
          }
          .item-info-total{
            display: flex;
            justify-content: space-between;
            align-content: center;
            margin-top: 5px;
            .total-left,.total-right{
              display: flex;
              margin: 0 5px;
              // margin-left: 0px;
              height: 16px;
              .left-img,.right-img{
                margin-right: 4px;
                width: 17px;
                height: 17px;
                img{
                  width: 100%;
                }
              }
              .left-info,.right-info{
                font-size: 12px;
              }
            }
          }
        }
      }
    }
  }
}
</style>
