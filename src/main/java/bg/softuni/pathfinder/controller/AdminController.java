package bg.softuni.pathfinder.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView adminPanel(){
        return new ModelAndView("");
    }
}
