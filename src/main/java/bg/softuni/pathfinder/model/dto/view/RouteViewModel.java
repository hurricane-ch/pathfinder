package bg.softuni.pathfinder.model.dto.view;

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
public class RouteViewModel {

    private Long id;
    private String imageUrl;
    private String name;
    private String description;
}
