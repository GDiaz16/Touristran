package App.DataLayer.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    public CityModel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PK_CITY;

    private String name;

    private int inhabitants;

    private String mostTouristicPlace;

    private String mostRelevantHotel;

    @OneToMany(mappedBy = "FK_CITY", cascade = CascadeType.ALL)
    private Set<BookingModel> bookingModelSet;

    @OneToMany(mappedBy = "FK_CITY")
    private Set<TouristModel> touristModels;
}
