package App.BusinessLayer.Repositories;

import App.DataLayer.Models.TouristModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends CrudRepository<TouristModel, Integer> {}
