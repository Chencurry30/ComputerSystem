export default [
  {
    path: '/videoPage:videoId?',
    name: 'videoPage',
    component: () =>import('@/views/videoView/videoPage') ,
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/videoSelect',
    name: 'videoSelect',
    component: () => import('@/views/videoView/videoSelect') ,
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },


]
