<template>
  <div id="app">
    <Home></Home>
  </div>
</template>

<script>
import Home from "./Views/components/Home";

export default {
  name: "app",
  components: {
    Home,
  },
  data() {
    return {
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
