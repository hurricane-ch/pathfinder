package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRouteBindingModel {

    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private Set<CategoryNames> categories;

}
