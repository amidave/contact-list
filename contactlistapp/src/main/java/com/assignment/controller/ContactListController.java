package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.entities.Contact;
import com.assignment.service.ContactListService;

@Controller
public class ContactListController {
	
	@Autowired
	ContactListService service;
	
	@RequestMapping(value = {"/contacts/","/contacts/{page}"})
	public String showContacts(@PathVariable("page") Optional<Integer> page,Model m){
		Integer pageNo=0;
		if(page.isPresent()){
			pageNo = page.get();
		}
		
		Page<Contact> pageResult = service.getContacts(pageNo);
		List<Contact> contacts = pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
		
		m.addAttribute("contacts", contacts);
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("totalPages", pageResult.getTotalPages());
		return "contact_list";
	}
	
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query){
		System.out.println(query);
		List<Contact> contactList = service.search(query);
		return ResponseEntity.ok(contactList);
	}
	
}
