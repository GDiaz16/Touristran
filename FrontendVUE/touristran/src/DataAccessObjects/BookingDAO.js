const axios = require("axios");

function getBookings(callback) {
  axios
    .get("http://localhost:8080/api/booking")
    .then(response => {
      //console.log(response);
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export default {getBookings};
