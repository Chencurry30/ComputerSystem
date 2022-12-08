//添加好友
<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <!--我的好友列表-->
            <div class="agreenfriendBox">
              <div class="agreenfriendHeader">
                <span class="headerP1">我的好友</span>
                <span class="headerP2">My Friend</span>
                <span class="headerP3">SETTINGS</span>
              </div>
              <div class="agreenfriendSelect">
                <div class="agreenSelectLeft">
                  <div class="selectItem">
                    <el-select v-model="userValue" placeholder="请选择">
                      <el-option v-for="item in cities" :key="item.value" :label="item.label" :value="item.value">
                        <span>{{ item.label }}</span>
                      </el-option>
                    </el-select>
                  </div>
                  <div class="selectItem">
                    <el-select v-model="actionValue" placeholder="请选择">
                      <el-option v-for="item in agreeStates" :key="item.value" :label="item.label" :value="item.value">
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
                  <div class="agreenImage">
                    <img src="../../assets/Img/defaultUserImg.png" alt="" v-if="item.user.image === '无'">
                    <img :src="[publicUrl + item.user.image ]" alt="">
                  </div>
                  <div class="agreeNickName">{{item.user.nickname}}</div>
                  <div class="agreenIntroduce">{{ item.reason }}</div>
                  <div class="agreenTime">{{ item.time }}</div>
                  <el-button type="success" icon="el-icon-check" circle size="mini" v-if="(userStates !== 0)"></el-button>
                  <el-button type="danger" icon="el-icon-delete" circle size="mini"></el-button>
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
import { getUserFriendAction } from '../../service/userServers'
export default {
  data() {
    return {
      userCurrent: 0,
      firendNickName: '',
      cities: [{
        value: 0,
        label: '我的申请'
      }, {
        value: 1,
        label: '申请我的'
      },],
      agreeStates: [{
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
      actionStates: 0,
      userStates: 0,
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
    this.getUserFriendList({ actionStates: -1, userStates: 0, pageNum: 1 })
  },
  methods: {

    //获取对应的筛选列表
    getAgreenList() {
      if(this.userValue === ''){
        this.userStates = 0;
      }else{
        this.userStates = this.userValue
      }
      if(this.actionValue === ''){
        this.actionStates = -1
      }else{
        this.actionStates = this.actionValue
      }
      this.getUserFriendList({userStates:this.userStates,actionStates:this.actionStates,pageNum:this.pageNum})
    },

    //页面加载时获取相关数据
    getUserFriendList({ userStates, actionStates, pageNum }) {
      console.log(userStates, actionStates, pageNum);
      getUserFriendAction({ actionStates, userStates, pageNum }).then((res) => {
        console.log(res);
        this.getFriendList = res.data.data.list
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
  margin-top: 15px;

  .containBox {
    margin-top: 5px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}

.userAction {
  display: flex;
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
      .agreeNickName{
        margin-left: 10px;
        width: 120px;

      }
      .agreenIntroduce {
        margin-left: 5px;
        font-size: 18px;
        width: 500px;
      }

      .agreenTime {
        width: 260px;
        font-size: 14px;
      }
    }
  }

}
</style>
