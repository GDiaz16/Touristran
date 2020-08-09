package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.BookingRepository;
import App.BusinessLayer.Repositories.BookingRepository;
import App.DataLayer.Models.BookingModel;
import App.DataLayer.Models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BookingModel save(BookingModel bookingModel){
        return bookingRepository.save(bookingModel);
    }

    public void deleteById(int id){
        bookingRepository.deleteById(id);
    }
}
