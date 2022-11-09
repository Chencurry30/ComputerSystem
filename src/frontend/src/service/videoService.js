import service from "./services";

//获取视屏选择列表的请求 
export const getVideoNavType = () =>{
  const url = '/videos/filterBox'
  return service.get(url);
}

//获取视屏的具体页面
export const getVideoList = ({first,second,pageNum,thild}) =>{
  const url = `/videos/pages/${first}-${second}-${thild}-${pageNum}?videoName=`
  return service.get(url)
}

//获取视屏的分页信息
export const getVideoPageData = (pageNo) =>{
  const url = `/videos/${pageNo}`
  return service.get(url)
}

//获取具体的视屏的相关信息
export const getVideoInfo = (videoId) =>{
  const url = `/videos/${videoId}`
  return service.get(url)
} 

//获取相应的评论资源

export const getVideoRemark = (videoId) =>{
  const url = `/comments/tree/${videoId}`
  return service.get(url)
} 

