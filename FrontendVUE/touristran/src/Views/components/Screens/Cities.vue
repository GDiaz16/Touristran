<template>
  <div>
    <b-button variant="success" class="m-3 b-floating" v-b-modal.modal-2>Agregar ciudad</b-button>
    <div v-for="(city, index) in cities" :key="city.pkCity">
      <City :city="city" :modalId="index.toString()"></City>
    </div>
    <b-modal id="modal-2" title="Agregar ciudad" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Elija la ciudad" label-for="input-1" class>
                <b-form-select
                  v-model="apiCity.pkCity"
                  :options="[{value:1, text:'Bogotá'},{value:1,text:'Medellin'}]"
                ></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>
          <b-button variant="success">Asignar</b-button>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import City from "./../Elements/City";

export default {
  name: "Cities",
  props: {
    busy: {
      type: Boolean,
      default: false,
    },
  },
  components: {
    City,
  },
  data() {
    return {
      apiCity: {
        pkCity: 0,
        name: "",
        inhabitants: 0,
        mostTouristicPlace: "",
        mostRelevantHotel: "",
      },
      cities: [
        {
          pkCity: 1,
          name: "Bogotá",
          inhabitants: 7650231,
          mostTouristicPlace: "Plaza de Bolivar",
          mostRelevantHotel: "Hotel Tequendama",
        },
        {
          pkCity: 2,
          name: "Medellin",
          inhabitants: 535345,
          mostTouristicPlace: "UDEA",
          mostRelevantHotel: "Hotel Barranquilla",
        },
        {
          pkCity: 3,
          name: "Cali",
          inhabitants: 95958568,
          mostTouristicPlace: "Plaza de toros",
          mostRelevantHotel: "Hotel Sucursal",
        },
      ],
    };
  },
};
</script>

<style>
</style>