import Login from '@/view/item'
import Register from '@/view/item'
import Home from "@/view/Home";
import webAboutIndex from '@/view/webAbout/webAboutIndex'   //关于我们链接的组件

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
        path: '/Login',
        name: 'Login',
        component: Login
    },
    {
        path: '/Register',
        name: 'Register',
        component: Register
    },
    {
        path:'/webAboutIndex',
        name:'webAboutIndex',
        component:webAboutIndex
    }
]



export default routes