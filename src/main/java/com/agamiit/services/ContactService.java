package com.agamiit.services;

import java.util.List;

import com.agamiit.entity.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contactEntity);
	public List<Contact> getAllContactId();
	public Contact getContactById(Integer contactId);
	public boolean deleteContactById(Integer contactId);

}
