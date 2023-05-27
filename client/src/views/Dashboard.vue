<template>
<div class="dashboardContainer">

<DashTopBar/>

<div class="middleContainer">

    <DashSideNav class="dash"></DashSideNav>
    
    <div class="dashMiddle">
        <div class="dashMenu">
       <div class="title"> {{$route.meta.title}}</div>
       <div class="dashIcons">
       <div @click="refreshData"  class="refresh"><fa size="lg" :spin="store.surveyLoading" icon="arrows-rotate"/></div>
       <fa @click="store.deleteSurvey()" v-if="store.surveyItemsSelected.length"  size="lg" icon="trash"/>
        </div>
        </div>
        <div class="dashMiddleBox">
            <!-- <router-view :key="$route.fullPath"></router-view> -->
            <router-view ></router-view>

        </div>
    </div>
</div>


</div>


</template>



<script setup>

import {onMounted} from 'vue';
import DashSideNav from '../components/DashSideNav.vue';
import DashTopBar from '../components/DashTopBar.vue';
import { useStore } from "@/stores/state.js";
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const store = useStore();





onMounted(() => {
    console.log('CHECKING IF USER IS LOGGED IN')
  if (!store.getUserInfo) {
    router.push({name: 'login'})
  }



});


const refreshData = async () => {
    console.log("Refreshing DAta")
    store.surveyData = []
await store.getSurvey()
}

</script>


<style scoped>


.dashboardContainer {
height: 100vh;
/* height: 100%; */
width: 100%;
/* overflow: hidden; */

}

.middleContainer {
    height: calc(100% - 65px);
    /* height: 100%; */
    display:flex;
    flex-direction: row;
}
.dash {
    /* border:1px solid red; */
    order:1;

}


.dashMiddle {
    padding: 1rem;
    background-color: #F0F0F4;
    width: 100%;
    /* border:1px solid red; */
    overflow:hidden;
    height: 100%;
    order:1;

}

.dashMenu {
    display:flex;
    flex-direction: row;
    justify-content: space-between;
}

.dashIcons {
    color: var(--dg2);
    display:flex;
    flex-direction: row;
    gap:2rem;
}
.title {
    font-size: 20px;
    margin-bottom:1rem;
}

.dashMiddleBox {
    border-radius: 12px;
    /* overflow:hidden; */

    background-color: #fefefe;
    height: calc( 100% - 25px);
    /* height: 100px; */
    width: 100%;
    overflow:hidden;
    /* overflow:scroll; */
    box-shadow: 10px 10px 12px -12px rgba(0,0,0,0.25);
}

@media only screen and (max-width:600px) {

    .middleContainer {
        flex-direction: column;
    }

    .dash {
        order:3;
      
    }

    .dashMiddle {
        padding: 5px;
    }
    
}
</style>