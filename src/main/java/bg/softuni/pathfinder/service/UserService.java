package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.Session.LoggedUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserService {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername()).orElse(null);
    }

}
