class BookingEntity {
  constructor(fkTourist, fkCity, date) {
    this.fkTourist = fkTourist;
    this.fkCity = fkCity;
    this.date = date;
  }

  getFkTourist() {
    return this.fkTourist;
  }

  setFkTourist(fkTourist) {
    this.fkTourist = fkTourist;
  }

  getFkCity() {
    return this.fkCity;
  }

  setFkCity(fkCity) {
    this.fkCity = fkCity;
  }

  getDate() {
    return this.date;
  }

  setDate(date) {
    this.date = date;
  }
}
