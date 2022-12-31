//我的动态
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
                <div>
                  <div class="form-group">
                    <label class="contents">发表我的动态</label>
                    <textarea class="form-control" v-model="contents.content" placeholder="说点什么吧......"></textarea>
                    <el-button type="text" size="large" @click="showDialog = !showDialog">😃</el-button>
                    <VEmojiPicker v-show="showDialog" @select="selectEmoji"></VEmojiPicker>
                    <uploadDypicture></uploadDypicture>
                  </div>
                  <div class="form-group">
                    <button class="btn btn-primary" @click="AddDynamics">发表动态</button>
                  </div>

                  <div class="dynamicsItem" v-for="item in Dynamics" :key="item.dynamicId">
                    <div class="dynamicsItemMain">


                      <div class="dynamicsItemHeader">
                        <div class="dynamiscItemUserImage" @click="gotoPerson(item)">
                          <img v-if="item.author.image === '无'" src="../../assets/Img/defaultUserImg.png" alt="">
                          <img v-else :src="[getpicture + item.author.image]" alt="">
                        </div>
                        <div class="dynamiscItemUserInformation">
                          <div class="nickName">{{ item.author.nickname }}</div>
                          <div class="createDate">{{ item.createDate }}</div>


                        </div>
                      </div>
                      <div class="dynamicsItemMiddle">
                        <div class="middleContent">{{ item.content }}</div>
                      </div>
                      <div class="dynamicsItemBottom">
                        <img :src="[getpicture + item.picture]" v-if="item.picture" alt="">
                      </div>

                    </div>
                  </div>

                  <!--分页表单-->
                  <div class="dynamicsPaging">
                    <el-pagination background layout="prev, pager, next" :total="totals" :page-size="pageSize"
                      @current-change="handleCurrentChange" @prev-click="prevPage" @next-click="nextPage" class="page">
                    </el-pagination>
                  </div>


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
import { VEmojiPicker } from 'v-emoji-picker';
import { createPublicUrl } from '../../utils/index'
import uploadDypicture from '../../components/upload/uploadDypicture'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import { getallDynamics, setDynamics } from '@/service/userServers'
export default {
  data() {
    return {
      showDialog: false,
      Dynamics: [],
      page: 1, //请求第一次的params
      pageSize: 5,
      totals: 0,//页面总条数
      contents: {
        content: '',
        picture: ''
      },
      fileList: [{
        name: '',
        url: ''
      }],
    }
  },
  components: { personAside, personHeader, uploadDypicture,VEmojiPicker },
  name: "myDynamics",
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
    this.GetDynamics()
  },
  methods: {
    selectEmoji(emoji) {
      this.contents.content = this.contents.content + emoji.data
    },
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
    //添加用户动态
    AddDynamics() {
      // console.log(this.contents)
      setDynamics(this.contents).then((res) => {
        if (res.data.code === 406) {
          this.$message.error("内容不能为空")
        } else if (res.data.code === 200) {
          this.$message.success("发布动态成功！")
        }
        this.contents = {}
        // console.log(res)
        this.GetDynamics()
      })
    },
    //获取所有动态
    GetDynamics() {
      getallDynamics(this.page).then((res) => {
        if (res.data.code === 200) {
          this.totals = res.data.data.total
          this.Dynamics = res.data.data.list
        } else if (res.data.code === 417) {
          this.Dynamics = []
          this.totals = 0
        }
      })
    },
    //当前页数改变
    handleCurrentChange(page) {
      this.page = page;
      this.GetDynamics();
    },
    //上一页
    prevPage(page) {
      this.page = page - 1
    },
    //下一页
    nextPage(page) {
      this.page = page + 1
    },
    gotoPerson(item) {
      let location = { name: 'otherPerson' }
      location.query = { userId: item.userId }
      this.$router.push(location)
    }
  },
  computed: {
    afterChangeData() {
      let start = (this.pageNo - 1) * this.pageSize
      let end = this.pageNo * this.pageSize
      return this.Dynamics.slice(start, end)
    },
    ...mapGetters('userInfo',
      {
        getUserImg: 'getUserImg'
      }),
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
    getpicture() {
      return createPublicUrl()
    }
  },
  // eslint-disable-next-line vue/no-deprecated-destroyed-lifecycle
  beforeDestroy() {

  }
};
</script>

<style lang='less' scoped>
.MainBox {


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
    border: 2px solid #eee;
  }

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

.dynamicsItem {
  margin: 10px;
  background-color: #fff;
  border-radius: 4px;
  min-width: 632px;
  position: relative;

  .dynamicsItemMain {
    display: flex;
    flex-direction: column;

    .dynamicsItemHeader {
      display: flex;
      align-items: center;

      .dynamiscItemUserImage {
        margin-left: 10px;
        width: 48px;
        height: 48px;

        img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }

      .dynamiscItemUserInformation {
        margin-left: 10px;
        flex-direction: column;

        .nickName {
          color: rgb(251, 114, 153);
        }

      }
    }

    .dynamicsItemMiddle {
      .middleContent {
        margin-top: 8px;
        margin-left: 10px;
      }
    }

    .dynamicsItemBottom {
      margin-top: 8px;
      margin-left: 10px;

      img {
        width: 220px;
      }
    }


  }
}

.btn-primary {
  margin-left: 800px;
}
</style>
