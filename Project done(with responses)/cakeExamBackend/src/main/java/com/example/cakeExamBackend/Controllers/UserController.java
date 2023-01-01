package com.example.cakeExamBackend.Controllers;

import com.example.cakeExamBackend.Security.SImplementations.UserDetailsImpl;
import com.example.cakeExamBackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*@PostConstruct
    public void initRoleAndUser() {
        userService.initRolesAndUser();
    }*/
}
