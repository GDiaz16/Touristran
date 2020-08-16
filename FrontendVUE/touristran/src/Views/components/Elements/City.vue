<template>
  <div>
    <b-card
      class="m-3"
      border-variant="warning"
      header="Ciudad"
      header-bg-variant="warning"
      header-text-variant="white"
    >
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Nombre" label-for="input-1" class>
                <b-form-input v-model="city.name"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Habitantes" label-for="input-1" class>
                <b-form-input v-model="city.inhabitants" type="number"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Identificación" label-for="input-1" class>
                <b-form-input v-model="city.mostTouristicPlace"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Frecuencia de viaje" label-for="input-1" class>
                <b-form-input v-model="city.mostRelevantHotel"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-button variant="warning" @click="updateCityDB">Actualizar</b-button>
          <b-button
            variant="primary"
            @click="getTouristsList"
            v-b-modal="modalId"
          >Historial de visitantes</b-button>
          <b-button variant="danger" @click="deleteCityDB">Borrar</b-button>
        </b-container>
      </b-form>
    </b-card>

    <b-modal :id="modalId" title="Historial de visitantes" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <ul v-for="(tourist, index) in tourists" :key="index">
                <li>{{tourist}}</li>
              </ul>
            </b-col>
          </b-row>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import CityDAO from "./../../../DataAccessObjects/CityDAO";
import BookingDAO from "./../../../DataAccessObjects/BookingDAO";
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";

export default {
  name: "City",
  data() {
    return {
      response: "",
      tourists: [],
    };
  },
  props: {
    city: {
      type: Object,
    },
    modalId: String,
    cities: [],
    getCitiesDB: Function,
  },
  methods: {
    getCityDB() {
      var data;
      CityDAO.getCity(this.city.pkCity, (data) => {
        console.log(data);
        this.cities = data;
      });
    },
    getTouristDB() {
      var data;
      TouristDAO.getTourist(this.booking.fkTourist, (data) => {
        console.log(data);
        this.tourist = data.name;
      });
    },
    updateCityDB() {
      CityDAO.updateCity(this.city, (response) => {
        this.response = response;
        this.getCitiesDB();
      });
    },
    deleteCityDB() {
      CityDAO.deleteCity(this.city.pkCity, (response) => {
        this.response = response;
        this.getCitiesDB();
      });
    },
    getTouristsList() {
      var bookingList = [];
      BookingDAO.getBookingByCity(this.city.pkCity, (data) => {
        data.forEach((element) => {
          TouristDAO.getTourist(element.fkTourist, (data) => {
            bookingList.push(data.name);
            this.tourists = Array.from(new Set(bookingList));
          });
        });
      });
    },
  },
};
</script>

<style>
</style>