<!--用户和老师的比例-->
<template>
  <div class="userCard" ref="userCard"></div>
</template>

<script>
const echarts = require('echarts/lib/echarts');
require('echarts/lib/component/toolbox');
require('echarts/lib/component/legend');
require('echarts/lib/chart/pie');
export default {
  name: 'userCard',
  data() {
    return {
      option: {},
      mychart: '',
    }
  },
  mounted() {
    this.mychart = echarts.init(this.$refs.userCard)
    this.createEchar()
    this.changeEchar()
  },
  methods: {
    createEchar() {
      this.option = {
        legend: {
          top: 'bottom'
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        series: [
          {
            name: 'Nightingale Chart',
            type: 'pie',
            radius: [40, 100],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 8
            },
            data: [
              { value: 40, name: '注册用户' },
              { value: 38, name: '老师人数' },
              { value: 32, name: '经常使用' },
            ]
          }
        ]
      };
      this.mychart.setOption(this.option);
    },
    changeEchar(){
      let canvas = this.$refs.userCard.firstChild
      canvas.style.width = 100 + '%'
      //获取里面的内部dom,修改width为100% 
      canvas.querySelector('canvas').style.width = 100 + '%'

    }
  }
}
</script>

<style lang="less" scoped>
.userCard {
  width: 100%;
  height: 100%;
  background: #fff;
}
</style>










