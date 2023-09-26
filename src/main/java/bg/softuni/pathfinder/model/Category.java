package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.enums.CategoryName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
    @Column(nullable = false)
    private CategoryName categoryName;
    @Column(columnDefinition = "TEXT")
    private String description;


}
