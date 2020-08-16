package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.BookingRepository;
import App.BusinessLayer.Repositories.BookingRepository;
import App.DataLayer.Models.BookingModel;
import App.DataLayer.Models.CityModel;
import App.DataLayer.Models.TouristModel;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingModel> findAll() {
        return (List<BookingModel>) bookingRepository.findAll();
    }

    public BookingModel findById(int id) {
        return bookingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<BookingModel> findByfkTourist(int id) {
        return bookingRepository.findByfkTouristEquals(id);
    }

    public List<BookingModel> findByfkCity(int id) {
        return bookingRepository.findByfkCityEquals(id);
    }

    public List<BookingModel> findBydate(LocalDate date) {
        return bookingRepository.findBydateEquals(date);
    }

    public BookingModel save(BookingModel bookingModel) {
        return bookingRepository.save(bookingModel);
    }

    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }
}
