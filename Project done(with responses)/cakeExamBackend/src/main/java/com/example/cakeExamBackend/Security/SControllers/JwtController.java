package com.example.cakeExamBackend.Security.SControllers;

import com.example.cakeExamBackend.Models.JwtRequest;
import com.example.cakeExamBackend.Models.JwtResponse;
import com.example.cakeExamBackend.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return jwtService.createJwtToken(jwtRequest);
    }
}
