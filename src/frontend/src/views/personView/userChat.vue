<!--好友聊天-->
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <div class="userAction">
              <!--我的好友列表-->
              <div class="friendBox">
                <div class="friendBoxHeader">
                  <span class="headerP1">我的研友</span>
                  <span class="headerP2">My Friend</span>
                  <span class="headerP3">SETTINGS</span>
                </div>
                <div class="friendBoxMain" @mouseleave="mouseLeaveFriend">
                  <div class="friendItem centerLocation redPort" :class="{ maskFriednBox: userCurrent === item.userId }"
                    v-for="item in userFridenList" :key="item.userId" @mouseenter="mouseEnterFriend(item)"
                    @click="showPopupBox(item.userId, item.image, item.nickname)">
                    <div class="ItemLeft">
                      <div class="userImg" v-if="item.image === '无'">
                        <img src="../../assets/Img/defaultUserImg.png" alt="">
                      </div>
                      <div class="userImg" v-else>
                        <img :src="[publicUrl + item.image]" alt="">
                      </div>
                      <div class="userName">{{ item.nickname }}</div>
                    </div>
                    <span class="Port" :class="{ hiddenRedPord: item.isRedSpot === 0 }"></span>
                  </div>
                </div>
                <ChatPopup ref="ChatPopup"></ChatPopup>
              </div>
              <!--搜索列表-->
              <div class="searchFriendBox">
                <div class="friendBoxHeader">
                  <span class="headerP1">我的研友</span>
                  <span class="headerP2">My Friend</span>
                  <span class="headerP3">SETTINGS</span>
                </div>
                <div class="friendBoxSearch">
                  <div class="search">
                    <div class="searchImg" @click="searchFriend">
                      <img src="../../assets/Img/Icon/search.png" alt="">
                    </div>
                    <div class="searchBox">
                      <div class="searchMain">
                        <input type="text" placeholder="请输入搜索内容" class="inputType" v-model="firendNickName">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="friendBoxSearchList">
                  <div class="friendItem centerLocation" v-for="(item) in searchFridenList" :key="item.userId">
                    <div class="ItemLeft">
                      <div class="userImg" v-if="item.image === '无'">
                        <img src="../../assets/Img/defaultUserImg.png" alt="">
                      </div>
                      <div class="userImg" v-else>
                        <img :src="[publicUrl + item.image]" alt="">
                      </div>
                      <div class="userName">{{ item.nickname }}</div>
                    </div>
                    <div class="ItemRight" @click="addFriend(item.userId, item.isFriend)">
                      添加好友
                    </div>
                  </div>
                </div>
                <addUserFriend ref="addUserFriend"></addUserFriend>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>



import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import ChatPopup from '../../components/popUp/ChatPopup'
import addUserFriend from '../../components/popUp/addUserFriend'
import { getFriend, getSearchFriend } from '@/service/userServers'
import { createPublicUrl } from '../../utils/index'
export default {
  data() {
    return {
      userFridenList: [],
      userCurrent: 0,
      searchFridenList: [],
      firendNickName: '',
      //开启监听的定时器 
      interval: ''
    }
  },
  components: { personAside, personHeader, ChatPopup, addUserFriend },
  name: "teacherReply",
  //根据 
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
    //获取这个用户的好友聊天 
    this.getUserFriend()
    //定时刷新好友列表 
    this.interval = setInterval(() => {
      this.getUserFriend()
    }, 2500)
  },
  //vue2中的这个在vue3中已经被抛弃 
  //eslint-disable-next-line vue/no-deprecated-destroyed-lifecycle 
  beforeDestroy() {
    clearInterval(this.interval)
    console.log('页面被销毁');
  },
  methods: {
    //获取好友列表 
    getUserFriend() {
      getFriend().then((res) => {
        this.userFridenList = res.data.data
        console.log(res);
      })
    },
    //点击时弹出对应的好友聊天框(将好友的图片,ID,昵称都传递到弹窗中使用) 
    showPopupBox(friendUserId, friendImg, friendNickName) {
      //清空定时器 
      clearInterval(this.interval)
      this.interval = null
      this.$refs.ChatPopup.showPopup(friendUserId, friendImg, friendNickName)
    },
    //关闭弹窗写在父组件中,方便后续操作
    closePopupBox() {
      console.log('我执行了关闭弹窗的函数');
      this.getUserFriend()  //再次请求，避免页面未及时刷新
      this.$refs.ChatPopup.closePopup()
      //再次开启定时器 
      this.interval = setInterval(() => {
        this.getUserFriend()
      }, 2500)
    },
    //搜索好友
    searchFriend() {
      let friendName = this.firendNickName
      console.log(friendName.length);
      if (friendName.length === 0) {
        this.$message.error('搜索昵称不能为空')
      } else {
        getSearchFriend(friendName).then((res) => {
          if (res.data.code === 406) {
            this.$message.error(res.data.message)
          } else {
            console.log(res);
            this.searchFridenList = res.data.data
          }
        })
      }
    },
    //申请添加好友
    addFriend(friendId, isFriend) {
      if (isFriend === 1) {
        this.$message.success('该用户已经是好友了,禁止再次添加')
      } else {
        this.$refs.addUserFriend.showPopup(friendId)
      }
    },
    //鼠标移入时的特效 
    mouseEnterFriend(item) {
      this.userCurrent = item.userId
    },
    //鼠标移出时的特效 
    mouseLeaveFriend() {
      this.userCurrent = 0;
    },
  },
  computed: {
    //获取公共的url 
    publicUrl() {
      return createPublicUrl()
    }
  },

  watch: {
    $route: {
      handler(route) {
        console.log(route);
        //表示的是页面进入了好友页面
        //,那么就停止这页面中的监听器,开启对应页面的监听器,监听实时返回 
        if (route.name === 'userChat') {
          //关闭持续请求 
          clearInterval(this.interval)
        } else {
          //持续开启 
        }
      },
      immediate: true
    }
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  .containBox {
    margin-top: 70px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}

.userAction {
  margin-top: 10px;
  display: flex;

  .friendBox {
    margin-top: 10px;
    width: 600px;
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;

    .friendBoxHeader {
      padding: 15px 0;
      border-bottom: 2px solid #eee;

      .headerP1 {
        margin-left: 40px;
        font-weight: 700;
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

    .friendBoxMain {
      margin: 10px 0;
      padding: 0 5px;

      .friendItem {
        margin: 10px 0;
        justify-content: space-between;
        cursor: pointer;
        border-radius: 10px;

        .ItemLeft {
          display: flex;
          align-items: center;

          .userImg {
            width: 48px;
            height: 48px;

            img {
              width: 100%;
              height: 100%;
              border-radius: 50%;
            }
          }
        }

        .userName {
          margin-left: 10px;
          font-size: 18px;
          font-weight: 500;
        }

        .hiddenRedPord {
          display: none !important;
        }
      }

      .redPort {
        position: relative;

        .Port {
          display: block;
          position: absolute;
          top: 20px;
          right: 20px;
          width: 12px;
          height: 12px;
          background: red;
          border-radius: 50%;
          z-index: 999;
        }
      }


      .maskFriednBox {
        background-color: #e5e7ea;
      }
    }
  }

  .searchFriendBox {
    margin-top: 10px;
    margin-left: 10px;
    width: 320px;
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;

    .friendBoxHeader {
      padding: 15px 0;
      border-bottom: 2px solid #eee;

      .headerP1 {
        margin-left: 20px;
        font-weight: 700;
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

    .friendBoxSearch {
      display: flex;
      justify-content: center;
    }

    .search {
      margin-top: 5px;
      display: flex;
      position: relative;
      align-items: center;
      width: 90%;

      .searchImg {
        position: absolute;
        top: 8px;
        right: 11px;
        z-index: 999;
        cursor: pointer;
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

    .friendItem {
      margin: 10px 6px;
      justify-content: space-between;
      cursor: pointer;
      border-radius: 10px;

      .ItemLeft {
        display: flex;
        align-items: center;

        .userImg {
          width: 48px;
          height: 48px;

          img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
          }
        }
      }

      .ItemRight {


        z-index: 11;
        width: 80px;
        height: 30px;
        line-height: 30px;

        background: #fc5531;
        border-radius: 23px;
        font-size: 14px;

        color: #fff;
        text-align: center;
      }

      .userName {
        margin-left: 10px;
        font-size: 18px;
        font-weight: 500;
      }
    }

    .friendBoxSearchList {
      margin-top: 10px;
      height: 400px;
      overflow-y: scroll;
    }

  }
}
</style>
