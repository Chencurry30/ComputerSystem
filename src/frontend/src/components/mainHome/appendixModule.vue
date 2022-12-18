<template>
  <div class="appendix-item w">
    <div class="title1">
      <div class="title-left">
        <div class="titleInfo">备考资源</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li class="BoxItem" :class="{ On: current === index }" v-for="(item, index) in selectList" :key="index"
            @click="selectItem(index)">
            {{ item.name }}
          </li>
        </ul>
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
        <div class="list-right" v-for="fatherItem in DataDownLoad" :key="fatherItem.id"
          :class="{ showBox: current === fatherItem.id }">
          <div class="title">{{ fatherItem.name }}</div>
          <div class="middleBox">
            <div class="middleContent">
              <div class="uploadLink" v-for="childrenItem in fatherItem.children" :key="childrenItem.downId">
                <a :href="childrenItem.link">{{ childrenItem.name }}</a>
              </div>
            </div>
          </div>
          <div class="middleBottom" v-for="(fatherItem) in DataList" :key="fatherItem.id"
            :class="{ showBox: current === fatherItem.id }">
            <div class="videoList">
              <div class="videoItem" v-for="(childrenItem) in fatherItem.children" :key="childrenItem.videoId"
                @click="gotoVideoPage(childrenItem.videoId)">
                <div class="videoItem-videoImg">
                  <img :src="[publicUrl + childrenItem.videoImage]" alt="视屏图片">
                </div>
                <div class="course-connect">
                  <div class="connect-info">{{ childrenItem.videoName }}</div>
                  <div class="course-bottom">
                    <span>坚持到底</span>
                    <span>{{ childrenItem.videoTime }}</span>
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
import { createPublicUrl } from '../../utils/index'
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
      DataDownLoad: [
        {
          id: 0,
          name: '数学真题',
          children: [
            {
              downId: 10001,
              name: '2020-2019考研数学一题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2010-2019-1.rar'
            },
            {
              downId: 10002,
              name: '2020-2019考研数学二题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2010-2019-2.rar'
            },
            {
              downId: 10003,
              name: '2020考研数学一题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2020-1.rar'
            },
            {
              downId: 10004,
              name: '2020考研数学二题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2020-2.rar'
            },
            {
              downId: 10005,
              name: '2021考研数学一题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2021-1.rar'
            },
            {
              downId: 10006,
              name: '2021考研数学二题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/math/2021-2.rar'
            }
          ]
        },
        {
          id: 1,
          name: '英语',
          children:[
          {
              downId: 10007,
              name: '2017考研数学一题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/English/2017-1.rar'
            }
          ]
        },
        {
          id: 2,
          name: '政治',
          children:[
          {
              downId: 10008,
              name: '2018考研政治题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/political/2018.pdf'
            },
            {
              downId: 10009,
              name: '2020考研政治题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/political/2020.pdf'
            },
            {
              downId: 10010,
              name: '2021考研政治题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/political/2021.pdf'
            }
          ]
        },
        {
          id: 3,
          name: '数据结构',
          children:[
          {
              downId: 10011,
              name: '2016研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2016-408.rar'
            },
            {
              downId: 10012,
              name: '2017考研政治题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2017-408.rar'
            },
            {
              downId: 10013,
              name: '2018考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2018-408.rar'
            },
            {
              downId: 10014,
              name: '2019考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2019-408.rar'
            },
            {
              downId: 10015,
              name: '2020考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2020-408.rar'
            }
          ]
        },
        {
          id: 4,
          name: '计算机组成原理',
          children:[
          {
              downId: 10016,
              name: '2016研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2016-408.rar'
            },
            {
              downId: 10017,
              name: '2017考研政治题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2017-408.rar'
            },
            {
              downId: 10018,
              name: '2018考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2018-408.rar'
            },
            {
              downId: 10019,
              name: '2019考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2019-408.rar'
            },
            {
              downId: 10020,
              name: '2020考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2020-408.rar'
            }
          ]
        },
        {
          id: 5,
          name: '计算机网络',
          children:[
          {
              downId: 10021,
              name: '2016研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2016-408.rar'
            },
            {
              downId: 10022,
              name: '2017研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2017-408.rar'
            },
            {
              downId: 10023,
              name: '2018考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2018-408.rar'
            },
            {
              downId: 10024,
              name: '2019考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2019-408.rar'
            },
            {
              downId: 10025,
              name: '2020考研408题目含答案',
              link: 'https://system-1234.oss-cn-chengdu.aliyuncs.com/resourcesDown/others/2020-408.rar'
            }
          ]
        }
      ],

    }
  },
  methods: {
    selectItem(index) {
      this.current = index
    },
    //根据点击的视屏跳转到对应的页面 
    gotoVideoPage(videoId) {
      let location = {
        name: 'videoPage'
      }
      location.query = { videoId: videoId }
      this.$router.push(location)
    }
  },
  computed: {
    publicUrl() {
      return createPublicUrl()
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

    .titleInfo {
      margin-left: 3px;
      padding-left: 8px;
      border-left: 4px solid #4e71f2;
      font-size: 24px;
      font-weight: 700;
      color: #333;
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
        display: none;
        margin-left: 20px;
        flex: 1;

        .middleBox {
          margin-top: 10px;
        }

        .middleBottom {
          margin-top: 10px;
          display: none;

          .videoList {
            margin-top: 15px;

            .videoItem {
              float: left;
              margin: 0 9px;
              width: 215px;
              height: 190px;
              border-radius: 8px;
              overflow: hidden;
              cursor: pointer;

              .videoItem-videoImg {
                width: 100%;
                height: 120px;

                img {
                  width: 100%;
                  height: 100%;
                }
              }

              .course-connect {
                padding: 5px;
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
        
        .showBox {
          display: block;
        }
      }

      .showBox {
        display: block;
      }
    }
  }

  .middleContent {
    margin-top: 5px;

    .uploadLink {
      font-size: 16px;
      color: #333;
      padding-left: 20px;
      line-height: 33px;
    }
  }
}
</style>
