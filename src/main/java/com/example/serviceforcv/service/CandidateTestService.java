package com.example.serviceforcv.service;

import com.example.serviceforcv.domain.CandidatesTest;
import com.example.serviceforcv.repository.CandidateTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CandidateTestService {
    private final CandidateTestRepository candidateTestRepository;

    public CandidateTestService(CandidateTestRepository candidateTestRepository) {
        this.candidateTestRepository = candidateTestRepository;
    }

    public List<CandidatesTest> getAll(PageRequest pageRequest) {
        Page<CandidatesTest> candidateTestsPage = candidateTestRepository.findAll(pageRequest);
        return candidateTestsPage.getContent();
    }
    public Boolean createCandidatesTest(CandidatesTest candidatesTest) {
        try {
            candidateTestRepository.save(candidatesTest);
            log.info(String.format("candidatesTest created " + candidatesTest.getCandidate()));
        } catch (Exception e) {
            log.warn(String.format("error", candidatesTest.getCandidate()));
            return false;
        }
        return true;
    }
    public Boolean updateCandidatesTest(CandidatesTest candidatesTest) {
        try {
            candidateTestRepository.saveAndFlush(candidatesTest);
            log.info(String.format("test update id: " + candidatesTest.getId()));
        } catch (Exception e) {
            log.warn(String.format("error", candidatesTest.getId(), e));
            return false;
        }
        return true;
    }
}
