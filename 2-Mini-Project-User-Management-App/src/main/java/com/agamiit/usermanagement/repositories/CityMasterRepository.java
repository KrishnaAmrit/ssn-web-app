package com.agamiit.usermanagement.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agamiit.usermanagement.entites.CityMasterEntity;
@Repository
public interface CityMasterRepository extends JpaRepository<CityMasterEntity, Serializable> {
	public List<CityMasterEntity> findByStateId(Integer stateId);

}
