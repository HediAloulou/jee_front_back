package com.fss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fss.entities.*;
import com.fss.services.*;


@RestController
@RequestMapping(path = "/banque_compte")
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {
	@Autowired
	CompteService compteservice;
	
	@GetMapping("/nbcomptes")
	  public String nbClients()
	  {
		  return compteservice.nbComptes();
		  
	  }
	@GetMapping("/comptes")
	  List<CompteBancaire> AfficherComptes()
	  {

		  return compteservice.AfficherComptes();
	  }
	  
	@GetMapping("/solde")
	  String Affichersolde(Long id)
	  {

		  return compteservice.Consultation_solde(id);
	  }
	  
	  
	
	

}
