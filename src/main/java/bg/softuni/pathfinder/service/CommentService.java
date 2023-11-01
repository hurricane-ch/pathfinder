package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.exceptions.UserNotFoundException;
import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.binding.CreateCommentBindingModel;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.Session.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper mapper;


    public void create(CreateCommentBindingModel createCommentBindingModel) {
        Optional<Route> optionalRoute = routeRepository.findById(createCommentBindingModel.getRouteId());

        if (optionalRoute.isEmpty()) {
            throw new RouteNotFoundException("Route not found");
        }

        Optional<User> optionalUser = userRepository.findByUsername(loggedUser.getUsername());

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with username: " + loggedUser.getUsername() + " was not found");
        }

        Route route = optionalRoute.get();
        User user = optionalUser.get();

        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
        comment.setRoute(route);
        comment.setCreated(LocalDateTime.now());
        comment.setAuthor(user);

        commentRepository.save(comment);
    }
}
