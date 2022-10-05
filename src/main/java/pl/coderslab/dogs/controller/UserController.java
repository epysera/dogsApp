package pl.coderslab.dogs.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dogs.DogSearchMode;
import pl.coderslab.dogs.entity.*;
import pl.coderslab.dogs.repository.DogRepository;
import pl.coderslab.dogs.repository.RoleRepository;
import pl.coderslab.dogs.repository.ShelterRepository;
import pl.coderslab.dogs.repository.UserRepository;
import pl.coderslab.dogs.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final DogRepository dogRepository;
    private final ShelterRepository shelterRepository;

    public UserController(UserService userService, RoleRepository roleRepository, UserRepository userRepository, DogRepository dogRepository, ShelterRepository shelterRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.dogRepository = dogRepository;
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("user2");
        user.setPassword("user222");
        userService.saveUser(user);
        return "Utowrzyłeś usera";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        User user = userRepository.getById(entityUser.getId());
        model.addAttribute("user", user);
        return "user/dashUser";

    }

    @GetMapping("/dashboard/dogs")
    public String dashboardDogs(Model model, @AuthenticationPrincipal CurrentUser customUser,
                                       @RequestParam(value = "field", required = false) DogSearchMode field,
                                       @RequestParam(value = "query", required = false) String query) {
        if (field != null && StringUtils.isNotEmpty(query)) {
            switch (field) {
                case ROZMIAR:
                    model.addAttribute("dogs", dogRepository.findAllBySize(query));
                    break;
                case RASA:
                    model.addAttribute("dogs", dogRepository.findAllByBreed(query));
                    break;
                case CHARAKTER:
                    model.addAttribute("dogs", dogRepository.findAllByCharacter(query));
                    break;
                case IMIĘ:
                    model.addAttribute("dogs", dogRepository.findAllByName(query));
                    break;
            }
            model.addAttribute("selectedField", field);
        } else {

            User entityUser = customUser.getUser();
            User user = userRepository.getById(entityUser.getId());
            model.addAttribute("user", user);
            List<Dog> dogs = dogRepository.findAll();
            model.addAttribute("dogs", dogs);
        }
            model.addAttribute("query", query);
            model.addAttribute("searchMode", DogSearchMode.values());
            return "user/dashUserSearch";

        }
        @GetMapping("/findDog")
        public String findDog(@RequestParam Long id, Model model) {
        model.addAttribute("dog", dogRepository.getById(id));
        return "user/showDog";
        }


//    @GetMapping("/hello")
//    @ResponseBody
//    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        return "Hello " + entityUser.getUsername();
//    }

    @GetMapping("/userInfo")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
        Logger log = LoggerFactory.getLogger(LoginController.class);
        log.info("customUser class {} " , customUser.getClass());
        return "You are logged as " + customUser;
    }
}

