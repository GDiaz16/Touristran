<template>
  <div>
    <b-button
      variant="success"
      class="m-3 b-floating"
      v-b-modal.modal-1
      @click="getCitiesDB"
    >Agregar turista</b-button>
    <b-button variant="primary" class="m-3 b-floating-2" @click="getTouristsDB">Actualizar lista</b-button>

    <div v-for="(tourist, index) in tourists" :key="tourist.pkTourist">
      <Tourist :tourist="tourist" :modalId="'t-'+index.toString()" :getTouristsDB="getTouristsDB"></Tourist>
    </div>
    <b-modal id="modal-1" title="Agregar turista" size="xl" :hide-footer="true">
      <b-form>
        <b-container>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Nombre" label-for="input-1" class>
                <b-form-input v-model="newTourist.name"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Fecha de nacimiento" label-for="input-1" class>
                <b-form-input v-model="newTourist.birthday" type="date"></b-form-input>
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
                <b-form-select v-model="newTourist.idType" :options="typesOfIdentity"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Identificación" label-for="input-1" class>
                <b-form-input v-model="newTourist.idOfTourist"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Frecuencia de viaje" label-for="input-1" class>
                <b-form-input v-model="newTourist.travelFrequencyInMonths" type="number"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-form-group id="fieldset-1" label="Presupuesto" label-for="input-1" class>
                <b-form-input v-model="newTourist.budget" type="number"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Destino" label-for="input-1" class>
                <b-form-select v-model="newTourist.city" :options="citiesOptionCom"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="fieldset-1" label="Tarjeta de crédito" label-for="input-1" class>
                <b-form-select
                  v-model="newTourist.hasCreditCard"
                  :options="[{value:true, text:'SI'},{value:false,text:'NO'}]"
                ></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>
          <b-button variant="success" @click="createTouristDB">Guardar</b-button>
          <p class="success">{{response}}</p>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import Tourist from "./../Elements/Tourist";
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";
import CityDAO from "./../../../DataAccessObjects/CityDAO";

export default {
  name: "Tourists",
  components: {
    Tourist,
  },
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
      newTourist: {
        city: 1,
        name: "",
        birthday: "",
        idOfTourist: "",
        idType: "",
        travelFrequencyInMonths: 0,
        budget: 0,
        hasCreditCard: false,
      },
      tourists: [],
    };
  },
  methods: {
    getTouristsDB() {
      var data;
      TouristDAO.getTourists((data) => {
        this.tourists = data;
      });
    },
    createTouristDB() {
      TouristDAO.createTourist(this.newTourist, (response) => {
        this.response = "Creado!";
        this.getTouristsDB();
      });
    },
    getCitiesDB(callback) {
      this.response = "";
      var data;
      CityDAO.getCities((data) => {
        var citiesAux = [];
        data.forEach((element) => {
          citiesAux.push({ value: element.name, text: element.name });
        });
        this.citiesOption = citiesAux;
      });
    },
  },
  computed: {
    citiesOptionCom: function () {
      return this.citiesOption;
    },
  },
  beforeMount() {
    this.getTouristsDB();
  },
};
</script>

<style>
.b-floating {
  position: fixed;
  top: -15px;
  right: 8px;
  z-index: 10;
}
.b-floating-2 {
  position: fixed;
  top: -15px;
  right: 150px;
  z-index: 10;
}

.success {
  color: rgb(89, 177, 38);
}
</style>