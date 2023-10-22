package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.enums.UserRole;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleByName (String name) {

        return this.roleRepository.findByName(UserRole.valueOf(name));
    }
}
