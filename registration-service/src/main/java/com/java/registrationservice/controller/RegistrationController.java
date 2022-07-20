package com.java.registrationservice.controller;

import com.java.registrationservice.dto.Seller;
import com.java.registrationservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody Seller seller){
        return registrationService.addSeller(seller);
    }

    @GetMapping("/sellersList")
    public List<Seller> getSellersList() {
        return registrationService.getSellersList();
    }
}