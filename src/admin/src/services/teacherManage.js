//老师管理的相关接口
import servers from "./service";

//获取所有的申请 
export const getExamine = () =>{
  const url = `examine`
  return servers.get(url)
}

//同意申请 
export const agreeTeacherApply = (examineId) =>{
  const url =`/examine/agree/${examineId}`
  return servers.put(url)
}

//拒接申请
export const disagreeTeacherApply = (examineId,disagreeData) =>{
  const url = `examine/disagree/${examineId}/${disagreeData}`
  return servers.put(url)
}