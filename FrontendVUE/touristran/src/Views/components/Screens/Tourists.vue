<template>
  <div>
    <b-button variant="success" class="m-3 b-floating" v-b-modal.modal-1>Agregar turista</b-button>
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
                <b-form-input v-model="newTourist.fkCity"></b-form-input>
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
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import Tourist from "./../Elements/Tourist";
import TouristDAO from "./../../../DataAccessObjects/TouristDAO";
export default {
  name: "Tourists",
  components: {
    Tourist,
  },
  data() {
    return {
      response: "",
      typesOfIdentity: [
        { value: "CÉDULA DE CIUDADANIA", text: "CÉDULA DE CIUDADANIA" },
        { value: "CÉDULA DE EXTRANJERÍA", text: "CÉDULA DE EXTRANJERÍA" },
        { value: "PASAPORTE", text: "PASAPORTE" },
        { value: "REGISTRO CIVIL", text: "REGISTRO CIVIL" },
        { value: "TARJETA DE IDENTIDAD", text: "TARJETA DE IDENTIDAD" },
      ],
      newTourist: {
        fkCity: 1,
        cityModel: {
          pkCity: 1,
        },
        name: "",
        birthday: "",
        idOfTourist: "",
        idType: "",
        travelFrequencyInMonths: 0,
        budget: 0,
        hasCreditCard: false,
      },
      tourists: [
        {
          pkTourist: 1,

          fkCity: 1,
          cityModel: {
            pkCity: 1,
          },
          name: "Pedro Diaz",
          birthday: "1998-05-07",
          idOfTourist: "123456",
          idType: "CC",
          travelFrequencyInMonths: 2,
          budget: 1000000.0,
          hasCreditCard: false,
        },
        {
          pkTourist: 2,
          fkCity: 1,
          cityModel: {
            pkCity: 1,
          },
          name: "Gonzalo Diaz Muñoz",
          birthday: "1998-05-07",
          idOfTourist: "78965461",
          idType: "CC",
          travelFrequencyInMonths: 2,
          budget: 1000000.0,
          hasCreditCard: true,
        },
        {
          pkTourist: 3,
          fkCity: 1,
          cityModel: {
            pkCity: 1,
          },
          name: "Maria Hernandez",
          birthday: "1998-05-07",
          idOfTourist: "3135468",
          idType: "CC",
          travelFrequencyInMonths: 2,
          budget: 1000000.0,
          hasCreditCard: false,
        },
      ],
    };
  },
  methods: {
    getTouristsDB() {
      var data;
      TouristDAO.getTourists((data) => {
        console.log(data);
        this.tourists = data;
      });
    },
    createTouristDB() {
      this.newTourist.cityModel.pkCity = this.newTourist.fkCity;
      TouristDAO.createTourist(this.newTourist, (response) => {
        this.response = response;
        this.getTouristsDB();
      });
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
</style>