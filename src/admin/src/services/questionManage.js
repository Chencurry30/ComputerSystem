//题目管理的相关接口
import service from './service'

//添加题目的相关接口 
export const addQuestion = (QuestionData) =>{
  const url = 'admin/question'
  return service.post(url,QuestionData)
}

//上传题目图片的相关内容 
export const uploadQuestionPicture = ({fileName,location}) =>{
  const url = `oss/policy/question/${fileName}-${location}`
  return service.get(url)
}


//获取题目列表
export const getQuestionList = ({classfyId,coursId,pageNum}) =>{
  const url = `admin/question/pages/${classfyId}-${coursId}-${pageNum}?questionName= `
  return service.get(url)
}

//删除对应的题目
export const deleteQuestionItem = (questionId) =>{
  const url = `admin/question/${questionId}`
  return service.delete(url)
}

//编辑题目
export const editQuestionItem = (questionData) =>{
  const url = `admin/question`
  return service.put(url,questionData)
}

