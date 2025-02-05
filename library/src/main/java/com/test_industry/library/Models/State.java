package com.test_industry.library.Models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
