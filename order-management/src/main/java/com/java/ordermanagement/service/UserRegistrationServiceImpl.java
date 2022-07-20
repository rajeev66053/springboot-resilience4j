package com.java.ordermanagement.service;

import com.java.ordermanagement.dto.Seller;
import com.java.ordermanagement.service.resilience4j.UserRegistrationResilience4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationResilience4j userRegistrationResilience4j;

    public UserRegistrationServiceImpl(UserRegistrationResilience4j userRegistrationResilience4j) {
        this.userRegistrationResilience4j = userRegistrationResilience4j;
    }

    @Override
    public String registerSeller(Seller sellerDto) {
        String registerSeller = null;

        //for (int i = 0; i < 10000; i++) {
        long start = System.currentTimeMillis();

        registerSeller = userRegistrationResilience4j.registerSeller(sellerDto);

        logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
        // }
        //registerSeller = userRegistrationResilience4j.registerSeller(sellerDto);
        return registerSeller;
    }

    @Override
    public List<Seller> getSellersList() {
        return userRegistrationResilience4j.getSellersList();
    }
}