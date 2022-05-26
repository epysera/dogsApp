package pl.coderslab.dogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dogs.entity.Dog;
import pl.coderslab.dogs.repository.DogRepository;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> listAll(String keyword) {
        if(keyword !=null) {
            return dogRepository.search(keyword);
        }
        return  dogRepository.findAll();
    }
}
