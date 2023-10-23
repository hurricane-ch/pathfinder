package bg.softuni.pathfinder.model.dto.view;

import bg.softuni.pathfinder.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDetailsViewModel {

    private Long id;
    private String name;
    private Level level;
    private String description;
    private String videoUrl;
    private String authorName;
}
