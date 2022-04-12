package com.agamiit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agamiit.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
	public List<Contact> findByActivieSW(String sw);
	

}
