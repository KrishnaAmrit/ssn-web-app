package com.agamiit.usermanagement.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agamiit.usermanagement.entites.CountryMasterEntity;
@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMasterEntity, Serializable> {
	
}
