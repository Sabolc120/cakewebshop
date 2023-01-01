package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BasketService {
    CakeBasketModel addCakeIntoBasket(String cake_img, String cake_main_ingredient, String cake_name,
                                      Integer cake_price, Integer cake_quantity, Long cake_id, Long user_cakes_in_basket,
                                      Integer candles, Boolean orderPlaced, String userName);

    List<CakeBasketModel> getCakesInBasket(Long user_cakes_in_basket);


}
