package com.javastart.sec.web;

import com.javastart.sec.user.UserService;
import com.javastart.sec.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String registrationForm(Model model){
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "registration-form";
    }

    @PostMapping("/register")
    String register(UserRegistrationDto userRegistrationDto){
        userService.register(userRegistrationDto);
        return "redirect:/comfirmation";
    }

    @GetMapping("/comfirmation")
    String registrationComfirmation(){
        return "registration-comfirmation";
    }
}
