import Servers from "./Servers";

//获取视屏选择列表的请求 
export const getVideoNavType = () =>{
  const url = '/videos/filterBox'
  return Servers.get(url);
}

//获取视屏的具体页面
export const getVideoList = ({first,second,pageNum,thild}) =>{
  const url = `/videos/pages/${first}-${second}-${thild}-${pageNum}?videoName=`
  return Servers.get(url)
}

//获取视屏的分页信息
export const getVideoPageData = (pageNo) =>{
  const url = `/videos/${pageNo}`
  return Servers.get(url)
}



