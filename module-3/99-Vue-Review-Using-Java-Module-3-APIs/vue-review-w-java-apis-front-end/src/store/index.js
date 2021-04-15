import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    hotels: []  // Hotels that we want to work with - data come from the SET_HOTELS mutation
  },
  mutations: {
    SET_HOTELS(state, data) { // Take the data passed in to it
      state.hotels = data;    // and assign it to the hotels array
    },
  },
  actions: {},
  modules: {}
});
