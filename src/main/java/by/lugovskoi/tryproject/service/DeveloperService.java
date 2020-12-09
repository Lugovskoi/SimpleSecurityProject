package by.lugovskoi.tryproject.service;

import by.lugovskoi.tryproject.model.Developer;

import java.util.List;
import java.util.Set;

public interface DeveloperService {
    public void save(Developer developer);

    public Developer findById(Long id);

    public Set<Developer> findAll();

    public void update(Long id, Developer developer);

    public void delete(Long id);
}
