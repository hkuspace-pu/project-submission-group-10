import { createApp } from '/node_modules/.vite/deps/vue.js?v=9820d562'
import { createPinia } from '/node_modules/.vite/deps/pinia.js?v=9820d562'

/* import the fontawesome core */
import { library } from '/node_modules/.vite/deps/@fortawesome_fontawesome-svg-core.js?v=9820d562'

/* import font awesome icon component */
import { FontAwesomeIcon as fa } from '/node_modules/.vite/deps/@fortawesome_vue-fontawesome.js?v=9820d562'

/* import specific icons */
import { faBars,faTree,faCircleXmark } from '/node_modules/.vite/deps/@fortawesome_free-solid-svg-icons.js?v=9820d562'
import VueAnimXyz from '/node_modules/.vite/deps/@animxyz_vue3.js?v=9820d562'

/* add icons to the library */
library.add(faBars,faTree,faCircleXmark)


import App from '/src/App.vue'
import router from '/src/router/index.js?t=1670605686325'

import '/src/assets/main.css'
import '/node_modules/@animxyz/core/dist/animxyz.css'

const app = createApp(App)
app.component('fa', fa)
app.use(VueAnimXyz)
app.use(createPinia())
app.use(router)

app.mount('#app')
