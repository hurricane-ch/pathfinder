package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(columnDefinition = "TEXT", nullable = false)
    private String gpsCoordinates;
    @Enumerated(EnumType.STRING)
    @Column
    private Level level;
    @Column(nullable = false)
    private String name;
    @Column
    private String videoUrl;
    @ManyToOne
    private User author;
    @ManyToMany
    private Set<Category> categories;

}
