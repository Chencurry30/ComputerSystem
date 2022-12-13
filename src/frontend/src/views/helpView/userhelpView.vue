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
        <span class="Center-Header-title Header-Back">用户中心</span>
      </div>
      <div class="por-section">
        <p><strong style="font-size: 18px;">构建有序的学习环境，是旭升网与您共同的目标。</strong></p>
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
            <div class="right-title_area">用户中心</div>

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
  name: 'userhelpView',
  data() {
    return {
      showCurrentIndex: '0',
      UserCenter:[
        {
          id: 1,
          question: '如何注册成为本网站的用户？',
          answer: `在网站首页导航栏右方,点击注册按钮,然后就可以跳转到注册页面。根据页面提示输入相关的信息注册账号成功后,便可成为我们的用户。`
        },{
          id: 2,
          question: '如何修改头像？',
          answer: `用户登录成功后,
                  在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,
                  然后用户再点击我的资料下面的头像,然后就弹出一个上传框,然后选择想要上传的头像,
                  然后点击确定,更换头像成功。注:(上传的文件名用数字或字母,否则将提示上传错误)`

        },{
          id: 3,
          question: '如何修改个人信息？',
          answer: `用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后用户再点击详情信息中的修改信息的按钮,
                  然后在弹窗中修改相关信息,点击确定,若格式没错就修改成功,反之就按照相关提示进行修改后
                  在点击确定`

        },{
          id: 4,
          question: '如何修改密码？',
          answer: `用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后点击左边的账户安全,然后点击下面的修改密码,
                  输入手机号,以及新密码和验证码后,点击修改密码。修改成功后自动退出,重新输入修改后的密码
                  便可以登录成功。`
        },{
          id: 5,
          question: '如何修改绑定的手机号？',
          answer: `用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后点击左边的账户安全,然后点击右边的修改手机号,
                  输入原来的手机号以及验证码后,在输入新的手机号以及验证码，然后点击修改手机号,若修改成功,则账号
                  绑定的手机号便切换为新的手机号`

        },{
          id: 6,
          question: '注册用户忘记密码怎么办？',
          answer: `在网站首页导航栏右方,点击登录或注册按钮,
          然后再点击忘记密码,然后输入账号,修改后的密码以及绑定的手机号,和验证码。然后
          在点击修改,修改成功后用户便可以通过新的密码进行相关登录`
        },
      ],
      RFriendCenter:[
        {
          id:1,
          question:'怎么添加研友？',
          answer:`用户在登录成功后,点击个人中心,进入个人中心的页面后,用户再点击左侧菜单栏中的好友聊天
          在右侧的我的好友中输入相关的关键字,例如(大),下面就会弹出相关的搜索结果,然后点击旁边的添加好友,输入
          添加的相关信息后点击确认,就等对方同意后,添加成功`
        },
        {
          id:2,
          question:'怎么进行研友聊天？',
          answer:`用户在登录成功后,点击个人中心,进入个人中心的页面后,用户再点击左侧菜单栏中的好友聊天
          然后在我的研友中选择出要进行聊天的人,然后点击,发送相关内容即可。`
        },
        {
          id:3,
          question:'怎么查看研究的信息？',
          answer:`用户在登录成功后,点击个人中心,进入个人中心的页面后,用户再点击左侧菜单栏中的好友聊天
          然后在我的研友中选择出要进行聊天的人,然后点击,在点击研究的头像后,跳转到研友的相关界面。`
        }
      ],
      dynamicCenter:[
        {
          id:1,
          question:'怎么上传图片？',
          answer:`用户在登录成功后,点击导航栏右侧的个人中心,然后再点击左侧导航栏中的我的动态,然后
          输入动态的相关信息或者也可以上传图片,然后再点击发送,即可发表动态成功。`
        },
        {
          id:2,
          question:'怎么查看动态？',
          answer:`用户在登录成功后,点击导航栏右侧的个人中心,然后再点击左侧导航栏中的我的动态,然后就可以查看
          全部的动态,或者点击对应用户的头像,跳转后,可以查看该用户的发表的全部动态`
        }
      ],
      answerSelect:[
        {
          id:1,
          name:'用户中心'
        },
        {
          id:2,
          name:'研友中心'
        },
        {
          id:3,
          name:'动态中心'
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
