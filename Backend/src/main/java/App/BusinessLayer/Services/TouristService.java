package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.TouristRepository;
import App.DataLayer.Models.ToDo;
import App.DataLayer.Models.TouristModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TouristService {
    @Autowired
    private TouristRepository touristRepository;

    public List<TouristModel> findAll(){
        return (List<TouristModel>) touristRepository.findAll();
    }

    public TouristModel findById(int id){
        return touristRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public TouristModel save(TouristModel touristModel){
        return touristRepository.save(touristModel);
    }

    public void deleteById(int id){
        touristRepository.deleteById(id);
    }
}
