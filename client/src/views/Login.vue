<template>
    <div class="loginWrapper">
        <div class="treeImage">
            <fa size="2x" icon="tree"/>
            <p>HK Tree Watch</p>
               </div>
        <div class="loginBox">
      
            <div class="leftSide">
               <div class="topBar">
                <fa size="2x" icon="tree"/>
  
               </div>

               <div class="treeImage">
                <img class="tree" src="../assets/images/tree.svg"/>
               </div>

            </div>


            <div class="rightSide">

                <form @submit.prevent="login">
                     <div class="login">
                    <h3 class="dark">Login</h3>
                   <label for="username">Email:</label> 
                   <input required v-model="email" type="text" id="username" name="username"/>
                   <label for="password">Password</label> 
                    <input required v-model="password" type="password" id="password" name="password"/>
                    <button type="submit" class="btn">
                   
                 <transition name="spinner" mode="out-in">
                  <span key="notloading" class="btnText" v-if="!isLoading">Login</span>
                  <span key="loading" class="btnText" v-else>  <fa size="lg" icon="spinner" pulse> </fa> </span>
                </transition>
                    
                    
                    </button>    
                </div>
                </form>

                <div class="otherContent">
                <p>Forgot password?</p>
                <p>Don't have a account? Register here</p>
                </div>
                   </div>
                  



        </div>
<p v-show="loginError" style="color:red">Please check your login credentials.</p>

    </div>




</template>

<script setup>
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router'
import { useStore } from "@/stores/state.js";
const store = useStore();
const router = useRouter()
const email = ref(null);
const password = ref(null);
const isLoading = ref(false);
const loginError = ref(false);
async function login() {
    try {
    isLoading.value = true
     loginError.value = false


    // API WAY
    const url = "https://api.hktreewatch.org"

    const resp = await fetch(url+'/login', {
        method: 'POST',
        body :  JSON.stringify(btoa(email.value+":"+password.value)),
        headers : {
        // "Content-type": "application/json;charset=UTF-8",
            "Authorization" : btoa(email.value+":"+password.value)
        }
    })

    // SIMON LOCAL JSON WAY
    // var url
    // if ( email.value == 'ivy@gmail.com' ) {
    //     url = 'client.json'
    // } else if ( email.value == 'leo@gmail.com' ) {
    //     url = 'admin.json'
    // } else if ( email.value == 'rishi@gmail.com' ) {
    //     url = 'moderator.json'
    // }
    // const resp = await fetch(url, {
    //         method: 'GET'
    //     })
try {
    console.log(resp)
    const token = await resp.json()
     console.log(token)
    localStorage.setItem('user_info',JSON.stringify(token));
    store.userInfo = token
    router.push({name: 'dashboard'})
    console.log('USERID' , store.getUserInfo[0].userId)
   

} catch(e) {
  console.log('LOGGIN FAILED')
}    
    
   
  
}
    catch(e) {
        isLoading.value = false
        loginError.value = true
        console.log('error1 : ', e.message)
        
    } finally {
        // isLoading.value = false
    }

}





</script>

<style scoped>
.loginWrapper {
    /* min-height: 50vh; */
    display:flex;
    height: 100vh;
    /* overflow-x:auto; */
   flex-direction: column; 
   align-items: center;
   justify-content: center;
     background-image: url('../assets/login-background.svg');
   background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background-position: bottom;
    padding: 12px;

    /* height: 400px; */
    /* width: 500px; */
  
}

.loginBox {
    max-width: 90%;
 max-height: 600px;
height: 400px;
width: 650px;
  border-radius: 24px;
 background-color: var(--backgroundColor);
  box-shadow: 0 0 60px -20px rgb(0 0 0 / 35%);
  display:flex;
  flex-direction: row;
  margin: 2rem;
  overflow:hidden;
}

.leftSide {
width: 45%;
padding: 20px;
padding-bottom: 0;
background: var(--lightGreen);
flex-direction: column;
justify-content: center;
align-items: center;

}

.rightSide {
    display:flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 1rem;
    flex:1;
    /* border:1px solid red; */
    /* width: 500px; */
}

.otherContent {
    margin-top:2rem;
    font-size: 12px;
    width: 100%;
}

form {
    width: 100%;
}
.login {
    width: 100%;
    display:flex;
    flex-direction: column;
    gap:0.5rem;
    /* border:1px solid red; */
}

.topBar {
    color: var(--myDark);
    display:flex;
    /* justify-content: center; */
    gap:0.5rem;
    align-items:center;
}


.treeImage {
    color: var(--dg2);
    margin: 2rem 0;
    text-align: center;
   
}
.tree {
width: 220px;
}


@media only screen and (max-width:800px) {
.leftSide {
    display:none;
}

.rightSide {

}


}

</style>