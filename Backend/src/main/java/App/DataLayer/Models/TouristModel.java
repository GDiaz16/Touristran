package App.DataLayer.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "Tourist")
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

    @OneToMany(mappedBy = "FK_TOURIST", cascade = CascadeType.ALL)
    private Set<BookingModel> bookingModelSet;
}
