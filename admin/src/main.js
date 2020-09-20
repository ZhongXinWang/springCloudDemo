import { createApp } from 'vue'
import App from './app.vue'
import router from './router'
import axios from 'axios'
// 使用createApp创建一个应用，使用路由use(router)，挂载到app标签上
let config = {
    // baseURL: process.env.baseURL || process.env.apiUrl || ""
    // timeout: 60 * 1000, // Timeout
    // withCredentials: true, // Check cross-site Access-Control
};
const ajax = axios.create(config);
createApp(App,{$ajax:axios}).use(router).mount('#app')
