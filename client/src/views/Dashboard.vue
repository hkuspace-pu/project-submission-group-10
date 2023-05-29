<template>
<div class="dashboardContainer">

<DashTopBar/>

<div class="middleContainer">

    <DashSideNav class="dash"></DashSideNav>
    
    <div class="dashMiddle">
        <div class="dashMenu">
       <div class="title"> {{$route.meta.title}}</div>
       <div class="dashIcons">
       <div @click="refreshData" v-if="$route.path == '/dash' && !store.surveyItemsSelected.length" class="refresh"><fa size="2x" :spin="store.surveyLoading" icon="arrows-rotate"/></div>
       <fa @click="store.deleteSurvey()" v-if="store.surveyItemsSelected.length && $route.path == '/dash'"  size="2x" icon="trash"/>
       <fa @click="store.approveSurvey(undefined,9)" style="color:var(--accept)" v-if="store.surveyItemsSelected.length && $route.path == '/dash' && isAdmin"  size="2x" icon="thumbs-up"/>
        <fa @click="store.approveSurvey(undefined,2)" style="color:var(--warning)" v-if="store.surveyItemsSelected.length && $route.path == '/dash' && isAdmin"  size="2x" icon="thumbs-down"/>
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

import {onMounted,computed, reactive} from 'vue';
import DashSideNav from '../components/DashSideNav.vue';
import DashTopBar from '../components/DashTopBar.vue';
import { useStore } from "@/stores/state.js";
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const store = useStore();


const isAdmin = computed(() =>{
    if (store.getUserInfo[0].role == 4) {
        return true
    } else {
        return false
    }
})


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
    align-items: center; 
    margin: 0.5rem;
}

.dashIcons {
    color: var(--dg2);
    display:flex;
    flex-direction: row;
    gap:2rem;
    padding: 10px 15px;
    border-radius: 4px;
    cursor: pointer;
    border:1px solid red;
    background: rgba(255, 255, 255, 0.2);
border-radius: 16px;
box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
backdrop-filter: blur(5px);
-webkit-backdrop-filter: blur(5px);
border: 1px solid rgba(255, 255, 255, 0.3);
}

.title {
    font-size: 20px;
    /* margin-bottom:1rem; */
}

.dashMiddleBox {
    border-radius: 12px;
    /* overflow:hidden; */

    background-color: #fefefe;
    height: calc( 100% - 65px);
    /* height: 100px; */
    width: 100%;
    overflow-x:hidden;
/* overflow:hidden; */
    overflow-y:auto;
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