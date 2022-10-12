import teacherSelect from '@/views/teacherView/teacherSelect';

import teacherPerson from '@/views/teacherView/teacherPerson';

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
