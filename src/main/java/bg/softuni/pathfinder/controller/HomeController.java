package bg.softuni.pathfinder.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
