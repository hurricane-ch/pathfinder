package bg.softuni.pathfinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterBindingModel {
    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;
}