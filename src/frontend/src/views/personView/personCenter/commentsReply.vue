//评论回复
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
          content:'你的评论对我很有帮助，感谢你的发言',
          resourcename:'回复我的'
        },
        {
          id:1236,
          image:'1231231231232.123',
          nickname:'高山星空',
          time:'2022-6-9',
          content:'你的评论对我很有帮助，感谢',
          resourcename:'回复我的'
        }
      ]
    }
  },
  components: { replyItem },
  name: "commentsReply",
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
