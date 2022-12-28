<template>
  <div class="MainBox w">
    <div class="Main">
      <div class="Main-left">
        <ul class="selectList">
          <li class="item" v-for="(item) in typeSelect" :key="item.id" @click="selsectTeacherType(item.id)">
            <div class="item-icon">
              <img src="../../assets/Img/teacherImg/teacherIcon.png" alt="">
            </div>
            <div class="item-info">{{ item.name }}</div>
          </li>
        </ul>
      </div>
      <div class="Main-right" v-if="judgeDataList">
        <div class="showBox">
          <ul class="teacherList">
            <li class="teacher-Item" v-for="teacherItem in getTeacherList" :key="teacherItem.teacherId"
              @click="gotoPersonView(teacherItem)">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">{{ teacherItem.directionName }}</div>
                </div>
                <div class="p2">{{ (String(teacherItem.name).substring(0, 1)) }}老师</div>
                <div class="p3">五年指导的相关经验</div>
                <div class="p4">
                  赵小五，中国考研数学辅导老师，
                  2003年被评为优秀的骨干教师，2005年获得讲课比赛一等奖，
                  辅导学习人数超十万人
                </div>
                <div class="hot">
                  <div class="hot-left">
                    <img src="../../assets/Img/Icon/gestures.png" alt="" />
                  </div>
                  <div class="hot-right">进入主页</div>
                </div>
              </div>
            </li>
          </ul>
        </div>
        <PagerView :pageInfo="getTeacherPage" @giveFatherPageNo="getSonPageNo"></PagerView>
      </div>
      <div v-else class="noDataImg">
        <div class="notDataBox">
          <img src="../../assets/Img/defaultListImg.png" alt="">
          <span>未找到相关数据</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PagerView from "@/components/remark/PagerView";
import { mapGetters } from "vuex";
export default {
  name: "teacherSelect",
  data() {
    return {
      typeSelect: [
        {
          id: 1,
          name: '考研数学'
        },
        {
          id: 2,
          name: '考研英语'
        },
        {
          id: 3,
          name: '考研政治'
        },
        {
          id: 4,
          name: '数据结构'
        },
        {
          id: 5,
          name: '计算机网络'
        },
        {
          id: 6,
          name: '组成原理'
        }



      ],
      //分页器展示的老师列表的集合 
      teacherList: [],
      //老师的种类
      teacherType: 1,
    }
  },

  components: {
    PagerView,
  },
  mounted() {
    //加载初始化数据 
    this.teacherListData({ teacherType: 1, pageNum: 1 })
  },
  methods: {
    gotoPersonView(teacherItem) {
      let location = { name: 'teacherPerson' }
      location.query = { teacherId: teacherItem.teacherId }
      this.$router.push(location);
    },
    //获取老师列表的相关请求 
    teacherListData({ teacherType, pageNum }) {
      this.$store.dispatch('teacherData/getTeachersData', { teacherType, pageNum })
    },
    //获取分页器传递的数据,并进行获取分页数据 
    getSonPageNo(pageNum) {
      this.$store.dispatch('teacherData/getTeachersData', { teacherType: this.teacherType, pageNum: pageNum })
    },
    //选择不同种类的老师
    selsectTeacherType(typeId) {
      this.teacherType = typeId
      //再将选择的忠烈以及分页器的首页传递后仓库进行请求 
      this.teacherListData({ teacherType: this.teacherType, pageNum: 1 })
    }

  },
  computed: {
    ...mapGetters('teacherData', {
      getTeacherList: 'getTeacherList',   //获取每一页老师所展示的数据
      getTeacherPage: 'getTeacherPage'    //获取老师对应的分页相关的信息
    }),
    judgeDataList() {
      return this.getTeacherList.length !== 0
    },
  }

};
</script>

<style lang="less" scoped>
.MainBox {
  margin-top: 70px;
  background: #f8f8f8;

  .Main {
    display: flex;

    .Main-left {
      flex: 2;

      .item {
        display: flex;
        width: 100%;
        height: 50px;
        align-items: center;
        cursor: pointer;
        padding-left: 60px;

        .item-icon {
          width: 28px;
          height: 28px;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .item-info {
          height: 28px;
          line-height: 28px;
          font-size: 18px;
          color: #333333;
          margin-left: 20px;
        }
      }
    }

    .Main-right {
      flex: 8;

      .showBox {
        padding: 10px 20px;

        .teacherList {
          display: flex;
          justify-content: space-between;
          align-items: center;
          flex-wrap: wrap;

          .teacher-Item {
            position: relative;
            display: flex;
            margin-bottom: 22px;
            padding-top: 16px;
            padding-left: 16px;
            width: 436px;
            height: 267px;
            cursor: pointer;
            background-color: #ffffff;

            .Item-left {
              flex: 15%;
              height: 236px;
              background-image: linear-gradient(0deg, #f5f6fa 0%, #e8ebf2 100%);

              img {
                width: 100%;
              }
            }

            .Item-right {
              flex: 2;

              .p1 {
                width: 100%;
                height: 20px;

                .teacherloge {
                  position: absolute;
                  top: 18px;
                  right: -2px;
                  width: 88px;
                  height: 20px;
                  line-height: 20px;
                  background-color: #ff9d00;
                  border-radius: 10px 0 0 10px;
                  float: right;
                  text-align: center;
                  font-size: 14px;
                  color: #ffffff;
                }
              }

              .p2 {
                text-align: right;
                font-size: 24px;
                color: #333333;
                margin: 16px 20px 10px;
              }

              .p3 {
                text-align: right;
                margin-right: 20px;
                margin-bottom: 10px;
                font-size: 16px;
                color: #ff9d00;
              }

              .p4 {
                text-align: left;
                margin-bottom: 5px;
                margin-right: 30px;
                margin-left: 30px;
                font-size: 14px;
                line-height: 24px;
                color: #999999;
                display: -webkit-box;
                -webkit-box-orient: vertical;
                -webkit-line-clamp: 4;
                overflow: hidden;
              }

              .hot {
                float: right;
                margin-right: 20px;
                display: flex;

                .hot-right {
                  margin-top: 5px;
                  font-size: 12px;
                  color: #999999;
                }
              }
            }
          }
        }
      }
    }
  }
}

.noDataImg {
  flex: 9;
  .notDataBox{
    margin: 0 auto;
    text-align: center;
    width: 320px;
    img {
    width: 100%;
    height: 100%;
  }
  }
}
</style>
