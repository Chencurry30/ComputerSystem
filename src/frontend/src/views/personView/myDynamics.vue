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
                    <label>发表动态</label>
                    <textarea class="form-control" v-model="contents.content"></textarea>
                  </div>
                  <div class="form-group">
                    <button class="btn btn-primary" @click="postDynamics">发表动态</button>
                  </div>
                  <el-table
                      :data="Dynamics"
                      stripe
                      style="width: 100%">
                    <el-table-column
                        prop="createDate"
                        label="日期"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="content"
                        label="内容"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="userId"
                        label="用户">
                    </el-table-column>
                  </el-table>
                </div>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>
  </div>


</template>

<script>
import { mapGetters } from 'vuex'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import {getDynamics, getallDynamics,setDynamics, deleteDynamics} from '../../service/userServers'
export default {
  data() {
    return {
      Dynamics:{},
      contents:{
        content:'',
        picture:''
      }
    }
  },
  components: {personAside,personHeader},
  name: "teacherReply",
  mounted() {
    this.GetDynamics()
    //避免页面刷新导致vuex中的数据丢失
    this.$store.dispatch('userInfo/getUserInfo')

  },
  methods: {
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
    changeEditor() {
      this.$refs.InfoPopup.showPopup(this.getUserInfo);
    },
    //发请求
    postDynamics(){
      // console.log(this.contents)
      setDynamics(this.contents).then((res)=>{
        if (res.data.code === 406){
          this.$message.error("内容不能为空")
        }else if(res.data.code === 200){
          this.$message.success("发布动态成功！")
        }
        console.log(res)
      })
    },
    //获取动态
    GetDynamics(){
      getallDynamics().then((res)=>{
        this.Dynamics = res.data.data
        console.log(this.Dynamics)
      })
    }

  },
  computed: {
    ...mapGetters('userInfo',
        {
          getUserImg: 'getUserImg'
        }),
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
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
  }
}
</style>
