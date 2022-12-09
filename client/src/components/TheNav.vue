<template>
   <nav>

<div class="logo">
  <fa size="2x" icon="tree"/>
  
</div>

<div @click="store.toggleOpen" class="bars">
 
<fa v-if="!store.isSideBarOpen" size="lg" class="showBar" icon="fa-bars"/>

<fa v-else size="lg" class="close" icon="xmark"/>
</div>


<XyzTransition xyz="right-100% duration-1 delay-0">
    <Sidebar key="1" v-if="store.isSideBarOpen"/>
  </XyzTransition>

</nav>



</template>


<script setup>
import Sidebar from './Sidebar.vue';
import {useStore} from '@/stores/counter.js'

const store = useStore()

</script>


<style scoped>

    nav {
      /* background-color: #F7FAFC; */
  /* max-width: 1280px; */
  margin: 1rem 0.72rem;
  /* padding: 0 1rem; */
  /* position:absolute; */
  top:0;
  left:0;
  right:0;
  height: 65px;
  /* width: 100%; */
  display:flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  font-size:22px;
  z-index:90001;
  /* position: relative; */
 /* border:1px solid red; */
  /* background-color:white; */
  /* background-color: #B2D1BD; */
}


.logo {
  font-size: 15px;
  font-weight: 600;
}

.bars {
  padding: 10px;
  height: 55px;
  width: 55px;
  border-radius: 50%;
  background-color: var(--dark);
  display:flex;
  justify-content: center;
align-items: center;
  cursor:pointer;
  color:white;
  z-index:1001;
  /* margin: auto; */
  /* border:1px solid red; */
}

.bars label, .bars input{
  cursor: pointer;
}

input {
display:none;
}



.bars {
  /* display:none; */
}






</style>