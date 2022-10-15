<template>
    <div class="video-item w">
      <div class="title">
        <div class="title-left">
          <div class="titleInfo">推荐视屏</div>
        </div>
        <div class="title-middle">
          <ul class="middleBox">
            <li class="BoxItem On">数学</li>
            <li class="BoxItem">英语</li>
            <li class="BoxItem">政治</li>
            <li class="BoxItem">计算机网络</li>
            <li class="BoxItem">操作系统</li>
            <li class="BoxItem">组成原理</li>
          </ul>
        </div>
        <div class="title-right">
          <div class="more">
            <router-link :to="{ name: 'videoSelect' }">点击更多</router-link>
          </div>
        </div>
      </div>
      <div class="item-list">
        <ul class="listBox clearfix">
          <li class="course-item">
            <div class="course-img"></div>
            <div class="course-connect">
                <div class="connect-info">教你三分钟速学线性代数</div>
                <div class="connect-bottom">
                    <div class="time">
                        <span>上传时间</span>
                        <span>2022-10-4</span>
                     </div>
                </div>
            </div>
          </li>
          <li class="course-item">
            <div class="course-img"></div>
            <div class="course-connect">
                <div class="connect-info">教你三分钟速学线性代数</div>
                <div class="connect-bottom">
                    <div class="time">
                        <span>上传时间</span>
                        <span>2022-10-4</span>
                     </div>
                </div>
            </div>
          </li>
          <li class="course-item">
            <div class="course-img"></div>
            <div class="course-connect">
                <div class="connect-info">教你三分钟速学线性代数</div>
                <div class="connect-bottom">
                    <div class="time">
                        <span>上传时间</span>
                        <span>2022-10-4</span>
                     </div>
                </div>
            </div>
          </li>
          <li class="course-item">
            <div class="course-img"></div>
            <div class="course-connect">
                <div class="connect-info">教你三分钟速学线性代数</div>
                <div class="connect-bottom">
                    <div class="time">
                        <span>上传时间</span>
                        <span>2022-10-4</span>
                     </div>
                </div>
            </div>
          </li>
          <li class="course-item">
            <div class="course-img"></div>
            <div class="course-connect">
                <div class="connect-info">教你三分钟速学线性代数</div>
                <div class="connect-bottom">
                    <div class="time">
                        <span>上传时间</span>
                        <span>2022-10-4</span>
                     </div>
                </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </template>
  <script>
  export default {
    name:'videoModule',
    data() {
      return {};
    },
  };
  </script>
  <style lang="less" scoped>
  .video-item {
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
            display: block;
            padding: 0 15px;
            border-bottom: 4px solid #fff;
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
        width: 100%;
        .course-item{
            float: left;
            margin: 0px 4px;
            width: 230px;
            height: 200px;
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
            cursor: pointer;
            .course-img{
                width: 100%;
                height: 130px;
                background: red;
            }
            .course-connect{
                padding: 5px;
                font-size: 12px;
                .connect-info{
                    height: 28px;
                    line-height: 18px;
                    overflow: hidden;
                    text-overflow: ellipsis;
                    font-size: 16px;
                    color: #333;
                }
                .time{
                    margin-left: 5px;
                }
            }
        }
        .course-item:hover{
            margin-top: 0px;
            box-shadow: 0 0 10px 2px #918f8f;
            transition: all 0.6s;
        }
      }
    }
  }
  </style>