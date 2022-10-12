<!--这个页面是用来保证用户点击其他用户图像时显示其他用户的相关内容，和个人页面差不过大，所以独立出来-->
<template>
  <div class="MainBox w">
    <div class="wrapper">
        <div class="wrapper-header">
            <div class="wrapper-user">
                <div class="user-info">
                    <div class="user-img">
                        <!-- <img src="" alt=""> -->
                    </div>
                    <div class="user-basic">
                        <div class="nickName">高山</div>
                        <div class="personalProfile">
                            这个人很无聊，什么都没有留下
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="navigator">
            <div class="navigator-info">主页</div>
        </div>
    </div>
    <div class="wrapper Main-info">
        <div class="col-left">
            <div class="personVideo">
                <div class="person-title">收藏的视屏</div>
            </div>
            <div class="personMain">
                <div class="Main-item">
                    <div class="item-img"></div>
                    <div class="item-title">123213213</div>
                    <div class="item-others">
                        <div class="left">坚持到底</div>
                        <div class="right">2022-10-9</div>
                    </div>



                </div>
                <div class="Main-item">
                    <div class="item-img"></div>
                    <div class="item-title">123213213</div>
                    <div class="item-others">
                        <div class="left">坚持到底</div>
                        <div class="right">2022-10-9</div>
                    </div>
                </div>
                <div class="Main-item">
                    <div class="item-img"></div>
                    <div class="item-title">123213213</div>
                    <div class="item-others">
                        <div class="left">坚持到底</div>
                        <div class="right">2022-10-9</div>
                    </div>
                </div>
                <div class="Main-item">
                    <div class="item-img"></div>
                    <div class="item-title">123213213</div>
                    <div class="item-others">
                        <div class="left">坚持到底</div>
                        <div class="right">2022-10-9</div>
                    </div>
                </div>
                <div class="Main-item">
                    <div class="item-img"></div>
                    <div class="item-title">123213213</div>
                    <div class="item-others">
                        <div class="left">坚持到底</div>
                        <div class="right">2022-10-9</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-right">
            <div class="personBox">
                <div class="person-info-title centerLocation">个人资料</div>
                <div class="person-info-connect">
                    <div class="info-person">
                        <span class="laber">用户ID:</span>
                        <span class="laber-info">123</span>
                    </div>
                    <div class="info-person">
                        <span class="laber">性别:</span>
                        <span class="laber-info">保密</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name:'ohterPerson'
}
</script>

<style lang="less" scoped>
    .wrapper{
        width: 1100px;
        margin: 0 auto;
        position: relative;
        .wrapper-header{
            position: relative;
            height: 200px;
            background: url(../../assets/Img/banner/person.png) no-repeat;
            background-size: 100%;
            .wrapper-user{    
                display: flex;
                position: absolute;
                bottom: 0;
                z-index: 10;
                .user-info{
                    display: flex;
                    align-items: center;
                    margin-left: 20px;
                    padding-bottom: 16px;
                    .user-img{
                        width: 72px;
                        height: 72px;
                        border-radius: 50%;
                        background: red;
                    }
                    .user-basic{
                        margin-left: 20px;
                        color: #ffffff;
                        .nickName{
                            margin-bottom: 5px;
                            font-weight: 700;
                            line-height: 18px;
                            font-size: 18px;
                        }
                        .personalProfile{
                            font-size: 14px;
                        }
                    }
                }
            }
        }
        .navigator{
            padding: 0 20px;
            height: 66px;
            line-height:66px;
            background: #fff;
            box-shadow: 0 0 0 1px #eee;
            border-radius: 0 0 4px 4px;
            .navigator-info{
                height: 100%;
                font-size: 18px;
                color: #222;
            }
        }
    }
    .Main-info{
        margin-top: 15px;
        display: flex;
        justify-content: space-between;
        .col-left{
            padding: 15px;
            width: 712px;
            background: #fff;
            border: 1px solid #eee;
            border-radius: 4px;
            .personVideo{
                margin-bottom: 17px;
                border-bottom: 1px solid #eee;
                .person-title{
                    line-height: 33px;
                    padding: 0 0 15px;
                    font-size: 20px;
                    color: #000;
                }
            }
            .personMain{
                max-height: 935px;
                .Main-item{
                    margin: 0 0 3px;
                    padding: 10px 10px 10px 0;
                    float: left;
                    width: 170px;
                    .item-img{
                        width: 160px;
                        height: 100px;
                        border-radius: 4px;
                        background: red;
                    }
                    .item-title{
                            line-height: 20px;
                            height: 38px;
                            margin-top: 6px;
                            overflow: hidden;

                    }
                    .item-others{
                            margin-top: 6px;
                            display: flex;
                            justify-content: space-between;
                            white-space: nowrap;
                            height: 14px;
                            line-height: 14px;
                            color:#999;
                            font-size: 12px;
                    }
                }
            }
        }
        .col-right{
            padding: 0 10px;
            width: 388px;
            .personBox{
                margin-left: 10px;
                padding: 15px 20px 18px;
                margin-bottom: 10px;
                background: #fff;
                border: 1px solid #eee;
                border-radius: 4px;
                .person-info-title{



                    padding-bottom: 18px;
                    border-bottom: 1px solid #e5e9ef;
                    margin-bottom: 10px;

                }
                .person-info-connect{
                        width: 100%;
                        .info-person{
                            margin: 5px auto;
                            width: 80%;
                            display: flex;
                            .laber{
                                margin-right: 10px;
                            }
                        }
                }
            }
        }
    }
</style>