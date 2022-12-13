<template>
  <div class="MainPageHeader helpBg">
    <div class="help-Center">
      <div class="pcc">
        <h1><span>安全</span></h1>
        <div class="pc"></div>
      </div>
      <div class="help-Center-Header">
        <span class="Center-Header-title Header-Back" @click="backHelpCenter">帮助首页</span>
        <span class="Center-Header-title">></span>
        <span class="Center-Header-title Header-Back">安全中心</span>
      </div>
      <div class="por-section">
        <p><strong style="font-size: 18px;">构建安全的学习环境，是旭升网与您共同的目标。</strong></p>
        <p><strong style="font-size: 18px;">旭升网基于多次网络安全测试的安全经验沉淀，并结合多软件安全的优秀实践，遵照开服区域的法律法规和云安全标准规范，为您提供按需使用、弹性扩展的安全服务，帮助您保护所有的应用系统和重要数据，确保您的旭升网上之旅安全。</strong></p>
      </div>
      <div class="help-Center-Main">
        <div class="Center-Main-left">
          <div class="Center-Main-left-Box">
            <div class="left-title_area">常见问题</div>
            <div class="Center-Main-left-ul">
              <li class="ulItem" v-for="item in answerSelect" :key="item.id" @click="selectItem(item.id)">
                <div class="ulItemName">{{item.name}}</div>
              </li>
            </div>
          </div>
        </div>
        <div class="Center-Main-right">
          <div class="Center-Main-right-Box" v-show="userSelectItem === 1">
            <div class="right-title_area">安全运维</div>

            <div class="Center-Main-right-ul">
              <li class="right-ul" v-for="(item) in UserCenter" :key="item.id">
                <div class="right-ulItem" @click="loolQuestionAnswer(item.id)">{{ item.question }}</div>
                <div class="right-ulItem-answer" :class="{ 'showRight-ulItem-answer': showCurrentIndex === item.id }">
                  {{ item.answer }}
                </div>
              </li>
            </div>






          </div>
          <div class="Center-Main-right-Box" v-show="userSelectItem === 2">
            <div class="right-title_area">研友中心</div>
            <div class="Center-Main-right-ul">
              <li class="right-ul" v-for="(item) in RFriendCenter" :key="item.id">
                <div class="right-ulItem" @click="loolQuestionAnswer(item.id)">{{ item.question }}</div>
                <div class="right-ulItem-answer" :class="{ 'showRight-ulItem-answer': showCurrentIndex === item.id }">
                  {{ item.answer }}
                </div>
              </li>
            </div>
          </div>
          <div class="Center-Main-right-Box" v-show="userSelectItem === 3">
            <div class="right-title_area">动态中心</div>

            <div class="Center-Main-right-ul">
              <li class="right-ul" v-for="(item) in dynamicCenter" :key="item.id">
                <div class="right-ulItem" @click="loolQuestionAnswer(item.id)">{{ item.question }}</div>
                <div class="right-ulItem-answer" :class="{ 'showRight-ulItem-answer': showCurrentIndex === item.id }">
                  {{ item.answer }}
                </div>
              </li>
            </div>






          </div>

        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name:'securityView',
  data() {
    return {
      showCurrentIndex: '0',
      UserCenter:[
        {
          id: 1,
          question: '旭升网提供的基础设施足够安全吗？',
          answer: `旭升网将基础设施安全视为构筑多维全栈的云安全防护体系的核心组成部分。为了让您可以更放心地上云，并利用安全的旭升网服务聚焦在业务发展上，旭升网参考业界最佳实践在数据中心、网络等基础设施的设计和管理上充分考虑安全性与合规性。`
        },{
          id: 2,
          question: '旭升网如何保障云上我的数据的安全性？',
          answer: `旭升网承诺绝不会在未经授权的情况下访问您的内容数据，同时遵从旭升网服务适用的法律法规，并持续关注内外部合规要求的变化，开展所服务行业的安全标准评估，并且向您分享我们的合规实践，保持应有的透明度。您的任何个人信息我们都将加密处理。`

        },{
          id: 3,
          question: '旭升网是否将我的数据转移到其它地方使用？',
          answer: `对于内容数据：您可以决定内容数据存储的区域。没有获得您的明确同意或者其他法律义务要求时，旭升网不会将您的内容数据转移到其他区域。`
        }
      ],
      RFriendCenter:[
        {
          id:1,
          question:'怎么处理身份认证失败？',
          answer:`用户在注册登录的同时，后台会验证其信息是否正确，若错误，会及时的弹出错误提示信息；若成功，系统会自动跳转到相应成功页面。`
        },
        {
          id:2,
          question:'系统怎样进行用户角色认证？',
          answer:`角色认证一律在我们后台管理系统中进行，若用户有角色认证需求请及时与我们联系，我们会尽快在后台管理系统中为用户开通有关权限。`
        }
      ],
      dynamicCenter:[
        {
          id:1,
          question:'该系统维护方面做了哪些？',
          answer:`入侵检测、数据备份、服务器优化、常见故障处理以及日志安排等一系统日常维护，服务器管理工作。`
        },
        {
          id:2,
          question:'系统安全检测是怎样进行的？',
          answer:`查看服务器状态、检测当前进程情况（在任务管理器中查看）、检查系统账号、检查是否有克隆账号、查看当前端口是否开放情况、检查系统服务、查看相关日志、检查系统文件、检查目录权限`
        }
      ],
      answerSelect:[
        {
          id:1,
          name:'安全运维'
        },
        {
          id:2,
          name:'身份认证'
        },
        {
          id:3,
          name:'系统维护'
        }
      ],
      userSelectItem:1,
    }
  },
  methods: {
    //获取对应的动态标签值,这样就可以搞定动态显示
    loolQuestionAnswer(itemId) {
      this.showCurrentIndex = itemId
    },
    //选择对应的动态
    selectItem(itemId){
      console.log(itemId);
      this.userSelectItem = itemId
    },
    //返回帮助首页
    backHelpCenter(){
      let location = {name:'helpCenter'}
      this.$router.push(location)
    }
  },
}
</script>

<style lang="less" scoped>
.helpBg {
  background: #f5f5f5;
}
.help-Center {
  margin: 0 auto;
  width: 1080px;

  .help-Center-Header {
    margin-top: 130px;
    padding-top: 10px;

    .Center-Header-title {
      display: inline-block;
      margin-left: 6px;
      height: 24px;
      line-height: 24px;
      color: #666666;
      font-size: 16px;
    }

    .Header-Back {
      cursor: pointer;
    }

    .Header-Back:hover {
      color: red;
    }
  }

  .title_area {
    margin: 10px 0 20px 10px;
    font-size: 24px;
    line-height: 45px;
    color: #333333;

  }

  .help-Center-Main {
    display: flex;
    padding-bottom: 30px;
    .Center-Main-left {
      width: 224px;

      .Center-Main-left-Box {
        width: 100%;
        background: #ffffff;
        border-radius: 5px;
        overflow: hidden;

        .left-title_area {
          width: 100%;
          background: url(../../assets/Img/helpCenterImg/leftTitleBg.png) no-repeat;
          height: 60px;
          font-size: 22px;
          font-weight: bold;
          color: #FFFFFF;
          text-indent: 22px;
          line-height: 60px;
        }

        .Center-Main-left-ul {
          background-color: #FFFFFF;
          background-image: url(../../assets/Img/helpCenterImg/leftSelectBg.png) no-repeat left bottom;

          .ulItem {
            border-top: 1px solid #f2f2f2;
            cursor: pointer;

            .ulItemName {
              height: 46px;
              line-height: 46px;
              color: #434343;
              font-size: 16px;
              padding-left: 40px;
            }
          }
        }

        .Center-Main-left-ul .ulItem:first-child {
          border: 0;
        }
      }


    }

    .Center-Main-right {
      margin-left: 10px;
      width: 834px;

      .Center-Main-right-Box {
        background: #ffffff;
        border-radius: 10px;

        .right-title_area {
          height: 58px;
          border-bottom: 1px solid #e6e6e6;
          padding-left: 60px;
          line-height: 58px;
          font-size: 19px;
          color: #b9331b;
          font-weight: bold;
          text-align: left;
        }

        .Center-Main-right-ul {

          padding: 23px 30px 22px;
          text-align: left;

          .right-ulItem {
            padding-left: 32px;
            height: 48px;
            line-height: 48px;
            font-size: 19px;
            color: #3d3d3d;
            background: url(../../assets/Img/helpCenterImg/rightSelectItem.png) no-repeat left center;
            display: block;
            cursor: pointer;
          }

          .right-ulItem-answer {
            display: none;
            padding-left: 10px;
          }

          .showRight-ulItem-answer {
            display: block;
          }
        }
      }
    }
  }
}
.por-section{
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}
.pc{
  background-image: url("../../assets/Img/PC.jpg");
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  width: 100%;
  height: 300px;
  background-position: top center;
  background-size: cover;
  background-repeat: no-repeat;
}
.pcc{
  width: 100%;
  height: 100px;
  h1{
    span{
      font-weight: 700;
      font-size: 40px;
      line-height: 50px;
      color: #252b3a;
    }
  }
}
</style>
