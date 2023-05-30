import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import * as d3 from 'd3'
import { saveAs } from 'file-saver'

export const useStore = defineStore({
  id: 'store',
  state: () => ({
  isSideBarOpen : false,
  masterTreeList : [],
  userInfo: null,
  surveyLoading : false,
  baseURL : 'https://api.hktreewatch.org/',
  surveyData : [],
  surveyItemsSelected : [],
  familyData: [],
  treeLists: [],
  userLists: [],
  deleteUserId: null,
  updateUserJson: null,
  exportSurveyTsv: false,
  isCreateNewTree: false,
  createTree: null,
  updateTreeData: null,
  activityLogUserId: null
  }),  

  actions : {
    toggleOpen() {
      this.isSideBarOpen = !this.isSideBarOpen
      document.body.classList.toggle("stopScroll")
    },
    //Get Master Tree List Data From API
    async getMasterTreeList() {
      const resp = await fetch(this.baseURL + 'getCommonAndScientificNameList', {
        //  const resp = await fetch(this.baseURL + 'getAllMasterTreeTableList', {
      method: 'GET'
      })
      const { data }= await resp.json()
      this.masterTreeList = data
  },

 async getSurvey() {
      let path
      this.surveyItemsSelected = []
      const changeDate = ((createTime) => {
        return new Date(createTime).toLocaleDateString('en-us', { year: "numeric", month: "short", day: "numeric" })
      })


      const formData = new FormData();
      if (this.getUserInfo[0].role === 4) {
        console.log("USER IS ADMIN")
        formData.append('roleId', this.getUserInfo[0].role);
        path = '/getAllSurveyRecord'
      } else {
        formData.append('userId', this.getUserInfo[0].userId);
        path = '/getSurveyRecordByUserId'
      }


      //  isDataLoading.value = true;
      this.surveyLoading = true 
      const resp = await fetch(this.baseURL + path, {
        method: 'POST',
        body: formData
      })
      const jsonData = await resp.json();

      this.surveyData = jsonData.data
      this.surveyData = this.surveyData.map((element) => {
        return { ...element, createTime: changeDate(element.createTime) }
      })
      this.surveyLoading = false
    },

  async deleteSurvey(surveyArray = this.surveyItemsSelected) {
      console.log("STARTING TO DELETE")
      let path 
      path = '/delSurveyRecord' 
     
      const promises = []
      
      const formData = new FormData()
      formData.append('userId',this.getUserInfo[0].userId)
      formData.append('roleId', 4)
      console.log(surveyArray.length)
      console.log(surveyArray)
      this.surveyLoading = true
      for (let i = 0; i < surveyArray.length; i++) {
        formData.set('surveyRecordId', surveyArray[i].id)
      const resp = await fetch(this.baseURL + path, {
        method: 'DELETE',
        body: formData
      })
      promises.push(resp);
      console.log("Delete Status : ", resp)
      }

      // await Promise.all(promises);
      // console.log('EVERYTHING Fin, refreshing')
      this.getSurvey()
  },

  async AItree() {
    
    await classifer.classify(previewImage.value)
  },


    async approveSurvey(id = this.surveyItemsSelected,status) {
      console.log('status', status)
      let formData = new FormData()
      this.surveyLoading = true
      for (let i = 0; i < id.length; i++) {
    
      formData.set('surveyRecordId', id[i].id)
      formData.set('userId', this.getUserInfo[0].userId)
      formData.set('roleId',this.getUserInfo[0].role) 
      formData.set('statusCode',status) 
      const resp = await fetch(this.baseURL + '/acceptSurveyRecord', {
        method: 'PUT',
        body: formData
      })
      console.log(i, 'done')

    }
      console.log('LOOP DONE', )
      this.surveyLoading = false
      this.getSurvey()

    },

    async  denySurvey(id) {
      console.log("Deny Survey")
    },

  async getFamilyList() {
    let path 
    path = '/getAllFamilyList' 
    const resp = await fetch(this.baseURL + path, {
      method: 'GET',
    })

    const jsonData = await resp.json();
    this.familyData = jsonData.data
  },

  async getTreeList() {
    console.log('GET MASTER TREE LIST')
    let path 
    path = '/getAllMasterTreeTableList' 

    const resp = await fetch(this.baseURL + path, {
      method: 'GET',
    })

    const jsonData = await resp.json();
    this.treeLists = jsonData.data
  },

  // user api request
  async getAllUser() {
    let path = 'getAllUser'

    const formData = new FormData()
    formData.append('roleId',this.getUserInfo[0].role)

    const resp = await fetch(this.baseURL + path, {
      method: "POST",
      body: formData,
    });
    const jsonData = await resp.json();
    this.userLists = jsonData.data
  },

  async deleteUser( userId = this.deleteUserId ) {
    let path = 'delUser'
    const formData = new FormData();
    formData.append("userId", userId);

    const deleteResp = await fetch(this.baseURL + path, {
      method: "DELETE",
      body:  formData
    });
    const delete_user = await deleteResp.json();
    return delete_user
  },

  async updateUser( _user = this.updateUserJson ) {
    let path = 'editUser'
    const formData = new FormData();
    formData.append("userId", _user['userId']);
    formData.append("username", _user['username']);
    formData.append("phoneNumber", _user['phoneNumber']);
    formData.append("email", _user['email']);
    formData.append("role", _user['role']);

    const updateResp = await fetch(this.baseURL + path, {
      method: "PUT",
      body:  formData
    });
    const update_resp = await updateResp.json();
    return update_resp
  },

  async getActivityLogByUserId() {
    let path = '/getAllActivityLogList'
    const formData = new FormData();
    formData.append("userId", this.activityLogUserId);
    formData.append("roleId", this.getUserInfo[0].role);

    const resp = await fetch(this.baseURL + path, {
      method: "POST",
      body:  formData
    });
    const resp_json = await resp.json();
    return resp_json
  },

  async downloadTsv() {
      let tsvContent = "";
      let tsvKey = ''

      tsvKey = Object.keys( this.surveyItemsSelected[0] ).join("\t");

      this.surveyItemsSelected.forEach(it_select => {
          let row = Object.values(it_select).join("\t");
          tsvContent += row + "\n";
      });

      tsvContent = tsvKey + "\n" + tsvContent

      // // Save the CSV string as a TSV file
      const blob = new Blob([tsvContent], { type: 'text/tab-separated-values' })
      saveAs(blob, 'output.tsv')

  },

  async createNewTree() {
    this.createTree = {
      "scientific_name" : '',
      "scientific_chi_name" : '',
      "family" : 1,
      "common_name" : '',
      "common_chi_name" : '',
      "img_url" : '',
      "short_desc" : '',
      "long_desc" : '',
      "native_exotic" : 1,
      "short_chi_desc" : '',
      "long_chi_desc" : '',
    }
    this.isCreateNewTree = true
  },

  async submitCreateTree() {
    let path = 'insertMasterTreeTable'
    let cData = {
      data: this.createTree
    }
    console.log( 'createTree', cData )
    const updateResp = await fetch(this.baseURL + path, {
      method: "POST",
      body: JSON.stringify(cData),
      headers : {
        "Content-type": "application/json;charset=UTF-8",
      }
    });
    const update_resp = await updateResp.json();
    return update_resp 
  },

  async updateTree() {
    let path = 'updateMasterTreeTableById'
    let pData = {
      data: this.updateTreeData
    }

    const updateResp = await fetch(this.baseURL + path, {
      method: "POST",
      body: JSON.stringify(pData),
      headers : {
        "Content-type": "application/json;charset=UTF-8",
      }
    });
    const update_resp = await updateResp.json();
    return update_resp 
  },

  async dateFormat( _dateTime ) {
    var _date = new Date(_dateTime)
    return   String(_date.getDate()).padStart(2, '0')+
              "/"+String((_date.getMonth()+1)).padStart(2, '0')+
              "/"+_date.getFullYear()+
              " "+String(_date.getHours()).padStart(2, '0')+
              ":"+String(_date.getMinutes()).padStart(2, '0')+
              ":"+String(_date.getSeconds()).padStart(2, '0')
  }

  },
  getters : {
    getIsOpen() {
      return this.isSideBarOpen
    },
    dropDownTreeList(state) {
      return state.masterTreeList.map(item => ({...item, label : item.value}))
      // return state.treeLists.map(item => ({...item, label : item.value}))
      // .filter(item => item.status != 0);

    },
    getUserInfo(state){
      return state.userInfo && state.userInfo.data
    },
  }
})
