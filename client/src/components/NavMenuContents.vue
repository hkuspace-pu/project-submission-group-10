<template>

<nav>
    <ul>
     <!-- <router-link class="" tag="li" to="#"> -->
              <FormKit
      type="dropdown"
      :prefixIcon="lang"
      :options="['English','Chinese']"
      value="English"
    />
            <!-- <fa v-if="store.isSideBarOpen" size="2x" icon="user"/> <p>Language</p> -->
       <!-- </router-link> -->
        <router-link class="link" tag="li" :to="{name:'dashboard'}">
            <fa v-if="store.isSideBarOpen" size="2x" icon="user"/> <p>About</p>
       </router-link>
     <router-link class="link" tag="li" :to="{path:'/', hash:'#faq'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p>FAQ</p>
       </router-link>
       <a class="link" href="#faq">
        <li>
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p>Donate</p>
        </li>
        </a>
         <router-link class="link" tag="li" :to="{name:'login'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p class="rounded dg">Create account</p>
       </router-link>
       <router-link class="link" tag="li" :to="{name:'login'}">
            <fa v-if="store.isSideBarOpen"  size="2x" icon="user"/> <p class="rounded">Login</p>
       </router-link>

    </ul>


</nav>

</template>

<script setup>
import {useStore} from '@/stores/state.js'
const lang = '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 30"> <path d="M15 3a12 12 0 1 0 0 24 12 12 0 0 0 0-24zm0 2 1 1 1 2v2a13 13 0 0 1-4 0V8l1-2 1-1zm3 1 4 1-2 2h-1a18 18 0 0 0-1-3zm-6 0-1 1v2h-1L8 7l4-1zM7 9l2 2h1v3H5l2-5zm16 0 2 5h-5v-3h1l2-2zm-11 3a15 15 0 0 0 6 0v2h-6v-2zm-7 4h5v3H9l-2 2-2-5zm7 0h6v2h-6v-2zm8 0h5l-2 5-2-2h-1v-3zm-5 4h2v2l-1 2-1 1-1-1-1-2v-2h2zm-4 1a18 18 0 0 0 1 3l-4-1 2-2h1zm8 0h1l2 2-4 1 1-1v-2z" color="#000" font-family="sans-serif" font-weight="400" overflow="visible" style="line-height:normal;font-variant-ligatures:normal;font-variant-position:normal;font-variant-caps:normal;font-variant-numeric:normal;font-variant-alternates:normal;font-feature-settings:normal;text-indent:0;text-align:start;text-decoration-line:none;text-decoration-style:solid;text-decoration-color:#000;text-transform:none;text-orientation:mixed;white-space:normal;shape-padding:0;isolation:auto;mix-blend-mode:normal;solid-color:#000;solid-opacity:1"/></svg>'
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
    background-color: var(--blue);
    color:white;
}

.dg {
 background-color: var(--quizBtn);
}

@media (max-width: 600px) {
    ul {
        flex-direction: column;
    }
}
</style>

<style>
.formkit-outer {
    margin:0 !important;
}
</style>