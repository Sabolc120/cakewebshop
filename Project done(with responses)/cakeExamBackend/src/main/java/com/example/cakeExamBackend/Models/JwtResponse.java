package com.example.cakeExamBackend.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private UserModel userModel;
    private String jwtToken;

    public JwtResponse(UserModel userModel, String jwtToken) {
        this.userModel = userModel;
        this.jwtToken = jwtToken;
    }
}
