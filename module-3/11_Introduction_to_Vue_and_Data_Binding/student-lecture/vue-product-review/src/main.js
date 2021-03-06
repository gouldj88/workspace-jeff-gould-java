/***************************************************************
This is automatically generated by the vue create command
We should probably never have to change anything in here 

Vue uses this to inject our Vue components into the index.html
***************************************************************/
import Vue from 'vue'         // Give me access the Vue stuff
import App from './App.vue'   // Give me access the App.vue component

Vue.config.productionTip = false    // Disable hints about Vue for the App
                                    // No longer needed as it is now the default


new Vue({                 // This instantiates a Vue application object
  render: h => h(App),    // Render tells Vue what the main component is called
}).$mount('#app')         // $mount tells Vue where in the index.html the Vue components should be added
                          // #app - the element with the id='app' will have the Vue components added to it
