package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
        property = "pk_BOOKING")
public class BookingModel {
    public BookingModel() {}

    public BookingModel(TouristModel FK_TOURIST, CityModel FK_CITY, Date date) {
        this.FK_TOURIST = FK_TOURIST;
        this.FK_CITY = FK_CITY;
        this.date = date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PK_BOOKING;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_TOURIST", nullable = true)
    private TouristModel FK_TOURIST;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_CITY", nullable = true)
    private CityModel FK_CITY;

    private Date date;
}
