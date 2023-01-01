package com.example.cakeExamBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier", unique = true)
    private Long id;

    private String userName;

    private String userPassword;

    private String authorities;

    @OneToMany
    @JsonBackReference
    @JoinColumn(name="user_cakes_in_basket")
    private List<CakeBasketModel> cakeBasketModel;

    @JoinColumn(name="user_id")
    @JsonManagedReference
    @OneToMany
    private List<OrderDetails> orderDetails;
}
//Felhasználó model adatbázisban
