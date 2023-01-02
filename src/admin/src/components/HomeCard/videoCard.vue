<!--题目相关的可视化数据-->
<template>
  <div class="MainCard" ref="Main"></div>
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
      videoTypeCount: [],
      myChart:'',
      option:{},
    }
  },
  mounted() {
    this.getCaedList()
    // 基于准备好的dom，初始化echarts实例
    this.myChart = echarts.init(this.$refs.Main);
  },
  methods: {
    getHomeData() {
      return new Promise((resolve, reject) => {
        getHomeCount().then(res => {
          this.videoTypeCount = []
          let value = []
          let list = res.data.data.videoTypeCount
          for (let i in list) {
            value.push(list[i])
          }
          this.videoTypeCount = value
          resolve(true);
        }).catch(err => {
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
        text: '视频分类及数量',
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
            { value: this.videoTypeCount[1], name: '数学' },
            { value: this.videoTypeCount[0], name: '政治' },
            { value: this.videoTypeCount[3], name: '计网' },
            { value: this.videoTypeCount[5], name: '计组' },
            { value: this.videoTypeCount[4], name: '数据结构' },
            { value: this.videoTypeCount[2], name: '数据结构' }
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
    }
  }
}
</script>

<style lang="less" scoped>
.MainCard {
  width: 100%;
  height: 320px;
}
</style>