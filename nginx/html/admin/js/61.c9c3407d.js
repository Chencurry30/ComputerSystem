"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[61],{65061:(t,e,l)=>{l.r(e),l.d(e,{default:()=>c});var a=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",[l("div",{staticClass:"demo-form-inline"},[l("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.searchForm}},[l("el-form-item",{attrs:{label:"关键字"}},[l("el-input",{attrs:{placeholder:"编码/项目名称"},model:{value:t.searchForm.key,callback:function(e){t.$set(t.searchForm,"key",e)},expression:"searchForm.key"}})],1),l("el-form-item",[l("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.getSearchBtn()}}},[t._v("查 询")]),l("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:t.onSubmit}},[t._v("新 增")])],1)],1)],1),l("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData}},[l("el-table-column",{attrs:{type:"selection",width:"55"}}),l("el-table-column",{attrs:{prop:"mno",label:"编码"}}),l("el-table-column",{attrs:{prop:"mname",label:"项目名称"}}),l("el-table-column",{attrs:{prop:"mstrength",label:"运动强度"}}),l("el-table-column",{attrs:{prop:"mweight",label:"千步当量"}}),l("el-table-column",{attrs:{prop:"magelower",label:"年龄下限"}}),l("el-table-column",{attrs:{prop:"mageupper",label:"年龄上线"}}),l("el-table-column",{attrs:{prop:"mtime",label:"运动时间"}}),l("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[l("el-button",{attrs:{type:"text",size:"small"},on:{click:function(l){return t.editRow(e.row)}}},[t._v("编辑")]),l("el-button",{attrs:{type:"text",size:"small"},on:{click:function(l){return t.deleteRow(e.row)}}},[t._v("删除")])]}}])})],1),l("el-pagination",{staticClass:"mt-20p",attrs:{background:"","current-page":t.searchForm.page,"page-size":t.searchForm.size,layout:"->, total, prev, pager, next",total:t.total},on:{"current-change":t.handleCurrentChange}})],1)},n=[];const o={data:function(){return{searchForm:{key:"",page:1,size:10},tableData:[],total:13}},mounted:function(){this.getMovementListApi()},methods:{getMovementListApi:function(){var t=this;servicesApi.getMovementListApi().then((function(e){t.tableData=e.data.data}))},deleteRow:function(t){var e=this;console.log(t),servicesApi.deleteMovementListApi(t.mno).then((function(t){e.getMovementListApi(),console.log(t)}))},getSearchBtn:function(){},onSubmit:function(){this.$refs["MovementBaseDialog"].show()},editRow:function(t){this.$refs.MovementBaseDialog.show(t)},handleClick:function(t){console.log(t)},handleCurrentChange:function(){}}},r=o;var i=l(43736),s=(0,i.Z)(r,a,n,!1,null,null,null);const c=s.exports}}]);
//# sourceMappingURL=61.c9c3407d.js.map