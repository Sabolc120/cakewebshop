package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.CakeBasketModel;
import com.example.cakeExamBackend.Models.CakeModel;
import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.CakeBasketRepo;
import com.example.cakeExamBackend.Repositories.CakeRepo;
import com.example.cakeExamBackend.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class CakeService {

    @Autowired
    private CakeRepo cakeRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CakeBasketRepo cakeBasketRepo;

    public Optional<CakeModel> getCakesService(Long id){
        return cakeRepo.findById(id);
    }
    public CakeBasketModel updateCake(CakeBasketModel cakeBasketModel, Long userId){
        Long cakeId = cakeBasketModel.getId();
        CakeBasketModel cakeBasketModel1 = cakeBasketRepo.findByCakeModelId(cakeId, userId); // NULL returned
        cakeBasketModel1.setCakeMainIngredient(cakeBasketModel.getCakeMainIngredient());
        cakeBasketModel1.setCakeImg(cakeBasketModel.getCakeImg());
        cakeBasketModel1.setCakeName(cakeBasketModel.getCakeName());
        cakeBasketModel1.setCakePrice(cakeBasketModel.getCakePrice());
        cakeBasketModel1.setCakeQuantity(cakeBasketModel1.getCakeQuantity());
        cakeBasketModel1.setCandle(cakeBasketModel.getCandle());
        cakeBasketModel1.setPlacedOrder(cakeBasketModel.isPlacedOrder());
        return cakeBasketRepo.save(cakeBasketModel1);
    }
    public CakeBasketModel updateCakeQuantity(CakeBasketModel cakeBasketModel, Long userId){
        Long cakeId = cakeBasketModel.getId();
        CakeBasketModel cakeBasketModel1 = cakeBasketRepo.findById(cakeId, userId);
        cakeBasketModel1.setCakeImg(cakeBasketModel.getCakeImg());
        cakeBasketModel1.setCakeName(cakeBasketModel.getCakeName());
        cakeBasketModel1.setCakePrice(cakeBasketModel.getCakePrice());
        cakeBasketModel1.setCakeQuantity(cakeBasketModel.getCakeQuantity());
        cakeBasketModel1.setCandle(cakeBasketModel.getCandle());
        cakeBasketModel1.setPlacedOrder(cakeBasketModel.isPlacedOrder());
        return cakeBasketRepo.save(cakeBasketModel1);
    }
    public void deleteCake(Long cakeId){
        cakeBasketRepo.deleteById(cakeId);
    }
}
