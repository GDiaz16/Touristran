<template>
  <div>
    <b-button
      @click="getCitiesFromApi"
      variant="success"
      class="m-3 b-floating"
      v-b-modal.modal-2
    >Agregar ciudad</b-button>
    <b-button variant="warning" class="m-3 b-floating-2" @click="getCitiesDB">Actualizar lista</b-button>

    <div v-for="(city, index) in cities" :key="city.pkCity">
      <City :city="city" :getCitiesDB="getCitiesDB" :modalId="index.toString()"></City>
    </div>
    <b-modal id="modal-2" title="Agregar ciudad" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Elija la ciudad" label-for="input-1" class>
                <b-form-select v-model="apiCity" :options="citiesApi"></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>
          <b-button @click="createCityDB" variant="success">Asignar</b-button>
          <p class="success">{{response}}</p>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import City from "./../Elements/City";
import getApiCities from "../../../DataAccessObjects/WebServiceDAO";
import CityDAO from "./../../../DataAccessObjects/CityDAO";
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
      response: "",
      apiCity: {
        pkCity: 0,
        name: "",
        inhabitants: 0,
        mostTouristicPlace: "",
        mostRelevantHotel: "",
      },
      citiesApi: [],
      cities: [],
    };
  },
  methods: {
    getCitiesFromApi() {
      this.response = "";
      var data;
      getApiCities((data) => {
        var citiesAux = [];
        data.forEach((element) => {
          citiesAux.push({ value: element, text: element.name });
        });
        this.citiesApi = citiesAux;
      });
    },
    getCitiesDB() {
      var data;
      CityDAO.getCities((data) => {
        this.cities = data;
      });
    },
    createCityDB() {
      CityDAO.createCity(this.apiCity, (response) => {
        this.response = "Ciudad agregada a la lista!";
        this.getCitiesDB();
      });
    },
  },
  beforeMount() {
    this.getCitiesDB();
  },
};
</script>

<style>
</style>