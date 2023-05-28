import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

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
    }



  },
  getters : {
    getIsOpen() {
      return this.isSideBarOpen
    },
    dropDownTreeList(state) {
      return state.masterTreeList.map(item => ({...item, label : item.value}))

    },
    getUserInfo(state){
      return state.userInfo && state.userInfo.data
    } 
  }
})
