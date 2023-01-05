//公共的方法,用来隐藏按钮
import Vue from 'vue'

Vue.directive('has', {
  //inserted：被绑定元素插入父节点时调用
  inserted: function (el, binding) {
    if (!permissionJudge(binding.value)) {
      el.parentNode.removeChild(el)
    }
    function permissionJudge(value) {
      const list = JSON.parse(sessionStorage.getItem('menuRight'))  // 权限按钮的List
      for (const item of list) {
        if (item.perms === value) {
          return true
        }
      }
      return false
    }
  }
})
