<template>
    <div class="headbox w">
        <div class="lf md:w-2/12   w-1/2">项目名字</div>
        <div class="bettwn md:w-7/12 md:block hidden">头部当行</div>
        <div class="lr md:w-3/12  w-1/2 items-center flex">
            <span class=" text-white bg-yellow-600 px-4 py-2 border rounded-full" @click="gotologin">登录/注册</span>
        </div>
    </div>
</template>

<script>
export default {
    name:'Header',

    methods:{
        gotologin(){
            console.log(1);

            let location = {name:'Login'}
            this.$router.push(location)
        }
    }
}
</script>

<style lang="less" scoped>
        .headbox{
            display: flex;
        }

</style>