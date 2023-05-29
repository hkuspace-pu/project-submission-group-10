<template>

  <!-- Using easy data table to display data https://www.npmjs.com/package/vue3-easy-data-table -->
  <EasyDataTable :headers="headers" :items="store.surveyData" alternating show-index table-class-name="customize-table"
    v-model:items-selected="store.surveyItemsSelected" :loading="store.surveyLoading" @expand-row="showRow">
    
    <template #item-image="{ uploadImg, id, name,userId }">
      <img class="thumbnail" :src="getFirstImage(uploadImg,id,userId)" />
      {{ name }}
    
    </template>

    <!-- Display custom hearts for tree health -->
    <template #item-health="item">
      <div class="health">
        <img class="heart" v-for="index in item.health" src="../assets/images/heartFill.svg" />
        <span v-if="item.health < 5">
          <img class="heart" v-for="index in (5 - item.health)" src="../assets/images/heartEmpty.svg" />
        </span>

      </div>
    </template>

    <!-- Display custom tags -->
    <template #item-status="item">
      <div class="pill"
        :class="item.status == 9 && 'pill_approved', item.status == 1 && 'pill_pending', item.status == 2 && 'pill_denied'">
        {{ itemStatus(item.status)}}
      </div>
    </template>

    <!-- Expanding data -->
    <template #expand="data">
      <div class="dataContainer">
        <div class="topBar">
          <h4 class="dark">{{ data.commonName }} ~ <em>{{ data.scientificName}}</em></h4>
          <div class="tags">
            <div v-for="pill in data.treeType" :key="pill" class="pill">
              {{ pill }}
            </div>
       </div>
        </div>

        <div class="dataContent">
          <div class="leftSide">
            <div class="media">
              <div>
                <!-- <img class="mainImage" :src="selectedImage" /> -->
                <img class="mainImage" :src="getFirstImage(data.uploadImg,data.id,data.userId)" />
              </div>
              <div class="thumbnail_group">
                <!-- {{changeArray(data.uploadImg)}} -->
                <img @click="getFirstImage(media, data.id)" class="thumbnail" v-for="media in changeArray(data.uploadImg)" :src="`https://hktreewatch.oss-cn-hongkong.aliyuncs.com/${data.userId}/${data.id}/${media}`" :key="media" />
              </div>
            </div>
          </div>
          <div class="rightSide">

            <table class="dataTable">
              <thead>
                <tr>
                  <th colspan="2">Tree information</th>
                  <!-- <th>Header</th> -->
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Common Name</td>
                  <td>{{ data.commonName }}</td>
                </tr>
                <tr>
                  <td>Scientific Name</td>
                  <td>{{ data.scientificName }}</td>
                </tr>
                <tr>
                  <td>HK Tree Watch ID</td>
                      <td>001</td>
                  <!-- <td>{{ data.advanced.hktwid }}</td> -->
                </tr>
                <tr>
                  <td>TCMP ID</td>
                  <td>{{ data.tcmpId }}</td>
                </tr>
                <tr>
                  <td>Location</td>
                  <td>{{ data.location }}</td>
                </tr>
                <tr>
                  <td>District</td>
                  <td>{{ data.district }}</td>
                </tr>
                <tr>
                  <td>Responsible Dept.</td>
                  <td>{{ data.responsibleDept }}</td>
                </tr>
                <tr>
                  <td>Native / Exotic</td>
                  <td>{{ data.nativeExotic }}</td>
                </tr>
                <tr>
                  <td>Height</td>
                  <td>{{ data.height }}
                  </td>
                </tr>
                <tr>
                  <td>Health rating</td>
                  <td>
                    <img class="heart" v-for="index in data.health" src="../assets/images/heartFill.svg" />
                    <span v-if="data.health < 5">
                      <img class="heart" v-for="index in (5 - data.health)" src="../assets/images/heartEmpty.svg" />
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>Crown spread</td>
                  <td>{{ data.crownSpread }}</td>
                </tr>
                <tr>
                  <td>Latitude</td>
                  <td>{{ data.latitude }}</td>
                </tr>
                <tr>
                  <td>Longitude</td>
                  <td>{{ data.longtitude }}</td>
                </tr>
                <tr>
                  <td>Health tags</td>
                  <td>
                    <div class="pill" v-for="tag in data.healthTag">{{ tag }}</div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </template>

  </EasyDataTable>
</template>

<script setup>
import { ref, computed,onMounted } from 'vue';

// Local reactive state
const isDataLoading = ref(false);
const clickedRow = ref(null)
const itemsSelected = ref([])

import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
import { useStore } from "@/stores/state.js";
const store = useStore();
// let data = ref([])

let userId = ref(null)
//Mounted

const changeDate = ((createTime) => {
  return new Date(createTime).toLocaleDateString('en-us', { year:"numeric", month:"short", day:"numeric"}) 
})


const changeArray = ((array) => {
  const arr = array.substr(1, array.length - 2).split(", ");
  console.log(arr)
  return arr
})



const getFirstImage = ((uploadImg,id,userId) => {
console.log(uploadImg)
// console.log("ID ", id)
const arr = uploadImg.substr(1, uploadImg.length - 2).split(", ");
// console.log(arr)
// console.log(JSON.parse(uploadImg))
  return `https://hktreewatch.oss-cn-hongkong.aliyuncs.com/${userId}/${id}/${arr[0]}`
})


onMounted(async () => {


await store.getSurvey()


})

const itemStatus = (status)=> {
  switch (status) {
    case 1:
      return 'Pending';
    case  2:
      return  'Denied';
    case 9:
      return 'Approved';
    default:
      return 'Pending';
  }
}



// Methods
const showRow = (index) => {
  clickedRow.value = store.surveyData[index]
};

// Computed Cached 
const selectedImage = computed(() => {
  // console.log(clickedRow.value)
  return clickedRow.value.uploadImg[0]
})



// Dummy Json Data
const headers = [
  { text: "Image", value: "image" },
  { text: "Common Name", value: "commonName" },
  { text: "Chinese name", value: "chineseName" },
  { text: "Health", value: "health", sortable: true },

  { text: "Height", value: "height", sortable: true },
  { text: "District", value: "district", sortable: true },
  { text: "Created At", value: "createTime", sortable: true },
  { text: "Status", value: "status", sortable: true },

];


// const data = [
//   {
//     "thumbnail": "https://source.unsplash.com/random/400x400/?tree,trees,flowers",
//     "common_name": "Bamboo Tree",
//     "chinese_name": "杧果",
//     // "tags" : "stone wall, dead",
//     "health": 3,
//     "height": 55,
//     "district": "Central",
//     "creation_date": "23/11/2019",
//     "status": "Approved",

//     advanced: {
//       hktwid: 22,
//       media: ['https://source.unsplash.com/random/400x400/?tree,trees,flowers', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers,green', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers,green'],
//       family_name: 'asdasd',
//       scientific_name: 'Ficus microcarpa',
//       TCMP_ID: '3453453453453',
//       location: '34 conduit road',
//       tags: ['stone wall', 'dead'],
//       responsible_dept: 'Highways Dept',
//       native_exotic: 'native',
//       updated_at: '23/11/2910',
//       triage_color: 'yellow',
//       x_cord: 234234,
//       y_cord: 234234,
//       height: 4,
//       crown_spread: 4,
//       condition: {
//         overall: 'fair',
//         tags: ['fugs', 'dead wood']
//       },
//       mitigation_measures: ['sdfsf', 'sdfsfd'],
//       conservation_status: {

//       }
//     }
//   }, {
//     "thumbnail": "https://source.unsplash.com/random/400x400/?trees,bark,flowers",
//     "common_name": "Mangoo Tree",
//     "chinese_name": "黃花夾竹桃, 酒杯花",
//     // "tags" : "stone wall, dead",
//     "health": 1,
//     "height": '20',
//     "district": "Central",
//     "creation_date": "23/11/2019",
//     "status": "Pending",

//   advanced: {
//       hktwid: 1,
//       media: ['https://source.unsplash.com/random/400x400/?tree,trees,flowers', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers'],
//       family_name: 'asdasd',
//       scientific_name: 'Ficus microcarpa',
//       TCMP_ID: '3453453453453',
//       location: '34 conduit road',
//       tags: ['stone wall', 'dead'],
//       responsible_dept: 'Highways Dept',
//       native_exotic: 'native',
//       updated_at: '23/11/2910',
//       triage_color: 'yellow',
//       x_cord: 234234,
//       y_cord: 234234,
//       height: '',
//       crown_spread: '',
//       condition: {
//         overall: 'fair',
//         tags: ['fugs', 'dead wood']
//       },
//       mitigation_measures: ['sdfsf', 'sdfsfd'],
//       conservation_status: {

//       }
//     }
//   }, {
//     "thumbnail": "https://source.unsplash.com/random/400x400/?flowers, tree",
//     "common_name": "Bannna Tree",
//     "chinese_name": "黃花夾竹桃",
//     // "tags" : "stone wall, dead",
//     "health": 5,
//     "height": '15',
//     "district": "Central",
//     "creation_date": "23/11/2019",
//     "status": "Denied",

//     advanced: {
//       hktwid: 2,
//       media: ['https://source.unsplash.com/random/400x400/?tree,trees,flowers', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers', 'https://source.unsplash.com/random/400x400/?tree,trees,flowers'],
//       family_name: 'asdasd',
//       scientific_name: 'Ficus microcarpa',
//       TCMP_ID: '3453453453453',
//       location: '34 conduit road',
//       tags: ['stone wall', 'dead'],
//       responsible_dept: 'Highways Dept',
//       native_exotic: 'native',
//       updated_at: '23/11/2910',
//       triage_color: 'yellow',
//       x_cord: 234234,
//       y_cord: 234234,
//       height: '',
//       crown_spread: '',
//       condition: {
//         overall: 'fair',
//         tags: ['fugs', 'dead wood']
//       },
//       mitigation_measures: ['sdfsf', 'sdfsfd'],
//       conservation_status: {

//       }
//     }
//   }

// ];

</script>

<style scoped>
.dashHomeContainer {
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
  background-image: url('../assets/svgloading.svg');
  background-size: cover;
  background-position: center;
  object-fit: contain;
  /* height: auto; */
}

.dataContainer {

  padding: 5px;
  background-color: #f7f7f7;

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
  /* border:1px solid red; */
  /* overflow-y: auto; */
  /* overflow:hidden; */
  border-radius: 12px;
}
</style>