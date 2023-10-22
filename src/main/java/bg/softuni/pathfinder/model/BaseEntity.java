package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "Start", sequenceName = "StartName", allocationSize = 1, initialValue = 10)

public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Start")
    private Long id;

}
