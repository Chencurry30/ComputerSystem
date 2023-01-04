//用于权限的模态框的数据校验

//验证是否为中文 
let judgeChinese = /^[\u4e00-\u9fa5]{1,20}$/

let permissionValidate = (function () {
  function FormValidate() { }
  FormValidate.Form = function () {
    return {
      judgeDataIsEnglist(rule, value, callback){
        if(value === ''){
          callback(new Error('输入的数据不能为空'))
        }else if(judgeChinese.test(value)){
          callback(new Error('路径不能携带中文'))
        }else{
          callback()
        }
      },
      judgeDataIsChinese(rule, value, callback){
        if(value === ''){
          callback(new Error('输入的数据不能为空'))
        }else if(!judgeChinese.test(value)){
          callback(new Error('名称只能是中文'))
        }else{
          callback()
        }
      }
    }
  }
  return FormValidate
}())

exports.FormValidate = permissionValidate