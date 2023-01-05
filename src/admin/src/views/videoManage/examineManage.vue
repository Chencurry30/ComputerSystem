<!--审核视屏-->
<template>
  <div class="appMain">
    
    <div class="filter-container">
      <div class="filter-container-left">
        <el-button type="primary" @click="getAuditVideoList(-1)">获取审核列表</el-button>
      </div>
      <div class="filter-container-right">
        <el-button type="primary" @click="getAuditVideoList(0)">未审核</el-button>
        <el-button type="primary" @click="getAuditVideoList(1)">审核通过</el-button>
        <el-button type="primary" @click="getAuditVideoList(2)">审核不通过</el-button>
      </div>
    </div>

    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="examineId" label="审核ID" width="100"></el-table-column>
      <el-table-column prop="name" label="视屏名称" width="100"></el-table-column>
      <el-table-column prop="introduction" label="视屏介绍" width="100"></el-table-column>
      <el-table-column prop="authorNickname" label="上传作者" width="150"></el-table-column>
      <el-table-column prop="typeName" label="视屏种类"></el-table-column>
      <el-table-column prop="time" label="上传时间"></el-table-column>
      <el-table-column prop="applyNickname" label="审核人"></el-table-column>
      <el-table-column prop="reviewComment" label="审核信息"></el-table-column>
      <el-table-column label="操作" width="250">
        <template slot-scope="scope">
          <el-button type="success" size="mini" @click="auditRow(scope.row)" v-if="scope.row.examineStatus === 0"
            v-has="`system:video:examine`">审核</el-button>
          <el-button type="primary" size="mini" @click="toViewRow(scope.row)"
            v-has="`system:video:viewExamine`">查看</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination class="filter-page" background layout="prev, pager, next" :total="total" :page-size="pageSize"
      @current-change="handleCurrentChange">
    </el-pagination>

    <!--审核视屏的弹窗-->
    <auditVideo ref="auditVideo"></auditVideo>
    <!--查看完整信息的弹窗-->
    <toViewAllpopUp ref="toViewAllpopUp"></toViewAllpopUp>
  </div>
</template>

<script>
import auditVideo from '../../components/popUp/video/auditVideo'
import toViewAllpopUp from '../../components/popUp/video/toViewAllpopUp'
import { getExamineList } from '../../services/videoManage'
export default {
  name: 'examineManage',
  data() {
    return {
      tableData: [],
      total: 0, //页面总条数
      page: 1, //请求第一次的params
      pageSize: 0,
      listType: 0,   //0表示的是查看全部的视屏列表
      statusType: 0   //获取审核视屏的状态
    }
  },
  components: { auditVideo, toViewAllpopUp },
  mounted() {
    this.getAuditVideoList(-1)
  },
  methods: {

    //获取全部视屏的审核列表
    getAuditVideoList(status) {
      //修改展示数据的类型 
      this.listType = 1
      let page = this.page
      //保存审核状态 
      this.statusType = status
      getExamineList({ status, page }).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.page = 1
          this.tableData = res.data.data.list
          this.total = res.data.data.total; //后端返回的总数量
          this.pageSize = res.data.data.pageSize //后端返回的每一页的总数
        } else if (res.data.code === 417) {
          this.page = 1
          this.tableData = []
          this.total = 0; //后端返回的总数量
          this.pageSize = 12 //后端返回的每一页的总数
        }
      })
    },
    //分页
    handleCurrentChange(page) {
      this.page = page;
      this.getAuditVideoList(this.statusType)
    },
    //审核视屏 
    auditRow(row) {
      this.$refs.auditVideo.showDialog(row)
    },


    //查看信息
    toViewRow(row) {
      this.$refs.toViewAllpopUp.showDialog(row)
    },
  }

}
</script>

<style scoped lang="less">
.filter-container {
  display: flex;
  justify-content: space-between;

  .filter-container-left {
    margin-left: 10px;
  }

  .filter-container-right {
    margin-right: 10px;
  }
}


.filter-page {
  margin-top: 10px;

  text-align: center;
}
</style>
