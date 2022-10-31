import Servers from "./Servers";

//获取视屏选择列表的请求 
export const getVideoNavType = () =>{
  const url = '/videos/filterBox'
  return Servers.get(url);
}


