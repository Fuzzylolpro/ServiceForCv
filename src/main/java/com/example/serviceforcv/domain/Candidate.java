package com.example.serviceforcv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity(name = "candidate")
@Component
public class Candidate {
    @Id
    @SequenceGenerator(name = "seq_candidate", sequenceName = "candidate_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "seq_candidate", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstname;
    private String secondName;
    private String middleName;
    private String description;
    private byte[] photo;
    private byte[] cvFile;
    @ManyToMany
    @JoinTable(
            name = "candidate_direction",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "direction_id")
    )
    private List<Direction> directionList;
}
