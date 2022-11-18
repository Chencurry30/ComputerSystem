<template>
  <div class="MainBox w">
    <div class="containBox">
      <div class="contain-left">
        <div class="Item">
          <div class="ItemHeader">
            <div class="HeaderTitle">个人中心</div>
            <div class="HeaderInfo">
              <div class="Info1">PERSONAL CENTER</div>
              <div class="Info2">MY DERE SEE DETALS</div>
            </div>
          </div>
          <div class="ItemBox">
            <ul class="ItemBox-list">
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/person.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'personInfo' }"
                    style="text-decoration: none"
                    >个人资料</router-link
                  >
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/security.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'personSecurity' }"
                    style="text-decoration: none"
                    >账户安全</router-link
                  >
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div class="Item second">
          <div class="ItemHeader">
            <div class="HeaderTitle">消息中心</div>
            <div class="HeaderInfo">
              <div class="Info1">MESSAGE CENTER</div>
              <div class="Info2">MY DERE SEE DETALS</div>
            </div>
          </div>
          <div class="ItemBox">
            <ul class="ItemBox-list">
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/remind.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'messageReply' }"
                    style="text-decoration: none"
                    >我的评论</router-link
                  >
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/remark.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'commentsReply' }"
                    style="text-decoration: none"
                    >评论回复</router-link
                  >
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/reply.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'myComment' }"
                    style="text-decoration: none"
                    >我的提问</router-link
                  >
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/notice.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'teacherReply' }"
                    style="text-decoration: none"
                    >老师回复</router-link
                  >
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/share.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'otherReply' }"
                    style="text-decoration: none"
                    >其他留言</router-link
                  >
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div class="Item third">
          <div class="ItemHeader">
            <div class="HeaderTitle">消息中心</div>
            <div class="HeaderInfo">
              <div class="Info1">MESSAGE CENTER</div>
              <div class="Info2">MY DERE SEE DETALS</div>
            </div>
          </div>
          <div class="ItemBox">
            <ul class="ItemBox-list">
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/record.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link
                    :to="{ name: 'thumbVideo' }"
                    style="text-decoration: none"
                    >点赞视屏</router-link
                  >
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="contain-right">
        <div class="showBox">
          <div class="UserBox">
            <div class="containHeader">
              <span class="headerP1">我的资料</span>
              <span class="headerP2">MY PROFILE</span>
              <span class="headerP3">SETTINGS</span>
              <div class="headerP4" @click="backHome()">返回首页</div>
            </div>
            <div class="containMain">
              <div class="userImg">
                <!--上传头像的子组件-->
                <uploadPicture></uploadPicture>


              </div>
              <div class="userInfo">
                <div class="nickname">昵称:&nbsp;&nbsp;&nbsp;{{getUserImg.nickname}}</div>
                <div class="personintroduce">个人留言:&nbsp;&nbsp;&nbsp;{{getUserImg.message}}</div>
              </div>
            </div>
          </div>
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import uploadPicture from '../../components/upload/uploadPicture.vue';
export default {
  name: "personPage",
  components: { uploadPicture },
  methods:{
    backHome(){
      let location = {
        name:'Home'
      }
      this.$router.push(location)
    }
  },
  computed:{
    ...mapGetters('userInfo',
    {
      getUserImg:'getUserImg'
    })
  }
};
</script>

<style lang="less" scoped>
.MainBox{
  margin-top: 15px;
  .containBox {
  margin-top: 5px;
  display: flex;
  .contain-left {
    flex: 1;
    .Item {
      margin: 0px 10px;
      width: 280px;
      border-radius: 10px;
      border: 3px solid #eee;
      .ItemHeader {
        display: flex;
        padding: 10px 0;
        justify-content: space-between;
        border-bottom: 2px solid #eee;

        .HeaderTitle {
          margin-left: 15px;
          font-size: 24px;
          font-weight: 700;
          color: #ff8c00;
        }
        .HeaderInfo {
          margin-right: 15px;
          .Info1 {
            font-size: 16px;
            font-weight: 700;
          }
          .Info2 {
            font-size: 10px;
          }
        }
      }
      .ItemBox {
        padding: 0 15px;
        .ItemBox-list {
          .list-item {
            display: flex;
            padding: 0 10px;
            height: 40px;
            line-height: 40px;
            border-bottom: 2px solid #eee;
            .list-icon {
              margin-top: 10px;
              width: 20px;
              height: 20px;
              img {
                vertical-align: top;
                width: 100%;
              }
            }
            .list-info {
              margin-left: 8px;
              font-size: 14px;
            }
          }
        }
      }
    }
    .second,.third {
      margin-top: 12px;
    }
  }
  .contain-right {
    flex: 3;
    .UserBox {
      border-radius: 10px;
      color: #666;
      border: 2px solid #eee;
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
        .headerP4{
          float: right;
          margin-right: 40px;
          font-weight: 700;
          cursor: pointer;
        }
      }
      .containMain {
        margin: 10px 0px;
        padding: 0px 20px;
        display: flex;
        .userImg {
          margin-left: 40px;
          width: 100px;
          height: 100px;
          border-radius: 50px;
          border: 1px solid #eee;
        }
        .userInfo {
          margin-top: 22px;   
          margin-left: 26px;
            .nickname,.personintroduce {
              font-weight: 700;
              font-size: 16px;
              color: #4e5358;
            }
          .personintroduce {
            margin-top: 4px;
          }
        }
        .InfoBox {
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
            .inputInfo {
              padding: 0px 10px;
              width: 260px;
              border-radius: 10px;
              font-size: 16px;
              font-family: 楷体;
              border: 1px solid #eee;
            }
            .group {
              padding: 5px 10px;
              width: 260px;
              border-radius: 10px;
              font-size: 16px;
              font-family: 楷体;
              border: 1px solid #eee;
            }
          }
          .video-item {
            float: left;
            margin: 0 2px;
            width: 180px;
            .videoImg {
              margin-top: 10px;
              width: 100%;
              height: 120px;
              background: blue;
            }
            .videoName {
              font-size: 14px;
              padding: 5px 0px;
              text-align: center;
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