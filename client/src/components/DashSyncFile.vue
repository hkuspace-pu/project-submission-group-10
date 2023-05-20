<template>
    <div class="file-upload">
        <div class="file-upload__area">
            <input type="file" name="" id="" @change="handleFileUpload" />
        </div>

         <div :class="{ hidden: items.length == 0 }">
            <!-- <table>
                <tr>
                    <th v-for="( tRow, tIndex ) in tsvTitle" :key="tIndex">
                        {{ tRow }}
                    </th>
                </tr>
                <tr v-for="( dRow, dIndex ) in tsvData" :key="dIndex" >
                    <td v-for="( tRow, tIndex ) in tsvTitle" :key="tIndex">
                        {{ dRow[tRow] }}
                    </td>
                </tr>
            </table> -->
            <EasyDataTable
                :headers="headers"
                :items="items"
            >

                <!-- <template #expand="data">
                <div class="tree_container" >
                    <div>
                    <img class="tree_icon" src="https://www.greening.gov.hk/filemanager/greening/treeant/31/t_031_Overview.jpg" /> 
                    </div>
                    <div class="tree_detail">
                    <div><label for="scientific_name">Scientific Name </label>{{ data.scientific_name }}</div>
                    <div><label for="common_name">Common Name: </label>{{ data.common_name }}</div>
                    <div><label for="chinese_name">Chinese Name: </label>{{ data.chinese_name }}</div>
                    <div><label for="family_name">Family Name: </label>{{ data.family_name }}</div>
                    <div><label for="native">Native/Exotic Species: </label>{{ data.native }}</div>
                    </div>

                </div>
                </template> -->

            </EasyDataTable>



        </div>  
        <div class="">
            <button @click="exportFile()">Export data</button>
        </div>
    </div>

  
</template>

<script>
    import * as d3 from 'd3'
    import { saveAs } from 'file-saver'

    export default {
        name: "FileUpload",
        data() {
            return {
                tsvData: [],
                tsvTitle: [],
                headers: [],
                items: []
            }
        },
        mounted() {
            // console.log('mounted!')
            // /getTsv
            const url = "http://api.hktreewatch.org"
            // const resp = await fetch(url+'/getTsv', {
            //     method: 'POST',
            //     body :  JSON.stringify({
            //         userId: 2,
            //         roleId: 4
            //     }),
            //     headers : {
            //         "Content-type": "application/json;charset=UTF-8",
            //     }
            // })

            // console.log(resp)
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

                        var _headers = []
                        var _items = []
                        this.tsvTitle.forEach(_tt => {
                            _headers.push({
                                text: _tt.toUpperCase(),
                                value: _tt,
                                sortable: true
                            })
                        });
                        this.tsvData.forEach(_td => {
                            _items.push(_td)
                        });

                        this.headers = _headers
                        this.items = _items

                    }
                    reader.readAsText(file)
                }
            },
            exportFile(ev) {
                let tsvContent = "";
                var _tsv = [
                    { id: 1, name: 'xx' },
                    { id: 2, name: 'yy' }
                ]


                _tsv.forEach(function(rowArray) {
                    // let keys = Object.keys(rowArray).join("\t")
                    // tsvKey = keys
                    let row = Object.values(rowArray).join("\t");
                    tsvContent += row + "\n";
                });

                let tsvKey = Object.keys( this.tsvTitle).join("\t")

                tsvContent = tsvKey + "\n" + tsvContent
                // Save the CSV string as a TSV file
                const blob = new Blob([tsvContent], { type: 'text/tab-separated-values' })
                saveAs(blob, 'output.tsv')
            },
            getTsvFile() {
                
            }
        },
    };
</script>

<style scoped>
    .file-upload {
        height: 100vh;
        width: 90%;
        /* display: flex; */
        align-items: flex-start;
        justify-content: center;
        margin: 0 5% 0;
    }
    .file-upload .file-upload__area {
        width: 100%;
        min-height: 200px;
        display: flex;
        align-items: center;
        justify-content: center;
        border: 2px dashed #ccc;
        margin-top: 40px;
        margin-bottom: 40px;
    }

    .hidden {
        display: none;
    }
</style>