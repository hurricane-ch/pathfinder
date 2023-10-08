package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = modelMapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findAllByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);
        route.setAuthor(userService.getLoggedUser());

        routeRepository.save(route);
    }

}
