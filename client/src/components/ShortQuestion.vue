<template>

<div class="sqContainer">
    <h2 class="mark">Quiz</h2>

    <div class="sqCol">
        <div class="sqCategory">
            <h3 class="mark sqTitle">Q{{q_no}} - {{sData.Question}}</h3>

            <a class="mark rotate sqAns" :class="{
                wrongQuiz:wrongAns[index],
                passQuiz:corrAns[index]
            }" @click="submitAns(index)" v-for="(item,index) in sData.Ans">{{item}}</a>

            <div class="sqWidth-80" :class="{hidden:!is_submitted}">
                <a class="mark rotate btnQuiz" @click="showDesc()">Read More</a>
                <a class="mark rotate btnQuiz" @click="showNext()" :class="{hidden:(q_no==q_count)}">Next</a>
                <a class="mark rotate btnQuiz" :class="{hidden:(q_no!=q_count)}">Register</a>
            </div>

            <div :class="{hidden:!_show_desc}">
                <div class="sqDesc" :class="{spDescBlock:!logined}" v-html="sData.desc"></div>

                <div class="overFlow" :class="{hidden:logined}">
                    <a class="mark rotate btnQuiz">Login to read more</a>
                </div>
            </div>

        </div>
    </div>

   

</div>
</template>


<script>


    import { ref,computed } from 'vue';

    const qData =  [{
        Question: "以下那一項不能讓樹木有適當的生長環境?",
        Correct: 2,
        Ans: [
            "在地面和地下均預留足夠空間", 
            "定期修剪樹冠及移除枯枝或斷枝", 
            "樹木及建築物應越接近越好", 
            "齊手合力監察社區樹木的健康狀況"
        ],
        desc: 
            `
                <h4>如何快速判斷樹木對土壤空間的需求？</h4>
                一般常說，樹木根系分布在樹冠內的區域寬幅。但也有部分樹種，根系伸展遠超過樹冠外的水平根系。僅停留在樹冠內伸展根系的樹種反而少。如此一來，究竟樹木需要多大的空間才能適當的生長，至今依舊無法確實判斷。<br/>

                但也可以就根系吸收的範圍掌握，如細根百分五十的分布範圍集中於樹冠半徑之內，以此作為樹木管理面積的一個基準。<br/>

                實際上，植栽時要確保面積也確實有其難度。原則上以根系能夠伸展的面積越寬闊越好，特別是行道樹改以綠帶狀種植，這要比單獨的植栽穴提供了更寬廣的空間。<br/><br/>

                <h4>除了坪數外，根系的成長也與「建材」有關！</h4>
                另一方面樹冠生長茂密，根系也會彼此之間出現相互競爭的關係。<br/>

                植栽的土層，存在許多的大型石礫、不透水層等，這也讓原本根系形態出現許多的變化。換句話說，根系除了先天遺傳要素，也會受到後天環境的物理條件影響。如黏土質時，根系容易伸展不良；其次為砂質土，而最適切為壤土。<br/>


                根系除了先天遺傳要素，也會受到後天環境的物理條件影響，比如土壤。<br/>
                樹木若種植於黏土質時，下雨時黏土易於分散，變得黏稠、摩擦抵抗也隨著減少。當持續晴天時，反而黏土粒子因乾燥而固結如同水泥般，這類的土性是非常容易阻害根系伸長生長。<br/>

                一般土壤表層分布細根多，同時表層的有機物、孔隙量、氧氣量較多進而促進生長。相對之下，越到下層土壤的孔隙越少，根系生長也就越為不良。`
    },{
        Question: "常見的樹木問題不包括?",
        Correct: 3,
        Ans: [
            "有病蟲害", 
            "不適當安裝纜索或支撐物", 
            "傾斜樹木", 
            "生長良好的樹木"
        ], 
        desc: `
            <h4>常見的樹木問題</h4>
            每棵樹木跟人一樣，都有其正常生命周期，由萌芽至成熟階段都會面對一些影響其健康及安全的危險。由於香港樹木的數量龐大，而樹木的健康和結構狀況會隨着它們的生命周期及外在環境不斷改變而出現變化，政府呼籲公眾協助監察社區內的樹木的狀況。<br/><br/>

            <h4>常見的樹木問題包括</h4>
            <h5>基本狀況</h5>
            <ul>
                <li>有病蟲害</li>
                <li>不適當安裝纜索或支撐物</li>
                <li>傾斜樹木</li>
                <li>呈現真菌子實體</li>
                <li>死樹</li>
                <li>生長不良的樹木</li>
            </ol><br/>
            <h5>樹冠狀況</h5>
            <ul>
                <li>樹冠頂上的樹枝枯死</li>
                <li>樹木被去頂</li>
                <li>低活冠比</li>
            </ol><br/>
            <h5>枝幹狀況</h5>
            <ul>
                <li>枝幹有裂縫或裂開</li>
                <li>枝幹出現樹洞</li>
                <li>枝幹出現腐爛</li>
                <li>交疊枝</li>
                <li>樹枝枯死</li>
                <li>懸吊斷枝</li>
            </ol><br/>
            <h5>樹幹狀況</h5>
            <ul>
                <li>腫瘤</li>
                <li>等勢莖</li>
                <li>水橫枝</li>
                <li>內夾樹皮</li>
                <li>多枝幹</li>
                <li>樹幹有裂縫或裂開</li>
                <li>樹幹出現樹洞</li>
                <li>樹幹出現腐爛</li>
            </ol><br/>
            <h5>枝幹狀況</h5>
            <ul>
                <li>根脊不現</li>
                <li>纏繞根</li>
                <li>根部翻起</li>
                <li>根部沒有足夠生長空間</li>
            </ol>

            <br/><br/>
            <h4>報告問題樹木</h4>
            市民可以向“1823”電話中心報告有問題樹木。“1823”電話中心全日運作，透過電話、電郵、傳真或函件受理市民的投訴和查詢。該電話中心提供一個有效渠道，集中處理市民就樹木事宜提出的投訴或查詢。<br/>
            市民亦可通過“Tell me@1823”的智能手機應用程式記下問題樹木的實際位置及加上相片連錄音或文字，以便有關部門跟進工作。<br/>
            樹木管理辦事處也製備了簡易圖解，介紹如何識別一般的樹木健康問題和結構問題，該份圖解已上載發展局 - 綠化、園境及樹木管理組網頁，歡迎市民查閱。
        `
    },{
        Question: "褐根病如何傳播?",
        Correct: 3,
        Ans: [
            "根部接觸", 
            "受污染的泥土", 
            "空氣傳播", 
            "枯枝或斷枝"
        ],
        desc: `
            <h4>什麼是褐根病？</h4>
            褐根病是由一種具侵略性的真菌致病原有害木層孔菌（Phellinus noxius）所引致，此真菌為一種白腐真菌，可迅速損害樹木的健康及結構，更可能令樹木倒塌。<br/><br/>

            <h4>褐根病如何傳播？</h4>
            褐根病可經由根部接觸、受污染的泥土、地面及地下水，甚至通過空氣傳播。<br/>
            可以透過鞋上受污染的泥土傳播褐根病，所以強烈建議公眾應遠離已知受感染的樹木。<br/><br/>

            <h4>褐根病的影響</h4>
            褐根病是一種常見於熱帶及亞熱帶地區的病害，現時並沒有有效的根治方法。曾經有不少人宣稱有根治方法或有效的管理，但只要樹木一旦受感染，該病不能根治。<br/>
            樹木受感染後，健康會迅速惡化，最終導致根部出現腐爛和不可逆轉的結構性破壞，嚴重危害公眾安全。<br/>
            褐根病會對我們的園境帶來破壞性的影響。種植的地方一旦受到感染，就必須要徹底消毒。<br/><br/>
        `
    }];
    var _no = Math.floor(Math.random() * qData.length )
    var isLogin = false
    if (localStorage.getItem("user_info") === null) {
        isLogin = true
    }
    
    export default {
        data() {
            return {
                wrongAns: {
                    0: false,
                    1: false,
                    2: false,
                    3: false,
                },
                corrAns: {
                    0: false,
                    1: false,
                    2: false,
                    3: false,
                },
                no_count: _no,
                sData: qData[_no],
                _show_desc: false,
                is_submitted:false,
                filterLists: qData,
                q_no:1,
                q_count: qData.length,
                logined: isLogin
            }
        },
        methods: {
            submitAns( key ) {
                this.is_submitted = true
                this.resetAns()
                this.corrAns[key] = true
                if ( this.sData['Correct'] != key ) {
                    this.wrongAns[this.sData['Correct'] ] = true
                }
                this.filterLists.splice(this.no_count, 1);
                // console.log( 'filterLists' , this.filterLists)
            },
            resetAns() {
                this.corrAns[0] = false
                this.corrAns[1] = false
                this.corrAns[2] = false
                this.corrAns[3] = false
                this.wrongAns[0] = false
                this.wrongAns[1] = false
                this.wrongAns[2] = false
                this.wrongAns[3] = false
            },
            showDesc() {
                this._show_desc = true
            },
            gemNewQuestion() {

            },
            showNext() {
                if ( qData.length > 0 ) {
                    this.no_count = Math.floor(Math.random() * this.filterLists.length )
                    this.sData = this.filterLists[this.no_count]
                    this._show_desc = false
                    this.is_submitted = false
                    this.resetAns()
                    this.q_no++
                }
            }
        },
    }

</script>


<style scoped>


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
    margin-left: 20px;
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
    margin: 0px 50px;
}

.spDescBlock {
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