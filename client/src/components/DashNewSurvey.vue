<template>

<div class="formContainer">
  <!-- :submit-label="button_label" -->
  <!-- <FormKit  @submit="submit" type="form" #default="{ value }" >  -->

    <div class="surveySteps">

      <div @click="step = 1" class="step" :class="step == 1 && 'step_background'">
      <div class="step_number">1</div>
      <div>Location</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 2"  class="step" :class="step == 2 && 'step_background'">
      <div class="step_number">2</div>
      <div>Identification </div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 3"  class="step" :class="step == 3 && 'step_background'">
      <div class="step_number">3</div>
      <div>Attributes</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 4"  class="step" :class="step == 4 && 'step_background'">
      <div class="step_number">4</div>
      <div>Health</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 5" class="step" :class="step == 5 && 'step_background'">
      <div class="step_number">5</div>
      <div>Media </div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 6" class="step" :class="step == 6 && 'step_background'">
      <div class="step_number">6</div>
      <div>Advanced </div>
      </div>
     
     
    </div>
    <FormKit
  type="form"
  #default="{ value }"
  @submit="submit"
  id="treeform"
  :actions="false"
>


  <div class="form-body">
   
    <XyzTransitionGroup  xyz="down-100% duration-6 ease-in-out out-up-100%" mode="out-in">
      <!-- <XyzTransitionGroup  xyz="" mode="out-in"> -->

    <section key=1 v-show="step == 1">
<div>
    <!-- <FormKit type="group" name="locationInfo"> -->
       
      <FormKit
      type="dropdown"
      name="district"
      label="*District"
      placeholder="Select district"
      :options="district"
      help="E.g Central, Wanchai etc."
      validation="required"
    />

      <FormKit type="text"
      prefixIcon="flag"
      name="location"
      label="*Tree location"
      help="E.g. No. 8 Tai Tong Street, Sha Tin"
      validation="required"
    />
 
   
    

    <FormKit
  type="date"
  name="survey_date"
  :value="todayDate"
  prefixIcon="Date of survey"
  label="*Date"
  help="Enter the date of the survey"
  validation="required"
  validation-visibility="live"
/>

    <!-- </FormKit> -->
    </div>

    <div>
      <h3 class="dark">Location</h3>


      <div>
        <!-- <iframe class="mapBox" frameborder="0" style="border:0" :src="gmapurl" allowfullscreen></iframe> -->
        <GoogleMap :api-key="GOOGLE_API" class="mapBox" :center="center" :zoom="12">
    <Marker :options="{ position: center }" />
  </GoogleMap>
      </div>

    </div>

 
    </section>
    <!-- </XyzTransition> -->


    <!-- <XyzTransition  class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
    <section key=2 v-show="step == 2">
    <div>
    <!-- <FormKit type="group" name="BasicTreeInfo"> -->

    <FormKit
      type="autocomplete"
      @input="passData"
      name="id"
      id="commonName"
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
          <img :src="option.imgUrl" width="20px"/>
          <span>
            {{ option.value }}
          </span>
        </div>
        
      </template>
      
     </FormKit>
     <div v-if="treeID.longChiDesc" class="details">

     
     </div>

    <FormKit
      type="taglist"
      name="tree_tag"
      label="Tree Tags"
      :options="treeTags"
      validation="required"
      :value=[]
    />

    </div>

    <div class="rightSide">   
      <XyzTransition appear xyz="fade" mode="out-in">
        <div :key="treeID.imgUrl" v-show="treeID.id">
        <img width="320" height="320"   :src="treeID.imgUrl"/>
      <div class="treeData">
        <p>Common Name : {{ treeID.commonName }} ({{treeID.commonChiName}})</p>
        <p>Scientific Name : {{ treeID.scientificName}}</p>
        <!-- ({{treeID.commonChiName}})</p> -->
      
        <p>Family : {{ treeID.family }}</p>
        <p><em>{{treeID.longDesc  }}</em></p>
      <p><em>{{treeID.longChiDesc  }}</em></p>
      </div>
      </div>
        </XyzTransition>
 
    </div>


    </section>


    <!-- </XyzTransition> -->

    <!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=3 v-show="step == 3">
  <div>
<!-- <FormKit type="group" name="Attributes"> -->
    <FormKit
  type="number"
  help="Estimate the tree height in meters."
  label="Height (meters)"
  name="height"
  suffixIcon="info"
  validation="required"
  value="25"
  step="1"
/>

<FormKit
  type="number"
  help="Crown spread."
  label="Crown spread width (meters)"
  name="crown"
  suffixIcon="info"
  validation="required"
  value="35"
  step="1"
/>

<FormKit
  type="number"
  help="Trunk diameter 1.3m above ground"
  label="Stem circumference"
  name="stem_circumference"
  suffixIcon="info"
  value="9"
  validation="required"
  step="1"
/>


<!-- </FormKit> -->
</div>

<div class="rightSide">
  <img  src="../assets/images/crown_spread_image.gif">
  <div class="attributeCrown">{{ value.crown }}</div>
  <div class="attributeHeight">{{ value.height }}</div>
  <div class="attributeStep">{{ value.stem_circumference }}</div>
  <!-- <input class="inputImage"  type="text"/> -->
  <!-- <FormKit
  outer-class="class-append"
  type="number"
   inner-class="my-input-class"
  name="crown"
  value="25"
  step="1"
/> -->
</div> </section>
<!-- </XyzTransition> -->


<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=4 v-show="step == 4">
  <div>
<!-- <FormKit type="group" name="health"> -->
<FormKit
  type="rating"
  name="health"  
  min="1"
  step="1"
  max="5"
  value="3"
  id="health"
  validation="required"
  label="Health assessment rating (Vigor):"
/>
<div class="ratingGuide">
<p>1 = Tree is weak with high stress and rot.</p>
<p>2 = Tree has poor vigor and/or disease infection. </p>
<p>3 = Tree has average vigor with mild rot/infection.</p>
<p>2 = Tree is in above average health with no signs of disease or stress.</p>
<p>5 = Tree is growing well and appears to be free of health stress factors.</p>
</div>



  

<!-- </FormKit> -->


    <FormKit
  type="toggle"
  name="dangerous_tree"
  value="1"
  validation="required"
  label="Is this tree a potential hazard?"
/>
    <!-- <FormKit
  v-model="treeValue"
  type="radio"
  label="Amenity value to general public"
  :options="['None', 'Low', 'Average', 'High']"
  help="Does this tree bring value to its surroundings?"
/> -->

<FormKit
      type="dropdown"
      name="recommendation"
      label="Your recommendation:"
      placeholder="Follow-up action"
      validation="required"
      :options="recommendation"
    />

</div>



<div>

  </div>
</section>
<!-- </XyzTransition> -->







<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=5 v-show="step == 5">
  <div>
<FormKit
  type="file"
  name="file"
  @input="onfileInput"
  label="Add  media"
  validation="required"
  accept=".jpg,.mov.,.mp4.,png"
  help="Add images or video"
  multiple
/>

{{ value.file }}

<FormKit
  v-model="treeValue"
  type="range"
  label="Amenity value to general public"
  min="1"
  name="amenity_value"
  max="5"
  value="4"
  validation="required"
  :options="[{label:'Poor', value:0},{label:'Average', value:1}]"
  help="1 = Low Value, 5 = High Value"
/>


<div class="amenity">
  <p class="step_number color">{{ value.amenity_value }}</p>
<p><em>"Amenity value" is used to describe the visual aspect of a tree, it's health, beautification to landscape, shelter & value.</em> </p>
<p>0 = Nil to low amenity value to the surroundings, wildlife and general public.</p>
<p>1 = Low to mild, provides habitat for small insects, birds, fungi.</p>
<p>2 = Mild to average, provides shelter, slows rainfall, reduce flash floods.</p>
<p>3 = Average, increases land value, provides shade.</p>
<p>4 = Above average, desirable, increases land value, health.</p>
<p>5 = High value, desirable, healthy, old & valuable.</p>
</div>




</div>

<div>
  <p>Images</p>
  <div  class="preview">
   <img  id="file-ip-1-preview">
 </div>


</div>
</section>

<section key=6 v-show="step == 6">
  <div>
    <h3>Advanced Options</h3>
<FormKit type="text"
      prefixIcon="number"
      name="tcmp_id"
      
      placeholder="GOVTCP2927S888S"
      label="Government Tree Identification"
      help="Government registered ID"
    
    />
    
  

    <FormKit
      type="dropdown"
      name="responsible_dept"
      label="Responsible Department"
      placeholder="Select Department"
      :options="department"
      help="E.g LCSD, Highways Dept."
     
    />
    <FormKit
  type="date"
  value="2023-06-01"
  name="next_inspection_date"
  label="Next inspection date"
  help="Schedule next inspection date"

/>


    </div>

    <div>
      <FormKit
  type="textarea"
  label="Further comments"
  name="comments"
  rows="5"
  placeholder="Further comments"
  help="E.g. The tree is beautiful but needs trimming."
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

    
    </section>

    </XyzTransitionGroup>





    <!-- <details>
      <summary>Form data</summary>
      <pre>{{ value }}</pre>
    </details> -->
  </div>
 
  <div class="step-nav">
      <FormKit type="button" :disabled="step == 1" @click="step--" v-text="'Previous step'" />
      <FormKit v-if="step <6" type="button" class="next"  @click="step++" v-text="nextText"/>
      <FormKit v-else type="submit" label="Submit Application" />
    </div>
    <!-- <pre wrap>{{ value }}</pre> -->
</FormKit>




</div>


</template>

<script setup>
import { GoogleMap, Marker } from "vue3-google-map";
import { ref,reactive,computed, onMounted } from 'vue';
import { getNode } from '@formkit/core'
// const GOOGLE_API = import.meta.env.'VITE_GOOGLE_API'
const GOOGLE_API = 'AIzaSyCv6UXTIdpXEKk0eHF7GC42Gv9mxcHd8o4'
const gmapurl = `https://www.google.com/maps/embed/v1/place?key=${GOOGLE_API}&q=Po+Leung+Kuk,Hong Kong+HK`
const center = ref({ lat: 22.2776807, lng: 14.1558142 });
const cord = reactive({lat:0,long:0})
// const data = reactive(null);
// import AddressAutocomplete from 'vue-google-maps-address-autocomplete';
const step = ref(1);
const commonName = ref([{commonName:'Fig tree (无花果树)', value : 'Fig tree (无花果树)', logo: '../assets/images/butterfly.webp', other : 'werwerwre', somethingelse: 'werwerwr' }, {commonName :'Gingko tree (银杏树)', value: 'Gingko tree (银杏树)',logo: '../assets/images/bird.gif',other : 'werwerwred', somethingelse: 'werdwerwr' }]);
// const commonName = ref([{}]);

const treeTags = ref(['Stone wall', 'Old & valuable','Juvenile (sapling)','Mature', ])
const selected = ref(null);
const options = ref(['Stone Wall', 'Dead', 'Alive']);
const stepNames = reactive(['locationInfo', 'basicInfo', 'advancedInfo'])
const recommendation = ref(['Retain', 'Transplant', 'Trim', 'Removal','Request furthur inspection'])
const district = ref(['Central', 'Western', 'Peak', 'Midlevels'])
const department = ref(['AFCD', 'LCSD','Highways Dept', 'Water Supplies Dept.', 'Housing Dept.'])
const treeValue = ref(null);
const treeID = ref({imgUrl: null});
const checkBoxValue = ref(null);
const selectedTree = "re";
// const todayDate = new Date(Date.now()).toLocaleString();
// const todayDate = '07/07/2022'
const today = new Date();
const todayDate = today.toISOString().split('T')[0];
// const nextInspectionDate = todayDate+
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
      case 5:
      return 'Next (Advanced)'
  
    default:
    return 'Next'
  
  }
})




const handleIconClick = () => {
console.log('INFO CLICKED')

}
const submit = async (fields) => {
  if (fields.dangerous_tree) {
    fields.dangerous_tree = 1
  } else {
    fields.dangerous_tree = 0
  }


 fields.tree_type_id = treeID.value.id
 fields.user_id = 1
 fields.lat = "039333"
 fields.long = "323232"
 delete fields.id
 delete fields.terms
var form_data = new FormData();

form_data.append('data', JSON.stringify(fields));
  const url2 = "http://18.118.83.77:9000"
  const url = "http://api.hktreewatch.org:9000"
  const resp = await fetch(url2+'/InsertSurveyRecord', {
        method: 'POST',
        // body: JSON.stringify(fields)
        body: form_data
      })


  // step.value = 1;
}

const onfileInput = (e) => {
console.log('on file input')
}

const passData = (e) => {
  console.log('data passe ', e)
  if (e) {
    treeID.value = commonName.value.find(name => e == name.value)
  } else {
     console.log('no image')
    // treeID.value.imgUrl = '../assets/images/tree2.svg'
  }
  // console.log(treeID)
 
}

const loadTreeList = async () => {
  const url = "http://api.hktreewatch.org:9000"
  const resp = await fetch(url+'/getCommonAndScientificNameList', {
        method: 'GET',
        // headers : {
        // "Content-type": "application/json;charset=UTF-8",
        // "Authorization" : btoa(email.value+":"+password.value)}
    })
    let {data} = await resp.json()

   data = data.map((item) => {
   return {...item, label : item.value}
      // item.label = item.value

    })
    commonName.value = data
    



  
}

onMounted(async () => {
  console.log('ON MOUNTED ')

  loadTreeList()


//REQUEST LOCATION FROM THE BROWSER

const sb = (position) => {
  center.value = {lat: position.coords.latitude ,lng: position.coords.longitude }
 }

const eb = (error) => {
  console.log('geo error')
  console.log(error)
}

console.log('getting geo location')

navigator.geolocation.getCurrentPosition(sb,eb)



})

</script>


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


.ratingGuide {
  margin-top:-15px;
  margin-bottom:20px;
}
.ratingGuide p, .amenity p {
  font-size:12px;

}

.formContainer {
  padding:10px;
  height: 100%;
  overflow-y:auto;
  width: 100%;
  /* border:1px solid red; */
  /* margin: auto; */

}

.surveySteps {
  margin: 25px 0;
  display:flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  /* border:1px solid red; */
  gap:20px;
}

.step {
display:flex;
gap:10px;
color:var(--dark);
cursor: pointer;
border-radius: 6px;
padding: 5px 8px;
justify-content: center;
align-items: center;
}

.step:hover {
  opacity: 0.8;
}

.step_background {
  background-color: var(--lightGreen);
}

.step_number {
  height: 20px;
  width: 20px;
font-size:13px;
font-weight: 600;
display:flex;
justify-content: center;
align-items: center;
  background-color: var(--dg2);
  color:white;
  border-radius: 50%;
}

.color {
  background-color: var(--lightGreen);
  color: var(--dark);
  margin-bottom:20px;
  /* color:red !important; */
/* color:red; */
}
.step-nav {
  /* margin-top: */
  width: 100%;
  /* border:1px solid red; */
  display:flex;
  justify-content: space-between;
  
}

.rightSide {
  position:relative;
  max-width: 320px;
  height: auto;
}

.rightSide img {
  object-fit: cover;
  border:1px solid grey;
  border-radius: 16px;
  /* width: 100%; */
  /* height: 100%; */
}
.class-append{
  border:1px solid red;
}

.inputImage {
  position : absolute;
  top:100px;
  right:150px;
  /* left:0; */
}

input {
  /* width: 10px; */
}

.inputImage {
  width: 80px;
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

.surveySteps {
  display:none;
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

[rating] .formkit-outer {
  margin-top:0;
}
.attributeCrown{
  position:absolute;
  top:165px;
  color:rgb(213, 18, 18);
  font-size:22px;
  width: 80px;
  left:235px;
}

.attributeHeight {
  position:absolute;
  top:185px;
  transform: rotate(-90deg);
  color:rgb(213, 18, 18);
  font-size:22px;
  width: 80px;
  left:15px;
}

.attributeStep {
  position:absolute;
  top:422px;
  color:rgb(213, 18, 18);
  font-size:22px;
  width: 80px;
  left:345px;
}

.my-input-class {
  color:red;
  background-color:rgba(250, 235, 215, 0.397);
  border:1px solid red;
}
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
  /* max-width: unset !important; */
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