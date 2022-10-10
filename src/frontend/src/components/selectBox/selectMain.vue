<!--选择页面的其他部分-->
<template>
    <div class="allBox">
        <div class="course-list clearfix">
        <div class="listItem">
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
            <div class="courseItem">
                <div class="imgBox"></div>
                <p class="title hiddenText">快速掌握文件存储的相关知识
                    1233333333312312asjdkajdklwjldkajsldkjawkd阿萨德金娃
                </p>
                <div class="one">
                    <div class="oneleft">坚持到底-不言放弃</div>
                    <div class="oneright">2022-9-10</div>
                </div>
            </div>
        </div>
        </div>
        <div class="course-page">
            <PagerView :total="150" :pageSize="6" 
            :pageNo="2" :continues="5"></PagerView>
        </div>   
    </div>

</template>

<script>
import PagerView from '../PagerView.vue';
export default {
    name: "selectMain",
    components: { PagerView }
}
</script>

<style lang="less" scoped>
    .course-list{
        margin-bottom: 30px;
        .listItem{
            margin: 10px auto;
            width:1160px;
            background: red;
            .courseItem{
                position: relative;
                width: 270px;
                height: 236px;
                float: left;
                margin: 0 20px 20px 0;
                border-radius: 8px;
                background-color: #fff;
                transition: all 0.6s;
                .imgBox{
                    background: red;
                    height: 152px;
                    margin-bottom: 8px;
                    border-radius: 8px 8px 0 0;
                    overflow: hidden;
                }
                .title{
                    color: #545c63;
                    line-height: 20px;
                    height: 40px;
                    margin-bottom: 8px;
                    padding: 0 8px;
                }
                .one{
                    display: flex;
                    justify-content: space-between;
                    font-size: 12px;
                    color: #9199a1;
                    line-height: 18px;
                    padding: 0 8px;
                    margin-bottom: 8px;
                }
            }   
            .courseItem:hover{
                margin-top: 0px;
                box-shadow: 0 0 20px 2px #918f8f;
                transition: all 0.6s;
            }
        }
    }
</style>