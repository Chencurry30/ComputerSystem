<!--顶部的面包屑,随时跳转-->
<template>
  <div class="Breadcrumb">
    <el-breadcrumb class="BreadcrumbMain" separator="×">
      <el-breadcrumb-item :to="routerItem.path" class="bread-view-tags" v-for="(routerItem) in breadList"
        :key="routerItem.path" :class="{ active: ActiveRoute === routerItem.path }">
        <em class="routeName">{{ routerItem.name }}</em>
        <i class="el-icon-close"></i>
      </el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
import SessionStorageAction from '../../utils/SessionStorageAction'
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
    //获取面包屑的方法 
    getBreadList(route) {
      if (this.breadList.length === 2) {
        this.breadList = JSON.parse(SessionStorageAction.getSessionStorage('bread'))
      } else {
        let routeItem = { name: route.name, path: route.path }
        this.breadList.push(routeItem)
        this.breadList = this.breadList.filter((item, index, selfArr) => {
          let list = selfArr.map(item => {
            return item.path
          })
          return list.indexOf(item.path) === index
        })
        //保存浏览的面包屑,避免刷新的时候丢失 
        SessionStorageAction.saveSessionStorage('bread', JSON.stringify(this.breadList))
        console.log(this.breadList);
      }
    }
  },
  watch: {
    $route: {
      handler(newvalue) {
        //获取面包屑的List 
        this.getBreadList(newvalue)
      },
      immediate: true
    }
  },
  computed: {
    ActiveRoute() {
      return this.$route.path
    }
  }
}
</script>

<style lang="less" scoped>
.bread-view-tags {
  display: inline-block;
  position: relative;
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

  .routeName {
    margin-left: 10px;
    cursor: pointer;
    font-style: normal;
  }
}

//当前路由的相关提醒 
.active {
  position: relative;
  background-color: #42b983;
  border-color: #42b983;

  .routeName {
    color: #fff;
  }
}

.active ::before {
  display: block;
  position: absolute;
  content: '';
  top: 50%;
  left: 10px;
  width: 8px;
  height: 8px;
  transform: translate(-50%, -50%);
  border-radius: 50%;
  background: #fff;
  z-index: 999;
}





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