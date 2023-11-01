package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.CategoryNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "name",nullable = false)
    private CategoryNames name;
    @Column(name = "description",columnDefinition = "TEXT")
//    @Lob
    private String description;

}