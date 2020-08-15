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

          <b-button variant="warning">Actualizar</b-button>
          <b-button variant="primary" v-b-modal="modalId">Historial de visitantes</b-button>
          <b-button variant="danger">Borrar</b-button>
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
export default {
  name: "City",
  data() {
    return { tourists: ["Gonzalo", "Dennis"] };
  },
  props: {
    city: {
      type: Object,
    },
    modalId: String,
  },
};
</script>

<style>
</style>