<!--查看视屏信息的弹窗-->
<template>
  <div class="auditBox">
    <el-dialog title="视屏相关信息展示" center :visible.sync="dialogVisible" width="60%">
      <div class="auditMain">
        <div class="MainHeader">
          <div class="MainLeft">
            <div class="title">视屏图片</div>
            <img :src="[getPublicUrl + videoData.image]" alt="">
          </div>
          <div class="MainRight">
            <div class="title">视屏信息</div>
            <div class="ItemData">
              <div class="ItemDataTitle">视屏名称</div>
              <div class="ItemDataInfo">{{ videoData.name }}</div>
            </div>
            <div class="ItemData">
              <div class="ItemDataTitle">上传作者</div>
              <div class="ItemDataInfo">{{ videoData.nickname }}</div>
            </div>
            <div class="ItemData">
              <div class="ItemDataTitle">上传时间</div>
              <div class="ItemDataInfo">{{ videoData.time }}</div>
            </div>
          </div>
        </div>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="closeDialog">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { createPublicUrl } from '../../../utils/getPublicUrl'
export default {
  name: 'toViewpopUp',
  data() {
    return {
      dialogVisible: false,
      videoData: {}
    };
  },
  methods: {
    showDialog(row) {
      this.videoData = row
      this.dialogVisible = true
    },
    closeDialog() {
      this.dialogVisible = false
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

  .MainLeft {
    width: 400px;

    img {
      width: 100%;
    }
  }

  .MainRight {
    margin-left: 20px;
    width: 490px;

    .ItemData {
      margin-bottom: 10px;
      display: flex;
      align-items: center;
      font-size:14px;
      .ItemDataTitle {
        width: 72px;
        margin-right: 10px;
      }

      .ItemDataInfo {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
      }
    }
  }
}

.title {
  margin-top: 6px;
  font-size: 14px;
}

/deep/ .el-form-item__label {
  padding: 0 20px 0 0;
}
</style>