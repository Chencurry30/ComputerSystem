<!--网站头部-->
<template>
  <div class="header">
    <div class="container-xl">
      <div class="main-box">
        <div class="main-left">
          <div class="loge">
            <img src="../assets/Img/webloge.png" alt="" />
          </div>
          <div class="title">旭升网</div>
          <span class="welcome">欢迎用户：{{showUsername}}</span>
        </div>
        <div class="main-right" v-if="false">
          <div class="message-icon">
            <img src="../assets/Img/Icon/message.png" alt="" />
          </div>
          <div class="userimg">
            <img src="../assets/Img/Icon/userimg.png" alt="用户的头像" />
          </div>
        </div>
        <div class="main-right" v-else>
          <div class="gotoperson">
            <router-link :to="{name:'personPage'}">个人中心</router-link>
          </div>
          <button class="gotologin" @click="gotologin">退出登录</button>
        </div>
        
      </div>
    </div>
    <div class="container-xl">
      <div class="select-box">
        <ul class="select-list">
          <li class="list-item">
            <div class="item-info">首页</div>
          </li>
          <li class="list-item">
            <div class="item-info">资源学习</div>
          </li>
          <li class="list-item">
            <div class="item-info">院校选择</div>
          </li>
          <li class="list-item">
            <div class="item-info">备考大纲</div>
          </li>
          <li class="list-item">
            <div class="item-info">考研政策</div>
          </li>
          <li class="list-item">
            <div class="item-info">更多信息</div>
          </li>
        </ul>
        <div class="search">
          <div class="search-loge">
            <img src="../assets/Img/Icon/search.png" alt="">
          </div>
          <input type="text" placeholder="Search...">
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Cookie from 'js-cookie';
export default {
  name: "webHeader",
  methods: {
    gotologin() {
      let location = { name: "loginView" };
      this.$router.push(location);
    },
  },
  computed:{
    showUsername(){
      return Cookie.get('name') 
      }
  }
};
</script>

<style lang="less" scoped>
.header {
  .main-box {
    display: flex;
    justify-content: space-between;
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
      .welcome{
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
        top: 2px;
        left: 10px;
        content: "";
        width: 10px;
        height: 10px;
        border-radius: 5px;
        background-color: red;
      }
      .userimg {
        width: 32px;
        height: 32px;
        img {
          width: 100%;
        }
      }

      .gotologin {
        margin-top: 8px;
        padding: 2px 10px;
        border-radius: 10px;
        color: #fff;
        background-color: #4e71f2;
        opacity: 0.7;
      }
      .gotoperson{
        margin-top: 8px;
        margin-right: 15px;
        padding: 2px 10px;
        border-radius: 10px;
        color: #fff;
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
      }
    }
    .search{
      display: flex;
      margin-top: 8px;
      padding: 1px 5px;
      height: 30px;
      line-height: 30px;
      border: 1px solid #dadcde;
      border-radius: 10px;
      .search-loge{
        width: 20px;
        height: 20px;
        img{
          margin-top: 5px;
          vertical-align:top;
          width: 100%;
        }
      }
      input{
        padding: 0 12px 0 5px;
        width: 200px;
      }
    }
  }
}
</style>