<template>
    
    <div id="faq" class="faqContainer">
     
        <h2 class="dark">Frequently asked questions</h2>
        <ul>
  
  <li @click="faq.isShown = !faq.isShown" v-for="faq in faqs" :key="faq.question">
    <div  class="faqTitle">{{faq.question}} 
      <fa size="xs" class="chevron" icon="chevron-left"/> 

      
  </div>
 <!-- <XyzTransition xyz="fade"> -->
     <div v-show="faq.isShown" v-html="faq.answer" class="faqContent"></div>
  <!-- </XyzTransition> -->

  </li>

</ul>
    </div>
 
</template>
    
<script setup>
import { ref } from "@vue/reactivity";
  import { useStoryblokApi } from "@storyblok/vue";
//   import { renderRichText } from "@storyblok/vue";
  const storyblokApi = useStoryblokApi();
const faqs = ref([]);
  const {data} = await storyblokApi.get("cdn/stories", {"starts_with": "faqs"});
//   const articleContent = computed(() => renderRichText(data.stories[0].content.body));
faqs.value = data.stories.map(function(article) {
    return {question: article.content.title_question, answer: article.content.title_answer,isShown:false}
})

console.log(faqs)
  console.log(data)

</script>
    
<style scoped>
.faqContainer {
    width: calc(100% - 1rem);
    max-width: 850px;
    padding: 5rem 0;
   margin-top:1rem;
   margin-bottom:5rem;
   margin:5rem auto;
     background-image: url('../assets/images/bottom-blob.svg');
      background-position: top center !important;
      background-repeat: no-repeat;
      background-size:contain;
      display: flex;
      flex-direction: column;

}
.title {
   font-size: calc(1.2rem + 0.8vw);
  /* border:1px solid red; */
  /* width: 100%; */
  text-align: center;
       color: var(--dark);
  margin-bottom: 2rem;
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
  
  .faqTitle {
     display:flex;
    flex-direction:row;
      justify-content: space-between;
    color: var(--dark);
       font-size:16px;
  }
  
  .chevron {

      color: var(--dg2);
      margin-left: 10px;
      transition: transform .2s ease;
        transform: rotate(180deg);
  }
  
  li:hover .chevron {
    transform: rotate(270deg);
  
  }
  
  
  .faqContent {
    color: var(--darkGreen);
    font-weight: 500;
    margin: 1rem 0.5rem;
    line-height: 25px;
    border-radius:4px;
    padding: 5px;
    font-size:15px;
  
    /* background: var(--myLightGreen); */
    
  }
  
  

  
  .faqContent ul {
    margin: 0.5rem 0;
     list-style-type:disc;
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