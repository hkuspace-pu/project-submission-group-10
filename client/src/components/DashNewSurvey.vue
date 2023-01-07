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
   
    <XyzTransitionGroup  xyz="down-100% duration-6 ease-in-out out-up-100%" mode="out-in">
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
  label="*Date"
  help="Enter the date of the survey"
  validation="required"
  validation-visibility="live"
/>

    </FormKit>
    </div>

    <div>
      <h3 class="dark">Location</h3>


      <div>
        <iframe class="mapBox" frameborder="0" style="border:0" :src="gmapurl" allowfullscreen></iframe>
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
      @suffix-icon-click="handleIconClick"
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

    <div class="rightSide">
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

<FormKit
  type="number"
  help="Trunk diameter 1.3m above ground"
  label="Stem circumference"
  name="crown"
  suffixIcon="info"
  value="25"
  step="1"
/>


</FormKit>
</div>

<div class="rightSide">
  <img  src="../assets/images/crown_spread_image.gif">
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
  label="Rate the overall health condition of the tree"
/>
<div>

</div>

  

</FormKit>

<FormKit
      type="dropdown"
      name="recommendation"
      label="Your recommendation"
      placeholder="Follow-up action"
      :options="recommendation"
    />

    <!-- <FormKit
  v-model="treeValue"
  type="radio"
  label="Amenity value to general public"
  :options="['None', 'Low', 'Average', 'High']"
  help="Does this tree bring value to its surroundings?"
/> -->

<FormKit
  v-model="treeValue"
  type="range"
  label="Amenity value to general public"
  min="0"
  prefix="1"
  suffix="10"
  max="5"
  help="0 = No Value, 5 = High Value"
/>
{{treeValue}}


<FormKit
  type="date"
  value="2022-01-01"
  label="Next inspection date"
  help="Schedule next inspection date"
  validation="required|date_before:2010-01-01"
  validation-visibility="live"
/>
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

<FormKit
  v-model="checkBoxValue"
  type="checkbox"
  label="Terms and Conditions"
  help="Do you agree to our terms of service?"
  name="terms"
  validation="accepted"
  validation-visibility="dirty"
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
const gmapurl = `https://www.google.com/maps/embed/v1/place?key=${GOOGLE_API}&q=Po+Leung+Kuk,Hong Kong+HK`
const cord = reactive({lat:0,long:0})

// import AddressAutocomplete from 'vue-google-maps-address-autocomplete';
const step = ref(1);
const commonName = ref([{commonName:'Fig tree (无花果树)', value : 'Fig tree (无花果树)', logo: '../assets/images/butterfly.webp' }, {commonName :'Gingko tree (银杏树)', value: 'Gingko tree (银杏树)',logo: '../assets/images/bird.gif' }]);
const treeTags = ref(['Stone wall', 'Old & valuable','Juvenile (sapling)','Mature', ])
const selected = ref(null);
const options = ref(['Stone Wall', 'Dead', 'Alive']);
const stepNames = reactive(['locationInfo', 'basicInfo', 'advancedInfo'])
const recommendation = ref(['Retain', 'Transplant', 'Trim', 'Removal'])
const treeValue = ref(null);
const checkBoxValue = ref(null);
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


const handleIconClick = () => {
console.log('INFO CLICKED')

}
const submit = async (fields) => {
  console.log(step)
 
      await new Promise((r) => setTimeout(r, 1000))
  alert(JSON.stringify(fields))
  step.value = 1;


}

onMounted(async () => {
  const url = "http://api.hktreewatch.org:9000"
  // http://18.118.83.77:9000
  const resp = await fetch('url/getCommonAndScientificNameList', {
        method: 'GET',
        // headers : {
        // "Content-type": "application/json;charset=UTF-8",
        // "Authorization" : btoa(email.value+":"+password.value)}
    }
    )
    const {data}= await resp.json()
    console.log(data)
    // commonName.value = data

//REQUEST LOCATION FROM THE BROWSER

const sb = (position) => {
  console.log('geo ok')
  console.log(position)
}

const eb = (error) => {
  console.log('geo error')
  console.log(error)
}

console.log('getting geo location')

navigator.geolocation.getCurrentPosition(sb,eb)




})

</script>

<!-- <script async src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places&callback=initMap"></script> -->

<style scoped>



.form-body {
  /* height: 100%; */

  /* border:1px solid red; */
  /* width: 100%; */
  /* height: 600px; */
  /* max-height: 50%; */
  overflow-y: hidden;
  display:flex;
  flex-direction: column;
  /* justify-content: center; */
  width: 100%;
  height:550px;
  max-height: calc(100% - 120px);
  /* margin: 40px 0; */
  /* border:2px solid green; */
  /* align-items: center; */
  /* margin-right:auto; */
  /* margin-left:auto; */
 

}

.formContainer {
  padding:10px;
  height: 100%;
  overflow-y:auto;
  width: 100%;
  /* border:1px solid red; */
  /* margin: auto; */

}

.step-nav {
  /* margin-top: */
  width: 100%;
  /* border:1px solid red; */
  display:flex;
  justify-content: space-between;
  
}

input {
  width: 700px;
}

section {
  display:flex;
  flex-direction: row;
  width: 100%;
  gap:2rem;
  /* padding:40px 0; */
  /* margin-top:20px; */
  /* margin-top:10px; */
  /* border:1px solid red; */
  justify-content: space-evenly;
  /* align-items: center; */
  /* border:1px solid red; */
}

.mapBox {
  width: 450px;
  height: 350px;
}


img {
  /* width: 300px; */
  /* height: 300px; */
  object-fit: cover
}

@media only screen and (max-width:800px) {
section {
  flex-direction: column;
}

img {
   width: 100px;
  height: 100px;
  object-fit: cover
}
.mapBox {
  /* width: 100%; */
  /* margin-left: auto; */
  /* margin-right: auto; */
  /* margin-left: 100px; */
  /* margin-left: auto; */
  /* margin-right: auto; */
  /* margin:auto; */
  width: 100%;
  height: auto;
}

}

</style>

<style>
.formkit-inner {
  /* p/: 10px; */
  /* border:1px solid red; */
  /* width: 700px; */
  /* max-width: 80%; */
  font-size: 18px;
  max-width: 420px;
  /* padding:0.5rem; */
  min-height: 55px;
}

.formkit-wrapper {
  /* border:2px solid orange; */
  max-width: unset !important;
  /* : 10px; */
  
}

.formkit-outer {
  padding:5px;
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


.formkit-suffix-icon:hover {
  cursor: pointer;
  color: var(--fk-color-primary);
}



</style>