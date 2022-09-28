<!--course:template是一个占位符,不在网页中显示,其中要包含一个父元素div -->
<template>
  <div class="course-manager">
    <div class="header">
      <ul class="clearF">
        <!-- 设置元素的可操作属性v-bind:disabled -->
        <li><button :disabled="flag" @click="go()">{{info}}</button><span v-show='!flag'>&gt;{{'已删除课程信息'}}</span></li>
        <li> <input type="button" v-show='flag' @click='go()' value="已删除课程信息"> </li>
      </ul>
    </div>
    <!-- 展示管理内容 -->
    <div class="content clearF">
      <form>
        <div>
          <span>筛选条件:&ensp;</span>
          <span>{{this.shaix}}</span>
          <input type="reset" value="重置" />
        </div>
        <!-- 设置搜索条件 -->
        <div>
          <span>学期</span>
          <!-- 下拉菜单,双向绑定,dname的值是什么就默认选中谁-->
          <select name="xy" v-model="term">
            <!-- 这里也可以用空白字符 -->
            <option value="all">全部</option>
            <option value="1">第一学期</option>

          </select>
          <span>搜索</span>
          <input type="text" placeholder="请输入课程名称,编号" />
          <input type="button" @click="queryCourse()" value="筛选" />
        </div>
      </form>
      <!-- 导入课程 -->
      <div class="import-course">
        <input type="button" value="导入课程信息" />
        <span>
          <!-- 导出按钮 -->
          <a>
            <img src="../assets/icon/daochu.png" @click="exportTest">
          </a>
          <!-- 下拉菜单 -->
          <a>
            <img @click="play()" src="../assets/icon/shaix.png">
            <!-- 切换下拉 -->
            <div v-show="fg">
              <p>
                <input type="checkbox" value="qx" />&ensp;全选
                <input type="button" value="重置" />
              </p>
              <p>课程信息</p>
              <!-- 课程信息 -->
              <p>
                <input type="checkbox" checked name="ck" value="kcbh" />课程编号
                <input type="checkbox" checked name="ck" value="kcmc" />课程名称
                <input type="checkbox" checked name="ck" value="zxf" />总学时
                <input type="checkbox" name="ck" value="zf" />总分
                <input type="checkbox" name="ck" value="ssyx" />所属院系
                <input type="checkbox" name="ck" value="kclb" />课程类别
                <input type="checkbox" name="ck" value="ksfs" />考试方式
              </p>
            </div>
          </a>
        </span>
      </div>
      <!-- 显示课程信息 -->
      <table cellpadding="0" cellspacing="0" class="display-course">
        <tr>
          <th>序号</th>
          <th>姓名</th>
          <th>学号</th>
          <th>课程编号</th>
          <th>课程名称</th>
          <th>学年</th>
          <th>学期</th>
          <th>操作</th>
        </tr>
        <!-- 遍历json数组对象[{},{},{}];obj,index in cinfo -->
        <template v-for="obj in currentPageData">
          <tr>
            <td><input type="checkbox">&ensp;&ensp;{{obj.id}}</td>
            <td>{{obj.name}}</td>
            <td>{{obj.sid}}</td>
            <td>{{obj.code}}</td>
            <td>{{obj.cname}}</td>
            <td>{{obj.year}}</td>
            <td>{{obj.term}}</td>
            <td><input type="button" v-model="btnv" @click='updateCourse(obj.id,obj.status)'></td>
          </tr>
        </template>
      </table>

      当前页面：{{currentPage}}/{{totalPage}}
      <input class="btn1" type="button" value="首页" @click="firstPage" style="margin-left: 70%">
      <input class="btn1" type="button" value="上一页" @click="prevPage">
      <input class="btn1" type="button" value="下一页" @click="nextPage">
      <input class="btn1" type="button" value="尾页" @click="lastPage">

    </div>
  </div>
</template>

<!-- 导出组件文件,方便其它地方调用-->
<script>
// 导入ajax的插件,安装npm install --save axios
// 拿本机的json文件需要放到static文件夹下或通过node的require实现
// let url = "http://localhost:8080/static/json/course.json";
// let url = "../static/json/course.json";
// 外部接口,let u = "http://www.weather.com.cn/data/cityinfo/101010100.html";
// 外部接口,let l="https://api.github.com/users?since=100";
let url = 'http://localhost:8086/csgo'
export default {
  // 名称任意,可以省略
  name: 'CourseManager',
  data () {
    return {
      info: '课程信息表管理',
      shaix: '学期',
      flag: true,
      fg: false,
      cinfo: 'yhc',
      // 默认查文学院
      term: 'all',
      // 到方法中切换按钮的文字
      btnv: '删除',

      // 分页的变量
      totalPage: 1, // 统共页数，默认为1
      currentPage: 1, // 当前页数 ，默认为1
      pageSize: 5, // 每页显示数量
      currentPageData: [], // 当前页显示内容
      headPage: 1
    }
  },
  // 方法
  methods: {
    // 显示/隐藏已删按钮
    go: function () {
      this.flag = !this.flag
      this.currentPage = 1
      // 调用另一查询函数,一定要加this
      this.queryCourse()
    },
    // 切换下拉菜单
    play: function () {
      this.fg = !this.fg
    },
    // 按条件查询
    queryCourse: function () {
      this.btnv = this.flag ? '删除' : '恢复'
      // 此处在main.js中全局导入了axios,$axios为自定义的全局原型对象
      this.$axios.get(url, {
        // 给后端传键值对或json字符串
        params: {
          term: this.term,
          status: this.flag ? 1 : 2
        }
      }).then(resp => {
        this.cinfo = resp.data
        console.log(this.cinfo.length)
        /* 分页总数计算 */
        this.totalPage = Math.ceil(this.cinfo.length / this.pageSize)
        this.totalPage = this.totalPage === 0 ? 1 : this.totalPage
        this.getCurrentPageData()
        console.log(this.cinfo)
      }).catch(error => {
        console.log('有误:' + error)
      })
    },
    // 逻辑删除数据
    updateCourse: function (id, status) {
      this.$axios.get('http://localhost:8086/update', {
        // 给后端传键值对或json字符串
        params: {
          id,
          status
        }
      }).then(resp => {
        if (resp.data !== '') {
          // eslint-disable-next-line no-unused-expressions,no-sequences
          alert(this.btnv + '成功'), this.queryCourse()
        }
      })
    },
    getCurrentPageData () {
      let begin = (this.currentPage - 1) * this.pageSize
      let end = this.currentPage * this.pageSize
      this.currentPageData = this.cinfo.slice(
        begin,
        end
      )
    },
    // 上一页
    prevPage () {
      if (this.currentPage === 1) {
        alert('已经是第一页了')
        return false
      } else {
        this.currentPage--
        this.getCurrentPageData()
      }
    },
    // 下一页
    nextPage () {
      if (this.currentPage === this.totalPage) {
        alert('已经是最后一页了')
        return false
      } else {
        this.currentPage++
        this.getCurrentPageData()
      }
    },
    // 尾页
    lastPage () {
      if (this.currentPage === this.totalPage) {
        return false
      } else {
        this.currentPage = this.totalPage
        this.getCurrentPageData()
      }
    },
    // 首页
    firstPage () {
      // eslint-disable-next-line no-unused-expressions
      this.currentPage = this.headPage
      this.getCurrentPageData()
    },
    exportTest () {
      alert('导出')
    }
  }
  // 批量恢复与删除传参方式idst:'{"ids":[{"id":1001},{"id":1002}],"status":2}'
  /// the end
}
</script>

<style>

.course-manager>.header {
  width: 100%;
  height: 54px;
  /* background-color: pink; */
}

.course-manager>.header>ul>li:nth-of-type(1) {
  float: left;
  height: 54px;
  line-height: 54px;
  font-size: 16px;
  padding-left: 20px;
}

.course-manager>.header>ul>li:nth-of-type(1)>button {
  border: none;
  outline: medium;
  font-size: 16px;
  color: black;
  width: 120px;
  height: 30px;
  cursor: pointer;
  background-color: white;
}

.course-manager>.header>ul>li:nth-of-type(2) {
  float: right;
  height: 54px;
  line-height: 54px;
  padding-right: 20px;
}

.course-manager>.header>ul>li:nth-of-type(2)>input {
  width: 120px;
  height: 30px;
  border: 1px solid blue;
  outline: medium;
  cursor: pointer;
  color: blue;
  font-size: 14px;
}
</style>
<!-- 选课内容的样式 -->
<style type="text/css">
.course-manager .content {
  background-color: #DDDDDD;
  /* 上左右留白 */
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 8px;
  height: 800px;
}

.course-manager .content form div:nth-of-type(1) {
  height: 50px;
  background-color: #EEEEEE;
  padding: 0 10px;
  line-height: 50px;
  position: relative;
  background-color: #EEEEEE;
}

/* 表单中元素的样式 */
.course-manager .content form div:nth-of-type(1)>span:nth-of-type(1) {
  font-weight: bold;
}

.course-manager .content form div:nth-of-type(1)>input {
  border: 1px solid blue;
  outline: medium;
  width: 46px;
  height: 20px;
  font-size: 12px;
  position: absolute;
  right: 10px;
  top: 15px;
  cursor: pointer;
}

/* 搜索栏样式 */
.course-manager .content form div:nth-of-type(2) {
  background-color: white;
  height: 60px;
  line-height: 60px;
  padding: 0px 10px;
  font-size: 14px;
}

.course-manager .content form div:nth-of-type(2)>select {
  width: 100px;
  height: 20px;
  vertical-align: middle;
  font-size: 12px;
}

.course-manager .content form div:nth-of-type(2)>input[type=text] {
  width: 200px;
  height: 20px;
  vertical-align: middle;
}

.course-manager .content form div:nth-of-type(2)>input[type=button] {
  width: 60px;
  height: 26px;
  border: 1px solid blue;
  outline: medium;
  background-color: white;
  color: blue;
  font-size: 14px;
  cursor: pointer;
  margin-left: 20px;
}

.course-manager .content .import-course {
  padding: 0px 10px;
  height: 70px;
  line-height: 70px;
  background-color: white;
  /* outline: 1px solid red; */
}

.course-manager .content .import-course>input {
  border: none;
  outline: medium;
  background-color: #0099FF;
  color: white;
  font-size: 12px;
  width: 80px;
  height: 30px;
  cursor: pointer;
  /* 添加圆解 */
  border-radius: 4px;
  float: left;
  margin-top: 20px;
}

/* 任何元素浮动过后,脱离原来位置,自动转换成为行内块元素 */
.course-manager .content .import-course>span {
  float: right;
  width: 90px;
  height: 30px;
  line-height: 30px;
  /* outline: 1px solid blue; */
  margin-top: 20px;
  text-align: center;
}

.course-manager .content .import-course>span>a {
  margin-left: 16px;
}

.course-manager .content .import-course>span>a>img {
  width: 14px;
  outline: 1px solid #ccc;
  line-height: 30px;
  cursor: pointer;
}

/* 下拉菜单的样式 */
.course-manager .content .import-course>span>a:nth-of-type(2) {
  /* outline: 1px solid red; */
  /* 添加定位 */
  position: relative;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div {
  width: 360px;
  height: 200px;
  /* 将盒子转成边框盒子,不会被padding撑大 */
  box-sizing: border-box;
  background-color: white;
  text-align: left;
  /* padding: 0px 10px; */
  position: absolute;
  top: 35px;
  right: -23px;
  border-top: 1px solid #CCCCCC;
  border-left: 1px solid #CCCCCC;
  border-bottom: 1px solid #CCCCCC;
  /* 先藏起来 */
  /* display: none; */
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(1) {
  border-bottom: 1px solid #EEEEEE;
  padding-left: 10px;
  height: 30px;
  line-height: 30px;
  /* outline: 1px solid red; */
  font-size: 10px;
  position: relative;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(1)>input {
  vertical-align: middle;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(1)>input[type=button] {
  position: absolute;
  right: 0px;
  border: none;
  outline: medium;
  width: 60px;
  height: 30px;
  cursor: pointer;
  color: #0099FF;
  background: white;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(2) {
  color: black;
  padding-left: 10px;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(3) {
  padding: 0px 10px;
}

.course-manager .content .import-course>span>a:nth-of-type(2)>div>p:nth-of-type(3)>input {
  width: 20px;
  /* margin-right: 10px; */

}
</style>
<!-- 课程信息的样式 -->
<style type="text/css">
.course-manager .content .display-course {
  padding: 0px 10px;
  width: 100%;
  background-color: white;
  text-align: center;
  font-size: 14px;
}

input {
  vertical-align: middle;
}

/* 表格标题行样式 */
.course-manager .content .display-course tr:nth-of-type(1) {
  background-color: #EEEEEE;
  height: 40px;
}

/* 单元格底部线 */
.course-manager .content .display-course td {
  height: 36px;
  border-bottom: 1px solid #ddd;
  font-size: 12px;
  color: #808080;
}

/* 设置表格两边线 */
td:first-of-type,
th:first-of-type {
  border-left: 1px solid #ddd;
}

td:last-of-type,
th:last-of-type {
  border-right: 1px solid #ddd;
}

.display-course tr td input[type=button] {
  border: none;
  outline: medium;
  color: #0099FF;
  width: 40px;
  height: 30px;
  background: white;
  cursor: pointer;
}
</style>
