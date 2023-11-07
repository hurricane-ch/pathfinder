package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
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
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;
    @OneToMany(mappedBy = "route")
    private List<Comment> comments;

    public void addCategories(Set<Category> categories) {
        this.categories.addAll(categories);
    }
}