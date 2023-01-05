<!--编辑菜单或按钮信息-->
<template>
  <div class="dialogMain">
    <el-dialog class="dialogHeader" :title="dialogTitle" :visible.sync="dialogVisible" width="60%" center>
      <div class="dialogContent">
        <el-form :model="submitMenuData" :rules="checkForm" ref="submitMenuData" label-width="100px"
          class="demo-ruleForm">
          <el-form-item label="菜单路径" prop="path">
            <el-input readonly v-model.trim="submitMenuData.path" placeholder="请输入添加菜单路径如:/system"></el-input>
          </el-form-item>
          <el-form-item label="菜单名称" prop="name">
            <el-input v-model.trim="submitMenuData.name" placeholder="请输入添加菜单名称如:系统管理"></el-input>
          </el-form-item>
          <el-form-item label="组件名称" prop="component">
            <el-input readonly v-model.trim="submitMenuData.component" placeholder="请输入添加菜单简称如:system"></el-input>
          </el-form-item>
          <el-form-item label="菜单级别" prop="level">
            <el-input readonly v-model.trim="submitMenuData.level" placeholder="请输入添加菜单名称如:系统管理"></el-input>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialog">取 消</el-button>
        <el-button type="primary" @click="submitMenu">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import permissionRule from '../../utils/permissionRule'
import { getMenuInformation,updateMenuInformation } from '../../services/permissionManage'
export default {
  data() {
    return {
      dialogTitle: '',
      dialogVisible: false,
      submitMenuData: {
        menuId: 0,
        path: '',
        name: '',
        component: '',
        menuType: 0,
        level: 0,
        label: ''
      },
      checkForm: {
        name: [
          { required: true, validator: permissionRule.FormValidate.Form().judgeDataIsChinese, trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    //打开弹窗 
    showDialog(title, MenuId) {
      this.MenuId = MenuId
      this.dialogTitle = title
      //获取权限菜单相关的信息 
      this.getMenuData()
      this.dialogVisible = true
    },
    //关闭弹窗 
    closeDialog() {
      this.dialogVisible = false
    },
    //获取权限菜单相关的信息 
    getMenuData() {
      getMenuInformation(this.MenuId).then((res) => {
        if (res.data.code === 200) {
          this.submitMenuData = res.data.data
        } else {
          this.$message.error('获取相关信息错误,请重新操作')
        }
      })
    },

    submitMenu() {
      this.$refs.submitMenuData.validate((valid) => {
        if (valid) {
          updateMenuInformation(this.submitMenuData).then((res) => {
            if (res.data.code === 200) {
              this.$message.success('修改成功,请重新登录后查看效果')
              this.closeDialog()
              //用来刷新页面 
              this.$parent.getPermissionsTree()
            }
          })
        } else {
          this.$message.warning('请输入对应项后再修改')
          return false;
        }
      });
    },

  }
};
</script>
<style lang='less' scoped>
.dialogHeader {
  z-index: 999;

  ::v-deep .el-dialog__title {
    font-size: 22px;
  }
}
</style>

