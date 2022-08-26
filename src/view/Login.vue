<template>
    <div class="contain flex relative md:h-80 h-70 sxm:bg-cover ">
         <div class="showbox absolute bg-white md:top-1/4 md:right-1/4  
       sxm:right-1/4 sxm:top-1/4">
            <div class="selecttitle flex py-3 my-2 md:mt-3 items-center justify-between">
                <div class="md:px-20 px-5 items-center">
                    <span class=" px-5 py-3">注册</span>
                </div>
                <div class="md:px-20 px-10">登录</div>
            </div>
            <div class="form mx-4 my-5">
                <ul class=" flex flex-col space-y-4  text-sm">
                    <li class="px-2 py-3 items-center border rounded-full flex">
                        <img src="@/assets/Img/LoginImg/phone.png" alt="" class="px-2">
                        <input type="text" placeholder="请输入11位手机号" class=" w-full">
                    </li>
                    <li class="items-center flex">
                        <div class="lf flex w-3/5 border rounded-full px-2 py-3">
                            <img src="@/assets/Img/LoginImg/phone.png" alt="" class="px-2">
                            <input type="text" placeholder="请输入11位手机号" class=" w-full">
                        </div>
                        <div class="lr w-2/5 border rounded-full mx-2 text-sm items-center text-center">
                            <button class="py-3">获取验证码</button>
                        </div>
                       
                    </li>
                    <li class="px-2 py-3 items-center border rounded-full flex">
                        <img src="@/assets/Img/LoginImg/phone.png" alt="" class="px-2">
                        <input type="text" placeholder="请输入11位手机号" class=" w-full">
                    </li>
                </ul>
            </div>
            <div class="form-btn my-4 w-15 items-center text-center border rounded-full mx-4">
                <button class="py-2">注册</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:'Login'
}
</script>

<style scoped>
    .contain{
        background: url(../assets/Img/LoginImg/Login-bg.jpeg) no-repeat center center;
    }
    @media screen and (min-width: 768px){
        .contain {
            background-size: 100%;
        }
    }
</style>