package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.enums.CategoryNames;
import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.validation.anotations.FileAnnotation;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

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
    @FileAnnotation(contentTypes = "text/xml")
    private MultipartFile gpxCoordinates;
    private Level level;
    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.*", message = "Invalid youtube url provided")
    private String videoUrl;
    private User author;
    private Set<CategoryNames> categories;
}
