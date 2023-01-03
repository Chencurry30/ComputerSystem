<!--首页中的折线图部分-->
<template>
  <div class="HomeDiscount" ref="HomeDiscount"></div>
</template>

<script>
//按需引入 
const echarts = require('echarts/lib/echarts');
require('echarts/lib/component/title');
require('echarts/lib/component/toolbox');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/grid');
require('echarts/lib/component/legend');
require('echarts/lib/chart/line');

export default {
  name: 'HomeDiscount',
  data() {
    return {
      myChart: '',
      option: {},
    }
  },
  mounted() {
    this.myChart = echarts.init(this.$refs.HomeDiscount);
    this.createEchar()
    //如果涉及到请求数据的话,则要注意先加载dom,后才能修改,实在不行学习nextTink,操作元素 
    this.changeEchar()
  },
  methods: {
    createEchar() {
      this.option = {
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['用户注册', '视屏播放', '上传视屏', '用户登录', '组卷次数']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['MonDay', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '用户注册',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: '视屏播放',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: '上传视屏',
            type: 'line',
            stack: 'Total',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: '用户登录',
            type: 'line',
            stack: 'Total',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: '组卷次数',
            type: 'line',
            stack: 'Total',
            data: [820, 932, 901, 934, 1290, 1330, 1320]
          }
        ]
      },
        this.myChart.setOption(this.option);
    },
    changeEchar(){
      let canvas = this.$refs.HomeDiscount.firstChild
      canvas.style.width = 100 + '%'
      canvas.querySelector('canvas').style.width = 100 + '%'
      //使用firstChild获取子节点来修改,使其满足自适应 
      // console.log( this.$refs.HomeDiscount.firstChild);
    }
  }




}
</script>

<style lang="less" scoped>
.HomeDiscount {
  margin-top: 30px;
  width: 100%;
  height: 390px;
  background: #fff;
}
</style>