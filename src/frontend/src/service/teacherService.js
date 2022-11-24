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