package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assignment.dao.ContactListRepository;
import com.assignment.entities.Contact;

@Service
public class ContactListService {
	
	@Autowired
	ContactListRepository repository;
	
	public Page<Contact> getContacts(Integer page){
		Pageable paging = PageRequest.of(page, 30);
		Page<Contact> pageResult = repository.findAll(paging);
		return pageResult;
	}

	public List<Contact> search(String query) {
		return repository.findByNameContaining(query);
	}
}
