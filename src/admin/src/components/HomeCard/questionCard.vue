<!--题目相关的可视化数据-->
<template>
  <div class="questionCard" ref="questionCard"></div>
</template>

<script>
import { getHomeCount } from '../../services/systemService'
const echarts = require('echarts/lib/echarts');
require('echarts/lib/component/title');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/legend');
require('echarts/lib/chart/pie');
export default {
  name: 'questionCard',
  data() {
    return {
      questionTypeCount: [],
      myChart:'',
      option:{},
    }
  },
  mounted() {
    this.getCaedList()
    // 基于准备好的dom，初始化echarts实例
    this.myChart = echarts.init(this.$refs.questionCard);
  },
  methods: {
    getHomeData() {
      return new Promise((resolve, reject) => {
        getHomeCount().then(res => {
          this.questionTypeCount = []
          let value = []
          let list = res.data.data.questionTypeCount
          for (let i in list) {
            value.push(list[i])
          }
          this.questionTypeCount = value
          resolve(true);
        })
          .catch(err => {
            console.log(err);
            reject(false)
          })
      })
    },
    //钩子执行的函数 
    async getCaedList() {
      await this.getHomeData()
      //初始化option 
      this.option = {
      title: {
        text: '题库分类及数量',
        subtext: '系统开发~~~至今',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          name: 'Access From',
          type: 'pie',
          radius: '60%',
          data: [
            { value: this.questionTypeCount[1], name: '数学' },
            { value: this.questionTypeCount[0], name: '政治' },
            { value: this.questionTypeCount[3], name: '计网' },
            { value: this.questionTypeCount[5], name: '计组' },
            { value: this.questionTypeCount[4], name: '数据结构' }
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
      };
      this.myChart.setOption(this.option);

      this.changeEchar()
    },
    //修改echars中的宽度,使其成为100 
    changeEchar(){
      let canvas = this.$refs.questionCard.firstChild
      canvas.style.width = 100 + '%'
      canvas.querySelector('canvas').style.width = 100 + '%'
    }


  }
}
</script>

<style lang="less" scoped>
.questionCard {
  width: 100%;
  height: 100%;
  background: #fff;
}
</style>