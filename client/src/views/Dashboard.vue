<template>
<div class="dashboardContainer">

<DashTopBar/>

<div class="middleContainer">

    <DashSideNav/>
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
    /* border:2px solid red; */

}


.dashMiddle {
    padding: 1rem;
    background-color: #F0F0F4;
    width: 100%;
    /* border:1px solid red; */
    overflow:hidden;
    height: 100%;

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
</style>