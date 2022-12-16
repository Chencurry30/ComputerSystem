import service from './services'

//获取老师列表 
export const getTeachers = () => {
  const url = `/teachers`
  return service.get(url)
}


//获取个人老师的相关信息
export const getTeacherInfo = (teacherId) => {
  const url = `/teachers/${teacherId}`
  return service.get(url)
} 


//发送个人对老师的评价
export const evaluationTeacher = (evaluationData) =>{
  const url = `/messages`
  return service.post(url,evaluationData)
}


//获取老师的评论信息
export const getTeacherRemark = (teacherId) =>{
  const url = `/messages/teacherId/${teacherId}`
  return service.get(url)
}