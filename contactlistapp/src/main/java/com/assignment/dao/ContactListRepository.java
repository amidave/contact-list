package com.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.Contact;

@Repository
public interface ContactListRepository extends JpaRepository<Contact, Integer>{

	//search query based search
	public List<Contact> findByNameContaining(String name);
	
}
