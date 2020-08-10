package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "City")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pk_CITY")
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

    @OneToMany(mappedBy = "FK_CITY", orphanRemoval = true)
    private List<BookingModel> bookingModelSet;

    @OneToMany(mappedBy = "FK_CITY", orphanRemoval = true)
    private List<TouristModel> touristModels;
}
