package pl.coderslab.dogs.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogs.entity.City;
import pl.coderslab.dogs.entity.Dog;
import pl.coderslab.dogs.entity.Shelter;
import pl.coderslab.dogs.repository.CityRepository;
import pl.coderslab.dogs.repository.DogRepository;
import pl.coderslab.dogs.repository.ShelterRepository;

import java.util.Properties;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class ImplDataController {

    private final DogRepository dogRepository;
    private final ShelterRepository shelterRepository;
    private final CityRepository cityRepository;

    public ImplDataController(DogRepository dogRepository, ShelterRepository shelterRepository, CityRepository cityRepository) {
        this.dogRepository = dogRepository;
        this.shelterRepository = shelterRepository;
        this.cityRepository = cityRepository;
    }


    @GetMapping("/data")
    public String loadData() {
        City lodz = new City(1L, "Łódź");
        cityRepository.save(lodz);
        City warszawa = new City(2L,"Warszawa");
        cityRepository.save(warszawa);
        City wroclaw = new City(3L,"Wrocław");
        cityRepository.save(wroclaw);

        Shelter banda = new Shelter(1L,"Banda Łódzka","5470048627", "470755007",lodz);
        shelterRepository.save(banda);
        Shelter wwa = new Shelter(2L, "WWA Schron", "8130336808", "690216613",warszawa);
        shelterRepository.save(wwa);
        Shelter kosc = new Shelter(3L, "Psia Kość", "8641783394", "292807319",wroclaw);
        shelterRepository.save(kosc);

        Dog luna = new Dog(1L, "Luna", "buldog francuski", "small", "family", banda);
        dogRepository.save(luna);
        Dog gonzo = new Dog(2L, "Gonzo", "mops", "medium", "family", wwa);
        dogRepository.save(gonzo);
        Dog reksio = new Dog(3L,"Reksio", "kundel", "large", "agressive", kosc);
        dogRepository.save(reksio);
        Dog maxik = new Dog(4L,"Maxik", "doberman", "large", "family",banda);
        dogRepository.save(maxik);
        Dog lolek = new Dog(5L,"Lolek", "kundel", "small", "agressive",wwa);
        dogRepository.save(lolek);
        Dog baton = new Dog(6L,"Baton", "mops","medium","family",kosc);
        dogRepository.save(baton);

        return "admin/dogsList";

    }
}
