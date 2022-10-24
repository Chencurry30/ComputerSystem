<template>
    <div>
      我是院校模块
      <selectHeader></selectHeader>
      <div class="allBox w">
        <div class="school-list clearfix">
          <div class="itemlist">
            <div class="schoolItem">
              <div class="schoolItem-title">
                <div class="left">北京大学</div>
                <div class="right">查看详情</div>
              </div>
              <div class="schoolItem-info"></div>
              <div class="schoolItem-select">
                <div>专业目录</div>
              </div>
              
            </div>

          </div>
        </div>
      </div>
    </div>
</template>

<script>
import {getSchoolList} from '../../Servers/school'
import selectHeader from '../../components/selectBox/selectHeader.vue'
export default {
  components: { selectHeader },
  name:'schoolSelect',
  mounted(){
    getSchoolList(1).then((res)=>{
      console.log(res);
    })
  }

}
</script>

<style lang="less" scoped>
  .school-list{
    .itemlist{
      margin-top: 10px;
      .schoolItem{
        float: left;
        width: 300px;
        .schoolItem-title{
          display: flex;
          justify-content: space-between;
          height: 31px;
          line-height: 31px;
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
          font-size: 14px;
          color: #999999;
          margin-top: 15px;
          margin-bottom: 20px;
        }
      }


    }



  }
</style>