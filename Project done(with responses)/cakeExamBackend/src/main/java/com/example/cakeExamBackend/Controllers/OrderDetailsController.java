package com.example.cakeExamBackend.Controllers;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.OrderDetails;
import com.example.cakeExamBackend.Services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/orderPut")
    public OrderDetails orderDetails(@RequestBody OrderDetails orderDetails, @RequestParam(value="userId") Long userId){
        if(userId!= null){
            String firstName = orderDetails.getFirstName();
            String lastName = orderDetails.getLastName();
            String customerPhoneNumber = orderDetails.getCustomerPhoneNumber();
            String customerEmail = orderDetails.getCustomerEmail();
            String city = orderDetails.getCity();
            String address = orderDetails.getAddress();
            String userName = orderDetails.getUserName();
            System.out.println(userName);
            OrderDetails orderDetails1 = orderDetailsService.completeOrderPost(
                    userId, firstName, lastName, customerPhoneNumber, customerEmail, city, address, userName);

            return orderDetails1;
        }
        return null;
    }
    @GetMapping("/getOrders")
    public List<OrderDetails> orderDetails(){
        return orderDetailsService.getOrders();
    }
    @GetMapping("/checkOrders")
    public List<CakeBasketModel> getOrder(@RequestParam(value="userName") String userName){
        System.out.println("Username: "+userName);
        return orderDetailsService.getOrders(userName); //Át kell passzolni a userNamet
    }
    @DeleteMapping("/deleteFromOrders")
    public void orderDetails(@RequestParam(value="orderId") Long orderId){
        orderDetailsService.deleteById(orderId);
    }
}
