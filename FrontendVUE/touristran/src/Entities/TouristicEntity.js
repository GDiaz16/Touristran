class TouristEntity {
  constructor(
    pkTourist,
    city,
    name,
    birthday,
    idOfTourist,
    idType,
    travelFrequencyInMonths,
    budget,
    hasCreditCard
  ) {
    this.pkTourist = pkTourist;
    this.city = city;
    this.name = name;
    this.birthday = birthday;
    this.idOfTourist = idOfTourist;
    this.idType = idType;
    this.travelFrequencyInMonths = travelFrequencyInMonths;
    this.budget = budget;
    this.hasCreditCard = hasCreditCard;
  }

  getPkTourist() {
    return this.pkTourist;
  }

  setPkTourist(pkTourist) {
    this.pkTourist = pkTourist;
  }

  getCity() {
    return this.city;
  }

  setCity(city) {
    this.city = city;
  }

  getName() {
    return name;
  }

  setName(name) {
    this.name = name;
  }

  getBirthday() {
    return this.birthday;
  }

  setBirthday(birthday) {
    this.birthday = birthday;
  }

  getIdType() {
    return this.idType;
  }

  setIdType(idType) {
    this.idType = idType;
  }

  getTravelFrequencyInMonths() {
    return this.travelFrequencyInMonths;
  }

  setTravelFrequencyInMonths(travelFrequencyInMonths) {
    this.travelFrequencyInMonths = travelFrequencyInMonths;
  }

  getBudget() {
    return this.budget;
  }

  setBudget(budget) {
    this.budget = budget;
  }

  getHasCreditCard() {
    return this.hasCreditCard;
  }

  setHasCreditCard(hasCreditCard) {
    this.hasCreditCard = hasCreditCard;
  }

  getIdOfTourist() {
    return this.idOfTourist;
  }

  setIdOfTourist(idOfTourist) {
    this.idOfTourist = idOfTourist;
  }

  toString() {
    return (
      "TouristEntity{" +
      "pkTourist=" +
      this.pkTourist +
      ", fkCity=" +
      this.fkCity +
      ", name=" +
      this.name +
      ", birthday=" +
      this.birthday +
      ", id=" +
      this.idOfTourist +
      ", idType=" +
      this.idType +
      ", travelFrequencyInMonths=" +
      this.travelFrequencyInMonths +
      ", budget=" +
      this.budget +
      ", hasCreditCard=" +
      this.hasCreditCard +
      "}"
    );
  }
}
