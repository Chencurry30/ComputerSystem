<!--这个页面是用来保证用户点击其他用户图像时显示其他用户的相关内容，和个人页面差不过大，所以独立出来-->
<template>
  <div class="MainBox w">
    <div class="wrapper">
        <div class="wrapper-header">
            <div class="wrapper-user">
                <div class="user-info">
                    <div class="user-img">
                         <img :src="[publicUrl + userMsg.image]" alt="">
                    </div>
                    <div class="user-basic">
                        <div class="nickName">{{userMsg.nickname}}</div>
                        <div>性别：{{userMsg.sex}}</div>
                        <div>年龄：{{userMsg.age}}</div>
                        <div class="personalProfile">
                          个性签名：{{userMsg.message}}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="navigator">
            <div class="navigator-info">主页</div>
        </div>
    </div>
    <div class="wrapper collect-Main">

      <div class="collect-Main-header">
        <div class="person-title">收藏的视屏</div>
      </div>


      <div class="collect-Main-connect">
        <div class="connect-header">
          <div class="Main-item"
               v-for="item in Collections"
               :key="item.videoId">
            <div class="item-img">
              <img :src="[publicUrl + item.image]">
            </div>
            <div class="item-title">{{item.name}}</div>
            <div class="item-others">
              <div class="left">{{item.nickname}}</div>
              <div class="right">{{item.time}}</div>
            </div>
          </div>
        </div>
        <pagerView :pageInfo="collectPage"  @giveFatherPageNo="getSonPageNo"></pagerView>
      </div>
    </div>
    <!-- <el-table
        :data="content"
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
    </el-table> -->
  </div>
</template>

<script>
import {getDynamics,getuserMsg,userVideoCollect} from '../../service/userServers'
import {createPublicUrl} from "@/utils";
import PagerView from "@/components/remark/PagerView.vue";

export default {
    name:'otherPerson',
  components: {PagerView},
  data(){
      return{
        userId:'',
        content:{},//动态信息
        userMsg:{},//其他用户信息
        Collections:{},//收藏信息
        collectPage:{} //分页器中存储的信息
      }
  },
  mounted() {
    this.userId = this.$route.query.userId
    getDynamics(this.userId).then((res=>{
      this.content = res.data.data
    }))
    this.getothersMsg(),
    this.getotherCollect(1)
  },
  methods:{
    //获取用户的动态列表
    getothersMsg() {
      getuserMsg(this.userId).then((res=>{
        this.userMsg = res.data.data
      }))
    },

    //获取用户收藏视屏列表
    getotherCollect(pageNum){
      console.log(this.userId)
      userVideoCollect(pageNum,this.userId).then((res)=>{
        console.log(res)
        if(res.data.code === 200){
          let data = {}
          data.pageNo = res.data.data.pageNum     //当前的页码数
          data.pagesize = res.data.data.pageSize  //每一页的大小
          data.total = res.data.data.total        //总共的个数
          data.pageTotal = res.data.data.pages    //总共有几页

          //将获取的分页数据转化给分页器中
          this.collectPage = data
          this.Collections = res.data.data.list
        }
      })
    },
    //获取分页器中传递的数据
    getSonPageNo(pageNum){
      this.getotherCollect(pageNum)

    }
  },
  computed:{
    publicUrl(){
      return createPublicUrl()
    }
  },
}
</script>

<style lang="less" scoped>

    .el-table{
      padding: 15px;
      width: 100%;
      background: #fff;
      border: 1px solid #eee;
      border-radius: 4px;
      margin-top: 15px;
    }
    .wrapper{
        width: 1100px;
        margin: 0 auto;
        position: relative;
        .wrapper-header{
            position: relative;
            height: 200px;
            background: url(../../assets/Img/banner/person.png) no-repeat;
            background-size: 100%;
            .wrapper-user{
                display: flex;
                position: absolute;
                bottom: 0;
                z-index: 10;
                .user-info{
                    display: flex;
                    align-items: center;
                    margin-left: 20px;
                    padding-bottom: 16px;
                    .user-img{
                        width: 72px;
                        height: 72px;
                        img{
                          width: 100%;
                          height: 100%;
                          border-radius: 50%;
                        }
                    }
                    .user-basic{
                        margin-left: 20px;
                        color: #ffffff;
                        .nickName{
                            margin-bottom: 5px;
                            font-weight: 700;
                            line-height: 18px;
                            font-size: 18px;
                        }
                        .personalProfile{
                            font-size: 14px;
                        }
                    }
                }
            }
        }
        .navigator{
            padding: 0 20px;
            height: 66px;
            line-height:66px;
            background: #fff;
            box-shadow: 0 0 0 1px #eee;
            border-radius: 0 0 4px 4px;
            .navigator-info{
                height: 100%;
                font-size: 18px;
                color: #222;
            }
        }
    }
    .collect-Main{
      margin-top: 15px;
      .collect-Main-header{
        margin-bottom: 17px;
        border-bottom: 1px solid #eee;
        .person-title{
          line-height: 33px;
          padding: 0 0 15px;
          font-size: 20px;
          color: #000;
        }
      }
      .collect-Main-connect{
        width: 100%;
        .connect-header{
          display: flex;
          flex-wrap: wrap;
          .Main-item{
            margin: 0 0 3px;
            padding: 10px 10px 10px 0;
            width: 275px;
            .item-img{
              width: 100%;
              height: 160px;
              border-radius: 4px;
              background: red;
              img{
                width: 100%;
                height: 100%;
              }
            }
            .item-title{
              line-height: 20px;
              height: 38px;
              margin-top: 6px;
              overflow: hidden;

            }
            .item-others{
              margin-top: 6px;
              display: flex;
              justify-content: space-between;
              white-space: nowrap;
              height: 14px;
              line-height: 14px;
              color:#999;
              font-size: 12px;
            }
          }
        }
         }

        }


</style>
