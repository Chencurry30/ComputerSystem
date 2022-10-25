<template>
    <div>
      <selectHeader></selectHeader>
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
// import {getSchoolList} from '../../Servers/school'
import selectHeader from '../../components/selectBox/selectHeader.vue'
export default {
  components: { selectHeader },
  name:'schoolSelect',
  methods:{
    gotoSchoolPage(){
      console.log(1);
      let location = { name: "schoolPage" };
      this.$router.push(location);
    }
  }

}
</script>

<style lang="less" scoped>
  .school-list{
    .itemlist{
      margin-top: 10px;
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
</style>