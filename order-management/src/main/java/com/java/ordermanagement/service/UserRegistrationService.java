package com.java.ordermanagement.service;

import com.java.ordermanagement.dto.Seller;

import java.util.List;

public interface UserRegistrationService {
    String registerSeller(Seller sellerDto);

    List<Seller> getSellersList();
}