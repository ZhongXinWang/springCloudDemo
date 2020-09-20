import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
Vue.config.productionTip = false
// 引入 axios,挂载到vue的属性上面
Vue.prototype.$ajax = axios;
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
