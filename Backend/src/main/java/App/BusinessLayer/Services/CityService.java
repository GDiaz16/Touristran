package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.CityRepository;
import App.DataLayer.Models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<CityModel> findAll(){
        return (List<CityModel>) cityRepository.findAll();
    }

    public CityModel findById(int id){
        return cityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public CityModel save(CityModel cityModel){
        return cityRepository.save(cityModel);
    }

    public void deleteById(int id){
        cityRepository.deleteById(id);
    }
}
