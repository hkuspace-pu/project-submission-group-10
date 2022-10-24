<template>

<main>
<video type=”video/mp4” src="../assets/video/tree2.mp4" muted loop autoplay/>
<p class="citation">Image courtsey canva.com</p>
</main>

</template>


<style scoped>

main {
    position:relative;
}

video {
    height: 99vh;
    width: 100%;
    object-fit:cover;
    z-index:-1;
    position:relative;
    /* clip: rect(0px, 100px, 100px, 150px); */
    /* top:100px; */
    /* object-position: bottom -200px right 20px; */
    /* object-position: center top; */
    /* margin:2rem; */
    /* opacity: 0; */
    /* color:transparent; */
    /* width: 100%; */
    /* border:2px solid red; */
    /* outline:2px solid red; */
}

p {
    position:absolute;
    bottom:10px;
    margin: 10px;
    color: white;
}

.skyline {
    position:absolute;
    bottom:20%;
    left:50%;
   width: 500px;
   height: auto;
    /* border:1px solid red; */
    z-index:1;
}
</style>