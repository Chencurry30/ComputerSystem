//申请成为老师
<template>
  <div class="MainBox w MainPageHeader">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">
          <div class="allBox">
            <personHeader></personHeader>
            <div class="allBox">
              <div class="UserBox second">
                <div class="boxbody">
                  <div class="title-h">
                    <span>申请成为老师</span>
                  </div>
                  <div class="muted-color">申请成为老师，公开昵称，成为更多研友的朋友</div>
                  <div class="btn" @click="ApplyForTeacher()">申请老师</div>
                  <ApplyForTeacher ref="ApplyForTeacher"></ApplyForTeacher>
                </div>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>
  </div>


</template>

<script>
import { mapGetters } from 'vuex'
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
import ApplyForTeacher from '../../components/popUp/ApplyForTeacher'
export default {
  data() {
    return {
      DataList: []
    }
  },
  components: { personAside, personHeader,ApplyForTeacher },
  name: "myComment",
  mounted() {
    this.$store.dispatch('userInfo/getUserInfo')
  },
  methods: {
    backHome() {
      let location = {
        name: 'Home'
      }
      this.$router.push(location)
    },
    ApplyForTeacher(){
      if(sessionStorage.getItem('teacherId') !== '0'){
        this.$message.error('当前已经是老师,禁止申请')
      }else{
        this.$refs.ApplyForTeacher.showPopup()
      }
    }

  },
  computed: {
    ...mapGetters('userInfo',
      {
        getUserImg: 'getUserImg'
      }),
    ...mapGetters('userInfo', {
      getUserInfo: 'getUserInfo'
    }),
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  .containBox {
    margin-top: 70px;
    display: flex;

    .contain-right {
      flex: 3;
    }
  }
}
.allBox {
  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;
  }
  .second {
    margin-top: 15px;
  }
  .boxbody {
    padding: 15px;

    .title-h {
      padding-bottom: 8px;
      position: relative;

      span {
        font-weight: 700;
      }

      ::after {
        position: absolute;
        content: "";
        display: block;
        width: 80px;
        height: 4px;
        top: 20px;
        left: 0;
        bottom: 3px;
        transition: 0.4s;
        background: black;
      }
    }

    .muted-color {
      margin-bottom: 20px;
      color: #999;
    }

    .btn {
      text-align: center;
      padding: 10px 15px;
      width: 300px;
      margin-right: 15px;
      margin-bottom: 10px;
      color: #5c7cff;
      background: rgba(77, 130, 249, 0.1);
      border-radius: 6px;
    }
  }
}
</style>
