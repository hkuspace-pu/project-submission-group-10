<template>

  <div class="accountContainer" >
    <div class="account_icon">
      <fa class="icon" size="2x" icon="circle-user"/>
    </div>
    <div class="account_detail">
      <div><label for="name">Name: </label>Ame Chan</div>
      <div><label for="name">Points: </label>0</div>
      <div><label for="name">Joined: </label>2022-12-31</div>
      <div><label for="name">
        <fa class="icon" size="1x" icon="location-dot"/>
      </label> Central</div>
    </div>

  </div>

</template>

<script setup>

// getlocation(() => {
//     navigator.getlocation
// })


</script>

<style scoped>
.accountContainer {
    display:flex;
    flex-direction: row;
    gap:20px;
    height: 200px;
    width: 100%;
    padding: 2rem;
    /* border:1px solid red; */

}

.account_icon {
  width: 48%;
  border: 1px solid #333;
  margin: 0 2%;
  padding: 2%;
} 

.account_detail {
  width: 48%
}

</style>