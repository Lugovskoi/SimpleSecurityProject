package by.lugovskoi.tryproject.controllers;

import by.lugovskoi.tryproject.model.Developer;
import by.lugovskoi.tryproject.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('developers:read')")
    public String index(Model model) {
        model.addAttribute("developers", developerService.findAll());
        return "developers/index";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAuthority('developers:read')")
    public String newDeveloper(@ModelAttribute("developer") Developer developer) {
        return "developers/new";
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('developers:read')")
    public String create(@ModelAttribute("developer") Developer developer) {
        developerService.save(developer);
        return "redirect:/developers";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("hasAuthority('developers:read')")
    public String editDeveloper(@PathVariable("id") Long id, Model model) {
        model.addAttribute("developer", developerService.findById(id));
        return "developers/update";
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public String update(@ModelAttribute("developer") Developer developer, @PathVariable("id") Long id) {
        developerService.update(id, developer);
        return "redirect:/developers";
    }

    @GetMapping("/{id}/delete")
    @PreAuthorize("hasAuthority('developers:read')")
    public String delete(@PathVariable("id") Long id) {
        developerService.delete(id);
        return "redirect:/developers";
    }
}
