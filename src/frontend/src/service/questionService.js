
import service from "./services";

export const getQuestionNav = () =>{
  const url = `/question/filterBox`
  return service.get(url)
}

export const getQuestionDataList = ({typeId,difficultId,classifyId,sourceId,yearId,pageNum}) =>{
  const url = `/question/pages/${typeId}-${difficultId}-${classifyId}-${sourceId}-${yearId}-${pageNum}`
  return service.get(url)
}

//随机组卷的接口
export const getVolume = data =>{
  const url = `/question/paper`
  return service.post(url,data)
}

//获取具体题目的接口
export const getQuestion = (questionId) =>{
  const url =`question/${questionId}`
  return service.get(url)
}

export const uploadQuestionPicture = ({fileName,location}) =>{
  const url = `oss/policy/question/${fileName}-${location}`
  return service.get(url)
}

export const addQuestion = (QuestionData) =>{
  const url = 'admin/question'
  return service.post(url,QuestionData)
}

//添加题目的相关接口
