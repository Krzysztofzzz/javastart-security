package com.javastart.sec.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String home(@CurrentSecurityContext SecurityContext securityContext, Model model) {
        model.addAttribute("username", securityContext.getAuthentication().getName());
        return "index";
    }
}
