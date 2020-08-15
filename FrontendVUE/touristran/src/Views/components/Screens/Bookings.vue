<template>
  <div>
    <b-button variant="success" class="m-3 b-floating" v-b-modal.modal-3>Hacer reservación</b-button>
    <div v-for="booking in bookings" :key="booking.pkBooking">
      <Booking :booking="booking"></Booking>
    </div>
    <b-modal id="modal-3" title="Agregar ciudad" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Ciudad" label-for="input-1" class>
                <b-form-input v-model="newBooking.fkCity"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Turista" label-for="input-1" class>
                <b-form-input v-model="newBooking.fkTourist"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha" label-for="input-1" class>
                <b-form-input v-model="newBooking.date" type="date"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-button variant="success">Crear reservación</b-button>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import Booking from "./../Elements/Booking";
export default {
  name: "Bookings",
  components: {
    Booking,
  },
  data() {
    return {
      newBooking: {
        pkBooking: 1,
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
      bookings: [
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
        {
          pkBooking: 2,
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
        {
          pkBooking: 3,
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
      ],
    };
  },
};
</script>

<style>
</style>