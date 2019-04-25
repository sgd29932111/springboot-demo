// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index'
import $ from 'jquery'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import Axios from "axios";

Vue.config.productionTip = false
Vue.prototype.$axios = Axios;

/* eslint-disable no-new */
new Vue({
  router,$,
  render: h => h(App)
}).$mount('#app');
