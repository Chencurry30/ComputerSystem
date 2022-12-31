<!--申请成为老师的弹窗-->
<template>
  <div class="messageDialog" v-show="showDialog">
    <div class="DialogBox">
      <div class="DialogHeader">
        <div class="Dialogtitle">申请弹窗</div>
        <div class="closeImg" @click="closePopup">
          <img src="../../assets/Img/Icon/close.png" alt="" />
        </div>
      </div>

      <div class="DialogBody">
        <div class="DialogBodyMain">
          <el-form label-width="80px" class="userInfoBox" ref="showPopupInfo" :model="applyData">
            <el-form-item label="老师昵称" prop="name">
              <el-input type="text" placeholder="请输入昵称(如张老师)" v-model.trim="applyData.name">
              </el-input>
            </el-form-item>
            <el-form-item label="教育背景" prop="background">
              <el-input type="text" placeholder="请输入教育背景(如本科)" v-model.trim="applyData.background">
              </el-input>
            </el-form-item>

            <el-form-item label="教育方向">
              <el-select type="text" placeholder="请选择教育方向" v-model.trim="applyData.directionName">
                <el-option label="数学" value="数学"></el-option>
                <el-option label="英语" value="英语"></el-option>
                <el-option label="政治" value="政治"></el-option>
                <el-option label="数据结构" value="数据结构"></el-option>
                <el-option label="计网" value="计网"></el-option>
                <el-option label="计组" value="计组"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="申请内容" prop="applyReason" class="personMessage">
              <el-input type="text" placeholder="请输入申请理由" v-model.trim="applyData.applyReason">
              </el-input>
            </el-form-item>
          </el-form>
          <div class="sendInfo btn" @click="sendLeaveMessage">发送申请</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { applyTeacher } from '../../service/teacherService'
export default {
  name: "ApplyForTeacher",
  data() {
    return {
      showDialog: false,
      direction:['数学','英语','政治','数据结构','计网','计组'],
      applyData: {
        name: "",
        background: "",
        directionId: 0,
        directionName: "",
        //拒绝理由
        reviewComment: "",
        //申请理由
        applyReason: "",
      }
    };
  },
  methods: {
    showPopup() {
      this.showDialog = true;
    },
    closePopup() {
      this.showDialog = false;
    },
    getDirection(value){
      for(let i = 0;i<this.direction.length;i++){
        if(this.direction[i] === value){
          return i+1
        }
      }

    },
    sendLeaveMessage(){
      if(this.applyData.name === ''){
        this.$message.error('请填入你的称呼,方便审核通过')
      }else if(this.applyData.background === ''){
        this.$message.error('请填入你的教育背景,方便审核通过')
      }else if(this.applyData.directionName === ''){
        this.$message.error('请填入你的执教方向,方便审核通过')
      }else if(this.applyData.applyReason === ''){
        this.$message.error('请填入你的申请理由,方便审核通过')
      }else{
        this.applyData.directionId = this.getDirection(this.applyData.directionName)
        applyTeacher(this.applyData).then((res)=>{
          if(res.data.code === 200){
            this.$message.success('申请成功，等待审核中')
            this.showDialog = false;
          }
        })
      }
    }
  },
};
</script>

<style lang="less" scoped>
.messageDialog {
  .DialogBox {
    position: relative;
    top: 50%;
    left: 50%;
    width: 480px;
    height: 440px;
    border-radius: 16px;
    transform: translateX(-50%) translateY(-50%);
    background: #ffffff;

    .closeImg {
      img {
        width: 100%;
      }
    }


    .DialogBody {
      width: 100%;

      .DialogBodyMain {
        padding: 10px 20px;

        .body-item {
          margin: 10px 0;
          display: flex;
          position: relative;

          .laber {
            position: absolute;
            top: 2px;
            left: 0;
            width: 60px;
            font-size: 14px;
            transition: 0.8s;
          }

          .laber-info {
            outline: 0;
            border: none;
            display: block;
            width: 100%;
            padding: 2em 2em 0.4em 0.3em;
            opacity: 0.8;
            transition: 0.3s;
            background: 0 0;
          }

          .laber-line {
            position: absolute;
            bottom: 0;
            left: 0;
            height: 1px;
            width: 100%;
            transition: 0.8s;
            background: rgba(50, 50, 50, 0.06);
          }
        }

        .sendInfo {
          display: flex;
          justify-content: center;
          margin-top: 20px;
          padding: 0.4em 5em;
          background: #59c3fb;
          color: #fff;
        }
      }
    }
  }
}
</style>
