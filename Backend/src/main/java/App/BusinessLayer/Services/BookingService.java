package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.BookingRepository;
import App.BusinessLayer.Repositories.BookingRepository;
import App.DataLayer.Models.BookingModel;
import App.DataLayer.Models.CityModel;
import App.DataLayer.Models.ToDo;
import App.DataLayer.Models.TouristModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingModel> findAll(){
        return (List<BookingModel>) bookingRepository.findAll();
    }

    public BookingModel findById(int id){
        return bookingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List <BookingModel> findByfkTourist( TouristModel touristModel){
        return bookingRepository.findByfkTouristEquals(touristModel);
    }

    public List <BookingModel> findByfkCity( CityModel cityModel){
        return bookingRepository.findByfkCityEquals(cityModel);
    }

    public BookingModel save(BookingModel bookingModel){
        return bookingRepository.save(bookingModel);
    }

    public void deleteById(int id){
        bookingRepository.deleteById(id);
    }
}
