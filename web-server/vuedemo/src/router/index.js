import Vue from 'vue'
import Router from 'vue-router'
import login from '@/views/login/index'
import test from '@/views/login/test'
import index from '@/views/index/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/index',
      name: 'index',
      component: index
    }
  ]
})
