<template>

  <div class="accountContainer" >
    <div>
      <img class="account_icon" src="../assets/images/man.png" /> 
    </div>
    <div class="account_detail">
      <div><label for="name">Name: </label>{{ full_name }}</div>
      <div><label for="date">Email: </label>{{ email }}</div>
      <div><label for="date">Contnet: </label>{{ phoneNumber }}</div>
      <div><label for="points">Points: </label>{{ points }}</div>
      <div><label for="date">Joined: </label>{{ join_date }}</div>
      <div><label for="location">
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
        var _uInfo = user_info.data[0]
        var email  = _uInfo.email
        var phoneNumber  = _uInfo.phoneNumber
        var role  = _uInfo.role
        var full_name = _uInfo.userName
        var points = _uInfo.point
        var createTime = new Date(_uInfo.createTime)
        var join_date = createTime.getDate()+
           "/"+(createTime.getMonth()+1)+
           "/"+createTime.getFullYear()+
           " "+createTime.getHours()+
           ":"+createTime.getMinutes()+
           ":"+createTime.getSeconds()
        return {
            full_name, points, join_date, email, phoneNumber
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