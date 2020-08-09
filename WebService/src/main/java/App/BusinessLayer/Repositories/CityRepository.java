package App.BusinessLayer.Repositories;

import App.DataLayer.Models.CityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityModel, Integer>{}
