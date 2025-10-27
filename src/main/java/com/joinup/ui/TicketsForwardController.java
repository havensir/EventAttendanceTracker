// src/main/java/com/joinup/ui/TicketsForwardController.java
package com.joinup.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketsForwardController {
    @GetMapping("/ui/tickets")
    public String forward() {
        return "forward:/ui/events/my";
    }
}
