package com.fss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fss.entities.Client;

import jakarta.transaction.Transactional;

public interface ClientRepository extends JpaRepository<Client, Long> {


	
}
