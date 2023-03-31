<template>
    <div class="file-upload">
        <div class="file-upload__area">
            <input type="file" name="" id="" @change="handleFileUpload" />
        </div>

        <div class="file-upload__area">
            <table>
                <tr v-for="( dRow, dIndex ) in tsvData" :key="dIndex" >
                    <td v-for="( tRow, tIndex ) in tsvTitle" :key="tIndex">
                        {{ dRow[tRow] }}
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script setup>

</script>
<script>
    import * as d3 from 'd3'

    export default {
        name: "FileUpload",
        data() {
            return {
                tsvData: [],
                tsvTitle: []
            }
        },
        methods: {
            handleFileUpload(ev) {
                const file = ev.target.files[0]
                if ( file ) {
                    const reader = new FileReader()

                    reader.onload = () => {
                        const data  = reader.result

                        var _res = d3.tsvParse(data)
                        this.tsvData = _res
                        this.tsvTitle = _res.columns
                    }
                    reader.readAsText(file)
                }
            }
        },
    };
</script>

<style scoped>
    .file-upload {
        height: 100vh;
        width: 100%;
        display: flex;
        align-items: flex-start;
        justify-content: center;
    }
    .file-upload .file-upload__area {
        width: 80%;
        min-height: 200px;
        display: flex;
        align-items: center;
        justify-content: center;
        border: 2px dashed #ccc;
        margin-top: 40px;
    }
</style>