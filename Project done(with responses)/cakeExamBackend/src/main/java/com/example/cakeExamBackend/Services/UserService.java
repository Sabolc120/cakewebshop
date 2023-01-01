package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    public UserModel register(UserModel userModel){
        passwordEncoder.encode(userModel.getUserPassword());
        return userRepo.save(userModel);
    }
    //DEFAULT ADMIN USER
    public void initRolesAndUser(){

        UserModel adminUser = new UserModel();
        adminUser.setId(1L);
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setAuthorities("ADMIN");
        userRepo.save(adminUser);
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public UserModel registerUser(String userName, String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setUserPassword(passwordEncoder.encode(password));
        user.setAuthorities("USER");
        return user;
    }
}
