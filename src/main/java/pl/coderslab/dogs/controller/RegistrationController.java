package pl.coderslab.dogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dogs.entity.User;
import pl.coderslab.dogs.repository.UserRepository;
import pl.coderslab.dogs.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }


    @PostMapping("/addUser")
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

}
