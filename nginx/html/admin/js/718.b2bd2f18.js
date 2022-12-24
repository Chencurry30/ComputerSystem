"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[718],{81321:(e,t,a)=>{a.d(t,{Z:()=>u});var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"home"},[a("el-dialog",{attrs:{title:e.title,"append-to-body":"",visible:e.dialogVisible},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("div",{staticStyle:{margin:"15px 0"}}),a("el-checkbox-group",{model:{value:e.userCheckList,callback:function(t){e.userCheckList=t},expression:"userCheckList"}},e._l(e.roleList,(function(t){return a("el-checkbox",{key:t.roleId,attrs:{label:t.roleId}},[e._v(e._s(t.name))])})),1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){return e.closeDialogVisible()}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.subminRole()}}},[e._v("确 定")])],1)],1)],1)},i=[],l=(a(89554),a(41539),a(54747),a(26833),a(48729));const n={name:"GiveRole",data:function(){return{form:{},dialogVisible:!1,activeName:"first",title:"选择角色",userCheckList:[],roleList:[]}},methods:{getAllRole:function(){var e=this;(0,l.JV)().then((function(t){console.log(t),e.roleList=t.data.data}))},getUserRole:function(e){var t=this;this.userCheckList=[],(0,l.xZ)(e.userId).then((function(e){var a=e.data.data;a.forEach((function(e){t.userCheckList[t.userCheckList.length++]=e.roleId})),t.userCheckList=Object.values(t.userCheckList)}))},showGiveRoles:function(e){this.userId=e.userId,this.getAllRole(),this.getUserRole(e),this.dialogVisible=!0},closeDialogVisible:function(){this.dialogVisible=!1},subminRole:function(){var e=this,t={};t.userId=this.userId,t.roleList=[],this.userCheckList.forEach((function(e){var a={roleId:e};t.roleList.push(a)})),(0,l.e1)(t).then((function(t){console.log(t),200===t.data.code&&(e.dialogVisible=!1,e.$parent.getFollowdiaryList())}))}}},s=n;var r=a(43736),c=(0,r.Z)(s,o,i,!1,null,"4362e3e4",null);const u=c.exports},40206:(e,t,a)=>{a.d(t,{Z:()=>d});var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"addRoleBox"},[a("el-dialog",{attrs:{title:"新增用户",visible:e.dialogVisible,width:"30%",center:""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"dataForm",staticClass:"login_in",attrs:{"label-width":"0px",model:e.dataForm,rules:e.checkForm}},[a("div",{staticClass:"form-info"},[a("el-form-item",{attrs:{prop:"username"}},[a("el-input",{attrs:{type:"text","prefix-icon":"el-icon-user",placeholder:"请输入用户用户名"},model:{value:e.dataForm.username,callback:function(t){e.$set(e.dataForm,"username","string"===typeof t?t.trim():t)},expression:"dataForm.username"}})],1),a("el-form-item",{attrs:{prop:"email"}},[a("el-input",{attrs:{"prefix-icon":"el-icon-user",placeholder:"请输入用户邮箱"},model:{value:e.dataForm.email,callback:function(t){e.$set(e.dataForm,"email","string"===typeof t?t.trim():t)},expression:"dataForm.email"}})],1),a("el-form-item",{attrs:{prop:"age"}},[a("el-input",{attrs:{type:"text","prefix-icon":"el-icon-user",placeholder:"请输入用户年龄"},model:{value:e.dataForm.age,callback:function(t){e.$set(e.dataForm,"age","string"===typeof t?t.trim():t)},expression:"dataForm.age"}})],1),a("el-form-item",{attrs:{prop:"sex"}},[a("el-select",{model:{value:e.dataForm.sex,callback:function(t){e.$set(e.dataForm,"sex",t)},expression:"dataForm.sex"}},[a("el-option",{attrs:{label:"女",value:"女"}}),a("el-option",{attrs:{label:"男",value:"男"}}),a("el-option",{attrs:{label:"保密",value:"保密"}})],1)],1)],1)]),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.closeDialogVisible}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.showDialogVisible,e.submit()}}},[e._v("确 定")])],1)],1)],1)},i=[],l=a(56310),n=a(48729);const s={name:"addRolepopUp",data:function(){return{dataForm:{username:"",email:"",age:"",sex:"保密"},dialogVisible:!1,checkForm:{username:[{validator:l.y.Form().validateUserName,trigger:"blur"}],email:[{validator:l.y.Form().validateEmail,trigger:"blur"}],age:[{validator:l.y.Form().validateNumber,trigger:"blur"}]}}},methods:{closeDialogVisible:function(){this.dialogVisible=!1},showDialogVisible:function(){this.dialogVisible=!this.dialogVisible},submit:function(){var e=this,t={};t.username=this.dataForm.username,t.email=this.dataForm.email,t.age=this.dataForm.age,t.sex=this.dataForm.sex,(0,n.cn)(t).then((function(t){200===t.data.code?(e.$message({message:"添加用户成功！",type:"success"}),e.dialogVisible=!1,e.$parent.getFollowdiaryList()):411===t.data.code?e.$message({message:"用户名重复！",type:"error"}):406===t.data.code&&e.$message({message:t.data.message,type:"error"})}))}}},r=s;var c=a(43736),u=(0,c.Z)(r,o,i,!1,null,null,null);const d=u.exports},78718:(e,t,a)=>{a.r(t),a.d(t,{default:()=>m});var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"home"},[e._v("` "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData},on:{"selection-change":e.deleteLog}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"username",label:"用户名",width:"120"}}),a("el-table-column",{attrs:{prop:"ip",label:"ip",width:"120"}}),a("el-table-column",{attrs:{prop:"createDate",label:"事件时间",width:"190"}}),a("el-table-column",{attrs:{prop:"type",label:"事件类型",width:"120"}}),a("el-table-column",{attrs:{prop:"model",label:"事件种类"}}),a("el-table-column",{attrs:{prop:"result",label:"事件结果"}}),a("el-table-column",{attrs:{prop:"description",label:"事件注释"}}),a("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"danger",icon:"el-icon-delete",circle:"",size:"mini"},on:{click:function(a){return e.deleteROW(t.row)}}})]}}])})],1),a("el-pagination",{staticClass:"page",attrs:{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize},on:{"current-change":e.handleCurrentChange}}),a("el-button",{attrs:{type:"primary",icon:"el-icon-delete"},on:{click:function(t){return e.deleteBtn(e.selections)}}},[e._v(" 批量删除 ")]),a("GiveRole",{ref:"GiveRole"}),a("addUserpopUp",{ref:"addUserpopUp"})],1)},i=[],l=a(81321),n=a(40206),s=a(48729);const r={name:"MemberArchive",data:function(){return{tableData:[{logId:"",username:"",ip:"",createDate:"",type:"",model:"",result:"",description:"",total:"",pageSize:""}],total:0,page:1,pageSize:0,selections:[]}},components:{GiveRole:l.Z,addUserpopUp:n.Z},mounted:function(){this.getFollowdiaryList()},methods:{getFollowdiaryList:function(){var e=this;(0,s.EJ)(this.page).then((function(t){e.tableData=t.data.data.list,e.total=t.data.data.total,e.pageSize=t.data.data.pageSize}))},handleCurrentChange:function(e){this.page=e,this.getFollowdiaryList()},deleteROW:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){(0,s.W1)(e.logId).then((function(){t.$message({message:"删除用户成功！",type:"success"}),t.getFollowdiaryList()}))["catch"]((function(){console.log("错误捕获")}))}))["catch"]((function(){t.$message({type:"info",message:"已取消删除"})}))},deleteBtn:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){(0,s.q0)(e).then((function(){t.$message({message:"删除用户成功！",type:"success"}),t.getFollowdiaryList()}))["catch"]((function(){console.log("错误捕获")}))}))["catch"]((function(){t.$message({type:"info",message:"已取消删除"})}))},deleteLog:function(e){this.selections=e}}},c=r;var u=a(43736),d=(0,u.Z)(c,o,i,!1,null,"05137139",null);const m=d.exports},48729:(e,t,a)=>{a.d(t,{DZ:()=>m,EJ:()=>g,Fe:()=>c,IM:()=>s,JV:()=>i,W1:()=>f,Xu:()=>u,Y2:()=>r,_d:()=>l,cn:()=>p,e1:()=>d,pR:()=>n,q0:()=>h,xZ:()=>b});var o=a(44498),i=function(){var e="/admin/roles";return o.Z.get(e)},l=function(e){var t="/admin/roles";return o.Z.post(t,e)},n=function(e){var t="/admin/roles/menu/".concat(e);return o.Z.get(t)},s=function(){var e="/admin/menus/tree";return o.Z.get(e)},r=function(e){var t="/admin/roles/menu";return o.Z.put(t,e)},c=function(e){var t="/admin/roles/".concat(e);return o.Z["delete"](t)},u=function(e){var t="/admin/users/pages/".concat(e);return o.Z.get(t)},d=function(e){var t="/admin/users/role";return o.Z.put(t,e)},m=function(e){var t="/admin/users/".concat(e);return o.Z["delete"](t)},p=function(e){var t="/admin/users";return o.Z.post(t,e)},g=function(e){var t="/admin/logs/pages/".concat(e);return o.Z.get(t)},f=function(e){var t="/admin/logs/".concat(e);return o.Z["delete"](t)},h=function(e){var t="/admin/logs";return o.Z.post(t,e)},b=function(e){var t="/admin/users/role/".concat(e);return o.Z.get(t)}}}]);
//# sourceMappingURL=718.b2bd2f18.js.map