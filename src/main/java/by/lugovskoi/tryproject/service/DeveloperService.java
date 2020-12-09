package by.lugovskoi.tryproject.service;

import by.lugovskoi.tryproject.model.Developer;

import java.util.List;
import java.util.Set;

public interface DeveloperService {
    void save(Developer developer);

    Developer findById(Long id);

    Set<Developer> findAll();

    void update(Long id, Developer developer);

    void delete(Long id);
}
