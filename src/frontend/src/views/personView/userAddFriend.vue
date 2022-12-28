//添加好友
<template>
  <div class="MainBox w MainPageHeader">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <!--我的好友列表-->
            <div class="agreenfriendBox">
              <div class="agreenfriendHeader">
                <span class="headerP1">我的研友</span>
                <span class="headerP2">My Friend</span>
                <span class="headerP3">SETTINGS</span>
              </div>
              <div class="agreenfriendSelect">
                <div class="agreenSelectLeft">
                  <div class="selectItem">
                    <el-select v-model="userValue" placeholder="请选择">
                      <el-option v-for="item in userStatesList" :key="item.value" :label="item.label" :value="item.value">
                        <span>{{ item.label }}</span>
                      </el-option>
                    </el-select>
                  </div>
                  <div class="selectItem">
                    <el-select v-model="actionValue" placeholder="请选择">
                      <el-option v-for="item in actionStatesList" :key="item.value" :label="item.label" :value="item.value">
                        <span>{{ item.label }}</span>
                      </el-option>
                    </el-select>
                  </div>
                </div>
                <div class="agreenSelectRight">
                  <el-button type="primary">刷新列表</el-button>
                  <el-button type="primary" @click="getAgreenList">获取列表</el-button>
                </div>
              </div>


              <div class="agreenfriendBottom">
                <div class="agreenItem" v-for="(item) in getFriendList" :key="item.examineId">

                    <div class="agreenImage" v-if="(userStates === 0)">
                      <img src="../../assets/Img/defaultUserImg.png" alt=""
                        v-if="item === {} || item.friend.image === '无'">
                      <img :src="[publicUrl + item.friend.image]" alt=""  v-else>
                    </div>

                    <div class="agreenImage" v-else>
                      <img src="../../assets/Img/defaultUserImg.png" alt="" v-if="item.user.image === '无'">
                      <img :src="[publicUrl + item.user.image]" alt="" v-else>
                    </div>
                    
                    
                     <div class="agreeNickName" v-if="(userStates === 0)">{{ item.friend.nickname }}</div>
                     <div class="agreeNickName" v-else>{{ item.user.nickname }}</div>


                    <div class="agreenIntroduce">{{ item.reason }}</div>
                    <div class="agreenTime">{{ item.time }}</div>
                    <span v-if="(item.status === 0 && userStates === 0)" class="agreenAction">等待验证</span>
                    <span v-else-if="(item.status === 1 && userStates === 0)" class="agreenAction">申请通过</span>
                    <span v-else-if="(item.status === 2 && userStates === 0)" class="agreenAction">申请未通过</span>

                    <span v-else-if="(item.status === 1 && userStates === 1)" class="agreenAction">已同意</span>
                    <span v-else-if="(item.status === 2 && userStates === 1)" class="agreenAction">已拒绝</span>

                    <el-button size="mini" round v-if="(item.status === 0 && userStates === 1)"  @click="userAgreenBtn(item.userId)">同意</el-button>
                    <el-button size="mini" round v-if="(item.status === 0 && userStates === 1)" @click="userRefusedBtn(item.userId)">拒绝</el-button>                    
                    <el-button size="mini" round v-if="(userStates === 0)">删除</el-button>
                  </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>



import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import { createPublicUrl } from '../../utils/index'
import { getUserFriendAction, agreenFriendAction } from '../../service/userServers'
export default {
  data() {
    return {
      userCurrent: 0,
      firendNickName: '',
      userStatesList: [{
        value: 0,
        label: '我的申请'
      }, {
        value: 1,
        label: '申请我的'
      },],
      actionStatesList: [{
        value: -1,
        label: '全部申请'
      }, {
        value: 0,
        label: '等待验证'
      }, {
        value: 1,
        label: '验证通过'
      },
      {
        value: 2,
        label: '拒绝添加'
      },

      ],
      //供用户选择的相关值 
      userValue: '',
      actionValue: '',

      //三个筛选条件 
      userStates: 0,
      actionStates: 0,
      pageNum: 1,        //分页器的页码数
      //获取后端数据的集合 
      getFriendList: [],
    }
  },
  name: "userAddFriend",
  components: { personAside, personHeader },
  mounted() {
    //获取用户的相关信息,避免刷新到时头像丢失
    this.$store.dispatch('userInfo/getUserInfo')
    //加载页面时默认获取相关的请求
  },
  methods: {
    //获取对应的筛选列表
    getAgreenList() {
      if (this.userValue === '') {
        this.userStates = 0;
      } else {
        this.userStates = this.userValue
      }
      if (this.actionValue === '') {
        this.actionStates = -1
      } else {
        this.actionStates = this.actionValue
      }
      this.getUserFriendList({ userStates: this.userStates, actionStates: this.actionStates, pageNum: this.pageNum })
    },

    //页面加载时获取相关数据
    getUserFriendList({ userStates, actionStates, pageNum }) {
      console.log(userStates, actionStates, pageNum);
      getUserFriendAction({ actionStates, userStates, pageNum }).then((res) => {
        if(res.data.code === 200){
          this.getFriendList = res.data.data.list
        }else if(res.data.code === 417){
          this.getFriendList = []
        }
      })
    },

    //是否同意申请成为好友 
    userAgreenBtn(userId) {
      let data = {}
      data.friendId = userId
      data.status = 1;
      agreenFriendAction(data).then((res) => {
        console.log(res);
        if(res.data.code === 200){
          this.$message.success(res.data.message)
          //同意生气后刷新页面 
          this.getAgreenList()
        }
      })
    },
    //是否拒绝申请
    userRefusedBtn(userId) {
      let data = {}
      data.friendId = userId
      data.status = 2;
      agreenFriendAction(data).then((res) => {
        console.log(res);
        if(res.data.code === 200){
          this.$message.success(res.data.message)
          //同意生气后刷新页面 
          this.getAgreenList()
        }
      })
    }

  },
  computed: {
    // 获取公共的url 
    publicUrl() {
      return createPublicUrl()
    }
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  .containBox {
    margin-top: 5px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}

.agreenfriendBox {
  margin-top: 10px;
  width: 100%;
  border-radius: 10px;
  color: #666;
  border: 2px solid #eee;

  .agreenfriendHeader {
    padding: 15px 0;
    border-bottom: 2px solid #eee;

    .headerP1 {
      margin-left: 20px;
      font-weight: 700;
    }

    .headerP2 {
      margin-left: 20px;
      font-weight: 700;
      color: #ff8c00;
    }

    .headerP3 {
      margin-left: 10px;
    }
  }

  .agreenfriendSelect {
    margin: 10px 8px;
    display: flex;
    justify-content: space-between;

    .agreenSelectLeft {
      display: flex;
    }

    .selectItem {
      margin-right: 10px;
    }
  }

  .agreenfriendBottom {
    .agreenItem {
      margin: 8px 4px;
      display: flex;
      align-items: center;

      .agreenImage {
        width: 48px;
        height: 48px;

        img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }

      .agreeNickName {
        margin-left: 10px;
        width: 120px;

      }

      .agreenIntroduce {
        margin-left: 5px;
        font-size: 18px;
        width: 290px;
      }

      .agreenTime {
        width: 190px;
        font-size: 14px;
      }
      .agreenAction{
        display: inline-block;
        width: 100px;
      }
    }
  }

}
</style>
