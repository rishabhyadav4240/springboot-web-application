package com.demoorg1.demowebapp1.repository;

import com.demoorg1.demowebapp1.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
