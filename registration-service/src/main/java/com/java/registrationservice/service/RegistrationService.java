package com.java.registrationservice.service;

import com.java.registrationservice.dto.Seller;

import java.util.List;

public interface RegistrationService {
    String addSeller(Seller seller);

    List<Seller> getSellersList();
}