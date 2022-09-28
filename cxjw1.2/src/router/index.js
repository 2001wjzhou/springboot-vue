import Vue from 'vue'
import Router from 'vue-router'
// 导入其它的路由组件文件,如果导入的是数组对象,拼接到当前路由中时
// 别名对象前都要加...,比如...rs,如果是普通对象,则不能加
import rs from './allrouter.js'
// 导入自定义的组件,取个别名,名称可以任意,可以省略扩展名
import StudentManager from '@/components/StudentManager'
// 将路由对象绑定到vue对象上
Vue.use(Router)
// 导出路由对象
export default new Router({
  // 如果是组合数组,则要用到es6整合数组的方式,当cour是数组对象时前加必须加三个.圆点
  // 这里也可以[...rs]
  routes: rs
})
// index.js文件为默认导出文件名,如果是其它文件名需全名引入
