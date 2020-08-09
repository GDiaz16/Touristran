package App.DataLayer.Models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "Booking")
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

    @ManyToOne
    @JoinColumn(name = "PK_TOURIST", nullable = false)
    private TouristModel FK_TOURIST;

    @ManyToOne
    @JoinColumn(name = "PK_CITY", nullable = false)
    private CityModel FK_CITY;

    private Date date;
}
