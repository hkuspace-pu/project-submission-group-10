<template>

    <div class="dashSideNav">
        <div class="menuItems">
            <router-link tag="div" class="row" :to="{ name: 'dashboard' }">
                <fa class="icon" size="2x" icon="house" :class="$route.name == 'dashboard' && 'focused'" />
            </router-link>
            <router-link tag="div" class="row" :to="{ name: 'new' }">
                <fa class="icon" size="2x" icon="file-pen" :class="$route.name == 'new' && 'focused'" />
            </router-link>
        </div>


        <foot>
            <router-link tag="div" class="row" :to="{ name: 'new' }">
                <fa class="icon" size="2x" icon="circle-question" :class="$route.name == 'help' && 'focused'" />
            </router-link>
            <!-- <router-link tag="div" class="row" :to="{name:'new'}" >
   <fa class="icon" size="2x" icon="circle-question" :class="$route.name=='help' && 'focused'"/>
</router-link> -->
        </foot>
    </div>
</template>


<style scoped>
.dashSideNav {
    height: 100%;
    box-shadow: 3px 0px 7px 0px rgba(189, 187, 189, 0.4);
    background-color: #F7F9FA;
    background-color: var(--brown);
    background-color: var(--darkGreen);
    display: flex;
    flex-direction: column;
}

.menuItems {
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

}

.title {
    font-weight: 400;
    font-size: 12px;
}
</style>