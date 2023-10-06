package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.enums.Level;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class AddRouteBindingModel {

    private String name;
    private String description;
    private Level level;
    private String videoUrl;

//    private Set<CategoryNames> categories;


}
