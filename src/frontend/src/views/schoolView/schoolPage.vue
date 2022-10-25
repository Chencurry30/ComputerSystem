<template>
  <div class="allBox">
    <div class="headerBox clearfix w">
        <div class="school-type">
            <div class="title">学校名字</div>
            <dl>
                <dd class="first">九八五</dd>
                <dd>二11</dd>
                <dd>双一流</dd>
                <dd>普通本科</dd>
            </dl>
            <div class="phone">
                <span>联系电话</span>
                <span>电话</span>
            </div>
        </div>
        <div class="school-introduce">
                
        </div>

    </div>




  </div>
</template>

<script>
export default {
    name:'schoolPage'
}
</script>

<style lang="less" scoped>
    .headerBox{
        .school-type{
            float: left;
            width: 300px;
            dl{
                margin-top: 24px;
                dd{
                    display: inline-block;
    min-width: 49px;
    height: 21px;
    padding: 0 8px;
    border-radius: 10px;
    background: #f5a500;
    font-size: 16px;
    text-align: center;
    line-height: 21px;
    margin-left: 10px;
    box-sizing: border-box;
                }
                .first{
                    margin-left: 0;
                }
            }
            .title{
                font-size: 26px;
                // color: #fff;
            }
            .phone{
                font-size: 16px;
                line-height: 24px;
                margin-top: 22px;
            }
        }
        .school-introduce{
            width: 620px;
            margin-right: 20px;
            float: right;
            font-size: 16px;
        }
    }
</style>