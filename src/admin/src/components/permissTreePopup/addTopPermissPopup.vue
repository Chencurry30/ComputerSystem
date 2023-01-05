<!--用来添加顶级菜单-->
<template>
  <div class="dialogMain">
    <el-dialog class="dialogHeader" :title="dialogTitle" :visible.sync="dialogVisible" width="60%" center>
      <div class="dialogContent">
        <el-form :model="submitMenuData" :rules="checkForm" ref="submitMenuData" label-width="100px"
          class="demo-ruleForm">
          <el-form-item label="菜单路径" prop="path">
            <el-input v-model.trim="submitMenuData.path" placeholder="请输入添加菜单路径如:/system"></el-input>
          </el-form-item>
          <el-form-item label="菜单名称" prop="name">
            <el-input v-model.trim="submitMenuData.name" placeholder="请输入添加菜单名称如:前台管理"></el-input>
          </el-form-item>
          <el-form-item label="组件名称" prop="component">
            <el-input v-model.trim="submitMenuData.component" placeholder="请输入添加菜单简称如:system"></el-input>
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
import { addTopMenu } from '../../services/permissionManage'
export default {
  name:'addTopPermissPopup',
  data() {
    return {
      dialogTitle: '',
      dialogVisible: false,
      submitMenuData: {
        menuId: 1,
        path: '',
        name: '',
        component: ''
      },
      //父路由的相关信息
      checkForm: {
        path: [
          { required: true, validator: permissionRule.FormValidate.Form().judgeDataIsEnglist, trigger: 'blur' }
        ],
        name: [
          { required: true, validator: permissionRule.FormValidate.Form().judgeDataIsChinese, trigger: 'blur' }
        ],
        component: [
          { required: true, validator: permissionRule.FormValidate.Form().judgeDataIsEnglist, trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    //打开弹窗 
    showDialog(title) {
      this.dialogTitle = title
      this.dialogVisible = true
    },
    //关闭弹窗 
    closeDialog() {
      this.dialogVisible = false
    },
    submitMenu() {
      this.$refs.submitMenuData.validate((valid) => {
        if (valid) {
          addTopMenu(this.submitMenuData).then((res) => {
            if (res.data.code === 200) {
              this.$message.success('添加成功，请重新登录后查看效果')
              this.closeDialog()
              //用来刷新页面 
              this.$parent.getPermissionsTree()
            }
            console.log(res);
          })
        } else {
          this.$message.warning('请输入对应项后再提交')
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

