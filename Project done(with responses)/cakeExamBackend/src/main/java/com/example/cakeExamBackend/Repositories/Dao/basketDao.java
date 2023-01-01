package com.example.cakeExamBackend.Repositories.Dao;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface basketDao extends JpaRepository<CakeBasketModel, Long> {

    @Query(value = "insert into cake_basket_model cake_img = :cake_img, cake_main_ingredient = :cake_main_ingredient," +
            "cake_name = :cake_name, cake_price = :cake_price, cake_quantity = :cake_quantity, cake_basket = :cake_basket," +
            "user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    CakeBasketModel addCakeIntoBasket(@Param(value="cake_img")String cake_img, @Param(value="cake_main_ingredient")String cake_main_ingredient,
                                      @Param(value="cake_name")String cake_name, @Param(value="cake_price")Integer cake_price,
                                      @Param(value="cake_quantity")Integer cake_quantity, @Param(value="cake_basket")Long cakeId,
                                      @Param(value="user_cakes_in_basket")Long userId);

    @Query(value = "SELECT * FROM cake_basket_model WHERE user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    List<CakeBasketModel> findCakesInBasket(@Param(value="user_cakes_in_basket") Long user_cakes_in_basket);
}
