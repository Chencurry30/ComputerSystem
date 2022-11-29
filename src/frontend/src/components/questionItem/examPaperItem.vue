<<<<<<< HEAD
<!--pdf试卷对应的相关信息-->
<template>
  <div class="paper-modular">
    <div class="current">
      <a href="javascript:;" class="pic pic-deft">试卷</a>
      <div class="contInfo">
        <a href="javascript:;">2022-2023学年广东省广州大学附中教育集团九年级（上）自主招生数学试卷</a>
      </div>
      <div class="contBottom">
        <div class="contBottom-Header">
          <i class="p-icon p-icon-formal"></i>
          <span class="title">考研真题</span>
        </div>
        <div class="contBottom-Bottom"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'examPaperItem'
}
</script>

<style lang="less" scoped>
.paper-modular {
  color: #5f5d5d;

  .current {
    position: relative;
    padding-left: 85px;
    margin-bottom: 20px;

    .pic {
      position: absolute;
      top: 0px;
      left: 0px;
      width: 76px;
      height: 94px;
      padding-top: 5px;
      font-weight: bold;
      text-align: center;
      background: url(../../assets/Img/questionImg/icon.png) no-repeat;
    }

    .pic-deft {
      background-position: -74px -135px;
      color: #54cb51;
    }
  }

  .contInfo {
    width: 300px;

    a {
      margin-right: 0;
      width: 100%;
      overflow: hidden;
      text-overflow: ellipsis;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      white-space: normal;
      height: 39px;
      color: #5f5d5d;
    }
  }

  .contBottom {
    .contBottom-Header {
      margin-top: 10px;
      display: flex;
      align-content: center;

      .p-icon {
        display: inline-block;
        vertical-align: middle;
        width: 14px;
        height: 16px;
        background: url(../../assets/Img/questionImg/icon.png) no-repeat;
      }

      .p-icon-formal {
        background-position: -42px 0;
        margin-right: 5px;
      }

      .title {
        height: 16px;
        line-height: 16px;
        font-size: 14px;
      }
    }
  }
}
=======
<!--pdf试卷对应的相关信息-->
<template>
  <div class="paper-modular">
    <div class="current">
      <a href="javascript:;" class="pic pic-deft">试卷</a>
      <div class="contInfo">
        <a href="javascript:;">2022-2023学年广东省广州大学附中教育集团九年级（上）自主招生数学试卷</a>
      </div>
      <div class="contBottom">
        <div class="contBottom-Header">
          <i class="p-icon p-icon-formal"></i>
          <span class="title">考研真题</span>
        </div>
        <div class="contBottom-Bottom"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'examPaperItem'
}
</script>

<style lang="less" scoped>
.paper-modular {
  color: #5f5d5d;

  .current {
    position: relative;
    padding-left: 85px;
    margin-bottom: 20px;

    .pic {
      position: absolute;
      top: 0px;
      left: 0px;
      width: 76px;
      height: 94px;
      padding-top: 5px;
      font-weight: bold;
      text-align: center;
      background: url(../../assets/Img/questionImg/icon.png) no-repeat;
    }

    .pic-deft {
      background-position: -74px -135px;
      color: #54cb51;
    }
  }

  .contInfo {
    width: 300px;

    a {
      margin-right: 0;
      width: 100%;
      overflow: hidden;
      text-overflow: ellipsis;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      white-space: normal;
      height: 39px;
      color: #5f5d5d;
    }
  }

  .contBottom {
    .contBottom-Header {
      margin-top: 10px;
      display: flex;
      align-content: center;

      .p-icon {
        display: inline-block;
        vertical-align: middle;
        width: 14px;
        height: 16px;
        background: url(../../assets/Img/questionImg/icon.png) no-repeat;
      }

      .p-icon-formal {
        background-position: -42px 0;
        margin-right: 5px;
      }

      .title {
        height: 16px;
        line-height: 16px;
        font-size: 14px;
      }
    }
  }
}
>>>>>>> 045fa486347b55144531b40db338a92cc10eb46d
</style>