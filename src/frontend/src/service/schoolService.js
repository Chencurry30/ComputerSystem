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

//获取专业的选择列表的相关信息
export const getSchoolMajorNavType = () =>{
  //返回的是院校加classfy的列表 
  // const url = `/majors/colleges/1-1`
  //返回的所有的列表 
  // const url = `/majors`
  const url = `/majors/filterBox`
  return service.get(url)
} 

//返回具体专业的相关信息
export const getSchoolMajor = ({collegeId,classfyId}) =>{
  const url = `/majors/colleges/${collegeId}-${classfyId}`
  return service.get(url)
}



