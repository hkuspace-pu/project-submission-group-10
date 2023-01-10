<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Features from '@/components/Features.vue';
import Banner from '@/components/Banner.vue';
import TheHero from '@/components/TheHero.vue'
import TheNav from '@/components/TheNav.vue'
import {useStore} from '@/stores/counter.js'
const store = useStore()
</script>

<template>
 <TheNav/>
 <!-- <div v-if="store.isSideBarOpen" class="cover"></div> -->
  <main :class="store.isSideBarOpen && 'blur'">
    
   

    <!-- <div class="cover"></div> -->

  <!-- <header> -->
    

    <!-- <div class="wrapper"> -->
     

     <!-- <nav>  -->
        <!-- <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink> -->
      <!-- </nav> -->
 
  <!-- </header> -->
 
  <TheHero/>
  <Features/>
  <Suspense>
    <template #default>
      <Banner />
    </template>
 
    <template #fallback>
      <div>Loading...</div>
    </template>
  </Suspense>



  </main>
</template>

<style scoped>


main {
  height: 100%;
  width: 100%;
  position: relative;
}

.blur {
  filter: blur(3px);
  pointer-events: none;
}
.cover {
  width: 100%;
  height: 100vh;
  filter:blur(20px);
  position: absolute;
  overflow:hidden;
  top:0;
  /* opacity: 0.1; */
  /* background-color: rgba(0,0,0,0.5); */
}

@media (min-width: 1024px) {
}
</style>