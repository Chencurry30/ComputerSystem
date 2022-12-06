<!--收藏视屏的页面 -->
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">

          <div class="allBox">
            <personHeader></personHeader>
            <div class="uploadVideo">
              <div class="uploadLeft">
                <div class="uploadItem">
                  <el-input
                      type="textarea"
                      :autosize="{ minRows: 2, maxRows: 4}"
                      placeholder="请输入内容"
                      v-model="textarea3">
                  </el-input>
                </div>
                <div class="uploadItem">
                  <el-input
                      type="textarea"
                      :autosize="{ minRows: 2, maxRows: 4}"
                      placeholder="请输入内容"
                      v-model="textarea3">
                  </el-input>
                </div>
                <div class="uploadItem">
                  <el-select v-model="value4" clearable placeholder="请选择">
                    <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </div>
              </div>

              <div class="uploadRight">
                  <uploadVideo></uploadVideo>
                </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import UploadVideo from "@/components/upload/uploadVideo.vue";
export default {
  name: "collectionVideo",
  data(){
    return{
      options: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶'
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
      value4: '',
      textarea2: '',
      textarea3: ''
    }
  },
  components:{
    UploadVideo,
    personAside,
    personHeader
  },
  //避免页面刷新导致vuex中的数据丢失
  mounted() {
    this.$store.dispatch('userInfo/getUserInfo')
  },
};
</script>

<style lang='less' scoped>
.MainBox {
  margin-top: 70px;

  .containBox {
    margin-top: 5px;
    display: flex;


    .contain-right {
      flex: 3;
    }
  }
}
.uploadVideo{
  margin-top: 15px;
  display: flex;
  justify-content: space-between;
  .uploadLeft{
    flex: 50%;
    .uploadItem{
      width: 100%;
      margin: 5px 0;
    }
  }
}


</style>
