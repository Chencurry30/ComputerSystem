//视屏资源的首页
<template>
  <div class="MainBox w">
    <div class="MainBox-left">
      <div class="videotitle">
        <h1 class="title">视屏的信息</h1>
        <div class="video-data">
          <div class="video-data-list">
            <span class="videoItem">
              <img src="../../assets/Img/Icon/video.png" alt="" />
              1.4万人
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/videomessage.png" alt="" />
              2400
            </span>
            <span class="videoItem">
              <img src="../../assets/Img/Icon/time.png" alt="" />
              2020-9-10
            </span>
          </div>
        </div>
      </div>
      <div class="videomain"></div>
      <div class="video-toolbar">
        <span class="like">
          <img
            src="../../assets/Img/Icon/dianzan.png"
            title="点赞"
            alt=""
            class="icon"
          />
          <span class="test-info">2131</span>
        </span>
        <span class="collection">
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
        </span>
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
        <div class="reply-content">
          <ReleaseItem></ReleaseItem>
        </div>

        <div class="reply-List">
          <replyItem v-for="(item) in DataList" :key=item.id :replyInfo="item"></replyItem>
        </div>
      </div>
    </div>
    <div class="MainBox-right">2</div>
  </div>
</template>

<script>
import ReleaseItem from "../../components/releaseItem.vue";
import ReplyItem from "../../components/replyItem.vue";
export default {
  name: "videoPage",
  data() {
    return {
      DataList: [
        {
          id: 1232,
          image: "1231231231232.123",
          nickname: "高山",
          time: "2022-6-30",
          content: "你的评论对我很有帮助，感谢你的发言",
          resourcename: "回复我的",
        },
        {
          id: 1236,
          image: "1231231231232.123",
          nickname: "高山星空",
          time: "2022-6-9",
          content: "你的评论对我很有帮助，感谢",
          resourcename: "回复我的",
        },
      ],
    };
  },
  components: {
    ReleaseItem,
    ReplyItem,
  },
};
</script>

<style lang='less' scoped>
.MainBox {
  display: flex;
  margin-top: 15px;
  .MainBox-left {
    width: 800px;
    padding: 10px 48px;
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
    }
  }

  .MainBox-right {
    width: 400px;
    background: blue;
  }
}
</style> 