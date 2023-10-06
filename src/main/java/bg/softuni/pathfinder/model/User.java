package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column
    private Integer age;
    @Column(unique = true)
    private String email;
    @ManyToMany
    @JoinTable(
            name = "users_roles", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key to User table
            inverseJoinColumns = @JoinColumn(name = "roles_id") // Foreign key to Role table
    )
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private Level level;

}
