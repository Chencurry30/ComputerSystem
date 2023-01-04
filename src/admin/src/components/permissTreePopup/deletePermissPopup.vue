<!--删除权限的弹窗-->
<template>
  <div class="dialogMain">
    <el-dialog class="dialogHeader" :title="dialogTitle" :visible.sync="dialogVisible" width="40%" center>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialog">取 消</el-button>
        <el-button type="primary" @click="submitMenu">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {deleteMenu} from '../../services/permissionManage'
export default {
  name: 'deletePermissPopup',
  data() {
    return {
      dialogVisible: false,
      dialogTitle:'',
      menuId:0,
    };
  },
  methods: {
    //打开弹窗 
    showDialog(title, fatherMenu) {
      this.menuId = fatherMenu.menuId
      this.dialogTitle = title
      this.dialogVisible = true
    },
    //关闭弹窗 
    closeDialog() {
      this.dialogVisible = false
    },
    submitMenu(){
      deleteMenu(this.menuId).then((res)=>{
        if(res.data.code === 200){
          this.$message.success('删除成功！！')
          this.closeDialog()
          this.$parent.getPermissionsTree()
        }else{
          this.$message.error('删除失败')
        }
      })
    }
  }
};
</script>

<!-- menuId: 2
path: "/systemManage"
name: "系统管理"
component: "systemManage"
parentId: 1
menuType: 1
level: 2
label: "系统管理" -->


<style lang='less' scoped>
.dialogHeader {
  z-index: 999;

  ::v-deep .el-dialog__title {
    font-size: 22px;
  }
}
</style>

