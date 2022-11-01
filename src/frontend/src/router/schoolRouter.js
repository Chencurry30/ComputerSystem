const schoolSelect = () => import('@/views/schoolView/schoolSelect')
const schoolPage = () => import('@/views/schoolView/schoolPage')

export default [
    {
        path:'/schoolSelect',
        name:'schoolSelect',
        component:schoolSelect,
        meta: {                          
            showTop: true,
            showFotter:true
          },
    },
    {
        path:'/schoolPage',
        name:'schoolPage',
        component:schoolPage,
        meta: {                          
            showTop: true,
            showFotter:true
          },  
    }
]