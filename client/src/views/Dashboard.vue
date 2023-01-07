<template>
<div class="dashboardContainer">

<DashTopBar/>

<div class="middleContainer">

    <DashSideNav class="dash"></DashSideNav>
    
    <div class="dashMiddle">
        {{$route.meta.title}}
        <div class="dashMiddleBox">
            <!-- <router-view :key="$route.fullPath"></router-view> -->
            <router-view ></router-view>

        </div>
    </div>
</div>


</div>


</template>



<script setup>
import DashSideNav from '../components/DashSideNav.vue';
import DashTopBar from '../components/DashTopBar.vue';




</script>


<style scoped>


.dashboardContainer {
height: 100vh;
width: 100%;
/* overflow: hidden; */

}

.middleContainer {
    height: calc(100% - 65px);
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