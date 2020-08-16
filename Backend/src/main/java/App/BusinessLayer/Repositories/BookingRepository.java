package App.BusinessLayer.Repositories;

import App.DataLayer.Models.BookingModel;
import App.DataLayer.Models.CityModel;
import App.DataLayer.Models.TouristModel;
import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingModel, Integer> {

    List<BookingModel> findByfkTouristEquals(int touristID);

    List<BookingModel> findByfkCityEquals(int cityID);

    List<BookingModel> findBydateEquals(LocalDate date);
}
