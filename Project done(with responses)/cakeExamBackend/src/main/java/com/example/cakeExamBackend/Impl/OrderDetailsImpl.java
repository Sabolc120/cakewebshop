package com.example.cakeExamBackend.Impl;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.OrderDetails;
import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.CakeBasketRepo;
import com.example.cakeExamBackend.Repositories.OrderDetailsRepo;
import com.example.cakeExamBackend.Repositories.UserRepo;
import com.example.cakeExamBackend.Services.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailsImpl implements OrderDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private CakeBasketRepo cakeBasketRepo;
    @Override
    public OrderDetails completeOrderPost(
                                          Long userId, String firstName, String lastName, String customerPhoneNumber, String customerEmail, String city,
                                          String address, String userName) {
        OrderDetails orderDetails = new OrderDetails();
        UserModel userModel = userRepo.findById(userId).orElse(null);
        orderDetails.setCustomerPhoneNumber(customerPhoneNumber);
        orderDetails.setCustomerEmail(customerEmail);
        orderDetails.setFirstName(firstName);
        orderDetails.setLastName(lastName);
        orderDetails.setUserModel(userModel);
        orderDetails.setCity("Szeged");
        orderDetails.setAddress(address);
        orderDetails.setUserName(userName);
        return orderDetailsRepo.save(orderDetails);

    }

    @Override
    public List<OrderDetails> getOrders() {
        return orderDetailsRepo.findAll();
    }

    @Override
    public List<CakeBasketModel> getOrders(String userName) {
        return cakeBasketRepo.findAllByUserName(userName);
    }
    @Override
    public void deleteById(Long orderId){
        orderDetailsRepo.deleteById(orderId);
    }
}
