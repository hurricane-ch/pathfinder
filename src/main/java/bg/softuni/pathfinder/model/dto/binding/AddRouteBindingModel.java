package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.model.User;
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
    private User author;
    private Set<CategoryNames> categories;

}
