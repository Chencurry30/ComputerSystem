import videoPage from '@/views/videoView/videoPage';

export default [
  {
    path: '/videoPage',
    name: 'videoPage',
    component: videoPage,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTopFotter: true
    }
  },

]
