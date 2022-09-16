import Home from "@/views/Home";
import loginView from "@/views/loginView";
import webAboutIndex from '@/views/webAbout/webAboutIndex' //关于我们链接的组件
const routes = [{
        path: '/',
        redirect: Home,
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home
    },
    {
        path: '/loginView',
        name: 'loginView',
        component: loginView
    },
    {
        path: '/webAboutIndex',
        name: 'webAboutIndex',
        component: webAboutIndex
    },
]



export default routes