const axios = require("axios");

function getCities(callback) {
  axios
    .get("http://localhost:8080/api/cities/")
    .then(response => {
      //console.log(response);
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function getCity(id, callback) {
  axios
    .get(`http://localhost:8080/api/cities/${id}`)
    .then(response => {
      //console.log(response);
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function createCity(city, callback) {
  axios
    .post("http://localhost:8080/api/cities", city)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function updateCity(city, callback) {
  axios
    .put("http://localhost:8080/api/cities/0", city)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function deleteCity(id, callback) {
  axios
    .delete(`http://localhost:8080/api/cities/${id}`)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export default {
  getCities,
  getCity,
  createCity,
  updateCity,
  deleteCity
};
