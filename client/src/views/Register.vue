<template>
    <div class="registerWrapper">
        <div class="treeImage">
            <fa size="2x" icon="tree"/>
            <p>HK Tree Watch</p>
               </div>
        <div class="registerBox">
      
            <div class="leftSide">
               <div class="topBar">
                <fa size="2x" icon="tree"/>
  
               </div>

               <div class="treeImage">
                <img class="tree" src="../assets/images/tree.svg"/>
               </div>

            </div>


            <div class="rightSide">

                <form @submit.prevent="register">
                     <div class="register">
                        <h3 class="dark">Register</h3>
                        <label for="username">Username</label> 
                        <input required :class="{invalid: username_invalid}" v-model="username" type="text" id="username" name="username"/>

                        <label for="fullname">Fullname</label> 
                        <input required :class="{invalid: fullname_invalid}" v-model="fullname" type="text" id="fullname" name="fullname"/>

                        <label for="email">Email:</label> 
                        <input required :class="{invalid: email_invalid}" v-model="email" type="email" id="email" name="email"/>

                        <label for="password">Phone number</label> 
                        <input required :class="{invalid: phoneNumber_invalid}" v-model="phoneNumber" type="number" id="phoneNumber" name="phoneNumber"/>

                        <label for="password">Password</label> 
                        <input required :class="{invalid: password_invalid}" v-model="password" type="password" id="password" name="password"/>

                        <label for="password">Confirm Password</label> 
                        <input required :class="{invalid: cpassword_invalid}" v-model="cpassword" type="password" id="cpassword" name="cpassword"/>

                        <button type="submit" class="btn">
                            <transition name="spinner" mode="out-in">
                            <span key="notloading" class="btnText" v-if="!isLoading">register</span>
                            <span key="loading" class="btnText" v-else>  <fa size="lg" icon="spinner" pulse> </fa> </span>
                            </transition>
                        </button>    
                    </div>
                </form>
            </div>
        </div>
        <!-- <p v-show="registerError" style="color:red">Please check your register credentials.</p> -->
        <p v-show="registerError" style="color:red">Please try again later.</p>

    </div>




</template>

<script setup>
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const email = ref(null);
const password = ref(null);
const cpassword = ref(null);
const token = ref(null);
const phoneNumber = ref(null);
const fullname = ref(null);
const username = ref(null);
const role = ref(4);
const isLoading = ref(false);
const registerError = ref(false);

const email_invalid = ref(false);
const password_invalid = ref(false);
const cpassword_invalid = ref(false);
const phoneNumber_invalid = ref(false);
const fullname_invalid = ref(false);
const username_invalid = ref(false);

const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/ig;
async function register() {
    try {
        registerError.value = false

        console.log( 're' )
        if ( username.value == '' ) {
            return
        }

        if ( email.value == '' ) {
            return
        }
        password_invalid.value = false
        var pTest = regex.test(password.value)
        if ( password.value == '' || pTest == false ) {
            password_invalid.value = true
            return
        }

        if ( phoneNumber.value == '' ) {
            return
        }

        if ( fullname.value == '' ) {
            return
        }
        cpassword_invalid.value = false
        // var cpTest = regex.test(cpassword.value)
        // if ( cpassword.value == '' || cpTest == false ) {
        //     cpassword_invalid.value = true
        //     return
        // }

        if ( cpassword.value != password.value ) {
            cpassword_invalid.value = true
            return
        }

        isLoading.value = true

        // API WAY
        const url = "https://api.hktreewatch.org"

        const data = new URLSearchParams();
        data.append('username', username.value);
        data.append('fullname', fullname.value);
        data.append('password', password.value);
        data.append('email', email.value);
        data.append('phoneNumber', phoneNumber.value);
        data.append('role', 4);

        // var _body = JSON.stringify(btoa(role.value+":"+fullname.value+":"+email.value+":"+password.value+":"+phoneNumber.value+":"+username.value))
        const resp = await fetch(url+'/createUser', {
            method: 'POST',
            body :  data,
            headers : {
                // "Content-type": "application/json;charset=UTF-8",
                // "Authorization" : btoa(role.value+":"+fullname.value+":"+email.value+":"+password.value+":"+phoneNumber.value+":"+username.value)
            }
        })

        console.log(resp)
        const token = await resp.json()
        console.log(token)
        localStorage.setItem('user_info',JSON.stringify(token));
        
        setTimeout(() => {
            isLoading.value = false
            router.push({name: 'dashboard'})
        }, 1200);

    }
    catch(e) {
        isLoading.value = false
        registerError.value = true
        console.log('error1 : ', e.message)
        
    } finally {
        // isLoading.value = false
    }

}

</script>

<style scoped>
.registerWrapper {
    /* min-height: 50vh; */
    display:flex;
    height: 100%;
    /* overflow-x:auto; */
   flex-direction: column; 
   align-items: center;
   justify-content: center;
     background-image: url('../assets/register-background.svg');
   background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background-position: bottom;
    padding: 12px;
    /* height: 400px; */
    /* width: 500px; */
  
}

.registerBox {
    max-width: 90%;
 max-height: 600px;
height: 600px;
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
.register {
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

.invalid {
    border-color: red !important;
}


}

</style>