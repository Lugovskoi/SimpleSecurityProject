package by.lugovskoi.tryproject.service;

import by.lugovskoi.tryproject.model.User;

import java.util.Set;

public interface UserService {

    void save(User user);

    User findById(Long id);

    Set<User> findAll();

    void update(Long id, User user);

    void delete(Long id);

    User findByEmail(String email);

    void toAdmin(Long id);

    void toUser(Long id);
}
