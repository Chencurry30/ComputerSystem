"use strict";(self["webpackChunkadmin"]=self["webpackChunkadmin"]||[]).push([[813],{813:function(t,e,a){a.r(e),a.d(e,{default:function(){return x}});var s=function(){var t=this,e=t._self._c;return e("div",{staticClass:"home"},[e("div",{staticClass:"header"}),e("div",{staticClass:"tableBox",staticStyle:{width:"100%"}},[t._m(0),t._l(t.teacherData,(function(a){return e("div",{key:a.examineId,staticClass:"tableDataItem"},[e("div",{staticClass:"examineId"},[t._v(t._s(a.examineId))]),e("div",{staticClass:"name"},[t._v(t._s(a.name))]),e("div",{staticClass:"directionName"},[t._v(t._s(a.directionName))]),e("div",{staticClass:"background"},[t._v(t._s(a.background))]),e("div",{staticClass:"applyDate"},[t._v(t._s(a.applyDate))]),e("div",{staticClass:"applyReason"},[t._v(t._s(a.applyReason))]),e("div",{staticClass:"reviewComment"},[t._v(t._s(a.reviewComment))]),e("div",{staticClass:"examineStatus"},[0===a.examineStatus?e("el-tag",[t._v("未审核")]):1===a.examineStatus?e("el-tag",{attrs:{type:"success"}},[t._v("通   过")]):e("el-tag",{attrs:{type:"danger"}},[t._v("未通过")])],1),e("div",{staticClass:"action"},[0===a.examineStatus?e("el-button",{directives:[{name:"has",rawName:"v-has",value:"system:teacher:sh",expression:"`system:teacher:sh`"}],attrs:{type:"success",size:"mini"},on:{click:function(e){return t.agreeRow(a)}}},[t._v("同意")]):t._e(),0===a.examineStatus?e("el-button",{directives:[{name:"has",rawName:"v-has",value:"system:teacher:sh",expression:"`system:teacher:sh`"}],attrs:{type:"danger",size:"mini"},on:{click:function(e){return t.disagreeRow(a)}}},[t._v("不同意")]):t._e()],1)])}))],2),e("teacherReply",{ref:"teacherReply"})],1)},i=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"tableTypeNav"},[e("div",{staticClass:"examineId"},[t._v("申请ID")]),e("div",{staticClass:"name"},[t._v("申请人名称")]),e("div",{staticClass:"directionName"},[t._v("老师教授的学科")]),e("div",{staticClass:"background"},[t._v("老师学历背景")]),e("div",{staticClass:"applyDate"},[t._v("申请时间")]),e("div",{staticClass:"applyReason"},[t._v("申请理由")]),e("div",{staticClass:"reviewComment"},[t._v("未通过理由")]),e("div",{staticClass:"examineStatus"},[t._v("状态")]),e("div",{staticClass:"action"},[t._v("操作")])])}],n=function(){var t=this,e=t._self._c;return e("div",{staticClass:"auditBox"},[e("el-dialog",{attrs:{title:"提示",center:"",visible:t.dialogVisible,width:"60%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[e("div",{staticClass:"auditMain"},[e("div",{staticClass:"MainHeader"}),e("div",{staticClass:"MainBottem"},[e("el-form",{ref:"form",attrs:{model:t.commitData,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"审核意见"}},[e("el-input",{model:{value:t.commitData.reviewComment,callback:function(e){t.$set(t.commitData,"reviewComment",e)},expression:"commitData.reviewComment"}})],1)],1)],1)]),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.subMitData()}}},[t._v("确 定")])],1)])],1)},l=[],c=a(4498);const r=()=>{const t="examine";return c.Z.get(t)},o=t=>{const e=`/examine/agree/${t}`;return c.Z.put(e)},m=(t,e)=>{const a=`examine/disagree/${t}/${e}`;return c.Z.put(a)};var d={name:"teacherReply",data(){return{dialogVisible:!1,commitData:{reviewComment:""},examineId:0}},methods:{showDialog(t){this.examineId=t.examineId,this.dialogVisible=!0},subMitData(){""===this.commitData.reviewComment?this.$message.error("请给出审核理由"):m(this.examineId,this.commitData.reviewComment).then((t=>{console.log(t),200===t.data.code&&(this.$message.success("老师审核成功"),this.dialogVisible=!1,this.$parent.getExamineData())}))}}},v=d,u=a(1001),h=(0,u.Z)(v,n,l,!1,null,"577f9e51",null),p=h.exports,_={name:"teacherManage",data(){return{teacherData:[]}},components:{teacherReply:p},mounted(){this.getExamineData()},methods:{getExamineData(){r().then((t=>{200===t.data.code&&(this.teacherData=t.data.data)}))},agreeRow(t){o(t.examineId).then((t=>{200===t.data.code&&(this.$message.success("审核成功！！！"),this.getExamineData())}))},disagreeRow(t){this.$refs.teacherReply.showDialog(t)}}},C=_,g=(0,u.Z)(C,s,i,!1,null,"5451127b",null),x=g.exports}}]);
//# sourceMappingURL=813.1f68d9da.js.map