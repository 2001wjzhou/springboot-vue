import Vue from 'vue'
import Router from 'vue-router'
import CourseManager from '@/components/CourseManager'
import StudentManager from '@/components/StudentManager'
import StudentSelectCourse from '@/components/StudentSelectCourse'
import TeacherArrayCourse from '@/components/TeacherArrayCourse'
import TeacherManager from '@/components/TeacherManager'
import Home from '@/components/home'
// 导入教务课程应用父组件
import Jiaowu from '@/components/Jiaowu'
// 导入未完待续组件
import Tips from '@/components/Tips'

Vue.use(Router)
// 此处单独定义所有路由,主要用于测试路由组合
// 可以普通对象,也可以是数组对象(在index.js整合时数组对象前需加三个点...)
// let cm = {
//   path: '/',//根路径为默认打开方式
//   name: 'CourseManager',
//   component: CourseManager
// }
// 创建复合路由组件对象,name可以省略
let rs = [
  {
    path: '/',
    name: 'login',
    component: () => import('../components/login')
  },
  {
    path: '/monitor',
    name: 'Monitor',
    component: Tips
  },
  {
    path: '/fanya',
    name: 'Fanya',
    component: Tips
  },
  {
    path: '/user',
    name: 'User',
    component: Tips
  },
  // 教务课程应用,配置子路由;需要默认打开,设置为根路径,又其它办法吗/Jiaowu
  {
    path: '/jiaowu',
    name: 'Jiaowu',
    component: Jiaowu,
    children: [{
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/jiaowu/coursem',
      name: 'CourseManager',
      component: CourseManager
    },
    {
      path: '/jiaowu/teacherm',
      name: 'teacherm',
      component: TeacherManager
    },
    {
      path: '/jiaowu/studentm',
      name: 'StudentManager',
      component: StudentManager
    },
    {
      path: '/jiaowu/teacherac',
      name: 'TeacherArrayCourse',
      component: TeacherArrayCourse
    },
    {
      path: '/jiaowu/studentsc',
      name: 'StudentSelectCourse',
      component: StudentSelectCourse
    }
    ]
  },
  {
    path: '/application',
    name: 'Application',
    component: Tips
  },
  {
    path: '/terminal',
    name: 'Terminal',
    component: Tips
  },
  {
    path: '/center',
    name: 'Center',
    component: Tips
  }

]
export default rs
