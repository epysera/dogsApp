package pl.coderslab.dogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogs.entity.Dog;
import pl.coderslab.dogs.service.DogService;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private DogService dogService;

    @RequestMapping("/search")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Dog> listDogs = dogService.listAll(keyword);
        model.addAttribute("listDogs", listDogs);
        model.addAttribute("keyword", keyword);

        return "sercz";
    }
}
