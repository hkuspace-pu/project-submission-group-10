<template>

<div class="formContainer">
  <!-- :submit-label="button_label" -->
  <!-- <FormKit  @submit="submit" type="form" #default="{ value }" >  -->
    <!-- <XyzTransition appear xyz="fade" mode="out-in"> -->
<div v-if="!formStatus">
  
  <div class="surveySteps">

      <div @click="step = 1" class="step" :class="step == 1 && 'step_background'">
      <div class="step_number">1</div>
      <div class="attr">Location</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 2"  class="step" :class="step == 2 && 'step_background'">
      <div class="step_number">2</div>
      <div class="attr">Identification </div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 3"  class="step" :class="step == 3 && 'step_background'">
      <div class="step_number">3</div>
      <div class="attr">Attributes</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 4"  class="step" :class="step == 4 && 'step_background'">
      <div class="step_number">4</div>
      <div class="attr">Health</div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 5" class="step" :class="step == 5 && 'step_background'">
      <div class="step_number">5</div>
      <div class="attr">Media </div>
      </div>
      <fa icon="chevron-right"/>
      <div @click="step = 6" class="step" :class="step == 6 && 'step_background'">
      <div class="step_number">6</div>
      <div class="attr">Advanced </div>
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
    
    <section key=1 v-show="step == 1">
<div class="leftSide">
    <!-- <FormKit type="group" name="locationInfo"> -->
       
      <FormKit
      type="dropdown"
      name="district"
      label="*District"
      placeholder="Select district"
      :options="district"
      help="E.g Central, Wanchai etc."
      validation="required"
      value="Central"
    />

      <FormKit type="text"
      prefixIcon="flag"
      name="location"
      value="18號 Harcourt Rd, Central"
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
        <iframe class="mapBox" frameborder="0" style="border:0" :src="gmapurl" allowfullscreen></iframe>
        <!-- <GoogleMap :api-key="GOOGLE_API" class="mapBox" :center="center" :zoom="12">
    <Marker :options="{ position: center }" />
  </GoogleMap> -->
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
      inputmode="none"
      prefixIcon="search"
      suffixIcon="info"
      @suffix-icon-click="handleIconClick"
      label="Common name"
      v-model="selectedTree"
      selection-appearance="option"
      placeholder="Example: Mango tree"
      :options="store.dropDownTreeList"
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
     <div v-if="treeID" class="details">
    {{ treeID.longChiDesc }}
     
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



    <div  class="rightSide"> 
        <XyzTransition appear xyz="fade" mode="out-in">  
        <div  v-if="treeID.imgUrl" :key="treeID.imgUrl" >
        <img width="335" height="335"  :src="treeID.imgUrl"/>
      <div class="treeData">
        <p>Common Name : {{ treeID.commonName }} ({{treeID.commonChiName}})</p>
        <p>Scientific Name : <em>{{ treeID.scientificName}}</em></p>
       <p> {{treeID.commonChiName}}</p>
      
        <p>Family : {{ treeID.familyName }}</p>
        {{ treeID.longChiDesc }}
        <p><em>{{treeID.shortDesc  }}</em></p>
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
 
</div> </section>
<!-- </XyzTransition> -->


<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=4 v-show="step == 4">
  <div>
<FormKit
  type="rating"
  name="health"
  rating-icon="heart"
  on-color="#DA012D"
  id="health"
  label="Health assessment rating (Vigor):"
/>
<!-- <FormKit type="group" name="health"> -->
<!-- <FormKit
  type="rating"
  name="health"  
  rating-icon="heart"
  on-color="#DA012D"
  min="1"
  step="1"
  max="5"
  value="3"
  id="health"
  label="Health assessment rating (Vigor):"
/> -->
<div class="ratingGuide">
<p>1 = Tree is weak with high stress and rot.</p>
<p>2 = Tree has poor vigor and/or disease infection. </p>
<p>3 = Tree has average vigor with mild rot/infection.</p>
<p>2 = Tree is in above average health with no signs of disease or stress.</p>
<p>5 = Tree is growing well and appears to be free of health stress factors.</p>
</div>



  

<!-- </FormKit> -->


    <!-- <FormKit
  type="toggle"
  name="dangerous_tree"
  value="1"
  validation="required"
  label="Is this tree a potential hazard?"
/> -->
    <!-- <FormKit
  v-model="treeValue"
  type="radio"
  label="Amenity value to general public"
  :options="['None', 'Low', 'Average', 'High']"
  help="Does this tree bring value to its surroundings?"
/> -->


</div>



<div class="rightSide">
  <FormKit
      type="dropdown"
      
      name="recommendation"
      label="Your recommendation:"
      placeholder="Follow-up action"
      validation="required"
      :options="recommendation"
    />

  </div>
</section>
<!-- </XyzTransition> -->







<!-- <XyzTransition class="item-group" xyz="fade up-100% out-up" mode="out-in"> -->
<section key=5 v-show="step == 5">
  <div class="leftSide">
<FormKit
  type="file"
  name="file"
  @change="onfileInput"
  label="Add  media"
  validation="required"
  accept=".jpg,.png.,webp"
  help="Add images or video"
  multiple="true"
/>

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

<div class="rightSide">
  <p>Images</p>
  <div class="preview">
   <img  :src="thumbnail_preview" id="file-ip-1-preview">
 </div>


</div>
</section>

<section key=6 v-show="step == 6">
  <div>
   
<FormKit type="text"
      prefixIcon="number"
      name="tcmp_id"
      
      placeholder="36-0001-6084"
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




  <div class="step-nav">
      <FormKit type="button" :disabled="step == 1" @click="step--" v-text="'Previous step'" />
      <FormKit v-if="step <6" type="button"  class="next"  @click="step++" v-text="nextText"/>
      <FormKit v-else type="submit" label="Submit Application" />
    </div>

    <!-- <details>
      <summary>Form data</summary>
      <pre>{{ value }}</pre>
    </details> -->
  </div>
 
 
    <!-- <pre wrap>{{ value }}</pre> -->
</FormKit>



</div>

<div ref="success" v-show="formStatus" class="success">

<h2 class="dark">Survey submitted.</h2>

<img width="120" src="../assets/sucsess.png"/>
<p> Thank you, your information will be reviewed.</p>
<p> <em>25 points</em> will be added to your profile, once your survey is approved!</p>

<button @click="newSurvey" class="btn">Start a new survey</button>


</div>
<!-- </XyzTransition> -->

</div>


</template>

<script setup>
import { GoogleMap, Marker } from "vue3-google-map";
import OSS from 'ali-oss';
import { ref, reactive, computed, onMounted,nextTick } from "vue";
import { getNode } from "@formkit/core";
import { Fetch } from "@/controller/BaseAPI.js";
import { useStore } from "@/stores/state.js";

import { Fireworks } from 'fireworks-js'


const store = useStore();
// const GOOGLE_API = import.meta.env.'VITE_GOOGLE_API'
const GOOGLE_API = "AIzaSyCv6UXTIdpXEKk0eHF7GC42Gv9mxcHd8o4";
const gmapurl = `https://www.google.com/maps/embed/v1/place?key=${GOOGLE_API}&q=Admiralty+Centre,Hong Kong+HK`;
const center = ref({ lat: 22.2776807, lng: 14.1558142 });
const cord = reactive({ lat: 0, long: 0 });
const endpoint = 'https://hktreewatch.oss-cn-hongkong.aliyuncs.com'
// const data = reactive(null);
// import AddressAutocomplete from 'vue-google-maps-address-autocomplete';
const step = ref(1);
const thumbnail_preview = ref(null)
const uploadFile = (async (obj) => {
  console.log(obj)
  console.log('UPLOADING FILE ', obj.file.name)
  console.log('file type', obj.file.file.type)
    const objectkey = `${store.getUserInfo[0].userId}/${obj.survId}/${obj.file.name}`
    const uploadURL = `${endpoint}/${objectkey}`
 const response = await fetch(uploadURL,{
    method: 'PUT',
    body:obj.file.file,
    headers :{
        'Content-Type': obj.file.file.type,
        'x-oss-object-acl':'public-read',
    }

 })
 return response

})

const commonName = ref([
  {
    commonName: "Fig tree (无花果树)",
    value: "Fig tree (无花果树)",
    logo: "../assets/images/butterfly.webp",
    other: "werwerwre",
    somethingelse: "werwerwr",
  },
  {
    commonName: "Gingko tree (银杏树)",
    value: "Gingko tree (银杏树)",
    logo: "../assets/images/bird.gif",
    other: "werwerwred",
    somethingelse: "werdwerwr",
  },
]);
// const commonName = ref([{}]);

const treeTags = ref([
  "Stone wall",
  "Old & valuable",
  "Juvenile (sapling)",
  "Mature",
]);
const selected = ref(null);
const options = ref(["Stone Wall", "Dead", "Alive"]);
const stepNames = reactive(["locationInfo", "basicInfo", "advancedInfo"]);
const recommendation = ref([
  "Retain",
  "Transplant",
  "Trim",
  "Removal",
  "Request furthur inspection",
]);
const district = ref(["Admiralty", "Central", "Western", "Peak", "Midlevels"]);
const department = ref([
  "AFCD",
  "LCSD",
  "Highways Dept",
  "Water Supplies Dept.",
  "Housing Dept.",
]);
const treeValue = ref(null);
const treeID = ref({ imgUrl: null });
const checkBoxValue = ref(null);
const selectedTree = reactive(null);
// const todayDate = new Date(Date.now()).toLocaleString();
// const todayDate = '07/07/2022'
const today = new Date();
const todayDate = today.toISOString().split("T")[0];
const formStatus = ref(false);

// const nextInspectionDate = todayDate+
// const commonName = ref(null);
// const address = reactive({ streetName, streetNumber, zipCode, city })

// const nextText = 'asdasd';
const button_label = computed(() => {
  return step.value != 4 ? "Next" : "Submit";
});

const nextText = computed(() => {
  switch (step.value) {
    case 1:
      return "Next (Identification)";
    case 2:
      return "Next (Attributes)";
    case 3:
      return "Next (Health)";
    case 4:
      return "Next (Media)";
    case 5:
      return "Next (Advanced)";

    default:
      return "Next";
  }
});

const handleIconClick = () => {};

const newSurvey = () => {
  formStatus.value = false;
  step.value = 1;
};

const submit = async (fields) => {



  console.log("submit");
  try {
    if (fields.dangerous_tree) {
      fields.dangerous_tree = 1;
    } else {
      fields.dangerous_tree = 0;
    }

  
    fields.tree_type_id = treeID.value.id || 1
    fields.user_id = store.getUserInfo[0].userId
    fields.lat = "039333";
    fields.long = "323232";
    delete fields.id;
    delete fields.terms;
    var form_data = new FormData();

   
    form_data.append("data", JSON.stringify(fields));
    const url = "https://api.hktreewatch.org";
    const survResp = await fetch(url + "/insertSurveyRecord", {
      method: "POST",
      // body: JSON.stringify(fields)
      body: form_data,
    });
    const survRespJson = await survResp.json()
    console.log(survRespJson.data[0].id);


//try uploading images

// console.log(fields.treeImages)

 for (let i = 0; i < fields.file.length; i++) {
  // console.log(fields.file.files[0])
      const resp =  await uploadFile({file : fields.file[i], survId : survRespJson.data[0].id})
      console.log(resp)
      // uploadPromises.push(uploadFileToOSS(files[i]));
    }




    formStatus.value = true;
   const success = ref(null)
//start firework show


 nextTick(() => {

const container = success.value
console.log('CONTAINER ' , container)
const fireworks = new Fireworks(container, { /* options */ })
fireworks.start()

  })


  } catch (e) {
    console.log(e);
  }

  // step.value = 1;
};

const onfileInput = (e) => {
  console.log('FILE INPUT')
    const file = e.target.files[0]
    const reader = new FileReader();
    reader.onload = () => {
        thumbnail_preview.value = reader.result
    
    }
   reader.readAsDataURL(file);
  };

const passData = (e) => {
  console.log("data passe ", e);
  treeID.value = store.dropDownTreeList.find((tree) => tree.label === e);
  console.log(treeID);

};



onMounted(async () => {
  console.log("ON MOUNTED ");
  
  store.getMasterTreeList();

  //REQUEST LOCATION FROM THE BROWSER

  const sb = (position) => {
    center.value = {
      lat: position.coords.latitude,
      lng: position.coords.longitude,
    };
  };

  const eb = (error) => {
    console.log("geo error");
    center.value = { lat: 22.2776807, lng: 14.1558142 };
    console.log(error);
  };

  console.log("getting geo location");

  navigator.geolocation.getCurrentPosition(sb, eb);
});




</script>


<style scoped>
.form-body {
  display: flex;
  flex-direction: column;
  max-width: 1200px;
  height: 100%;
  /* margin-bottom: 30px; */
  /* height:95%; */
  max-height: calc(100% - 120px);
  height: 660px;
  /* overflow-y:hidden; */
  margin: 30px auto;
  /* overflow:hidden; */
  overflow-x: hidden;
  background-color : var(--backgroundColor);
  padding:15px;
  border-radius: 12px;
  
}

.ratingGuide {
  margin-top: -15px;
  margin-bottom: 20px;
}
.ratingGuide p,
.amenity p {
  font-size: 12px;
}

.formContainer {
  padding: 10px;
  height: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  width: 100%;
}

.surveySteps {
  margin: 35px 25px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 20px;

}

.step {
  display: flex;
  gap: 15px;
  color: var(--dark);
  cursor: pointer;
  border-radius: 6px;
  padding: 5px 8px;
  justify-content: center;
  align-items: center;
  transition: all 0.5s ease-in-out;
}

.step:hover {
  opacity: 0.8;
}

.step_background {
  background-color: var(--lightGreen);
  transform: scale(125%);
}

.step_number {
  height: 20px;
  width: 20px;
  font-size: 13px;
  font-weight: 600;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--dg2);
  color: white;
  border-radius: 50%;

}

.color {
  background-color: var(--lightGreen);
  color: var(--dark);
  margin-bottom: 20px;
  /* color:red !important; */
  /* color:red; */
}
.step-nav {
  flex:0.5;
  /* margin-top: */
  /* width: 95%; */
  /* border:1px solid red; */
  display: flex;
  align-items: center;
  justify-content: flex-end;
  /* margin: 30px 0; */
  /* margin-bottom: 25px; */
}

.leftSide {
  /* flex:1; */
}
.rightSide {
  position: relative;
  /* border: 1px solid red; */
  /* width: 300px; */
  max-width: 365px;
  /* flex:1; */
  /* min-height: 500px; */
  /* height: 100%; */
  /* height: 100px; */
  /* width: 100px; */
}

.rightSide img {
  object-fit: cover;
  border: 1px solid grey;
  border-radius: 16px;
  /* max-width: 150px; */
  /* max-height: 150px; */
  /* width: 150px; */
  /* height: 150px; */
  
  /* width: 100%; */
  /* height: 100%; */
}

.preview img {
  max-width: 300px;
}
.class-append {
  border: 1px solid red;
}

.inputImage {
  position: absolute;
  top: 100px;
  right: 150px;
  /* left:0; */
}

input {
  /* width: 10px; */
}

.inputImage {
  width: 80px;
}
section {
  flex:3;
  display: flex;
  flex-direction: row;
  /* width: fit-content; */
  gap: 4rem;
  /* align-items: center; */
  justify-content: center;

}

.mapBox {
  width: 450px;
  height: 350px;
}

img {
  /* width: 300px; */
  /* height: 300px; */
  object-fit: cover;
}

.success {
  height: 100%;
  width: 100%;
  /* border: 1px solid red; */
  display: flex;
  flex-direction: column;
  gap: 20px;
  justify-content: center;
  align-items: center;
}

/* .success img {
width: 120px;
height: 120px;
} */

@media only screen and (max-width: 800px) {
  section {
    flex-direction: column;
  }

  .attributeCrown,
  .attributeHeight,
  .attributeStep {
    display: none;
  }
  .attr {
    display: none;
  }
  .surveySteps {
    margin: 10px 3px;
    gap: 6px;
  }

  img {
    /* width: 100%; */
    width: 180px;
    height: 180px;
    object-fit: cover;
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
  margin-top: 0;
}
.attributeCrown {
  position: absolute;
  top: 165px;
  color: rgb(213, 18, 18);
  font-size: 22px;
  width: 80px;
  left: 235px;
}

.attributeHeight {
  position: absolute;
  top: 185px;
  transform: rotate(-90deg);
  color: rgb(213, 18, 18);
  font-size: 22px;
  width: 80px;
  left: 15px;
}

.attributeStep {
  position: absolute;
  top: 422px;
  color: rgb(213, 18, 18);
  font-size: 22px;
  width: 80px;
  left: 345px;
}

.my-input-class {
  color: red;
  background-color: rgba(250, 235, 215, 0.397);
  border: 1px solid red;
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
  padding: 5px;
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