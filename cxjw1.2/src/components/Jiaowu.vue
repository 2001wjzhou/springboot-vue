<!-- 教务课程序应用组件;请优化各子模块 -->
<template>
  <div>
      <!-- 侧边栏设置与路由切换,样式到App.vue中统一设置 -->
    <ul class="main side-main clearF">
      <li class="cxapp-sidenav">
        <!-- 侧边栏导般a,此处如果为/为默认打开的路径设置与样式 -->
        <!-- 默认打一个主页 -->
        <router-link to="/" style="display: none;"></router-link>
        <router-link  to="/jiaowu/coursem" active-class="cc">课程信息表管理</router-link>
        <!-- 被选中的样式 -->
<!--
        <router-link to="/jiaowu/teacherm" active-class="cc">教师信息表管理</router-link>
-->
        <router-link to="/jiaowu/studentm" active-class="cc">学生信息表管理</router-link>
<!--
        <router-link to="/jiaowu/teacherac" active-class="cc">教师排课表管理</router-link>
-->
        <router-link to="/jiaowu/studentsc" active-class="cc">学生选排课管理</router-link>
      </li>
      <!-- 点击超链后切换的部分,样式到App.vue中设置 -->
      <li class="cxapp-content">
        <!-- 画线用的 -->
        <span></span>
        <!-- 组件在此渲染,样式到App.vue中设置 -->
        <router-view></router-view>
      </li>
    </ul>
  </div>
</template>

<script>
// 为导出当前组件
export default {
  name: '你还没有登录'
}
</script>
<style type="text/css">
  /* 选中后的样式 */
  .cc {
    background-color: aliceblue;
    color: blue;
  }
/* 侧边导航栏,样式到App.vue中统一设置 */
</style>
