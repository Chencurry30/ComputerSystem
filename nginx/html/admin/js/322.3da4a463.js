"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[322],{81321:(e,t,a)=>{a.d(t,{Z:()=>c});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"home"},[a("el-dialog",{attrs:{title:e.title,"append-to-body":"",visible:e.dialogVisible},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",{staticStyle:{margin:"15px 0"}}),a("el-checkbox-group",{model:{value:e.userCheckList,callback:function(t){e.userCheckList=t},expression:"userCheckList"}},e._l(e.roleList,(function(t){return a("el-checkbox",{key:t.roleId,attrs:{label:t.roleId}},[e._v(e._s(t.name))])})),1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){return e.closeDialogVisible()}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.subminRole()}}},[e._v("确 定")])],1)],1)],1)},o=[],s=(a(89554),a(41539),a(54747),a(26833),a(48729));const i={name:"GiveRole",data:function(){return{form:{},dialogVisible:!1,activeName:"first",title:"选择角色",userCheckList:[],roleList:[]}},methods:{getAllRole:function(){var e=this;(0,s.JV)().then((function(t){console.log(t),e.roleList=t.data.data}))},getUserRole:function(e){var t=this;this.userCheckList=[],(0,s.xZ)(e.userId).then((function(e){var a=e.data.data;a.forEach((function(e){t.userCheckList[t.userCheckList.length++]=e.roleId})),t.userCheckList=Object.values(t.userCheckList)}))},showGiveRoles:function(e){this.userId=e.userId,this.getAllRole(),this.getUserRole(e),this.dialogVisible=!0},closeDialogVisible:function(){this.dialogVisible=!1},subminRole:function(){var e=this,t={};t.userId=this.userId,t.roleList=[],this.userCheckList.forEach((function(e){var a={roleId:e};t.roleList.push(a)})),(0,s.e1)(t).then((function(t){console.log(t),200===t.data.code&&(e.dialogVisible=!1,e.$parent.getFollowdiaryList())}))}}},r=i;var n=a(43736),u=(0,n.Z)(r,l,o,!1,null,"4362e3e4",null);const c=u.exports},26322:(e,t,a)=>{a.r(t),a.d(t,{default:()=>L});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"home"},[a("div",{staticClass:"nav-select"},[a("div",{staticClass:"nav-left"},[a("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.addSubBtn}},[e._v(" 新 增 ")])],1),a("div",{staticClass:"nav-right"},[a("div",{staticClass:"nav-left-second"},[a("el-select",{attrs:{placeholder:"请选择筛选科目"},model:{value:e.classfyId,callback:function(t){e.classfyId=t},expression:"classfyId"}},[a("el-option",{attrs:{label:"全部",value:"0"}},[e._v("全部")]),a("el-option",{attrs:{label:"数学",value:"2"}},[e._v("数学")]),a("el-option",{attrs:{label:"政治",value:"3"}},[e._v("政治")]),a("el-option",{attrs:{label:"数据结构",value:"4"}},[e._v("数据结构")]),a("el-option",{attrs:{label:"计组",value:"5"}},[e._v("计组")]),a("el-option",{attrs:{label:"计网",value:"6"}},[e._v("计网")])],1)],1),a("div",{staticClass:"nav-left-second"},[a("el-select",{attrs:{placeholder:"请选择筛选题目来源"},model:{value:e.coursId,callback:function(t){e.coursId=t},expression:"coursId"}},[a("el-option",{attrs:{label:"全部",value:"0"}},[e._v("全部")]),a("el-option",{attrs:{label:"考研真题",value:"1"}},[e._v("考研真题")]),a("el-option",{attrs:{label:"408",value:"2"}},[e._v("408")]),a("el-option",{attrs:{label:"自主出题",value:"3"}},[e._v("自主出题")])],1)],1),a("el-button",{staticClass:"searchData",attrs:{type:"primary"},on:{click:e.getSearchBtn}},[e._v("查 询")])],1)]),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"questionId",label:"ID",width:"100"}}),a("el-table-column",{attrs:{prop:"sites",label:"题目考点"}}),a("el-table-column",{attrs:{prop:"classifyName",label:"题目类型"}}),a("el-table-column",{attrs:{prop:"difficult",label:"题目难度"}}),a("el-table-column",{attrs:{prop:"source",label:"题目来源"}}),a("el-table-column",{attrs:{prop:"year",label:"题目年份"}}),a("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"success",icon:"el-icon-check",circle:"",size:"mini"},on:{click:function(a){return e.lookQuestionRow(t.row)}}}),a("el-button",{attrs:{type:"primary",icon:"el-icon-edit",circle:"",size:"mini"},on:{click:function(a){return e.editRow(t.row)}}}),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete",circle:"",size:"mini"},on:{click:function(a){return e.deleteQuestionRow(t.row)}}})]}}])})],1),a("el-pagination",{staticClass:"page",attrs:{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize},on:{"current-change":e.handleCurrentChange}}),a("QuestionPopup",{ref:"QuestionPopup"}),a("showQuestionMorePopup",{ref:"showQuestionMorePopup"})],1)},o=[],s=a(81321),i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"questionDialog"},[a("el-dialog",{attrs:{title:"添加题目信息",visible:e.dialogVisible,width:"80%",center:""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",{staticClass:"submitQuestionBox"},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px"}},[a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"题目类别",prop:"questionType"}},[a("el-radio-group",{model:{value:e.ruleForm.questionType,callback:function(t){e.$set(e.ruleForm,"questionType",t)},expression:"ruleForm.questionType"}},[a("el-radio",{attrs:{label:"1"}},[e._v("单选题")]),a("el-radio",{attrs:{label:"2"}},[e._v("多选题")]),a("el-radio",{attrs:{label:"3"}},[e._v("填空题")]),a("el-radio",{attrs:{label:"4"}},[e._v("解答题")])],1)],1),a("el-form-item",{attrs:{label:"题目学科",prop:"classifyId"}},[a("el-radio-group",{model:{value:e.ruleForm.classifyId,callback:function(t){e.$set(e.ruleForm,"classifyId",t)},expression:"ruleForm.classifyId"}},[a("el-radio",{attrs:{label:"2"}},[e._v("数学")]),a("el-radio",{attrs:{label:"3"}},[e._v("政治")]),a("el-radio",{attrs:{label:"4"}},[e._v("计网")]),a("el-radio",{attrs:{label:"5"}},[e._v("数据结构")]),a("el-radio",{attrs:{label:"6"}},[e._v("计组")])],1)],1)],1),a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"题干内容",prop:"questionTitle"}},[a("el-input",{model:{value:e.ruleForm.questionTitle,callback:function(t){e.$set(e.ruleForm,"questionTitle",t)},expression:"ruleForm.questionTitle"}})],1),a("el-form-item",{attrs:{label:"题目考点",prop:"sites"}},[a("el-input",{model:{value:e.ruleForm.sites,callback:function(t){e.$set(e.ruleForm,"sites",t)},expression:"ruleForm.sites"}})],1)],1),a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"题目答案",prop:"answer"}},[a("el-input",{model:{value:e.ruleForm.answer,callback:function(t){e.$set(e.ruleForm,"answer",t)},expression:"ruleForm.answer"}})],1),a("el-form-item",{attrs:{label:"答案图片",prop:"answerImage"}},[a("div",{staticClass:"form-item"},[a("el-input",{model:{value:e.ruleForm.answerImage,callback:function(t){e.$set(e.ruleForm,"answerImage",t)},expression:"ruleForm.answerImage"}}),a("el-upload")],1)])],1),a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"携带的图片",prop:"enclosureImage"}},[a("div",{staticClass:"form-item"},[a("el-input",{model:{value:e.ruleForm.enclosureImage,callback:function(t){e.$set(e.ruleForm,"enclosureImage",t)},expression:"ruleForm.enclosureImage"}}),a("el-upload")],1)]),a("el-form-item",{attrs:{label:"题干图片",prop:"titleImage"}},[a("div",{staticClass:"form-item"},[a("el-input",{model:{value:e.ruleForm.titleImage,callback:function(t){e.$set(e.ruleForm,"titleImage",t)},expression:"ruleForm.titleImage"}}),a("el-upload")],1)])],1),a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"题目解析",prop:"solution"}},[a("el-input",{model:{value:e.ruleForm.solution,callback:function(t){e.$set(e.ruleForm,"solution",t)},expression:"ruleForm.solution"}})],1),a("el-form-item",{attrs:{label:"解析图片",prop:"solutionImage"}},[a("div",{staticClass:"form-item"},[a("el-input",{model:{value:e.ruleForm.solutionImage,callback:function(t){e.$set(e.ruleForm,"solutionImage",t)},expression:"ruleForm.solutionImage"}}),a("el-upload")],1)])],1),a("div",{staticClass:"item"},[a("el-form-item",{attrs:{label:"题目难度",prop:"difficult"}},[a("el-select",{attrs:{placeholder:"请选择题目难度"},model:{value:e.ruleForm.difficult,callback:function(t){e.$set(e.ruleForm,"difficult",t)},expression:"ruleForm.difficult"}},[a("el-option",{attrs:{label:"0.1",value:"0.1"}}),a("el-option",{attrs:{label:"0.2",value:"0.2"}}),a("el-option",{attrs:{label:"0.3",value:"0.3"}}),a("el-option",{attrs:{label:"0.4",value:"0.4"}}),a("el-option",{attrs:{label:"0.5",value:"0.5"}}),a("el-option",{attrs:{label:"0.6",value:"0.6"}}),a("el-option",{attrs:{label:"0.7",value:"0.7"}}),a("el-option",{attrs:{label:"0.8",value:"0.8"}}),a("el-option",{attrs:{label:"0.9",value:"0.9"}})],1)],1),a("el-form-item",{attrs:{label:"题目来源",prop:"source"}},[a("el-select",{attrs:{placeholder:"请选择题目年份"},model:{value:e.ruleForm.source,callback:function(t){e.$set(e.ruleForm,"source",t)},expression:"ruleForm.source"}},[a("el-option",{attrs:{label:"考研真题",value:"考研真题"}}),a("el-option",{attrs:{label:"408",value:"408"}}),a("el-option",{attrs:{label:"自主出题",value:"自主出题"}})],1)],1),a("el-form-item",{attrs:{label:"题目年份",prop:"year"}},[a("el-select",{attrs:{placeholder:"请选择题目年份"},model:{value:e.ruleForm.year,callback:function(t){e.$set(e.ruleForm,"year",t)},expression:"ruleForm.year"}},[a("el-option",{attrs:{label:"2022",value:"2022"}}),a("el-option",{attrs:{label:"2021",value:"2021"}}),a("el-option",{attrs:{label:"2020",value:"2020"}}),a("el-option",{attrs:{label:"2019",value:"2019"}}),a("el-option",{attrs:{label:"2018",value:"2018"}})],1)],1)],1),a("div",{staticClass:"optionSelect"},e._l(e.ruleForm.questionChoiceList,(function(t,l){return a("el-form-item",{key:l,attrs:{label:l+1+":选项内容  "+t.choiceName,prop:"questionChoiceList",dataIndex:l}},[a("el-input",{attrs:{placeholder:"请上传选项对应的内容(可以上传图片代替则填无)"},model:{value:t.choiceTitle,callback:function(a){e.$set(t,"choiceTitle",a)},expression:"item.choiceTitle"}}),a("div",{staticClass:"form-item"},[a("el-input",{attrs:{placeholder:"请上传选项对应的图片(若无则不填)"},model:{value:t.titleImage,callback:function(a){e.$set(t,"titleImage",a)},expression:"item.titleImage"}}),a("el-upload")],1)],1)})),1),a("el-form-item",{staticClass:"formBottom"},[a("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("关闭弹窗")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("立即创建")])],1)],1)],1)])],1)},r=[],n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-upload",{staticClass:"upload-demo",attrs:{action:e.objectData.host,"before-upload":e.getPolicy,data:e.objectData,"show-file-list":!1,"list-type":"picture"}},[a("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")])],1)},u=[];a(68309),a(41539);const c={data:function(){return{objectData:{OSSAccessKeyId:"",policy:"",Signature:"",key:"",host:"",dir:""}}},methods:{getPolicy:function(e){var t=this,a=this.returnImgLocation,l=e.name;return console.log(a),console.log(this.$parent.label),new Promise((function(e,o){uploadQuestionPicture({fileName:l,location:a}).then((function(a){if(console.log(a),t.objectData.OSSAccessKeyId=a.data.data.accessid,t.objectData.policy=a.data.data.policy,t.objectData.Signature=a.data.data.signature,t.objectData.dir=a.data.data.dir,t.objectData.host=a.data.data.host,t.objectData.key=a.data.data.key,"answerImage"===t.$parent.prop)console.log(t.$parent.$parent.$parent),t.$parent.$parent.$parent.ruleForm.answerImage=a.data.data.key;else if("enclosureImage"===t.$parent.prop)t.$parent.$parent.$parent.ruleForm.enclosureImage=a.data.data.key;else if("solutionImage"===t.$parent.prop)t.$parent.$parent.$parent.ruleForm.solutionImage=a.data.data.key;else if("titleImage"===t.$parent.prop)t.$parent.$parent.$parent.ruleForm.titleImage=a.data.data.key;else{var l=t.$parent.label.substring(0,1);console.log(t.$parent.$parent.$parent.ruleForm.questionChoiceList[l-1]),t.$parent.$parent.$parent.ruleForm.questionChoiceList[l-1].titleImage=a.data.data.key}console.log(t.objectData),e(!0)}))["catch"]((function(e){console.log(e),o(!1)}))}))}},computed:{returnImgLocation:function(){return"answerImage"===this.$parent.prop?"answer":"enclosureImage"===this.$parent.prop?"enclosure":"solutionImage"===this.$parent.prop?"solution":"titleImage"===this.$parent.prop?"title":"options"}}},d=c;var m=a(43736),p=(0,m.Z)(d,n,u,!1,null,"304764c3",null);const g=p.exports;a(92222);var f=a(44498),v=function(e){var t="admin/question";return f.Z.post(t,e)},b=function(e){var t=e.classfyId,a=e.coursId,l=e.pageNum,o="admin/question/pages/".concat(t,"-").concat(a,"-").concat(l,"?questionName= ");return f.Z.get(o)},h=function(e){var t="admin/question/".concat(e);return f.Z["delete"](t)};const I={name:"questionPopup",data:function(){return{ruleForm:{questionTitle:"",titleImage:"",enclosureImage:"",answer:"",answerImage:"",questionType:"",solution:"",solutionImage:"",sites:"",classifyId:"",difficult:"",source:"",year:"",questionChoiceList:[{choiceName:"A",choiceTitle:"",titleImage:"",choiceId:1,questionId:1},{choiceName:"B",choiceTitle:"",titleImage:"",choiceId:2,questionId:2},{choiceName:"C",choiceTitle:"",titleImage:"",choiceId:3,questionId:3},{choiceName:"D",choiceTitle:"",titleImage:"",choiceId:4,questionId:4}]},rules:{questionTitle:[{required:!0,message:"请输入题目的内容",trigger:"blur"}],classifyId:[{required:!0,message:"请选择题目学科",trigger:"change"}],questionType:[{required:!0,message:"请选择题目类别",trigger:"change"}],difficult:[{required:!0,message:"请选择题目难度",trigger:"change"}],year:[{required:!0,message:"请选择题目年份",trigger:"change"}],source:[{required:!0,message:"请选择题目来源",trigger:"change"}],sites:[{required:!0,message:"请输入题目考点",trigger:"blur"}],answer:[{required:!0,message:"请输入题目答案",trigger:"blur"}],solution:[{required:!0,message:"请输入题目的解析",trigger:"blur"}]},dialogVisible:!1}},components:{ElUpload:g},methods:{submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return t.$message({message:"添加失败",type:"error"}),!1;v(t.ruleForm).then((function(e){console.log(e),200===e.data.code&&(t.$message.success("添加成功"),t.dialogVisible=!1)}))}))},resetForm:function(e){this.$refs[e].resetFields()},showDialogVisible:function(){this.dialogVisible=!0,console.log(this.dialogVisible)}}},y=I;var _=(0,m.Z)(y,i,r,!1,null,"e6b112c2",null);const C=_.exports;var k=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"questionDialog"},[a("el-dialog",{attrs:{title:"题目详情",visible:e.dialogVisible,width:"60%",center:""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",{staticClass:"titleConnect"},[a("div",{staticClass:"questionTitle"},[a("div",{staticClass:"titleHeader"},[a("span",[e._v("("+e._s(e.questioHead)+")    ")]),"无"===e.QuestionData.questionTitle?a("span",[e._v("题目如下图所示")]):a("span",[e._v(e._s(e.QuestionData.questionTitle))])]),""!==e.QuestionData.titleImage?a("div",{staticClass:"titleImg"},[a("img",{attrs:{src:[e.publicUrl+e.QuestionData.titleImage],alt:""}})]):e._e()]),a("div",{staticClass:"questionSelect"},e._l(e.QuestionData.questionChoiceList,(function(t){return a("div",{key:t.choiceId,staticClass:"selectItem"},["无"!==t.choiceTitle?a("span",[e._v(" "+e._s(t.choiceName)+". "+e._s(t.choiceTitle)+" ")]):a("span",{staticClass:"selectOption"},[e._v(" "+e._s(t.choiceName)+".    "),""!==t?a("div",{staticClass:"titleImg"},[a("img",{attrs:{src:[e.publicUrl+t.titleImage],alt:""}})]):e._e()])])})),0),a("div",{staticClass:"questionSites"},[a("em",[e._v("[ 考点 ]")]),a("div",[e._v(e._s(e.QuestionData.sites))])]),a("div",{staticClass:"questionAnswer"},[a("em",[e._v("[ 答案 ]")]),"无"===e.QuestionData.answer?a("span"):a("span",[e._v(e._s(e.QuestionData.answer))]),""!==e.QuestionData.answerImage?a("div",{staticClass:"titleImg"},[a("img",{attrs:{src:[e.publicUrl+e.QuestionData.answerImage],alt:""}})]):e._e()]),a("div",{staticClass:"questionSolution"},[a("div",{staticClass:"solutionHeader"},[a("em",[e._v("[ 解答 ]")]),"无"===e.QuestionData.solution?a("span",[e._v("解析如下图所示")]):a("span",[e._v(e._s(e.QuestionData.solution))])]),""!==e.QuestionData.solutionImage?a("div",{staticClass:"solutionImg"},[a("img",{attrs:{src:[e.publicUrl+e.QuestionData.solutionImage],alt:"该题目解析的图片"}})]):e._e()])]),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)])],1)},F=[],$=a(94835);const q={name:"showQuestionMorePopup",data:function(){return{QuestionData:{},dialogVisible:!1}},methods:{showQuestionMore:function(e){console.log(),this.QuestionData=e,this.dialogVisible=!0}},computed:{questioHead:function(){return 1===this.QuestionData.questionType?"单选题":2===this.QuestionData.questionType?"多选题":3===this.QuestionData.questionType?"填空题":"解答题"},publicUrl:function(){return(0,$.Y)()}}},w=q;var D=(0,m.Z)(w,k,F,!1,null,"7a4f8859",null);const Q=D.exports,x={name:"questionManage",data:function(){return{searchForm:{key:""},tableData:[],total:0,page:1,pageSize:0,classfyId:"",coursId:""}},components:{GiveRole:s.Z,QuestionPopup:C,ShowQuestionMorePopup:Q},mounted:function(){this.getQuestionData({classfyId:0,coursId:0,pageNum:1})},methods:{getQuestionData:function(e){var t=this,a=e.classfyId,l=e.coursId,o=e.pageNum;b({classfyId:a,coursId:l,pageNum:o}).then((function(e){console.log(e),t.tableData=e.data.data.list,t.total=e.data.data.total,t.pageSize=e.data.data.pageSize}))},handleCurrentChange:function(e){this.page=e,this.getQuestionData({pageNum:this.page})},lookQuestionRow:function(e){this.$refs.showQuestionMorePopup.showQuestionMore(e),console.log(e)},deleteQuestionRow:function(e){var t=this;console.log(e),h(e.questionId).then((function(e){200===e.data.code&&(t.$message.success("删除成功"),t.page=1,t.getQuestionData({classfyId:0,coursId:0,pageNum:1}))}))},getSearchBtn:function(){var e=""===this.classfyId?0:this.classfyId,t=""===this.coursId?0:this.coursId;console.log(e,t),this.getQuestionData({classfyId:e,coursId:t,pageNum:this.page})},addSubBtn:function(){console.log(this.$refs),this.$refs.QuestionPopup.showDialogVisible()}}},T=x;var Z=(0,m.Z)(T,l,o,!1,null,"1cda8e48",null);const L=Z.exports},48729:(e,t,a)=>{a.d(t,{DZ:()=>m,EJ:()=>g,Fe:()=>u,IM:()=>r,JV:()=>o,W1:()=>f,Xu:()=>c,Y2:()=>n,_d:()=>s,cn:()=>p,e1:()=>d,pR:()=>i,q0:()=>v,xZ:()=>b});var l=a(44498),o=function(){var e="/admin/roles";return l.Z.get(e)},s=function(e){var t="/admin/roles";return l.Z.post(t,e)},i=function(e){var t="/admin/roles/menu/".concat(e);return l.Z.get(t)},r=function(){var e="/admin/menus/tree";return l.Z.get(e)},n=function(e){var t="/admin/roles/menu";return l.Z.put(t,e)},u=function(e){var t="/admin/roles/".concat(e);return l.Z["delete"](t)},c=function(e){var t="/admin/users/pages/".concat(e);return l.Z.get(t)},d=function(e){var t="/admin/users/role";return l.Z.put(t,e)},m=function(e){var t="/admin/users/".concat(e);return l.Z["delete"](t)},p=function(e){var t="/admin/users";return l.Z.post(t,e)},g=function(e){var t="/admin/logs/pages/".concat(e);return l.Z.get(t)},f=function(e){var t="/admin/logs/".concat(e);return l.Z["delete"](t)},v=function(e){var t="/admin/logs";return l.Z.post(t,e)},b=function(e){var t="/admin/users/role/".concat(e);return l.Z.get(t)}},94835:(e,t,a)=>{a.d(t,{Y:()=>l});var l=function(){return"https://system-1234.oss-cn-chengdu.aliyuncs.com/"}}}]);
//# sourceMappingURL=322.3da4a463.js.map