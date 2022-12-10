<template>
  <div class="MainPageHeader helpBg">
    <div class="help-Center">
      <div class="help-Center-Header">
        <span class="Center-Header-title Header-Back">帮助首页</span>
        <span class="Center-Header-title">></span>
        <span class="Center-Header-title Header-Back">用户中心</span>
      </div>
      <div class="title_area">以下是用户中心相关的注意事项</div>
      <div class="help-Center-Main">
        <div class="Center-Main-left">
          <div class="Center-Main-left-Box">
            <div class="left-title_area">常见问题</div>
            <div class="Center-Main-left-ul">
              <li class="ulItem">
                <div class="ulItemName">用户中心</div>
              </li>
              <li class="ulItem">
                <div class="ulItemName">研友中心</div>
              </li>
              <li class="ulItem">
                <div class="ulItemName">动态中心</div>
              </li>
            </div>
          </div>
        </div>
        <div class="Center-Main-right">
          <div class="Center-Main-right-Box">
            <div class="right-title_area">用户中心</div>
            <div class="Center-Main-right-ul">
              <li class="right-ul" v-for="(item) in answerList" :key="item.id">
                <div class="right-ulItem" @click="loolQuestionAnswer(item.id)">{{item.question}}</div>
                <div class="right-ulItem-answer"
                  :class="{ 'showRight-ulItem-answer': showCurrentIndex === item.id }">
                  {{item.answer}}
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
      answerList: [
        {
          id: 1,
          question: '如何注册成为本网站的用户',
          answer: `答:在网站首页导航栏右方,点击注册按钮,然后就可以跳转到注册页面。根据页面提示输入相关的信息注册账号成功后,便可成为我们的用户。`
        },
        {
          id: 2,
          question: '如何修改头像',
          answer: `答:用户登录成功后,
                  在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,
                  然后用户再点击我的资料下面的头像,然后就弹出一个上传框,然后选择想要上传的头像,
                  然后点击确定,更换头像成功。注:(上传的文件名用数字或字母,否则将提示上传错误)`

        },
        
        {
          id: 3,
          question: '如何修改个人信息',
          answer: `答:用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后用户再点击详情信息中的修改信息的按钮,
                  然后在弹窗中修改相关信息,点击确定,若格式没错就修改成功,反之就按照相关提示进行修改后
                  在点击确定`

        },

        {
          id: 4,
          question: '如何修改密码',
          answer: `答:用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后点击左边的账户安全,然后点击下面的修改密码,
                  输入手机号,以及新密码和验证码后,点击修改密码。修改成功后自动退出,重新输入修改后的密码
                  便可以登录成功。`
        }
        , {
          id: 5,
          question: '如何修改绑定的手机号',
          answer: `答:用户登录成功后,在网站首页导航栏右方,点击个人中心,
                  然后就可以跳转到用户的个人中心页面,然后点击左边的账户安全,然后点击右边的修改手机号,
                  输入原来的手机号以及验证码后,在输入新的手机号以及验证码，然后点击修改手机号,若修改成功,则账号
                  绑定的手机号便切换为新的手机号`

        }, {
          id: 6,
          question: '注册用户忘记密码怎么办',
          answer: `答:在网站首页导航栏右方,点击登录或注册按钮,然后再点击忘记密码,然后输入账号,修改后的密码以及绑定的手机号,和验证码。然后
          在点击修改,修改成功后用户便可以通过新的密码进行相关登录`
        },
      ]
    }
  },
  methods: {
    //获取对应的动态标签值,这样就可以搞定动态显示 
    loolQuestionAnswer(itemId) {
      this.showCurrentIndex = itemId
    },
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
    margin-top: 74px;
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
</style>