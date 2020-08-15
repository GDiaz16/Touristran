<template>
  <div>
    <div>
      <b-tabs content-class="mt-3">
        <b-tab title="Turistas" active>
          <Tourists></Tourists>
        </b-tab>
        <b-tab title="Ciudades">
          <Cities></Cities>
        </b-tab>
        <b-tab title="Historial de reservaciones">
          <Bookings></Bookings>
        </b-tab>
      </b-tabs>
    </div>
  </div>
</template>

<script>
import Tourists from "./Screens/Tourists";
import Cities from "./Screens/Cities";
import Bookings from "./Screens/Bookings";

export default {
  name: "Home",
  components: {
    Tourists,
    Cities,
    Bookings,
  },
};
</script>

<style>
</style>