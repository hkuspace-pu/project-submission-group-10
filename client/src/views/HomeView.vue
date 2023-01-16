<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { onMounted } from 'vue';
import Features from '@/components/Features.vue';
import Banner from '@/components/Banner.vue';
import TheHero from '@/components/TheHero.vue'
import TheNav from '@/components/TheNav.vue'
import Faq from '@/components/TheFaq.vue'
import TheFoot from '@/components/TheFoot.vue'
import {useStore} from '@/stores/state.js'
// import Btn from '@/components/Button.vue'
const store = useStore()



</script>

<template>
 <TheNav/>
 <!-- <div v-if="store.isSideBarOpen" class="cover"></div> -->
  <main :class="store.isSideBarOpen && 'blur'">
    
<!-- <btn>click me</btn> -->
 
  <TheHero/>
  <Features/>
 
   <Suspense>
    <template #default>
      <Banner />

    </template>
 
    <template #fallback>
      <div>Loading...</div>
      <!-- <Banner /> -->
      
    </template>
  </Suspense>
  <Suspense>
    <template #default>
      <Faq />

    </template>
 
    <template #fallback>
      <div>Loading...</div>
      <!-- <Faq /> -->
      
    </template>
  </Suspense>

  <TheFoot/>
  

  </main>
</template>




<style scoped>


main {
  height: 100%;
  scroll-behavior: smooth;
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