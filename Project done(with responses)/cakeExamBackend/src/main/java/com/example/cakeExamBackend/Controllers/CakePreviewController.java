package com.example.cakeExamBackend.Controllers;

import com.example.cakeExamBackend.Models.CakeModel;
import com.example.cakeExamBackend.Repositories.CakeRepo;
import com.example.cakeExamBackend.Security.SImplementations.UserDetailsImpl;
import com.example.cakeExamBackend.Services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class CakePreviewController {

    @Autowired
    private CakeRepo cakeRepo;

    @Autowired
    private CakeService cakeService;

    //Működő megoldás.
    @GetMapping("/getCake{id}")
    public Optional<CakeModel> getCake(@RequestParam(name="id") Long id){
        return cakeService.getCakesService(id);
    }
}
