package com.example.serviceforcv.repository;

import com.example.serviceforcv.domain.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<Tests,Long> {
}
