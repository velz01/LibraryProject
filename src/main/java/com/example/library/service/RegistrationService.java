package com.example.library.service;

import com.example.library.model.MyUser;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {
    public final UserService userService;

    @Transactional
    public void register(MyUser user) {
        userService.addUser(user);
    }

}
