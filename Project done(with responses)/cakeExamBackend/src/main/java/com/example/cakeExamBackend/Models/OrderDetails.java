package com.example.cakeExamBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; /*Ez alapján rendelés lekövetése, milyen torta, mennyi, stb*/


    /*Rendelést leadó felhasználó*/
    private String firstName;
    private String lastName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String city;
    private String address;
    private String userName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private UserModel userModel;
}
