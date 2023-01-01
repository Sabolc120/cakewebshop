package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.UserModel;

public interface RegisterService {
    UserModel registerUser(String userName, String userPassword);
}
