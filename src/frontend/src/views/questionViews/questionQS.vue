
<template>
  <div class="submitQuestionBox">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <!--题目类别-->
      <div class="item">
        <el-form-item label="题目类别" prop="questionType">
          <el-radio-group v-model="ruleForm.questionType">
            <el-radio label="1">单选题</el-radio>
            <el-radio label="2">多选题</el-radio>
            <el-radio label="3">填空题</el-radio>
            <el-radio label="4">解答题</el-radio>
          </el-radio-group>
        </el-form-item>

        <!--题目学科-->
        <el-form-item label="题目学科" prop="classifyId">
          <el-radio-group v-model="ruleForm.classifyId">
            <el-radio label="2">数学</el-radio>
            <el-radio label="3">政治</el-radio>
            <el-radio label="4">计网</el-radio>
            <el-radio label="5">数据结构</el-radio>
            <el-radio label="6">计组</el-radio>
          </el-radio-group>
        </el-form-item>
      </div>



      <div class="item">
        <!--题干内容-->
        <el-form-item label="题干内容" prop="questionTitle">
          <el-input v-model="ruleForm.questionTitle"></el-input>
        </el-form-item>
        <!--题目考点-->
        <el-form-item label="题目考点" prop="sites">
          <el-input v-model="ruleForm.sites"></el-input>
        </el-form-item>

      </div>

      <div class="item">
        <!--题目答案-->
        <el-form-item label="题目答案" prop="answer">
          <el-input v-model="ruleForm.answer"></el-input>
        </el-form-item>

        <!--题目答案的图片-->
        <el-form-item label="答案图片" prop="answerImage">
          <div class="form-item">
            <el-input v-model="ruleForm.answerImage"></el-input>
            <el-upload></el-upload>
          </div>
        </el-form-item>
      </div>

      <div class="item">
        <!--题目中携带的图片-->
        <el-form-item label="携带的图片" prop="enclosureImage">
          <div class="form-item">
            <el-input v-model="ruleForm.enclosureImage"></el-input>
            <el-upload></el-upload>
          </div>
        </el-form-item>
        <!--题干图片-->
        <el-form-item label="题干图片" prop="titleImage">
          <div class="form-item">
            <el-input v-model="ruleForm.titleImage"></el-input>
            <el-upload></el-upload>
          </div>
        </el-form-item>
      </div>


      <div class="item">

        <!--题目解答-->
        <el-form-item label="题目解析" prop="solution">
          <el-input v-model="ruleForm.solution"></el-input>
        </el-form-item>

        <!--题目解答的图片-->
        <el-form-item label="解析图片" prop="solutionImage">
          <div class="form-item">
            <el-input v-model="ruleForm.solutionImage"></el-input>
            <el-upload></el-upload>
          </div>
        </el-form-item>
      </div>










      <!--题目难度-->
      <el-form-item label="题目难度" prop="difficult">
        <el-select v-model="ruleForm.difficult" placeholder="请选择题目难度">
          <el-option label="0.1" value="0.1"></el-option>
          <el-option label="0.2" value="0.2"></el-option>
          <el-option label="0.3" value="0.3"></el-option>
          <el-option label="0.4" value="0.4"></el-option>
          <el-option label="0.5" value="0.5"></el-option>
          <el-option label="0.6" value="0.6"></el-option>
          <el-option label="0.7" value="0.7"></el-option>
          <el-option label="0.8" value="0.8"></el-option>
          <el-option label="0.9" value="0.9"></el-option>
        </el-select>
      </el-form-item>

      <!--题目来源-->
      <el-form-item label="题目来源" prop="source">
        <el-select v-model="ruleForm.source" placeholder="请选择题目年份">
          <el-option label="考研真题" value="考研真题"></el-option>
          <el-option label="408" value="408"></el-option>
          <el-option label="自主出题" value="自主出题"></el-option>

        </el-select>
      </el-form-item>

      <!--题目年份-->
      <el-form-item label="题目年份" prop="year">
        <el-select v-model="ruleForm.year" placeholder="请选择题目年份">
          <el-option label="2022" value="2022"></el-option>
          <el-option label="2021" value="2021"></el-option>
          <el-option label="2020" value="2020"></el-option>
          <el-option label="2019" value="2019"></el-option>
          <el-option label="2018" value="2018"></el-option>

        </el-select>
      </el-form-item>

      <div class="optionSelect">
        <el-form-item :label="`${index + 1}:选项内容  ${item.choiceName}`" prop="questionChoiceList"
          v-for="(item, index) in ruleForm.questionChoiceList" :key="index" :dataIndex="index">
          <el-input v-model="item.choiceTitle" placeholder="请上传选项对应的内容(可以上传图片代替则填无)"></el-input>
          <div class="form-item">
            <el-input v-model="item.titleImage" placeholder="请上传选项对应的图片(若无则不填)"></el-input>
            <el-upload></el-upload>
          </div>

        </el-form-item>
      </div>






      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>



<script>
import ElUpload from '../../components/upload/elUpload';
import { addQuestion } from '../../service/questionService'
export default {
  name: 'questionQS',
  data() {
    return {
      ruleForm: {
        questionTitle: '',    //题干
        titleImage: '',       //题干图片
        enclosureImage: '',   //题目中出现的图片
        answer: '',            //题目答案
        answerImage: '',      //题目答案对应的图片
        questionType: '',    //题目的类型
        solution: '',           //题目解答       
        solutionImage: '',      //题目解答的图片
        sites: '',             //题目考点 
        classifyId: '',      //题目的学科
        difficult: '',        //题目难度
        source: '',           //题目来源 
        year: '',               //题目年份
        questionChoiceList: [
          {
            choiceName: 'A',
            choiceTitle: '',
            titleImage: '',
            choiceId:1,
            questionId:1,

          },
          {
            choiceName: 'B',
            choiceTitle: '',
            titleImage: '',
            choiceId:2,
            questionId:2,
          },
          {
            choiceName: 'C',
            choiceTitle: '',
            titleImage: '',
            choiceId:3,
            questionId:3,
          },
          {
            choiceName: 'D',
            choiceTitle: '',
            titleImage: '',
            choiceId:4,
            questionId:4,
          }

        ]
      },
      rules: {
        //对应题目的内 
        questionTitle: [
          { required: true, message: '请输入题目的内容', trigger: 'blur' },
        ],

        //选择题目的学科 
        classifyId: [
          { required: true, message: '请选择题目学科', trigger: 'change' }
        ],
        //选择题目的类别 
        questionType: [
          { required: true, message: '请选择题目类别', trigger: 'change' }
        ],
        //题目难度 
        difficult: [
          { required: true, message: '请选择题目难度', trigger: 'change' }
        ],
        //题目来源 
        source: [
          { required: true, message: '请选择题目来源', trigger: 'change' }
        ],
        //题目考点
        sites: [
          { required: true, message: '请输入题目考点', trigger: 'blur' },
          { min: 4, max: 12, message: '长度在 4 到 12 个字符', trigger: 'blur' }
        ],
        //题目考点
        answer: [
          { required: true, message: '请输入题目答案', trigger: 'blur' },
        ],
        solution: [
          { required: true, message: '请输入题目的解析', trigger: 'blur' },
        ],
      }
    };
  },
  components: {
    ElUpload,
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addQuestion(this.ruleForm).then((res) => {
            console.log(res);
            this.$message({
              message: "添加成功",
              type: "success",
            })

          })
          console.log(this.ruleForm);
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style  scoped lang="less">
.submitQuestionBox {
  margin: 20px auto;
  width: 900px;
}

.item {
  display: flex;
  justify-content: space-between;
}

.el-form-item {
  width: 50%;

  .form-item {
    display: flex;
    justify-content: space-between;
  }

}

.optionSelect {
  display: flex;
  flex-wrap: wrap;

  .el-form-item {
    width: 50%;

    .form-item {
      margin-top: 5px;
    }
  }
}
</style>