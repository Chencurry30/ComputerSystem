<!--用户管理-->
<template>
  <div class="appMain">
    <div class="filter-container">
      <div class="filter-container-searchInput">
        <el-input placeholder="头部尚未任何操作"></el-input>
      </div>
      <div class="filter-container-searchBtn">
        <el-button type="primary" icon="el-icon-search">搜索</el-button>
      </div>
      <div class="filter-container-addBtn">
        <el-button
          type="primary"
          icon="el-icon-plus"
          @click="addUserBtn"
          v-has="`system:user:add`"
          >新 增</el-button
        >
      </div>
      <div class="filter-container-exportExcle">
        <el-button type="primary" icon="el-icon-plus" @click="exportExcel"
          >导出为excle</el-button
        >
      </div>
    </div>
    <!--主题-->
    <!-- contenteditable="true"-->
    <table
      style="width: 100%"
      class="filter-table"
      id="result"
      ref="excleTable"
    >
      <tr class="tableTypeNav">
        <th class="userId">ID</th>
        <th class="username">用户名</th>
        <th class="nickname">昵称</th>
        <th class="email">邮箱</th>
        <th class="sex">性别</th>
        <th class="age">年龄</th>
        <th class="roles">角色</th>
        <th class="action">操作</th>
      </tr>
      <tr
        class="tableDataItem"
        v-for="fatherItem in tableData"
        :key="fatherItem.userId"
      >
        <td class="userId">{{ fatherItem.userId }}</td>
        <td class="username">{{ fatherItem.username }}</td>
        <td class="nickname">{{ fatherItem.nickname }}</td>
        <td class="email">{{ fatherItem.email }}</td>
        <td class="sex">{{ fatherItem.sex }}</td>
        <td class="age">{{ fatherItem.age }}</td>
        <div class="roles">
          <el-tag
            type="success"
            v-for="childItem in fatherItem.roles"
            :key="childItem.roleId"
            >{{ childItem.name }}</el-tag
          >
        </div>
        <div class="action">
          <el-button
            type="success"
            size="mini"
            @click="giveUserRole(fatherItem)"
            v-has="`system:user:update`"
            >赋角色</el-button
          >
          <el-button type="primary" size="mini">查看</el-button>
          <el-button
            type="danger"
            size="mini"
            @click="deleteROW(fatherItem)"
            v-has="`system:user:delete`"
            >删除</el-button
          >
        </div>
      </tr>
    </table>
    <!--分页表单-->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      class="filter-page"
      @current-change="handleCurrentChange"
    >
    </el-pagination>

    <giveUserRole ref="giveUserRole"></giveUserRole>
    <addUserPopup ref="addUserPopup"></addUserPopup>
  </div>
</template>

<script>
import exportExcle from "../../utils/exportExcle";
import giveUserRole from "../../components/userPopup/giveUserRole";
import addUserPopup from "../../components/userPopup/addUserPopup";
import { getuserListApi, userDelete } from "../../services/systemManage";
export default {
  name: "MemberArchive",
  data() {
    return {
      searchForm: {
        // 查询条件
        key: "",
      },
      //根据后端所川回的值
      tableData: [],
      total: 0, //页面总条数
      page: 1, //请求第一次的params
      pageSize: 6,
    };
  },
  components: { giveUserRole, addUserPopup },

  mounted() {
    this.getFollowdiaryList();
  },
  methods: {
    //导出函数用户数据
    exportExcel() {
      var csv = exportExcle.tableTocsv(this.$refs.excleTable);
      var sheet = exportExcle.csvTosheet(csv);
      var blob = exportExcle.sheetToblob(sheet);
      exportExcle.openDownloadDialog(blob, "导出.xlsx");
    },
    //获取所有列表的信息
    getFollowdiaryList() {
      getuserListApi(this.page).then((res) => {
        if (res.data.code === 200) {
          this.tableData = res.data.data.list; //后端返回的值赋值给页面
          this.total = res.data.data.total; //后端返回的总数量
        } else if (res.data.code === 417) {
          this.tableData = [];
          this.total = 0;
        }
      });
    },
    //分页
    handleCurrentChange(page) {
      this.page = page;
      this.getFollowdiaryList();
    },
    //赋予角色
    giveUserRole(fatherItem) {
      this.$refs.giveUserRole.showGiveRoles(fatherItem);
    },
    //删除列表
    deleteROW(fatherItem) {
      this.$confirm("此操作将永久删除该用户, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          userDelete(fatherItem.userId)
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
    //新增用户弹窗
    addUserBtn() {
      this.$refs.addUserPopup.showDialog();
    },
  },
};
</script>
<style scoped lang="less">
.filter-container {
  padding: 10px;
  display: flex;

  .filter-container-searchInput,
  .filter-container-searchBtn,
  .filter-container-addBtn,
  .filter-container-exportExcle {
    margin-right: 10px;
  }
}

.filter-table {
  min-width: 1420px;

  .tableTypeNav,
  .tableDataItem {
    display: flex;
    align-items: center;
    text-align: center;

    .userId,
    .username,
    .nickname {
      width: 160px;
    }

    .email {
      width: 220px;
    }

    .sex,
    .age {
      width: 100px;
    }

    .roles {
      font-weight: 400;
      width: 200px;
      color: #606266;
      .el-tag {
        margin: 0 5px;
      }
    }

    .userId,
    .sex,
    .age,
    .email,
    .nickname,
    .username {
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
