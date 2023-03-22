<template>

<div class="featureContainer">
    <h2 class="mark">Features</h2>

    <div class="featureCol">

    <div class="featureCategory">
        <img src="../assets/images/knowledge.png"/>
        <h3 class="mark rotate">Knowledge</h3>

    </div>
    
    <div class="featureCategory">
        <img src="../assets/images/report.png"/>
        <h3 class="mark rotate">Report</h3>


    </div>

    <div class="featureCategory">
        <img src="../assets/images/survey.png"/>
        <h3 class="mark rotate">Survey</h3>
    </div>


    
    </div>
   

</div>
</template>


<style scoped>


.featureContainer {
    margin: 1rem 0;
    width: 100%;
    /* height: 380px; */
    padding: 2rem;
    display:flex;
    flex-direction: column;
    flex-direction: center;
    align-items: center;
    gap: 10px;
    /* overflow:hidden; */
    /* position:relative; */

}

.featureCol {
    display:flex;
    flex-direction: row;
    flex-wrap: wrap;
    height: 100%;
    width: 100%;
    gap: 1.5rem;
    justify-content: space-evenly;
    /* flex-wrap: wrap; */
}

.featureCol img {
    /* width: 100px; */
    height: 120px;
    /* width: 100px; */
    /* object-fit: contain; */
}

.featureCategory {
    display:flex;
    flex-direction: column;
    justify-content: center;
    gap:15px;
    align-items: center;

    padding: 60px;
    background-image: url('../assets/images/bottom-blob.svg');
    /* mask-image: url('../assets/images/bottom-blob.svg'); */
      background-position: top center !important;
      background-repeat: no-repeat;
      /* background-color:red; */
      background-size:cover;
      /* background-size: 400px; */
      display: flex;
      flex-direction: column;
}
</style>