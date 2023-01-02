<!--用户管理-->
<template>
  <div class="home">
    <div class="nav-select">
      <div class="nav-left">
        <el-button type="primary" icon="el-icon-plus" @click="addSubBtn" v-has="`system:user:add`">
          新 增
        </el-button>
      </div>
    </div>
    <!--主题-->
    <div style="width: 100%" class="tableBox">
      <div class="tableTypeNav">
        <div class="userId">ID</div>
        <div class="username">用户名</div>
        <div class="nickname">昵称</div>
        <div class="email">邮箱</div>
        <div class="sex">性别</div>
        <div class="age">年龄</div>
        <div class="roles">角色</div>
        <div class="action">操作</div>
      </div>
      <div class="tableDataItem" v-for="(fatherItem) in tableData" :key="fatherItem.userId">
        <div class="userId">{{ fatherItem.userId }}</div>
        <div class="username">{{ fatherItem.username }}</div>
        <div class="nickname">{{ fatherItem.nickname }}</div>
        <div class="email">{{ fatherItem.email }}</div>
        <div class="sex">{{ fatherItem.sex }}</div>
        <div class="age">{{ fatherItem.age }}</div>
        <div class="roles">
          <el-tag type="success" v-for="childItem in fatherItem.roles" :key="childItem.roleId">{{ childItem.name
}}</el-tag>
        </div>
        <div class="action">
          <el-button type="success" size="mini" @click="giveUserRole(fatherItem)"
            v-has="`system:user:update`">赋角色</el-button>
          <el-button type="danger" size="mini" @click="deleteROW(fatherItem)"
            v-has="`system:user:delete`">删除</el-button>
        </div>
      </div>
    </div>
    <!--分页表单-->
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize"
      @current-change="handleCurrentChange" class="page">
    </el-pagination>

    <!--提示框的组件-->
    <GiveRole ref="GiveRole"></GiveRole>
    <addUserpopUp ref="addUserpopUp"></addUserpopUp>
  </div>
</template>

<script>
import GiveRole from "../../components/permissManage/GiveRole.vue";
import addUserpopUp from "../../components/permissManage/addUserpopUp.vue";
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
  components: { GiveRole, addUserpopUp },
  mounted() {
    this.getFollowdiaryList();
  },
  methods: {
    //获取所有列表的信息
    getFollowdiaryList() {
      getuserListApi(this.page).then((res) => {
        if (res.data.code === 200) {
          this.tableData = res.data.data.list; //后端返回的值赋值给页面
          this.total = res.data.data.total; //后端返回的总数量 
        }else if(res.data.code === 417){
          this.tableData = []
          this.total = 0
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
      this.$refs.GiveRole.showGiveRoles(fatherItem);
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
              })
              this.getFollowdiaryList(); //更新列表
            })
            .catch(() => {
              console.log("错误捕获");
            })
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    //新增
    addSubBtn() {
      this.$refs.addUserpopUp.showDialogVisible();
    },


  },
};
</script>

<style scoped lang="less">
.nav-select {
  margin: 10px 20px;
  display: flex;
  justify-content: space-between;

  .nav-right {
    display: flex;

    .searchData {
      margin-left: 10px;
    }
  }
}

.tableBox {
  min-width: 1420px;

  .tableTypeNav,
  .tableDataItem {
    font-size: 18px;
    display: flex;
    align-items: center;
    text-align: center;

    .userId {
      padding: 12px 0;
      width: 160px;
      height: 100%;
    }

    .username {
      padding: 12px 0;
      width: 160px;
      height: 100%;
    }

    .nickname {
      padding: 12px 0;
      width: 160px;
      height: 100%;
    }

    .email {
      padding: 12px 0;
      width: 220px;
      height: 100%;
    }

    .sex {
      padding: 12px 0;
      width: 100px;
      height: 100%;
    }

    .age {
      padding: 12px 0;
      width: 100px;
      height: 100%;
    }

    .roles {
      padding: 12px 0;
      width: 280px;
      height: 100%;

      .el-tag {
        margin: 0 5px;
      }
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
