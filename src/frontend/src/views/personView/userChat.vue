//我的动态
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <div class="friendBox">
              <div class="friendBoxHeader">
                <span class="headerP1">我的好友</span>
                <span class="headerP2">My Friend</span>
                <span class="headerP3">SETTINGS</span>
              </div>
              <div class="friendBoxMain">
                <div class="friendItem centerLocation">
                  <div class="ItemLeft">
                    <div class="userImg">
                      <img src="../../assets/Img/defaultUserImg.png" alt="">
                    </div>
                    <div class="userName">张三</div>
                  </div>
                  <div class="ItemRight">
                    <button @click="showPopupBox">点击聊天</button>
                  </div>
                </div>
              </div>
              <ChatPopup ref="ChatPopup"></ChatPopup>
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
import { } from '@/service/userServers'
export default {
  data() {
    return {
    }
  },
  components: { personAside, personHeader,ChatPopup },
  name: "teacherReply",
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
  },
  methods:{
    showPopupBox(){
      this.$refs.ChatPopup.showPopup()
    }
  }


};
</script>

<style lang='less' scoped>
.MainBox {
  margin-top: 70px;

  .containBox {
    margin-top: 5px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}

.allBox {
  .second {
    margin-top: 15px;

    .contents {
      font-size: 18px;
      font-weight: bold;
      width: 100%;
      Text-align: center;

    }
  }
}

.friendBox {
  margin-top: 15px;
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
    padding: 0 20px;

    .friendItem {
      justify-content: space-between;
      .ItemLeft {
        display: flex;
        align-items: center;
        .userImg {
          width: 48px;
          height: 48px;

          img {
            width: 100%;
            border-radius: 50%;
          }
        }
      }

      .userName {
        margin-left: 10px;
        font-size: 18px;
        font-weight: 500;
      }
    }
  }
}
</style>
