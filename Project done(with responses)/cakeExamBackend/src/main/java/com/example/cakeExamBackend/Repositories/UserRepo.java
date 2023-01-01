package com.example.cakeExamBackend.Repositories;

import com.example.cakeExamBackend.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long> { //ORM, Adatbázis parancsokhoz.
    Optional<UserModel> findByuserName(String userName);

}
