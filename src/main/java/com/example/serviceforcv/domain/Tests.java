package com.example.serviceforcv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity(name = "tests")
@Component
public class Tests {
    @Id
    @SequenceGenerator(name = "seq_tests", sequenceName = "tests_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "seq_tests", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "test_direction",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "direction_id")
    )
    private List<Direction> directionList;
}
