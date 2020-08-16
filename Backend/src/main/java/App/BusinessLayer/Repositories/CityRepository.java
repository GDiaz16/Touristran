package App.BusinessLayer.Repositories;

import App.DataLayer.Models.CityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Interfaz usada por hibernate para hacer tareas de CRUD
@Repository
public interface CityRepository extends CrudRepository<CityModel, Integer>{}
