package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.Session.LoggedUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;


    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        User user = userRepository.findByUsername(userLoginBindingModel.getUsername()).orElse(null);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new IllegalArgumentException("Wrong password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(true);

        return passwordMatch;
    }

    public void logout() {
       loggedUser.reset();
    }

}
