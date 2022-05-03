package com.agamiit.usermanagement.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agamiit.usermanagement.entites.UserAccountEntity;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable> {
	public UserAccountEntity findByEmailAndPassWord(String email,String password);
	public UserAccountEntity findByEmail(String emailID);

}
