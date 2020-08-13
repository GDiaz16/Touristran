package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Tourist")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkTourist")
public class TouristModel {
    public TouristModel() {
    }

    public TouristModel(CityModel fkCity, String name, Date birthday, String idOfTourist,
                        String idType, int travelFrequencyInMonths,
                        double budget, boolean hasCreditCard) {
        this.fkCity = fkCity;
        this.name = name;
        this.birthday = birthday;
        this.idOfTourist = idOfTourist;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkTourist;

    @ManyToOne
    @JoinColumn(name = "pkCity", nullable = true)
    private CityModel fkCity;

    private String name;

    private Date birthday;

    private String idOfTourist;

    private String idType;

    private int travelFrequencyInMonths;

    private double budget;

    private boolean hasCreditCard;

    @OneToMany(mappedBy = "fkTourist", orphanRemoval = true)
    @JsonIgnore
    private List<BookingModel> bookingModelSet;
}
