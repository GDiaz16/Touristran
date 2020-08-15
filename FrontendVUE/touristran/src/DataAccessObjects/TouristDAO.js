const axios = require("axios");

function getTourists(callback) {
  axios
    .get("http://localhost:8080/api/tourists")
    .then(response => {
      //console.log(response);
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
function getTourist(id, callback) {
  axios
    .get(`http://localhost:8080/api/tourists/${id}`)
    .then(response => {
      //console.log(response);
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function createTourist(tourist, callback) {
  axios
    .post("http://localhost:8080/api/tourists", tourist)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function updateTourist(tourist, callback) {
  axios
    .put("http://localhost:8080/api/tourists/0", tourist)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function deleteTourist(id, callback) {
  axios
    .delete(`http://localhost:8080/api/tourists/${id}`)
    .then(response => {
      //console.log(response);
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export default {
  getTourists,
  getTourist,
  createTourist,
  updateTourist,
  deleteTourist
};
