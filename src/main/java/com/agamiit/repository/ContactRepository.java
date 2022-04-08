package com.agamiit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agamiit.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity,Integer> {
	public List<ContactEntity> findByActivieSW(String sw);
	

}
