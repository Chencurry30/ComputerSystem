<!--组卷的弹窗-->
<template>
  <div class="questionDialog" v-show="dialogVisible">
    <div class="DialogBox">
      <div class="DialogHeader">
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
        <div class="Dialogtitle centerLocation">组卷中心</div>
      </div>
      <div class="DialogMain">

        <p>请选择题型</p>
        <div class="title1">
          <div class="selectItem" :data-typeId="1" @click="selectNumber" :class="{ activeOn: !showId1 }">选择题</div>
          <div class="selectItem" :data-typeId="2" @click="selectNumber" :class="{ activeOn: !showId2 }">多选题</div>
          <div class="selectItem" :data-typeId="3" @click="selectNumber" :class="{ activeOn: !showId3 }">填空题</div>
          <div class="selectItem" :data-typeId="4" @click="selectNumber" :class="{ activeOn: !showId4 }">解答题</div>
        </div>

        <p>题量设置</p>
        <div class="title2">
          <div class="title2Item" :class="{ hiddenBox: showId1 }">
            <em>选择</em>
            <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.singleChoiceNum">
          </div>
          <div class="title2Item" :class="{ hiddenBox: showId2 }">
            <em>多选</em>
            <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.multipleChoiceNum">
          </div>
          <div class="title2Item" :class="{ hiddenBox: showId3 }">
            <em>填空</em>
            <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.judgeNum">
          </div>
          <div class="title2Item" :class="{ hiddenBox: showId4 }">
            <em>解答</em>
            <input type="text" placeholder="输入题量" maxlength="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
              v-model="selectInput.answerNum">
          </div>

        </div>

        <p>科目设置</p>
        <div class="title3">
          <div class="selectItem" v-for="(subjectItem) in subjectList" :key="subjectItem.classifyId"
            @click="selectSubject(subjectItem)" :class="{ activeOn: subjectId === subjectItem.classifyId }">
            {{ subjectItem.name }}
          </div>
        </div>
      </div>
      <div class="DialogBottom" @click="submitSelect">点击组卷</div>
    </div>
  </div>
</template>
  
<script>
export default {
  name: "questionPopup",
  data() {
    return {
      dialogVisible: false,
      showId1: true,
      showId2: true,
      showId3: true,
      showId4: true,
      difficultyId: 0,
      //选择科目的组卷ID 
      subjectId: 0,
      subjectList: [
        {
          classifyId: 2,
          name: '数学'
        },
        {
          classifyId: 3,
          name: '政治'
        },
        {
          classifyId: 4,
          name: '数据结构'
        },
        {
          classifyId: 5,
          name: '计网'
        },
        {
          classifyId: 6,
          name: "计组"
        }
      ],
      selectInput: {
        singleChoiceNum: 0,
        multipleChoiceNum: 0,
        completionNum: 0,
        answerNum: 0,
      }
    };
  },
  methods: {
    showPopup() {
      this.dialogVisible = true;
    },
    closePopup() {
      this.dialogVisible = false
    },
    selectNumber(e) {
      let element = e.target
      let { typeid } = element.dataset
      if (typeid === '1') {
        this.showId1 = !this.showId1
      } else if (typeid === '2') {
        this.showId2 = !this.showId2
      } else if (typeid === '3') {
        this.showId3 = !this.showId3
      } else {
        this.showId4 = !this.showId4
      }
    },
    selectSubject(subjuctItem) {
      this.subjectId = subjuctItem.classifyId
    },
    //将选项通过路由传递到对应的页面，避免出现刷新导致数据丢失 
    submitSelect() {
      if (this.subjectId === 0) {
        this.$message({
          message: "请选择要组卷的题目",
          type: "error",
        })
      } else if (this.selectInput.singleChoiceNum === 0 &&
        this.selectInput.multipleChoiceNum === 0 &&
        this.selectInput.completionNum === 0 &&
        this.selectInput.answerNum === 0) {
        this.$message({
          message: "请至少选择一项组卷题目的类型",
          type: "error",
        })
      } else {
        let data = {}
        data.classifyId = this.subjectId
        data.singleChoiceNum = this.selectInput.singleChoiceNum,
          data.multipleChoiceNum = this.selectInput.multipleChoiceNum,
          data.completionNum = this.selectInput.completionNum,
          data.answerNum = this.selectInput.answerNum

        let location = {
          name: 'questionVolume'
        }
        location.query = {
          classifyId: this.subjectId,
          singleChoiceNum: parseInt(this.selectInput.singleChoiceNum),
          multipleChoiceNum: parseInt(this.selectInput.multipleChoiceNum),
          completionNum: parseInt(this.selectInput.completionNum),
          answerNum: parseInt(this.selectInput.answerNum),
        }
        this.$message({
          message: "欢迎来到组卷页面",
          type: "success",
        })
        this.$router.push(location)
      }
    },
  },
};
</script>
  
<style lang="less" scoped>
.DialogBox {
  position: relative;
  top: 50%;
  left: 50%;
  width: 460px;
  height: 450px;
  border-radius: 16px;
  transform: translateX(-50%) translateY(-50%);
  background: #ffffff;

  .DialogMain {
    .mid-title {
      padding: 15px;
      text-align: left;
    }

    .title1 {
      margin: 5px 10px;
      display: flex;
    }

    .title2 {
      display: flex;
      line-height: 30px;
      margin-bottom: 10px;

      .title2Item {
        margin: 5px 2px;

        em {
          color: #fff;
          background-color: #2489f6;
          text-align: center;
          float: left;
          min-width: 48px;
          padding: 0 5px;
        }

        input {
          padding: 0 15px;
          width: 62px;
          height: 30px;
          line-height: 30px;
          border: 1px solid #e8e8e8;
          border-top-right-radius: 6px;
          border-bottom-right-radius: 6px;
        }
      }

    }

    .title3 {
      display: flex;

    }

    .selectItem {
      margin: 5px 10px;
      height: 34px;
      line-height: 34px;
      min-width: 64px;
      padding: 0 8px;
      color: #666666;
      background-color: #e8e8e8;
      cursor: pointer;
      text-align: center;
      border-radius: 4px;
    }

    .activeOn {
      color: #ffffff;
      background-color: #4a9efa;
    }

    p {
      margin-left: 10px;
      padding: 10px 0;
      text-align: left;
      color: #666666;

    }











  }

  .DialogBottom {
    margin: 30px auto 5px;
    display: flex;
    justify-content: center;
    width: 80%;
    height: 40px;
    line-height: 40px;
    border-radius: 8px;
    text-align: center;
    cursor: pointer;
    color: #ffffff;
    background-color: #4a9efa;
  }
}
</style>
  