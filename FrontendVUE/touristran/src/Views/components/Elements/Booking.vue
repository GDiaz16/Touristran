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
                <b-form-input v-model="booking.fkCity"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Turista" label-for="input-1" class>
                <b-form-input v-model="booking.fkTourist"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha" label-for="input-1" class>
                <b-form-input v-model="booking.date" type="date"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

        </b-container>
      </b-form>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "Booking",
  props: {
    booking: {
      type: Object,
    },
  },
};
</script>

<style>
</style>