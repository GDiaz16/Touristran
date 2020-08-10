package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Tourist")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pk_TOURIST")
public class TouristModel {
    public TouristModel() {
    }

    public TouristModel(CityModel FK_CITY, String name, Date birthday, String id,
                        String idType, int travelFrequencyInMonths,
                        double budget, boolean hasCreditCard) {
        this.FK_CITY = FK_CITY;
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PK_TOURIST;

    @ManyToOne
    @JoinColumn(name = "PK_CITY", nullable = true)
    private CityModel FK_CITY;

    private String name;

    private Date birthday;

    private String id;

    private String idType;

    private int travelFrequencyInMonths;

    private double budget;

    private boolean hasCreditCard;

    @OneToMany(mappedBy = "FK_TOURIST", orphanRemoval = true)
    private List<BookingModel> bookingModelSet;
}
