<template>

  <!-- <h3 class="dark">List Surveys</h3> -->
  <EasyDataTable
    :headers="headers" :items="items" :loading="isDataLoading"
  >

    <template #expand="data">
      <div class="tree_container" >
        <div>
          <img class="tree_icon" :src="data.imgUrl" /> 
        </div>
        <div class="tree_detail">
          <div><label for="scientificName">Scientific Name </label>{{ data.scientificName }}</div>
          <div><label for="scientificChiName">Scientific Chinese Name </label>{{ data.scientificChiName }}</div>
          <div><label for="commonName">Common Name: </label>{{ data.commonName }}</div>
          <div><label for="commonChiName">Common Chinese Name: </label>{{ data.commonChiName }}</div>

          <div><label for="family">Family Name: </label>{{ data.familyFi }}</div>
          <div><label for="shortDesc">Short Desc: </label>{{ data.shortDesc }}</div>
          <div><label for="shortChiDesc">Short Desc (Chinese): </label>{{ data.shortChiDesc }}</div>

          <div><label for="longDesc">Long Desc: </label>{{ data.longDesc }}</div>
          <div><label for="longChiDesc">Long Desc (Chinese): </label>{{ data.longChiDesc }}</div>

          <div><label for="nativeExotic">Native/Exotic Species: </label>{{ data.nativeExoticFi }}</div>
          <div><label for="status">Create Date: </label>{{ data.createTimeFi }}</div>
          <div><label for="status">Status: </label>{{ data.status }}</div>

          <div class="btnClass" >
            <button class="edit_btn" @click="editTree(data)"> Edit </button>
            <button class="delete_btn" @click="deleteTree(data)"> Delete </button>
          </div>

        </div>

      </div>
    </template>

  </EasyDataTable>

  <Modal v-model:visible="isVisible" :okButton="confirmBtn">
    "id": _data['id'],
		"scientific_name" : _data['scientificName'],
		"scientific_chi_name" : _data['scientificChiName'],
		"family" : _data['family'],
		"status" : 1,
		"common_name" : _data['commonName'],
    "common_chi_name" : _data['commonChiName'],
    "img_url" : _data['imgUrl'],
    "short_desc" : _data['shortDesc'],
    "long_desc" : _data['longDesc'],
    "native_exotic" : _data['nativeExotic'],
    "short_chi_desc" : _data['shortChiDesc'],
    "long_chi_desc" : _data['longChiDesc'],
    "create_time" : _data['createTime'],

    <div><label for="scientificName">Scientific Name </label>{{ data.scientificName }}
        <input required v-model="editData.scientificName" type="text" id="scientificName" name="scientificName"/></div>
    <div><label for="scientificChiName">Scientific Chinese Name </label>
        <input required v-model="editData.scientificChiName" type="text" id="scientificChiName" name="scientificChiName"/></div>
    <div><label for="commonName">Common Name: </label>
        <input required v-model="editData.commonName" type="text" id="commonName" name="commonName"/></div>
    <div><label for="commonChiName">Common Chinese Name: </label>
        <input required v-model="editData.commonChiName" type="text" id="commonChiName" name="commonChiName"/></div>

    <!-- <div><label for="family">Family Name: </label>
        <input required v-model="editData.scientificName" type="text" id="scientificName" name="scientificName"/></div> -->
    <div><label for="shortDesc">Short Desc: </label>
        <input required v-model="editData.shortDesc" type="text" id="shortDesc" name="shortDesc"/></div>
    <div><label for="shortChiDesc">Short Desc (Chinese): </label>
        <input required v-model="editData.shortChiDesc" type="text" id="shortChiDesc" name="shortChiDesc"/></div>

    <div><label for="longDesc">Long Desc: </label>
        <input required v-model="editData.longDesc" type="text" id="longDesc" name="longDesc"/></div>
    <div><label for="longChiDesc">Long Desc (Chinese): </label>
        <input required v-model="editData.longChiDesc" type="text" id="longChiDesc" name="longChiDesc"/></div>

    <div><label for="nativeExotic">Native/Exotic Species: </label>
        <input required v-model="editData.nativeExoticFi" type="text" id="nativeExoticFi" name="nativeExoticFi"/></div>
    <div><label for="status">Status: </label>{{ data.status }}</div>
  </Modal>
  

<!-- </div> -->

</template>

<script setup>
import { ref, computed,onMounted } from 'vue';
import { useStore } from "@/stores/state.js";
import { useRouter, useRoute } from 'vue-router'
import { Modal } from 'usemodal-vue3';
const router = useRouter()
const store = useStore();

const isDataLoading = ref(false);
const clickedRow = ref(null)
const itemsSelected = ref([])
let items = ref([]);
let familyLists = ref([])
let isVisible = ref(false);
let editData = ref({})

const url = "https://api.hktreewatch.org";

const showRow = (index) => {
  clickedRow.value = data[index].advanced
};

const selectedImage = computed(() => {
  return clickedRow.value.media[0]
})

const headers = [
      { text: "Scientific Name", value: "scientificName", sortable: true  },
      // { text: "Scientific Chinese Name", value: "scientificChiName", sortable: true  },
      { text: "Common Name", value: "commonName", sortable: true },
      // { text: "Chinese Name", value: "commonChiName", sortable: true },
      { text: "Family Name", value: "familyFi", sortable: true },
      { text: "Native/Exotic Species", value: "nativeExoticFi", sortable: true },
      { text: "Status", value: "status", sortable: true },
    ];

onMounted(async () => {
  if (!store.getUserInfo) {
    router.push({ name: "login" });
  }

  try {
    isDataLoading.value = true;
    await store.getFamilyList()

    await store.getMasterTreeList()
    var jsonData = store.treeLists
    jsonData.forEach(jEle => {
      jEle['createTimeFi'] = dateFormat( jEle['createTime'] )
      jEle['familyFi'] = filterFamily( jEle['family'] )
      jEle['nativeExoticFi'] = filterNativeExotic( jEle['nativeExotic'] )
    });
    items = jsonData;
  } catch (e) {
    console.log("ERROR LOADING DATA ", e);
  } finally {
    isDataLoading.value = false;
  }
});

const filterFamily = ( _family ) => {
  var filterList = store.familyData.filter(( _lists ) => {
    return _family == _lists['id']
  });

  return filterList.length > 0 ? filterList[0]['familyName'] : _family
} 

const filterNativeExotic = ( _nativeExotic ) => {
  return _nativeExotic == 1 ? 'Native' : 'Exotic'
}  

const dateFormat = ( _dateTime ) => {
  var _date = new Date(_dateTime)
  return  _date.getDate()+ 
           "/"+(_date.getMonth()+1)+
           "/"+_date.getFullYear()+
           " "+_date.getHours()+
           ":"+String(_date.getMinutes()).padStart(2, '0')+
           ":"+_date.getSeconds()
}

const deleteTree = async ( _data ) => {
  console.log( '_data', _data)
  var _json = {
		"id": _data['id'],
		"scientific_name" : _data['scientificName'],
		"scientific_chi_name" : _data['scientificChiName'],
		"family" : _data['family'],
		"status" : 1,
		"common_name" : _data['commonName'],
    "common_chi_name" : _data['commonChiName'],
    "img_url" : _data['imgUrl'],
    "short_desc" : _data['shortDesc'],
    "long_desc" : _data['longDesc'],
    "native_exotic" : _data['nativeExotic'],
    "short_chi_desc" : _data['shortChiDesc'],
    "long_chi_desc" : _data['longChiDesc'],
    "create_time" : _data['createTime'],
	}
  editData.valie = _json
  updateTree()
}

const editTree = ( treeData ) => {
  editData.value = treeData
  isVisible.value = true
}

const updateTree = async () => {
  const formData = new FormData();

  console.log( 'updateData', JSON.stringify(editData.valie) )

  // {"district":"Central","location":"18號 Harcourt Rd, Central","survey_date":"2023-05-28","id":null,"tree_tag":["Old & valuable"],"height":"25","crown":"35","stem_circumference":"9","health":3,"recommendation":"Trim","file":[{"name":"sprint_screen.jpeg","file":{}}],"amenity_value":"2","next_inspection_date":"2023-06-01","terms":true}
  // {"id":1,"scientific_name":"Araucaria columnaris","scientific_chi_name":"柱狀南洋杉","family":1,"status":1,"common_name":"Cook Pine","common_chi_name":"柱狀南洋杉","img_url":"https://www.greening.gov.hk/filemanager/greening/en/content_83/Ara_col.jpg","short_desc":"Elegant upright tree with outstanding columnar shape..","long_desc":"Cook Pine is a native species of New Caledonia, an island located within Oceania in the Southern Hemisphere. The species is widely planted as street trees and horticultural plants across the tropics and subtropics. Being a tropical coastal plant, it is less tolerant to the cold.","native_exotic":2,"short_chi_desc":"優雅樹木，具顯眼的直立柱狀樹型。","long_chi_desc":"優雅樹木，具顯眼的直立柱狀樹型。","create_time":1672571097000}

  formData.append("data", JSON.stringify(editData.value));
  // formData.append("data", JSON.stringify(_json));
  const updateResp = await fetch(url + '/updateMasterTreeTableById', {
    method: "POST",
    body:  formData
  });
  const updateData = await updateResp.json();
  console.log( 'updateData', updateData )
}

let confirmBtn = ref({
  text: 'Confirm', 
  onclick: () => {
    updateTree()
  }
})

    // const items = [{"scientific_name":"Acacia auriculiformis A. Cunn. ex Benth.","common_name":"Ear-leaved Acacia, Ear-pod Wattle","chinese_name":"耳果相思, 耳葉相思, 大葉相思","family_name":"MIMOSACEAE","native":"Exotic"},{"scientific_name":"Acacia confusa Merr.","common_name":"Taiwan Acacia","chinese_name":"台灣相思, 相思樹, 台灣柳, 相思仔","family_name":"MIMOSACEAE","native":"Exotic"},{"scientific_name":"Acacia mangium Willd.","common_name":"Big-leaved Acacia, Broad-leaved Acacia3","chinese_name":"大葉相思, 馬占相思","family_name":"MIMOSACEAE","native":"Exotic"},{"scientific_name":"Ailanthus fordii Noot.","common_name":"Ailanthus, Green Ailanthus","chinese_name":"常綠臭椿, 福氏臭椿","family_name":"SIMAROUBACEAE","native":"Native"},{"scientific_name":"Albizia lebbeck (L.) Benth.","common_name":"Lebbeck Tree","chinese_name":"大葉合歡, 闊莢合歡","family_name":"MIMOSACEAE","native":"Exotic"},{"scientific_name":"Aleurites moluccana (L.) Willd.","common_name":"Candlenut Tree, Common Aleurites","chinese_name":"石栗","family_name":"EUPHORBIACEAE","native":"Exotic"},{"scientific_name":"Alstonia scholaris (L.) R. Br.","common_name":"Devil Tree, Common Alstonia","chinese_name":"糖膠樹, 黑板樹, 麵條樹, 燈架樹","family_name":"APOCYNACEAE","native":"Exotic"},{"scientific_name":"Aquilaria sinensis (Lour.) Spreng.","common_name":"Incense Tree","chinese_name":"土沉香, 牙香樹, 白木香","family_name":"THYMELAEACEAE","native":"Native"},{"scientific_name":"Araucaria columnaris (G. Forst.) Hook.","common_name":"Cook Pine, New Caledonia Pine","chinese_name":"柱狀南洋杉","family_name":"ARAUCARIACEAE","native":"Exotic"},{"scientific_name":"Archontophoenix alexandrae (F. Muell.) H. Wendl. & Drude","common_name":"Alexandra Palm, King Palm","chinese_name":"假檳榔, 亞力山大椰子","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Artocarpus heterophyllus Lam.","common_name":"Jackfruit","chinese_name":"菠蘿蜜, 樹菠蘿, 木菠蘿","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Bauhinia purpurea L.","common_name":"Purple Camel's Foot","chinese_name":"紅花羊蹄甲, 羊蹄甲, 洋紫荊","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Bauhinia variegata L.","common_name":"Camel's Foot Tree","chinese_name":"宮粉羊蹄甲, 洋紫荊, 羊蹄甲, 彎葉樹","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Bauhinia variegata L. var. candida (Aiton) Buch.-Ham.","common_name":"White Bauhinia","chinese_name":"白花洋紫荊, 白花羊蹄甲, 大白花","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Bauhinia × blakeana Dunn","common_name":"Hong Kong Orchid Tree","chinese_name":"洋紫荊, 紅花羊蹄甲, 豔紫荊","family_name":"CAESALPINIACEAE","native":"Native"},{"scientific_name":"Bischofia javanica Blume","common_name":"Autumn Maple","chinese_name":"秋楓, 茄苳","family_name":"EUPHORBIACEAE","native":"Native"},{"scientific_name":"Bischofia polycarpa (H. Lév.) Airy Shaw","common_name":"Chinese Bishopwood","chinese_name":"重陽木","family_name":"EUPHORBIACEAE","native":"Exotic"},{"scientific_name":"Bombax ceiba L.","common_name":"Tree Cotton, Red Kapok Tree","chinese_name":"木棉, 紅棉, 英雄樹, 攀枝花","family_name":"BOMBACACEAE","native":"Exotic"},{"scientific_name":"Bridelia tomentosa Blume","common_name":"Pop-gun Seed, Pikpoktai","chinese_name":"土蜜樹, 逼迫仔","family_name":"EUPHORBIACEAE","native":"Native"},{"scientific_name":"Callistemon viminalis (Sol. ex Gaertn.) G. Don","common_name":"Tall Bottle-brush, Weeping Bottlebrush, Drooping Bottlebrush, Creek Bottlebrush, Red Bottlebrush","chinese_name":"串錢柳, 垂枝紅千層","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Caryota maxima Blume","common_name":"Fishtail Palm","chinese_name":"魚尾葵, 青棕, 假桄榔","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Cassia fistula L.","common_name":"Golden-shower","chinese_name":"臘腸樹, 豬腸豆, 阿勃勒, 牛角樹, 波斯皂莢","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Casuarina equisetifolia L.","common_name":"Horsetail Tree","chinese_name":"木麻黃, 牛尾松, 馬尾樹","family_name":"CASUARINACEAE","native":"Exotic"},{"scientific_name":"Celtis sinensis Pers.","common_name":"Chinese Hackberry","chinese_name":"朴樹","family_name":"ULMACEAE","native":"Native"},{"scientific_name":"Chukrasia tabularis A. Juss.","common_name":"Chittagong Chickrassy","chinese_name":"麻楝","family_name":"MELIACEAE","native":"Exotic"},{"scientific_name":"Cinnamomum burmannii (Nees & T. Nees) Blume","common_name":"Batavia Cinnamon, Cinnamon Tree","chinese_name":"陰香、山肉桂","family_name":"LAURACEAE","native":"Native"},{"scientific_name":"Cinnamomum camphora (L.) J. Presl","common_name":"Camphor Tree","chinese_name":"樟, 樟樹, 樟腦樹","family_name":"LAURACEAE","native":"Native"},{"scientific_name":"Corymbia citriodora (Hook.) K. D. Hill & L. A. S. Johnson","common_name":"Lemon-scented Gum","chinese_name":"檸檬桉","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Crateva trifoliata (Roxb.) B. S. Sun","common_name":"Obtuse-leaved Crateva","chinese_name":"鈍葉魚木, 赤果魚木","family_name":"CAPPARACEAE","native":"Exotic"},{"scientific_name":"Crateva unilocularis Buch.-Ham.","common_name":"Spider Tree","chinese_name":"樹頭菜","family_name":"CAPPARACEAE","native":"Exotic"},{"scientific_name":"Delonix regia (Bojer ex Hook.) Raf.","common_name":"Flame Tree, Flame of the Forest","chinese_name":"鳳凰木, 鳳凰花, 紅花楹, 火樹","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Dimocarpus longan Lour.","common_name":"Longan","chinese_name":"龍眼, 桂圓, 圓眼","family_name":"SAPINDACEAE","native":"Exotic"},{"scientific_name":"Elaeocarpus hainanensis Oliv.","common_name":"Hainan Elaeocarpus","chinese_name":"水石榕","family_name":"ELAEOCARPACEAE","native":"Exotic"},{"scientific_name":"Elaeocarpus sylvestris (Lour.) Poir.","common_name":"Woodland Elaeocarpus","chinese_name":"山杜英, 膽八樹, 羊屎樹, 羊仔樹","family_name":"ELAEOCARPACEAE","native":"Native"},{"scientific_name":"Erythrina variegata L.","common_name":"Coral Tree","chinese_name":"刺桐","family_name":"FABACEAE","native":"Exotic"},{"scientific_name":"Eucalyptus camaldulensis Dehnh.","common_name":"River Red Gum, Murray Red Gum","chinese_name":"赤桉","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Eucalyptus robusta Sm.","common_name":"Swamp Mahogany","chinese_name":"大葉桉","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Eucalyptus urophylla S. T. Blake","common_name":"Timor White Gum, Timor Mountain Gum, Half-barked Tree","chinese_name":"尾葉桉","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Ficus altissima Blume","common_name":"Mountain Fig, Lofty Fig","chinese_name":"高山榕, 雞榕, 大青樹, 萬年青","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Ficus benjamina L.","common_name":"Weeping Fig","chinese_name":"垂葉榕, 垂榕, 白榕","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Ficus elastica Roxb. ex Hornem.","common_name":"India-rubber Tree, Caoutchuc","chinese_name":"印度榕, 印度橡樹","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Ficus hispida L. f.","common_name":"Opposite-leaved Fig, Rough-leaved Stem-fig","chinese_name":"對葉榕, 牛乳樹, 牛奶子, 乳汁麻木, 豬母茶","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Ficus microcarpa L. f.","common_name":"Chinese Banyan, Small-fruited Fig","chinese_name":"細葉榕, 榕樹, 萬年青","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Ficus religiosa L.","common_name":"Peepul Tree, Bodh Tree, Botree Fig, Bodhi","chinese_name":"菩提樹, 思維樹, 印度菩提樹, 阿思多羅, 印度波樹","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Ficus rumphii Blume","common_name":"Mock Bodh Tree, Mock Peepul Tree","chinese_name":"心葉榕, 假菩提樹","family_name":"MORACEAE","native":"Exotic"},{"scientific_name":"Ficus subpisocarpa Gagnep.","common_name":"Japanese Superb Fig, Superb Fig","chinese_name":"筆管榕","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Ficus variegata Blume","common_name":"Common Red-stem Fig","chinese_name":"青果榕, 雜色榕","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Ficus virens Aiton","common_name":"Big-leaved Fig","chinese_name":"黃葛樹, 大葉榕, 綠黃葛樹, 黃桷樹","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Garcinia subelliptica Merr.","common_name":"Common Garcinia, Fukugi, Happy Tree","chinese_name":"菲島福木","family_name":"CLUSIACEAE","native":"Exotic"},{"scientific_name":"Grevillea robusta A. Cunn. ex R. Br.","common_name":"Silk Oak","chinese_name":"銀樺","family_name":"PROTEACEAE","native":"Exotic"},{"scientific_name":"Hibiscus tiliaceus L.","common_name":"Cuban Bast, Sea Hibiscus","chinese_name":"黃槿, 桐花, 海麻, 萬年春","family_name":"MALVACEAE","native":"Native"},{"scientific_name":"Hyophorbe lagenicaulis (L.H. Bailey) H. E. Moore","common_name":"Bottle Palm","chinese_name":"酒瓶椰子","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Ilex rotunda Thunb. var. microcarpa (Lindl. ex Paxton) S. Y. Hu","common_name":"Small-fruited Holly, Chinese Holly","chinese_name":"小果鐵冬青","family_name":"AQUIFOLIACEAE","native":"Native"},{"scientific_name":"Jacaranda mimosifolia D. Don","common_name":"Jacaranda","chinese_name":"藍花楹","family_name":"BIGNONIACEAE","native":"Exotic"},{"scientific_name":"Juniperus chinensis L.","common_name":"Chinese Juniper","chinese_name":"圓柏, 檜, 刺柏","family_name":"CUPRESSACEAE","native":"Exotic"},{"scientific_name":"Khaya senegalensis (Desr.) A. Juss.","common_name":"African Mahogany, Senegal Mahogany, Dry Zone Mahogany","chinese_name":"非洲楝, 塞內加爾楝, 非洲桃花心木, 仙加樹","family_name":"MELIACEAE","native":"Exotic"},{"scientific_name":"Koelreuteria bipinnata Franch.","common_name":"Golden Rain Tree, Chinese Flame Tree, Pride of China","chinese_name":"複羽葉欒樹, 國慶花","family_name":"SAPINDACEAE","native":"Exotic"},{"scientific_name":"Lagerstroemia speciosa (L.) Pers.","common_name":"Queen Crape Myrtle, Queen Lagerstroemia, Queen Crape-myrtle","chinese_name":"大花紫薇, 大葉紫薇, 洋紫薇, 百日紅","family_name":"LYTHRACEAE","native":"Exotic"},{"scientific_name":"Liquidambar formosana Hance","common_name":"Sweet Gum, Chinese Sweet Gum","chinese_name":"楓香, 楓香樹","family_name":"HAMAMELIDACEAE","native":"Native"},{"scientific_name":"Litsea glutinosa (Lour.) C. B. Rob.","common_name":"Pond Spice","chinese_name":"潺槁樹, 潺槁木薑子, 油槁樹, 膠樟","family_name":"LAURACEAE","native":"Native"},{"scientific_name":"Litsea monopetala (Roxb.) Pers.","common_name":"Persimmon-leaved Litsea","chinese_name":"假柿木薑子, 假柿樹","family_name":"LAURACEAE","native":"Native"},{"scientific_name":"Livistona chinensis (Jacq.) R.Br. ex Mart.","common_name":"Chinese Fan-palm","chinese_name":"蒲葵, 葵樹","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Lophostemon confertus (R. Br.) Peter G. Wilson & J. T. Waterh.","common_name":"Brisbane Box, Queensland Box","chinese_name":"紅膠木","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Macaranga tanarius (L.) Müll. Arg. var. tomentosa (Blume) Müll. Arg.","common_name":"Elephant's Ear, Common Macaranga","chinese_name":"血桐, 流血桐, 帳篷樹","family_name":"EUPHORBIACEAE","native":"Native"},{"scientific_name":"Magnolia grandiflora L.","common_name":"Bull Bay, Southern Magnolia","chinese_name":"荷花玉蘭, 洋玉蘭, 廣玉蘭, 荷花木蘭","family_name":"MAGNOLIACEAEL","native":"Exotic"},{"scientific_name":"Mallotus paniculatus (Lam.) Müll. Arg.","common_name":"Turn-in-the-wind, Panicled Mallotus","chinese_name":"白楸, 力樹, 黃背桐, 白葉子","family_name":"EUPHORBIACEAE","native":"Native"},{"scientific_name":"Mangifera indica L.","common_name":"Mango","chinese_name":"杧果","family_name":"ANACARDIACEAE","native":"Exotic"},{"scientific_name":"Melaleuca cajuputi Roxb. subsp. cumingiana (Turcz.) Barlow","common_name":"Paper-bark Tree, Cajeput-tree","chinese_name":"白千層","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Melia azedarach L.","common_name":"China-berry, Persian Lilac","chinese_name":"楝, 苦楝, 森樹, 紫花樹","family_name":"MELIACEAE","native":"Exotic"},{"scientific_name":"Michelia x alba DC.","common_name":"White Jade Orchid Tree, White Champak","chinese_name":"白蘭, 白蘭花, 白玉蘭","family_name":"MAGNOLIACEAEL","native":"Exotic"},{"scientific_name":"Morus alba L.","common_name":"White Mulberry","chinese_name":"桑, 桑樹","family_name":"MORACEAE","native":"Native"},{"scientific_name":"Nageia nagi (Thunb.) Kuntze","common_name":"Nagi, Japanese Podocarpus","chinese_name":"竹柏","family_name":"PODOCARPACEAE","native":"Exotic"},{"scientific_name":"Peltophorum pterocarpum (DC.) Baker ex K. Heyne","common_name":"Yellow Poinciana, Yellow Flame Tree","chinese_name":"盾柱木, 雙翼豆, 閉筴木","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Peltophorum tonkinense (Pierre) Gagnep.","common_name":"Yinzhu","chinese_name":"銀珠, 油楠","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Phoenix roebelenii O’Brien","common_name":"Dwarf Date Palm","chinese_name":"江邊刺葵, 日本葵, 軟葉刺葵","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Plumeria rubra L.","common_name":"Frangipani","chinese_name":"雞蛋花, 紅雞蛋花, 鹿角樹","family_name":"APOCYNACEAE","native":"Exotic"},{"scientific_name":"Podocarpus macrophyllus (Thunb.) Sweet","common_name":"Buddhist Pine, Kusamaki","chinese_name":"羅漢松","family_name":"PODOCARPACEAE","native":"Native"},{"scientific_name":"Pongamia pinnata (L.) Merr.","common_name":"Wild Bean","chinese_name":"水黃皮, 水流豆, 野豆","family_name":"FABACEAE","native":"Native"},{"scientific_name":"Pterocarpus indicus Willd.","common_name":"Burmese Rosewood","chinese_name":"紫檀, 印度紫檀, 牛血樹, 青龍木","family_name":"FABACEAE","native":"Exotic"},{"scientific_name":"Ravenala madagascariensis Sonn.","common_name":"Traveller's Palm, Traveller’s Tree","chinese_name":"旅人蕉, 扇芭蕉","family_name":"STRELITZIACEAE","native":"Exotic"},{"scientific_name":"Roystonea regia (Kunth) O.F. Cook","common_name":"Royal Palm","chinese_name":"大王椰子, 王棕","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Sapium sebiferum (L.) Roxb.","common_name":"Chinese Tallow Tree","chinese_name":"烏桕","family_name":"EUPHORBIACEAE","native":"Native"},{"scientific_name":"Schefflera actinophylla (Endl.) Harms","common_name":"Umbrella Tree","chinese_name":"輻葉鵝掌柴, 澳洲鵝掌柴, 傘樹","family_name":"ARALIACEAE","native":"Exotic"},{"scientific_name":"Schefflera heptaphylla (L.) Frodin","common_name":"Ivy Tree","chinese_name":"鵝掌柴, 鴨腳木","family_name":"ARALIACEAE","native":"Native"},{"scientific_name":"Schima superba Gardner & Champ.","common_name":"Schima, Chinese Gugertree","chinese_name":"木荷, 荷樹","family_name":"THEACEAE","native":"Native"},{"scientific_name":"Senna siamea (Lam.) H. S. Irwin & Barneby","common_name":"Kassod Tree","chinese_name":"鐵刀木, 黑心樹, 挨刀樹","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Senna surattensis (Burm. f.) H. S. Irwin & Barneby","common_name":"Sunshine Tree","chinese_name":"黃槐決明, 黃槐","family_name":"CAESALPINIACEAE","native":"Exotic"},{"scientific_name":"Spathodea campanulata P. Beauv.","common_name":"African Tulip Tree, Fountain Tree","chinese_name":"火焰樹, 火焰木, 噴泉樹, 火燒花","family_name":"BIGNONIACEAE","native":"Exotic"},{"scientific_name":"Sterculia lanceolata Cav.","common_name":"Lance-leaved Sterculia, Scarlet Sterculia","chinese_name":"假蘋婆, 雞冠木, 賽蘋婆","family_name":"STERCULIACEAE","native":"Native"},{"scientific_name":"Syagrus romanzoffiana (Cham.) Glassman","common_name":"Queen Palm, Cocos Palm","chinese_name":"皇后葵, 金山葵, 女王椰子","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Syzygium cumini (L.) Skeels","common_name":"Jambolan Plum, Java Plum","chinese_name":"烏墨, 海南蒲桃, 烏口樹, 肯氏蒲桃","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Syzygium jambos (L.) Alston","common_name":"Rose Apple, Malabar Plum","chinese_name":"蒲桃, 水蒲桃, 廣東葡桃","family_name":"MYRTACEAE","native":"Exotic"},{"scientific_name":"Tabebuia chrysantha (Jacq.) G. Nicholson","common_name":"Yellow Pui, Araguaney","chinese_name":"黃鐘木, 黃花風鈴木","family_name":"BIGNONIACEAE","native":"Exotic"},{"scientific_name":"Tabebuia impetiginosa (Mart. ex DC.) Standl.","common_name":"Purple Tabebuia, Pink Trumpet Tree, Red Lapacho","chinese_name":"紫花風鈴木","family_name":"BIGNONIACEAE","native":"Exotic"},{"scientific_name":"Terminalia catappa L.","common_name":"Indian Almond","chinese_name":"欖仁樹, 大葉欖仁, 山枇杷樹","family_name":"COMBRETACEAE","native":"Exotic"},{"scientific_name":"Terminalia mantaly H. Perrier","common_name":"Terminalia, Umbrella Tree, Madagascar Almond","chinese_name":"小葉欖仁, 細葉欖仁, 非洲欖仁","family_name":"COMBRETACEAE","native":"Exotic"},{"scientific_name":"Thevetia peruviana (Pers.) K. Schum.","common_name":"Yellow Oleander","chinese_name":"黃花夾竹桃, 酒杯花","family_name":"APOCYNACEAE","native":"Exotic"},{"scientific_name":"Viburnum odoratissimum Ker Gawl.","common_name":"Sweet Viburnum","chinese_name":"珊瑚樹, 極香莢蒾, 早禾樹, 山豬肉","family_name":"CAPRIFOLIACEAE","native":"Native"},{"scientific_name":"Wodyetia bifurcata A.K.Irvine","common_name":"Foxtail Palm","chinese_name":"狐尾椰子, 狐尾棕","family_name":"ARECACEAE","native":"Exotic"},{"scientific_name":"Xanthostemon chrysanthus (F. Muell.) Benth.","common_name":"Golden Penda","chinese_name":"金蒲桃","family_name":"MYRTACEAE","native":"Exotic"}];


</script>

<style scoped>

.dashHomeContainer {
    /* margin: 3rem; */
    /* padding: 0.5rem; */
  border-radius: 12px;
    background-color: #fefefe;
    height: 100%;
    width: 100%;
    box-shadow: 10px 10px 12px -12px rgba(0,0,0,0.25);

}

.media {
  display:flex;
  flex-direction: column;
  width: 400px;
  justify-content: space-between;
  /* border:1px solid var(--dark); */
  gap: 5px;
  margin: 1rem;
}

.thumbnail_group {
  display:flex;
  flex-direction: row;
  gap:8px;
}
.thumbnail {
  width: 45px;
  height: 45px;
  border-radius: 4px;
  /* border:1px solid red; */
}

.mainImage {
  width: 350px;
  height: 350px;
  background-image: url('../assets/logo.svg');
  background-size: cover;
  background-position: center;
  object-fit: contain;
  /* height: auto; */
}
.dataContainer {
  /* border:1px solid red; */
  padding: 5px;
  background-color:#f7f7f7;
  /* background-color: var(--dark); */
  /* display:flex; */
  /* flex-direction: row; */
}

.topBar {
  /* border:1px solid red; */
}

.dataContent {
  display:flex;
}
.leftSide {
  display:flex;
  flex-direction: column;
  gap:5px;
}

.rightSide {
  gap:5px;
  display:flex;
  width: 100%;
  flex-direction: column;

}

.tags {
  display:flex;
  flex-direction: row;
  gap:10px;
  width: 350px;
  /* border:1px solid red; */
}

.pill {
  background-color: orange;
  padding: 3px 10px;
  border-radius: 12px;
  width: fit-content;
  border:1px solid lightgray;
}

.pill_pending {
  background-color: orange;
  color:white;
}

.pill_approved {
  background-color: lightgreen;
}

.pill_denied {
  background-color: red;
  color:white;
}

.heart {
  width: 18px;
  
}
.mainImage {
  border-radius: 6px;
}

table.dataTable {
/* border:1px solid red; */
    width: 250px;
    border-width: 1px;
    border-style: outset;
    
}

.customize-table { 
height: 100%;
  overflow-y:auto;
  /* overflow:hidden; */
  border-radius: 12px;
}

.tree_container {
    display:flex;
    flex-direction: row;
    gap:20px;
    /* height: 350px; */
    width: 100%;
    padding: 2rem;
    /* border:1px solid red; */

}

.tree_icon {
  max-height:150px;
  border: 1px solid #333;
  margin: 0 2%;
  padding: 2%;
  border-radius: 5px;
} 

.tree_detail {
  width: 100%
}

.btnClass {
  text-align: right;
}

.edit_btn {
    border: 1px;
    padding: 5px 10px;
    background-color: var(--wrongingBtn);
    border-radius: 4px;
    color: white;
    margin: 0px 10px;
}

.delete_btn {
    border: 1px;
    padding: 5px 10px;
    background-color: var(--deletBtn);
    border-radius: 4px;
    color: white;
}

.dialog-div {
    margin: 10px 0;
}
</style>