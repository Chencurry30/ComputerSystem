export default [
  {
    path: '/teacherSelect',
    name: 'teacherSelect',
    component:  () => import('@/views/teacherView/teacherSelect'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部                       
      showTop: true,
      showFotter:true
      },
  },
  {
    path: '/teacherPerson/:teacherId?',
    name: 'teacherPerson',
    component: () => import('@/views/teacherView/teacherPerson') ,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  }
]
