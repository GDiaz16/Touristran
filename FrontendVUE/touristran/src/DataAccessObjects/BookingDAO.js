const axios = require("axios");

function getBookings(callback) {
  axios
    .get("http://localhost:8080/api/booking")
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function getBooking(id, callback) {
  axios
    .get(`http://localhost:8080/api/booking/${id}`)
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function createBooking(booking, callback) {
  axios
    .post("http://localhost:8080/api/booking", booking)
    .then(response => {
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function updateBooking(booking, callback) {
  axios
    .put("http://localhost:8080/api/booking/0", booking)
    .then(response => {
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function deleteBooking(id, callback) {
  axios
    .delete(`http://localhost:8080/api/booking/${id}`)
    .then(response => {
      callback(response.status);
    })
    .catch(function(error) {
      console.log(error);
    });
}

function getBookingByCity(id, callback) {
  axios
    .get(`http://localhost:8080/api/booking/city/${id}`)
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
function getBookingByTourist(id, callback) {
  axios
    .get(`http://localhost:8080/api/booking/tourist/${id}`)
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
function getBookingByDate(date, callback) {
  axios
    .get(`http://localhost:8080/api/booking/date?date=${date}`)
    .then(response => {
      callback(response.data);
    })
    .catch(function(error) {
      console.log(error);
    });
}
export default {
  getBookings,
  getBooking,
  createBooking,
  updateBooking,
  deleteBooking,
  getBookingByCity,
  getBookingByTourist,
  getBookingByDate
};
