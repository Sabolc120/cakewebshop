package com.example.cakeExamBackend.Controllers;

import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.UserRepo;
import com.example.cakeExamBackend.Services.RegisterService;
import com.example.cakeExamBackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    public UserRepo userRepo;

    @Autowired
    public RegisterService registerService;

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody UserModel userEntity){ //Regisztrálásért felelős végpont.
        String userName = userEntity.getUserName();
        String password = userEntity.getUserPassword();

        UserModel user = userService.registerUser(userName, password);
        return userRepo.save(user);
    }
}
