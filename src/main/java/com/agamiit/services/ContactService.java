package com.agamiit.services;

import java.util.List;

import com.agamiit.entity.ContactEntity;

public interface ContactService {
	
	public boolean saveContact(ContactEntity contactEntity);
	public List<ContactEntity> getAllContactId();
	public ContactEntity getContactById(Integer contactId);
	public boolean deleteContactById(Integer contactId);

}
