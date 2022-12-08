<template>

<div class="heroContainer">
 <div class="heroTitle">
    <XyzTransition appear xyz="fade right delay-6">
    <img class="bird" src="../assets/images/bird.gif"/>
    </XyzTransition>
    <XyzTransition appear xyz="fade left delay-9">
    <img class="bird2" src="../assets/images/bird.gif"/>
</XyzTransition>
<XyzTransition appear xyz="fade-75 left delay-10">
    <img class="butterfly" src="../assets/images/butterfly.webp"/>
    </XyzTransition>

    <h1 class="dark">Hong Kong Tree Watch</h1>
    <h2 class="dark">A natural science survey system.</h2>
    <XyzTransition appear xyz="fade down delay-2">
        <img class="tree" src="../assets/images/tree.svg"/>

    </XyzTransition>

</div> 

 </div>



</template>

<script setup>
import Button from './Button.vue';
</script>



<style scoped>

.heroContainer {
    height: 75vh;
    width: 100%;
    position:relative;
    background: url('../assets/images/sky3.png'),#F7FAFC;;
    background-size:100%;
    background-repeat: no-repeat;
    background-position: bottom;
    overflow:hidden;

    /* background: linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);  */
/* background-color: #F7FAFC; */
/* z-index:-100; */
    
    padding: 2rem;
}
.bird {
    position:absolute;
    width: 40px;
    top:17%;
    right:10%;

}

.bird2 {
    position:absolute;
    width: 75px;
    top:22%;
    right:9%;

}


.butterfly {
    position:absolute;
    width: 55px;
    transform:rotate(20deg);
    top:22%;
    left:9%;

}
.heroTitle {
    display:flex;
    flex-direction:column;
    justify-content: center;
    align-items: center;
    /* border:1px solid red; */

}

.heroTitle img {
    margin : 1.2rem 0;
}



p {
    position:absolute;
    bottom:10px;
    margin: 10px;
    color: white;
}

.tree {
    height: 400px;
    /* width: 380px; */
    padding: 10px 0;

}

@media (max-width:600px) {
   
    .tree {
        width: 280px;
    }
}
</style>