const axios = require("axios");

function getApiCities(callback) {
  axios
    .get("http://localhost:7070/web-api/cities/")
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

export default getApiCities;
