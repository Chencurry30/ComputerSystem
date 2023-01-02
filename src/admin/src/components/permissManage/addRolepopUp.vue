<template>
  <div class="AllBox">
    <el-dialog title="添加角色" :visible.sync="dialogVisible" width="30%" center>

      <el-form label-width="0px" class="login_in" ref="dataForm" :model="dataForm" :rules="checkForm">
        <div class="form-info">
          <el-form-item prop="name">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入添加的角色名字" v-model.trim="dataForm.name">
            </el-input>
          </el-form-item>
          <el-form-item prop="roleKey">
            <el-input prefix-icon="el-icon-user" placeholder="请输入添加角色的别名" v-model.trim="dataForm.roleKey"></el-input>
          </el-form-item>
        </div>

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialogVisible">取 消</el-button>
        <el-button type="primary" @click="submitRole()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { addRole } from '../../services/systemManage'
import rules from '../../utils/rules'
export default {
  name: 'addRolepopUp',
  data() {
    return {
      dataForm: {
        name: '',
        roleKey: '',
      },
      dialogVisible: false,
      checkForm: {
        name: [{
          validator: rules.FormValidate.Form().validateJudgeData,
          trigger: "blur",
        }],
        roleKey: [{
          validator: rules.FormValidate.Form().validateJudgeData,
          trigger: "blur",
        }],
      },

    };
  },
  methods: {
    closeDialogVisible() {
      this.dialogVisible = false
    },
    showDialogVisible() {
      this.dataForm = {
        name: '',
        roleKey: '',
      }
      this.dialogVisible = !this.dialogVisible
    },
    submitRole() {
      this.$refs.dataForm.validate((valid) => {
        if (valid) {
          //给定一个Id，值无关需求 
          this.dataForm.roleId = 6
          addRole(this.dataForm).then((res) => {
            console.log(res);
            if (res.data.code === 200) {
              this.$message.success('添加成功!!')
              this.dialogVisible = false
              //自动刷新角色列表 
              this.$parent.getRoles()
            } else if (res.data.code === 406) {
              this.$message.error(res.data.message)
            }
          })
        } else {
          this.$message.error('请按照提示输入数据')
          this.dialogVisible = true
        }
      })
    },
  }
};
</script>
<style>

</style>