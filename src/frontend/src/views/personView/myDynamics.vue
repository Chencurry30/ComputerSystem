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
                    <button class="btn btn-primary" @click="AddDynamics">发表动态</button>
                  </div>

                  <div class="bili-dyn-item"
                  v-for="item in Dynamics"
                  key="item.dynamicId">
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
                      <div>
                        <span style="color: #222;">{{item.content}}</span>
                      </div>
                    </div>
                  </div>

<!--                  <el-table-->
<!--                      :data="Dynamics"-->
<!--                      stripe-->
<!--                      style="width: 100%">-->
<!--                    <el-table-column-->
<!--                        prop="createDate"-->
<!--                        label="日期"-->
<!--                        width="180">-->
<!--                    </el-table-column>-->
<!--                    <el-table-column-->
<!--                        prop="content"-->
<!--                        label="内容"-->
<!--                        width="180">-->
<!--                    </el-table-column>-->
<!--                    <el-table-column-->
<!--                        prop="author.nickname"-->
<!--                        label="用户">-->
<!--                    </el-table-column>-->
<!--                  </el-table>-->
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
import {getDynamics, getallDynamics,setDynamics, deleteDynamics} from '@/service/userServers'
export default {
  data() {
    return {
      Dynamics:{
        author:{
          nickname:''
        }
      },
      contents:{
        content:'',
        picture:''
      }
    }
  },
  components: { personAside,personHeader},
  name: "teacherReply",
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
    this.GetDynamics()
  },
  methods: {
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
        if (res.data.code === 406){
          this.$message.error("内容不能为空")
        }else if(res.data.code === 200){
          this.$message.success("发布动态成功！")
        }
        console.log(res)
      })
    },
    //获取所有动态
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
</style>
