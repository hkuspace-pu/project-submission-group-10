<template>
  <form class="newSurveyContainer">
    <label for="location">Location</label>
    <input type="text" id="location" class="input">

    <label for="date">Date</label>
    <input type="date" id="date" class="input">
    <label for="date">Tags</label>
    <input type="text" id="tags" class="input">

    <Multiselect
      v-model="selected"
      :options="options"
      :multiple="true"
      :taggable="true"
      >
    </Multiselect>

    <FormKit type="form" @submit="submitHandler">
    <FormKit type="text" label="Name" name="name" help="wererer" placeholder="sdfsdf" />
    <FormKit type="email" label="Email" name="email" />
  </FormKit>

</form>



</template>

<script setup>
import { ref } from 'vue';
import Multiselect from 'vue-multiselect'
// import { plugin, defaultConfig } from '@formkit/vue'
import "vue-multiselect/dist/vue-multiselect.css"

const selected = ref(null);
const options = ref(['Stone Wall', 'Dead', 'Alive']);


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