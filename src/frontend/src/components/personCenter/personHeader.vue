<template>
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
        <uploadPicture :userImage="getUserImg.image"></uploadPicture>
      </div>
      <div class="userInfo">
        <div class="nickname">昵称:&nbsp;&nbsp;&nbsp;{{ getUserImg.nickname }}</div>
        <div class="personintroduce">个人留言:&nbsp;&nbsp;&nbsp;{{ getUserImg.message }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import uploadPicture from '../upload/uploadPicture'
export default {
  name:'personHeader',
  components:{
    uploadPicture
  },
  methods:{
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
  },
  computed: {
    ...mapGetters('userInfo',
      {
        getUserImg: 'getUserImg'
      }),
  }
}
</script>

<style lang="less">
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

    .headerP4 {
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

      .nickname,
      .personintroduce {
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
</style>