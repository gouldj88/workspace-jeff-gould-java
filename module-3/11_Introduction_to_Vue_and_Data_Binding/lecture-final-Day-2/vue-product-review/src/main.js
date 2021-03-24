/* This is automatically generated by vue create command  
   We should probably never have to change anything in here

   Vue uses this to inject our Vue components into the index.html
*/
import Vue from 'vue'        // Give me to access the Vue stuff
import App from './App.vue'  // Give me to access the App.vue component 

Vue.config.productionTip = false  // Disable hints about Vue for the App
                                  // no longer needed as it is now the default

new Vue({              // instantiate a Vue application object
  render: h => h(App), // render tells Vue what the main component is called - must match name of an import
}).$mount('#app')      // $mount - tells Vue where in the index.html the Vue components should be added
                       // #app - the element with id='app' will have the Vue components added to it
