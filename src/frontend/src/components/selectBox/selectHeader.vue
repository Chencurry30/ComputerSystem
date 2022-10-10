<!--选择页面的头部-->
<template>
  <div class="fittle w">
    <div class="fittle-box">
        <div class="fittle-itme">
            <span class="typename centerLocation">分类</span>
            <ul class="itemList">
                <li class="item centerLocation activeOn">全部</li>
                <li class="item">数学</li>
                <li class="item">英语</li>
                <li class="item">政治</li>
                <li class="item">计算机组成原理</li>
                <li class="item">数据结构</li>
                <li class="item">计算机网络</li>
            </ul>
        </div>
        <div class="fittle-itme">
            <span class="typename centerLocation">时长</span>
            <ul class="itemList">
                <li class="item centerLocation activeOn">全部</li>
                <li class="item">小于十分钟</li>
                <li class="item">小于30分钟</li>
                <li class="item">小于一个小时</li>
                <li class="item">大于二小时</li>
                <li class="item">大于三小时</li>
            </ul>
        </div>
        <div class="fittle-itme">
            <span class="typename centerLocation">排列</span>
            <ul class="itemList">
                <li class="item centerLocation activeOn">全部</li>
                <li class="item">时长</li>
                <li class="item">上传时间</li>
                <li class="item">播放量</li>
                <li class="item">评论人数</li>
            </ul>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name:'selectHeader'
}
</script>

<style lang="less" scoped>
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
</style>