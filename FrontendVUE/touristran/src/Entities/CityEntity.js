class CityEntity {
  constructor(name, inhabitants, mostTouristicPlace, mostRelevantHotel) {
    this.name = name;
    this.inhabitants = inhabitants;
    this.mostTouristicPlace = mostTouristicPlace;
    this.mostRelevantHotel = mostRelevantHotel;
  }
  getName() {
    return name;
  }

  setName(name) {
    this.name = name;
  }

  getInhabitants() {
    return this.inhabitants;
  }

  setInhabitants(inhabitants) {
    this.inhabitants = inhabitants;
  }

  getMostTouristicPlace() {
    return this.mostTouristicPlace;
  }

  setMostTouristicPlace(mostTouristicPlace) {
    this.mostTouristicPlace = mostTouristicPlace;
  }

  getMostRelevantHotel() {
    return this.mostRelevantHotel;
  }

  setMostRelevantHotel(mostRelevantHotel) {
    this.mostRelevantHotel = mostRelevantHotel;
  }
}
