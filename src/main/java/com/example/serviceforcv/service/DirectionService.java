package com.example.serviceforcv.service;

import com.example.serviceforcv.domain.Direction;
import com.example.serviceforcv.repository.DirectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DirectionService {
    private final DirectionRepository directionRepository;

    public DirectionService(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    public List<Direction> getAll(PageRequest pageRequest) {
        Page<Direction> directionPage = directionRepository.findAll(pageRequest);
        return directionPage.getContent();
    }
    public Boolean createDirection(Direction direction) {
        try {
            directionRepository.save(direction);
            log.info(String.format("direction created " + direction.getName()));
        } catch (Exception e) {
            log.warn(String.format("error", direction.getName()));
            return false;
        }
        return true;
    }
    public Boolean updateDirection(Direction direction) {
        try {
            directionRepository.saveAndFlush(direction);
            log.info(String.format("direction update id: " + direction.getId()));
        } catch (Exception e) {
            log.warn(String.format("error", direction.getId(), e));
            return false;
        }
        return true;
    }

}
