package com.example.cakeExamBackend.Repositories;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

}
