package com.example.cakeExamBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CakeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cakeName;

    private String mainIngredient;

    private int price;

    private String imageUrl;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name="cake_basket")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)//For dodging infinite recursion.
    private List<CakeBasketModel> cakeBasketModels;

    public CakeModel(Long id, List<CakeBasketModel> cakeBasketModels) {
        this.id = id;
        this.cakeBasketModels = cakeBasketModels;
    }

    public CakeModel(Long id) {
        this.id = id;
    }

    public CakeModel(List<CakeBasketModel> cakeBasketModels) {
        this.cakeBasketModels = cakeBasketModels;
    }

    public CakeModel() {
    }
}
