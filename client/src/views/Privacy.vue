<template>
   <TheNav/>
<div class="privacyContainer">     
    <div v-if="privacy" id="faq" class="privacyContainer">
      <div class="titleFrame">

        <h1> {{ privacy.title}}</h1>

      </div>

        <div class="privacyBody">
         
          <p v-html="renderRichText(privacy.body)"></p>


        </div>



     
    </div>
  
  </div>
  <TheFoot/>
</template>
    
<script setup>
import TheNav from '@/components/TheNav.vue'
import TheFoot from '@/components/TheFoot.vue'
import { ref } from "@vue/reactivity";
  import { useStoryblokApi } from "@storyblok/vue";
import { onMounted } from "vue";
  import { renderRichText } from "@storyblok/vue";
const storyblokApi = useStoryblokApi();
const privacy = ref([]);


onMounted(async () => {
  console.log('Privacy Mounted')
  const {data} = await storyblokApi.get("cdn/stories", {"starts_with": "privacy"});
 console.log(data)
  privacy.value = data.stories[0].content

})



// faqs.value = data.stories.map(function(article) {
//     return {question: article.content.title_question, answer: article.content.title_answer,isShown:false}
// })



</script>


    
<style scoped>

.privacyContainer{
    min-height: 100vh;
    width: 100%;
    display:flex;
    flex-direction: column;
    /* border:1px solid red; */
    align-items: center;

/* border: 1px solid red; */

}
.title {
   font-size: calc(1.4rem + 0.8vw);
   font-weight: 600;
  text-align: center;
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
  
  .titleFrame {
    height: 120px;
    width: 100%;
    display:flex;
    justify-content: center;
    align-items: center;
    background-color:var(--darkGreen);
    color:white;
  }


  .privacyBody {
    padding: 2rem;
    max-width: 1200px;
    line-height: 1.5em;
    font-size: 18px;
    display:flex;
    justify-content: center;
    align-items: center;
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

<style>
p {
 display:block;
 margin-bottom:16px;
}
</style>