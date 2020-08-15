package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Booking")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pkBooking")
public class BookingModel {

    public BookingModel() {
    }

    public BookingModel(CityModel cityModel, TouristModel touristModel, int fkCity, int fkTourist, LocalDate date) {
        this.fkTourist = fkTourist;
        this.fkCity = fkCity;
        this.date = date;
        this.cityModel = cityModel;
        this.touristModel = touristModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkBooking;

    @ManyToOne(targetEntity = TouristModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pkTourist", nullable = true)
    private TouristModel touristModel;

    @ManyToOne(targetEntity = CityModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pkCity", nullable = true)
    private CityModel cityModel;

    @Column(name = "pkTourist", updatable = false, insertable = false)
    private int fkTourist;

    @Column(name = "pkCity", updatable = false, insertable = false)
    private int fkCity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
