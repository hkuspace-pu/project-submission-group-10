<template>
    
    <div class="bannerContainer">
     
        <h2 class="mark">What's new</h2>
        <div class="bannerInnerContainer">
            <div class="innerLeft">
                <img :src="data.stories[0].content.image.filename || data.stories[0].content.url.url" />
            </div>
            <div class="innerRight">
                <p class="date">{{new Date(data.stories[0].created_at).toLocaleString('en-UK', {dateStyle: 'full'}) }}</p>
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
    /* height: 380px; */
    background-color: var(--backgroundColor);
    /* padding: 2rem; */
    display: flex;
    flex-direction: column;
    flex-direction: center;
    align-items: center;
    gap: 1.2rem;

}

.bannerInnerContainer {
    max-width: 1280px;
    display: flex;
    padding: 2rem;
    flex-direction: row;
    gap: 1rem;
    /* align-items: center; */
    width: 100%;
    justify-content: space-evenly;
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

.date {
    font-size: 13px;
    color: var(--dark);

}
/* .innerRight > p {
    margin: 16px 0;
} */


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