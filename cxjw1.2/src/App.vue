<!-- 此处需优化:路由嵌套,标题或超链接内容使用动态加载方式 -->
<template>
  <div class="cxapp">
    <!-- 顶部导航 -->
    <ul class="main clearF top-main">
      <!-- 此处要加当前路径 -->
      <li><img src="./assets/imgs/chaoxing-logo.png"></li>
      <li>
        <!--        <router-link to="/monitor" active-class="se">运行监控</router-link>
                <router-link to="/fanya" active-class="se">泛亚管理</router-link>
                <router-link to="/user" active-class="se">用户管理</router-link>-->
        <!-- 默认选中,并设置选中的样式 -->
        <a  exact-active-class="se" >教务课程系统</a>
        <!--        <router-link to="/application" active-class="se">应用管理</router-link>
                <router-link to="/terminal" active-class="se">终端配置</router-link>
                <router-link to="/center" active-class="se">数据中心</router-link>-->
      </li>
      <li>
        <!-- img中动态引入图片地址的正确方法v-bind:src=-->
        <img :src="require(''+usericon)" alt="用户">
        <span >{{user}}</span>
        <el-button type="info" @click="logout" style="background-color: #00ffff;border: none">退出</el-button>      </li>
    </ul>
    <!-- 父组件在此渲染 -->
    <router-view></router-view>
  </div>
</template>

<script>
// 导出当前组件
export default {
  name: 'App',
  data () {
    return {
      // 动态引入图片信息
      usericon: './assets/icon/user-icon.png',
      user: localStorage.getItem('username')
    }
  },
  methods:{
    logout(){
      alert('退出成功')
      localStorage.removeItem('username')
      this.user='你还没有登录'
      this.$router.replace('/')
    }
  }

}
</script>
<style type="text/css">
/* 导航选中的样式*/
.se{
  /* 权限提升 */
  color:blue !important;
}
/* 顶部样式 */
.cxapp {
  height: 50px;
}

/* main:1250px */
.cxapp>.top-main {
  height: 50px;
  /* background-color: #EEEEEE; */
}

.cxapp>.top-main li {
  float: left;
  height: 50px;
  line-height: 50px;
}

.cxapp .top-main li:nth-of-type(1) {
  width: 260px;
}

.cxapp .top-main li:nth-of-type(1) img {
  vertical-align: middle;
}

.cxapp .top-main li:nth-of-type(2) {
  width: 750px;
  text-align: center;

  /* 看一下 */
  /* background-color: pink; */
}

.cxapp .top-main li:nth-of-type(2)>a {
  text-decoration: none;
  height: 100%;
  line-height: 50px;
  font-size: 25px;
  font-weight: bold;
  float: left;
}

.cxapp .top-main li:nth-of-type(3) {
  width: 210px;
  line-height: 50px;
  /* 左对齐 */
  text-align: right;
}

.cxapp .top-main li:nth-of-type(3) img {
  width: 18px;
  vertical-align: middle;
}

.cxapp .top-main li:nth-of-type(3) span {
  color: orangered;
  font-size: 16px;
}
</style>
<style type="text/css">
/* 侧边导航栏样式 */
.cxapp .side-main>li {
  float: left;
}
.cxapp .cxapp-sidenav {
  width: 260px;
  /* outline: 1px solid red; */
  height: 800px;
  border-top: 0px solid #eee;
}

/* 修改超链接的默认样式 */
.cxapp .cxapp-sidenav>a {
  text-decoration: none;
  padding-left: 20px;
  display: block;
  height: 70px;
  line-height: 50px;
  font-size: 20px;
  /* 文字颜色也要设置,否则会使用默认的蓝色了 */
}

.cxapp .side-main .cxapp-content {
  width: 990px;
  height: 800px;
  position: relative;
  /* outline: 1px solid red; */
}

.cxapp .side-main .cxapp-content>span {
  display: inline-block;
  width: 100%;
  height: 1px;
  background-color: #EEEEEE;
  position: absolute;
  left: 0px;
  top: 2px;
}
</style>
