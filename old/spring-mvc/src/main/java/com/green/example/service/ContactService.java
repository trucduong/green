package com.green.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.green.example.dao.ContactDao;
import com.green.example.entity.Contact;
import com.green.example.model.ContactModel;

import utils.Constants;

@Service
@Transactional
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
//	@Autowired
//	private EmailContactDao emailContactDao;
	
//	@Autowired
//	private PhoneContactDao phoneContactDao;

	public List<Contact> search(String name) {
		if (name == null || name.length() == 0) {
			return contactDao.findAll();
		}

		return contactDao.findByName(name);
	}

	public Contact create(ContactModel contactModel) {
		
		Contact contact = new Contact();
		//contact.setName(contactModel.getName());
		//.....
		contactModel.toContact(contact);
		String fileName = saveContactAvatar(contactModel.getAvatarFile(), contactModel.getAvatar());
		contact.setAvatar(fileName);
		
		Contact result = contactDao.create(contact);
		return result;
	}
	
	public Contact find(long id) {
		return contactDao.find(id);
	}
	
	public Contact update(ContactModel contactModel) {
		
		Contact contact = contactDao.find(contactModel.getId());
		//contact.setName(contactModel.getName());
		//.....
		contactModel.toContact(contact);
		String fileName = saveContactAvatar(contactModel.getAvatarFile(), contactModel.getAvatar());
		contact.setAvatar(fileName);
		
		Contact result = contactDao.update(contact);
		return result;
	}
	
	public void delete(long contactId) {
		// delete email contact
		
		// delete phone contact
		
		// delete contact
	}
	
	private String saveContactAvatar(MultipartFile file, String defaultAvatar) {
    	if (file != null) {
			try {
				byte[] bytes = file.getBytes();
				String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
	             Path path = Paths.get(Constants.UPLOAD_FOLDER  + "/" + fileName );
	             Files.write(path, bytes);
	             
	             return fileName;
	             
			} catch (IOException e) {
				// TODO logging
				return defaultAvatar;
			}
		} else {
			return defaultAvatar;
		}
    }
}
