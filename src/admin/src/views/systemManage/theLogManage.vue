<!--日志管理-->
<template>
  <div class="home">
    <!--主题-->`
    <el-table :data="tableData" style="width: 100%" @selection-change="deleteLog">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="username" label="用户名" width="120"></el-table-column>
      <el-table-column prop="ip" label="ip" width="120"></el-table-column>
      <el-table-column prop="createDate" label="事件时间" width="190"></el-table-column>
      <el-table-column prop="type" label="事件类型" width="120"></el-table-column>
      <el-table-column prop="model" label="事件种类"></el-table-column>
      <el-table-column prop="result" label="事件结果"></el-table-column>
      <el-table-column prop="description" label="事件注释"></el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" circle size="mini" @click="deleteROW(scope.row)" v-has="`system:log:delete`"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 批量删除日志 -->

    <!--分页表单-->
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize"
      @current-change="handleCurrentChange" class="page">
    </el-pagination>
    <el-button type="primary" icon="el-icon-delete" @click="deleteBtn(selections)" v-has="`system:log:delete`">
      批量删除
    </el-button>
    <!--提示框的组件-->
    <GiveRole ref="GiveRole"></GiveRole>
    <addUserpopUp ref="addUserpopUp"></addUserpopUp>
  </div>
</template>

<script>
import GiveRole from "../../components/permissManage/GiveRole";
import addUserpopUp from "../../components/permissManage/addUserpopUp.vue";
import { getLoglist, logDelete, logsDelete } from "../../services/systemManage";
export default {
  name: "MemberArchive",
  data() {
    return {
      //根据后端所川回的值
      tableData: [
        {
          logId: "",
          username: "",
          ip: "",
          createDate: "",
          type: "",
          model: "",
          result: "",
          description: "",
          total: "",
          pageSize: "",
        },
      ],
      total: 0, //页面总条数
      page: 1, //请求第一次的params
      pageSize: 0,
      selections: [],
    };
  },
  components: { GiveRole, addUserpopUp },
  mounted() {
    this.getFollowdiaryList();
  },
  methods: {
    //获取所有列表的信息
    getFollowdiaryList() {
      getLoglist(this.page).then((res) => {
        this.tableData = res.data.data.list; //后端返回的值赋值给页面
        this.total = res.data.data.total; //后端返回的总数量
        this.pageSize = res.data.data.pageSize; //后端放回每页总条数
      });
    },
    //分页
    handleCurrentChange(page) {
      this.page = page;
      this.getFollowdiaryList();
    },
    //删除列表
    deleteROW(row) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          logDelete(row.logId)
            .then(() => {
              this.$message({
                message: "删除用户成功！",
                type: "success",
              });
              this.getFollowdiaryList(); //更新列表
            })
            .catch(() => {
              console.log("错误捕获");
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    //批量删除
    deleteBtn(data) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          logsDelete(data)
            .then(() => {
              this.$message({
                message: "删除用户成功！",
                type: "success",
              });
              this.getFollowdiaryList(); //更新列表
            })
            .catch(() => {
              console.log("错误捕获");
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    deleteLog(val) {
      this.selections = val;
      // console.log(this.selections);
    },
  },
};
</script>

<style scoped>
.nav-select {
  margin: 10px 20px;
  display: flex;
  justify-content: space-between;
}

.nav-right {
  display: flex;
}

.searchData {
  margin-left: 10px;
}

.page {
  margin-top: 10px;

  text-align: center;
}
</style>
