<template>
  <div class="heroContainer">
    <video type=”video/mp4” src="../assets/video/tree.mp4" muted loop autoplay/>
    <div class="heroTitle">
      <XyzTransition appear xyz="fade right delay-6">
        <img class="bird" src="../assets/images/bird.gif" />
      </XyzTransition>
      <XyzTransition appear xyz="fade left delay-9">
        <img class="bird2" src="../assets/images/bird.gif" />
      </XyzTransition>
      <XyzTransition appear xyz="fade-75 left delay-10">
        <img class="butterfly" src="../assets/images/butterfly.webp" />
      </XyzTransition>
      <XyzTransition appear xyz="fade down delay-12">
        <h1 class="">A Natural Science Survey System</h1>
      </XyzTransition>
      <!-- <img class="tree" src="../assets/images/tree.svg"/> -->
    </div>
    <XyzTransition appear xyz="fade left delay-1">
      <div class="circle c1">
        <img src="../assets/images/child_image.png" />
        <div class="shownText">Learn</div>
        <div class="hiddenText">Learn to plant</div>
        
      </div>
    </XyzTransition>
    <XyzTransition appear xyz="fade right delay-4">
      <div class="circle c2">
    
       <img src="../assets/images/adult1.png" />
         <div class="shownText">Help</div>
       <div class="hiddenText">Help Survey</div>
  
      </div>
    </XyzTransition>
    <XyzTransition appear xyz="fade right delay-6">
          <div class="circle c3">
         <img src="../assets/images/qr_code_scan.png" />
           <div class="shownText">Research</div>
       <div class="hiddenText">Tree QR Code</div>
       </div>
    </XyzTransition>
    <XyzTransition appear xyz="fade left delay-8">
         <div class="circle c4">
         <img src="../assets/images/fallen_tree.png" />
             <div class="shownText">Report</div>
                <div class="hiddenText">Report fallen tree</div>
           </div>
    </XyzTransition>
  </div>
</template>

<script setup>
import Button from "./Button.vue";
</script>



<style scoped>
.heroContainer {
  height: 100vh;
  width: 100%;
  position: relative;
  overflow: hidden;
  background-color: var(--backgroundColor);
  /* object-fit: contain; */
  /* padding: 2rem; */
}

.heroContainer video {
  object-fit: cover;
  /* z-index:-1; */
  height: 100vh;
  top: 0;
  left: 0;
  right: 0;
  width: 100%;
  /* border:1px solid red; */
}

.xyz-nested {
  position: absolute;
}
.circle {
  position: absolute;
  top: 10%;
  border: 3px solid white;
  box-shadow: rgba(0, 0, 0, 0.35) 0px 2px 5px;

  border-radius: 50%;
  width: 225px;
  height: 225px;
cursor:pointer;
  opacity: 0.9;
  transition: all 0.5s ease-in-out;
  /* padding: 30px; */
  overflow: hidden;
  text-align: center;
}

.circle img {
  object-fit: cover;
  position: relative;
  transition: all 0.2s ease-in-out;
  width: 100%;
  height: 100%;
}

.hiddenText {
  color: var(--quizBtn);
  position: absolute;
 top: 50%;
  left: 50%;
  transform: translate(-50%, -50%) scale(50%);

  transition: all 0.2s ease-in-out;
pointer-events: none;
  visibility: hidden;
  font-size: 32px;
  font-weight: 800;

}

.shownText {
  padding: 6px 12px;
  border-radius: 6px;
  background-color: var(--quizBtnTransparent);
  color:white;
  font-size: 20px;
  position : absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.circle img:hover {
  opacity: 0.3;
transform:  scale(90%);
}

.circle:hover .hiddenText {
  visibility: visible;
    transform: translate(-50%, -50%) scale(110%);
  /* transform: scale(40%); */
}

.circle:hover .shownText {
  visibility: hidden;
}


.circleShade {
  width: 100%;
  height: 100%;
  position: absolute;
  background: rgba(0, 0, 0, 0.6);
  opacity: 0;
  top: 0;
  left: 0;
}


.c1{
    top:15%;
    left: 5%;

}
.c2 {
  top: 20%;
  right: 5%;
}

.c3 {

  top: 40%;
  right: 15%;
}

.c4 {

  top: 55%;
  left: 10%;
}

.bird {
  position: absolute;
  width: 90px;
  top: 17%;
  right: 10%;
}

.bird2 {
  position: absolute;
  width: 75px;
  top: 22%;
  right: 9%;
}

.butterfly {
  position: absolute;
  width: 130px;
  transform: rotate(20deg);
  top: 22%;
  left: 9%;
}
.heroTitle {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  width: 100%;
  /* left: 0; */
  /* right: 0;
  border:1px solid red;
  z-index: 3;
  /* border:1px solid red; */
}

.heroTitle img {
  margin: 1.2rem 0;
}

p {
  position: absolute;
  bottom: 10px;
  margin: 10px;
  color: white;
}

.tree {
  height: 400px;
  /* width: 380px; */
  padding: 10px 0;
}

@media (max-width: 600px) {
  .tree {
    width: 280px;
  }

  .circle {
    width: 140px;
    height: 90px;
    border-radius:20px;
  }

  .butterfly {
    visibility: hidden;
  }
}
</style>