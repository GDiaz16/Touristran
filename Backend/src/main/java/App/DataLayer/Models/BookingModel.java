package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Booking")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
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

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkBooking;

    // Entidad de relacion con la tabla turista
    @ManyToOne(targetEntity = TouristModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pkTourist", nullable = true)
    private TouristModel touristModel;

    // Entidad de relacion con la tabla ciudad
    @ManyToOne(targetEntity = CityModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pkCity", nullable = true)
    private CityModel cityModel;

    // Columna de relacion con la tabla turista
    @Column(name = "pkTourist", updatable = false, insertable = false)
    private int fkTourist;

    // Columna de relacion con la tabla ciudad
    @Column(name = "pkCity", updatable = false, insertable = false)
    private int fkCity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
