package com.demoorg1.demowebapp1.service;

import com.demoorg1.demowebapp1.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllAddress();

    Address findAddressById(Long id);
}
