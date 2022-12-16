<template>
  <div class="video-item w">
    <div class="title">
      <div class="title-left">
        <div class="titleInfo">推荐视屏</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li v-for="(item, index) in liList" :key="index" v-on:click="addClass(index)"
            v-bind:class="{ On: index === current }" class="BoxItem">
            {{ item.name }}
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
      <ul class="listBox clearfix" :class="{ hiddenListBox: current === fatherItem.id }"
        v-for="(fatherItem) in DataList" :key="fatherItem.id">
        <li class="course-item" v-for="(childItem) in fatherItem.children" :key="childItem.videoId"
        @click="gotoVideoPage(childItem.videoId)">
          <div class="course-img">
            <img :src="[publicUrl + childItem.videoImage]" alt="视屏图片">
          </div>
          <div class="course-connect">
            <div class="connect-info">{{childItem.videoName}}</div>
            <div class="course-bottom">
              <span>坚持到底,筑梦前行</span>
              <span>{{childItem.videoTime}}</span>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import { createPublicUrl } from '../../utils/index'
export default {
  name: 'videoModule',
  data() {
    return {
      liList: [
        { name: '数学' },
        { name: '英语' },
        { name: '政治' },
        { name: '数据结构' },
        { name: '计算机组成原理'},
        { name: '计算机网络' },
      ],
      DataList: [
        {
          id: 0,
          name: '数学',
          children: [
            {
              videoId: 14,
              videoImage: 'video/videoImg/8794027591208.jpg',
              videoName: '考研数学历年真题全解析 2021年 数学二',
              videoTime: '2022-10-15 16:12:31'
            },
            {
              videoId: 2,
              videoImage: 'video/videoImg/8794737791208.jpg',
              videoName: '考研数学历年真题全解析 2022年 数学三',
              videoTime: '2022-10-15 16:12:31'
            },
            {

              videoId: 8,
              videoImage: 'video/videoImg/8794027591208.jpg',
              videoName: '考研数学历年真题全解析 2022年 数学二',
              videoTime: '2022-10-15 16:12:31'
            },
            {

              videoId: 20,
              videoImage: 'video/videoImg/4389035031208.jpg',
              videoName: '考研数学历年真题全解析 2021年 数学三',
              videoTime: '2022-10-15 16:12:31'
            }
          ]
        },
        {
          id: 1,
          name: '英语',
          children: [
            {
              videoId: 1,
              videoImage: 'video/videoImg/7820996031208.jpg',
              videoName: '17分钟看完颉斌斌的阅读思维和技巧,搭配思维导图,真的很绝!|考研英语',
              videoTime: '2022-10-15 16:10:52'
            },
            {
              videoId: 7,
              videoImage: 'video/videoImg/2461442091192.jpg',
              videoName: '22考研英语阅读逐年刷题精讲(考研党必备:包含考研阅读英语一和英语二)',
              videoTime: '2022-10-15 16:10:52'
            },
            {

              videoId: 13,
              videoImage: 'video/videoImg/5405241871208.jpg',
              videoName: '『英一80分』b站最全考研英语全年全板块规划|备考阶段划分及名师推荐|书籍购买指南|备考注意事项',
              videoTime: '2022-10-15 16:10:52'
            },
            {

              videoId: 19,
              videoImage: 'video/videoImg/8769878421208.jpg',
              videoName: '23大作文万能模板!直接背!英一保16分,英二保12分!【23考研英语,含新大纲】',
              videoTime: '2022-10-15 16:10:55'
            }
          ]
        },
        {
          id: 2,
          name: '政治',
          children: [
            {
              videoId: 3,
              videoImage: 'video/videoImg/8603807931208.jpg',
              videoName: '考研政治83分秘诀:轻松可复制,直接照着学!',
              videoTime: '2022-10-13 17:30:00'
            },
            {
              videoId: 9,
              videoImage: 'video/videoImg/8532397971208.jpg',
              videoName: '考研政治要背诵的,只有这些,不要瞎背!!【23考研政治】',
              videoTime: '2022-10-15 16:20:06'
            },
            {

              videoId: 15,
              videoImage: 'video/videoImg/8476651631208.png',
              videoName: '55min学完马原!精简版,无废话![唯物史观]',
              videoTime: '2022-10-15 16:20:06'
            },
            {

              videoId: 21,
              videoImage: 'video/videoImg/8476602081208.png',
              videoName: '55min学完马原!精简版!无废话![认识论]',
              videoTime: '2022-10-15 16:20:06'
            }
          ]
        },
        {
          id: 3,
          name: '数据结构',
          children: [
            {
              videoId: 5,
              videoImage: 'video/videoImg/7982299611192.jpg',
              videoName: '小强计算机考研-数据结构考研[严蔚敏]',
              videoTime: '2022-10-15 16:23:21'
            },
            {
              videoId: 11,
              videoImage: 'video/videoImg/7982278131192.jpg',
              videoName: '小强计算机考研-数据结构考研[严蔚敏]',
              videoTime: '2022-10-15 16:23:21'
            },
            {

              videoId: 17,
              videoImage: 'video/videoImg/7982237631192.jpg',
              videoName: '小强计算机考研-数据结构考研[严蔚敏]',
              videoTime: '2022-10-15 16:23:21'
            },
            {

              videoId: 23,
              videoImage: 'video/videoImg/7982182751192.jpg',
              videoName: '小强计算机考研-数据结构考研[严蔚敏]',
              videoTime: '2022-10-15 16:23:21'
            }
          ]
        },
        {
          id: 4,
          name: '计算机组成原理',
          children: [
            {
              videoId: 6,
              videoImage: 'video/videoImg/7506180041208.jpg',
              videoName: '408考研138分学长|计组高分经验',
              videoTime: '2022-10-15 16:24:21'
            },
            {
              videoId: 12,
              videoImage: 'video/videoImg/8308910401208.jpg',
              videoName: ' 计组过完一轮跟没学一样?一张图帮你完成408考研组成原理章节知识点梳理以及重点解题技巧',
              videoTime: '2022-10-15 16:24:21'
            },
            {

              videoId: 18,
              videoImage: 'video/videoImg/8587408771208.jpg',
              videoName: '【408考研138分】计组:一次搞定大端小端and对齐',
              videoTime: '2022-10-15 16:24:21'
            },
            {

              videoId: 24,
              videoImage: 'video/videoImg/8325129101208.jpg',
              videoName: '如何养成408考研的计组指令系统的大题解题思路?看完打通任督二脉',
              videoTime: '2022-10-15 16:24:21'
            }
          ]
        },
        {
          id: 5,
          name: '计算机网络',
          children: [
            {
              videoId: 4,
              videoImage: 'video/videoImg/8931305331208.jpg',
              videoName: '60分钟理清计算机网络,期末、考研必备,节约一半复习时间(上)',
              videoTime: '2022-10-15 16:22:27'
            },
            {
              videoId: 10,
              videoImage: 'video/videoImg/8931431301208.jpg',
              videoName: '60分钟理清计算机网络,期末、考研必备,节约一半复习时间(下)',
              videoTime: '2022-10-15 16:22:27'
            },
            {

              videoId: 16,
              videoImage: 'video/videoImg/4543790921208.jpg',
              videoName: '【408考研】历年计网大题串讲',
              videoTime: '2022-10-15 16:22:27'
            },
            {

              videoId: 22,
              videoImage: 'video/videoImg/7691976861208.jpg',
              videoName: '408(计组+操作系统+数据结构+计网)王道计算机考研专栏万字笔记-祝您考研顺利',
              videoTime: '2022-10-15 16:22:27'
            }
          ]
        }
      ],
      current: 0,
    };
  },
  methods: {
    addClass(index) {
      this.current = index
    },
    gotoVideoPage(videoId){
      let location = {
        name:'videoPage'
      }
      location.query = {videoId:videoId}
      this.$router.push(location)
    }
  },
  computed: {
    //计算出公共的路径 
    publicUrl() {
      return createPublicUrl()
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
          border-bottom: 4px solid #ffffff;
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
      display: none;
      width: 100%;

      .course-item {
        float: left;
        margin: 0 9px;
        width: 280px;
        height: 240px;
        border-radius: 8px;
        overflow: hidden;
        cursor: pointer;
        transition: all 1s;

        .course-img {
          width: 100%;
          height: 170px;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .course-connect {
          padding: 10px;
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
        margin-top: 0;
        box-shadow: 0 0 10px 2px #918f8f;
        transition: all 0.8s;
      }
    }

    .hiddenListBox {
      display: block;
    }
  }
}
</style>
