package com.example.library.controller;

import com.example.library.model.MyUser;
import com.example.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    @PostMapping("/newUser")
    public @ResponseBody String addUser(@RequestBody MyUser user) {
        userService.addUser(user);
        return "Пользователь сохранен";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String displayAdminPage() {
        return "books/admin";
    }
}
