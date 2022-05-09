package pl.coderslab.dogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

        @GetMapping("/home")
        public String home() {
            return "index";
        }
    @GetMapping("/home_reps")
    @ResponseBody
    public String respBody() {
        return "Surowy tekst";
    }
}

