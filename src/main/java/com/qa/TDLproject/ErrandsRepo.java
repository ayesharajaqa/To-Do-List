package com.qa.TDLproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

@Repository
public interface ErrandsRepo extends JpaRepository<ErrandsDomain,Long> {

} 

