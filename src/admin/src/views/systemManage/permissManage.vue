<!--权限管理-->
<template>
  <div class="AllBox">
    <el-card class="box-card">
      <div slot="header" class="clearfix selectBox">
        <el-button type="primary" icon="el-icon-delete" @click="addRole" v-has="`system:role:add`">添加角色</el-button>
        <el-button type="primary" icon="el-icon-delete" @click="saveTreeBtn">保存角色</el-button>
      </div>
      <div v-for="(item) in rolesData" :key="item.roleId" class="text item">
        <div class="itemInfo">
          {{ item.name }}
        </div>
        <div class="itemBtn">
          <el-button type="primary" size="mini" icon="el-icon-edit" circle @click="editRole(item)"
            v-has="`system:role:getMenu`"></el-button>
          <el-button type="primary" size="mini" icon="el-icon-delete" circle v-if="item.roleId > 4"
            @click="deleteRole(item.roleId)" v-has="`system:role:delete`"></el-button>
        </div>
      </div>
    </el-card>
    <addRolepopUp ref="addRolepopUp"></addRolepopUp>
    <permissionsTree ref="PermissionsTree"></permissionsTree>
  </div>
</template>

<script>
import { getRoleList, roleDelete } from '../../services/systemManage'
import addRolepopUp from '@/components/permissManage/addRolepopUp.vue'
import PermissionsTree from '@/components/permissManage/permissionsTree.vue';
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
    this.getRoles()
  },
  methods: {
    //获取角色列表
    getRoles() {
      getRoleList().then((res) => {
        if (res.data.code === 200) {
          this.rolesData = res.data.data;
        } else if (res.data.code === 403) {
          this.$message.error("权限不足！！！")
        }
      })
    },
    //添加角色 
    addRole() {
      this.$refs.addRolepopUp.showDialogVisible()
    },
    //编辑角色 
    editRole(item) {
      this.showTree = true;
      this.roleId = item.roleId
      this.$refs.PermissionsTree.showTreeList(item.roleId, [], item.name)
    },
    //删除角色 
    deleteRole(roleId) {
      roleDelete(roleId).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.$message.success("删除角色成功！")
          this.getRoles()
        } else if(res.data.code === 400) {
          this.$message.error("无法删除该角色，该角色已经被分配给用户，请取消分配再删除!!")
        }
      })
    },
    //保存修改后的角色权限 
    saveTreeBtn() {
      this.$refs.PermissionsTree.saveRoleTreeBtn(this.roleId)
    },
  }
};
</script>

<style lang="less" scoped>
.AllBox {
  margin: 40px 10px;
  display: flex;

  .text {
    font-size: 20px;
  }

  /deep/.item {
    display: flex;
    padding: 5px 0;
    align-items: center;
    justify-content: space-between;
    height: 50px;
    line-height: 30px;
  }

  .itemInfo {
    margin-left: 10px;
  }

  .itemBtn {
    margin-right: 15px;
  }
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
  clear: both
}

.box-card {
  width: 360px;

  /deep/.el-card__body {
    padding: 10px 30px;
  }
}

.sendInfo {
  width: 60px;
  height: 50px;
  margin: 15px 0;
  background: red;
  text-align: center;
}
</style>