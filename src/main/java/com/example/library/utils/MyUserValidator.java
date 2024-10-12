package com.example.library.utils;

import com.example.library.model.MyUser;
import com.example.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MyUserValidator implements Validator {
    private final UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return MyUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyUser user = (MyUser) target;
        Optional<MyUser> myUser = userService.getUserByUsername(user.getUsername());
        if (myUser.isPresent()) {
            errors.rejectValue("username", "", "Имя человека уже есть");
        }
        else {
            return;
        }
    }
}
