//我的动态
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <div class="allBox">
              <div class="UserBox second">
                <div>
                  <div class="form-group">
                    <label class="contents">发表我的动态</label>
                    <textarea class="form-control" v-model="contents.content" placeholder="说说你的心情......"></textarea>
                    <el-button type="text" size="large" @click="showDialog = !showDialog">😃</el-button>
                    <VEmojiPicker v-show="showDialog" @select="selectEmoji"></VEmojiPicker>
                    <uploadDypicture></uploadDypicture>
                  </div>
                  <div class="form-group">
                    <button class="btn btn-primary" @click="AddDynamics">发表动态</button>
                  </div>

                  <div class="bili-dyn-item"
                  v-for="item in Dynamics"
                  :key="item.dynamicId">
                    <div class="bili-dyn-item__main">
                      <div class="bili-dyn-item__avatar" >
                        <div class="bili-dyn-avatar" style="width: 48px; height: 48px;">
                          <div class="bili-avatar" style="width: 48px;height:48px;transform: translate(0px, 0px);">
                            <img src="https://system-1234.oss-cn-chengdu.aliyuncs.com/user/userImage/8b670200-fb7c-41cc-8cad-3703a3311bf0.png">
                          </div>
                        </div>
                      </div>
                      <div class="bili-dyn-item__header">
                        <div class="bili-dyn-title">
                          <span class="bili-dyn-title__text" style="color: rgb(251, 114, 153);">{{item.author.nickname}}</span>
                        </div>
                        <div class="bili-dyn-time">{{item.createDate}}</div>
                      </div>
                      <div class="picture">
                        <div style="color: #222;">{{item.content}}</div>
                        <img :src="[getpicture+item.picture]" v-if="item.picture">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--分页表单-->
              <el-pagination
                  background
                  layout="prev, pager, next"
                  :total=100
                  :page-size="pageSize"
                  @current-change="handleCurrentChange"
                  @prev-click="prevPage"
                  @next-click="nextPage"
                  class="page"
              >
              </el-pagination>
            </div>


          </div>
        </div>
      </div>
    </div>
  </div>


</template>

<script>
import { mapGetters } from 'vuex'
import {VEmojiPicker} from 'v-emoji-picker';
import {createPublicUrl} from '../../utils/index'
import uploadDypicture from '../../components/upload/uploadDypicture'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import {getDynamics, getallDynamics,setDynamics, deleteDynamics} from '@/service/userServers'
export default {
  data() {
    return {
      showDialog: false,
      Dynamics:[],
      page: 1, //请求第一次的params
      pageSize: 5,
      contents:{
        content:'',
        picture:''
      },
      fileList:[{
        name:'',
        url:''
      }],
    }
  },
  components: { personAside,personHeader,uploadDypicture,VEmojiPicker},
  name: "teacherReply",
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
    this.GetDynamics()
  },
  methods: {
    selectEmoji(emoji) {
      console.log(typeof  emoji.data)
      this.contents.content = this.contents.content + emoji.data
    },
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
    //添加用户动态
    AddDynamics(){
      // console.log(this.contents)
      setDynamics(this.contents).then((res)=>{
        console.log(this.contents)
        if (res.data.code === 406){
          this.$message.error("内容不能为空")
        }else if(res.data.code === 200){
          this.$message.success("发布动态成功！")
        }
        console.log(res)
        this.GetDynamics()
      })
    },
    //获取所有动态
    GetDynamics(){
      getallDynamics(this.page).then((res)=>{
        console.log(res)
        this.Dynamics = res.data.data.list
        console.log(this.Dynamics)
      })
    },
    handleChange(file, fileList) {
      this.fileList = fileList.slice(-3);
    },
    //分页大小改变
    handleSizeChange(val) {
      this.pageSize = val;
    },
    //当前页数改变
    handleCurrentChange(page) {
      this.page = page;
      this.GetDynamics();
    },
    //上一页
    prevPage(page){
      this.page = page - 1
    },
    //下一页
    nextPage(page){
      this.page = page + 1
    },
  },
  computed: {
    afterChangeData(){
      let start = (this.pageNo - 1) * this.pageSize
      let end = this.pageNo * this.pageSize
      return this.Dynamics.slice(start,end)
    },
    ...mapGetters('userInfo',
        {
          getUserImg: 'getUserImg'
        }),
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
    getpicture(){
      return createPublicUrl()
    }
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  margin-top: 15px;
  .containBox {
    margin-top: 5px;
    display: flex;
    .contain-right {
      flex: 3;
    }
  }
}
.allBox {
  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;
  }
  .second {
    margin-top: 15px;
    .contents{
      font-size: 18px;
      font-weight: bold;
      width: 100%;
      Text-align:center;

    }
  }
}
.bili-dyn-item{
  background-color: #fff;
  border-radius: 4px;
  font-family: Helvetica Neue,Helvetica,Arial,Microsoft Yahei,Hiragino Sans GB,Heiti SC,WenQuanYi Micro Hei,sans-serif;
  letter-spacing: 0;
  min-width: 632px;
  position: relative;
  .bili-dyn-item__main{
    padding: 0 12px 0 88px;
    position: relative;
    .bili-dyn-item__avatar{
      height: 48px;
      left: 24px;
      position: absolute;
      top: 24px;
      width: 48px;
      .bili-avatar{
        img{
          width: 100%;
          height: 100%;
        }
      }
    }
    .bili-dyn-item__header{
      height: 73px;
      padding-top: 27px;
      .bili-dyn-title{
        align-items: center;
        display: flex;
        height: 24px;
        width: max-content;
        .bili-dyn-title__text{
          cursor: pointer;
          font-size: 16px;
        }
        .bili-dyn-time{
          color: #99a2aa;
          cursor: pointer;
          font-size: 8px;
          height: 22px;
          line-height: 18px;
          padding-top: 4px;
          transition: color .3s ease;
          user-select: none;
          width: fit-content;
        }
      }
    }
  }
}
.btn-primary{
  margin-left: 800px;
}
.picture{
  margin-top: 10px;
  margin-bottom: 10px;
  img{
    width: 200px;
    margin-top: 10px;
  }
}
</style>
