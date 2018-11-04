// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'

import '@/permission'

import '../static/layui/css/layui.css'
import '../static/global.css'
import '../static/layui/css/modules/layer/default/layer.css'

Vue.config.productionTip = false

layui.config({
  version: "1.0.0",
  base: "/static/fly/mods/"
}).extend({
  fly: 'index'
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
