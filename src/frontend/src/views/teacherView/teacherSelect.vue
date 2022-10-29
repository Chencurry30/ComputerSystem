<template>
  <div class="MainBox w">
    <div class="Main">
      <div class="Main-left">
        <ul class="selectList">
          <li class="item">
            <div class="item-icon"></div>
            <div class="item-info">考研数学</div>
          </li>
          <li class="item">
            <div class="item-icon"></div>
            <div class="item-info">考研政治</div>
          </li>
          <li class="item">
            <div class="item-icon"></div>
            <div class="item-info">考研英语</div>
          </li>
          <li class="item">
            <div class="item-icon"></div>
            <div class="item-info">组成原理</div>
          </li>
        </ul>
      </div>
      <div class="Main-right">
        <div class="showBox">
          <ul class="teacherList">
            <li class="teacher-Item" @click="gotoPersonView">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">考研数学</div>
                </div>
                <div class="p2">张小五</div>
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
            <li class="teacher-Item">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">考研数学</div>
                </div>
                <div class="p2">张小五</div>
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
            <li class="teacher-Item">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">考研数学</div>
                </div>
                <div class="p2">张小五</div>
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
            <li class="teacher-Item">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">考研数学</div>
                </div>
                <div class="p2">张小五</div>
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
            <li class="teacher-Item">
              <div class="Item-left">
                <img src="../../assets/Img/teacherImg/1.png" />
              </div>
              <div class="Item-right">
                <div class="p1">
                  <div class="teacherloge">考研数学</div>
                </div>
                <div class="p2">张小五</div>
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
        <PagerView></PagerView>
      </div>
    </div>
  </div>
</template>

<script>
import PagerView from "@/components/remark/PagerView";
export default {
  name: "teacherSelect",
  components: {
    PagerView,
  },
  methods:{
    gotoPersonView(){
      let location = {name:'teacherPerson'}
      // location.params = {teacherId:6};
      location.query = {teacherId:2}
      this.$router.push(location);
    }
  }
};
</script>

<style lang="less" scoped>
.MainBox {
  margin-top: 20px;
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
          background: red;
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
</style>
