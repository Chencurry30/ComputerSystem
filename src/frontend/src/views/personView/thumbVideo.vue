<template>
  <div class="MainBox w">
    <div class="containBox">
      <personAside></personAside>
      <div class="contain-right">
        <div class="showBox">

          <div class="allBox">
            <personHeader></personHeader>
            <div class="allBox">
              <div class="UserBox first">
                <ul class="videoList">
                  <li class="videoItem">
                    <div class="videoImg">
                      <img src="" alt="" />
                    </div>
                    <div class="videoInfo">qwe</div>
                    <div class="thumbtime">
                      <span>收藏于</span>
                      <span></span>
                    </div>
                  </li>
                  <li class="videoItem">
                    <div class="videoImg">
                      <img src="" alt="" />
                    </div>
                    <div class="videoInfo">qwe</div>
                    <div class="thumbtime">
                      <span>收藏于</span>
                      <span></span>
                    </div>
                  </li>
                  <li class="videoItem">
                    <div class="videoImg">
                      <img src="" alt="" />
                    </div>
                    <div class="videoInfo">qwe</div>
                    <div class="thumbtime">
                      <span>收藏于</span>
                      <span></span>
                    </div>
                  </li>
                  <li class="videoItem">
                    <div class="videoImg">
                      <img src="" alt="" />
                    </div>
                    <div class="videoInfo">qwe</div>
                    <div class="thumbtime">
                      <span>收藏于</span>
                      <span></span>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import personAside from '../../components/personCenter/personAside'
import personHeader from '../../components/personCenter/personHeader'
export default {
  name: "thumbVideo",
  components:{
    personAside,personHeader
  }
};
</script>

<style lang='less' scoped>
.MainBox {
  margin-top: 15px;

  .containBox {
    margin-top: 5px;
    display: flex;


    .contain-right {
      flex: 3;
    }
  }
}
.allBox {
  .first {
    margin-top: 15px;
  }

  .UserBox {
    border-radius: 10px;
    color: #666;
    border: 2px solid #eee;

    .videoList {
      margin-bottom: 0;
      padding: 5px 0px;
      height: 320px;

      .videoItem {
        float: left;
        margin: 0px 2px;
        width: 194px;
        height: 160px;

        .videoImg {
          width: 190px;
          margin: 0px 2px;
          height: 120px;
          background: blue;
        }

        .videoInfo,
        .thumbtime {
          height: 20px;
          line-height: 20px;
          font-size: 14px;
          color: #666;
        }
      }
    }
  }
}
</style>