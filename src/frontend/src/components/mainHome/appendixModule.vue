<template>
  <div class="appendix-item w">
    <div class="title1">
      <div class="title-left">
        <div class="titleInfo">备考资源</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li class="BoxItem On" v-for="(item, index) in selectList" :key="index">
            {{ item.name }}
          </li>
        </ul>
      </div>
      <div class="title-right">
        <div class="more">点击更多</div>
      </div>
    </div>
    <div class="item-list">
      <div class="list-connect">


        <div class="list-left">
          <div class="title1">推荐院校</div>
          <div class="itemBox clearfix">
            <Swiper></Swiper>
          </div>
          <div class="title2">院校地区</div>
          <div class="itemBox">
            <dl>
              <dt>一区</dt>
              <dd>北京</dd>
              <dd>天津</dd>
              <dd class="first">上海</dd>
              <dd>江苏</dd>
              <dd>更多</dd>
              <dt>二区</dt>
              <dd>广西</dd>
              <dd>海南</dd>
              <dd class="first">贵州</dd>
              <dd>云南</dd>
              <dd>更多</dd>
              <dt>三区</dt>
              <dd>新疆</dd>
              <dd>西藏</dd>
              <dd class="first">甘肃</dd>
              <dd>青海</dd>
              <dd>更多</dd>
            </dl>
          </div>
        </div>

        <div class="list-right">
          <div class="title">资源下载</div>
          <div class="middleBox">
            <div class="middle-left">
              <div class="middleHeader">
                <div class="title1">数学真题</div>
                <div class="more">More</div>
              </div>
              <div class="middleContent">
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
              </div>
            </div>
            <div class="middle-right">
              <div class="middleHeader">
                <div class="title1">数学真题</div>
                <div class="more">More</div>
              </div>
              <div class="middleContent">
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
                <p>考研数学三真题及答案汇总</p>
              </div>
            </div>
          </div>
          <div class="middleBottom">
            <div class="title1">相关视屏</div>

            <div class="videoList">
              <div class="videoItem">
                <div class="videoItem-videoImg"></div>
                <div class="course-connect">
                  <div class="connect-info">教你三分钟速学线性代数</div>
                  <div class="course-bottom">
                    <span>坚持到底</span>
                    <span>2022-10-9</span>
                  </div>
                </div>
              </div>
              <div class="videoItem">
                <div class="videoItem-videoImg"></div>
                <div class="course-connect">
                  <div class="connect-info">教你三分钟速学线性代数</div>
                  <div class="course-bottom">
                    <span>坚持到底</span>
                    <span>2022-10-9</span>
                  </div>
                </div>
              </div>
              <div class="videoItem">
                <div class="videoItem-videoImg"></div>
                <div class="course-connect">
                  <div class="connect-info">教你三分钟速学线性代数</div>
                  <div class="course-bottom">
                    <span>坚持到底</span>
                    <span>2022-10-9</span>
                  </div>
                </div>
              </div>
              <div class="videoItem">
                <div class="videoItem-videoImg"></div>
                <div class="course-connect">
                  <div class="connect-info">教你三分钟速学线性代数</div>
                  <div class="course-bottom">
                    <span>坚持到底</span>
                    <span>2022-10-9</span>
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
import Swiper from './swiper.vue';
export default {
  name: "appendixModule",
  components: { Swiper },
  data() {
    return {
      selectList: [
        { name: '数学' },
        { name: '英语' },
        { name: '政治' },
        { name: '数据结构' },
        { name: '计算机网络' },
        { name: '计算机组成原理' },
      ],
      //表示当前的下标 
      current: 0,
    }
  }
}
</script>

<style lang="less" scoped>
.appendix-item {
  background: #fff;

  .title {
    height: 18px;
    line-height: 18px;
    padding-left: 9px;
    border-left: solid 4px #4e71f2;
    font-size: 16px;
    color: #333333;
    font-weight: 700;
  }

  .title1 {
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
          display: block;
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

    .titleInfo {
      margin-left: 3px;
      padding-left: 8px;
      border-left: 4px solid #4e71f2;
      font-size: 24px;
      font-weight: 700;
      color: #333;
    }

  }

  .middleHeader {
    display: flex;
    padding: 0 10px;
    justify-content: space-between;
  }

  .middleContent {
    margin-top: 10px;

    p {
      font-size: 14px;
      color: #333;
      padding-left: 20px;
      line-height: 33px;
    }
  }

  .item-list {
    padding: 25px 15px;

    .list-connect {
      display: flex;

      .list-left {
        width: 214px;
        height: 496px;

        .title1,
        .title2 {
          height: 18px;
          line-height: 18px;
          padding-left: 9px;
          border-left: solid 4px #4e71f2;
          font-size: 16px;
          color: #333333;
          font-weight: 700;
        }

        .itemBox {
          margin: 5px auto;

          dt,
          dd {
            margin-top: 10px;
            float: left;
            width: 64px;
            text-align: center;
            height: 26px;
            line-height: 26px;
            font-size: 14px;
            border-radius: 45px;
          }

          dt {
            color: #fff;
            background-color: #FF9D00;
          }

          dd {
            margin-left: 10px;
            color: #333;
            border: solid 1px #EDEDED;
          }
        }
      }

      .list-right {
        margin-left: 20px;
        flex: 1;

        .middleBox {
          display: flex;
          margin-top: 10px;

          .middle-left {
            flex: 1;

            .more {
              margin-right: 30px;
              font-size: 14px;
              color: #999999;
              height: 18px;
              line-height: 18px;
            }
          }

          .middle-right {
            flex: 1;

            .more {
              margin-right: 30px;
              font-size: 14px;
              color: #999999;
              height: 18px;
              line-height: 18px;
            }
          }
        }

        .middleBottom {
          margin-top: 10px;

          .videoList {
            margin-top: 15px;

            .videoItem {
              float: left;
              margin: 0 9px;
              width: 215px;
              height: 210px;
              border-radius: 8px;
              overflow: hidden;
              cursor: pointer;

              .videoItem-videoImg {
                width: 100%;
                height: 100px;
                background: red;
              }

              .course-connect {
                padding: 15px;
                width: 100%;
                border-radius: 0 0 6px 6px;

                .connect-info {
                  width: 100%;
                  text-overflow: ellipsis;
                  white-space: nowrap;
                  overflow: hidden;
                }

                .course-bottom {
                  display: flex;
                  justify-content: space-between;
                  padding-top: 9px;

                  span {
                    font-size: 12px;
                    font-family: Microsoft YaHei;
                    font-weight: 400;
                    color: #808080;
                    margin-top: 2px;

                  }
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
