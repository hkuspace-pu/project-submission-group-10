<template>
    <div class="loginWrapper">
        <div class="loginBox">
            <div class="leftSide">
               
            </div>


            <div class="rightSide">


            </div>
        </div>


    </div>




</template>

<script>

</script>

<style scoped>
.loginWrapper {
   border:2px solid red;
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
  
}

.loginBox {
    max-width: 960px;
 max-height: 600px;
  border-radius: 24px;
 background-color: white;
  box-shadow: 0 0 60px -20px rgb(0 0 0 / 85%);
  display:flex;
  flex-direction: row;
  overflow:hidden;
}

.leftSide {
width: 70%;
padding: 20px;
padding-bottom: 0;
background: grey;
flex-direction: column;
justify-content: space-between;
}
</style>