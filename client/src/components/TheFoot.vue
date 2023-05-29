<template>
<div class="footContainer">

    <div class="footerText">
        2023 HK TREE WATCH
    </div>
    <ul class="footCrumbs">
        <li>
            • Sitemap 
        </li>
        <router-link tag="li" :to="{name:'privacy'}">• Privacy Policy</router-link> 
        <li>
            <a href="mailto:info@hktreewatch.org">• Contact us</a>
        </li>
    </ul>
      

</div>


</template>



<style scoped>
.footContainer {
    /* margin-top:120px; */
    width: 100%;
    height: 160px;
    background-color: var(--dg2);
    display:flex;
    color:white;
    display:flex;
    flex-direction: column;
    align-items: center;
    font-weight: 300;
    justify-content: center;
    font-size: 14px;
}

.footerText {
    margin-bottom:1rem;
    
}

.footCrumbs {
    display:flex;
    gap:10px;
}
</style>