package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email", unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key to User table
            inverseJoinColumns = @JoinColumn(name = "roles_id") // Foreign key to Role table
    )
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private Level level;

}