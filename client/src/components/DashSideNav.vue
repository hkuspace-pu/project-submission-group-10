<template>

<div class="dashSideNav">
    <div class="menuItems">
        <router-link v-if="role=='Admin'" tag="div" class="row" :to="{name:'dashboard'}">
            <fa class="icon" size="2x" icon="house" :class="$route.name=='dashboard' && 'focused'" />
        </router-link>
        <router-link tag="div" class="row" :to="{name:'new'}" >
            <fa class="icon" size="2x" icon="file-pen" :class="$route.name=='new' && 'focused'"/>
        </router-link>
        <router-link v-if="role=='Admin'" tag="div" class="row" :to="{name:'chart'}" >
            <fa class="icon" size="2x" icon="chart-simple" :class="$route.name=='chart' && 'focused'"/>
        </router-link>

        <router-link v-if="role=='Admin'" tag="div" class="row" :to="{name:'feature'}" >
            <fa class="icon" size="2x" icon="layer-group" :class="$route.name=='feature' && 'focused'"/>
        </router-link>
        <router-link v-if="role=='Admin'" tag="div" class="row" :to="{name:'feature_new'}" >
            <fa class="icon" size="2x" icon="notes-medical" :class="$route.name=='feature_new' && 'focused'"/>
        </router-link>

        <router-link v-if="role=='Admin'||role=='Moderator'" tag="div" class="row" :to="{name:'syncfile'}" >
            <fa class="icon" size="2x" icon="file-arrow-up" :class="$route.name=='syncfile' && 'focused'"/>
        </router-link>
    </div>


    <foot>
        <router-link v-if="role=='Admin'||role=='Moderator'" tag="div" class="row" :to="{name:'users'}" >
            <fa class="icon" size="2x" icon="users" :class="$route.name=='users' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'admin_account'}" >
            <fa class="icon" size="2x" icon="circle-user" :class="$route.name=='admin_account' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'new'}" >
            <fa class="icon" size="2x" icon="circle-question" :class="$route.name=='help' && 'focused'"/>
        </router-link>
        <!-- <router-link tag="div" class="row" :to="{name:'new'}" >
        <fa class="icon" size="2x" icon="circle-question" :class="$route.name=='help' && 'focused'"/>
        </router-link> -->

    </foot>

</div>

</template>

<script>
import { ref,computed } from 'vue';
// localStorage.getItem('key');
export default {
    data() {
        var user_info = JSON.parse(localStorage.getItem('user_info'))
        console.log( 'user_info', user_info )
        var role = user_info.role
        return {
            role
        }
    },
};

</script>


<style scoped>

.dashSideNav {
    /* z-index:100000; */
    /* padding: 1rem; */
    /* width: 80px; */
    height: 100%;
    /* height: calc(100% - 65px); */
    box-shadow: 3px 0px 7px 0px rgba(189,187,189,0.4);
    background-color: #F7F9FA;
    background-color: var(--brown);
    background-color: var(--darkGreen);

    display:flex;
    flex-direction: column;
    
}

.menuItems {
    flex:1;
}
/* :class="$route.name=='new' && 'focused'" */
.icon {

    /* border: 1px solid red; */
    /* background-color: #f0f0f069; */
    padding: 10px;
    border-radius: 6px;
    color: white;
    /* padding:2rem; */

}

.focused {
    background-color: #f0f0f069;
}
.row {
/* margin:10px; */
/* padding:10px; */
/* border:1px solid red; */
padding:15px;
    display:flex;
    flex-direction: row;
    align-items: center;

    justify-content: center;
    /* border-bottom: 1px solid lightgray; */
}

.title {
    font-weight: 400;
    font-size:12px;
}
</style>