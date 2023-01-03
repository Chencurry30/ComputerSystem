<template>
  <div class="TreeBox" v-show="isShowTree">
    <div class="PrimissBox">
      <el-tag class="roleTitle">编辑的角色是</el-tag>
      <el-tag type="danger" class="roleTitle">{{ roleName }}</el-tag>
    </div>


    <el-tree class="TreeMain" :data="Tree" show-checkbox node-key="menuId" :default-checked-keys="roleTree" ref="tree">
    </el-tree>

  </div>
</template>

<script>
import { getCheckTreeList } from '@/utils/getTreeList'
import { lookRole, getTree, saveTree } from '@/services/systemManage'
export default {
  name: 'permissionsTree',
  data() {
    return {
      Tree: [],           //所有的权限构成的树形结构
      roleTree: [],      //角色携带的相关权限
      isShowTree: true, //权限树是否展示
      modifyRight: [],   //修改后的权限保存
      roleName: '',
    }
  },
  mounted() {
    this.getTree()
  },
  methods: {
    //获取一个角色已有的权限 
    showTreeList(roleId, roleList, roleName) {
      this.$refs.tree.setCheckedKeys([])
      this.roleName = roleName
      this.roleTree = []
      lookRole(roleId).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          let data = res.data.data
          data.forEach(item => {
            if (item.level === 4) {
              roleList.push(item.menuId)
            }
          });
          console.log('check', this.roleTree);
          this.roleTree = roleList
          this.isShowTree = true
        }else if(res.data.code === 417){
          this.roleTree = []
          console.log(typeof this.roleTree);
          this.isShowTree = true
        }
      })
    },
    //获取所有权限构成的树形结构 
    getTree() {
      getTree().then((res) => {
        if (res.data.code === 200) {
          this.Tree = res.data.data
        }
      })
    },
    //获取所有打了勾的权限 
    getCheckedNodes() {
      let data = getCheckTreeList(this.$refs.tree.getCheckedNodes(), this.modifyRight)
      this.modifyRight = data
    },
    //获取半勾状态下的权限 
    getHalfCheckedNodes() {
      let data = getCheckTreeList(this.$refs.tree.getHalfCheckedNodes(), this.modifyRight)
      this.modifyRight = data
    },
    //保存角色修改的权限 
    saveRoleTreeBtn(roleId) {
      if (this.isShowTree === false) {
        this.$message.error("请查看角色权限后再保存")
      } else {
        this.getCheckedNodes()
        this.getHalfCheckedNodes()
        let data = {}
        data.roleId = roleId
        data.menuList = this.modifyRight
        saveTree(data).then((res) => {
          if (res.data.code === 200) {
            this.$message.success("修改角色权限成功！")
            this.isShowTree = false
          } else {
            this.$message.error("修改角色权限失败,请重新操作！")
          }
          this.modifyRight = []
        })
      }
    },
  }
}
</script>

<style lang="less" scoped>
.TreeBox {
  margin-left: 20px;
  width: 320px;

  .PrimissBox {
    width: 100%;
    margin-bottom: 10px;
    .backBtn {
      margin: 10px 0 10px 10px;
    }

    .roleTitle {
      margin-left: 10px;
    }
  }
}

.TreeMain {
  ::v-deep .el-tree-node__content {
    height: 32px;
  }
  ::v-deep .el-checkbox__inner{
    width: 20px;
    height: 20px;
  }
  ::v-deep .el-tree-node__label{
    font-size: 16px;
  }
}




</style>