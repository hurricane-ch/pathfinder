package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String fullName;
    @Column
    private String email;
    @ManyToMany
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private Level level;

}
