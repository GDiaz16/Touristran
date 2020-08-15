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

export default {getCities};
