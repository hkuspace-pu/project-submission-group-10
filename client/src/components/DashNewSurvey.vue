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
   
    <XyzTransitionGroup  xyz="down-75% out-up-100%" mode="out-in">
      <!-- <XyzTransitionGroup  xyz="" mode="out-in"> -->

    <section key=1 v-if="step == 1">
<div>
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
    </div>

    <div>
      <h3 class="dark">Location</h3>
      <div>

        <iframe width="450" height="350" frameborder="0" style="border:0"
:src="gmapurl" allowfullscreen>
</iframe>

      </div>
    </div>

 
    </section>
    <!-- </XyzTransition> -->


    <!-- <XyzTransition  class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
    <section key=2 v-else-if="step == 2">
    <div>
    <FormKit type="group" name="BasicTreeInfo">

    <FormKit
      type="autocomplete"
      name="commonName"
      prefixIcon="search"
      suffixIcon="info"
      label="Common name"
      selection-appearance="option"
      validation="required"
      placeholder="Example: Mango tree"
      :options="commonName"
    >

    <template #option="{ option }">
        <div class="formkit-option">
          <!-- <img :src="option.logo" width="20px"/> -->
          <span>
            {{ option.commonName }}
          </span>
        </div>
      </template>

    </FormKit>

    </FormKit>
    </div>

    <div>
<img src="../assets/images/tree.svg"/>
    </div>


    </section>


    <!-- </XyzTransition> -->

    <!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=3 v-else-if="step == 3">
  <div>
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
</div>

<div>
  <img src="../assets/images/crown_spread_image.gif">
</div>
</section>
<!-- </XyzTransition> -->


<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=4 v-else-if="step == 4">
  <div>
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
</div>

<div><p>something here</p></div>
</section>
<!-- </XyzTransition> -->







<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=5 v-else-if="step == 5">
  <div>
<FormKit
  type="file"
  label="Add  media"
  accept=".jpg,.mov.,.mp4.,png"
  help="Add images or video"
  multiple
/>
</div>

<div>
  <p>someting here</p>
</div>
</section>

    </XyzTransitionGroup>





    <!-- <details>
      <summary>Form data</summary>
      <pre>{{ value }}</pre>
    </details> -->
  </div>
  <div class="step-nav">
      <FormKit type="button" :disabled="step == 1" @click="step--" v-text="'Previous step'" />
      <FormKit v-if="step <5" type="button" class="next"  @click="step++" v-text="nextText"/>
      <FormKit v-else type="submit" label="Submit Application" />
    </div>
 
</FormKit>

</div>


</template>

<script setup>
import { ref,reactive,computed, onMounted } from 'vue';
// const GOOGLE_API = import.meta.env.'VITE_GOOGLE_API'
const GOOGLE_API = 'AIzaSyCv6UXTIdpXEKk0eHF7GC42Gv9mxcHd8o4'
const gmapurl = `https://www.google.com/maps/embed/v1/place?key=${GOOGLE_API}&q=Space+Needle,Seattle+WA`


// import AddressAutocomplete from 'vue-google-maps-address-autocomplete';
const step = ref(1);
const commonName = ref([{commonName:'Fig tree (无花果树)', value : 'Fig tree (无花果树)', logo: '../assets/images/butterfly.webp' }, {commonName :'Gingko tree (银杏树)', value: 'Gingko tree (银杏树)',logo: '../assets/images/bird.gif' }]);
const treeTags = ref(['Stone wall', 'Old & valuable','Juvenile (sapling)','Mature', ])
const selected = ref(null);
const options = ref(['Stone Wall', 'Dead', 'Alive']);
const stepNames = reactive(['locationInfo', 'basicInfo', 'advancedInfo'])

// const commonName = ref(null);
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
 
      await new Promise((r) => setTimeout(r, 1000))
  alert(JSON.stringify(fields))
  step.value = 1;


}

onMounted(async () => {
  const resp = await fetch('http://18.118.83.77:9000/getCommonAndScientificNameList', {
        method: 'GET',
        // headers : {
        // "Content-type": "application/json;charset=UTF-8",
        // "Authorization" : btoa(email.value+":"+password.value)}
    }
    )
    const {data}= await resp.json()
    console.log(data)
    // commonName.value = data

})

</script>

<!-- <script async src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places&callback=initMap"></script> -->

<style scoped>


.form-body {

  /* height:  */
  /* width: 100%; */
  height: 550px;
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
  /* width: 700px; */
  /* max-width: 80%; */
  font-size: 18px;
  max-width: 420px;
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

.formkit-option {
  display: flex;
  align-items: center;
}

.formkit-option img {
  width: 20px;
  height: 20px;
  margin-right: 10px;
}

section {
  display:flex;
  flex-direction: row;
  
  justify-content: space-evenly;
  /* align-items: center; */
  /* border:1px solid red; */
}
</style>