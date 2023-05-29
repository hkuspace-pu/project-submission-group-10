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

    <div>
      <button class="user_btn btn_loggout" @click="loggout()">Loggout</button>
    </div>

  </div>

  <div style="padding: 0 2rem;">
      <button class="user_btn log_btn" @click="getActivityLog()"> Show Activity Log </button>
      <div v-for="log in activityLogLists" :key="log.id">
        <label for="name">Date: {{ dateFormat(log.createTime) }}</label>&nbsp;&nbsp;&nbsp;
        <label for="name">Activity: {{ log.activityLog }}</label>
      </div>
    </div>


</template>

<script>
import { ref,computed } from 'vue';
import { Modal } from 'usemodal-vue3';
import { useStore } from "@/stores/state.js";
const store = useStore();
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
           ":"+createTime.getSeconds();
        let isActivityVisible = false
        let activityLogLists = []
        return {
            full_name, points, join_date, email, phoneNumber, isActivityVisible, activityLogLists, Modal
        }
    },
    methods: {
      loggout() {
        localStorage.removeItem("user_info");
        window.location.href = '/login'
      },

      async getActivityLog() {
        store.activityLogUserId = store.getUserInfo[0].userId
        const activity_log = await store.getActivityLogByUserId()
        this.activityLogLists = activity_log.data
        this.isActivityVisible = true
      },

      dateFormat(_dateTime) {
        var _date = new Date(_dateTime)
        return   String(_date.getDate()).padStart(2, '0')+
            "/"+String((_date.getMonth()+1)).padStart(2, '0')+
            "/"+_date.getFullYear()+
            " "+String(_date.getHours()).padStart(2, '0')+
            ":"+String(_date.getMinutes()).padStart(2, '0')+
            ":"+String(_date.getSeconds()).padStart(2, '0')
      }
    }
};

</script>

<style scoped>
.accountContainer {
    display:flex;
    flex-direction: row;
    gap:20px;
    height: 380px;
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

.btn_loggout {
    background-color: #2E7D32;
}

.user_btn {
    padding: 5px 10px;
    border-radius: 5px;
    border: 1px;
    margin: 10px;
    color: white;
    font-size: 15px;
}

.log_btn {
    background-color: var(--brown);
    margin: 10px 0;
}

</style>