package App.DataLayer.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "City")
public class CityModel {

    public CityModel(String name, int inhabitants, String mostTouristicPlace,
            String mostRelevantHotel) {
        this.name = name;
        this.inhabitants = inhabitants;
        this.mostTouristicPlace = mostTouristicPlace;
        this.mostRelevantHotel = mostRelevantHotel;
    }

    public CityModel() {
    }

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PK_CITY;

    private String name;

    private int inhabitants;

    private String mostTouristicPlace;

    private String mostRelevantHotel;

}
