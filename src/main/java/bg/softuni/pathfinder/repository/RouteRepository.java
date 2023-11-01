package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
//    void add(AddRouteBindingModel addRouteBindingModel);

    List<Route> findAllByCategories_Name(CategoryNames categoryNames);
}
