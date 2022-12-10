//个人用户的相关接口
import service from './services'
export const getUserInfo = (token) =>{
  const url = '/users'
  return service.get(url,token);
}
//改变用户的个人信息
export const changeUserInfo = (userinfo) =>{
  const url = '/users'
  return service.put(url,userinfo);
}
//上传用户头像
export const uploadUserPicture = (picture) =>{
  const url =`/oss/policy/user/${picture}`
  return service.get(url)
}
//上传动态图片
export const uploaddynamicPicture = (picture) =>{
  const url =`/oss/policy/dynamic/${picture}`
  return service.get(url)
}

//返回用户的收藏视屏的列表
export const userVideoCollect = (pageNum,userId) =>{
  const url = `videos/collect/${pageNum}-${userId}`
  return service.get(url)
}


//获取其他用户信息
export const getuserMsg = (userId) =>{
  const url = `/users/${userId}`
  return service.get(url)
}


//发送我的动态
export const setDynamics = (data) =>{
  const url = `/dynamics`
  return service.post(url,data)
}

//查询我的动态
export const getDynamics = (id,page) =>{
  const url = `/dynamics/users/${id}/${page}`
  return service.get(url)
}

//删除我的动态
export const deleteDynamics = (id) => {
  const url = `/dynamics/${id}`
  return service.delete(url)
}

//查询所有动态
export const getallDynamics = (page) =>{
  const url = `/dynamics/pages/${page}`
  return service.get(url)
}


//获取用户好友列表的
export const getFriend = () =>{
  const url = `friends`
  return service.get(url)
}  
//获取相互交流的数据
export const getmessage = (userId,firendId) => {
  const url = `/pull/msg?from=${userId}&to=${firendId}`
  return service.post(url)
}

//搜索好友
export const getSearchFriend = (friendName) => {
  const url = `friends/search?nickname=${friendName}`
  return service.get(url)
}
//申请添加好友 
export const addUserFriendAction = (addFriendData) =>{
  const url = `friends`
  return service.post(url,addFriendData)
}
//获取用户所有的相关申请(从左到右依次为申请的情况，谁的申请，分页数)
export const getUserFriendAction = ({userStates,actionStates,pageNum}) =>{
  const url = `friends/examine/${actionStates}-${userStates}-${pageNum}`
  return service.get(url)
}
//同意申请成为好友
export const agreenFriendAction = (actionData) => {
  const url = 'friends'
  return service.put(url,actionData)
}

//获取小红点,即(好友聊天中是否出现小红点，出现就是有人发的消息未查看) 
export const notAccepted = () =>{
  const url = `friends/redSpot`
  return service.get(url)
}


