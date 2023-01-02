<!--审核老师-->
<template>
  <div class="home">
    <div class="header"></div>
    <div style="width: 100%" class="tableBox">
      <div class="tableTypeNav">
        <div class="examineId">申请ID</div>
        <div class="name">申请人名称</div>
        <div class="directionName">老师教授的学科</div>
        <div class="background">老师学历背景</div>
        <div class="applyDate">申请时间</div>
        <div class="applyReason">申请理由</div>
        <div class="reviewComment">未通过理由</div>
        <div class="examineStatus">状态</div>
        <div class="action">操作</div>
      </div>
      <div class="tableDataItem" v-for="(fatherItem) in teacherData" :key="fatherItem.examineId">
        <div class="examineId">{{ fatherItem.examineId }}</div>
        <div class="name">{{ fatherItem.name }}</div>
        <div class="directionName">{{ fatherItem.directionName }}</div>
        <div class="background">{{ fatherItem.background }}</div>
        <div class="applyDate">{{ fatherItem.applyDate }}</div>
        <div class="applyReason">{{ fatherItem.applyReason }}</div>
        <div class="reviewComment">{{ fatherItem.reviewComment }}</div>
        <div class="examineStatus">
          <el-tag v-if="fatherItem.examineStatus === 0">未审核</el-tag>
          <el-tag type="success" v-else-if="fatherItem.examineStatus === 1">通&nbsp;&nbsp;&nbsp;过</el-tag>
          <el-tag type="danger" v-else>未通过</el-tag>
        </div>
        <div class="action">
          <el-button type="success" size="mini" @click="agreeRow(fatherItem)" v-has="`system:teacher:sh`"
          v-if="fatherItem.examineStatus === 0 ">同意</el-button>
          <el-button type="danger" size="mini" @click="disagreeRow(fatherItem)"
          v-if="fatherItem.examineStatus === 0 "  v-has="`system:teacher:sh`">不同意</el-button>
        </div>
      </div>
    </div>
    <teacherReply ref="teacherReply"></teacherReply>
  </div>
</template>

<script>
import teacherReply from '../../components/popUp/teacher/teacherReply'
import { getExamine, agreeTeacherApply } from '../../services/teacherManage'
export default {
  name: 'teacherManage',
  data() {
    return {
      teacherData: [],
    }
  },
  components: {
    teacherReply
  },
  mounted() {
    //获取所有的审核列表
    this.getExamineData()
  },
  methods: {
    //获取所有的审核列表 
    getExamineData() {
      getExamine().then((res) => {
        if (res.data.code === 200) {
          this.teacherData = res.data.data
        }
      })
    },
    //同意审核
    agreeRow(row) {
      agreeTeacherApply(row.examineId).then((res) => {
        if (res.data.code === 200) {
          this.$message.success('审核成功！！！')
          this.getExamineData()
        }
      })
    },

    //拒接审核
    disagreeRow(row) {
      this.$refs.teacherReply.showDialog(row)
    }
  }
}
</script>

<style lang="less" scoped>
.header {
  margin-bottom: 20px;
}

.tableBox {
  min-width: 1420px;

  .tableTypeNav,
  .tableDataItem {
    font-size: 18px;
    display: flex;
    align-items: center;
    text-align: center;

    .examineId {
      padding: 12px 0;
      width: 90px;
      height: 100%;
    }

    .name {
      padding: 12px 0;
      width: 160px;
      height: 100%;
    }

    .directionName {
      padding: 12px 0;
      width: 140px;
      height: 100%;
    }

    .background {
      padding: 12px 0;
      width: 150px;
      height: 100%;
    }

    .applyDate {
      padding: 12px 0;
      width: 200px;
      height: 100%;
    }

    .applyReason {
      padding: 12px 0;
      width: 210px;
      height: 100%;
    }

    .reviewComment {
      padding: 12px 0;
      width: 210px;
      height: 100%;

    }

    .action {
      padding: 12px 0;
      width: 200px;
      height: 100%;
    }
  }

  .tableDataItem {
    margin: 10px 0px;
    height: 50px;
    line-height: 50px;
  }

}

.page {
  text-align: center;
  margin-top: 30px;
}
</style>