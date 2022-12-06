export default [
    {
        path:'/schoolSelect',
        name:'schoolSelect',
        component:() => import('@/views/schoolView/schoolSelect'),
        meta: {                          
            showTop: true,
            showFotter:true,
            //跳转到404页面后是出现头部
            showNotFound:true,
          },
    },
    {
        path:'/schoolPage/:collegeId?',
        name:'schoolPage',
        component: () => import('@/views/schoolView/schoolPage'),
        meta: {                          
            showTop: false,
            showFotter:false,
            //跳转到404页面后是出现头部
            showNotFound:true,
          },  
    }
]