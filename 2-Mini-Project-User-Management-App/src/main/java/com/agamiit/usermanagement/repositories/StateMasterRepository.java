package com.agamiit.usermanagement.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agamiit.usermanagement.entites.StateMasterEntity;
@Repository
public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Serializable> {
	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
