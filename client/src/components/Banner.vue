<template>
    <div class="bannerContainer">
        <h2 class="dark">Banner</h2>
        <div class="bannerInnerContainer">
            <div class="innerLeft">
                <img src="https://via.placeholder.com/150" />
            </div>
            <div class="innerRight">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Assumenda iusto fugiat repudiandae suscipit
                    ratione nesciunt, numquam veritatis eligendi unde ipsa incidunt non minima omnis qui? Ab eos quos
                    ipsam eum!</p>
            </div>
        </div>
    </div>
</template>
    
    
<style scoped>
.bannerContainer {
    margin-top: 5rem;
    width: 100%;
    height: 380px;
    padding: 2rem;
    display: flex;
    flex-direction: column;
    flex-direction: center;
    align-items: center;
    gap: 1.2rem;

}

.bannerInnerContainer {
    display: flex;
    flex-direction: row;
    gap: 1rem;
    align-items: center;
    justify-content: center;
}
</style>