package com.example.serviceforcv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity(name = "direction")
public class Direction {
    @Id
    @SequenceGenerator(name = "seq_direction", sequenceName = "direction_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "seq_direction", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
}
