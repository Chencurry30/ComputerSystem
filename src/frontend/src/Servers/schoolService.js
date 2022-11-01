import Servers from "./Servers";

//获取院校选择列表的请求 
export const getSchoolNavType = () =>{
  const url = '/colleges/filterBox'
  return Servers.get(url);
}
