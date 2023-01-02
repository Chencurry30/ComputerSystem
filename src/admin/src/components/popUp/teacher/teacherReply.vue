<!--审核视屏的弹窗-->
<template>
  <div class="auditBox">
    <el-dialog title="提示" center :visible.sync="dialogVisible" width="60%">
      <div class="auditMain">
        <div class="MainHeader">
        </div>
        <div class="MainBottem">
          <el-form ref="form" :model="commitData" label-width="80px">
            <el-form-item label="审核意见">
              <el-input v-model="commitData.reviewComment"></el-input>
            </el-form-item>
          </el-form>
        </div>

      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="subMitData()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {disagreeTeacherApply} from '../../../services/teacherManage'
export default {
  name: 'teacherReply',
  data() {
    return {
      dialogVisible: false,
      commitData:{
        reviewComment:''
      },
      examineId:0,
    };
  },
  methods: {
    showDialog(row) {
      this.examineId = row.examineId
      this.dialogVisible = true
    },
    subMitData(){
      if(this.commitData.reviewComment === ''){
        this.$message.error('请给出审核理由')
      }else{
        disagreeTeacherApply(this.examineId,this.commitData.reviewComment).then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            this.$message.success('老师审核成功')
            this.dialogVisible = false
            this.$parent.getExamineData()
          }
        })
      }
    }
  },
};

</script>

<style lang="less" scoped>
.title {
  margin: 10px 0 10px 5px;
  font-size: 18px;
}

.MainHeader {
  display: flex;
  justify-content: space-between;

  .MainLeft {
    width: 400px;

    img {
      width: 100%;
    }
  }

  .MainRight {
    width: 480px;
  }
}

.MainContent {
  margin: 10px 0;
  display: flex;
  align-items: center;
  height: 39px;
  line-height: 39px;

  .title {
    margin-top: 6px;
    font-size: 14px;
  }

  .ContentSelect {
    margin-left: 10px;
    display: flex;
    align-items: center;
  }
}
/deep/ .el-form-item__label {
  padding: 0 20px 0 0;
}
</style>