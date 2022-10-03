<template>
  <div class="MainBox w">
    <div class="containBox">
      <div class="contain-left">
        <div class="Item">
          <div class="ItemHeader">
            <div class="HeaderTitle">个人中心</div>
            <div class="HeaderInfo">
              <div class="Info1">PERSONAL CENTER</div>
              <div class="Info2">MY DERE SEE DETALS</div>
            </div>
          </div>
          <div class="ItemBox">
            <ul class="ItemBox-list">
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/person.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link :to="{name:'personInfo'}" style="text-decoration:none">个人资料</router-link>
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/security.png" alt="" />
                </div>
                <div class="list-info">
                   <router-link :to="{name:'personSecurity'}" style="text-decoration:none">账户安全</router-link>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div class="Item second">
          <div class="ItemHeader">
            <div class="HeaderTitle">消息中心</div>
            <div class="HeaderInfo">
              <div class="Info1">MESSAGE CENTER</div>
              <div class="Info2">MY DERE SEE DETALS</div>
            </div>
          </div>
          <div class="ItemBox">
            <ul class="ItemBox-list">
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/remind.png" alt="" />
                </div>
                <div class="list-info">
                  <router-link :to="{name:'messageReply'}" style="text-decoration:none">消息回复</router-link>
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/remark.png" alt="" />
                </div>
                <div class="list-info">
                   <router-link :to="{name:'personSecurity'}" style="text-decoration:none">消息评论</router-link>
                </div>
              </li>
              <li class="list-item">
                <div class="list-icon">
                  <img src="../../assets/Img/Icon/reply.png" alt="" />
                </div>
                <div class="list-info">
                   <router-link :to="{name:'personSecurity'}" style="text-decoration:none">他人回复</router-link>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="contain-right">
        <div class="showBox">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name:'personPage',

};
</script>

<style lang="less" scoped>
.containBox {
  margin-top: 5px;
  display: flex;
  .contain-left {
    flex: 1;
    .Item {
      margin:0px 10px;
      width: 280px;
      border-radius: 10px;
      border: 3px solid #eee;
      .ItemHeader {
        display: flex;
        padding: 10px 0;
        justify-content: space-between;
        border-bottom: 2px solid #eee;

        .HeaderTitle {
          margin-left: 15px;
          font-size: 24px;
          font-weight: 700;
          color: #ff8c00;
        }
        .HeaderInfo {
          margin-right: 15px;
          .Info1 {
            font-size: 16px;
            font-weight: 700;
          }
          .Info2 {
            font-size: 10px;
          }
        }
      }
      .ItemBox {
        padding: 0 15px;
        .ItemBox-list {
          .list-item {
            display: flex;
            padding: 0 10px;
            height: 40px;
            line-height: 40px;
            border-bottom: 2px solid #eee;
            .list-icon {
              margin-top: 10px;
              width: 20px;
              height: 20px;
              img {
                vertical-align: top;
                width: 100%;
              }
            }
            .list-info {
              margin-left: 8px;
              font-size: 14px;
            }
          }
        }
      }
    }
    .second{
      margin-top: 12px;
    }
  }
  .contain-right {
    flex: 3;
    .showBox {
      padding: 0 10px;
      width: 820px;
    }
  }
}
</style>