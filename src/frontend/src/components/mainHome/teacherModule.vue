<template>
  <div class="teacher-item w">
    <div class="title">
      <div class="title-left">
        <div class="titleInfo">老师列表</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li class="BoxItem On">数学资源</li>
          <li class="BoxItem">数学资源</li>
          <li class="BoxItem">数学资源</li>
          <li class="BoxItem">数学资源</li>
          <li class="BoxItem">数学资源</li>
          <li class="BoxItem">数学资源</li>
        </ul>
      </div>
      <div class="title-right">
        <div class="more">
          <router-link :to="{ name: 'teacherSelect' }">点击更多</router-link>
        </div>
      </div>
    </div>
    <div class="item-list">
      <ul class="listBox">
        <li class="listItem">
          <div class="mainBox">
            <ul class="Box">
              <li
                class="BoxItem"
                v-for="item in teachers"
                :key="item.teacherId"
                @click="goTeacherperson(item.teacherId)"
              >
                <div class="item-Info">
                  <div class="itemImg">
                    <img src="../../assets/Img/teacherImg/1.png" alt="" />
                  </div>
                  <div class="itemIntroduce">
                    <div class="Introduce-left">
                      <span class="teacherInfo">{{ item.name }}</span>
                      <span class="professional">数学</span>
                    </div>
                    <div class="Introduce-right">
                      <img src="../../assets/Img/Icon/gestures.png" alt="" />
                      <router-link :to="{ name: 'teacherPerson' }"
                        >点击更多</router-link
                      >
                    </div>
                  </div>
                </div>
                <div class="teacher">
                  <div>{{ item.name }}</div>
                  <p>{{ item.information }}</p>
                  <p>{{ item.background }}</p>
                </div>
              </li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { getTeachers } from "../../service/teacherService";
export default {
  name: "teacherModule",
  data() {
    return {
      teachers: {
        name: "",
        background: "",
        directionName: "",
        information: "",
        teacherId: "",
      },
    };
  },
  created() {
    getTeachers().then((res) => {
      // console.log(res);
      this.teachers = res.data.data;
      console.log(this.teachers);
    });
  },
  methods: {
    goTeacherperson(id) {
      let location = { name: "teacherPerson" };
      location.query = { teacherId: id };
      this.$router.push(location);
      // getTeacher(id).then((res) => {
      //   // console.log(res);
      //   let teacherMsg = res.data.data

      // });
    },
  },
};
</script>


<style lang="less" scoped>
.teacher-item {
  .title {
    display: flex;
    height: 30px;
    line-height: 30px;
    .title-left {
      flex: 1;
      .titleInfo {
        margin-left: 3px;
        padding-left: 8px;
        border-left: 4px solid #4e71f2;
        font-size: 24px;
        font-weight: 700;
        color: #333;
      }
    }
    .title-middle {
      flex: 8;
      .middleBox {
        margin-left: 30px;
        .BoxItem {
          float: left;
          display: flex;
          padding: 0 15px;
          border-bottom: 4px solid #f7f7f7;
          line-height: 27px;
          font-size: 16px;
          cursor: pointer;
          color: #333;
        }
        .On {
          color: #4e71f2;
          border-color: #4e71f2;
        }
      }
    }
    .title-right {
      flex: 1;
      .more {
        float: right;
        font-size: 14px;
        cursor: pointer;
        color: #333;
      }
    }
  }
  .item-list {
    margin-top: 20px;
    .listBox {
      .listItem {
        margin: 0 auto;
        display: block;
        width: 1190px;
        .mainBox {
          overflow: hidden;
          width: 100%;
          height: 100%;
          .Box {
            width: 1500px;
            .BoxItem {
              position: relative;
              margin: 0 5px;
              float: left;
              width: 190px;
              cursor: pointer;
              background: linear-gradient(#e8ebf2, #f8f8fb);
              .item-Info {
                .itemImg {
                  margin: 0 auto;
                  width: 186px;
                  img {
                    margin-top: 10px;
                    width: 100%;
                  }
                }
                .itemIntroduce {
                  display: flex;
                  margin: 5px auto;
                  width: 100%;
                  height: 20px;
                  justify-content: space-between;
                  .Introduce-left {
                    .teacherInfo {
                      padding: 10px 0 0 10px;
                      font-size: 16px;
                      color: #333333;
                    }
                    .professional {
                      align-items: center;
                      margin-left: 5px;
                      padding-left: 5px;
                      font-size: 14px;
                      border-left: 1px solid #333333;
                    }
                  }
                  .Introduce-right {
                    margin-top: 4px;
                    margin-right: 8px;
                    font-size: 12px;
                    img {
                      margin-top: -4px;
                    }
                  }
                }
              }
              .teacher {
                position: absolute;
                // display: none;
                padding-left: 12px;
                padding-top: 42px;
                left: 0;
                top: 0;
                width: 100%;
                height: 236px;
                opacity: 0.5;
                background: rgba(51, 51, 51, 0.6);
                div {
                  font-size: 24px;
                  color: #fff;
                  font-weight: bold;
                  margin-bottom: 13px;
                }
                p {
                  font-size: 12px;
                  line-height: 32px;
                  color: #fff;
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