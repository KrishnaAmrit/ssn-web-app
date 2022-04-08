package com.agamiit.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.agamiit.entity.ContactEntity;
import com.agamiit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(ContactEntity contactEntity) {
		contactEntity.setActivieSW("Y");
		ContactEntity save = contactRepo.save(contactEntity);
		if (save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<ContactEntity> getAllContactId() {
		ContactEntity contactEntity=new ContactEntity();
		contactEntity.setActivieSW("Y");
		return contactRepo.findByActivieSW("Y");
	}

	@Override
	public ContactEntity getContactById(Integer contactId) {
		Optional<ContactEntity> findByID=contactRepo.findById(contactId);
		if (findByID.isPresent()) {
			return findByID.get();
			
		}
		return null;
	}
	
		

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<ContactEntity> findByID=contactRepo.findById(contactId);
		if (findByID.isPresent()) {
            ContactEntity contactEntity=findByID.get();
            contactEntity.setActivieSW("N");
            contactRepo.save(contactEntity);
            return true;
		}
		return false;
	}
}
