<template>

  <div class="accountContainer" >
    <div>
      <img class="account_icon" src="../assets/images/man.png" /> 
    </div>
    <div class="account_detail">
      <div><label for="name">Name: </label>{{ full_name }}</div>
      <div><label for="name">Points: </label>{{ points }}</div>
      <div><label for="name">Joined: </label>{{ join_date }}</div>
      <div><label for="name">
        <fa class="icon" size="1x" icon="location-dot"/>
      </label> {{ location }}</div>
    </div>

  </div>

</template>

<script>
import { ref,computed } from 'vue';
// localStorage.getItem('key');
export default {
    data() {
        var user_info = JSON.parse(localStorage.getItem('user_info'))
        console.log( 'user_info', user_info )
        var full_name = user_info.full_name
        var points = user_info.points
        var join_date = user_info.join_date
        var location = user_info.location
        return {
            full_name, points, join_date, location
        }
    },
};

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
  width: 300px;
  border: 1px solid #333;
  margin: 0 2%;
  padding: 2%;
  border-radius: 5px;
} 

.account_detail {
  width: 48%
}

</style>