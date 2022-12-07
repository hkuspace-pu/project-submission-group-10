<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Features from './components/Features.vue';
import Banner from './components/Banner.vue';
import TheHero from './components/TheHero.vue'
import TheNav from './components/TheNav.vue'
</script>

<template>
  <the-nav/>
  <!-- <header> -->
    

    <!-- <div class="wrapper"> -->
     

     <!-- <nav>  -->
        <!-- <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink> -->
      <!-- </nav> -->
 
  <!-- </header> -->
 
  <the-hero class="hero"/>
  <Features/>
  <Banner/>



<RouterView />
</template>

<style scoped>

.hero {
  position:relative;
}



@media (min-width: 1024px) {
}
</style>
