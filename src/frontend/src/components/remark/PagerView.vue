<!--分页器-->
<template>
  <div class="pagerview">
    <div class="pagerBox centerLocation">
        <ul class="pagination">
          <!-- 上一页 -->
          <li @click="prePage(),giveFatherPageNo()" :class="{'disabledBox':disabledPre}">
            <a aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
           <li v-for="(page,index) in pageNumber" :key="index" :class="{'active':page === pageData.pageNo}"
           @click="gotoPage(page),giveFatherPageNo()">
            <a>
              {{page}}
            </a>
          </li>
        
          <li @click="nextPage(),giveFatherPageNo()" :class="{'disabled':disabledNext}" >
            <a aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li> 
        </ul>
      </div>
  </div>
</template>

<script>
import { mapGetters} from 'vuex';
export default {
  name:'PagerView',
  props:['pageData'],
  data(){
    return{
      // pageData:this.pageData
    }
  },
  methods:{
    prePage(){
      if(this.pageData.pageNo === 1){
        this.pageData.pageNo = 1;
      }else{
      this.pageData.pageNo -= 1;
      }
    },
    nextPage(){
      if(this.pageData.pageNo === this.pageData.pageTotal){
        this.pageData.pageNo = this.pageData.pageTotal;
      }else{
      this.pageData.pageNo += 1;
      }
    },
    //计算从后端返回的分页器的相关数据的页面标明 
    calculatePage(){
      let totalPage = this.pageData.pageTotal  //获取总的页码数
      let pageNo = this.pageData.pageNo  //当前的页码数
      if(totalPage < 7) return totalPage
      if(pageNo <=5){ 
        return [1,2,3,4,5,'...',totalPage]
      }else if(pageNo >=totalPage -5){
        return [1,'...',totalPage-5,totalPage-4,totalPage-3,totalPage-2,totalPage-1,totalPage]
      }else{
        return [1,'...',pageNo-1,pageNo,pageNo+1,'...',totalPage]
      }
    },
    gotoPage(page){
      if(page === '...'){
        return;
      }else{
        this.pageData.pageNo = page
        this.calculatePage();
        // this.getPageData();
      }
    },

    //利用下面的点击选项，从子组件向父组件进行相关参数的传递 
    giveFatherPageNo(){
      this.$emit("giveFatherPageNo", this.pageData.pageNo);
    } 
    








  },
  //computed里面尽量不要做修改data数据的相关操作 
  computed:{
    //判断是否隐藏上一页 
    disabledPre(){
      return this.pageData.pageNo === 1;
    },
    disabledNext(){
      return this.pageData.pageNo === this.pageData.pageTotal
    },

    //用来展示下面分页器中所展示的相关数据,通过方法封装,避免在comput操作data的数据 
    pageNumber(){
      return this.calculatePage();
    },
    ...mapGetters('videoData',{
      getVideoPage:'getVideoPage'
    })
  },

}
</script>

<style lang="less" scoped>
.pagerview{
  margin:25px 0px 20px 0;
  .pagerBox{
  margin: 5px 0px;
  text-align: center;
  .pagination{
    margin-bottom: 0px;
    li{
      margin: 0 5px;
      padding: 0 4px;
      display: inline-block;
      min-width: 50px;
      height: 28px;
      line-height: 28px;
      font-size: 14px;
      border-radius: 2px;
      background-color: #f4f4f5;
      color: #606266;
      cursor: pointer;
    }
    .active {
      cursor: not-allowed;
      background-color: #409eff;
      color: #fff;
    }
  }
  .disabledBox{
    display: none;
  }
  }
}

</style>



   
