<template>
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
              <router-link :to="{ name: 'personPage' }" style="text-decoration: none">个人资料</router-link>
            </div>
          </li>
          <li class="list-item">
            <div class="list-icon">
              <img src="../../assets/Img/Icon/security.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'personSecurity' }" style="text-decoration: none">账户安全</router-link>
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
              <img src="../../assets/Img/Icon/reply.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'myComment' }" style="text-decoration: none">我的申请</router-link>
            </div>
          </li>
          <li class="list-item">
            <div class="list-icon">
              <img src="../../assets/Img/Icon/record.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'collectionVideo' }" style="text-decoration: none">上传视屏</router-link>
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
              <img src="../../assets/Img/Icon/notice.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'myDynamics' }" style="text-decoration: none">我的动态</router-link>

            </div>
          </li>
          <li class="list-item redPort">
            <div class="list-icon">
              <img src="../../assets/Img/Icon/notice.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'userChat' }" style="text-decoration: none">研友聊天</router-link>
            </div>
            <span class="Port" :class="{ hiddenRedPord: !redSpot }"></span>
          </li>
          <li class="list-item">
            <div class="list-icon">
              <img src="../../assets/Img/Icon/notice.png" alt="" />
            </div>
            <div class="list-info">
              <router-link :to="{ name: 'userAddFriend' }" style="text-decoration: none">添加研友</router-link>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import { notAccepted } from '../../service/userServers'
export default {
  name: 'personAside',
  data() {
    return {
      interval: null,
      //是否显示提醒用户有人发送相关信息 
      redSpot: false,
      //控制是否加载相关内容 
      setTimeFlag: true,
    }
  },
  mounted() {
    if (this.setTimeFlag === true) {
      this.interval = setInterval(() => {
        this.getRedSpot()
      }, 2500)
    }
  },
  //vue2中的这个在vue3中已经被抛弃 
  //eslint-disable-next-line vue/no-deprecated-destroyed-lifecycle 
  beforeDestroy() {
    clearInterval(this.interval)
  },
  methods: {
    getRedSpot() {
      notAccepted().then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.redSpot = res.data.data
        }
      });
    }
  },
  watch: {
    $route: {
      handler(route) {
        //表示的是页面进入了好友页面
        //,那么就停止这页面中的监听器,开启对应页面的监听器,监听实时返回 
        if (route.name === 'userChat') {
          //关闭持续请求 
          this.setTimeFlag = false
          this.redSpot = false
          clearInterval(this.interval)
        } else {
          //持续开启 
          this.setTimeFlag = true
        }
      },
      immediate: true
    }
  }
}
</script>

<style lang="less">
.contain-left {
  flex: 1;

  .Item {
    margin: 0 10px;
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

        .redPort {
          position: relative;

          .Port {
            position: absolute;
            top: 14px;
            right: 10px;
            width: 12px;
            height: 12px;
            background: red;
            border-radius: 50%;
          }
        }

        .hiddenRedPord {
          display: none;
        }
      }

    }
  }

  .second,
  .third {
    margin-top: 12px;
  }
}
</style>