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
    <div class="wrapper Main-info">
        <div class="col-left">
            <div class="personVideo">
                <div class="person-title">收藏的视屏</div>
            </div>
            <div class="personMain">
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
        </div>
    </div>
    <el-table
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
    </el-table>
  </div>
</template>

<script>
import {getDynamics,getuserMsg,userVideoCollect} from '../../service/userServers'
import {createPublicUrl} from "@/utils";

export default {
    name:'otherPerson',
  data(){
      return{
        userId:'',
        content:{},//动态信息
        userMsg:{},//其他用户信息
        Collections:{}//收藏信息
      }
  },
  mounted() {
    this.userId = this.$route.query.userId
    getDynamics(this.userId).then((res=>{
      this.content = res.data.data
      console.log(this.content)
    }))
    this.getothersMsg(),
    this.getotherCollect()
  },
  computed:{
    publicUrl(){
      return createPublicUrl()
    }
  },
  methods:{
    getothersMsg() {
      getuserMsg(this.userId).then((res=>{
        this.userMsg = res.data.data
        console.log(this.userMsg)
      }))
    },
    getotherCollect(){
      userVideoCollect(this.userId).then((res)=>{
        console.log(res)
        this.Collections = res.data.data.list
        console.log(this.Collections)
      })
    }
  }
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
    .Main-info{
        margin-top: 15px;
        display: flex;
        justify-content: space-between;
        .col-left{
            padding: 15px;
            width: 100%;
            background: #fff;
            border: 1px solid #eee;
            border-radius: 4px;
            .personVideo{
                margin-bottom: 17px;
                border-bottom: 1px solid #eee;
                .person-title{
                    line-height: 33px;
                    padding: 0 0 15px;
                    font-size: 20px;
                    color: #000;
                }
            }
            .personMain{
                max-height: 935px;
                .Main-item{
                    margin: 0 0 3px;
                    padding: 10px 10px 10px 0;
                    float: left;
                    width: 226px;
                    .item-img{
                      width: 216px;
                      height: 130px;
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
