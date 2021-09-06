import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogin:false,
    user:{
      email:"",
      token:""
    }
  },
  mutations: {
    SET_TOKEN() {
      
    }
  },
  actions: {
  },
  modules: {
  }
})
