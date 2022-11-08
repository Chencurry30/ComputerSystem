
const videoPage = () =>import('@/views/videoView/videoPage')       //视频的首页
const videoSelect = () => import('@/views/videoView/videoSelect')  //视频选择页面

export default [
  {
    path: '/videoPage:videoId?',
    name: 'videoPage',
    component: videoPage,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },
  {
    path: '/videoSelect',
    name: 'videoSelect',
    component: videoSelect,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },


]
