import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useStore = defineStore({
  id: 'store',
  state: () => ({
  isSideBarOpen : false,
  masterTreeList : [],
  userInfo: null,
  baseURL : 'https://api.hktreewatch.org/'
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
