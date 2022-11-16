import service from "./services";

export const getQuestionNav = () =>{
  const url = `/question/filterBox`
  return service.get(url)
}

export const getQuestionDataList = ({typeId,difficultId,classifyId,sourceId,yearId,pageNum}) =>{
  const url = `/question/pages/${typeId}-${difficultId}-${classifyId}-${sourceId}-${yearId}-${pageNum}`
  return service.get(url)
}
