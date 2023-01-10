<template>
    
    <div class="bannerContainer">
     
        <h2 class="dark">What's new</h2>
        <div class="bannerInnerContainer">
            <div class="innerLeft">
                <img :src="data.stories[0].content.image.filename || data.stories[0].content.url.url" />
            </div>
            <div class="innerRight">
  
                <h3 class="dark">{{ data.stories[0].content.title}}</h3>
                <p v-html="articleContent"></p>
            </div>
        </div>
    </div>

</template>
    
<script setup>
import { computed } from "@vue/reactivity";
  import { useStoryblokApi } from "@storyblok/vue";
  import { renderRichText } from "@storyblok/vue";
  const storyblokApi = useStoryblokApi();

  const {data} = await storyblokApi.get("cdn/stories", {"starts_with": "featured", "resolve_assets" : 1});
  const articleContent = computed(() => renderRichText(data.stories[0].content.body));

  console.log(data)

</script>
    
<style scoped>
.bannerContainer {
    margin-top: 5rem;
    width: 100%;
    height: 380px;
    background-color: var(--backgroundColor);
    /* padding: 2rem; */
    display: flex;
    flex-direction: column;
    flex-direction: center;
    align-items: center;
    gap: 1.2rem;

}

.bannerInnerContainer {
    display: flex;
    padding: 2rem;
    flex-direction: row;
    gap: 1rem;
    align-items: center;
    width: 100%;
    /* background-color: grey; */
    overflow:hidden;
    justify-content: center;
}

.innerLeft {
    width: 100%;
}
.innerLeft img {
    max-width: 400px;
    border-radius: 16px;
}

.innerRight {
    display:flex;
    flex-direction: column;
    gap: 15px;
}
</style>