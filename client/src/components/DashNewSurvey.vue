<template>

<div class="formContainer">
  <!-- :submit-label="button_label" -->
  <!-- <FormKit  @submit="submit" type="form" #default="{ value }" >  -->

    <FormKit
  type="form"
  #default="{ value}"
  @submit="submit"
  :actions="false"
>


  <div class="form-body">
   
    <XyzTransition key="1" class="item-group" xyz="fade up-100% out-up" mode="out-in">
    <section v-show="step == 1">
    <FormKit type="group" name="locationInfo">
       
      <FormKit type="text"
      prefixIcon="flag"
      label="*Tree location"
      help="The location within 10 meters of the tree species."
      validation="required|length:10"
    />

    <FormKit
  type="date"
  value="2021-01-01"
  prefixIcon="Date of survey"
  label="date"
  help="Enter the date of the survey"
  validation="required"
  validation-visibility="live"
/>

    </FormKit>
    </section>
    </XyzTransition>

    <XyzTransition key="2" class="item-group" xyz="fade up-100% out-up" mode="out-in">
    <section v-show="step == 2">

    <FormKit type="group" name="BasicTreeInfo">

    <FormKit
      type="autocomplete"
      name="commonName"
      prefixIcon="search"
      suffixIcon="info"
      label="Common name"
      validation="required"
      placeholder="Example: Mango tree"
      :options="commonName"
    />

    </FormKit>
    </section>
    </XyzTransition>

    <XyzTransition key="3" class="item-group" xyz="fade up-100% out-up" mode="out-in">
<section v-show="step == 3">
<FormKit type="group" name="Attributes">
    <FormKit
  type="number"
  help="Estimate the tree height in meters."
  label="Height (meters)"
  name="height"
  suffixIcon="info"
  value="25"
  step="1"
/>

<FormKit
  type="number"
  help="Crown spread."
  label="Crown spread width (meters)"
  name="crown"
  suffixIcon="info"
  value="25"
  step="1"
/>
</FormKit>
</section>
</XyzTransition>


<XyzTransition key="4" class="item-group" xyz="fade up-100% out-up" mode="out-in">
<section v-show="step == 4">
<FormKit type="group" name="health">
<FormKit
  type="rating"
  name="health"  
 
  min="1"
  step="0.5"
  rating-icon="heart"
  on-color="#DA012D"
  max="5"
  id="health"
  label="Rate the overall health of the tree"
/>
<div>

</div>

  
<FormKit
      type="taglist"
      name="tree_tags"
      label="Search for tags that describe the tree"
      prefixIcon="search"
      :options="treeTags"
     
    />
</FormKit>
</section>
</XyzTransition>







<XyzTransition key="5" class="item-group" xyz="fade up-100% out-up" mode="out-in">
<section v-show="step == 5">
<FormKit
  type="file"
  label="Add  media"
  accept=".jpg,.mov.,.mp4.,png"
  help="Add images or video"
  multiple
/>
</section>
</XyzTransition>




    <!-- <details>
      <summary>Form data</summary>
      <pre>{{ value }}</pre>
    </details> -->
  </div>
  <div class="step-nav">
      <FormKit type="button" :disabled="step == 1" @click="step--" v-text="'Previous step'" />
      <FormKit v-if="step <5" type="button" class="next" :disabled="step == 5 " @click="step++" v-text="nextText"/>
      <FormKit v-else type="submit" label="Submit Application" />
    </div>
 
</FormKit>

</div>


</template>

<script setup>
import { ref,reactive,computed } from 'vue';

// import AddressAutocomplete from 'vue-google-maps-address-autocomplete';
const step = ref(1);
const commonName = ref(['Fig tree (无花果树)', 'Gingko tree (银杏树)']);
const treeTags = ref(['Stone wall', 'Old & valuable','Juvenile (sapling)','Mature', ])
const selected = ref(null);
const options = ref(['Stone Wall', 'Dead', 'Alive']);
const stepNames = reactive(['locationInfo', 'basicInfo', 'advancedInfo'])
// const address = reactive({ streetName, streetNumber, zipCode, city })

// const nextText = 'asdasd';
const button_label = computed(() => {
  return (step.value != 4) ? 'Next' : 'Submit'
})

const nextText = computed(() => {
  switch (step.value) {
    case 1:
      return 'Next (Identification)'
      case 2:
      return 'Next (Attributes)'
      case 3:
      return 'Next (Health)'
      case 4:
      return 'Next (Media)'
  
    default:
    return 'Next'
  
  }
})


// getlocation(() => {
//     navigator.getlocation
// })

const submit = async (fields) => {
  console.log(step)
  if (step.value == 4) {
      await new Promise((r) => setTimeout(r, 1000))
  alert(JSON.stringify(fields))
  step.value = 1;
  } else {
     step.value++
  }

}

</script>

<!-- <script async src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places&callback=initMap"></script> -->

<style scoped>


.form-body {

  /* height:  */
  /* width: 100%; */
  height: 350px;
  max-height: 80%;
  overflow-y: auto;
  /* margin-bottom:100px; */
  /* border:1px solid red; */
  /* display:flex; */
  /* flex-direction: column; */
  /* align-items: center; */
  /* justify-content: center; */
  padding: 2rem;
  /* margin: 0 1.5rem; */

}

.formContainer {
  padding:1.4rem;
  /* margin:auto; */
  height: 100%;
  width: 100%;
  /* border:1px solid green; */
  /* display:flex; */
  /* width: 100%; */
  /* flex-direction: column; */
  /* justify-content: center; */
  /* align-items: center; */
}

.step-nav {
  margin-top:2rem;
  width: 100%;
  /* border:1px solid red; */
  display:flex;
  justify-content: space-between;
  
}

input {
  width: 700px;
}

</style>

<style>
.formkit-inner {
  width: 700px;
  /* max-width: 80%; */
  font-size: 18px;
  /* padding:0.5rem; */
  min-height: 55px;
}

.formkit-wrapper {
  max-width: unset !important;
  
}

.formkit-outer {
  /* border:2px solid green; */
  /* display:flex;
  flex-direction: column;
  justify-content: center;
  overflow:hidden;
  align-items: center; */
  /* display:flex */

}



</style>