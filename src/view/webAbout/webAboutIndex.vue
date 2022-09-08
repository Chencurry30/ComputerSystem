<template>
  <div class="main-Box">
    <div class="Box w">
      <div class="Box-left">
        <div class="showtitle">
          <div class="fontwelcom">
            <em>欢迎来到</em>
            <i>旭升</i>
          </div>
          <div class="left-font">考研平台！</div>
        </div>
        <div class="showinfo">
          <span
            >始终把以人为本，为用户服务，坚持严格的资源审核，为用户负责，讲
            辅助用户考研做到正规化、规范化。
          </span>
        </div>
        <div class="seg">
          <span></span>
        </div>
        <div class="cloumn_contain">
          <span>
            安全驾驶驾驶学院设计课程时考虑到了忙碌的学生。我们有一个非常灵活的课程系统，
            允许学生按照自己的意愿和自己的节奏参加课程。在一些学校，你有一个非常严格的课程安排，
            这不适用于孩子忙碌生活的许多当前时间表。
          </span>
        </div>

        <div class="cloumn_icon_list">
          <ul class="cloumn_box">
            <li class="cloumn_item">
              <div class="item_icon">
                <img src="@/assets/Img/Icon/1.png" alt="" />
              </div>
              <div class="item_info">
                <div class="item_title">更新数据</div>
                <div class="item_info">实时跟新相关数据</div>
              </div>
            </li>
            <li class="cloumn_item">
              <div class="item_icon">
                <img src="@/assets/Img/Icon/2.png" alt="" />
              </div>
              <div class="item_info">
                <div class="item_title">服务透明</div>
                <div class="item_info">进度网上随时可查</div>
              </div>
            </li>
            <li class="cloumn_item">
              <div class="item_icon">
                <img src="@/assets/Img/Icon/3.png" alt="" />
              </div>
              <div class="item_info">
                <div class="item_title">名师解答</div>
                <div class="item_info">帮助解答疑难问题</div>
              </div>
            </li>
            <li class="cloumn_item">
              <div class="item_icon">
                <img src="@/assets/Img/Icon/4.png" alt="" />
              </div>
              <div class="item_item">
                <div class="item_title">服务水平</div>
                <div class="item_info">软件服务日益提高</div>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="Box-right">2</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "webAboutIndex",
};
</script>

<style lang="less" scoped>
.main-Box {
  margin-top: 30px;
  width: 100%;
  .Box {
    display: flex;
    .Box-left {
      flex: 60%;
      margin: 60px 0 40px 0;
      padding: 0 40px;
      .showtitle {
        .fontwelcom {
          font-weight: 700;
          font-size: 38px;
          em {
            color: #f4ca59;
          }
          i {
            color: #242327;
          }
        }
        .left-font {
          font-weight: 700;
          font-size: 38px;
          color: #242327;
        }
      }
      .showinfo {
        padding: 30px 0;
        line-height: 26px;
        span {
          font-size: 18px;
          color: #8e8c9a;
          font-family: arial;
        }
      }
      .seg {
        margin-bottom: 40px;
        position: relative;
        height: 20px;
        border-bottom: 1px solid #8e8c9a;
        ::before {
          content: "";
          position: absolute;
          bottom: -2px;
          left: 0;
          width: 100px;
          height: 5px;
          background-color: #f4ca59;
        }
      }
      .cloumn_contain {
        padding-bottom: 20px;
        line-height: 26px;
        span {
          font-size: 15px;
          color: #9193a0;
        }
      }
      .cloumn_icon_list {
        .cloumn_box {
          .cloumn_item {
            float: left;
            display: flex;
            margin: 10px 65px;
            .item_icon {
              width: 56px;
              img {
                width: 100%;
              }
            }
            .item_title {
              padding: 0 0 5px 10px;
              font-size: 20px;
              color: #000000;
            }
            .item_info {
              padding: 0 0 5px 10px;
              font-size: 16px;
              color: #8a8a9a;
            }
          }
        }
      }
    }
    .Box-right {
      flex: 40%;
      background-color: blue;
    }
  }
}
</style>