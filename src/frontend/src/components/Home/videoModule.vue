<template>
  <div class="video-item w">
    <div class="title">
      <div class="title-left">
        <div class="titleInfo">推荐视屏</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li 
          v-for="(item,index) in liList" 
          v-on:click="addClass(index)" 
          v-bind:class="{On:index==current}"
          class="BoxItem">
          {{item.name}}
          </li>
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
            <div class="course-bottom">
              <span>坚持到底,永不放过期</span>
              <span>2022-10-9</span>
            </div>
          </div>
        </li>
        <li class="course-item">
          <div class="course-img"></div>
          <div class="course-connect">
            <div class="connect-info">教你三分钟速学线性代数</div>
          </div>
        </li>
        <li class="course-item">
          <div class="course-img"></div>
          <div class="course-connect">
            <div class="connect-info">教你三分钟速学线性代数</div>
          </div>
        </li>
        <li class="course-item">
          <div class="course-img"></div>
          <div class="course-connect">
            <div class="connect-info">教你三分钟速学线性代数</div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {
  name: 'videoModule',
  data() {
    return {
      liList:[
        {name:'数学'},
        {name:'英语'},
        {name:'政治'},
        {name:'操作系统'},
        {name:'计算机网络'},
        {name:'计算机组成原理'},
      ],
      current:0,
    };
  },
  methods:{
    addClass(index){
      this.current=index
    }
  }
};
</script>
<style lang='less' scoped>
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
      width: 100%;

      .course-item {
        float: left;
        margin: 0px 9px;
        width: 280px;
        height: 210px;
        border-radius: 8px;
        overflow: hidden;
        cursor: pointer;
        transition: all 1s;

        .course-img {
          width: 100%;
          height: 130px;
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
              color: rgba(128, 128, 128, 1);
              margin-top: 2px;
            }
          }
        }

      }

      .course-item:hover {
        margin-top: 0px;
        box-shadow: 0 0 10px 2px #918f8f;
        transition: all 0.8s;
      }
    }
  }
}
</style>
