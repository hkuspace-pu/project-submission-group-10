<script setup>
import { RouterLink, RouterView } from 'vue-router'
import TheHero from './components/TheHero.vue'
import TheNav from './components/TheNav.vue'
</script>

<template>
  <!-- <header> -->
    

    <!-- <div class="wrapper"> -->
     

     <!-- <nav>  -->
        <!-- <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink> -->
      <!-- </nav> -->
 
  <!-- </header> -->
 
  <the-hero class="hero"/>
<the-nav/>



<RouterView />
</template>

<style scoped>

.hero {
  position:relative;
}



@media (min-width: 1024px) {
}
</style>
