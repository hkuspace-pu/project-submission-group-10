<template>

<div class="dashSideNav">
    <div class="menuItems">
        <router-link tag="div" class="row" :to="{name:'dashboard'}">
            <fa class="icon" size="2x" icon="house" :class="$route.name=='dashboard' && 'focused'" />
        </router-link>
        <router-link tag="div" class="row" :to="{name:'survey'}" >
            <fa class="icon" size="2x" icon="notes-medical" :class="$route.name=='survey' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'new'}" >
            <fa class="icon" size="2x" icon="file-pen" :class="$route.name=='new' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'chart'}" >
            <fa class="icon" size="2x" icon="chart-simple" :class="$route.name=='chart' && 'focused'"/>
        </router-link>

        <router-link tag="div" class="row" :to="{name:'feature'}" >
            <fa class="icon" size="2x" icon="layer-group" :class="$route.name=='feature' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'feature_new'}" >
            <fa class="icon" size="2x" icon="file-circle-plus" :class="$route.name=='feature_new' && 'focused'"/>
        </router-link>

        <router-link tag="div" class="row" :to="{name:'syncfile'}" >
            <fa class="icon" size="2x" icon="file-arrow-up" :class="$route.name=='syncfile' && 'focused'"/>
        </router-link>
    </div>


    <foot>
        <router-link tag="div" class="row" :to="{name:'admin_account'}" >
            <fa class="icon" size="2x" icon="circle-user" :class="$route.name=='admin_account' && 'focused'"/>
        </router-link>
        <router-link tag="div" class="row" :to="{name:'new'}" >
            <fa class="icon" size="2x" icon="circle-question" :class="$route.name=='help' && 'focused'"/>
        </router-link>
    </foot>

</div>

</template>


<style scoped>
.dashSideNav {
    /* height: 100%; */
    box-shadow: 3px 0px 7px 0px rgba(189, 187, 189, 0.4);
    background-color: var(--darkGreen);
    display: flex;
    overflow: hidden;
    flex-direction: column;
    /* flex-direction: row; */
    /* height: 100%; */
    /* width: 100%; */
    /* border:1px solid red; */
    /* flex-direction: column; */
}

.menuItems {
    display:flex;
    flex-direction: column;
    /* WIDTH: 100%; */
    flex: 1;
}

.icon {
    padding: 10px;
    border-radius: 6px;
    color: white;
}

.focused {
    background-color: #f0f0f069;
}

.row {

    padding: 15px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    /* border:1px solid red; */

}

.title {
    font-weight: 400;
    font-size: 12px;
}

foot {
    display:flex;
    flex-direction: column;
    /* border:1px solid red; */
    /* margin-left:auto; */
    /* margin-top:auto; */
    /* display:flex; */
}

@media only screen and (max-width:600px) {
.menuItems {
    flex-direction: row;
}

foot {
    flex-direction: row;
}
.dashSideNav {
    flex-direction: row;
    justify-content: space-evenly;
}

.row {
    padding: 5px;
}
.icon{
    font-size: 26px;
}
}
</style>