import videoPage from '@/views/videoView/videoPage';
import videoSelect from '@/views/videoView/videoSelect';
export default [
  {
    path: '/videoPage',
    name: 'videoPage',
    component: videoPage,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTopFotter: true
    }
  },
  {
    path: '/videoSelect',
    name: 'videoSelect',
    component: videoSelect,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTopFotter: true
    }
  },


]
