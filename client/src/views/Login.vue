<template>
    <div class="loginWrapper">
        <div class="loginBox">
            <div class="leftSide">
               <div class="topBar">
                <fa size="2x" icon="tree"/>
                <p>HK TREE WATCH</p>
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


    </div>




</template>

<script setup>
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const email = ref(null);
const password = ref(null);
const isLoading = ref(false);

async function login() {
    try {
    isLoading.value = true
<<<<<<< HEAD
    const resp = await fetch('http://18.118.83.77:9000/login', {
        method: 'POST',
        headers : {
        "Content-type": "application/json;charset=UTF-8",
        "Authorization" : btoa(email.value+":"+password.value)}
    })
=======
    // const resp = await fetch('https://httpbin.org/get', {
    //     method: 'GET',
    //     headers : {
    //     "Content-type": "application/json;charset=UTF-8",
    //     "Authorization" : 'Basic '+ btoa(email.value+":"+password.value)}
    // })
    var url
    if ( email.value == 'simon@gmail.com' ) {
        url = 'client.json'
    } else if ( email.value == 'leo@gmail.com' ) {
        url = 'admin.json'
    } else if ( email.value == 'rishi@gmail.com' ) {
        url = 'moderator.json'
    }
    const resp = await fetch('/src/assets/'+url, {
            method: 'GET'
        })
>>>>>>> dev-simon
    const token = await resp.json()
    console.log(token)
    localStorage.setItem('user_info',JSON.stringify(token));
    router.push({name: 'dashboard'})
    // return resp2

}
    catch(e) {
        console.log('error : ', e.message)
        
    } finally {
        isLoading.value = false
    }

}





</script>

<style scoped>
.loginWrapper {
    min-height: 100vh;
    display:flex;
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
    max-width: 960px;
 max-height: 600px;
height: 400px;
width: 700px;
  border-radius: 24px;
 background-color: white;
  box-shadow: 0 0 60px -20px rgb(0 0 0 / 85%);
  display:flex;
  flex-direction: row;
  overflow:hidden;
}

.leftSide {
width: 45%;
padding: 20px;
padding-bottom: 0;
background: lightblue;
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
    margin: 2rem 0;
    text-align: center;
   
}
.tree {
width: 220px;
}

</style>