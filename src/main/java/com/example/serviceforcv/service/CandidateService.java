package com.example.serviceforcv.service;

import com.example.serviceforcv.domain.Candidate;
import com.example.serviceforcv.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getAll(PageRequest pageRequest) {
        Page<Candidate> candidatePage = candidateRepository.findAll(pageRequest);
        return candidatePage.getContent();
    }

    public Candidate addCandidate(String firstName, String secondName, String middleName, String description, byte[] photo, byte[] cv)  {

        Candidate candidate = new Candidate();
        candidate.setFirstname(firstName);
        candidate.setSecondName(secondName);
        candidate.setMiddleName(middleName);
        candidate.setDescription(description);
        candidate.setPhoto(photo);
        candidate.setCvFile(cv);
        log.info(String.format("candidate created id: " + candidate.getId()));
        return candidateRepository.save(candidate);
    }
    public Boolean updateCandidate(Candidate candidate) {
        try {
            candidateRepository.saveAndFlush(candidate);
            log.info(String.format("candidate update id: " + candidate.getId()));
        } catch (Exception e) {
            log.warn(String.format("error", candidate.getId(), e));
            return false;
        }
        return true;
    }
}
