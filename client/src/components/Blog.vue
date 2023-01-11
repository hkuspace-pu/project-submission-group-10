<template>

<div class="cmsContainer">


<h3 class="dark"><em>This is the blog demo. Only Admins & Moderators can edit the blog directly here, and it will appear on the home page for the general public </em></h3>

<Suspense>
    <template #default>
      <Banner />

    </template>
 
    <template #fallback>
      <img src="../assets/svgloading.svg">  
    </template>
  </Suspense>


  <Suspense>
    <template #default>
      <Faq />

    </template>
 
    <template #fallback>
      <img src="../assets/svgloading.svg">    
    </template>
  </Suspense>

</div>
</template>


<script setup>
import Banner from './Banner.vue';
import Faq from './TheFaq.vue';

</script>

<style scoped>

.cmsContainer {
    height: 100%;
    overflow-y:auto;
    /* border:1px solid red; */
}
</style>