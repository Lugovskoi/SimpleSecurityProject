package by.lugovskoi.tryproject.service.impl;

import by.lugovskoi.tryproject.model.Developer;
import by.lugovskoi.tryproject.repository.DeveloperRepository;
import by.lugovskoi.tryproject.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public void save(Developer developer) {
        developerRepository.save(developer);
    }

    @Override
    public Developer findById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Developer> findAll() {
        return new HashSet<>(developerRepository.findAll());
    }

    @Override
    public void update(Long id, Developer developer) {
        Developer developerToUpdate = findById(id);
        developerToUpdate.setFirstName(developer.getFirstName());
        developerToUpdate.setLastName(developer.getLastName());
        save(developerToUpdate);
    }

    @Override
    public void delete(Long id) {
        developerRepository.deleteById(id);
    }
}
