import Vue from 'vue'
import Router from 'vue-router'
import layout from '@/views/layout/layout';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '',
      component: layout,
      redirect: 'index',
      children: [{
        path: 'index',
        component: () => import('@/views/question/index')
      }]
    },
    {
      path: '/question',
      component: layout,
      children: [{
        path: 'detail',
        component: () => import('@/views/question/detail')
      }]
    },
    {
      path: '/question',
      component: layout,
      children: [{
        path: 'add',
        component: () => import('@/views/question/add')
      }]
    },
    {
      path: '/login',
      component: layout,
      children: [{
        path: '',
        component: () => import('@/views/login')
      }]
    }
  ]
})
