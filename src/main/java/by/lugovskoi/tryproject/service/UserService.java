package by.lugovskoi.tryproject.service;

import by.lugovskoi.tryproject.model.User;

import java.util.Set;

public interface UserService {

    public void save(User user);

    public User findById(Long id);

    public Set<User> findAll();

    public void update(Long id, User user);

    public void delete(Long id);

    public User findByEmail(String email);
}
