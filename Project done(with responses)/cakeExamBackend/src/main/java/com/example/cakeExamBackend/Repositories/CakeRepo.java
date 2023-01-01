package com.example.cakeExamBackend.Repositories;

import com.example.cakeExamBackend.Models.CakeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepo extends JpaRepository<CakeModel, Long> { //ORM, Adatbázis parancsokhoz.
}
