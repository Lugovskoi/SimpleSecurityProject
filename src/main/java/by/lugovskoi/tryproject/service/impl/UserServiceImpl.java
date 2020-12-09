package by.lugovskoi.tryproject.service.impl;

import by.lugovskoi.tryproject.model.Role;
import by.lugovskoi.tryproject.model.Status;
import by.lugovskoi.tryproject.model.User;
import by.lugovskoi.tryproject.repository.UserRepository;
import by.lugovskoi.tryproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        if(user.getRole() == null) {
            user.setRole(Role.USER);
        }
        if(user.getStatus() == null) {
            user.setStatus(Status.ACTIVE);
        }
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public void update(Long id, User user) {
        User userToUpdate = findById(id);
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setStatus(user.getStatus());
        userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
    }

    @Override
    public void toAdmin(Long id) {
       User user = findById(id);
       user.setRole(Role.ADMIN);
       userRepository.save(user);
    }

    @Override
    public void toUser(Long id) {
        User user = findById(id);
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
