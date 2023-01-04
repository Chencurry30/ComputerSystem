<!--用来添加权限的弹窗-->
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
            <el-input v-model.trim="submitMenuData.name" placeholder="请输入添加菜单名称如:系统管理"></el-input>
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
import {addfirstMenu} from '../../services/permissionManage'
export default {
  data() {
    return {
      dialogTitle: '',
      dialogVisible: false,
      submitMenuData: {
        menuId:1,
        path: '',
        name: '',
        component: ''
      },
      //父路由的相关信息
      fatherMenu:{},
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
    showDialog(title,fatherMenu) {
      this.fatherMenu = fatherMenu
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
          console.log(this.fatherMenu);
          console.log(this.submitMenuData);
          this.changeDataStyle()
          addfirstMenu(this.submitMenuData).then((res)=>{
            console.log(res);
          })
        } else {
          this.$message.warning('请输入对应项后再提交')
          return false;
        }
      });
    },
    //修改对应数据的格式,满足提交后端的需要 
    changeDataStyle(){
      //先将水平为1的给去掉 
      if(this.fatherMenu.level === 1){
        return;
      }else {
        //表示添加的是菜单 
        this.submitMenuData.parentId = this.fatherMenu.menuId
        this.submitMenuData.menuType = 1
        this.submitMenuData.level = this.fatherMenu.level + 1
      }
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

