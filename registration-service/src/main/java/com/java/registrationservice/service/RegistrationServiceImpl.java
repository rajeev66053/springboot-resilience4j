package com.java.registrationservice.service;

import com.java.registrationservice.dto.Seller;
import com.java.registrationservice.repository.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public String addSeller(@RequestBody Seller seller) {

        if (seller.getEmailId() == null || seller.getEmailId().isEmpty()) {
            logger.error("email id which is mandatory field is null/empty");
            throw new RuntimeException("Seller mail id is not valid. Please enter valid Id");
        }
        seller.setId(getSellersList().size() + 1);
        boolean isSellerAdded = registrationRepository.addSeller(seller);
        String message;
        if (isSellerAdded) {
            message = "Registration successful. Your registration id is - '" + seller.getId() + "'\n Save it for future communication with us.";

        } else {
            message = "There was some problem in registering the seller. Please try after some time!!";

        }
        logger.info("Add seller status - {} and message - {}", isSellerAdded, message);
        return message;
    }

    @Override
    public List<Seller> getSellersList() {

        List<Seller> sellerList = registrationRepository.getSellerList();
        logger.info("fetching seller list. Total sellers - {}", sellerList.size());
        return sellerList;
    }
}