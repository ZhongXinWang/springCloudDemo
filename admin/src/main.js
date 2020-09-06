import { createApp } from 'vue'
import App from './app.vue'
import router from './router'
// 使用createApp创建一个应用，使用路由use(router)，挂载到app标签上
createApp(App).use(router).mount('#app')
