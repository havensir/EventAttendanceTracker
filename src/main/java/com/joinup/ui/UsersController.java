package com.joinup.ui;

import com.joinup.model.Role;
import com.joinup.model.User;
import com.joinup.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final IUserService service;

    public UsersController(IUserService service) { this.service = service; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", service.getAll());
        model.addAttribute("userForm", new User());
        model.addAttribute("roles", Role.values());
        model.addAttribute("active", "users");
        model.addAttribute("hero", "Users");
        return "users";
    }

    @PostMapping
    public String add(@ModelAttribute("userForm") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", service.getAll());
            model.addAttribute("roles", Role.values());
            model.addAttribute("active", "users");
            model.addAttribute("hero", "Users");
            return "users";
        }
        if (user.getRole() == null) user.setRole(Role.USER);
        service.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        User u = service.getById(id);
        model.addAttribute("user", u);
        model.addAttribute("roles", Role.values());
        model.addAttribute("active", "users");
        model.addAttribute("hero", "Edit " + u.getDisplayName());
        return "users-edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam(required = false) String company,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam Role role) {
        User incoming = new User();
        incoming.setFirstName(firstName);
        incoming.setLastName(lastName);
        incoming.setCompany(company);
        incoming.setEmail(email);
        incoming.setPhone(phone);
        incoming.setRole(role);
        service.update(id, incoming);

        // Stay on edit page and show dialog via ?saved=1
        return "redirect:/users/" + id + "/edit?saved=1";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
