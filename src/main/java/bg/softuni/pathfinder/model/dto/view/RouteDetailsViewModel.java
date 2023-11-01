package bg.softuni.pathfinder.model.dto.view;

import bg.softuni.pathfinder.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RouteDetailsViewModel {

    private Long id;
    private String name;
    private Level level;
    private String description;
    private String videoUrl;
    private String authorName;
    private List<CommentViewModel> comments;


    // TODO pass coordinates;
}

