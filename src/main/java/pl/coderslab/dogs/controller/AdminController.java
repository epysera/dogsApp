package pl.coderslab.dogs.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogs.entity.*;
import pl.coderslab.dogs.repository.*;
import pl.coderslab.dogs.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

    private final DogRepository dogRepository;
    private final ShelterRepository shelterRepository;
    private final CityRepository cityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public AdminController(DogRepository dogRepository, ShelterRepository shelterRepository, CityRepository cityRepository, RoleRepository roleRepository, UserRepository userRepository, UserService userService) {
        this.dogRepository = dogRepository;
        this.shelterRepository = shelterRepository;
        this.cityRepository = cityRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @GetMapping("/allDogs")
    public String showPosts(Model model) {
        List<Dog> dogs = dogRepository.findAll();
        model.addAttribute("dogs", dogs);
        return "admin/dogsList";
    }

    @GetMapping("/addDog")
    public String addDogForm(Model model) {
        model.addAttribute("dog",new Dog());
        return "admin/AddDogForm";
    }

    @PostMapping("/addDog")
    public String saveDog(@Valid Dog dog, BindingResult result){
        if (result.hasErrors()) {
            return "/admin/AddDogForm";
        }

        dogRepository.save(dog);
        return "redirect:/admin/allDogs";
    }

    @GetMapping("/editDog/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("dog", dogRepository.getById(id));
        return "admin/updateDog";
    }

    @PostMapping(value = "/editDog")
    public String editDog(@ModelAttribute("dog") @Valid Dog dog, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/updateDog";
        }
        dogRepository.save(dog);
        return "redirect:/admin/allDogs";
    }

    @GetMapping("/deleteDog/{id}")
    public String deleteDog(@PathVariable long id) {
        dogRepository.deleteById(id);
        return "redirect:/admin/allDogs";
    }

    @GetMapping("/show/{id}")
    public String showDog(Model model, @PathVariable long id) {
        model.addAttribute("dog", dogRepository.getById(id));
        return "admin/showDog";
    }

    @GetMapping("/addShelter")
    public String addShelterForm(Model model) {
        model.addAttribute("shelter",new Shelter());
        return "admin/addShelterForm";
    }

    @PostMapping("/addShelter")
    public String saveShelter(@Valid Shelter shelter, BindingResult result){
        if (result.hasErrors()) {
            return "admin/addShelterForm";
        }

        shelterRepository.save(shelter);
        return "redirect:/admin/allShelters";
    }

    @GetMapping("/allShelters")
    public String showAllShelters(Model model) {
        List<Shelter> shelters = shelterRepository.findAll();
        model.addAttribute("shelters", shelters);
        return "admin/sheltersList";
    }

    @GetMapping("/deleteShelter/{id}")
    public String deleteShelter(@PathVariable long id) {
        shelterRepository.deleteById(id);
        return "redirect:/admin/allShelters";
    }

    @GetMapping("/editShelter/{id}")
    public String showUpdateForm (@PathVariable long id, Model model) {
        model.addAttribute("shelter", shelterRepository.getById(id));
        return "admin/updateShelter";
    }

    @PostMapping(value = "/editShelter")
    public String editShelter (@ModelAttribute("shelter") @Valid Shelter shelter, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/updateShelter";
        }
        shelterRepository.save(shelter);
        return "redirect:/admin/allShelters";
    }

    @GetMapping("/addCity")
    public String addCityForm(Model model) {
        model.addAttribute("city",new City());
        return "admin/addCityForm";
    }

    @PostMapping("/addCity")
    public String saveCity(@Valid City city, BindingResult result){
        if (result.hasErrors()) {
            return "admin/addCityForm";
        }

        cityRepository.save(city);
        return "redirect:/admin/allCities";
    }

    @GetMapping("/allCities")
    public String showAllCities(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "admin/citiesList";
    }

    @GetMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable long id) {
        cityRepository.deleteById(id);
        return "redirect:/admin/allCities";
    }
    @GetMapping("/editCity/{id}")
    public String showEditFormCity(@PathVariable long id, Model model) {
        model.addAttribute("city", cityRepository.getById(id));
        return "admin/updateCity";
    }

    @PostMapping(value = "/editCity")
    public String editCity(@ModelAttribute("city") @Valid City city, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/updateCity";
        }
        cityRepository.save(city);
        return "redirect:/admin/allCities";
    }
    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/usersList";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/allUsers";
    }
    @GetMapping("/editUser/{id}")
    public String showEditFormUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.getById(id));
        return "admin/updateUser";
    }

    @PostMapping(value = "/editUser")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/updateUser";
        }
        userRepository.save(user);
        return "redirect:/admin/allUsers";
    }







    @ModelAttribute("shelters")
    public List<Shelter> shelters(){
        return shelterRepository.findAll();
    }

    @ModelAttribute("cities")
    public List<City> cities(){
        return cityRepository.findAll();
    }

    @ModelAttribute("sizes")
    public List<String> sizes() {
        return Arrays.asList("small", "medium", "large");
    }






    @GetMapping("/home")
    public String home() {
        return "index";
        }
    @GetMapping("/about")
    @ResponseBody
    public String respBody() {
        return "Surowy tekst";
    }
}

