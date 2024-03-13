package com.example.serviceforcv.service;

import com.example.serviceforcv.domain.Tests;
import com.example.serviceforcv.repository.TestsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestsService {
    private final TestsRepository testsRepository;

    public TestsService(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }
    public List<Tests> getAll(PageRequest pageRequest) {
        Page<Tests> testsPage = testsRepository.findAll(pageRequest);
        return testsPage.getContent();
    }
    public Boolean createTest(Tests tests) {
        try {
            testsRepository.save(tests);
            log.info(String.format("test created " + tests.getName()));
        } catch (Exception e) {
            log.warn(String.format("error", tests.getName()));
            return false;
        }
        return true;
    }
    public Boolean updateTest(Tests tests) {
        try {
            testsRepository.saveAndFlush(tests);
            log.info(String.format("test update id: " + tests.getId()));
        } catch (Exception e) {
            log.warn(String.format("error", tests.getId(), e));
            return false;
        }
        return true;
    }
}
