import notFound from '../views/baseView/notFound.vue'
//登录组件
import loginView from '../views/baseView/loginView.vue';
//首页
import homeView from '../views/baseView/homeView'
//包含首页的盒子 
import indexBox from '../views/Index';
//个人中心
import person from '../views/Setting/person.vue'
 const staticRoute = [
    {
        path:"/",
        redirect:loginView
    },
    //这个路由是登录路由 
    {
        path: '/loginView',
        name: 'loginView',
        component: loginView
    },
    //404页面
    {
        path:"/404",
        name:"notFound",
        component:notFound
    },
    {
        path: '/indexBox',
        name: 'indexBox',
        component: indexBox,
        //路由元信息
        meta:{
          isLogin:true
        },
        children:[
          //首页
          {
            path: '/homeView',
            name: 'homeView',
            component: homeView
          },
          //个人中心
          {
            path: '/person',
            name: 'person',
            component: person
          },         
    ],
    redirect:'homeView',
  },
    
]

export default staticRoute

