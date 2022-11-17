import service from "./services";

//获取院校选择列表的请求 
export const getSchoolNavType = () =>{
  const url = '/colleges/filterBox'
  return service.get(url);
}
//获取院校的数据列表 
export const getschoolList = ({first,second,thild,pageNum}) =>{
  const url = `/colleges/pages/${first}-${second}-${thild}-${pageNum}?collegeName=`
  return service.get(url)
}

//获取具体院校的相关信息
export const getschoolInfo = (collegeId) =>{
  const url = `/colleges/${collegeId}`
  return service.get(url)
} 