package pl.coderslab.dogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.dogs.entity.Dog;
import pl.coderslab.dogs.entity.Shelter;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    @Override
    List<Dog> findAll();

    List<Dog> findAllByBreed (String breed);
    List<Dog> findAllByShelter(Shelter shelter);
    List <Dog> findAllBySize (String size);
    List <Dog> findAllByCharacter(String character);
    List <Dog> findAllByName (String name);


    @Query("SELECT d FROM Dog d WHERE CONCAT(d.name, ' ', d.breed, ' ', d.size, ' ', d.shelter.name) LIKE %?1%")
    public List<Dog> search(String keyword);

}
