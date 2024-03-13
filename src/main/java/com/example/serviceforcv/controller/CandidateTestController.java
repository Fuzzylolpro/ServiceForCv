package com.example.serviceforcv.controller;

import com.example.serviceforcv.domain.CandidatesTest;
import com.example.serviceforcv.service.CandidateTestService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidateTest")
public class CandidateTestController {
    private final CandidateTestService candidateTestService;

    public CandidateTestController(CandidateTestService candidateTestService) {
        this.candidateTestService = candidateTestService;
    }
    @GetMapping
    public ResponseEntity<List<CandidatesTest>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort));
        List<CandidatesTest> candidateList = candidateTestService.getAll(pageRequest);
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody CandidatesTest candidatesTest) {
        return new ResponseEntity<>(candidateTestService.createCandidatesTest(candidatesTest) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody CandidatesTest candidatesTest) {
        return new ResponseEntity<>(candidateTestService.updateCandidatesTest(candidatesTest) ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }
}
