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
       /*Testing site String cake_img_test = cakeBasketModel.getCakeImg();
        String cake_main_ingredient_test = cakeBasketModel.getCakeMainIngredient();
        String cake_name_test = cakeBasketModel.getCakeName();
        Integer cake_price_test = cakeBasketModel.getCakePrice();
        Integer cake_quantity_test = cakeBasketModel.getCakeQuantity();
        System.out.println("Torta kép: "+cake_img_test);
        System.out.println("Torta fő hozzávaló: "+cake_main_ingredient_test);
        System.out.println("Torta neve: "+cake_name_test);
        System.out.println("Torta ára: "+cake_price_test);
        System.out.println("Torta mennyisége: "+cake_quantity_test);
        System.out.println("Torta id: "+cake_basket);
        System.out.println("Felhasználó id: "+user_cakes_in_basket);
        System.out.println("Torta mennyiségének tipusa: "+cake_quantity_test.getClass());*/
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
    /*@PostMapping("/addCakeIntoBasket")
    public CakeBasketModel postCakeIntoBasket(@RequestParam(value = "cakeName", required = false) String cakeName,
                                          @RequestParam("cake_img") String cake_img,
                                          @RequestParam("cake_price") Integer cake_price,
                                          @RequestParam("cake_quantity") Integer cake_quantity,
                                          @RequestParam("cake_main_ingredient") String cake_main_ingredient,
                                          @RequestParam(value = "cake_basket", required = false) Long cake_id,
                                          @RequestParam(value = "user_cakes_in_basket", required = false) Long user_id) {

        System.out.println(cake_id);
        System.out.println(cakeName);
        return basketService.addCakeIntoBasket(cakeName,cake_img,cake_main_ingredient,cake_price,cake_quantity,cake_id,user_id);
    }*/
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
