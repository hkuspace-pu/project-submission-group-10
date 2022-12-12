<template>
  <form class="newSurveyContainer">
    <label for="location">Location</label>
    <input type="text" id="location" class="input">

    <label for="date">Date</label>
    <input type="date" id="date" class="input">
    <label for="date">Tags</label>
    <input type="text" id="tags" class="input">


</form>



</template>

<script setup>

// getlocation(() => {
//     navigator.getlocation
// })


</script>

<style scoped>
.newSurveyContainer {
    display:flex;
    flex-direction: column;
    gap:20px;
    height: 200px;
    width: 400px;
    padding: 2rem;
    /* border:1px solid red; */

}

</style>