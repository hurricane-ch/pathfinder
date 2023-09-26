package bg.softuni.pathfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column
    private Boolean approved;
    @Column
    private LocalDate created;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

}
