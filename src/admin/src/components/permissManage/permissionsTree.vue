<template>
  <div class="permission_Tree" v-show="isShowTree">
    <!--roleId不等于-1显示编辑角色  等于-1显示编辑权限树-->
    <div class="permission_Header" v-if="roleId !== -1">
      <el-tag class="roleTitle">编辑的角色是</el-tag>
      <el-tag class="roleTitle" type="danger">{{ roleName }}</el-tag>
      <el-button
        class="saveRoleBtn"
        type="primary"
        icon="el-icon-success"
        size="small"
        @click="saveRole"
        >保存修改</el-button
      >
    </div>
    <div class="permission_Header" v-else>
      <el-button
        class="editPermissionBtn"
        type="primary"
        icon="el-icon-plus"
        size="small"
        @click="addTopMenu"
        >添加顶级菜单</el-button
      >
    </div>
    <el-tree
      class="permission_Content"
      :data="Tree"
      :render-after-expand="false"
      show-checkbox
      node-key="menuId"
      :default-checked-keys="roleTree"
      ref="tree"
    >
      <div class="custom-tree-node permission_Main" slot-scope="{ node, data }">
        <div>{{ node.label }}</div>
        <div class="editPermission_Btn">
          <el-button
            type="primary"
            size="mini"
            @click.stop="() => addPermissionNode(data)"
          >
            添加
          </el-button>
          <el-button
            type="warning"
            size="mini"
            @click="() => editPermissionNode(data)"
          >
            编辑
          </el-button>
          <el-button
            type="danger"
            size="mini"
            @click.stop="() => deletePermissionNode(data)"
          >
            删除
          </el-button>
        </div>
      </div>
    </el-tree>
    <AddPermissPopup ref="AddPermissPopup"></AddPermissPopup>
    <deletePermissPopup ref="deletePermissPopup"></deletePermissPopup>
    <addTopPermissPopup ref="addTopPermissPopup"></addTopPermissPopup>
    <editPermissPopup ref="editPermissPopup"></editPermissPopup>
  </div>
</template>

<script>
import { getCheckTreeList } from "@/utils/getTreeList";
import { lookRole, getTree, saveTree } from "@/services/systemManage";
import AddPermissPopup from "../permissTreePopup/addPermissPopup.vue";
import deletePermissPopup from "../permissTreePopup/deletePermissPopup.vue";
import addTopPermissPopup from "../permissTreePopup/addTopPermissPopup.vue";
import editPermissPopup from "../permissTreePopup/editPermissPopup.vue";
export default {
  name: "permissionsTree",
  data() {
    return {
      Tree: [], //所有的权限构成的树形结构
      roleTree: [], //角色携带的相关权限
      isShowTree: false, //权限树是否展示
      modifyRight: [], //修改后的权限保存
      roleName: "",
      //角色的Id,由父组件调用方法传递进来,为-1表示编辑权限,其他为编辑角色权限
      roleId: -1,
    };
  },
  components: {
    AddPermissPopup,
    deletePermissPopup,
    addTopPermissPopup,
    editPermissPopup,
  },
  mounted() {
    this.getPermissionsTree();
  },
  methods: {
    //获取一个角色已有的权限
    showTreeList(roleId, roleList, roleName) {
      this.$refs.tree.setCheckedKeys([]); //清空上一个角色遗留的权限
      //-1表示是编辑权限树
      if (roleId === -1) {
        this.roleId = roleId;
        console.log(this.roleId);
        this.isShowTree = true;
        return;
      } else {
        this.roleName = roleName;
        this.roleTree = [];
        this.roleId = roleId;
        lookRole(roleId).then((res) => {
          if (res.data.code === 200) {
            let data = res.data.data;
            data.forEach((item) => {
              if (item.level === 4) {
                roleList.push(item.menuId);
              }
            });
            console.log("check", this.roleTree);
            this.roleTree = roleList;
            this.isShowTree = true;
          } else if (res.data.code === 417) {
            this.roleTree = [];
            console.log(typeof this.roleTree);
            this.isShowTree = true;
          }
        });
      }
    },
    //获取所有的权限
    getPermissionsTree() {
      getTree().then((res) => {
        if (res.data.code === 200) {
          this.Tree = res.data.data;
        }
      });
    },
    //获取所有打了勾的权限
    getCheckedNodes() {
      let data = getCheckTreeList(
        this.$refs.tree.getCheckedNodes(),
        this.modifyRight
      );
      this.modifyRight = data;
    },
    //获取半勾状态下的权限
    getHalfCheckedNodes() {
      let data = getCheckTreeList(
        this.$refs.tree.getHalfCheckedNodes(),
        this.modifyRight
      );
      this.modifyRight = data;
    },
    //保存角色修改的权限
    saveRole() {
      console.log(123);
      this.getCheckedNodes();
      this.getHalfCheckedNodes();
      let data = {};
      data.roleId = this.roleId;
      data.menuList = this.modifyRight;
      saveTree(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("修改角色权限成功！");
          this.isShowTree = false;
        } else {
          this.$message.error("修改角色权限失败,请重新操作！");
        }
        this.modifyRight = [];
      });
    },
    //用来删除按钮或菜单
    deletePermissionNode(primiseItem) {
      this.$refs.deletePermissPopup.showDialog("删除权限", primiseItem);
    },
    //添加权限菜单菜单
    addPermissionNode(primiseItem) {
      if (primiseItem.level === 1) {
        this.$refs.AddPermissPopup.showDialog("添加一级菜单", primiseItem);
      } else if (primiseItem.level === 2) {
        this.$refs.AddPermissPopup.showDialog("添加二级菜单", primiseItem);
      } else if (primiseItem.level === 3) {
        this.$refs.AddPermissPopup.showDialog("添加按钮菜单", primiseItem);
      } else {
        //level为4表示的是按钮权限,
        this.$message.error("按钮权限不能在添加权限！！");
      }
    },
    //用于添加顶级菜单权限
    addTopMenu() {
      this.$refs.addTopPermissPopup.showDialog("添加顶级菜单");
    },
    //用于编辑按钮或菜单
    editPermissionNode(primiseItem) {
      this.$refs.editPermissPopup.showDialog(
        "编辑菜单信息",
        primiseItem.menuId
      );
    },
  },
};
</script>

<style lang="less" scoped>
.permission_Tree {
  padding-left: 20%;
  overflow: hidden;

  .permission_Header {
    width: 100%;
    margin-bottom: 10px;

    .roleTitle {
      margin-left: 10px;
    }

    .saveRoleBtn,
    .editPermissionBtn {
      margin-left: 10px;
    }
  }

  .permission_Content {
    width: 50%;

    .permission_Main {
      width: 100%;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    .editPermission_Btn {
      margin-left: 20px;
    }

    ::v-deep .el-tree-node__content {
      display: flex;
      align-items: center;
      height: 36px;
    }

    ::v-deep .el-checkbox__inner {
      width: 20px;
      height: 20px;
    }

    ::v-deep .el-tree-node__label {
      font-size: 16px;
    }
  }
}
</style>