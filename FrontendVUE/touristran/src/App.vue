<template>
  <div id="app">
    <Home></Home>
  </div>
</template>

<script>
import TouristDAO from "./DataAccessObjects/TouristDAO";
import Home from "./Views/components/Home";
console.log("tag", TouristDAO());

export default {
  name: "app",
  components: {
    Home,
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
    };
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

}


</style>
