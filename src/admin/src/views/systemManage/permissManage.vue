<!--权限管理-->
<template>
  <div class="appMain">
    <div class="filter-container">
      <div class="fillter-container-BtnList">
        <el-button
          type="primary"
          icon="el-icon-plus"
          @click="addRole"
          v-has="`system:role:add`"
          >添加角色</el-button
        >
        <el-button type="primary" icon="el-icon-edit" @click="editPermission"
          >编辑权限</el-button
        >
      </div>
    </div>
    <div class="filter-primissList">
      <div class="primissList">
        <div
          v-for="item in rolesData"
          :key="item.roleId"
          class="roleFont roleItem"
        >
          <div class="itemInfo">
            {{ item.name }}
          </div>
          <div class="itemBtn">
            <el-button
              type="primary"
              size="mini"
              icon="el-icon-edit"
              circle
              @click="editRole(item)"
              v-has="`system:role:getMenu`"
            ></el-button>
            <el-button
              type="primary"
              size="mini"
              icon="el-icon-delete"
              circle
              v-if="item.roleId > 4"
              @click="deleteRole(item.roleId)"
              v-has="`system:role:delete`"
            ></el-button>
          </div>
        </div>
      </div>
      <div class="primissTr">
        <permissionsTree ref="PermissionsTree"></permissionsTree>
      </div>
    </div>
    <addRolepopUp ref="addRolepopUp"></addRolepopUp>
  </div>
</template>

<script>
import { getRoleList, roleDelete } from "../../services/systemManage";
import addRolepopUp from "@/components/permissManage/addRolepopUp.vue";
import PermissionsTree from "@/components/permissManage/permissionsTree.vue";
export default {
  data() {
    return {
      //存储角色的列表
      rolesData: [],
      roleId: 0,
      showTree: false,
    };
  },
  components: {
    addRolepopUp,
    PermissionsTree,
  },
  mounted() {
    //获取角色列表
    this.getRoles();
  },
  methods: {
    //获取角色列表
    getRoles() {
      getRoleList().then((res) => {
        if (res.data.code === 200) {
          this.rolesData = res.data.data;
        } else if (res.data.code === 403) {
          this.$message.error("权限不足！！！");
        }
      });
    },
    //添加角色
    addRole() {
      this.$refs.addRolepopUp.showDialogVisible();
    },
    //编辑角色
    editRole(item) {
      this.showTree = true;
      this.roleId = item.roleId;
      this.$refs.PermissionsTree.showTreeList(item.roleId, [], item.name);
    },
    //删除角色
    deleteRole(roleId) {
      roleDelete(roleId).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.$message.success("删除角色成功！");
          this.getRoles();
        } else if (res.data.code === 400) {
          this.$message.error(
            "无法删除该角色，该角色已经被分配给用户，请取消分配再删除!!"
          );
        }
      });
    },

    //编辑权限树
    editPermission() {
      //调用方法传入-1,标明知识查看权限树
      this.$refs.PermissionsTree.showTreeList(-1, [], "");
    },
  },
};
</script>

<style lang="less" scoped>
.appMain {
  padding: 20px 5px 50px 15px;
  display: block;

  .filter-container {
    margin-left: 10px;
    width: 290px;

    .fillter-container-BtnList {
      display: flex;
      justify-content: space-between;
    }
  }
}

.filter-primissList {
  display: flex;

  .primissList {
    width: 25rem;
    border-right: 1px solid #9093994a;

    .roleItem {
      display: flex;
      margin: 5px 10px;
      padding: 15px 0;
      align-items: center;
      justify-content: space-between;
    }

    .roleFont {
      font-size: 16px;
      background-color: #409eff38;
      border-color: #e9e9eb;
      color: black;
      border-radius: 10px;
    }
  }
  .primissTr {
    width: 100%;
  }
}

.itemInfo {
  margin-left: 20px;
}

.itemBtn {
  margin-right: 15px;
}

.selectBox {
  display: flex;
  justify-content: space-between;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.box-card {
  width: 360px;

  /deep/.el-card__body {
    padding: 10px 30px;
  }
}
</style>