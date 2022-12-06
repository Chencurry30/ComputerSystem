<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">

          <div class="allBox">
            <personHeader></personHeader>
            <div class="UserBox secondBox">
              <div class="containHeader">
                <span class="headerP1">详细信息</span>
                <span class="headerP2">DETAILED</span>
                <span class="headerP3">INFORMATION</span>
              </div>
              <div class="containMain">
                <ul class="userInfoBox">
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">用户名：</span>
                      <span>{{ getUserInfo.username }}</span>
                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">昵称：</span>
                      <span>{{ getUserInfo.nickname }}</span>
                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">手机号：</span>
                      <span>{{ getUserInfo.phone }}</span>
                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">邮箱：</span>
                      <span>{{ getUserInfo.email }}</span>

                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">年龄：</span>
                      <span>{{ getUserInfo.age }}</span>
                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">性别：</span>
                      <span>{{ getUserInfo.sex }}</span>
                    </div>
                  </li>
                  <li class="Info-item">
                    <div class="item-title">
                      <span class="laber">个人留言：</span>
                      <span>{{ getUserInfo.message }}</span>
                    </div>
                  </li>
                  <div class="btn" @click="changeEditor">
                    修改信息
                  </div>
                  <InfoPopup ref="InfoPopup"></InfoPopup>
                </ul>
              </div>
            </div>
            <div class="UserBox thirdBox">
              <div class="containHeader">
                <span class="headerP1">推荐视屏</span>
                <span class="headerP2">RECOMMEND</span>
                <span class="headerP2">VIDEOS</span>
              </div>
              <div class="containMain" v-if="collectVideo.length !== 0">
                <ul class="videoBox">
                  <li class="video-item" v-for="(videoItem) in collectVideo" :key="videoItem.videoId"
                    @click="gotoVideoPage(videoItem.videoId)">
                    <div class="videoImg">
                      <img :src="[publicUrl + videoItem.image]" alt="">
                    </div>
                    <div class="videoName">{{ videoItem.name }}</div>
                  </li>
                </ul>
              </div>
              <div class="nodataFound" v-else>
                <div class="noFoundBox">
                  <img src="../../assets/Img/defaultListImg.png" alt="" class="nodataFoundImg">
                </div>
                <span class="noFoundInfomation">暂无收藏视屏</span>
              </div>
              <pagerView :pageInfo="collectPage" @giveFatherPageNo="getSonPageNo" v-if="collectVideo.length !== 0">
              </pagerView>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { createPublicUrl } from '../../utils/index'
import InfoPopup from '../../components/popUp/InfoPopup'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import { userVideoCollect } from '../../service/userServers'
import PagerView from "@/components/remark/PagerView";
export default {
  inject: ['reload'],
  name: "personPage",
  data() {
    return {
      collectVideo: [],
      //关于收藏视屏的分页信息
      collectPage: {}
    }
  },
  components: { PagerView, InfoPopup, personAside, personHeader },
  mounted() {
    //获取用户的相关信息
    this.$store.dispatch('userInfo/getUserInfo')
    //获取本用户收藏的视屏的列表
    this.getUserCollect(1)

  },
  methods: {
    //获取用户收藏的视屏
    getUserCollect(pageNum) {
      let userId = sessionStorage.getItem('userId')
      userVideoCollect(pageNum, userId).then((res) => {
        if (res.data.code === 200) {
          let data = {}
          data.pageNo = res.data.data.pageNum     //当前的页码数
          data.pagesize = res.data.data.pageSize  //每一页的大小
          data.total = res.data.data.total        //总共的个数
          data.pageTotal = res.data.data.pages    //总共有几页

          //将获取的分页数据转化给分页器中
          this.collectPage = data

          //将获取的数据传递给收藏列表
          this.collectVideo = res.data.data.list
          console.log(this.collectVideo);
        }
      })
    },
    //修改用户的个人信息
    changeEditor() {
      this.$refs.InfoPopup.showPopup(this.getUserInfo);
    },
    //获取分页器中传递的数据
    getSonPageNo(pageNum) {
      this.getUserCollect(pageNum)

    },
    //点击对应的收藏视屏跳转到对应的页面
    gotoVideoPage(videoId) {
      console.log(videoId);
      let location = {
        name: 'videoPage'
      }
      location.query = { videoId: videoId }
      this.$router.push(location)
    }

  },
  computed: {
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
    //返回图片存储的公共路径
    publicUrl() {
      return createPublicUrl()
    }
  },
};
</script>

<style lang="less" scoped>
.MainBox {
  margin-top: 70px;

  .containBox {
    margin-top: 5px;
    display: flex;


    .contain-right {
      flex: 3;

      .UserBox {
        margin: 18px 0;
        border-radius: 10px;
        font-size: 14px;
        color: #666;
        border: 2px solid #eee;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;


        .containHeader {
          padding: 15px 0;
          border-bottom: 2px solid #eee;

          .headerP1 {
            margin-left: 40px;
            font-weight: 700;
            // font-size: 16px;
          }

          .headerP2 {
            margin-left: 20px;
            font-weight: 700;
            color: #ff8c00;
          }

          .headerP3 {
            margin-left: 10px;
          }


        }

        .containMain {
          margin: 10px 0;
          padding: 0 20px;
          display: flex;




          .userInfoBox {
            margin-bottom: 0;
            padding: 20px 10px 10px 10px;
            width: 100%;

            .Info-item {
              height: 30px;
              line-height: 30px;
              margin-bottom: 9px;

              .laber {
                display: inline-block;
                width: 80px;
                font-weight: 700;
              }
            }
          }




          .videoBox {
            .video-item {
              float: left;
              margin: 0 2px;
              width: 180px;
              cursor: pointer;

              .videoImg {
                margin-top: 10px;
                width: 100%;
                height: 120px;

                img {
                  width: 100%;
                  height: 100%;
                }
              }

              .videoName {
                font-size: 14px;
                text-align: center;
                padding: 2px 20px;
                width: 180px;
                overflow: hidden;
                display: -webkit-box;
                -webkit-box-orient: vertical;
                -webkit-line-clamp: 2;
              }
            }
          }




          .btn {
            float: right;
            padding: 5px 15px;
            border-radius: 10px;
            color: #ffffff;
            background: #ff8c00;
          }
        }
      }

      .showBox {
        padding: 0 10px;
        width: 820px;
      }
    }
  }
}
</style>
