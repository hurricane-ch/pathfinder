package bg.softuni.pathfinder.model.dto.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserLoginBindingModel {
    private String username;
    private String password;
}
