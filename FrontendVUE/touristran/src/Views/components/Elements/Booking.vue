<template>
  <div>
    <b-card
      class="m-3"
      border-variant="info"
      header="Reservacion"
      header-bg-variant="info"
      header-text-variant="white"
    >
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Ciudad" label-for="input-1" class>
                <b-form-input v-model="tourist" :disabled="true"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Turista" label-for="input-1" class>
                <b-form-input v-model="city" :disabled="true"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha" label-for="input-1" class>
                <b-form-input v-model="booking.date" type="date" :disabled="true"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
        </b-container>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";
import CityDAO from "./../../../DataAccessObjects/CityDAO";

export default {
  name: "Booking",
  data() {
    return {
      city: "",
      tourist: "",
    };
  },

  props: {
    booking: {
      type: Object,
    },
  },
  methods: {
    getCityDB() {
      var data;
      CityDAO.getCity(this.booking.fkCity, (data) => {
        console.log(data);
        this.city = data.name;
      });
    },
    getTouristDB() {
      var data;
      TouristDAO.getTourist(this.booking.fkTourist, (data) => {
        console.log(data);
        this.tourist = data.name;
      });
    },
  },
  beforeMount() {
    this.getCityDB();
    this.getTouristDB();
  },
};
</script>

<style>
</style>