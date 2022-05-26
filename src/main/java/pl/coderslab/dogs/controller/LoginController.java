package pl.coderslab.dogs.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dogs.entity.CurrentUser;
import pl.coderslab.dogs.entity.Role;
import pl.coderslab.dogs.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class LoginController {


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = {"/success"}, method = RequestMethod.GET)
    public String showDashboard(@AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        Set<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        Set<Integer> roleID = user.getRoles().stream().map(Role::getId).collect(Collectors.toSet());
        if (roleID.contains(1)) {
            //render admin page
            return "redirect:user/dashboard";
        } else if (roleID.contains(2)) {
            //render vendor page
            return "redirect:admin/allDogs";
        } else
            return "/403";
    }

}
