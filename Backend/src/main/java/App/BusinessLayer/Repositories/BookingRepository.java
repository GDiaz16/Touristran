package App.BusinessLayer.Repositories;

import App.DataLayer.Models.BookingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository  extends CrudRepository<BookingModel, Integer> {}
