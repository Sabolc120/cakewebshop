package com.example.cakeExamBackend.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CakeBasketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cakeName;

    private String cakeImg;

    private String cakeMainIngredient;

    private int cakePrice;

    private int cakeQuantity;

    private int candle;

    private boolean placedOrder;

    private String userName;

    @ManyToOne
    //StackOverFlow: null
    @JoinColumn(name = "cake_basket")
    private CakeModel cakeModel;

    @ManyToOne
    @JoinColumn(name="user_cakes_in_basket")
    private UserModel userModel;

    public CakeBasketModel() {

    }
}
