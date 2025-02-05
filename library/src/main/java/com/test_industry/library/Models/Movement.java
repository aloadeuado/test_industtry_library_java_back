package com.test_industry.library.Models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "movements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book", referencedColumnName = "id")
    private Book book;

    private String observation;
}