package App.BusinessLayer.Repositories;

import App.DataLayer.Models.BookingModel;
import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interfaz usada por hibernate para hacer tareas de CRUD
@Repository
public interface BookingRepository extends CrudRepository<BookingModel, Integer> {

    // Consultas personalizadas:
    
    List<BookingModel> findByfkTouristEquals(int touristID);

    List<BookingModel> findByfkCityEquals(int cityID);

    List<BookingModel> findBydateEquals(LocalDate date);
}
