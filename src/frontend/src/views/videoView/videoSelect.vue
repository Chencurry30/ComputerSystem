<template>
  <div class="MainHeader">
    <div class="fittle w">
    <div class="fittle-box">
        <div class="fittle-itme" v-for="(fatherItem) in getVdieoNavType" :key="fatherItem.id">
            <span class="typename centerLocation">{{fatherItem.name}}</span>
            <ul class="itemList">
                <li class="item centerLocation" v-for="(childItem) in fatherItem.list" :key="childItem.typeId">{{childItem.typeName}}</li>
            </ul>
        </div>
    </div>
  </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
    name: "videoSelect",
    components: {
    },
    mounted(){
      this.getVideoNavType()
    },
    methods:{
      //获取视屏的选择列表 
      getVideoNavType(){
        this.$store.dispatch('videoData/getNavType')
      }
    },
    computed:{
      ...mapGetters('videoData',{
        getVdieoNavType:'getVdieoNavType'
      })
    }
}
</script>

<style lang="less" scoped>
  .MainHeader{
    background: #f2f4f6;
    .fittle{
    padding-top: 20px;

}
    .fittle-box{
        // position: relative;
    // height: 170px;
    padding-bottom: 10px;
    font-size: 14px;
    color: #545c63;
    border-bottom: 1px solid #545c6333;
    .fittle-itme{
        display: flex;
        align-content: center;
        margin-bottom: 15px;
        .typename{
            margin-left: 20px;
            width: 3em;
            margin-right: 6px;
            font-weight: 700;
        }
        .itemList{
            display: flex;
            flex: 1;
            margin-bottom: 0px;
            .item{
                padding: 3px 10px;
                border-radius: 10px;
            }
            .activeOn{
                color: #f20d0d;
                font-weight: 700;
                background: #f20d0d0f;
            }
        }
        }
    }
  }
</style>