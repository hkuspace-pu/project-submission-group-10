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
      { text: "Place", value: "place" },
      { text: "Tree", value: "tree", sortable: true },
      { text: "Weight (kg)", value: "weight", sortable: true },
      { text: "Age", value: "age", sortable: true }
    ];

    const items = [
      { "name": "Curry", "height": 178, "weight": 77, "age": 20 },
      { "name": "James", "height": 180, "weight": 75, "age": 21 },
      { "name": "Jordan", "height": 181, "weight": 73, "age": 22 }
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