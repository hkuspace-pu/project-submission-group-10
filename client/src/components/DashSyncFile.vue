<template>
    <div class="file-upload">
        <p>Here is the preview of the tsv data</p>
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

        <p>Please choose and upload your tsv file</p>
        <div class="file-upload__area">
            <input type="file" name="" id="" @change="handleFileUpload" />
        </div>

        <div >
            <button class="btn_export" @click="exportFile()">Export data</button>
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
        async mounted() {
            // /getTsv
            const data = new URLSearchParams();
            data.append('userId', 4);
            data.append('roleId', 4);

            const url = "https://api.hktreewatch.org"
            const resp = await fetch(url+'/getTsv', { 
                method: 'POST',
                body :  data
            })

            var _res = await resp.json()
            if ( _res.data && _res.data.length > 0 ) {
                var _data = _res.data[0].tsvString //\n
                
                var d3Res = d3.tsvParse(_data)
                this.tsvData = d3Res
                this.tsvTitle = d3Res.columns

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
        },
        methods: {
            replaceAll( st, rep, repWith ) {
                const result = st.split(rep).join(repWith)
                return result;
            },
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
                        // this.tsvTitle.forEach(_tt => {
                        //     _headers.push({
                        //         text: _tt.toUpperCase(),
                        //         value: _tt,
                        //         sortable: true
                        //     })
                        // });
                        this.tsvData.forEach(_td => {
                            _items.push(_td)
                        });

                        // this.headers = _headers
                        this.items = this.items.concat(_items);

                    }
                    reader.readAsText(file)
                }
            },
            exportFile(ev) {
                let tsvContent = "";

                let tsvKey = ''
                this.headers.forEach(head => {
                    tsvKey += head['value'] + "\t";
                });

                this.items.forEach(it => {
                    let row = Object.values(it).join("\t");
                    tsvContent += row + "\n";
                });

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
        /* margin-top: 40px; */
        margin-bottom: 20px;
    }

    .hidden {
        display: none;
    }

    .btn_export {
        padding: 5px 10px;
        border-radius: 5px;
        border: 1px;
        margin: 10px 10px 10px 0;
        background-color: #2E7D32;
        color: white;
        font-size: 15px;
    }

    p {
        margin-top: 20px;
    }
</style>