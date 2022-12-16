<template>
  <div class="teacher-item w">
    <div class="title">
      <div class="title-left">
        <div class="titleInfo">老师列表</div>
      </div>
      <div class="title-middle">
        <ul class="middleBox">
          <li class="BoxItem" :class="{ On: index === current }" v-for="(item, index) in liList" :key="index"
            v-on:click="selectItem(index)">
            {{ item.name }}
          </li>
        </ul>
      </div>
      <div class="title-right">
        <div class="more">
          <router-link :to="{ name: 'teacherSelect' }">点击更多</router-link>
        </div>
      </div>
    </div>
    <div class="item-list">
      <ul class="listBox clearfix" v-for="(fatherItem) in teacherList" :key="fatherItem.id"
        :class="{ showListBox: current === fatherItem.id }">
        <li class="teacher-Item" v-for="(childItem) in fatherItem.children" :key="childItem.teacherId"
          @mouseenter="enterTeacherItem(childItem.teacherId)" 
          @mouseleave="leaveTeacherItem()"
          @click="gotoTeacherPage(childItem.teacherId)">
          <div class="item-Info">
            <div class="itemImg">
              <img src="../../assets/Img/teacherImg/1.png" alt="" />
            </div>
            <div class="itemIntroduce">
              <div class="Introduce-left">
                <span class="teacherInfo">{{ childItem.name }}</span>
                <span class="professional">{{ childItem.directionName }}</span>
              </div>
              <div class="Introduce-right">
                <router-link :to="{ name: 'teacherPerson' }">点击更多</router-link>
              </div>
            </div>
          </div>
          <div class="MaskBox" :class="{ showListBox: maskCurrent === childItem.teacherId }">
            <div>{{ childItem.name }}</div>
            <p>{{ childItem.background }}</p>
            <p>{{ childItem.information }}</p>
          </div>
        </li>



      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "teacherModule",
  data() {
    return {
      liList: [
        { name: '数学' },
        { name: '英语' },
        { name: '政治' },
        { name: '数据结构' },
        { name: '计算机网络' },
        { name: '计算机组成原理' },
      ],
      teacherList: [
        {
          id: 0,
          name: '数学',
          children: [
            {
              teacherId: 1,
              name: '张老师',
              directionName: '数学',
              information: '擅长数学中的线性代数',
              background: '博士研究生'
            },
            {
              teacherId: 4,
              name: '宋老师',
              directionName: '数学',
              information: '擅长数学中的集合问题',
              background: '博士研究生'
            }
          ]
        }, {
          id: 1,
          name: '英语',
          children: [
            {
              teacherId: 5,
              name: '陈老师',
              directionName: '英语',
              information: '擅长阅读理解,理解文字',
              background: '博士研究生'
            },
          ]
        },
        {
          id: 2,
          name: '政治',
          children: [
            {
              teacherId: 6,
              name: '胡老师',
              directionName: '政治',
              information: '押题高手,带你领悟实时政治',
              background: '博士研究生'
            },
          ]
        },
        {
          id: 3,
          name: '数据结构',
          children: [
            {
              teacherId: 7,
              name: '刘老师',
              directionName: '数据结构',
              information: '底层原理,领悟基础',
              background: '博士研究生'
            },
          ]
        },
        {
          id: 4,
          name: '计网',
          children: [
            {
              teacherId: 3,
              name: '王老师',
              directionName: '计网',
              information: '有自己个性教学方法,快速搞懂基础知识',
              background: '博士研究生'
            },
          ]
        },
        {
          id: 5,
          name: '计组',
          children: [
            {
              teacherId: 2,
              name: '李老师',
              directionName: '计组',
              information: '计组基础知识扎实',
              background: '博士研究生'
            },
          ]
        }


      ],
      //表示当前的下标 
      current: 0,
      //遮罩层的下标 
      maskCurrent: 0
    }
  },
  methods: {
    //头部的选择导航栏 
    selectItem(index) {
      this.current = index
    },
    //移入时的特效 
    enterTeacherItem(index) {
      this.maskCurrent = index
    },
    //移除时的特效 
    leaveTeacherItem() {
      this.maskCurrent = 0
    },
    //点击具体的老师时的特效 
    gotoTeacherPage(id) {
      let location = { name: "teacherPerson" };
      location.query = { teacherId: id };
      this.$router.push(location);
    },
}


 
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
      margin: 0 auto;
      display: none;
      width: 1190px;

      .teacher-Item {
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
            }
          }
        }

        .MaskBox {
          position: absolute;
          display: none;
          padding-left: 12px;
          padding-top: 42px;
          left: 0;
          top: 0;
          width: 100%;
          height: 236px;
          opacity: 0.5;
          background: rgba(51, 51, 51, 0.6);
          color: #fff;
          font-size: 14px;

          div {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
          }

          p {
            line-height: 32px;
            margin-bottom: 5px;
          }
        }

        .showListBox {
          display: block;
        }
      }
    }

    .showListBox {
      display: block;
    }
  }
}
</style> -->
