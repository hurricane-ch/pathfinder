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

    @Column(columnDefinition = "TEXT", name = "gpx_coordinates")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private User author;
    @ManyToMany
    private Set<Category> categories;

    public void addCategories(Set<Category> categories) {
        this.categories.addAll(categories);
    }
}