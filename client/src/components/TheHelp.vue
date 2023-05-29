<template>
    
    <div id="faq" class="faqContainer">
     
        <h2 class="dark">How to contribute</h2>


        <div class="howto">

            <div class="step">
            <img src="../assets/images/step1.png"/>
<div class=""><h3 class="dark">It's easy to register and create a account.</h3></div>

            </div>


            <div class="step">
    <img src="../assets/images/STEP2.png"/>
    <div class=""><h3 class="dark">Contribute to survey tree specimen in your neighborhood.</h3></div>

              </div>

            <div class="step">
   <img src="../assets/images/STEP3.png"/>
       <div class=""><h3 class="dark">Earn 25 points per approved survey & redeem free gifts!</h3></div>
              </div>


               <div class="step blob4">
   <img src="../assets/images/STEP4.png"/>
    <div class=""><h3 class="dark">Be proud of caring for your environment.</h3></div>
              </div>

          </div>
        

    </div>
 
</template>
    
<script setup>
import { ref } from "@vue/reactivity";


</script>
    
<style scoped>
.faqContainer {
    width: calc(100% - 1rem);
    max-width: 850px;
    padding: 5rem 0;
   margin-top:1rem;
   margin-bottom:5rem;
   margin:5rem auto;
     /* background-image: url('../assets/images/blob1.svg'); */
     /* background-color:red; */
      background-position: top center !important;
      background-repeat: no-repeat;
      background-size:contain;
      display: flex;
      flex-direction: column;

}
.title {
   font-size: calc(1.2rem + 0.8vw);
  /* border:1px solid red; */
  /* width: 100%; */
  text-align: center;
       color: var(--dark);
  margin-bottom: 2rem;
  }
  ul {
    list-style: none;
  }
  ul li {
    /* width: 100%; */
  background-color:white;
    /* justify-content: center; */
    /* border:1px solid red; */
    color: var(--dark);
     cursor: pointer;
    padding: 20px;
    margin: 15px 0;
   border: 1px solid var(--brown);
  
  }
  
  .faqTitle {
     display:flex;
    flex-direction:row;
      justify-content: space-between;
    color: var(--dark);
       font-size:16px;
  }
  
  .chevron {

      color: var(--dg2);
      margin-left: 10px;
      transition: transform .2s ease;
        transform: rotate(180deg);
  }
  
  li:hover .chevron {
    transform: rotate(270deg);
  
  }
  
  
  .faqContent {
    color: var(--darkGreen);
    font-weight: 500;
    margin: 1rem 0.5rem;
    line-height: 25px;
    border-radius:4px;
    padding: 5px;
    font-size:15px;
  
    /* background: var(--myLightGreen); */
    
  }
  
  

  
  .faqContent ul {
    margin: 0.5rem 0;
     list-style-type:disc;
  }


.howto {
  width: 100%;
  /* height: 300px; */
background-color: var(--backgroundColor);
padding: 1rem 0.5rem;
  display:flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius:20px;
  /* justify-content: space-evenly; */
}


.step {
display:flex;
flex-direction: column;
align-items: center;
justify-content: center;





}

.stepText {
padding: 10px;
 
}

.step img {
  /* max-width: 480px; */
  /* height: 300px; */
  /* max-width: 300px; */
   filter: drop-shadow(0 0.2rem 0.25rem rgba(0, 0, 0, 0.2));
}

.blob1 {
     background-image: url('../assets/images/blob1.svg');

     /* background-color:red; */
      background-position: top center !important;
      background-repeat: no-repeat;
      background-size:contain;
}

@media only screen and (max-width:800px) {
.bannerInnerContainer {
  flex-direction: column;

  justify-content: center;
  align-items: center;
}

.innerLeft img {
    max-width:300px
}

}
</style>