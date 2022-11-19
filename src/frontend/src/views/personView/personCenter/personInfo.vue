//用户信息
<template>
  <div class="allBox">
    <div class="UserBox secondBox">
      <div class="containHeader">
        <span class="headerP1">详细信息</span>
        <span class="headerP2">DETAILED</span>
        <span class="headerP3">INFORMATION</span>
      </div>
      <div class="containMain">
        <ul class="InfoBox">
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">用户名：</span>
              <span>{{getUserInfo.username}}</span>
            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">昵称：</span>
              <span >{{getUserInfo.nickname}}</span>
            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">手机号：</span>
              <span>{{getUserInfo.phone}}</span>
            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">邮箱：</span>
              <span >{{getUserInfo.email}}</span>

            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">年龄：</span>
              <span >{{getUserInfo.age}}</span>
            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">性别：</span>
              <span>{{getUserInfo.sex}}</span>
            </div>
          </li>
          <li class="Info-item">
            <div class="item-title">
              <span class="laber">个人留言：</span>
              <span >{{getUserInfo.message}}</span>
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
      <div class="containMain">
        <ul class="InfoBox">
          <li class="video-item">
            <div class="videoImg"></div>
            <div class="videoName">计算机组成原理</div>
          </li>
          <li class="video-item">
            <div class="videoImg"></div>
            <div class="videoName">计算机组成原理</div>
          </li>
          <li class="video-item">
            <div class="videoImg"></div>
            <div class="videoName">计算机组成原理</div>
          </li>
          <li class="video-item">
            <div class="videoImg"></div>
            <div class="videoName">计算机组成原理</div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import InfoPopup from '../../../components/popUp/InfoPopup.vue';
import {mapGetters} from 'vuex'
export default {
    name: "personInfo",
    data() {
        return {
        };
    },
    components: { InfoPopup },
    mounted(){
      this.$store.dispatch('userInfo/getUserInfo')
    },
    methods: {
        changeEditor() {
          this.$refs.InfoPopup.showPopup(this.getUserInfo);
        },
    },
    computed:{
      ...mapGetters('userInfo',{
        getUserInfo:'getUserInfo'
      }),
      showprivacy(){
        return this.getUserInfo.isHide === 0 ? '所有信息用户均可见' : '所有信息用户不可见'
      }
    }
};
</script>

<style lang="less" scoped>
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
      margin-left: 40px;
      width: 200px;
      .infoTop {
        margin: 5px 0px;
        display: flex;
        justify-content: space-between;
        .left {
          font-weight: 700;
        }
        .right {
          font-weight: 700;
        }
      }
      .infoMiddle {
        margin-left: 5px;
        margin-bottom: 5px;
        span {
          padding: 0px 5px;
        }
      }
      .infoBottom {
        margin-left: -3px;
        margin-top: 10px;
        span {
          margin: 0 3px;
          padding: 0px 8px;
          border: 2px solid #eee;
          border-radius: 10px;
        }
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
.secondBox {
  margin-top: 20px;
}
.thirdBox {
  margin-top: 20px;
}
</style>
