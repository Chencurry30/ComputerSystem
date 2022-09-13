import Login from '@/views/item'
import Register from '@/views/item'
import Home from "@/views/Home";
import webAboutIndex from '@/views/webAbout/webAboutIndex'   //关于我们链接的组件

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