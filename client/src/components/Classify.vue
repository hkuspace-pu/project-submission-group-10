<template>
  <!-- SUPERVISED LEARNING WITH A PRETRAINED model -->
  <!-- USING A LABELED DATASET AND Images -->

  <div class="classifyContainer">
    <h2 class="dark">Tree Classification</h2>
    <h4 style="text-align:center" class="dark">If you are unsure which tree you are surveyors, use our AI prediction tool.</h4>

    <div class="loading" v-if="loadingModel">
      <h2 class="dark">Please wait, loading model data.</h2>
      <progress></progress>
    </div>

    <div class="innerContainer" v-else>
    
      <div v-if="classifyResults.length > 0" class="classificationResult">
        <h3 class="dark">
          <span class="mark">{{ classifyResults[0].label }}</span>
        </h3>
        <h4 class="dark">
          Confidence:
          {{ (classifyResults[0].confidence * 100).toFixed(2) + "%" }}
        </h4>
      </div>

      <FormKit
        type="file"
        name="file"
        @change="imageChange"
        label="Drop your image"
        validation="required"
        accept=".jpg,.png.,webp"
        multiple="false"
      />
      <!-- <input type="file" @change="imageChange"/> -->

      <img v-show="imagePath" ref="previewImage" class="previewImage" :src="imagePath" />

      <button v-if="imagePath" class="btn" @click="start">

         <transition name="spinner" mode="out-in">
                  <span key="notloading" class="btnText" v-if="!isLoading">Start</span>
                  <span key="loading" class="btnText" v-else>  <fa size="lg" icon="spinner" pulse> </fa> </span>
                </transition>
</button>
    </div>
  </div>
</template>

<script setup>
import ml5 from "ml5";

import { ref, reactive, computed, onMounted } from "vue";
const imagePath = ref();
const loadingModel = ref(true);
const classifyResults = ref([]);
// console.log(ml5.version);
const previewImage = ref(null);
let classifier = ref(null);
const isLoading = ref(false);
const imageChange = (e) => {
  const file = e.target.files[0];
  const reader = new FileReader();

  reader.onload = () => {
    imagePath.value = reader.result;
 
    // reader.readAsDataURL(file)
  };
  //  console.log(e.target.value)
     previewImage.value = previewImage;
  console.log("image changd");
  reader.readAsDataURL(file);
 
};

onMounted(async () => {
  const script = document.createElement('script');
  script.src = 'https://unpkg.com/ml5@0.12.2/dist/ml5.min.js';
  script.type = 'text/javascript';
  script.async = true;
  document.body.appendChild(script);


  classifier = ml5.imageClassifier(
    "https://teachablemachine.withgoogle.com/models/GbGUdIUyZ/",
    modelLoaded
  );
});

const modelLoaded = () => {
  console.log("model loaded");
  loadingModel.value = false;
};

const start = async () => {
     console.log("starting");
 

    if (classifyResults.value.length >= 1) {
    classifyResults.value  = []
    imagePath.value = null
    return 
    
    }
 

 

  try {
    
    isLoading.value = true
    const results = await classifier.classify(previewImage.value);
    classifyResults.value = results;
  } catch (error) {
    console.error(error);
  } finally {
       isLoading.value = false
  }
};
</script>

<style scoped>
.classifyContainer {
margin: 1rem;
}

.loading {
    margin: 2rem 0;
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items : center;
}
.innerContainer {
  padding: 2rem;
  display: flex;
  /* width: 600px; */
  /* border:1px solid red; */
  margin: 0 auto;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 2rem;
}
img {
  object-fit: cover;
  border-radius: 4px;
  height: 250px;
  /* height: 320px; */
  /* border:1px solid red; */
}

.classificationResult {
  display:flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 2rem;
  background: rgba(255, 255, 255, 0.2);
  border-radius: 16px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px);
  border: 1px solid rgba(255, 255, 255, 0.3);
}
</style>