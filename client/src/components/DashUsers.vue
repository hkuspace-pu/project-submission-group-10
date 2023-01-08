<template>

  <!-- <h3 class="dark">List Surveys</h3> -->
  <EasyDataTable
    :headers="headers"
    :items="items"
  >

  </EasyDataTable>
  

<!-- </div> -->

</template>

<script setup>
import { ref,computed } from 'vue';

const isDataLoading = ref(false);
const clickedRow = ref(null)
const itemsSelected = ref([])

const showRow = (index) => {
  clickedRow.value = data[index].advanced
};

const selectedImage = computed(() => {
  return clickedRow.value.media[0]
})



const headers = [
      { text: "Name", value: "name", sortable: true  },
      { text: "Title", value: "title", sortable: true },
      { text: "Email", value: "email", sortable: true },
      { text: "Phone No.", value: "phone_number", sortable: true },
      { text: "Role", value: "role", sortable: true },
      { text: "Points", value: "points", sortable: true },
      { text: "Joined Date", value: "join_date", sortable: true },
      { text: "Status", value: "status", sortable: true },
    ];

    const items = [
      { "name": "Leo", "title": "Mr.", "email": 'leo@gmail.com', "phone_number": '61125221',  "role": "Admin",  "points": 0,  "join_date": '2022-10-31',  "status": 1 },
      { "name": "Rishi", "title": "Mr.", "email": 'rishi@gmail.com', "phone_number": '91125221',  "role": "",  "points": 0,  "join_date": '2022-11-30',  "status": 1 },
      { "name": "Simon Wong", "title": "Mr.", "email": 'simon@gmail.com', "phone_number": '67435221',  "role": "Client",  "points": 0,  "join_date": '2022-12-31',  "status": 1 },
    ];


</script>

<style scoped>

.dashHomeContainer {
    /* margin: 3rem; */
    /* padding: 0.5rem; */
  border-radius: 12px;
    background-color: #fefefe;
    height: 100%;
    width: 100%;
    box-shadow: 10px 10px 12px -12px rgba(0,0,0,0.25);

}

.media {
  display:flex;
  flex-direction: column;
  width: 350px;
  justify-content: space-between;
  /* border:1px solid var(--dark); */
  gap: 5px;
  margin: 1rem;
}

.thumbnail_group {
  display:flex;
  flex-direction: row;
  gap:8px;
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
  background-image: url('../assets/logo.svg');
  background-size: cover;
  background-position: center;
  object-fit: contain;
  /* height: auto; */
}
.dataContainer {
  /* border:1px solid red; */
  padding: 5px;
  background-color:#f7f7f7;
  /* background-color: var(--dark); */
  /* display:flex; */
  /* flex-direction: row; */
}

.topBar {
  /* border:1px solid red; */
}

.dataContent {
  display:flex;
}
.leftSide {
  display:flex;
  flex-direction: column;
  gap:5px;
}

.rightSide {
  gap:5px;
  display:flex;
  width: 100%;
  flex-direction: column;

}

.tags {
  display:flex;
  flex-direction: row;
  gap:10px;
  width: 350px;
  /* border:1px solid red; */
}

.pill {
  background-color: orange;
  padding: 3px 10px;
  border-radius: 12px;
  width: fit-content;
  border:1px solid lightgray;
}

.pill_pending {
  background-color: orange;
  color:white;
}

.pill_approved {
  background-color: lightgreen;
}

.pill_denied {
  background-color: red;
  color:white;
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
  overflow-y:auto;
  /* overflow:hidden; */
  border-radius: 12px;
}
</style>