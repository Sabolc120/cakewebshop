package com.example.cakeExamBackend.Impl;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.CakeModel;
import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.CakeBasketRepo;
import com.example.cakeExamBackend.Repositories.CakeRepo;
import com.example.cakeExamBackend.Repositories.Dao.basketDao;
import com.example.cakeExamBackend.Repositories.UserRepo;
import com.example.cakeExamBackend.Services.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private com.example.cakeExamBackend.Repositories.Dao.basketDao basketDao;

    @Autowired
    private CakeRepo cakeRepo;
    @Override
    public CakeBasketModel addCakeIntoBasket(String cake_img, String cake_main_ingredient, String cake_name,
                                             Integer cake_price, Integer cake_quantity, Long cake_id, Long user_id,
                                             Integer candle, Boolean placedOrder, String userName) {
        CakeBasketModel cakeBasketModel = new CakeBasketModel();
        CakeModel cakeModel = cakeRepo.findById(cake_id).orElse(null);
        UserModel userModel = userRepo.findById(user_id).orElse(null);
        cakeBasketModel.setCakeImg(cake_img);
        cakeBasketModel.setCakeQuantity(1);
        cakeBasketModel.setCakePrice(cake_price);
        cakeBasketModel.setCakeMainIngredient(cake_main_ingredient);
        cakeBasketModel.setUserModel(userModel);
        cakeBasketModel.setCakeModel(cakeModel);
        cakeBasketModel.setCakeName(cake_name);
        cakeBasketModel.setPlacedOrder(false);
        cakeBasketModel.setCandle(candle);
        cakeBasketModel.setUserName(userName);
        return basketDao.save(cakeBasketModel);
    }

    @Override
    public List<CakeBasketModel> getCakesInBasket(Long user_cakes_in_basket) {
        return basketDao.findCakesInBasket(user_cakes_in_basket);
    }
}
