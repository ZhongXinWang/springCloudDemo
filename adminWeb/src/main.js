import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios, {AxiosRequestConfig} from 'axios'
Vue.config.productionTip = false
// 引入 axios,挂载到vue的属性上面
Vue.prototype.$ajax = axios;
// axios  请求拦截
axios.interceptors.request.use(request=>{
  console.log("请求URL:"+request.url);
  console.log("请求参数:"+request.data);
  return request;
},error => {
  console.error("请求错误"+error)
  return Promise.reject(error)
});

axios.interceptors.response.use(response =>{
  console.log("状态码:"+response.status)
  return response;
},error => {
  console.error("返回错误:"+error)
  return Promise.reject(error)
});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
