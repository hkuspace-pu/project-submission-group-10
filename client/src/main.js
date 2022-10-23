import { createApp } from 'vue'
import { createPinia } from 'pinia'

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon as fa } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faBars } from '@fortawesome/free-solid-svg-icons'

/* add icons to the library */
library.add(faBars)


import App from './App.vue'
import router from './router'

import './assets/main.css'

const app = createApp(App)
app.component('fa', fa)

app.use(createPinia())
app.use(router)

app.mount('#app')
