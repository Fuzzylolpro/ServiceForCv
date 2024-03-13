package com.example.serviceforcv.controller;

import com.example.serviceforcv.domain.Candidate;
import com.example.serviceforcv.service.CandidateService;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort));
        List<Candidate> candidateList = candidateService.getAll(pageRequest);
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Candidate> addCandidate(@RequestParam String firstName,
                                                  @RequestParam String secondName,
                                                  @RequestParam String middleName,
                                                  @RequestParam String description,
                                                  @RequestPart("photo") MultipartFile photo,
                                                  @RequestPart("cv") MultipartFile cv) {
        try {
            Candidate candidate = candidateService.addCandidate(firstName, secondName, middleName, description, photo.getBytes(), cv.getBytes());
            return ResponseEntity.ok(candidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Candidate candidate,@RequestPart("photo") MultipartFile photo,@RequestPart("cv") MultipartFile cv) {
        return new ResponseEntity<>(candidateService.updateCandidate(candidate) ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }
}
