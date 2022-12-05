const schoolSelect = () => import('@/views/schoolView/schoolSelect')
const schoolPage = () => import('@/views/schoolView/schoolPage')

export default [
    {
        path:'/schoolSelect',
        name:'schoolSelect',
        component:schoolSelect,
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
        component:schoolPage,
        meta: {                          
            showTop: false,
            showFotter:false,
            //跳转到404页面后是出现头部
            showNotFound:true,
          },  
    }
]