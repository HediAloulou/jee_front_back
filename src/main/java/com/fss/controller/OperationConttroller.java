package com.fss.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fss.entities.CompteBancaire;
import com.fss.entities.Operation;
import com.fss.services.CompteService;
import com.fss.services.OperationService;

@RestController
@RequestMapping(path = "/banque_operation")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationConttroller {
	@Autowired
	OperationService operationservice;
	@GetMapping("/operations")
	 public ArrayList<Operation> AfficherComptes()
	  {

		  return (ArrayList<Operation>) operationservice.AfficherOperations();
	  }
	
}
