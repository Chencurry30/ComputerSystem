<!--网站头部-->
<template>
  <div class="header">
    <div class="headerMain">
      <div class="main-left">
        <div class="loge">
          <img src="../../assets/Img/webloge.png" alt="" />
        </div>
        <div class="title">旭升网</div>
      </div>
      <div class="main-middle">
        <div class="middle-box">
          <div class="list-item" v-for="(item, index) in liList" :key="index">
            <router-link :to="item.link">{{ item.name }}</router-link>
          </div>
          <div class="search">
            <div class="searchImg">
              <img src="../../assets/Img/Icon/search.png" alt="">
            </div>
            <div class="searchBox">
              <div class="searchMain">
                <input type="text" placeholder="请输入搜索内容" class="inputType">
              </div>
            </div>
          </div>
          <div class="list-item" v-if="judgeUserLogin">
            <router-link :to="{ name: 'personPage' }">个人中心 </router-link>
          </div>
          <div class="login-or-register centerLocation" v-else>
            <span class="login">登录</span>
            <span class="register">注册</span>
          </div>
        </div>
      </div>
      <div class="main-right centerLocation" v-if="judgeUserLogin">
        <div class="userimg">
          <img v-if="hidddenDefaultImg" :src='publicUrl' alt="" @mouseenter="showSelect()"
            @mouseleave="hiddenSelect()" />
          <img v-else src="../../assets/Img/defaultUserImg.png" alt="默认头像" />

          <div class="user-select" :class="{ showBox: show }" @mouseenter="showSelect()">
            <div class="select-item">{{ userNickName }}</div>
            <div class="select-item" @click="backLogin()">退出登录</div>
          </div>


        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'
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
      //动态显示选择框
      show: false,
      //用户头像
      userImg: sessionStorage.getItem('userImg'),
      //用户昵称
      userNickName: sessionStorage.getItem('nickname')
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
    //展示下选框
    showSelect() {
      this.show = true
    },
    //隐藏下选框
    hiddenSelect() {
      this.show = false
    }

  },
  computed: {
    //判断用户是否登录
    judgeUserLogin() {
      return sessionStorage.getItem('token') !== null
    },
    //拼接公共的url
    publicUrl() {
      return createPublicUrl() + this.userImg
    },
    //判断用户是否有头像
    hidddenDefaultImg() {
      return sessionStorage.getItem('userImg') !== '无'
    },
    //获取用户信息
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
  },

  watch: {
    'getUserInfo': {
      handler: function (newval) {
        console.log(newval);
        //先从session中获取图片
        let localImg = sessionStorage.getItem(('userImg'))
        if (localImg !== newval.image) {
          this.userImg = newval.image
          this.userNickName = newval.nickname
          //将新图片存储到session,供首页使用
          sessionStorage.setItem('userImg', newval.image)
          //将新昵称存储到session,供首页使用
          sessionStorage.setItem('nickname', newval.nickname)
        }
        setTimeout(() => {
          this.reload()
        }, 100)
      }
    },
    deep: true,
    immediate: true,
  }
};
</script>

<style lang="less" scoped>

.header {
  top:0;
  position: fixed;
  display: flex;
  justify-content: center;
  background: white;
  min-width: 100%;
  height: 60px;
  box-shadow: 0 0 5px #d7d7d7;
  z-index: 1000;
  .headerMain {
    position: fixed;
    top:0;
    display: flex;
    flex-basis: 1200px;
    line-height: 60px;

    .main-left {
      display: flex;
      align-items: center;
      width: 138px;

      .loge {
        width: 40px;
        height: 40px;

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
    }

    .main-middle {
      align-items: center;
      display: flex;
      width: 100%;
      justify-content: space-between;

      .middle-box {
        display: flex;

        .list-item {
          align-items: center;
          padding: 0 20px;
        }

        .search {
          display: flex;
          position: relative;
          align-items: center;
          width: 220px;

          .searchImg {
            position: absolute;
            top: 20px;
            right: 11px;
            z-index: 999;
          }

          .searchBox {
            width: 100%;
            font-feature-settings: "tnum";
            box-sizing: border-box;
            color: #000000d9;
            font-size: 14px;
            font-variant: tabular-nums;
            line-height: 1.5715;
            list-style: none;
            margin: 0;
            padding: 0;
          }

          .searchMain {
            padding: 5px 0;
            border-radius: 119px;
            background-color: #fff;
            border: 1px solid #d9d9d9;
            position: relative;
            transition: all .3s cubic-bezier(.645, .045, .355, 1);
          }

          .inputType {
            margin-left: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            width: 167px;
          }
        }



        .login-or-register {
          margin-left: 50px;
          cursor: pointer;

          .login {
            margin-right: 2rem;
          }

          .register {
            background-color: #4d555d;
            color: #fff;
            height: 30px;
            line-height: 26px;
            padding: 2px;
            text-align: center;
            width: 60px;


          }
        }
      }

    }

    .main-right {
      .userimg {
        position: relative;
        width: 48px;
        height: 48px;

        img {
          display: block;
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }

        .showBox {
          display: block !important;
        }

        .user-select {
          display: none;
          width: 100px;
          height: 0;
          position: absolute;
          top: 40px;
          left: -30px;
          transition: 1s;
          z-index: 999;

          .select-item {
            margin-top: 8px;
            width: 100%;
            text-align: center;
            color: black;
            height: 24px;
            line-height: 24px;
            cursor: pointer;
            overflow: hidden;
          }

          .select-item:hover {
            background-color: #9a9c9d;
          }
        }
      }

    }
  }
}
</style>
