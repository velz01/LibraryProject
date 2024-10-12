package com.example.library.controller;


import com.example.library.model.MyUser;
import com.example.library.service.RegistrationService;
import com.example.library.service.UserService;
import com.example.library.utils.MyUserValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    private final MyUserValidator validator;
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "auth/registration";

    }
    @PostMapping("/registration")
    public String performRegistration(@Valid MyUser user, BindingResult bindingResult) {
        validator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }
        userService.addUser(user);

        return "redirect:/login";
    }
}
