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
@Table(name = "messages")
public class Message extends BaseEntity {

    @Column
    private LocalDate dateTime;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private User recipient;
}
