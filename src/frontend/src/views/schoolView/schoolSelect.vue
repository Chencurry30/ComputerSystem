<template>
  <div class="MainHeader">
    <div class="fittle">
    <div class="fittle-box w">
        <div class="fittle-itme" v-for="(fatherItem,index) in getschoolNavType" :key="index">
            <span class="typename centerLocation">{{fatherItem.name}}</span>
            <ul class="itemList">
                <li class="item centerLocation" v-for="(childItem) in fatherItem.list" :key="childItem.typeId"
                >{{childItem.name}}</li>
            </ul>
        </div>
    </div>
    </div>
    <div class="allBox w">
      <div class="school-list clearfix">
        <div class="itemlist">
          <div class="schoolItem">
            <div class="schoolItem-title">
              <div class="left">北京大学</div>
              <div class="right" @click="gotoSchoolPage">查看详情</div>
            </div>
            <div class="schoolItem-info">
              <div class="left">
                院校地区 - 院校类别 - 院校隶属 
              </div>
              <div class="right">
                院校属性
              </div>
            </div>              
          </div>
          <div class="schoolItem">
            <div class="schoolItem-title">
              <div class="left">北京大学</div>
              <div class="right">查看详情</div>
            </div>
            <div class="schoolItem-info">
              <div class="left">
                院校地区 - 院校类别 - 院校隶属 
              </div>
              <div class="right">
                院校属性
              </div>
            </div>              
          </div>

          <div class="schoolItem">
            <div class="schoolItem-title">
              <div class="left">北京大学</div>
              <div class="right">查看详情</div>
            </div>
            
            <div class="schoolItem-info">
              <div class="left">
                院校地区 - 院校类别 - 院校隶属 
              </div>
              <div class="right">
                院校属性
              </div>
            </div>              
          </div>
          <div class="schoolItem">
            <div class="schoolItem-title">
              <div class="left">北京大学</div>
              <div class="right">查看详情</div>
            </div>
            <div class="schoolItem-info">
              <div class="left">
                院校地区 - 院校类别 - 院校隶属 
              </div>
              <div class="right">
                院校属性
              </div>
            </div>              
          </div>
          <div class="schoolItem">
            <div class="schoolItem-title">
              <div class="left">北京大学</div>
              <div class="right">查看详情</div>
            </div>
            <div class="schoolItem-info">
              <div class="left">
                院校地区 - 院校类别 - 院校隶属 
              </div>
              <div class="right">
                院校属性
              </div>
            </div>              
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
    name: "videoSelect",
    components: {
    },
    mounted(){
      this.getSchoolType()
    },
    methods:{
      //获取视屏的选择列表 
      getSchoolType(){
        this.$store.dispatch('schoolData/getNavType')
      },
      gotoSchoolPage(){
        let location = {}
        location.name = 'schoolPage'
        console.log(location);
        this.$router.push(location)
      }
    },
    computed:{
      ...mapGetters('schoolData',{
        getschoolNavType:'getschoolNavType'
      })
    }
}
</script>

<style lang="less" scoped>
  .MainHeader{
    .fittle{
      padding-top: 20px;
      background: #f2f4f6;
    }
    .fittle-box{
      padding-bottom: 10px;
      font-size: 14px;
      color: #545c63;
      border-bottom: 1px solid #545c6333;
    .fittle-itme{
        display: flex;
        align-content: center;
        margin-bottom: 15px;
        .typename{
            margin-left: 20px;
            width: 3em;
            margin-right: 6px;
            font-weight: 700;
        }
        .itemList{
            display: flex;
            flex: 1;
            margin-bottom: 0px;
            .item{
                padding: 3px 10px;
                border-radius: 10px;
            }
            .activeOn{
                color: #f20d0d;
                font-weight: 700;
                background: #f20d0d0f;
            }
        }
        }
    }
    .school-list{
      .itemlist{
        margin-top: 15px;
        .schoolItem{
          float: left;
          width: 290px;
          background-color: #ffffff;
          box-shadow: 0px 0px 9px 1px rgb(0 0 0 / 33%);
          border-radius: 10px;
          padding: 10px;
          font-size: 0;
          margin-right: 10px;
          margin-bottom: 15px;
          .schoolItem-title{
            display: flex;
            justify-content: space-between;
            height: 31px;
            line-height: 31px;
            .left{
              padding: 0 5px;
              font-size: 20px;
              font-weight: 700;
            }
            .right{
              display: block;
              border-radius: 16px;
              margin-right: 10px;
              font-size: 14px;
              color: #ffffff;
              width: 94px;
              text-align: center;
              background-color: #ff9d00;
              cursor: pointer;
            }
          }
          .schoolItem-info{
            display: flex;
            justify-content: center;
            font-size: 14px;
            color: #999999;
            margin-top: 15px;
            margin-bottom: 20px;
          }
        }
      }
    }
  }
</style>