<template>
  <!-- <h3 class="dark">List Surveys</h3> -->
  <EasyDataTable :headers="headers" :items="items" :loading="isDataLoading">
    <template #item-name="{ name }">
      <div class="name-wrapper">
        <img class="avator" src="../assets/images/man.png" />
        {{ name }}
      </div>
    </template>

    <template #expand="data">
      <div class="accountContainer">
        <div>
          <img class="account_icon" src="../assets/images/man.png" />
        </div>
        <div class="account_detail">
          <div><label for="name">Name: </label>{{ data.fullName }}</div>
          <div><label for="date">Email: </label>{{ data.email }}</div>
          <div><label for="date">Contnet: </label>{{ data.phoneNumber }}</div>
          <div><label for="points">Points: </label>{{ data.point }}</div>
          <div><label for="date">Joined: </label>{{ data.createTimeFi }}</div>
          <!-- <div>
            <label for="location">
              <fa class="icon" size="1x" icon="location-dot" />
            </label>
            {{ data.location }}
          </div> -->
        </div>

        <div class="btnClass" >
            <button class="edit_btn" @click="editUser(data)"> Edit </button>
            <button class="delete_btn" @click="deleteUser(data.id)"> Delete </button>
        </div>
      </div>
    </template>
  </EasyDataTable>

  <!-- </div> -->
</template>

<script setup>
import { ref, computed,onMounted } from 'vue';
import { useStore } from "@/stores/state.js";
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const store = useStore();

const isDataLoading = ref(false);
const clickedRow = ref(null);
const itemsSelected = ref([]);
let items = ref([]);

const url = "https://api.hktreewatch.org";

const headers = [
  { text: "Full Name", value: "fullName", sortable: true },
  { text: "User Name", value: "userName", sortable: true },
  { text: "Email", value: "email", sortable: true },
  { text: "Phone No.", value: "phoneNumber", sortable: true },
  { text: "Role", value: "role", sortable: true },
  { text: "Points", value: "point", sortable: true },
  { text: "Joined Date", value: "createTimeFi", sortable: true },
  { text: "Status", value: "status", sortable: true },
];

onMounted(async () => {
  if (!store.getUserInfo) {
    router.push({ name: "login" });
  }

  loadUsers()
});

const loadUsers = async () => {
  const formData = new URLSearchParams();
  formData.append("roleId", store.getUserInfo[0].role);
  try {
    isDataLoading.value = true;
    const resp = await fetch(url + '/getAllUser', {
      method: "POST",
      body: formData,
    });
    const jsonData = await resp.json();
    jsonData.data.forEach(jEle => {
      jEle['createTimeFi'] = dateFormat( jEle['createTime'] )
    });
    items = jsonData.data;
  } catch (e) {
    console.log("ERROR LOADING DATA ", e);
  } finally {
    isDataLoading.value = false;
  }
}

const showRow = (index) => {
  clickedRow.value = data[index].advanced;
};

const selectedImage = computed(() => {
  return clickedRow.value.media[0];
});

const dateFormat = ( _dateTime ) => {
  var _date = new Date(_dateTime)
  return  _date.getDate()+
           "/"+(_date.getMonth()+1)+
           "/"+_date.getFullYear()+
           " "+_date.getHours()+
           ":"+String(_date.getMinutes()).padStart(2, '0')+
           ":"+_date.getSeconds()
}

const deleteUser = async ( _id ) => {
  const formData = new URLSearchParams();
  formData.append("userId", _id);

  const deleteResp = await fetch(url + '/delUser', {
    method: "DELETE",
    body:  formData
  });
  const delete_user = await deleteResp.json();
  console.log( 'delete_user', delete_user )

  if ( delete_user.errorNo == 200 ) {
    loadUsers()
  } else {
    console.log( 'fail to delete', delete_user.errMsg )
  }
}

const editUser = ( _data ) => {
  console.log( 'edit', _data )
  // updateUser( _json, 'editUser' )
}
</script>

<style scoped>
.dashHomeContainer {
  /* margin: 3rem; */
  /* padding: 0.5rem; */
  border-radius: 12px;
  background-color: #fefefe;
  height: 100%;
  width: 100%;
  box-shadow: 10px 10px 12px -12px rgba(0, 0, 0, 0.25);
}

.media {
  display: flex;
  flex-direction: column;
  width: 350px;
  justify-content: space-between;
  /* border:1px solid var(--dark); */
  gap: 5px;
  margin: 1rem;
}

.thumbnail_group {
  display: flex;
  flex-direction: row;
  gap: 8px;
}
.thumbnail {
  width: 45px;
  height: 45px;
  border-radius: 4px;
  /* border:1px solid red; */
}

.mainImage {
  width: 350px;
  height: 350px;
  background-image: url("../assets/logo.svg");
  background-size: cover;
  background-position: center;
  object-fit: contain;
  /* height: auto; */
}
.dataContainer {
  /* border:1px solid red; */
  padding: 5px;
  background-color: #f7f7f7;
  /* background-color: var(--dark); */
  /* display:flex; */
  /* flex-direction: row; */
}

.topBar {
  /* border:1px solid red; */
}

.dataContent {
  display: flex;
}
.leftSide {
  display: flex;
  flex-direction: column;
  gap: 5px;
}

.rightSide {
  gap: 5px;
  display: flex;
  width: 100%;
  flex-direction: column;
}

.tags {
  display: flex;
  flex-direction: row;
  gap: 10px;
  width: 350px;
  /* border:1px solid red; */
}

.pill {
  background-color: orange;
  padding: 3px 10px;
  border-radius: 12px;
  width: fit-content;
  border: 1px solid lightgray;
}

.pill_pending {
  background-color: orange;
  color: white;
}

.pill_approved {
  background-color: lightgreen;
}

.pill_denied {
  background-color: red;
  color: white;
}

.heart {
  width: 18px;
}
.mainImage {
  border-radius: 6px;
}

table.dataTable {
  /* border:1px solid red; */
  width: 250px;
  border-width: 1px;
  border-style: outset;
}

.customize-table {
  height: 100%;
  overflow-y: auto;
  /* overflow:hidden; */
  border-radius: 12px;
}

.name-wrapper {
  padding: 5px;
  display: flex;
  align-items: center;
  justify-items: center;
}

.avator {
  margin-right: 10px;
  display: inline-block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
  box-shadow: inset 0 2px 4px 0 rgb(0 0 0 / 10%);
}

.accountContainer {
  display: flex;
  flex-direction: row;
  gap: 20px;
  height: 200px;
  width: 100%;
  padding: 2rem;
  /* border:1px solid red; */
}

.account_icon {
  width: 150px;
  border: 1px solid #333;
  margin: 0 2%;
  padding: 2%;
  border-radius: 5px;
}

.account_detail {
  width: 48%;
}

.btnClass {
  text-align: right;
}

.edit_btn {
    border: 1px;
    padding: 5px 10px;
    background-color: var(--wrongingBtn);
    border-radius: 4px;
    color: white;
    margin: 0px 10px;
}

.delete_btn {
    border: 1px;
    padding: 5px 10px;
    background-color: var(--deletBtn);
    border-radius: 4px;
    color: white;
}
</style>