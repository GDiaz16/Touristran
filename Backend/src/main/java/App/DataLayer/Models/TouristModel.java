package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDate;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Tourist")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkTourist")
public class TouristModel {

    public TouristModel() {
    }

    public TouristModel(String city, String name, LocalDate birthday, String idOfTourist,
            String idType, int travelFrequencyInMonths,
            double budget, boolean hasCreditCard) {

        this.name = name;
        this.birthday = birthday;
        this.idOfTourist = idOfTourist;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
        this.city = city;
    }

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkTourist;

    private String city;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String idOfTourist;

    private String idType;

    private int travelFrequencyInMonths;

    private double budget;

    private boolean hasCreditCard;

    // Relacion uno a muchos con booking
    @OneToMany(mappedBy = "fkTourist", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<BookingModel> bookingModelSet;

}
