<template>

<div class="heroContainer">
    <!-- <img style="height:600px; weight:100%" src="/src/assets/images/Great-Trossachs-Forest-National-Nature-Reserve.jpg"/> -->


    <div class="heroTitle">
    <!-- <div class="heroTitle" style="padding: 0 2rem 2rem 2rem;" :class="{g0:cutCount==0,g1:cutCount==1}"> -->

        <div id="cf2" class="shadow">
            <!-- <img class="bottom" :class="{transparent:cutCount==1, hidden:cutCount>1}" src="../assets/images/Great-Trossachs-Forest-National-Nature-Reserve.jpg" />
            <img class="top" :class="{transparent:cutCount==2, hidden:cutCount>2}" src="../assets/images/re21.png" /> -->

            <img class="bottom" :class="{transparent:cutCount==1, hidden:cutCount>1}" src="../assets/images/Great-Trossachs-Forest-National-Nature-Reserve.jpg" />
            <img class="top" :class="{transparent:cutCount==2, hidden:cutCount>2}" src="../assets/images/re21.png" />
            <img class="top" :class="{transparent:cutCount==3, hidden:cutCount>3}" src="../assets/images/re22.png" />
            <img class="top" :class="{transparent:cutCount==4, hidden:cutCount>4}" src="../assets/images/re23.png" />
            <img class="top" :class="{transparent:cutCount==5, hidden:cutCount>5}" src="../assets/images/re24.png" />
        </div>

        <div class="heroTitle zIndex5">
            <h1 class="dark gameTitle">{{ title }}</h1>
            <h2 class="dark gameTitle">{{ subTitle }}</h2>
            
            <XyzTransition appear xyz="fade down delay-2">
                <img class="tree" :class="{hidden: cutCount==5}" src="../assets/images/tree.png"/>
            </XyzTransition>

            <XyzTransition appear xyz="fade down delay-2">
                <img class="tree ax" v-if="showGame" :class="{ax_rotate: gotoRotate, hidden: cutCount==5}" src="../assets/images/ax.png"/>
            </XyzTransition>

            <a class="mark btn_rotate" @click="gameStart()" :class="{hidden: showGame}">Do you want to play a game?</a>
            <a class="mark btn_rotate" @click="btnRotate()" :class="{hidden: !showGame, hidden: cutCount==5}" :disabled="gotoRotate">Click me</a>

            <XyzTransition appear xyz="fade down delay-2">
                <p class="qDesc" v-if="showQ" :class="{transform1s: showQBtn}">Is that what you want ?</p>
            </XyzTransition>

            <XyzTransition appear xyz="fade down delay-2">
                <p class="mark rotate btnQuiz" v-if="showQBtn" @click="toLogin()">Join us, to change the future</p>
                <!-- <router-link class="link" :to="{name:'login'}">
                    <fa /> <p class="mark rotate btnQuiz" v-if="showQBtn">Join us, to change the future</p>
                </router-link>  -->
            </XyzTransition>

        </div>

    </div> 
    <!-- <img style="height:600px; weight:100%" src="/src/assets/images/Great-Trossachs-Forest-National-Nature-Reserve.jpg"/> -->
 </div>


</template>


<script>
    import { ref,computed } from 'vue';
    
    export default {
        data() {
            return {
                gotoRotate: false,
                title: 'Hong Kong Tree Watch',
                subTitle: 'A natural science survey system',
                cutCount: 0,
                showQ: false,
                showQBtn: false,
                showGame: false
            }
        },
        methods: {
            gameStart(){
                this.showGame = true
            },
            btnRotate() {
                this.gotoRotate = true
                setTimeout(() => {
                    this.gotoRotate = false
                }, 650);

                this.cutCount++

                switch (this.cutCount) {
                    case 1:
                        this.title = 'Do it'
                        this.subTitle = 'Just do it'
                        break;
                    case 2:
                        this.title = 'Good Job'
                        this.subTitle = 'Try again'
                        break;
                    case 3:
                        this.title = 'Try harder'
                        this.subTitle = 'You almost done'
                        break;
                    case 4:
                        this.title = 'One more PLEASE'
                        this.subTitle = 'I\'m the bad guy ~ ~ ~ '
                        break;
                    case 5:
                        this.title = 'WOW, Congratulations!!'
                        this.subTitle = 'You ruined the world. Well done'
                        setTimeout(() => {
                            this.showDesc()
                        }, 2000);
                        break;
                    default:
                        this.title = 'Hong Kong Tree Watch'
                        this.subTitle = 'A natural science survey system'
                }
            },
            showDesc() {
                this.showQ = true
                setTimeout(() => {
                    this.showQBtn = true
                },2000);
            },
            toLogin() {
                window.location.href="login"
            }
        },
    }

</script>


<style scoped>

.heroContainer {
    height: 600px;
    width: 100%;
    position:relative;
    /* background: url('../assets/images/Great-Trossachs-Forest-National-Nature-Reserve.jpg'),#F7FAFC; */
    background: url('../assets/images/_99861388_p05cfkst.jpg'),#F7FAFC;
    background-size:100%;
    background-repeat: no-repeat;
    background-position: bottom;
    overflow:hidden;

    /* background: linear-gradient(to right, #ada996, #f2f2f2, #dbdbdb, #eaeaea);  */
/* background-color: #F7FAFC; */
/* z-index:-100; */
    
    /* padding: 2rem; */
    padding-top: 2rem;
}

.bird {
    position:absolute;
    width: 40px;
    top:17%;
    right:10%;

}

.bird2 {
    position:absolute;
    width: 75px;
    top:22%;
    right:9%;

}


.butterfly {
    position:absolute;
    width: 55px;
    transform:rotate(20deg);
    top:22%;
    left:9%;

}
.heroTitle {
    display:flex;
    flex-direction:column;
    justify-content: center;
    align-items: center;
    /* border:1px solid red; */

}

.heroTitle img {
    margin : 1.2rem 0;
}



p {
    position:absolute;
    bottom:10px;
    margin: 10px;
    color: white;
}

.tree {
    height: 400px;
    /* width: 380px; */
    padding: 10px 0;

}

.ax {
    position: absolute;
    height: 200px;
    margin: 150px 200px 0px 0px !important;
}

.ax_rotate {
    /* transform: rotate(80deg); */
    transform: translate(50px, 0px) rotate(80deg) ;
    transition: 0.1s ease-in;
}

.btn_rotate {
    top: -100px;
    position: relative;
}

#cf2 {
    position:relative;
    /* height:281px; */
    width:100%;
    margin:0 auto;
}
#cf2 img {
    width: 100%;
    position:absolute;
    left:0;
    -webkit-transition: opacity 1s ease-in-out;
    -moz-transition: opacity 1s ease-in-out;
    -o-transition: opacity 1s ease-in-out;
    transition: opacity 1s ease-in-out;
    margin: -1px 0 0 0;
}

#cf2 img.transparent {
    opacity:0;
}

.zIndex5 {
    z-index: 5;
    padding: 0 2rem 2rem 2rem;
}

.qDesc {
    font-size: 29px;
}

.gameTitle {
    color: var(--gameTitle)
}

.transform1s {
    transform: translate(0px, -60px);
    transition: 0.6s ease-in;
}

@media (max-width:600px) {
   
    .tree {
        width: 280px;
    }
}


.sqContainer {
    margin: 1rem 0;
    width: 100%;
    /* height: 380px; */
    padding: 2rem;
    display:flex;
    flex-direction: column;
    flex-direction: center;
    align-items: center;
    gap: 10px;
    /* overflow:hidden; */
    /* position:relative; */

}

.correct {
      background-color: green;
}

.sqCol {
    display:flex;
    flex-direction: row;
    flex-wrap: wrap;
    height: 100%;
    width: 100%;
    gap: 1.5rem;
    justify-content: space-evenly;
    /* flex-wrap: wrap; */
}

.sqCol img {
    /* width: 100px; */
    height: 120px;
    /* width: 100px; */
    /* object-fit: contain; */
}

.sqCategory {
    width: 80%;
    display:flex;
    flex-direction: column;
    justify-content: center;
    gap:15px;
    align-items: center;

    padding-bottom: 20px;
    border-radius: 16px;
    background-color:  var(--quizBg);
}

.sqTitle {
    margin: 0;
    text-align: center;
    width: 100%;
    border-radius: 16px 16px 0 0;
}

.sqAns {
    width: 80%;
    margin-left: 10%;
    margin-right: 10%;
    cursor: pointer;
}

.sqWidth-80 {
    width: 80%;
    text-align: right;
}

.btnQuiz {
    cursor: pointer;
    background: var(--quizBtn);
    color: var(--backgroundColor);
}

.wrongQuiz {
    background-color: var(--quizWrong)
}

.passQuiz {
    background-color: var(--quizPass)
}

.hidden {
    display:none
}

.sqDesc {
    margin: 0px 10%;
}

.sqDescBlock {
    height: 150px;
    overflow: auto;
}

.overFlow {
    background-image: linear-gradient(rgba(255,255,255,0),rgba(255,255,255,1));
    /* padding-top: 0px; */
    margin: 0px 50px;
    margin-top: -80px;
    position: relative;
    z-index: 10;
    text-align: center;
}
</style>