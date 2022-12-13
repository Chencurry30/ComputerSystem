<!--上传视屏的页面-->
<template>
  <div class="MainBox w MainPageHeader">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <div class="uploadVideo">
              <div class="uploadLeft">
                <uploadVideo></uploadVideo>
              </div>
              <div class="uploadRight">
                <div class="uploadItem">
                  <div class="laber">视屏名字</div>
                  <div class="uploadItemData">
                    <input type="text" v-model="videoData.name">
                  </div>
                </div>
                <div class="uploadItem">
                  <div class="laber">视屏简介</div>
                  <div class="uploadItemData">
                    <textarea v-model="videoData.introduction"></textarea>
                  </div>
                </div>
                <div class="uploadItem">
                  <div class="laber">视屏种类</div>
                  <div class="uploadItemData">
                    <el-select v-model="videoData.typeId" clearable placeholder="请选择上传视屏的种类">
                      <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                      </el-option>
                    </el-select>
                  </div>
                </div>
                <div class="uploadItem">
                  <div class="laber">视屏时长</div>
                  <div class="uploadItemData">
                    <input type="text" v-model="videoData.duration">
                  </div>
                </div>
                <div class="uploadItem">
                  <div class="laber">视屏图片</div>
                  <div class="uploadItemData">
                    <div>{{ videoData.image }}</div>
                  </div>
                </div>
                <div class="uploadItem">
                  <div class="laber">视屏链接</div>
                  <div class="uploadItemData">
                    <div>{{ videoData.link }}</div>
                  </div>
                </div>
                <div class="uploadBtn" @click="uploadVideoAction">上传提交</div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { uploadVideoData } from '../../service/userServers'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import UploadVideo from "@/components/upload/uploadVideo.vue";
export default {
  name: "collectionVideo",
  data() {
    return {
      options: [{
        value: '1',
        label: '英语'
      }, {
        value: '2',
        label: '数学'
      }, {
        value: '3',
        label: '政治'
      }, {
        value: '4',
        label: '计组'
      }, {
        value: '5',
        label: '计网'
      },
      {
        value: '6',
        label: '数据结构'
      }],
      videoData: {
        typeId: '',
        name: '',
        introduction: '',
        duration: '',
        link: '',
        image: '',
      }
    }
  },

  components: {
    UploadVideo,
    personAside,
    personHeader
  },
  //避免页面刷新导致vuex中的数据丢失
  mounted() {
    this.$store.dispatch('userInfo/getUserInfo')
  },
  methods:{
    uploadVideoAction(){
      uploadVideoData(this.videoData).then((res)=>{
        console.log(res);
      })
    }
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  .containBox {
    margin-top: 5px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}

.uploadVideo {
  margin-top: 15px;
  display: flex;
  justify-content: space-between;

  .uploadLeft {
    overflow: hidden;
  }

  .uploadRight {
    flex: 60%;

    .uploadItem {
      margin: 10px 0;
      display: flex;
      align-items: center;
      width: 100%;

      .laber {
        font-size: 16px;
      }

      .uploadItemData {
        flex: 80%;
        margin-left: 10px;

        input,
        textarea {
          padding: 8px 5px;
          width: 100%;
          border-radius: 8px;
          border: 1px solid #DCDFE6;
        }
      }
    }

    .uploadBtn {
      float: right;
      margin-top: 36px;
      padding: 9px 20px;
      width: 100px;
      cursor: pointer;

      border: 1px solid #DCDFE6;

      text-align: center;
      font-size: 14px;
      border-radius: 6px;
    }

  }
}
</style>
