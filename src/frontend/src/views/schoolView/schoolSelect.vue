<template>
  <div class="videoPage">
    <div class="MainHeader">
      <div class="fittle">
        <div class="fittle-box">
          <div class="fittle-itme" v-for="(fatherItem) in getNavType" :key="fatherItem.id">
                <span class="typename centerLocation">{{fatherItem.name}}</span>
                <ul class="itemList">
                    <li class="item centerLocation"  v-for="(childItem) in fatherItem.list" :key="childItem.id"
                    :class="{activeOn1:selectId.first===childItem.regionId,
                    activeOn2:selectId.second === childItem.typeId,
                    activeOn3:selectId.thild === childItem.attributeId}" 

                    :data-regionId="childItem.regionId" :data-typeId="childItem.typeId" :data-attributeId="childItem.attributeId"
                    @click="selectVideo">{{childItem.name}}</li>
                </ul>
          </div>
        </div>
      </div>
    </div>
     <div class="MainContent">
      <div class="school-list">
        <thead>
          <tr>
            <th style="width:150px">院校名称</th>
            <th style="width:150px">院校类型</th>
            <th style="width:250px">院校地址</th>
            <th style="width:150px">院校隶属</th>
            <th style="width:500px">院校信息</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item) in getSchoolDataList" :key="item.collegeId">
            <td>{{item.name}}</td>
            <td>{{item.type}}</td>
            <td>{{item.address}}</td>
            <td>{{item.subjection}}</td>
            <td>{{item.disDevelop}}</td>
          </tr>
        </tbody>
      </div>
    </div>
    <!--<div class="MainFooter"> -->
      <!--其中的第一组为父组件向子组件传递的参数  第二组是子组件向父组件传递的选择的页码-->
      <!-- <PagerView :pageData="getVideoPage"  @giveFatherPageNo="getSonPageNo"></PagerView>
    </div> -->
  </div>

</template>

<script>
import _ from 'lodash'
import {mapGetters} from 'vuex'
import PagerView from '../../components/remark/PagerView'
export default {
    name: "schoolSelect",
    data(){
      return{
        selectId:{
          first:0,
          second:0,
          thild:0,
          pageNum:1
        },
      }
    },
    components: {
      PagerView
    },
    mounted(){
      //获取视屏的选择列表 
      this.getschoolNavType()
      //获取最初始化的相关数据 
      this.getvideos()
    },
    methods:{
      //获取院校的选择列表 
      getschoolNavType(){
        this.$store.dispatch('schoolData/getNavType')
      },
      //获取初始化的相关数据
      getvideos(){
        let first = 0
        let second = 0
        let thild = 0
        let pageNum = 1
        this.$store.dispatch('videoData/getVideoData',{first,second,thild,pageNum})
      },
      //获取子组件返回的pageNo 
      getSonPageNo(pageNum){
        let {first,second,thild} = this.selectId
        this.$store.dispatch('videoData/getVideoData',{first,second,thild,pageNum})
      },

      //根据列表中的选项，返回相关的数据 
      selectVideo:_.throttle(function(event){
        let element = event.target
        let {regionid,typeid,attributeid} = element.dataset
        if(regionid !== undefined){
          this.selectId.first = parseInt(regionid)
        }else if(typeid !== undefined){
          this.selectId.second = parseInt(typeid)
        }else if(attributeid !== undefined){
          this.selectId.thild = parseInt(attributeid)
        }
        let {first,second,thild,pageNum} = this.selectId
        console.log(first,second,thild,pageNum);
        this.$store.dispatch('schoolData/getschoolData',{first,second,thild,pageNum})
      },1500)


    },
    computed:{
      ...mapGetters('schoolData',{
        getNavType:'getSchoolNavType',
        getSchoolDataList:'getSchoolDataList',
        getVideoPage:'getVideoPage',
      })
    }
}
</script>

<style lang="less" scoped>
  .MainHeader{
    background: #f2f4f6;
    .fittle{
      margin: 0 auto;
      padding-top: 20px;
      width: 1280px;
      .fittle-box{
          // position: relative;
      // height: 170px;
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
              .activeOn1,.activeOn2,.activeOn3{
                  color: #f20d0d;
                  font-weight: 700;
                  background: #f20d0d0f;
              }
          }
          }
      }
    }
  }
  .MainContent{
    margin: 0 auto;
    padding-top: 20px;
    width: 1280px;
    .school-list{
      width: 100%;
      line-height: 25px;
      border: 1px solid #e9e9e9;
      border-bottom: 0;
      border-collapse: collapse;
      border-spacing: 0;
      word-break: break-all;
      word-wrap: break-word;
      th{
        padding: 12px 10px;
        border-bottom: 1px solid #e9e9e9;
        font-size: 16px;
        font-weight: 700;
        text-align: left;
      }
      td{
        padding: 12px 10px;
    border-bottom: 1px solid #e9e9e9;
    font-size: 16px;
    color: #666;
    text-align: left;
      }
    }
  }
</style>