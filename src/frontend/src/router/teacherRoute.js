const teacherSelect = () => import('@/views/teacherView/teacherSelect');  //老师的选择页面
const teacherPerson = () => import('@/views/teacherView/teacherPerson')   //老师的个人详情页面

export default [
  {
    path: '/teacherSelect',
    name: 'teacherSelect',
    component: teacherSelect,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部                       
      showTop: true,
      showFotter:true
      },
  },
  {
    path: '/teacherPerson/:teacherId?',
    name: 'teacherPerson',
    component: teacherPerson,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  }
]
