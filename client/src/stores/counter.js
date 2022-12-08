import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useStore = defineStore({
  id: 'counter',
  state: () => ({
  isSideBarOpen : false,
  }),  

  actions : {
    toggleOpen() {
      this.isSideBarOpen = !this.isSideBarOpen
      document.body.classList.toggle("stopScroll")
    }
  },

  getters : {
    getIsOpen() {
      return this.isSideBarOpen
    }
  }
})
