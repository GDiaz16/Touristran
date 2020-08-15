package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDate;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Tourist")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkTourist")
public class TouristModel {

    public TouristModel() {
    }

    public TouristModel(/*CityModel cityModel, Long fkCity,*/String city, String name, LocalDate birthday, String idOfTourist,
            String idType, int travelFrequencyInMonths,
            double budget, boolean hasCreditCard) {
//        this.cityModel = cityModel;
//        this.fkCity = fkCity;
        this.name = name;
        this.birthday = birthday;
        this.idOfTourist = idOfTourist;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkTourist;

//    @ManyToOne(targetEntity = CityModel.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "pkCity", nullable = true)
//    private CityModel cityModel;
//
//    @Column(name = "pkCity", insertable = false, updatable = false)
//    private Long fkCity;
    private String city;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String idOfTourist;

    private String idType;

    private int travelFrequencyInMonths;

    private double budget;

    private boolean hasCreditCard;

    @OneToMany(mappedBy = "fkTourist", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<BookingModel> bookingModelSet;

}
