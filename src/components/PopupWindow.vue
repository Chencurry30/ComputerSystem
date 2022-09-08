<template>
    <div>
      <el-dialog 
      title="信息提示"
      :visible.sync="dialogVisible"
      width="50%"
center
      :before-close="handleClose">
  <span>这是一段信息</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
</el-dialog>
    </div>
</template>


<script>
  export default {
name:'PopupWindow',
    data() {
      return {
        dialogVisible: false
      };
    },
    methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      show(){
        this.dialogVisible = true
      }
    }
  };
</script>

<style scoped lang="less">
.el-dialog{
.el-dialog__header{
    text-align: center !important;
    background-color: red;
  }
}

</style>