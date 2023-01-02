<!--顶部的面包屑,随时跳转-->
<template>
  <div class="Breadcrumb">
    <el-breadcrumb class="BreadcrumbMain" separator="×">
      <el-breadcrumb-item :to="routerItem.path" class="bread-view-tags" v-for="(routerItem) in breadList"
        :key="routerItem.path">
        <em>{{ routerItem.name }}</em>
        <i class="el-icon-close"></i>
      </el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  name: 'BreadCrumb',
  data() {
    return {
      breadList: [
        {
          name: "首页",
          path: "/homeView"
        }

      ],
    }
  },
  methods: {
    getBreadList(route) {
      let routeItem = { name: route.name, path: route.path }
      this.breadList.push(routeItem)
      this.breadList = this.breadList.filter((item,index,selfArr) =>{
        let list =  selfArr.map(item => {
          return item.path
        })
        return list.indexOf(item.path) === index
      })
    }


  },

  watch: {
    $route(route) {
      console.log(route);
      //获取面包屑的List 
      this.getBreadList(route)
    }
  },
}
</script>

<style lang="less" scoped>
.bread-view-tags {
  display: inline-block;
  position: relative;
  cursor: pointer;
  height: 26px;
  line-height: 26px;
  border: 1px solid #d8dce5;
  color: #495060;
  background: #fff;
  padding: 0 8px;
  font-size: 14px;
  margin-left: 5px;
  margin-top: 4px;

  //在bread-view-tags中的才会受到影响,其他的不会影响 
  ::v-deep .el-breadcrumb__separator {
    display: none;
  }

  .el-icon-close {
    margin-left: 10px;
  }

  .em {
    font-style: normal;
  }

}

// .bread-view-tags ::after{
//     contain: '';
//     width: 10px;
//     height: 10px;
//     background: red;
//   }









.Breadcrumb {
  padding: 2px 10px;
}

.BreadcrumbMain {
  height: 100%;
  white-space: nowrap;
  position: relative;
  overflow: hidden;
  width: 100%;
}

.app-breadcrumb.el-breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  .no-redirect {
    color: #97a8be;
    cursor: text;
  }
}
</style>