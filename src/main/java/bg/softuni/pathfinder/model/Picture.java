package bg.softuni.pathfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "url",nullable = false)
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

}