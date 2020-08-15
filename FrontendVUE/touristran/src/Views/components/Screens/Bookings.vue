<template>
  <div>
    <b-button
      variant="success"
      @click="getData"
      class="m-3 b-floating"
      v-b-modal.modal-3
    >Hacer reservación</b-button>
    <div v-for="booking in bookings" :key="booking.pkBooking">
      <Booking :booking="booking"></Booking>
    </div>
    <b-modal id="modal-3" title="Agregar ciudad" size="xl" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Ciudad" label-for="input-1" class>
                <b-form-select v-model="newBooking.fkCity" :options="cities"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Turista" label-for="input-1" class>
                <b-form-select v-model="newBooking.fkTourist" :options="tourists"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha" label-for="input-1" class>
                <b-form-input v-model="newBooking.date" type="date"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-button variant="success" @click="createBookingDB">Crear reservación</b-button>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import Booking from "./../Elements/Booking";
import BookingDAO from "./../../../DataAccessObjects/BookingDAO";
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";
import CityDAO from "./../../../DataAccessObjects/CityDAO";

export default {
  name: "Bookings",

  components: {
    Booking,
  },
  data() {
    return {
      response: "",
      tourists: [],
      cities: [],
      newBooking: {
        touristModel: {
          pkTourist: 2,
        },
        cityModel: {
          pkCity: 1,
        },
        fkTourist: 2,
        fkCity: 1,
        date: "",
      },
      bookings: [] /* [
        {
          pkBooking: 1,
          touristModel: {
            pkTourist: 2,
          },
          cityModel: {
            pkCity: 1,
          },
          fkTourist: 2,
          fkCity: 1,
          date: "2020-10-04",
        },

      ] */,
    };
  },
  methods: {
    getTouristsDB() {
      var data;
      TouristDAO.getTourists((data) => {
        console.log(data);
        var touristsAux = [];
        data.forEach((element) => {
          touristsAux.push({ value: element.pkTourist, text: element.name });
        });
        this.tourists = touristsAux;
      });
    },
    getCitiesDB() {
      var data;
      CityDAO.getCities((data) => {
        console.log(data);
        var citiesAux = [];
        data.forEach((element) => {
          citiesAux.push({ value: element.pCity, text: element.name });
        });
        this.cities = citiesAux;
      });
    },
    getData() {
      this.getCitiesDB();
      this.getTouristsDB();
    },
    getBookingDB() {
      var data;
      BookingDAO.getBookings((data) => {
        console.log(data);
        this.bookings = data;
      });
    },
    createBookingDB() {
      this.newBooking.cityModel.pkCity = this.newBooking.fkCity;
      this.newBooking.touristModel.pkTourist = this.newBooking.fkTourist;
      BookingDAO.createBooking(this.newBooking, (response) => {
        this.response = response;
        this.getBookingDB();
      });
    },
  },
  beforeMount() {
    this.getBookingDB();
  },
};
</script>

<style>
</style>