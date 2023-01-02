package com.example.cakeExamBackend.Controllers;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Repositories.CakeBasketRepo;
import com.example.cakeExamBackend.Repositories.UserRepo;
import com.example.cakeExamBackend.Services.BasketService;
import com.example.cakeExamBackend.Services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private CakeBasketRepo cakeBasketRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CakeService cakeService;

    @PostMapping("/addCakeIntoBasket")
    public CakeBasketModel addCake(@RequestBody CakeBasketModel cakeBasketModel,
                                   @RequestParam(value="cake_basket", required = false) Long cake_basket, @RequestParam(value = "user_cakes_in_basket") Long user_cakes_in_basket) {
        if (cake_basket != null) {
            String cake_img = cakeBasketModel.getCakeImg();
            String cake_main_ingredient = cakeBasketModel.getCakeMainIngredient();
            String cake_name = cakeBasketModel.getCakeName();
            Integer cake_price = cakeBasketModel.getCakePrice();
            Integer cake_quantity = cakeBasketModel.getCakePrice();
            Integer candles = cakeBasketModel.getCandle();
            Boolean placedOrder = cakeBasketModel.isPlacedOrder();
            String username = cakeBasketModel.getUserName();
            CakeBasketModel addmaCake = basketService.addCakeIntoBasket(cake_img, cake_main_ingredient,
                    cake_name, cake_price, cake_quantity,
                    cake_basket, user_cakes_in_basket, candles, placedOrder, username);
            return cakeBasketModel;
        }
        return null;
    }
    @GetMapping("/userBasket")
    public List<CakeBasketModel> getCakesInBasket(@RequestParam(value="user_cakes_in_basket")Long user_cakes_in_basket)
    {
        System.out.println(user_cakes_in_basket);
        return basketService.getCakesInBasket(user_cakes_in_basket);
    }
    @PutMapping("/setStatus")
    public CakeBasketModel cakeBasketModel(@RequestBody CakeBasketModel cakeBasketModel, @RequestParam(value="userId") Long userId){
        System.out.println("Tortanév: "+cakeBasketModel.getCakeName());
        System.out.println("Tortakép: "+cakeBasketModel.getCakeImg());
        System.out.println("Torta ár: "+cakeBasketModel.getCakePrice());
        System.out.println("Torta fő hozzávaló: "+cakeBasketModel.getCakeMainIngredient());
        System.out.println("Torta gyertyák: "+cakeBasketModel.getCandle());
        System.out.println("Torta mennyisége: "+cakeBasketModel.getCakeQuantity());
        System.out.println("Rendelés: "+cakeBasketModel.isPlacedOrder());
        System.out.println("Torta id: "+cakeBasketModel.getId());
        return cakeService.updateCake(cakeBasketModel, userId);
    }
    @PutMapping("/setQuantity")
    public CakeBasketModel updateCakeQuantity(@RequestBody CakeBasketModel cakeBasketModel, @RequestParam(value = "userId")Long userId){
        System.out.println("Tortanév: "+cakeBasketModel.getCakeName());
        System.out.println("Tortakép: "+cakeBasketModel.getCakeImg());
        System.out.println("Torta ár: "+cakeBasketModel.getCakePrice());
        System.out.println("Torta fő hozzávaló: "+cakeBasketModel.getCakeMainIngredient());
        System.out.println("Torta gyertyák: "+cakeBasketModel.getCandle());
        System.out.println("Torta mennyisége: "+cakeBasketModel.getCakeQuantity());
        System.out.println("Rendelés: "+cakeBasketModel.isPlacedOrder());
        System.out.println("Torta id: "+cakeBasketModel.getId());
        return cakeService.updateCakeQuantity(cakeBasketModel, userId);
    }
    @DeleteMapping("/deleteFromBasket")
    public void cakeBasketModel(@RequestParam(value="cakeId") Long cakeId){
         cakeService.deleteCake(cakeId);
    }
}
