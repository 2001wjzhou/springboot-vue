// 此文件为程序的主文件,用于启动程序,并挂载网页元素,加载路由,公共组件
import Vue from 'vue'
import App from './App.vue'

// 导入了axios
import axios from 'axios'
// 导入路由,取个别名为rt,也可以是router
// 默认导入此文夹中的文件名为index.js,其它文件名需指定全名ind.js
import rt from './router'
// main.js中引入ElementUI

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

const bus = new Vue()
Vue.prototype.$bus = bus

Vue.use(ElementUI)
// 全局配置生产环境中不需要提示信息
Vue.config.productionTip = false
// 创建一个自定义的全局的axios对象
Vue.prototype.$axios = axios
// 创建根实例并加载路由与组件,根元素
// eslint-disable-next-line no-new
new Vue({
  el: '#app',
  // 此处可以简写
  router: rt,
  // 挂载组件
  components: {
    App

  },
  // 设置一个公共组件模块中的元素名
  template: '<App/>'
})
