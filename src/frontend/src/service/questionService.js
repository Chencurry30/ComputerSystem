
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
export const setVolume = data =>{
  const url = `/question/paper`
  return service.post(url,data)
}