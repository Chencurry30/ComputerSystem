<!-- eslint-disable vue/no-useless-template-attributes -->
<template>
  <div class="appMain">
    <!-- 顶部选择框-->
    <div class="filter-container"></div>
    <!--中间部分-->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="videoId" label="视屏ID" width="100"></el-table-column>
      <el-table-column prop="name" label="视屏名称" width="650"></el-table-column>
      <el-table-column prop="nickname" label="上传作者"></el-table-column>
      <el-table-column prop="time" label="上传时间"></el-table-column>

      <el-table-column label="操作" width="150">
        <template slot-scope="scope" class="filter-tableBtnList">
          <el-button type="primary" size="mini" @click="toViewRow(scope.row)" v-has="`system:video:view`">查看</el-button>
          <el-button type="danger" size="mini" @click="deleteTable(scope.row)"
            v-has="`system:video:delete`">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--分页表单-->
    <el-pagination class="filter-page" background layout="prev, pager, next" :total="total" :page-size="pageSize"
      @current-change="handleCurrentChange">
    </el-pagination>

    <!--弹窗的组件-->
    <toViewpopUp ref="toViewpopUp"></toViewpopUp>
  </div>
</template>

<script>
//查看信息的弹窗 
import toViewpopUp from '../../components/popUp/video/toViewpopUp'
import { getVideoList, deleteVideoAction } from '../../services/videoManage'
export default {
  name: 'videoManage',
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
  components: {
    toViewpopUp
  },
  mounted() {
    this.getAllVideoList(1)
  },
  methods: {
    //获取所有的视屏列表
    getAllVideoList(pageNum) {
      getVideoList(pageNum).then((res) => {
        if (res.data.code === 200) {
          this.tableData = res.data.data.list
          this.total = res.data.data.total; //后端返回的总数量
          this.pageSize = res.data.data.pageSize //后端返回的每一页的总数
        } else if (res.data.code === 417) {
          this.tableData = []
          this.total = 0
          this.pageSize = 8
        }
      })
    },
    //分页
    handleCurrentChange(page) {
      this.page = page;
      this.getAllVideoList(this.page);
    },


    // 删除
    deleteTable(row) {
      deleteVideoAction(row.videoId).then((res) => {
        if (res.data.code === 200) {
          this.$message.success('删除视屏成功!!')
          this.getAllVideoList(this.page)
        }
      })
    },
    //查看信息
    toViewRow(row) {
      this.$refs.toViewpopUp.showDialog(row)
    },
  }
}
</script>
<style scoped>
</style>
