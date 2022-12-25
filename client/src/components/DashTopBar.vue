<template>

<div class="dashTopBarContainer">
    <router-link tag="div" class="row" :to="{name:'admin_account'}" >
        <div class="account_icon">
            <fa class="icon" size="2x" icon="circle-user"/>
        </div>
    </router-link>

</div>

</template>


<style scoped>


.dashTopBarContainer {
    height: 65px;
    background-color: var(--lightGreen);
    width: 100%;
    flex-direction: row;
    text-align: right;
    padding: 15px 2% 0;
}
</style>