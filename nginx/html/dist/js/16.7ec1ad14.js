"use strict";(self["webpackChunkweb_7"]=self["webpackChunkweb_7"]||[]).push([[16],{16:function(s,t,i){i.r(t),i.d(t,{default:function(){return d}});var a=function(){var s=this,t=s._self._c;return t("div",{staticClass:"allBox"},[t("div",{staticClass:"header"},[t("div",{staticClass:"headerBox clearfix w"},[t("div",{staticClass:"school-type"},[t("div",{staticClass:"school-type-header"},[t("div",{staticClass:"title"},[s._v(s._s(s.schoolInfo.name))]),t("div",{staticClass:"ranking"},[s._v(s._s(s.schoolInfo.attribute))])]),t("div",{staticClass:"phone"},[t("span",[s._v("联系电话")]),t("span",[s._v(s._s(s.schoolInfo.phone))])])]),t("div",{staticClass:"school-introduce"},[t("ul",{staticClass:"school-item1"},[t("li",{staticClass:"first bg"},[s._v("地区："+s._s(s.schoolInfo.region))]),t("li",{staticClass:"second bg"},[s._v("类别："+s._s(s.schoolInfo.type))]),t("li",{staticClass:"third bg"},[s._v("隶属："+s._s(s.schoolInfo.subjection))])]),t("div",{staticClass:"school-item4 bg fourth"},[s._v("院校邮箱："+s._s(s.schoolInfo.mail))]),t("div",{staticClass:"school-item4 bg fifth"},[s._v("院校官网："+s._s(s.schoolInfo.web))]),t("div",{staticClass:"school-item4 bg sixth"},[s._v("院校地址："+s._s(s.schoolInfo.address))])])])]),t("div",{staticClass:"connect w"},[s._m(0),t("h2",{staticClass:"big-title"},[s._v("院校简介")]),t("div",{staticClass:"column-title-left"},[t("div",{staticClass:"column-title-left-header"},[t("h3",[s._v("院校历史")]),t("div",{on:{click:s.hex}},[t("a",{staticClass:"rightLink",attrs:{href:"javascript:;"}},[s._v("展开全部")])])]),t("div",{staticClass:"schoolIntroduce",class:{showHeight:s.first}},[s._v(" "+s._s(s.schoolInfo.introduction)+" ")])]),t("h2",{staticClass:"big-title"},[s._v("专业简介")]),t("div",{staticClass:"column-title-left"},[s._m(1),t("div",{staticClass:"tab-header clearfix"},s._l(s.collegeList,(function(i){return t("div",{key:i.id,staticClass:"tab-item",class:{selected:s.countIndex===i.id},on:{click:function(t){return s.selectItem(i.id)}}},[t("a",{attrs:{href:"javascript:;"}},[s._v(s._s(i.name))])])})),0),s._m(2)])])])},e=[function(){var s=this,t=s._self._c;return t("div",{staticClass:"column-title"},[t("h3",[s._v("院校概况")]),t("div",{staticClass:"title-border"})])},function(){var s=this,t=s._self._c;return t("div",{staticClass:"column-title-left-header"},[t("h3",[s._v("硕士专业")])])},function(){var s=this,t=s._self._c;return t("div",{staticClass:"tab-connect"},[t("div",{staticClass:"item-connect"},[t("ul",{staticClass:"clearfix"},[t("li",[s._v("高等教育学[专业的编号]")]),t("li",[s._v("教育技术学[专业的编号]")])])])])}],l=i(6139),c={name:"schoolPage",data(){return{schoolInfo:{},first:!1,collegeList:[{id:0,name:"教育学"},{id:12350,name:"工学"},{id:1235089,name:"理学"}],countIndex:0}},mounted(){this.getSchool()},methods:{getSchool(){let s=this.$route.query.collegeId;(0,l.AI)(s).then((s=>{this.schoolInfo=s.data.data,console.log(s)}))},hex(){this.first=!this.first},selectItem(s){this.countIndex=s}}},o=c,n=i(1001),h=(0,n.Z)(o,a,e,!1,null,"47f6eade",null),d=h.exports}}]);
//# sourceMappingURL=16.7ec1ad14.js.map