<!--审核老师-->
<template>
  <div class="appMain">
    <div class="filter-container"></div>
    <div style="width: 100%" class="filter-table">
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
            v-if="fatherItem.examineStatus === 0">同意</el-button>
          <el-button type="danger" size="mini" @click="disagreeRow(fatherItem)" v-if="fatherItem.examineStatus === 0"
            v-has="`system:teacher:sh`">不同意</el-button>
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
.filter-table {
  min-width: 1420px;

  .tableTypeNav,
  .tableDataItem {
    display: flex;
    align-items: center;
    text-align: center;

    .examineId,
    .name,
    .directionName {
      width: 140px;
    }

    .background {
      width: 140px;
    }

    .applyDate {
      width: 220px;
    }

    .applyReason,
    .reviewComment,
    .examineStatus {
      width: 160px;

    }


    .examineStatus {
      font-weight: 400;
      width: 120px;
      color: #606266;

      .el-tag {
        margin: 0 5px;
      }
    }

    .examineId,
    .name,
    .directionName,
    .background,
    .applyDate,
    .applyReason,
    .reviewComment,
    .examineStatus {
      height: 100%;
      font-weight: 400;
      display: inline-block;
      box-sizing: border-box;
      color: #606266;
      overflow: hidden;
      padding-left: 10px;
      padding-right: 10px;
    }

    .action {
      font-weight: 400;
      padding: 12px 0;
      width: 200px;
      height: 100%;
      color: #606266;
    }
  }

  .tableDataItem {
    height: 50px;
    line-height: 50px;
  }

}
</style>