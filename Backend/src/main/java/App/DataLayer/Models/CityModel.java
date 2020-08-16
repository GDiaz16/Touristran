package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "City")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkCity")
public class CityModel {
    public CityModel(String name, int inhabitants, String mostTouristicPlace,
                     String mostRelevantHotel) {
        this.name = name;
        this.inhabitants = inhabitants;
        this.mostTouristicPlace = mostTouristicPlace;
        this.mostRelevantHotel = mostRelevantHotel;
    }

    public CityModel() {}

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkCity;

    private String name;

    private int inhabitants;

    private String mostTouristicPlace;

    private String mostRelevantHotel;

    // Relacion uno a muchos con booking
    @OneToMany(mappedBy = "fkCity", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<BookingModel> bookingModelSet;

}
