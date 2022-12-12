<template>
<div class="sideBarContainer">
<div class="topBar">
   
</div>

<NavMenuContents/>



</div>


</template>

<script setup>
import NavMenuContents from '@/components/NavMenuContents.vue'
</script>

<style scoped>

.sideBarContainer {
    /* height: 100%; */
    background-color:lightblue;
    height: 1290px;
    width: 365px;
    max-width: 99%;
    /* background-color:white; */
    position :fixed;
    right:0;
    top:0;
    bottom:0;
    padding:1rem;
    right:0;
    z-index:1000;
    /* top:5px */
    box-shadow: 4px 0 10px 0 rgb(0 0 0 / 40%);
}

.topBar  {
   height: 65px;
}



</style>