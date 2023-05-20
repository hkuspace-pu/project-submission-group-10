<template>
   <nav>

<div class="logo">
  <fa size="2x" icon="tree"/>
  <span class="logo_text"><span class="hk">HK</span> Tree Watch</span>
</div>

<NavMenuContents  id="navBarContents" ></NavMenuContents>


<div @click="store.toggleOpen" class="bars">

   <fa v-if="!store.isSideBarOpen" size="lg" icon="fa-bars"/>

<fa v-else size="lg" class="close" icon="xmark"/>
</div>
 


<XyzTransition xyz="right-100% duration-1 delay-0">
    <Sidebar key="1" v-if="store.isSideBarOpen"/>
  </XyzTransition>

</nav>



</template>


<script setup>
import Sidebar from './Sidebar.vue';
import NavMenuContents from '../components/NavMenuContents.vue';
import {useStore} from '@/stores/state.js'

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
  font-size: 22px;
  display:flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  color: var(--dg2);
  gap:5px;
  /* border:1px solid red; */
}

.hk {
  font-weight: 600;
    font-size: 22px;
  color: var(--quizBtn);
}

.bars {
  padding: 15px;
  height: 55px;
  width: 55px;
  border-radius: 50%;
  display:none;
  align-items: center;
  justify-content: center;
  background-color: var(--dark);
  cursor:pointer;
  color:white;
  z-index:1001;

}

.bars label, .bars input{
  cursor: pointer;
}

input {
display:none;
}

@media (max-width: 600px) {
 
  #navBarContents {
    display:none;
  }

  .bars {
    display:flex;
  }

}



</style>