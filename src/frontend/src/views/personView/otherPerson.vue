<!--这个页面是用来保证用户点击其他用户图像时显示其他用户的相关内容，和个人页面差不过大，所以独立出来-->
<template>
  <div class="MainBox w MainPageHeader">
    <div class="wrapper">
      <div class="wrapper-header">
        <div class="wrapper-user">
          <div class="user-info">
            <div class="user-img">
              <img :src="[publicUrl + userMsg.image]" alt="">
            </div>
            <div class="user-basic">
              <div class="nickName">{{ userMsg.nickname }}</div>
              <div>性别：{{ userMsg.sex }}</div>
              <div>年龄：{{ userMsg.age }}</div>
              <div class="personalProfile">
                个性签名：{{ userMsg.message }}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="navigator">
        <div class="navigator-info">主页</div>
      </div>
    </div>
    <div class="wrapper collect-Main">

      <div class="collect-Main-header">
        <div class="person-title">收藏的视屏</div>
      </div>


      <div class="collect-Main-connect">
        <div class="connect-header">
          <div class="Main-item" v-for="item in Collections" :key="item.videoId">
            <div class="item-img">
              <img :src="[publicUrl + item.image]">
            </div>
            <div class="item-title">{{ item.name }}</div>
            <div class="item-others">
              <div class="left">{{ item.nickname }}</div>
              <div class="right">{{ item.time }}</div>
            </div>
          </div>
        </div>
        <pagerView :pageInfo="collectPage" @giveFatherPageNo="getSonPageNo"></pagerView>
      </div>
      <div class="collect-Main-header">
        <div class="person-title">他的动态</div>
      </div>
      <div class="bili-dyn-item" v-for="item in Dynamics" :key="item.dynamicId">
        <div class="bili-dyn-item__main">
          <div class="bili-dyn-item__avatar">
            <div class="bili-dyn-avatar" style="width: 48px; height: 48px;">
              <div class="bili-avatar" style="width: 48px;height:48px;transform: translate(0px, 0px);">
                <img v-if="item.author.image === '无'" src="../../assets/Img/defaultUserImg.png" alt="">
                <img v-else :src="[getpicture + item.author.image]" alt="">

              </div>
            </div>
          </div>
          <div class="bili-dyn-item__header">
            <div class="bili-dyn-title">
              <span class="bili-dyn-title__text" style="color: rgb(251, 114, 153);">{{ item.author.nickname }}</span>
            </div>
            <div class="bili-dyn-time">{{ item.createDate }}</div>
          </div>
          <div class="picture">
            <div style="color: #222;">{{ item.content }}</div>
            <img :src="[getpicture + item.picture]" v-if="item.picture" alt="">
          </div>
        </div>
      </div>
      <!--分页表单-->
      <el-pagination background layout="prev, pager, next" :total="totals" :page-size="pageSize"
        @current-change="handleCurrentChange" @prev-click="prevPage" @next-click="nextPage" class="page">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getDynamics, getuserMsg, userVideoCollect } from '../../service/userServers'
import { createPublicUrl } from "@/utils";
import PagerView from "@/components/remark/PagerView.vue";

export default {
  name: 'otherPerson',
  components: { PagerView },
  data() {
    return {
      page: 1, //请求第一次的params
      pageSize: 5,
      totals: 0,//页面总条数
      userId: '',
      Dynamics: {},//动态信息
      userMsg: {},//其他用户信息
      Collections: {},//收藏信息
      collectPage: {} //分页器中存储的信息
    }
  },
  mounted() {
    this.userId = this.$route.query.userId
    this.getotherDynamic()
    this.getothersMsg()
    this.getotherCollect(1)
  },
  methods: {
    //获取用户的动态列表
    getothersMsg() {
      getuserMsg(this.userId).then((res => {
        this.userMsg = res.data.data
      }))
    },
    getotherDynamic() {
      getDynamics(this.userId, this.page).then((res => {
        this.Dynamics = res.data.data.list
        this.totals = res.data.data.total
      }))
    },
    //当前页数改变
    handleCurrentChange(page) {
      this.page = page;
      console.log(this.page)
      this.getotherDynamic();
    },
    //上一页
    prevPage(page) {
      this.page = page - 1
    },
    //下一页
    nextPage(page) {
      this.page = page + 1
    },

    //获取用户收藏视屏列表
    getotherCollect(pageNum) {
      console.log(this.userId)
      userVideoCollect(pageNum, this.userId).then((res) => {
        // console.log(res)
        if (res.data.code === 200) {
          let data = {}
          data.pageNo = res.data.data.pageNum     //当前的页码数
          data.pagesize = res.data.data.pageSize  //每一页的大小
          data.total = res.data.data.total        //总共的个数
          data.pageTotal = res.data.data.pages    //总共有几页

          //将获取的分页数据转化给分页器中
          this.collectPage = data
          this.Collections = res.data.data.list
        }
      })
    },
    //获取分页器中传递的数据
    getSonPageNo(pageNum) {
      this.getotherCollect(pageNum)
    },

  },
  computed: {
    publicUrl() {
      return createPublicUrl()
    },
    getpicture() {
      return createPublicUrl()
    },
  },
}
</script>

<style lang="less" scoped>
.el-table {
  padding: 15px;
  width: 100%;
  background: #fff;
  border: 1px solid #eee;
  border-radius: 4px;
  margin-top: 15px;
}

.wrapper {
  width: 1100px;
  margin: 0 auto;
  position: relative;

  .wrapper-header {
    position: relative;
    height: 200px;
    background: url(../../assets/Img/banner/person.png) no-repeat;
    background-size: 100%;

    .wrapper-user {
      display: flex;
      position: absolute;
      bottom: 0;
      z-index: 10;

      .user-info {
        display: flex;
        align-items: center;
        margin-left: 20px;
        padding-bottom: 16px;

        .user-img {
          width: 72px;
          height: 72px;

          img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
          }
        }

        .user-basic {
          margin-left: 20px;
          color: #ffffff;

          .nickName {
            margin-bottom: 5px;
            font-weight: 700;
            line-height: 18px;
            font-size: 18px;
          }

          .personalProfile {
            font-size: 14px;
          }
        }
      }
    }
  }

  .navigator {
    padding: 0 20px;
    height: 66px;
    line-height: 66px;
    background: #fff;
    box-shadow: 0 0 0 1px #eee;
    border-radius: 0 0 4px 4px;

    .navigator-info {
      height: 100%;
      font-size: 18px;
      color: #222;
    }
  }
}

.collect-Main {
  margin-top: 15px;

  .collect-Main-header {
    margin-bottom: 17px;
    border-bottom: 1px solid #eee;

    .person-title {
      line-height: 33px;
      padding: 0 0 15px;
      font-size: 20px;
      color: #000;
    }
  }

  .collect-Main-connect {
    width: 100%;

    .connect-header {
      display: flex;
      flex-wrap: wrap;

      .Main-item {
        margin: 0 0 3px;
        padding: 10px 10px 10px 0;
        width: 275px;

        .item-img {
          width: 100%;
          height: 160px;
          border-radius: 4px;
          background: red;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .item-title {
          line-height: 20px;
          height: 38px;
          margin-top: 6px;
          overflow: hidden;

        }

        .item-others {
          margin-top: 6px;
          display: flex;
          justify-content: space-between;
          white-space: nowrap;
          height: 14px;
          line-height: 14px;
          color: #999;
          font-size: 12px;
        }
      }
    }
  }

}

.bili-dyn-item {
  margin-left: 5%;
  background-color: #fff;
  border-radius: 4px;
  font-family: Helvetica Neue, Helvetica, Arial, Microsoft Yahei, Hiragino Sans GB, Heiti SC, WenQuanYi Micro Hei, sans-serif;
  letter-spacing: 0;
  min-width: 632px;
  position: relative;

  .bili-dyn-item__main {
    padding: 0 12px 0 88px;
    position: relative;

    .bili-dyn-item__avatar {
      height: 48px;
      left: 24px;
      position: absolute;
      top: 24px;
      width: 48px;

      .bili-avatar {
        img {
          width: 100%;
          height: 100%;
        }
      }
    }

    .bili-dyn-item__header {
      height: 73px;
      padding-top: 27px;

      .bili-dyn-title {
        align-items: center;
        display: flex;
        height: 24px;
        width: max-content;

        .bili-dyn-title__text {
          cursor: pointer;
          font-size: 16px;
        }

        .bili-dyn-time {
          color: #99a2aa;
          cursor: pointer;
          font-size: 8px;
          height: 22px;
          line-height: 18px;
          padding-top: 4px;
          transition: color .3s ease;
          user-select: none;
          width: fit-content;
        }
      }
    }
  }
}

.picture {
  margin-top: 10px;
  margin-bottom: 10px;

  img {
    width: 200px;
    margin-top: 10px;
  }
}

.el-pagination {
  margin-left: 5%;
  margin-top: 60px;
}
</style>
