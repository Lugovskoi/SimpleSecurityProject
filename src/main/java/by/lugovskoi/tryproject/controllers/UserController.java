package by.lugovskoi.tryproject.controllers;

import by.lugovskoi.tryproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('developers:write')")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        UserDetails user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", user.getUsername());
        return "users/index";
    }

    @GetMapping("/{id}/toAdmin")
    @PreAuthorize("hasAuthority('developers:write')")
    public String toAdmin(@PathVariable Long id) {
        userService.toAdmin(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/toUser")
    @PreAuthorize("hasAuthority('developers:write')")
    public String toUser(@PathVariable Long id) {
        userService.toUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    @PreAuthorize("hasAuthority('developers:write')")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
