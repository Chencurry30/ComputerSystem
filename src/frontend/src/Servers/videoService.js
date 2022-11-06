import Servers from "./Servers";

//获取视屏选择列表的请求 
export const getVideoNavType = () =>{
  const url = '/videos/filterBox'
  return Servers.get(url);
}

//获取视屏的具体页面
export const getVideoList = ({first,second,thild}) =>{
  // console.log(first,second,thild);
  const url = `/videos/pages/${first}-${second}-${thild}-4?videoName=`
  return Servers.get(url)
}


