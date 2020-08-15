<template>
  <div>
    <b-card
      class="m-3"
      border-variant="primary"
      header="Turista"
      header-bg-variant="primary"
      header-text-variant="white"
    >
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Nombre" label-for="input-1" class>
                <b-form-input v-model="tourist.name"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha de nacimiento" label-for="input-1" class>
                <b-form-input v-model="tourist.birthday" type="date"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-form-group
                id="fieldset-1"
                label="Tipo de identificación"
                label-for="input-1"
                class
              >
                <b-form-select v-model="tourist.idType" :options="typesOfIdentity"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Identificación" label-for="input-1" class>
                <b-form-input v-model="tourist.idOfTourist"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Frecuencia de viaje" label-for="input-1" class>
                <b-form-input v-model="tourist.travelFrequencyInMonths" type="number"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Presupuesto" label-for="input-1" class>
                <b-form-input v-model="tourist.budget" type="number"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Destino" label-for="input-1" class>
                <b-form-select v-model="tourist.fkCity" :options="citiesOption"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Tarjeta de crédito" label-for="input-1" class>
                <b-form-select
                  v-model="tourist.hasCreditCard"
                  :options="[{value:true, text:'SI'},{value:false,text:'NO'}]"
                ></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>
          <b-button variant="primary" @click="updateTouristDB">Actualizar</b-button>
          <b-button variant="warning" v-b-modal="modalId">Ciudades visitadas</b-button>
          <b-button variant="danger" @click="deleteTouristDB">Borrar</b-button>
        </b-container>
      </b-form>
    </b-card>
    <b-modal :id="modalId" title="Ciudades visitadas" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <ul v-for="(city, index) in cities" :key="index">
                <li>{{city}}</li>
              </ul>
            </b-col>
          </b-row>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";
import CityDAO from "./../../../DataAccessObjects/CityDAO";

export default {
  name: "Tourist",
  data() {
    return {
      response: "",
      citiesOption: [],
      typesOfIdentity: [
        { value: "CÉDULA DE CIUDADANIA", text: "CÉDULA DE CIUDADANIA" },
        { value: "CÉDULA DE EXTRANJERÍA", text: "CÉDULA DE EXTRANJERÍA" },
        { value: "PASAPORTE", text: "PASAPORTE" },
        { value: "REGISTRO CIVIL", text: "REGISTRO CIVIL" },
        { value: "TARJETA DE IDENTIDAD", text: "TARJETA DE IDENTIDAD" },
      ],
    };
  },
  props: {
    tourist: {
      type: Object,
    },
    modalId: String,
    cities: [],
    getTouristsDB: Function,
  },
  methods: {
    getTouristDB() {
      var data;
      TouristDAO.getTourists(this.tourist.pkTourist, (data) => {
        console.log(data);
        this.tourists = data;
      });
    },
    updateTouristDB() {
      this.tourist.cityModel.pkCity = this.tourist.fkCity;
      TouristDAO.updateTourist(this.tourist, (response) => {
        this.response = response;
        this.getTouristsDB();
      });
    },
    deleteTouristDB() {
      TouristDAO.deleteTourist(this.tourist.pkTourist, (response) => {
        this.response = response;
        this.getTouristsDB();
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
        this.citiesOption = citiesAux;
      });
    },
  },
};
</script>

<style>
</style>