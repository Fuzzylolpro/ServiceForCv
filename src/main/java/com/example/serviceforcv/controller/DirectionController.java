package com.example.serviceforcv.controller;

import com.example.serviceforcv.domain.Direction;
import com.example.serviceforcv.service.DirectionService;
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
@RequestMapping("/direction")
public class DirectionController {
    private final DirectionService directionService;

    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    @GetMapping
    public ResponseEntity<List<Direction>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort));
        List<Direction> directionList = directionService.getAll(pageRequest);
        return new ResponseEntity<>(directionList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Direction direction) {
        return new ResponseEntity<>(directionService.createDirection(direction) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Direction direction) {
        return new ResponseEntity<>(directionService.updateDirection(direction) ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

}
