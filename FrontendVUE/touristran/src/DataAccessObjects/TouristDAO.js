const axios = require("axios");

function getTourist() {
  axios.get("http://localhost:8080/api/booking/").then((response) => {
    console.log(response);
  }).catch(function(error){
    console.log(error)
  }); 
  //console.log('tag', 'Hola mundo')
  
}

export default getTourist;