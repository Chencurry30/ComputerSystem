import Login from '@/view/item'
import Register from '@/view/item'
import Home from "@/view/Home";

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
    }
]



export default routes