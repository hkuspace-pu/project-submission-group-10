<template>


<div class="dashTopBar">
    <div class="logo">
        <fa size="2x" icon="tree"/>
    </div>
    <div class="dashTopBarContainer">

        <div class="accountName">
            <p>{{ full_name }}</p>
            <p>{{ role }}</p>
        </div>
        <div>
            <router-link tag="div" class="row" :to="{name:'admin_account'}" >
                <div class="account_icon">
                    <fa class="icon" size="2x" icon="circle-user"/>
                </div>
            </router-link>
        </div>

    </div>
</div>

</template>
<script>
import { ref,computed } from 'vue';
// localStorage.getItem('key');
export default {
    data() {
        var user_info = JSON.parse(localStorage.getItem('user_info'))
        console.log( 'user_info', user_info )
        var full_name = user_info.full_name
        var role = user_info.role
        return {
            full_name, role
        }
    },
};

</script>


<style scoped>

.dashTopBar{
    height: 65px;
    background-color: var(--lightGreen);
    width: 100%;
}

.dashTopBarContainer {
    width: calc(95% - 7px);
    padding: 15px 2% 0;
    color: black !important;

    display: flex;
    flex-direction: row-reverse;
}

.accountName {
    padding: 2px 5px;
    margin-top: -2px;
    line-height: 1;
}   

a {
    color: black !important;
}

.logo {
    width: 5%;
    margin-left: 7px;
    float: left;
    padding: 15px 2% 0;
    font-size: 15px;
    font-weight: 600;
}
</style>