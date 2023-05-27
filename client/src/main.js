import { createApp } from 'vue'
import { createPinia } from 'pinia'

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'
import { StoryblokVue, apiPlugin } from '@storyblok/vue';

/* import font awesome icon component */
import { FontAwesomeIcon as fa } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faNotesMedical,faCircleUser,faChartSimple
        ,faLocationDot, faFileArrowUp, faLayerGroup, faFileCirclePlus,faChevronRight,faUsers,faNewspaper,faChevronLeft,faArrowsRotate,faTrash } from '@fortawesome/free-solid-svg-icons'
import VueAnimXyz from '@animxyz/vue3'


/* add icons to the library */

library.add(faBars,faTree,faXmark,faFilePen,faUser,faSpinner,faHouse,faCircleQuestion,faNotesMedical,faCircleUser,faChartSimple
            ,faLocationDot, faFileArrowUp, faLayerGroup, faFileCirclePlus,faChevronRight,faUsers,faNewspaper,faChevronLeft,faArrowsRotate,faTrash)

import Vue3EasyDataTable from 'vue3-easy-data-table';
import 'vue3-easy-data-table/dist/style.css';



// // const app = createApp(App);

import App from './App.vue'
import router from './router'

//STORY BLOCK STUFF
import Grid from "./components/Grid.vue";
import Page from "./components/Page.vue";
import Teaser from "./components/Teaser.vue";
import Feature from "./components/Feature.vue";


import { plugin, defaultConfig } from '@formkit/vue'
import { createProPlugin, inputs } from '@formkit/pro'
import '@formkit/themes/genesis'
import '@formkit/pro/genesis'
// import '@formkit/themes/genesis'
import './assets/main.css'
import '@animxyz/core'



const app = createApp(App)

//STORY BLOCK STUFF
app.component("Grid", Grid);
app.component("Page", Page);
app.component("Teaser", Teaser);
app.component("Feature", Feature);


const pro = createProPlugin('fk-577218191f7', inputs)
app.use(plugin, defaultConfig({ plugins: [pro] }))

app.component('fa', fa)
app.use(VueAnimXyz)
app.use(createPinia())
app.use(router)
// app.use(plugin, defaultConfig)

app.use(StoryblokVue, {
        accessToken: 'By3wbauW0r2L5NjJLSOlpwtt',
        bridge: process.env.NODE_ENV !== 'production', // optimizes by excluding the bridge on production
        use: [apiPlugin],
        apiOptions: {
                region: "us"
        }
      });

app.component('EasyDataTable', Vue3EasyDataTable);

app.mount('#app')
