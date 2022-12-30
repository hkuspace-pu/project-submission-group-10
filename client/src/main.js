import { createApp } from 'vue'
import { createPinia } from 'pinia'

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon as fa } from '@fortawesome/vue-fontawesome'

/* import specific icons */
<<<<<<< HEAD
import { faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faChartPie } from '@fortawesome/free-solid-svg-icons'
import VueAnimXyz from '@animxyz/vue3'

/* add icons to the library */
library.add(faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faChartPie)
=======
import { faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faNotesMedical,faCircleUser,faChartSimple
        ,faLocationDot, faFileArrowUp, faLayerGroup, faCirclePlus } from '@fortawesome/free-solid-svg-icons'
import VueAnimXyz from '@animxyz/vue3'

/* add icons to the library */
library.add(faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faNotesMedical,faCircleUser,faChartSimple
            ,faLocationDot, faFileArrowUp, faLayerGroup, faCirclePlus)
>>>>>>> dev-simon

import Vue3EasyDataTable from 'vue3-easy-data-table';
import 'vue3-easy-data-table/dist/style.css';

// // const app = createApp(App);

import App from './App.vue'
import router from './router'

import { plugin, defaultConfig } from '@formkit/vue'
import '@formkit/themes/genesis'

import './assets/main.css'
import '@animxyz/core'

const app = createApp(App)
app.component('fa', fa)
app.use(VueAnimXyz)
app.use(createPinia())
app.use(router)
app.use(plugin, defaultConfig)


app.component('EasyDataTable', Vue3EasyDataTable);

app.mount('#app')
