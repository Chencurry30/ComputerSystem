//表单验证的各个参数或者方法
/*
 * @author 李国强
 * @date 2022/10/23
 * @Description: 校验数据的公共方法
*/
// 账号{要求2-12位}
let usernameReg = /^(?![0-9]*$)(?![a-zA-Z]*$)[a-zA-Z0-9]{2,20}$/

// 电话{要求11位}
let phoneReg = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/

// 密码{6-12位}
let passwordReg = /^(?![0-9]*$)(?![a-zA-Z]*$)[a-zA-Z0-9]{6,12}$/

//验证码(要求{4位})

let codeReg = /^(?![0-9]*$){4,4}/










// 必须为数字
let numberReg = /^\d+$|^\d+[.]?\d+$/


// 联系人
let contactsReg = /^[\u0391-\uFFE5A-Za-z]+$/

let regId = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/

let emailReg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/

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
      //用于验证验证码
      validateCode(rule,value,callback){
        if(value === ''){
          return callback(new Error('验证码不能为空'))
        }
        if(!codeReg.test(value)){
          return callback(new Error('验证码位数不对'))          
        }else{
          callback()
        }
      }, 












      //只用于年龄的验证规则
      validateNumber (rule, value, callback) {
        if (value !== '') {
          if (!numberReg.test(value)) {
            callback(new Error('年龄只能是纯数字'))
          } else {
            callback()
          }
        } else {
          callback()
        }
      },

      // 密码的验证
      validatePsdReg (rule, value, callback) {
        if (!value) {
          return callback(new Error('请输入密码'))
        }
        if (!passwordReg.test(value)) {
          callback(new Error('请输入6-20位英文字母、数字或者符号（除空格），且字母、数字和标点符号至少包含两种'))
        } else {
          callback()
        }
      },

      // 联系人
      validateContacts (rule, value, callback) {
        if (!value) {
          return callback(new Error('请输入联系人'))
        }
        if (!contactsReg.test(value)) {
          callback(new Error('联系人不可输入特殊字符'))
        } else {
          callback()
        }
      },

      // 邮箱的验证规则
      validateEmail (rule, value, callback) {
        if (value !== '') {
          if (!emailReg.test(value)) {
            callback(new Error('邮箱格式不正确'))
          } else {
            callback()
          }
        } else {
          callback()
        }
      },


      // 身份证的验证规则
      ID (rule, value, callback) {
        if (!value) {
          return callback(new Error('身份证不能为空'))
        }
        if (!regId.test(value)) {
          callback(new Error('请输入正确的二代身份证号码'))
        } else {
          callback()
        }
      }
    }
  }
  return FormValidate
}())

exports.FormValidate = FormValidate