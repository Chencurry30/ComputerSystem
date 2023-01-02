<!--将角色给用户-->
<template>
  <div class="home">
    <el-dialog :title="title" append-to-body :visible.sync="dialogVisible">
      <div style="margin: 15px 0;"></div>
      <el-checkbox-group v-model="userCheckList">
        <el-checkbox v-for="role in roleList" :label="role.roleId" :key="role.roleId">{{ role.name }}</el-checkbox>
      </el-checkbox-group>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialogVisible()">取 消</el-button>
        <el-button type="primary" @click="subminRole()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getRoleList, renewRole, userRole } from '../../services/systemManage'
export default {
  name: 'GiveRole',
  data() {
    return {
      form: {},
      dialogVisible: false,
      activeName: 'first',
      title: '选择角色',
      userCheckList: [],
      roleList: [],
    }
  },
  methods: {
    //返回所有的角色集合 
    getAllRole() {
      getRoleList().then((res) => {
        console.log(res);
        this.roleList = res.data.data //获取后台角色
      })
    },
    //返回用户的角色 
    getUserRole(fatherItem) {
      this.userCheckList = []
      userRole(fatherItem.userId).then((res) => {
        let list = res.data.data
        list.forEach(item => {
          this.userCheckList[this.userCheckList.length++] = item.roleId
        });
        this.userCheckList =  Object.values( this.userCheckList)
      })
    },
    // 显示弹窗
    showGiveRoles(fatherItem) {
      this.userId = fatherItem.userId
      this.getAllRole()                    //获取所有的角色列表
      this.getUserRole(fatherItem)       //获取用户目前拥有的角色列表
      this.dialogVisible = true
    },
    //关闭弹窗
    closeDialogVisible() {
      this.dialogVisible = false
    },
    //提交角色
    subminRole() {
      let data = {}
      data.userId = this.userId
      data.roleList = []
      this.userCheckList.forEach(item=>{
        let roleData = {
          roleId:item
        }
        data.roleList.push(roleData)
      })
      //更新用户角色 
      renewRole(data).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.dialogVisible = false //关闭弹窗
          this.$parent.getFollowdiaryList() //相当于刷新列表，重新获取了一遍用户信息
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
.el-input {
  width: 150px;
  margin: 15px 5px 10px 20px;
}

.xz {
  margin-left: 20px;
}

.el-radio-group {
  margin-left: 50px;
  margin-bottom: 10px;
  margin-top: 10px;
}

.top {
  margin-top: -40px;
}

.xz1 {
  margin-bottom: 10px;
}
</style>