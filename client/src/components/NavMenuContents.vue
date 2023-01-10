<template>

<nav>
    <ul>
    
        <!-- <router-link class="link" tag="li" :to="{name:'dashboard'}">
            <fa v-if="store.isSideBarOpen" size="2x" icon="user"/> <p>About Us</p>
       </router-link> -->
       <!-- <router-link class="link" tag="li" :to="{name:'dashboard'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p>Report</p>
       </router-link> -->
       <!-- <router-link class="link" tag="li" :to="{path:'/', hash:'#faq'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p>FAQ</p>
       </router-link> -->
       <a class="link" href="#faq">
        <li>
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p>FAQ</p>
        </li>
        </a>
       <router-link class="link" tag="li" :to="{name:'login'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p class="rounded">Login</p>
       </router-link>

    </ul>


</nav>

</template>

<script setup>
import {useStore} from '@/stores/counter.js'
const store = useStore()
</script>

<style scoped>

nav ul {
    display:flex;
    gap:1rem;
}
.link {
    color:grey;
    /* font-size:16px; */
    display:flex;
    flex-direction:row;
    align-items: center;
    gap:1rem;
}
 
li p {
    font-size: 20px;
}

.rounded {
    padding: 10px 25px;
    border-radius: 36px;
    background-color:black;
    color:white;
}

@media (max-width: 600px) {
    ul {
        flex-direction: column;
    }
}
</style>