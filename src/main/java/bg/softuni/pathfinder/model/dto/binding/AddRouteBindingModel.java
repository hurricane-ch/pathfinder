package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.model.User;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AddRouteBindingModel {

    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters")
    private String description;
    private Level level;
    private String videoUrl;
    private User author;
    private Set<CategoryNames> categories;


}
