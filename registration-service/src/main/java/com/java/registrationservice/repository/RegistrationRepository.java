package com.java.registrationservice.repository;

import com.java.registrationservice.dto.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistrationRepository {

    List<Seller> sellerDtoList = new ArrayList<>();

    public boolean addSeller(Seller sellerDto) {

        return sellerDtoList.add(sellerDto);
    }

    public List<Seller> getSellerList() {
        return sellerDtoList;
    }
}