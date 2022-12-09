<template>
<div class="dashboardContainer">

<DashTopBar/>

<div class="middleContainer">

    <DashSideNav/>
    <div class="dashMiddle">
     <router-view :key="$route.fullPath"></router-view>
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

}

.middleContainer {
    height: calc(100% - 65px);
    display:flex;
    flex-direction: row;
    /* border:2px solid red; */

}


.dashMiddle {
    padding: 3rem 1rem 1rem 1rem;
    /* padding-top:2rem; */
    /* border:1px solid green; */
    background-color: #F0F0F4;
    width: 100%;
}
</style>