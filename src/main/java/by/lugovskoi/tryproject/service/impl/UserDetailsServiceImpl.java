package by.lugovskoi.tryproject.service.impl;

import by.lugovskoi.tryproject.model.User;
import by.lugovskoi.tryproject.security.SecurityUser;
import by.lugovskoi.tryproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        System.out.println(user.toString());
        UserDetails userDetails = SecurityUser.fromUser(user);
        System.out.println(userDetails.toString());
        return userDetails;
    }
}
