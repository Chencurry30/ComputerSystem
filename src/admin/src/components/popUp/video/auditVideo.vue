<!--审核视屏的弹窗-->
<template>
  <div class="auditBox">
    <el-dialog title="提示" center :visible.sync="dialogVisible" width="60%">
      <div class="auditMain">
        <div class="MainHeader">
          <div class="MainLeft">
            <div class="title">视屏图片</div>
            <img :src="[getPublicUrl + videoImage]" alt="">
          </div>
          <div class="MainRight">
            <div class="title">视屏内容</div>
            <videoPlay :videoLink="videoLink"></videoPlay>
          </div>
        </div>
        <div class="MainContent">
          <div class="title">审核选项</div>
          <el-radio-group v-model="commitData.examineResult" class="ContentSelect">
            <el-radio :label="1">审核通过</el-radio>
            <el-radio :label="2">审核不通过</el-radio>
          </el-radio-group>
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
import { createPublicUrl } from '../../../utils/getPublicUrl'
import {auditVideoAction} from '../../../services/videoManage'
import videoPlay from '../../videoPlay/videoPlay';
export default {
  components: { videoPlay },
  name: 'auditVideo',
  data() {
    return {
      dialogVisible: false,
      videoImage: '',
      videoLink: '',
      commitData: {
        examineId:0,
        examineResult: 0,
        reviewComment: '',
      }

    };
  },
  methods: {
    showDialog(row) {
      this.videoImage = row.image
      this.videoLink = row.link
      this.commitData.examineId = row.examineId
      console.log(row);
      this.dialogVisible = true
    },
    subMitData(){
      if(this.commitData.examineResult === 0){
        this.$message.error('请给出审核的状态')
      }else if(this.commitData.reviewComment === ''){
        this.$message.error('请给出审核意见')
      }else{
        auditVideoAction(this.commitData).then((res)=>{
          if(res.data.code === 200){
            this.$message.success('视屏审核成功')
            this.dialogVisible = true
            this.$parent.getAuditVideoList(-1)
          }
        })
      }
    }
  },
  computed: {
    getPublicUrl() {
      return createPublicUrl()
    }
  }
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