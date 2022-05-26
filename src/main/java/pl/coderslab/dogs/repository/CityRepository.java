package pl.coderslab.dogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogs.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    List<City> findAll();


}
