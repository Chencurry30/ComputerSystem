//我的提问(针对老师)
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">

          <div class="allBox">
            <personHeader></personHeader>
            <div class="allBox">
              <div class="UserBox second">
                这里是针对老师提问的相关记录
                <div class="messageHeraer">
                  <!--这里是评论信息中的一个组件，这里利用父组件向子组件传入参数即可-->
<!--                  <replyItem v-for="(item) in DataList" :key="item.id" :replyInfo="item"></replyItem>-->
                </div>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>
  </div>


</template>

<script>
import { mapGetters } from 'vuex'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
export default {
  data() {
    return {
      DataList: [
        {
          id: 1232,
          image: '1231231231232.123',
          nickname: '高山',
          time: '2022-6-30',
          content: '你的评论对我很有帮助，感谢你的发言',
          resourcename: '回复我的'
        },
        {
          id: 1236,
          image: '1231231231232.123',
          nickname: '高山星空',
          time: '2022-6-9',
          content: '你的评论对我很有帮助，感谢',
          resourcename: '回复我的'
        }
      ]
    }
  },
  components: {personAside,personHeader},
  name: "teacherReply",
  //避免页面刷新导致vuex中的数据丢失
  mounted() {
    this.$store.dispatch('userInfo/getUserInfo')
  },
  methods: {
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
    changeEditor() {
      this.$refs.InfoPopup.showPopup(this.getUserInfo);
    },
  },
  computed: {
    ...mapGetters('userInfo',
      {
        getUserImg: 'getUserImg'
      }),
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
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
  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;
  }

  .second {
    margin-top: 15px;
  }
}
</style>
