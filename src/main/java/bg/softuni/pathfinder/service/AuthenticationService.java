package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.exceptions.LoginCredentialsException;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.Session.LoggedUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        userRepository.save(user);
    }

    public void login(UserLoginBindingModel userLoginBindingModel) throws LoginCredentialsException {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: [" + username + "] is not present"));

        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(),
                user.getPassword());

        if (!passwordMatch){
            throw new LoginCredentialsException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername())
                .setLogged(true)
                .setRoles(user.getRoles());
    }

    public void logout() {
        loggedUser.reset();
    }
}