<template>


<div v-if="store.getUserInfo" class="dashTopBar">
    <div @click="$router.push({name : 'dashboard'})" class="logo">
        <fa size="2x" icon="tree"/>
    </div>
    <div class="rightSide">

        <router-link tag="div" class="profile" :to="{name:'admin_account'}" >
            
        <img :src="`https://avatars.dicebear.com/api/avataaars/${email}.svg?mouth=smile&radius=50&skinColor=edb98a`"/>     
            <div class="accountName">
            <p>{{ email }}</p>
            <p :class="roleCheck() == 'Admin' ? 'red' : 'dark'">{{roleCheck()}}</p>
            </div>
        </router-link>

    </div>
</div>

</template>
<script setup>
import { ref,computed,onMounted, reactive} from 'vue';
import { useStore } from "@/stores/state.js";
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const store = useStore();
let role = ref()
let email = ref()


// localStorage.getItem('key');
// export default {
//     data() {
//         var user_info = JSON.parse(localStorage.getItem('user_info'))
//         console.log( 'user_info', user_info )
//         var full_name = user_info.full_name
//         var role = user_info.role
//         return {
//             full_name, role
//         }
//     },
// };

onMounted(async () => {

  if (!store.getUserInfo) {
    router.push({name: 'login'})
  }
role.value = store.getUserInfo[0].role
email.value = store.getUserInfo[0].email
// if (store.getUserInfo) {
// // let role = reactive(store.getUserInfo[0].role)
// // let email = reactive(store.getUserInfo[0].email)
// email.value = store.getUserInfo[0].email
// role.value = store.getUserInfo[0].role
// }
})

const roleCheck = (() => {
   if (role.value == 4) {
    return 'Admin'
   } else {
    return 'User'
   }
    })


</script>


<style scoped>

.dashTopBar{
    height: 65px;
    background-color: var(--lightGreen);
    width: 100%;
    display:flex;
    padding: 0 0.5rem;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
}

.logo {
    color: var(--dg2);

}
.rightSide {
    display:flex;
    flex-direction: column;
    align-items: center;
    /* width: calc(95% - 7px); */
    /* padding: 15px 2% 0; */
   /* color: black !important; */

}

.red {
    color: red;
    font-weight: 600;
}

.dark {
    color:black;
}
.rightSide img {
    height : 50px;
    width: 50px;
    border:1px solid var(--brown);
    background-color: var(--darkGreen);
    border-radius :50%;
}
.profile {
    display:flex;
    flex-direction: row;
    gap: 8px;
    align-items: center;
    text-decoration: none;
}

.accountName {
    display:flex;
    flex-direction: column;
   font-size: 13px;
}   


a {
    color: black !important;
}


</style>