<template>
  <div>
    <Lb></Lb>
  </div>
</template>



<script>
  import Lb from '../components/Home/Lb.vue'
export default {
  name: "Home",
  components:{
    Lb
  },
  data() {
    return {
      UserInfoLogin: {
        phone: "",
        password: "",
        CommitPassword: "",
        Vcode: "",
      },
    };
  },
  methods: {
    GotoBtn() {
      console.log(this.$route);
      let routes = this.$route.name;
      if (routes === "Register") {
        let location = { name: "Login" };
        this.$router.push(location);
      } else {
        let location = { name: "Register" };
        this.$router.push(location);
      }
    },
    SendInfo() {
      console.log(123);
      this.$refs.PopupWindow.show(); //用于提醒用户输入的条件
    },
  },
  computed: {
    changestyle() {
      return this.$route.name !== "Login";
    },
    changebg() {
      return this.$route.name !== "Login";
    },
  },
};
</script>

<style scoped lang="less">
  .contain {
    position: relative;
    .mainbox {
      display: flex;

    }
  }
  </style>