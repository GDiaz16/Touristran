const axios = require("axios");

function getTourists(callback) {
  axios.get("http://localhost:8080/api/tourists").then((response) => {
    //console.log(response);
    callback(response.data);
  }).catch(function(error){
    console.log(error)
  }); 
  
}

export default {getTourists};