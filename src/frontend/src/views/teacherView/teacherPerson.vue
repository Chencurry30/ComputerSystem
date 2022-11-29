<template>
  <div class="MainBox w">
    <div class="Main">
      <div class="banner">
        <div class="banner-left">
          <img src="../../assets/Img/teacherImg/bannerInfo.png.png" alt="" />
        </div>
        <div class="banner-middle">
          <div class="middleBox">
            <div class="middle-header">
              <div class="middle-left">{{teacherMsg.name}}</div>
              <div class="middle-right">与他留言</div>
              <questionPopup ref="questionPopup"></questionPopup>
            </div>
            <div class="middle-main">
              <p>学位:{{teacherMsg.background}}</p>
              <p>教师科目:{{teacherMsg.directionName}}</p>
              <p>关注人数:{{teacherMsg.attentPeople}}</p>
            </div>
          </div>
        </div>
        <div class="banner-right">
          <div class="ImgBox">
            <img src="../../assets/Img/teacherImg/1.png" alt="" />
          </div>
        </div>
      </div>
      <div class="main-connect">
        <div class="connect-left">
          <div class="left-MainBox">
            <div class="left-Item">
              <div class="Item-title">辅导资历</div>
              <div class="Item-Info">
                从事高等数学教育多年，在多篇核心期刊发表过相关论文,从事辅导长达5年。
              </div>
            </div>
            <div class="left-Item">
              <div class="Item-title">辅导记录</div>
              <div class="Item-Info">
                帮助无数考研的人在数学方面解决他们的疑难为题,至今辅导人数超50W人。
              </div>
            </div>
          </div>

          <div class="left-Resources">
            <div class="ResourcesTitle">
              <div>推荐视屏</div>
            </div>
            <div class="ResourcesBox">
              <ul class="BoxItem">
                <li class="Item">
                  <div class="ImgBox"></div>
                  <div class="ItemInfo">
                    <div class="ItemInfo-left">快速理解积分</div>
                    <div class="ItemInfo-right">2022/9/14</div>
                  </div>
                </li>
                <li class="Item">
                  <div class="ImgBox"></div>
                  <div class="ItemInfo">
                    <div class="ItemInfo-left">快速理解积分</div>
                    <div class="ItemInfo-right">2022/9/14</div>
                  </div>
                </li>
                <li class="Item">
                  <div class="ImgBox"></div>
                  <div class="ItemInfo">
                    <div class="ItemInfo-left">快速理解积分</div>
                    <div class="ItemInfo-right">2022/9/14</div>
                  </div>
                </li>
              </ul>
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
              <input type="text" placeholder="请输入你的用户名" />
            </div>
            <div class="label_email">
              <input type="text" placeholder="请输入你的邮箱" />
            </div>
            <div class="label_comMessage">
              <input type="text" placeholder="请输入你的评论" />
            </div>
            <div class="sub">发送评论</div>
          </div>
        </div>
      </div>
      <!-- <div class="main-fotter">
        <div class="fotter-header">用户评论</div>
        <div class="fotter-connect">
          <replyItem
            v-for="item in DataList"
            :key="item.id"
            :replyInfo="item"
          ></replyItem>
        </div>
      </div> -->
    </div>
  </div>
</template>

<script>
import QuestionPopup from "../../components/popUp/questionPopup.vue";
// import replyItem from "../../components/remark/replyItem.vue";
import { getTeacherInfo} from "../../service/teacherService";
export default {
  components: {  QuestionPopup },
  name: "teacherPerson",
  data() {
    return {
      teacherId: "",
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
      teacherMsg: {
        attentPeople:'',
        name: "",
        background: "",
        directionName: "",
        information: "",
        Id: "",
      },
    };
  },
  mounted() {
    this.teacherId = this.$route.query.teacherId;
    getTeacherInfo(this.teacherId).then((res) => {
      console.log(res)
      this.teacherMsg = res.data.data;
      console.log(this.teacherMsg);
    });
  },
  methods: {},
};
</script>

<style lang="less" scoped>
.Main {
  margin-top: 10px;
  .banner {
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
  .main-connect {
    margin-top: 15px;
    display: flex;
    .connect-left {
      flex: 3;
      .left-MainBox {
        padding: 30px 58px 30px 30px;
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
        display: flex;
        .ResourcesTitle {
          flex: 1;
          div {
            width: 100%;
            height: 30px;
            line-height: 30px;
            font-size: 16px;
            font-weight: 700;
            text-align: center;
          }
        }
        .ResourcesBox {
          flex: 5;
          .BoxItem {
            overflow: hidden;
            .Item {
              float: left;
              margin: 0 5px;
              width: 226px;
              // height: 180px;
              overflow: hidden;
              .ImgBox {
                margin: 5px auto;
                width: 100%;
                height: 124px;
                background: blue;
              }
              .ItemInfo {
                display: flex;
                width: 100%;
                height: 20px;
                line-height: 20px;
                justify-content: space-between;
                .ItemInfo-left {
                  margin-left: 10px;
                  font-size: 12px;
                  color: #333333;
                }
                .ItemInfo-right {
                  margin-right: 10px;
                  font-size: 12px;
                  color: #333333;
                }
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
        .sub {
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
  .main-fotter {
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
