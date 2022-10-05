package pl.coderslab.dogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogs.entity.Shelter;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Override
    List<Shelter> findAll();

    List<Shelter> findAllByName (String name);
}
