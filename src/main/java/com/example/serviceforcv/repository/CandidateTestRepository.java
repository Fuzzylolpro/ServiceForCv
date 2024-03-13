package com.example.serviceforcv.repository;

import com.example.serviceforcv.domain.CandidatesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateTestRepository extends JpaRepository<CandidatesTest,Long> {
}
