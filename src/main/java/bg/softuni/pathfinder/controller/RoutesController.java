package bg.softuni.pathfinder.controller;


import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteViewModel;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/routes")
@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class RoutesController {

    private final RouteService routeService;

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult";
    private static final String DOT = ".";


    @GetMapping
    public ModelAndView getAll() {
        List<RouteViewModel> routes = routeService.getAll();

        ModelAndView modelAndView = new ModelAndView("routes");
        modelAndView.addObject("routes", routes);

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable("id") Long id) {
        RouteDetailsViewModel route = routeService.getDetails(id);

        ModelAndView modelAndView = new ModelAndView("route-details");
        modelAndView.addObject("route", route);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        if (!model.containsAttribute("addRouteBindingModel")) {
            model.addAttribute("addRouteBindingModel", new AddRouteBindingModel());
        }

        return new ModelAndView("add-route");
    }

    @PostMapping("/add")
    public ModelAndView add(
            @Valid AddRouteBindingModel addRouteBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            final String attributeName = "addRouteBindingModel";
            redirectAttributes
                    .addFlashAttribute(attributeName, addRouteBindingModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + DOT + attributeName, bindingResult);
            modelAndView.setViewName("redirect:add");
        } else {
            routeService.add(addRouteBindingModel);
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
}