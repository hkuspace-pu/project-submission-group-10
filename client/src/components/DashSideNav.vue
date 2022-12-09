<template>

<div class="dashSideNav">
<div class="row">

    <div class="title">New Survey</div>
    <fa class="icon" size="2x" icon="file-pen"/>
</div>

<fa icon="file-pen"/>
<fa icon="file-pen"/>


</div>

</template>


<style scoped>

.dashSideNav {
    
    /* padding: 1rem; */
    width: 220px;
    height: 100%;
    /* height: calc(100% - 65px); */
    box-shadow: 3px 0px 7px 0px rgba(189,187,189,0.4);
    background-color: #F7F9FA;
    display:flex;
    flex-direction: column;
    
}

.icon {
    color: grey;
    padding:2rem;

}
.row {
/* margin:10px; */
padding:10px;
    display:flex;
    flex-direction: row;
    align-items: center;
    border-bottom: 1px solid lightgray;
}

.title {
    font-weight: 400;
    font-size:12px;
}
</style>