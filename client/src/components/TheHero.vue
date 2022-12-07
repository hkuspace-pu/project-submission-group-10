<template>

<div class="heroContainer">
 <div class="heroTitle">
    <img class="bird" src="../assets/images/bird.gif"/>
    <img class="bird2" src="../assets/images/bird.gif"/>
    <img class="butterfly" src="../assets/images/butterfly.webp"/>
    <h1 class="dark">Hong Kong Tree Watch</h1>
    <h2 class="dark">A natural science survey system.</h2>
    <img width="360px" src="../assets/images/tree.svg"/>
    <h3 class="dark">Know your roots.</h3>
</div> 

 </div>



</template>


<style scoped>

.heroContainer {
    height: 75vh;
    width: 100%;
    position:relative;
    /* border-bottom:1px solid black; */
    
    /* background: linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea); W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background-color: #F7FAFC;
    
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
</style>