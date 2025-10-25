// src/main/java/com/joinup/ui/MockTesterController.java
package com.joinup.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MockTesterController {
    @GetMapping("/ui/api-tester")
    public String tester(Model model){
        model.addAttribute("active","tester");
        model.addAttribute("hero","API Route Tester");
        return "api-tester";
    }
}
