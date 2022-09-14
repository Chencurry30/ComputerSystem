<<<<<<< HEAD
import Home from "@/views/Home";
import loginView from "@/views/loginView";
import webAboutIndex from '@/views/webAbout/webAboutIndex' //关于我们链接的组件
=======
import Login from '@/views/item'
import Register from '@/views/item'
import Home from "@/views/Home";
import webAboutIndex from '@/views/webAbout/webAboutIndex'   //关于我们链接的组件
>>>>>>> 9653537358bac4cf83bb9dae6f4926530fe41234

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
        path: 'loginView',
        name: 'loginView',
        component: loginView
    },
    {
        path: '/webAboutIndex',
        name: 'webAboutIndex',
        component: webAboutIndex
    }
]



export default routes