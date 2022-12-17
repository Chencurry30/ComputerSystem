"use strict";(self["webpackChunkweb_7"]=self["webpackChunkweb_7"]||[]).push([[263],{5263:function(e,t,s){s.r(t),s.d(t,{default:function(){return u}});var i=function(){var e=this,t=e._self._c;return t("div",{staticClass:"MainPageHeader helpBg"},[t("div",{staticClass:"help-Center"},[e._m(0),t("div",{staticClass:"help-Center-Header"},[t("span",{staticClass:"Center-Header-title Header-Back",on:{click:e.backHelpCenter}},[e._v("帮助首页")]),t("span",{staticClass:"Center-Header-title"},[e._v(">")]),t("span",{staticClass:"Center-Header-title Header-Back"},[e._v("上传帮助")])]),e._m(1),t("div",{staticClass:"help-Center-Main"},[t("div",{staticClass:"Center-Main-left"},[t("div",{staticClass:"Center-Main-left-Box"},[t("div",{staticClass:"left-title_area"},[e._v("常见问题")]),t("div",{staticClass:"Center-Main-left-ul"},e._l(e.answerSelect,(function(s){return t("li",{key:s.id,staticClass:"ulItem",on:{click:function(t){return e.selectItem(s.id)}}},[t("div",{staticClass:"ulItemName"},[e._v(e._s(s.name))])])})),0)])]),t("div",{staticClass:"Center-Main-right"},[t("div",{directives:[{name:"show",rawName:"v-show",value:1===e.userSelectItem,expression:"userSelectItem === 1"}],staticClass:"Center-Main-right-Box"},[t("div",{staticClass:"right-title_area"},[e._v("安全运维")]),t("div",{staticClass:"Center-Main-right-ul"},e._l(e.UserCenter,(function(s){return t("li",{key:s.id,staticClass:"right-ul"},[t("div",{staticClass:"right-ulItem",on:{click:function(t){return e.loolQuestionAnswer(s.id)}}},[e._v(e._s(s.question))]),t("div",{staticClass:"right-ulItem-answer",class:{"showRight-ulItem-answer":e.showCurrentIndex===s.id}},[e._v(" "+e._s(s.answer)+" ")])])})),0)]),t("div",{directives:[{name:"show",rawName:"v-show",value:2===e.userSelectItem,expression:"userSelectItem === 2"}],staticClass:"Center-Main-right-Box"},[t("div",{staticClass:"right-title_area"},[e._v("上传问题")]),t("div",{staticClass:"Center-Main-right-ul"},e._l(e.RFriendCenter,(function(s){return t("li",{key:s.id,staticClass:"right-ul"},[t("div",{staticClass:"right-ulItem",on:{click:function(t){return e.loolQuestionAnswer(s.id)}}},[e._v(e._s(s.question))]),t("div",{staticClass:"right-ulItem-answer",class:{"showRight-ulItem-answer":e.showCurrentIndex===s.id}},[e._v(" "+e._s(s.answer)+" ")])])})),0)]),t("div",{directives:[{name:"show",rawName:"v-show",value:3===e.userSelectItem,expression:"userSelectItem === 3"}],staticClass:"Center-Main-right-Box"},[t("div",{staticClass:"right-title_area"},[e._v("系统维护")]),t("div",{staticClass:"Center-Main-right-ul"},e._l(e.dynamicCenter,(function(s){return t("li",{key:s.id,staticClass:"right-ul"},[t("div",{staticClass:"right-ulItem",on:{click:function(t){return e.loolQuestionAnswer(s.id)}}},[e._v(e._s(s.question))]),t("div",{staticClass:"right-ulItem-answer",class:{"showRight-ulItem-answer":e.showCurrentIndex===s.id}},[e._v(" "+e._s(s.answer)+" ")])])})),0)])])])])])},a=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"pcc"},[t("h1",[t("span",[e._v("安全")])]),t("div",{staticClass:"pc"})])},function(){var e=this,t=e._self._c;return t("div",{staticClass:"por-section"},[t("p",[t("strong",{staticStyle:{"font-size":"18px"}},[e._v("构建安全的上传环境，是旭升网与您共同的目标。")])])])}],n={name:"uploadView",data(){return{showCurrentIndex:"0",UserCenter:[{id:1,question:"旭升网提供的基础设施足够安全吗？",answer:"旭升网将基础设施安全视为构筑多维全栈的云安全防护体系的核心组成部分。为了让您可以更放心地上云，并利用安全的旭升网服务聚焦在业务发展上，旭升网参考业界最佳实践在数据中心、网络等基础设施的设计和管理上充分考虑安全性与合规性。"},{id:2,question:"旭升网如何保障云上我的数据的安全性？",answer:"旭升网承诺绝不会在未经授权的情况下访问您的内容数据，同时遵从旭升网服务适用的法律法规，并持续关注内外部合规要求的变化，开展所服务行业的安全标准评估，并且向您分享我们的合规实践，保持应有的透明度。您的任何个人信息我们都将加密处理。"},{id:3,question:"旭升网是否将我的数据转移到其它地方使用？",answer:"对于内容数据：您可以决定内容数据存储的区域。没有获得您的明确同意或者其他法律义务要求时，旭升网不会将您的内容数据转移到其他区域。"}],RFriendCenter:[{id:1,question:"为什么上传的照片或视频出现失败情况？",answer:"首先，若已经成功上传有关信息，是符合旭升网的相关要求，都是通过相关校验合格后，上传成功。其次，若上传失败有关信息，其原因可能是不符合本系统相关规定，重新上传符合的即可。"},{id:2,question:"是否确保上传的有关信息的安全性？",answer:"用户上传的信息都是通过后台和前台的审核合格后才做出相应的成功返回，请您放心使用！"}],dynamicCenter:[{id:1,question:"该系统维护方面做了哪些？",answer:"入侵检测、数据备份、服务器优化、常见故障处理以及日志安排等一系统日常维护，服务器管理工作。"},{id:2,question:"系统安全检测是怎样进行的？",answer:"查看服务器状态、检测当前进程情况（在任务管理器中查看）、检查系统账号、检查是否有克隆账号、查看当前端口是否开放情况、检查系统服务、查看相关日志、检查系统文件、检查目录权限"}],answerSelect:[{id:1,name:"安全运维"},{id:2,name:"上传问题"},{id:3,name:"系统维护"}],userSelectItem:1}},methods:{loolQuestionAnswer(e){this.showCurrentIndex=e},selectItem(e){console.log(e),this.userSelectItem=e},backHelpCenter(){let e={name:"helpCenter"};this.$router.push(e)}}},r=n,l=s(3736),c=(0,l.Z)(r,i,a,!1,null,"8e6e8104",null),u=c.exports}}]);
//# sourceMappingURL=263.9b513352.js.map