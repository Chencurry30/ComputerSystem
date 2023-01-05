<template>
  <div class="addRoleBox">
    <el-dialog title="新增用户" :visible.sync="dialogVisible" width="30%" center>
      <el-form label-width="0px" class="login_in" ref="dataForm" :model="dataForm" :rules="checkForm">
        <div class="form-info">
          <el-form-item prop="username">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入用户用户名" v-model.trim="dataForm.username">
            </el-input>
          </el-form-item>
          <el-form-item prop="email">
            <el-input prefix-icon="el-icon-user" placeholder="请输入用户邮箱" v-model.trim="dataForm.email"></el-input>
          </el-form-item>
          <el-form-item prop="age">
            <el-input type="text" prefix-icon="el-icon-user" placeholder="请输入用户年龄" v-model.trim="dataForm.age">
            </el-input>
          </el-form-item>
          <el-form-item prop="sex">
            <el-select v-model="dataForm.sex">
              <el-option label="女" value="女"></el-option>
              <el-option label="男" value="男"></el-option>
              <el-option label="保密" value="保密"></el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialogVisible">取 消</el-button>
        <el-button type="primary" @click="showDialogVisible, submit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
  
<script>
import rules from '@/utils/rules'
import { addUser } from '@/services/systemManage'
export default {
  name: 'addRolepopUp',
  data() {
    return {
      dataForm: {
        username: '',
        email: '',
        age: '',
        sex: '保密'
      },
      dialogVisible: false,
      checkForm: {
        //用户名校验
        username: [
          { require: true, validator: rules.FormValidate.Form().validateUserName, trigger: 'blur' }
        ],
        //邮箱校验
        email: [
          { require: true, validator: rules.FormValidate.Form().validateEmail, trigger: 'blur' }
        ],
        //年龄校验
        age: [
          { require: true, validator: rules.FormValidate.Form().validataAge, trigger: 'blur' }
        ],
      },
    };
  },
  methods: {
    closeDialogVisible() {
      this.dialogVisible = false
    },
    showDialog() {
      this.dialogVisible = true
    },
    submit() {
      let data = {}
      data.username = this.dataForm.username
      data.email = this.dataForm.email
      data.age = (this.dataForm.age)
      data.sex = this.dataForm.sex
      addUser(data).then((res) => {
        if (res.data.code === 200) {
          this.$message({
            message: "添加用户成功！",
            type: "success",
          })
          this.dialogVisible = false  //关闭弹窗
          this.$parent.getFollowdiaryList() //刷新页面
        } else if (res.data.code === 411) {
          this.$message({
            message: "用户名重复！",
            type: "error",
          })
        } else if (res.data.code === 406) {
          this.$message({
            message: res.data.message,
            type: "error"
          })
        }
      })
    }
  }
};
</script>
<style>

</style>