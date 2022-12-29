<template>
  <div class="MainBox w">
    <div class="teacherPage">
      <div class="pageHeader">
        <div class="banner-left">
          <img src="../../assets/Img/teacherImg/bannerInfo.png.png" alt="" />
        </div>
        <div class="banner-middle">
          <div class="middleBox">
            <div class="middle-header">
              <div class="middle-left">{{ teacherMsg.name }}</div>
              <div class="middle-right">{{teacherMsg.nickName  }}</div>
            </div>
            <div class="middle-main">
              <p>学位:{{ teacherMsg.background }}</p>
              <p>教师科目:{{ teacherMsg.directionName }}</p>
              <p>关注人数:{{ teacherMsg.attentPeople }}</p>
            </div>
          </div>
        </div>
        <div class="banner-right">
          <div class="ImgBox">
            <img src="../../assets/Img/teacherImg/1.png" alt="" />
          </div>
        </div>
      </div>
      <div class="pageMain">
        <div class="connect-left">
          <div class="left-MainBox">
            <div class="left-Item">
              <div class="Item-title">辅导资历</div>
              <div class="Item-Info">
                从事高等数学教育多年。
              </div>
            </div>
            <div class="left-Item">
              <div class="Item-title">辅导记录</div>
              <div class="Item-Info">
                帮助无数考研的人解决他们的疑难问题。
              </div>
            </div>
          </div>
          <div class="left-Resources">
            <div class="ResourcesTitle">推荐视频</div>
            <div class="ResourcesBox">
              <div class="ResourcesItem" v-for="(videoItem) in recommendVideo" :key="videoItem.videoId"
                @click="gotoVideoPage(videoItem.videoId)">
                <div class="ResourcesImg">
                  <img :src="[publicUrl + videoItem.videoImage]" alt="">
                </div>
                <div class="ResourcesInfo">
                  <div class="ResourcesInfo-left">{{ videoItem.videoName }}</div>
                  <div class="ResourcesInfo-right">{{ videoItem.videoTime.substring(0, 10) }}</div>
                </div>
              </div>


            </div>
          </div>
        </div>
        <div class="connect-right">
          <div class="comTeacher">
            <div class="title">
              老师评论
              <div class="styleT"></div>
            </div>
            <div class="label_Name">
              <input type="text" placeholder="请输入你的昵称" v-model="sendTeacherData.nickName" />
            </div>
            <div class="label_comMessage">
              <input type="text" placeholder="请输入你的评论" v-model="sendTeacherData.content" />
            </div>
            <div class="subminBtn" @click="sendMessData">发送评论</div>
          </div>
        </div>
      </div>
      <div class="pageRemark">
        <div class="fotter-header">用户评论</div>
        <div class="fotter-connect">
          <teacherReply v-for="userItem in DataList" :key="userItem.messageId" :replyInfo="userItem"></teacherReply>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import teacherReply from "../../components/remark/teacherReply";
import { createPublicUrl } from '../../utils/index'
import { getTeacherInfo, evaluationTeacher, getTeacherRemark } from "../../service/teacherService";
export default {
  name: "teacherPerson",
  data() {
    return {
      teacherId: "",
      //获取评论的相关列表 
      DataList: [],
      //老师的相关信息 
      teacherMsg: {
        attentPeople: '暂无数据',
        name: "暂无数据",
        background: "暂无数据",
        directionName: "暂无数据",
        information: "暂无数据",
        nickName:'暂无数据'
      },
      sendTeacherData: {
        nickName: sessionStorage.getItem('nickname'),
        content: '',
        teacherId: this.$route.query.teacherId,
        userId: sessionStorage.getItem('userId')
      },
      //这里目前暂时写死，后续会进行写活 
      recommendVideo: [
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
      ],
    }
  },
  components: { teacherReply },
  mounted() {
    this.teacherId = this.$route.query.teacherId;
    getTeacherInfo(this.teacherId).then((res) => {
      if (res.data.code === 200) {
        if(res.data.data !== undefined){
          this.teacherMsg = res.data.data;
        }
      }
    })
    //获取对老师的相关评价 
    this.teacherRemark()
  },
  methods: {
    //发送相关评论 
    sendMessData() {
      console.log(this.sendTeacherData);
      if (this.sendTeacherData.content === '') {
        this.$message.error('评论的内容不能为空')
      } else {
        evaluationTeacher(this.sendTeacherData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success('评论成功')
            //再一次获取新数据 
            this.teacherRemark()
          }
        })
      }
    },
    //获取老师的评论 
    teacherRemark() {
      getTeacherRemark(this.teacherId).then((res) => {
        if(res.data.code === 200){
          this.DataList = res.data.data
        }
      })
    },
    //前往具体的视屏页面
    gotoVideoPage(videoId) {
      let location = { name: 'videoPage' }
      location.query = { videoId: videoId }
      this.$router.push(location)
    },
  },
  computed: {
    //获取前置的公共的url 
    publicUrl() {
      return createPublicUrl()
    }
  },
  watch: {
    'sendTeacherData.nickName': {
      handler() {
        this.sendTeacherData.username = sessionStorage.getItem('nickname')
        this.$message.error('昵称不能随意修改,只能在个人中心中修改')
      },
      deep: true

    }
  }
};
</script>

<style lang="less" scoped>
.teacherPage {
  margin-top: 70px;

  .pageHeader {
    display: flex;
    height: 260px;
    background: url("../../assets/Img/teacherImg/banner.png.png");

    .banner-left {
      flex: 1;
      margin-top: 45px;
      margin-left: 50px;
    }

    .banner-middle {
      flex: 2;

      .middleBox {
        margin-top: 35px;
        margin-left: 130px;
        padding: 15px 20px 0 25px;
        width: 352px;
        height: 180px;
        background-color: #ffffff;
        border-radius: 10px;

        .middle-header {
          margin-bottom: 6px;
          display: flex;
          justify-content: space-between;

          .middle-left {
            font-size: 30px;
            color: #ff9d00;
            font-weight: bold;
          }

          .middle-right {
            margin-top: 5px;
            width: 113px;
            height: 35px;
            line-height: 35px;
            text-align: center;
            background-color: #ff9d00;
            border-radius: 18px;
            font-size: 18px;
            color: #ffffff;
            cursor: pointer;
          }
        }

        .middle-main {
          p {
            line-height: 24px;
            height: 24px;
          }
        }
      }
    }

    .banner-right {
      flex: 1;

      .ImgBox {
        margin-top: 10px;
        width: 190px;

        img {
          width: 100%;
        }
      }
    }
  }

  .pageMain {
    margin-top: 15px;
    display: flex;

    .connect-left {
      flex: 3;

      .left-MainBox {
        padding: 30px 30px 0 30px;

        .left-Item {
          display: flex;
          margin-bottom: 25px;

          .Item-title {
            line-height: 30px;
            font-size: 18px;
            color: #333333;
            margin-right: 30px;
            width: 75px;
          }

          .Item-Info {
            line-height: 30px;
            width: 694px;
            font-size: 16px;
            color: #999999;
          }
        }
      }

      .left-Resources {
        margin-top: 10px;

        .ResourcesTitle {
          height: 30px;
          line-height: 30px;
          font-weight: 700;
        }

        .ResourcesBox {
          margin-top: 15px;

          display: flex;
          justify-content: center;

          .ResourcesItem {
            float: left;
            margin: 0 5px;
            width: 240px;
            cursor: pointer;

            .ResourcesImg {
              margin: 5px auto;
              height: 150px;

              img {
                width: 100%;
                height: 100%;
                border-radius: 10px;
              }
            }

            .ResourcesInfo {
              display: flex;
              align-items: center;
              justify-content: space-between;

              font-size: 12px;
              color: #333333;

              .ResourcesInfo-left {
                margin-left: 5px;
                width: 148px;
                text-overflow: ellipsis;
                white-space: nowrap;
                overflow: hidden;
              }

              .ResourcesInfo-right {
                margin-right: 10px;
              }
            }
          }

        }
      }
    }

    .connect-right {
      flex: 1;

      .comTeacher {
        padding: 10px 0 26px 5px;

        .title {
          position: relative;
          margin-left: -20px;
          margin-top: 14px;
          width: 276px;
          height: 50px;
          line-height: 50px;
          font-size: 20px;
          border-top-right-radius: 25px;
          border-bottom-right-radius: 25px;
          text-align: center;
          color: #ffffff;
          background: #ff9d00;

          .styleT {
            position: absolute;
            top: -25px;
            left: 0;
            border-width: 0;
            width: 0;
            height: 0;
            border-top: 0 solid transparent;
            border-bottom: 25px solid #ff9d00;
            border-left: 15px solid transparent;
            border-right: 0 solid #ff9d00;
          }
        }

        .label_Name,
        .label_email,
        .label_comMessage {
          width: 207px;
          height: 40px;
          border-radius: 5px;
          margin: 16px auto 0;
          text-indent: 0.5em;
          background: #ffffff;

          input {
            margin-top: 9px;
            background: #ffffff;
          }
        }

        .subminBtn {
          width: 207px;
          height: 40px;
          border-radius: 5px;
          background: linear-gradient(108deg, #ff6000 40%, #ff9e00);
          margin: 16px auto 0;
          font-size: 18px;
          color: #fff;
          text-align: center;
          line-height: 40px;
          cursor: pointer;
        }
      }
    }
  }

  .pageRemark {
    width: 860px;
    margin-top: 10px;

    .fotter-header {
      padding: 10px 0 10px 5px;
      font-weight: 700;
    }

    .fotter-connect {
      width: 100%;
    }
  }
}
</style>
