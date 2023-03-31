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
                <h1 class="dark">404</h1>
                <router-link class="link" tag="li" :to="{name:'home'}">
                    <p>Back to Main</p>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import { ref } from 'vue';
    import { useRouter, useRoute } from 'vue-router'
    const router = useRouter()

    export default {
        name: "404",
        methods: {
            backToMain(ev) {
                router.push({name: 'dashboard'})
            }
        },
    };
</script>

<style scoped>
.loginWrapper {
    /* min-height: 50vh; */
    display:flex;
    height: 100%;
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