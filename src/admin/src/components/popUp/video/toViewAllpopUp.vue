<!--查看所有信息的弹窗页面-->
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
import videoPlay from '../../videoPlay/videoPlay';
export default {
  components: { videoPlay },
  name: 'auditVideo',
  data() {
    return {
      dialogVisible: false,
      videoImage: '',
      videoLink: '',
    };
  },
  methods: {
    showDialog(row) {
      this.videoImage = row.image
      this.videoLink = row.link
      console.log(row);
      this.dialogVisible = true
    },


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

.title {
  margin-top: 6px;
  font-size: 14px;
}

/deep/ .el-form-item__label {
  padding: 0 20px 0 0;
}
</style>