package com.example.cakeExamBackend.Repositories;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CakeBasketRepo extends JpaRepository<CakeBasketModel, Long> {

    @Query(value = "SELECT * FROM cake_basket_model WHERE cake_basket = :cake_basket AND user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    CakeBasketModel findByCakeModelId(@Param(value="cake_basket")
                                      Long cake_basket, @Param(value="user_cakes_in_basket") Long user_cakes_in_basket);

    @Query(value = "SELECT * FROM cake_basket_model WHERE cake_basket = :cake_basket AND user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    CakeBasketModel findByCakeModel_Id(@Param(value="cake_basket")
                                       Long cake_basket, @Param(value="user_cakes_in_basket") Long user_cakes_in_basket);

    @Query(value = "SELECT * FROM cake_basket_model WHERE id = :id AND user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    CakeBasketModel findById(@Param(value="id")
                             Long id, @Param(value="user_cakes_in_basket") Long user_cakes_in_basket);

    @Query(value = "SELECT * FROM cake_basket_model WHERE user_cakes_in_basket = :user_cakes_in_basket", nativeQuery = true)
    List<CakeBasketModel> findAllById(@Param(value="user_cakes_in_basket") Long userId);

    @Query(value = "SELECT * FROM cake_basket_model WHERE user_name = :user_name", nativeQuery = true)
    List<CakeBasketModel> findAllByUserName(@Param(value="user_name") String userName);
}
