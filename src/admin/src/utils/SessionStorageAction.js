//封装对session缓存的相关操作 
const SessionStorageAction = {
  clearSessionStorage(key){
    sessionStorage.clear(key)
  },
  saveSessionStorage(key,value){
    sessionStorage.setItem(key,value)
  },
  getSessionStorage(key){
    return sessionStorage.getItem(key)
  }
} 
export default SessionStorageAction