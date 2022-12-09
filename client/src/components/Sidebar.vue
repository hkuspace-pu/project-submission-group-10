<template>
<div class="sideBarContainer">
<div class="topBar">
   
</div>

<nav>
    <ul>
        <li class="link">
            <fa  size="2x" icon="user"/> <p>Login</p>
        </li>
        <router-link class="link" tag="li" :to="{name:'dashboard'}">
            <fa  size="2x" icon="user"/> <p>Login</p>
       </router-link>

    </ul>


</nav>

</div>


</template>


<style scoped>

.sideBarContainer {
    /* height: 100%; */
    background-color:lightblue;
    height: 1290px;
    width: 365px;
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

</style>