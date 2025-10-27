package com.joinup.ui;

import com.joinup.dao.IUserDao;
import com.joinup.model.Role;
import com.joinup.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final IUserDao userDao;

    public AuthController(IUserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "loggedOut", required = false) String loggedOut,
                            Model model) {
        model.addAttribute("hero", "Welcome Back");
        model.addAttribute("loggedOut", loggedOut != null);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email,
                          @RequestParam(required = false) String org,
                          @RequestParam(required = false, defaultValue = "USER") Role role,
                          HttpServletRequest req) {

        // Normalize email for stable lookups
        String normEmail = email == null ? "" : email.trim().toLowerCase();

        HttpSession session = req.getSession(true);
        session.setAttribute("userFirst", firstName);
        session.setAttribute("userLast",  lastName);
        session.setAttribute("userName",  (firstName + " " + lastName).trim());
        session.setAttribute("userEmail", normEmail);
        session.setAttribute("userOrg",   (org == null || org.isBlank()) ? "JoinUp" : org);
        session.setAttribute("userRole",  role == null ? Role.USER : role);

        // Find by normalized email or create a record
        User user = userDao.findAll().stream()
                .filter(u -> u.getEmail() != null && u.getEmail().trim().toLowerCase().equals(normEmail))
                .findFirst()
                .orElseGet(() -> userDao.save(new User(
                        null, firstName, lastName, org, normEmail, "", role == null ? Role.USER : role
                )));

        // Align fields if changed at login
        boolean changed = false;
        if (!firstName.equals(user.getFirstName())) { user.setFirstName(firstName); changed = true; }
        if (!lastName.equals(user.getLastName()))   { user.setLastName(lastName);   changed = true; }
        if (role != null && role != user.getRole()) { user.setRole(role);           changed = true; }
        if (org != null && (user.getCompany() == null || !org.equals(user.getCompany()))) {
            user.setCompany(org); changed = true;
        }
        if (changed) userDao.save(user);

        // Store the canonical user id for routing
        session.setAttribute("userId", user.getId());
        return "redirect:/";
    }

    /** Always route Profile to the current user's edit page. */
    @GetMapping("/profile")
    public String profileRedirect(HttpServletRequest req) {
        HttpSession s = req.getSession(false);
        if (s == null) return "redirect:/login";

        // If we already know the user id, use it
        Long id = (Long) s.getAttribute("userId");
        if (id != null) return "redirect:/users/" + id + "/edit";

        // Otherwise, resolve by normalized email (and create if needed)
        String email = (String) s.getAttribute("userEmail");
        String first = (String) s.getAttribute("userFirst");
        String last  = (String) s.getAttribute("userLast");
        String org   = (String) s.getAttribute("userOrg");
        Role role    = (Role)   s.getAttribute("userRole");

        String normEmail = email == null ? "" : email.trim().toLowerCase();

        User found = userDao.findAll().stream()
                .filter(u -> u.getEmail() != null && u.getEmail().trim().toLowerCase().equals(normEmail))
                .findFirst()
                .orElseGet(() -> userDao.save(new User(
                        null, first, last, org, normEmail, "", role == null ? Role.USER : role
                )));

        s.setAttribute("userId", found.getId());
        return "redirect:/users/" + found.getId() + "/edit";
    }

    @PostMapping("/logout")
    public String doLogout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) session.invalidate();
        return "redirect:/login?loggedOut=1";
    }
}
