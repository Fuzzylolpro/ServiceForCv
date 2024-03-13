package com.example.serviceforcv.controller;

import com.example.serviceforcv.domain.Tests;
import com.example.serviceforcv.service.TestsService;
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
@RequestMapping("/tests")
public class TestsController {
    private final TestsService testsService;

    public TestsController(TestsService testsService) {
        this.testsService = testsService;
    }


    @GetMapping
    public ResponseEntity<List<Tests>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort));
        List<Tests> candidateList = testsService.getAll(pageRequest);
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Tests tests) {
        return new ResponseEntity<>(testsService.createTest(tests) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Tests tests) {
        return new ResponseEntity<>(testsService.updateTest(tests) ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }
}
