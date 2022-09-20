<template>
  <div class="fotter">
    <div class="fotter-info">
      <div class="fotter-left">
        <div class="list-link">
          <h3>资源学习</h3>
          <ul>
            <li>数学资源</li>
            <li>英语资源</li>
            <li>政治资源</li>
            <li>专业课资源</li>
          </ul>
        </div>
        <div class="list-link">
          <h3>院校选择</h3>
          <ul>
            <li>985院校</li>
            <li>211院校</li>
            <li>双一流院校</li>
            <li>普通院校</li>
          </ul>
        </div>
        <div class="list-link">
          <h3>考研备考</h3>
          <ul>
            <li>考研时间</li>
            <li>报名流程</li>
            <li>考试须知</li>
            <li>考研大纲</li>
          </ul>
        </div>
        <div class="list-link">
          <h3>其他帮助</h3>
          <ul>
            <li>教师资源</li>
            <li>考研简章</li>
            <li>考研政策</li>
            <li>答疑解惑</li>
          </ul>
        </div>
        <div class="list-link">
          <h3>关于我们</h3>
          <ul>
            <li>用户须知</li>
            <li>更新日志</li>
          </ul>
        </div>
      </div>
      <div class="fotter-right">
        <h5>旭升考研网</h5>
        <div class="showinfo">
          本网站所提供的数据是往年各大院校的数据,仅供用户参考,实际信息以各高校今天展示为主
        </div>
        <div class="goto-link">
          <a href="">详细查看</a>
        </div>
      </div>
    </div>
    <div class="fotter-copy">
      <div class="copy-select">
        <router-link :to="{ name: 'webAboutIndex' }">关于我们</router-link>
        <span class="mod_copy">|</span>
        <router-link :to="{ name: 'webAboutContact' }">联系我们</router-link>
        <span class="mod_copy">|</span>
        <router-link :to="{ name: 'webAboutService' }">联系客服</router-link>
        <span class="mod_copy">|</span>
        <a href="">系统中心</a>
        <span class="mod_copy">|</span>
        <a href="">隐私中心</a>
        <span class="mod_copy">|</span>
        <a href="">友情链接</a>
        <span class="mod_copy">|</span>
        <a href="">用户帮助</a>
        <span class="mod_copy">|</span>
        <a href="">风险通知</a>
      </div>
    </div>
    <div class="fotter-auto">
      <div class="auto">
        <a href="https://yz.chsi.com.cn/" target="_blank"
          >中国研究生招生信息网</a
        >
        <a href="https://www.chsi.com.cn/" target="_blank">学信网</a>
        <a href="https://zkaoy.com/" target="_blank">青研帮</a>
        <a href="https://kaoyan.eol.cn/" target="_blank">中国教育在线</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "webFotter",
  data() {
    return {};
  },
};
</script>


<style lang="less" scoped>
.fotter {
  margin-top: 10px;
  width: 100%;
  // border-top: 1px solid #dedede;
  // background: #eaeaea;
  .fotter-info {
    display: flex;
    margin: 10px auto;
    width: 990px;
    color: #666;
    font-family: "microsoft yahei";
    .fotter-left {
      display: flex;
      .list-link {
        width: 158px;
        h3 {
          margin: 10px 0 0 8px;
          font-size: 18px;
          font-weight: normal;
          color: #666;
        }
        ul {
          margin-left: 12px;
          li {
            padding: 2px 0;
            font-size: 14px;
            color: #999999;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
          }
          li:hover {
            color: black;
          }
        }
      }
    }
    .fotter-right {
      h5 {
        margin-top: 10px;
        margin-bottom: 15px;
        font-size: 14px;
        text-align: center;
      }
      .showinfo {
        font-size: 13px;
      }
      .goto-link {
        margin-top: -7px;
        margin-right: 2px;
        text-align: right;
        a {
          font-size: 12px;
        }
      }
    }
  }
  .fotter-copy {
    margin: 0 auto;
    margin-top: 20px;
    width: 990px;
    border-top: 1px solid #dedede;

    .copy-select {
      display: flex;
      justify-content: center;
      margin: 10px 0;
      height: 24px;
      line-height: 24px;
      a {
        font-size: 12px;
        color: #666;
      }
      .mod_copy {
        padding: 0 6px;
        text-align: center;
        color: #ccc;
        font: 14px tahoma;
      }
    }
  }
  .fotter-auto {
    margin: 0 auto;
    padding-bottom: 3px;
    width: 990px;
    .auto {
      display: flex;
      justify-content: center;
      margin: 5px 0 10px 0;
      a {
        margin: 0 10px;
        font-size: 12px;
        color: #666;
      }
    }
  }
}
</style>