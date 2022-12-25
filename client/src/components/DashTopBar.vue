<template>

<div class="dashTopBarContainer">
    <div class="accountName">
        Ame K
    </div>
    <div>
        <router-link tag="div" class="row" :to="{name:'admin_account'}" >
            <div class="account_icon">
                <fa class="icon" size="2x" icon="circle-user"/>
            </div>
        </router-link>
    </div>

</div>

</template>


<style scoped>


.dashTopBarContainer {
    height: 65px;
    background-color: var(--lightGreen);
    width: 100%;

    text-align: right;
    padding: 15px 2% 0;
    color: black !important;

    display: flex;
    flex-direction: row-reverse;
}

.accountName {
    padding: 2px 5px;
}   

a {
    color: black !important;
}
</style>