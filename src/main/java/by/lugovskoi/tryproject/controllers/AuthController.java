package by.lugovskoi.tryproject.controllers;

import by.lugovskoi.tryproject.model.Role;
import by.lugovskoi.tryproject.model.User;
import by.lugovskoi.tryproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "auth/login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "auth/success";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/auth/login";
    }
}
