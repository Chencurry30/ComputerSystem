import videoPage from '@/views/videoView/videoPage';
import videoSelect from '@/views/videoView/videoSelect';
export default [
  {
    path: '/videoPage',
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
