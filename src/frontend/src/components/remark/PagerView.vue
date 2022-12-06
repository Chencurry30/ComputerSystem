<!--分页器-->
<template>
  <div class="pagerview">
    <div class="pagerBox centerLocation">
      <ul class="pagination">
        <!-- 上一页 -->
        <li @click="prePage()" :class="{'disabledBox':disabledPre}">
          <a aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <li v-for="(page, index) in pageNumber" :key="index" :class="{ 'active': page === pageData.pageNo }"
          @click="gotoPage(page)">
          <a>
            {{ page }}
          </a>
        </li>

        <li @click="nextPage()" :class="{ 'disabled': disabledNext }">
          <a aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import _ from 'lodash'
export default {
  name: 'PagerView',
  props: ['pageInfo'],
  data() {
    return {
      pageData: this.pageInfo || {}
    }
  },
  methods: {
    prePage: _.throttle(function () {
      if (this.pageData.pageNo === 1) {
        this.pageData.pageNo = 1;
        this.$message.success('这已经是第一页了')
      } else {
        this.pageData.pageNo -= 1;
        this.giveFatherPageNo(this.pageData.pageNo)
      }
    }, 1000),
    nextPage:_.throttle(function(){
      if (this.pageData.pageNo === this.pageData.pageTotal) {
        this.pageData.pageNo = this.pageData.pageTotal;
        this.$message.success('这已经是最后一页了')
      } else {
        this.pageData.pageNo += 1;
        this.giveFatherPageNo(this.pageData.pageNo)
      }
    },1000),
    //计算从后端返回的分页器的相关数据的页面标明 
    calculatePage() {
      let totalPage = this.pageData.pageTotal  //获取总的页码数
      let pageNo = this.pageData.pageNo  //当前的页码数
      if (totalPage < 7) return totalPage
      if (pageNo <= 5) {
        return [1, 2, 3, 4, 5, '...', totalPage]
      } else if (pageNo >= totalPage - 5) {
        return [1, '...', totalPage - 5, totalPage - 4, totalPage - 3, totalPage - 2, totalPage - 1, totalPage]
      } else {
        return [1, '...', pageNo - 1, pageNo, pageNo + 1, '...', totalPage]
      }
    },

    //利用lodash来防止抖动 
    gotoPage(page) {
      if (page !== '...' && this.pageData.pageNo !== page) {
        this.giveFatherPageNo(page)
        this.calculatePage();
      }
    },

    //利用下面的点击选项，从子组件向父组件进行相关参数的传递 
    giveFatherPageNo(page) {
      this.$emit("giveFatherPageNo", page);
    },




  },
  //computed里面尽量不要做修改data数据的相关操作 
  computed: {
    //判断是否隐藏上一页 
    disabledPre() {
      return this.pageData.pageNo === 1;
    },
    disabledNext() {
      return this.pageData.pageNo === this.pageData.pageTotal
    },

    //用来展示下面分页器中所展示的相关数据,通过方法封装,避免在comput操作data的数据 
    pageNumber() {
      return this.calculatePage();
    },
  },

  watch: {
    //利用属性的监听 
    pageInfo(newData) {
      this.pageData = newData
    }
  }

}
</script>

<style lang="less" scoped>
.pagerview {
  margin: 25px 0 20px 0;

  .pagerBox {
    margin: 5px 0;
    text-align: center;

    .pagination {
      margin-bottom: 0;

      li {
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

    .disabledBox {
      display: none;
    }
  }
}
</style>



   
