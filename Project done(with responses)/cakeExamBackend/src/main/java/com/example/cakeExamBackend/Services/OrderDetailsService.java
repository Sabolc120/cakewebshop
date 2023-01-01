package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {

    OrderDetails completeOrderPost(
                                   Long userId, String firstName, String lastName, String customerPhoneNumber, String customerEmail,
                                   String city, String address, String userName);
    List<OrderDetails> getOrders(); /*<--- findAll, admin az összeset fogja látni.*/

    List<CakeBasketModel> getOrders(String userEmail);

    void deleteById(Long orderId);

}
