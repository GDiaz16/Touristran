package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "Booking")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkBooking")
public class BookingModel {
    public BookingModel() {}

    public BookingModel(TouristModel fkTourist, CityModel fkCity, Date date) {
        this.fkTourist = fkTourist;
        this.fkCity = fkCity;
        this.date = date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkBooking;

    @ManyToOne
    @JoinColumn(name = "pkTourist", nullable = true)
    private TouristModel fkTourist;

    @ManyToOne
    @JoinColumn(name = "pkCity", nullable = true)
    private CityModel fkCity;

    private Date date;
}
