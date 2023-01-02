<!--题目管理-->
<template>
  <div class="home">
    <div class="nav-select">
      <div class="nav-left">
        <el-button type="primary" icon="el-icon-plus" @click="addSubBtn" v-has="`system:question:insert`">
          新 增
        </el-button>
      </div>
      <div class="nav-right">
        <div class="nav-left-second">
          <el-select v-model="classfyId" placeholder="请选择筛选科目">
            <el-option label="全部" value="0">全部</el-option>
            <el-option label="数学" value="2">数学</el-option>
            <el-option label="政治" value="3">政治</el-option>
            <el-option label="计网" value="4">计网</el-option>
            <el-option label="数据结构" value="5">数据结构</el-option>
            <el-option label="计组" value="6">计组</el-option>
          </el-select>
        </div>
        <div class="nav-left-second">
          <el-select v-model="coursId" placeholder="请选择筛选题目来源">
            <el-option label="全部" value="0">全部</el-option>
            <el-option label="自主出题" value="1">自主出题</el-option>
            <el-option label="408" value="2">408</el-option>
            <el-option label="考研真题" value="3">考研真题</el-option>

          </el-select>
        </div>
        <el-button type="primary" class="searchData" @click="getSearchBtn">查 询</el-button>
      </div>
    </div>

    <!--主题-->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="questionId" label="ID" width="100"></el-table-column>
      <el-table-column prop="sites" label="题目考点"></el-table-column>
      <el-table-column prop="classifyName" label="题目类型"></el-table-column>
      <el-table-column prop="difficult" label="题目难度"></el-table-column>
      <el-table-column prop="source" label="题目来源"></el-table-column>
      <el-table-column prop="year" label="题目年份"></el-table-column>
      <el-table-column label="操作" width="250">
        <template slot-scope="scope">
          <el-button type="success" size="mini" @click="lookQuestionRow(scope.row)"
            v-has="`system:question:view`">查看</el-button>
          <el-button type="primary" size="mini" @click="editRow(scope.row)"
            v-has="`system:question:update`">编辑</el-button>
          <el-button type="danger" size="mini" @click="deleteQuestionRow(scope.row)"
            v-has="`system:question:delete`">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--分页表单-->
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize"
      @current-change="handleCurrentChange" class="page">
    </el-pagination>

    <!--提示框的组件-->
    <QuestionPopup ref="QuestionPopup"></QuestionPopup>
    <!--显示题目详情的组件-->
    <showQuestionMorePopup ref="showQuestionMorePopup"></showQuestionMorePopup>
    <!--修改题目信息的组件-->
    <toEditPopup ref="toEditPopup"></toEditPopup>
  </div>
</template>

<script>
import QuestionPopup from '../../components/popUp/qustion/questionPopup.vue';
import toEditPopup from '../../components/popUp/qustion/toEditPopup.vue';
import ShowQuestionMorePopup from '../../components/popUp/qustion/showQuestionMorePopup';
import { getQuestionList, deleteQuestionItem } from '../../services/questionManage'
export default {
  name: "questionManage",
  data() {
    return {
      searchForm: {
        // 查询条件
        key: "",
      },
      //根据后端所川回的值
      tableData: [],
      total: 0, //页面总条数
      page: 1, //请求第一次的params
      pageSize: 0,
      classfyId: "",          //题目类型
      coursId: "",
    };
  },
  components: { QuestionPopup, ShowQuestionMorePopup, toEditPopup },
  mounted() {
    this.getQuestionData({ classfyId: 0, coursId: 0, pageNum: 1 });
  },
  methods: {
    //获取所有列表的信息
    getQuestionData({ classfyId, coursId, pageNum }) {
      getQuestionList({ classfyId, coursId, pageNum }).then((res) => {
        if (res.data.code === 403) {
          this.$message.error('权限不足!!!')
        } else if (res.data.code === 200) {
          this.tableData = res.data.data.list;
          this.total = res.data.data.total; //后端返回的总数量
          this.pageSize = res.data.data.pageSize
        } else if(res.data.code === 417){
          this.tableData = []
          this.total = 0
          this.pageSize = 8
        }
      })
    },

    //分页
    handleCurrentChange(page) {
      let classfyId = 0;   //种类
      let coursId = 0;   //来源
      this.page = page;
      if (this.classfyId === '') {
        classfyId = 0;
      } else {
        classfyId = parseInt(this.classfyId)
      }
      if (this.coursId === '') {
        coursId = 0;
      } else {
        coursId = parseInt(this.coursId)
      }
      this.getQuestionData({ classfyId, coursId, pageNum: this.page });
    },

    //查看具体的题目
    lookQuestionRow(row) {
      this.$refs.showQuestionMorePopup.showQuestionMore(row)
    },
    //删除对应的题目 
    deleteQuestionRow(row) {
      console.log(row);
      deleteQuestionItem(row.questionId).then((res) => {
        if (res.data.code === 200) {
          this.$message.success('删除成功')
          //获取对应的相关数据 
          this.getQuestionData({ classfyId: 0, coursId: 0, pageNum: this.page })
        }
      })
    },
    //根据相应的条件查询出对应的题目内容
    getSearchBtn() {
      let classfyId = this.classfyId === "" ? 0 : this.classfyId
      let coursId = this.coursId === "" ? 0 : this.coursId
      console.log(classfyId, coursId);
      this.getQuestionData({ classfyId, coursId, pageNum: this.page })
    },
    //添加题目的弹窗 
    addSubBtn() {
      this.$refs.QuestionPopup.showDialogVisible();
    },
    //编辑题目 
    editRow(rowItem) {
      this.$refs.toEditPopup.showDialogVisible(rowItem);
      //刷新页面 
      // this.getQuestionData({classfyId:0,coursId:0,pageNum:1});
    }
  },
};
</script>

<style scoped lang="less">
.nav-select {
  margin: 10px 20px;
  display: flex;
  justify-content: space-between;

  .nav-right {
    display: flex;

    .nav-left-second {
      margin-right: 10px;
    }

    .searchData {
      margin-left: 10px;
    }
  }
}

.page {
  text-align: center;
  margin-top: 30px;
}
</style>


