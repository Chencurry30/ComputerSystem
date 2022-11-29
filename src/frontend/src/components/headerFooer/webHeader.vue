<!--网站头部-->
<template>
  <div class="header">
    <div class="container-xl">
      <div class="main-box">
        <div class="main-left">
          <div class="loge">
            <img src="../../assets/Img/webloge.png" alt="" />
          </div>
          <div class="title">旭升网</div>
        </div>
        <div class="main-right centerLocation" v-if="showLoginBtn">
          <div class="message-icon">
            <img src="../../assets/Img/Icon/message.png" alt="" />
          </div>
          <div class="userimg">
            <img v-if="hidddenDefaultImg" :src='publicUrl' alt="用户头像" />
            <img v-else src="../../assets/Img/defaultUserImg.png" alt="默认头像" />
            <div class="user-select">
              <div class="select-item" @click="gotoPerson()">个人中心</div>
              <div class="select-item" @click="backLogin()">退出登录</div>
            </div>
          </div>
        </div>
        <div class="main-right" v-else>
          <button class="gotologin" @click="gotologin">用户注册</button>
        </div>
      </div>
    </div>
    <div class="container-xl" v-if="hiddenTopComponent">
      <div class="select-box">
        <ul class="select-list">
          <li class="list-item" v-for="(item, index) in liList"
            :key="index">
            <div class="item-info">
              <router-link :to="item.link">{{ item.name }}</router-link>
            </div>
          </li>
        </ul>
        <div class="search">
          <div class="search-loge">
            <img src="../../assets/Img/Icon/search.png" alt="">
          </div>
          <input type="text" placeholder="Search...">
        </div>
      </div>
    </div>
  </div>
</template>
<script>

// import { mapGetters } from 'vuex'
import { createPublicUrl } from '../../utils/index'
export default {
  name: "webHeader",
  //App中传入的一个相关的方法,用于帮助进行页面刷新 
  inject: ['reload'],

  data() {
    return {
      liList: [
        { name: '首页', link: 'Home' },
        { name: '资源学习', link: 'videoSelect' },
        { name: '院校选择', link: 'schoolSelect' },
        { name: '题库学习', link: 'questionSelect' },
        { name: '考研政策', link: '' },
        { name: '更多信息', link: 'questionQS' },
      ],
      current: 0,
      showBox: false
    }
  },
  methods: {
    //前往登录页面 
    gotologin() {
      let location = { name: "loginView" };
      sessionStorage.removeItem('token')
      this.$router.push(location);
    },
    //退出登录 
    backLogin() {
      sessionStorage.removeItem('token')
      sessionStorage.removeItem('userImg')
      sessionStorage.removeItem('userId') 
      let location = {
        name: 'loginView'
      }
      this.$router.push(location)
      this.reload()
    },
    //前往个人中心
    gotoPerson() {
      let location = {
        name: 'personPage'
      }
      this.$router.push(location)
    },
  },
  computed: {
    showLoginBtn() {
      return sessionStorage.getItem('token') !== null
    },
    hiddenTopComponent() {
      return this.$route.meta.showTop;
    },
    publicUrl() {
      const userImg = sessionStorage.getItem('userImg')
      return createPublicUrl() + userImg
      
    },
    //判断用户是否有头像 
    hidddenDefaultImg(){
      return sessionStorage.getItem('userImg')
    }
  },
};
</script>

<style lang="less" scoped>
.header {
  .main-box {
    display: flex;
    height: 50px;
    justify-content: space-between;
    align-content: center;
    margin-bottom: 10px;

    .main-left {
      display: flex;
      align-items: center;

      .loge {
        width: 32px;
        height: 32px;

        img {
          width: 100%;
          height: 100%;
        }
      }

      .title {
        padding: 0 5px;
        font-weight: 700;
        font-size: 20px;
      }

      .welcome {
        color: #666;
        font-family: '楷体';
        font-size: 17px;
        margin-left: 15px;
      }
    }

    .main-right {
      display: flex;

      .message-icon {
        margin-right: 20px;
        margin-top: 6px;
        position: relative;
        width: 20px;
        height: 20px;

        img {
          width: 100%;
        }
      }

      .message-icon:after {
        display: block;
        position: absolute;
        top: 0px;
        left: 10px;
        content: "";
        width: 10px;
        height: 10px;
        border-radius: 5px;
        background-color: red;
      }

      .userimg {
        position: relative;
        width: 36px;
        height: 36px;
        img {
          display: block;
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }

        .user-select {
          overflow: hidden;
          width: 120px;
          height: 0;
          position: absolute;
          top: 40px;
          left: -45px;
          border-radius: 10px;
          transition: 1s;

          .select-item {
            margin-top: 8px;
            width: 100%;
            text-align: center;
            color: black;
            height: 24px;
            line-height: 24px;
            cursor: pointer;
          }
        }
      }

      .userimg:hover .itemVBox {
        display: block;
        transition: 1s;
      }

      .gotologin {
        margin-top: 14px;
        padding: 2px 16px;
        height: 35px;
        line-height: 30px;
        border-radius: 10px;
        font-size: 16px;
        color: #fff;
        background-color: #4e71f2;
        opacity: 0.7;
      }

      .gotologin:active {
        opacity: 1;
      }
    }
  }

  .select-box {
    display: flex;
    justify-content: space-between;
    margin: 8px 0px;
    border-top: 1px solid #f3f6f9;
    border-bottom: 1px solid #f3f6f9;

    .select-list {
      display: flex;
      margin-left: 130px;
      margin-bottom: 0px;

      .list-item {
        display: flex;
        margin-right: 30px;
        padding: 10px 5px;
        align-content: center;
      }

      .item-info {
        margin-top: 2px;
        margin-left: 5px;
        font-size: 16px;
        color: #232e3c;

        a {
          text-decoration: none;
          color: #666;
        }
      }

      .action {
        border-bottom: blue 3px solid;
      }
    }

    .search {
      display: flex;
      margin-top: 8px;
      padding: 1px 5px;
      height: 30px;
      line-height: 30px;
      border: 1px solid #dadcde;
      border-radius: 10px;

      .search-loge {
        width: 20px;
        height: 20px;

        img {
          margin-top: 5px;
          vertical-align: top;
          width: 100%;
        }
      }

      input {
        padding: 0 12px 0 5px;
        width: 200px;
      }
    }
  }

  .userimg:hover .user-select {
    height: 70px !important;
    background: rgb(11, 171, 234) !important;
  }

}
</style>
