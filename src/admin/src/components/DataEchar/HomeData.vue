<template>
  <!--首页展示的顶部数据-->
  <div class="HomeData">
    <div class="Echer-row">
      <div class="EcharItem">
        <div class="EcharItem-icon userSvg">
          <svg-icon icon-class="user"></svg-icon>
        </div>
        <div class="EcharItem-Data">
          <div class="EcharItem-Data-Title">Register User</div>
          <span class="EcharItem-Data-Title-Data">12300</span>
        </div>
      </div>
      <div class="EcharItem">
        <div class="EcharItem-icon teacherSvg">
          <svg-icon icon-class="teacher"></svg-icon>
        </div>
        <div class="EcharItem-Data">
          <div class="EcharItem-Data-Title">Apply Teacher</div>
          <span class="EcharItem-Data-Title-Data">1200</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HomeData',
  data() {
    return {
      like: true,
      value1: 4154.564,
      value2: 2222,
      title: "今年的增长",
      input: "Hello Element UI!",
    };
  },
};
</script>
<style lang="less">
.HomeData {
  position: relative;
  .Echer-row{
    display: flex;
    margin-top: 18px;
    margin-left: -10px;
    margin-right: -10px;

    .EcharItem {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin: 0 10px;
      padding: 0 10px;
      width: 25%;
      height: 108px;
      cursor: pointer;
      font-size: 12px;
      color: #666;
      background: #fff;
      box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.15);
      border-color: rgba(0, 0, 0, 0.05);
    }

    .EcharItem-icon {
      width: 5rem;
      height: 5rem;


    }

    .EcharItem-Data {
      font-weight: 700;
      margin: 1rem;
      margin-left: 0;
      text-align: center;
      font-size: 20px;

      .EcharItem-Data-Title {
        margin-bottom: 12px;
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
      }
    }
  }
}
</style>