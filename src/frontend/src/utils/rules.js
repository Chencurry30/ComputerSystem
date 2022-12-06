//表单验证的各个参数或者方法
/*
 * @author 李国强
 * @date 2022/10/23
 * @Description: 校验数据的公共方法
*/
// 账号{要求2-12位}
let usernameReg = /^(?![0-9]*$)(?![a-zA-Z]*$)[a-zA-Z0-9]{2,12}$/

// 电话{要求11位}
let phoneReg = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/

// 密码{6-12位}
let passwordReg = /^(?![0-9]*$)(?![a-zA-Z]*$)[a-zA-Z0-9]{6,12}$/

//验证年龄
let ageReg = /^120$|^[1-9]$|^(1[0-1]|[1-9])\d$/

//验证邮箱 
let emailReg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/

//验证昵称
let nicknameReg =  /^[\u4e00-\u9fa5]{2,12}$|[a-zA-Z0-9]{2,12}$/

//验证个人留言 
let personalMessageReg = /^[\u4e00-\u9fa5]{1,20}$/


let FormValidate = (function () {
  function FormValidate () {}
  // From表单验证规则  可用于公用的校验部分
  FormValidate.Form = function () {
    return {
      //只用于账号的验证规则
      validateUserName (rule, value, callback) {
        if (value === '') {
          return callback(new Error('请输入账号'))
        }
        if (!usernameReg.test(value)) {
          callback(new Error('账号必须为2-12位(必须包含数字与字母)'))
        } else {
          callback()
        }
      },
      //电话号码的验证
      validatePhone (rule, value, callback) {
        if (value === '') {
          return callback(new Error('请输入手机号码'))
        }
        if (!phoneReg.test(value)) {
          callback(new Error('手机格式不正确'))
        } else {
          callback()
          }
      },
      //用户密码的验证
      validatePassWord(rule,value,callback){
        if(value === ''){
          return callback(new Error('请输入密码'))
        }
        if(!passwordReg.test(value)){
          callback(new Error('密码为6-12位(必须包含数字和字母)'))
        }else{
          callback()
        }
      },
      //只用于年龄的验证规则
      validataAge (rule, value, callback) {
        if (value !== '') {
          if (!ageReg.test(value)) {
            callback(new Error('年龄的范围为1-120'))
          } else {
            callback()
          }
        } else {
          callback('请输入年龄')
        }
      },
      //邮箱的验证规则
      validateEmail (rule, value, callback) {
        if (value !== '') {
          if (!emailReg.test(value)) {
            console.log(123);
            callback(new Error('邮箱格式不正确'))
          } else {
            callback()
          }
        } else {
          callback(new Error('请输入邮箱'))
        }
      },
      //昵称的验证
      validateNickName(rule,value,callback){
        if (value !== '') {
          if ( !nicknameReg.test(value)) {
            callback(new Error('格式不对(2-12位(数字,字母,中文))'))
          } else {
            callback()
          }
        } else {
          callback(new Error('请输入昵称'))
        }
      },
      //个人留言的验证
      validatePersonalMessage(rule,value,callback){
        if (value !== '') {
          if ( !personalMessageReg.test(value)) {
            callback(new Error('留言格式不对(2~20)只能是中文'))
          } else {
            callback()
          }
        } else {
          callback(new Error('请输入个人留言'))
        }
      },

    }
  }
  return FormValidate
}())

exports.FormValidate = FormValidate