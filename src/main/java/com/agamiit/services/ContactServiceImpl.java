package com.agamiit.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.agamiit.entity.Contact;
import com.agamiit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contactEntity) {
		contactEntity.setActivieSW("Y");
		Contact save = contactRepo.save(contactEntity);
		if (save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContactId() {
		Contact contactEntity=new Contact();
		contactEntity.setActivieSW("Y");
		return contactRepo.findByActivieSW("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findByID=contactRepo.findById(contactId);
		if (findByID.isPresent()) {
			return findByID.get();
			
		}
		return null;
	}
	
		

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact> findByID=contactRepo.findById(contactId);
		if (findByID.isPresent()) {
            Contact contactEntity=findByID.get();
            contactEntity.setActivieSW("N");
            contactRepo.save(contactEntity);
            return true;
		}
		return false;
	}
}
