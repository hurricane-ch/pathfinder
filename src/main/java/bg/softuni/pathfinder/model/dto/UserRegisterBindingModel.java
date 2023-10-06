package bg.softuni.pathfinder.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterBindingModel {
    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;
}