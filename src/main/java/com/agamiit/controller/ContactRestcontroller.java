package com.agamiit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agamiit.constrant.AppConstrant;
import com.agamiit.entity.Contact;
import com.agamiit.propes.AppProperties;
import com.agamiit.services.ContactServiceImpl;

@RestController
//@RequestMapping(value = "/contact")
@CrossOrigin
public class ContactRestcontroller {
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	@Autowired
	private AppProperties appPropes;

	@PostMapping(value = "/contact")
	public String SaveContact(@RequestBody Contact contactEntity) {
		Boolean status = contactServiceImpl.saveContact(contactEntity);
 
		Map<String ,String> messages=appPropes.getMessages();
		if (status) {
			return messages.get(AppConstrant.CONTACT_SAVE_SUCC);
		}
		return messages.get(AppConstrant.CONTACT_SAVE_FAIL);
	}

	@GetMapping(value = "/contacts")
	public List<Contact> getAllContact() {

		return contactServiceImpl.getAllContactId();
	}

	@GetMapping(value = "/contact/{cid}")
	public Contact ContactByContactId(@PathVariable("cid") Integer ContactId) {
		return contactServiceImpl.getContactById(ContactId);

	}

	@DeleteMapping(value = "/contact/{cid}")
	public String deleteContact(@PathVariable("cid") Integer contactId) {
		boolean status = contactServiceImpl.deleteContactById(contactId);
		Map<String ,String> messages=appPropes.getMessages();
		if (status) {
			return messages.get(AppConstrant.CONTACT_DELETE_SUCC);
		} else {
			return messages.get(AppConstrant.CONTACT_DELETE_FAIL);
		}

	}

}
