<template>

<div class="heroContainer">
<video type=”video/mp4” src="../assets/video/tree.mp4" muted loop autoplay/>
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
    <XyzTransition appear xyz="fade down delay-2">
    <h1 class="">Hong Kong Tree Watch</h1>
    <h2 class="mark rotate">A natural science survey system.</h2>
    </XyzTransition>
        <!-- <img class="tree" src="../assets/images/tree.svg"/> -->
        <!-- <video type=”video/mp4” src="../assets/video/tree2.mp4" muted loop autoplay/> -->



</div> 

<div class="circle"></div>
<div class="circle c2"></div>
<div class="circle c3"></div>
<div class="circle c4"></div>

 </div>



</template>

<script setup>
import Button from './Button.vue';
</script>



<style scoped>

.heroContainer {
    height: 100vh;
    width: 100%;
    position:relative;
    position:relative;

    background-size:100%;
    background-repeat: no-repeat;
    background-position: bottom;
    overflow:hidden;    
    /* object-fit: contain; */
    padding: 2rem;
}

.heroContainer video {
    position: absolute;
    object-fit: cover;
    max-width: 100%;
    height:auto;
    top:0;
    left:0;
    right:0;
}


.circle {
position:absolute;
padding: 12px;
/* outline: 2px; */
border:5px solid white;
box-shadow: rgba(0, 0, 0, 0.35) 0px 2px 5px;
/* filter:drop-shadow(2px); */
border-radius: 50%;
width:225px;
height: 225px;
background-color:green;
opacity:50%;
/* z-index:99; */
    }

.c2 {
    background-image: url(../assets/images/bird.gif);
top:20%;
right:5%;
}

.c3 {
    top:30%;
right:15%;
}



.c4 {

}

.bird {
    position:absolute;
    width: 40px;
    top:17%;
    right:10%;

}

video {
      /* filter:opacity(60%); */
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
    position:absolute;
    top:0;
    left:0;
    right:0;
    /* z-index: 3; */
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