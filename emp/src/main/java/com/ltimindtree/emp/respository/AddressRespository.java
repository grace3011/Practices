package com.ltimindtree.emp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.emp.entity.Address;

@Repository
public interface AddressRespository extends JpaRepository<Address ,Long> {
    
}
