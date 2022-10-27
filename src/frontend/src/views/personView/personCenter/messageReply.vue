//我的评论
<template>
  <div class="allBox">
    <div class="UserBox second">
      <div class="messageHeraer">
        <!--这里是评论信息中的一个组件，这里利用父组件向子组件传入参数即可-->
        <replyItem v-for="(item) in DataList" :key="item.id" :replyInfo="item"></replyItem>
      </div>
    </div>
  </div>
</template>

<script>
import replyItem from '../../../components/remark/replyItem.vue';
export default {
    data(){
    return{
      DataList:[
        {
          id:1232,
          image:'1231231231232.123',
          nickname:'高山',
          time:'2022-6-30',
          content:'课程66666666666，希望有相关系列课程供我们学习',
          resourcename:'计算机组成原理'
        },
        {
          id:1236,
          image:'1231231231232.123',
          nickname:'高山星空',
          time:'2022-6-9',
          content:'这个课程对我们的帮助都很大，感谢鬼剑相关课程给我',
          resourcename:'计算机组成原理'
        }
      ]
    }
  },
  components: { replyItem },
  name: "messageReply",
};
</script>

<style lang='less' scoped>
.allBox {
  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;
  }
  .second {
    margin-top: 15px;
  }
}
</style>
