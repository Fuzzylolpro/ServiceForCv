package com.example.serviceforcv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Entity(name = "candidate_tests")
@Component
public class CandidatesTest {
    @Id
    @SequenceGenerator(name = "seq_candidate_tests", sequenceName = "candidate_tests_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "seq_candidate_tests", strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Candidate candidate;
    @ManyToOne
    private Tests tests;
    @CreationTimestamp
    private Timestamp time;
    private Long result;
}
