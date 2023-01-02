import Service from "./service";

//获取视屏列表 
export const getVideoList = (pageNum) =>{
  const url = `admin/videos/pages/0-${pageNum}`
  return Service.get(url)
}

//获取审核的视屏列表
export const getExamineList = ({status,page}) =>{
  const url = `admin/videos/examine/${status}-${page}`
  return Service.get(url)
} 

//审核视屏是否通过 
export const auditVideoAction = (auditData) =>{
  const url = '/admin/videos/examine'
  return Service.put(url,auditData)
}

//删除视屏
export const deleteVideoAction = (videoId) =>{
  const url = `admin/videos/${videoId}`
  return Service.delete(url)
}