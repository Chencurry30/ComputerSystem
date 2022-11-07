import Servers from "./Servers";

//获取院校选择列表的请求 
export const getSchoolNavType = () =>{
  const url = '/colleges/filterBox'
  return Servers.get(url);
}
//获取院校的数据列表 
export const getschoolList = ({first,second,thild,pageNum}) =>{
  const url = `/colleges/pages/${first}-${second}-${thild}-${pageNum}?collegeName=`
  return Servers.get(url)
}