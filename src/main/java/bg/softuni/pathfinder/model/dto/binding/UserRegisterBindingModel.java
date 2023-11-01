package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.validation.anotations.PasswordMatch;
import bg.softuni.pathfinder.validation.anotations.UniqueEmail;
import bg.softuni.pathfinder.validation.anotations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserRegisterBindingModel {

    @UniqueUsername
    @NotNull
    @Size(min = 2, message = "{user.username.length}")
    private String username;

    @NotNull
    @Size(min = 2, message = "{user.full-name.length}")
    private String fullName;

    @NotNull
    @UniqueEmail
    @Email(regexp = ".+[@].+", message = "{user.email}")
    private String email;

    @Positive(message = "{user.age}")
    private int age;

    @Size(min = 2, message = "{user.password.length}")
    private String password;

    @Size(min = 2, message = "{user.confirm-password.length}")
    private String confirmPassword;
}